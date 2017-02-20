package com.wyc.draw.web.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.Account;
import com.wyc.common.domain.vo.ResultPageListVo;
import com.wyc.common.service.AccountService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.DrawRoom;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.VieRedPacketProblem;
import com.wyc.draw.domain.VieRedPacketTakepartMember;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.GetRedPacketProblemFilter;
import com.wyc.draw.filter.GetRedPacketProblemListFilter;
import com.wyc.draw.filter.GetVieRedPackInfoFilter;
import com.wyc.draw.filter.GetVieRedPacketResultFilter;
import com.wyc.draw.service.DrawRoomService;
import com.wyc.draw.service.VieRedPacketProblemService;
import com.wyc.draw.service.VieRedPacketTakepartMemberService;
import com.wyc.draw.vo.RedPacketVo;
import com.wyc.draw.vo.VieProblemAnswerListVo;
import com.wyc.draw.vo.VieRedPacketProblemListVo;
import com.wyc.draw.vo.VieRedPacketProblemVo;
import com.wyc.draw.vo.VieRedPacketTakepartMemberVo;

@Controller
@RequestMapping(value="/view/vie/draw/vie_draw")
public class VieDrawController {
	
	@Autowired
	private DrawRoomService drawRoomService;
	
	@Autowired
	private VieRedPacketProblemService vieRedPacketProblemService;

	
	@Autowired
	private VieRedPacketTakepartMemberService vieRedPacketTakepartMemberService;
	
	@Autowired
	private AccountService accountService;
	
	@Transactional
	@HandlerAnnotation(hanlerFilter=GetVieRedPackInfoFilter.class)
	@RequestMapping(value="info")
	public String info(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		RedPacketVo redPacketVo = (RedPacketVo)sessionManager.getObject(RedPacketVo.class);
		
		httpServletRequest.setAttribute("redPacketInfo", redPacketVo);
		
		
		VieRedPacketTakepartMemberVo thisMember = (VieRedPacketTakepartMemberVo)sessionManager.getObject(VieRedPacketTakepartMemberVo.class);
		
		
		
		ResultPageListVo resultPageListVo = (ResultPageListVo)sessionManager.getObject(ResultPageListVo.class);

		httpServletRequest.setAttribute("takePartMembers", resultPageListVo);
		
		
		List<VieRedPacketTakepartMember> vieRedPacketTakepartMembers = vieRedPacketTakepartMemberService.findAllByRedPacketIdAndIsComplete(redPacketVo.getId(),0);
		if(vieRedPacketTakepartMembers!=null&&vieRedPacketTakepartMembers.size()>0){
			VieRedPacketTakepartMember vieRedPacketTakepartMember = vieRedPacketTakepartMembers.get(0);
			if(CommonUtil.isEmpty(vieRedPacketTakepartMember.getCurrentProblemId())){
				VieRedPacketProblem firstRedPacketProblem = vieRedPacketProblemService.findOneByRedPacketIdAndIsFirst(redPacketVo.getId(),1);
				
				
				return "redirect:vie_answer_problem?member_id="+vieRedPacketTakepartMember.getId()+"&red_packet_id="+redPacketVo.getId()+"&current_seq="+firstRedPacketProblem.getSeq();
			}
			VieRedPacketProblem vieRedPacketProblem = vieRedPacketProblemService.findOne(vieRedPacketTakepartMember.getCurrentProblemId());
			VieRedPacketProblem lastRedPacketProblem = vieRedPacketProblemService.getLastByRedPacketId(redPacketVo.getId());
			if(lastRedPacketProblem.getSeq()>vieRedPacketProblem.getSeq()){
				int currentSeq = vieRedPacketProblem.getSeq()+1;
				VieRedPacketProblem currentVieRedPacketProblem = vieRedPacketProblemService.findOneByRedPacketIdAndSeq(redPacketVo.getId(),currentSeq);
				return "redirect:vie_answer_problem?member_id="+vieRedPacketTakepartMember.getId()+"&red_packet_id="+redPacketVo.getId()+"&current_seq="+currentVieRedPacketProblem.getSeq();
			}else{
				vieRedPacketTakepartMember.setIsComplete(1);
				vieRedPacketTakepartMemberService.update(vieRedPacketTakepartMember);
			}
			
		}else{
			//List<VieRedPacketProblem> firstVieRedPacketProblems = vieRedPacketProblemService.findFirstByRedPacketId(redPacketVo.getId());
			//httpServletRequest.setAttribute("currentProblem", firstVieRedPacketProblems.get(0));
		}
		
		
		if(thisMember==null&&redPacketVo.getIsAnswer()==1){
			VieRedPacketTakepartMember vieRedPacketTakepartMember = vieRedPacketTakepartMemberService.findByRedPacketIdAndDrawUserId(redPacketVo.getId(), drawUser.getId());
			if(vieRedPacketTakepartMember!=null)
			thisMember = new VieRedPacketTakepartMemberVo();
			thisMember.setCurrentProblemId(vieRedPacketTakepartMember.getCurrentProblemId());
			thisMember.setDrawUserId(vieRedPacketTakepartMember.getDrawUserId());
			thisMember.setHeadImg(vieRedPacketTakepartMember.getHeadImg());
			thisMember.setId(vieRedPacketTakepartMember.getId());
			thisMember.setIsBest(vieRedPacketTakepartMember.getIsBest());
			thisMember.setIsComplete(vieRedPacketTakepartMember.getIsComplete());
			thisMember.setIsPay(vieRedPacketTakepartMember.getIsPay());
			thisMember.setNickname(vieRedPacketTakepartMember.getNickname());
			thisMember.setOpendid(vieRedPacketTakepartMember.getOpendid());
			thisMember.setRedPacketId(vieRedPacketTakepartMember.getRedPacketId());
			thisMember.setRightCount(vieRedPacketTakepartMember.getRightCount());
			thisMember.setTimeLong(vieRedPacketTakepartMember.getTimeLong());
			thisMember.setUserId(vieRedPacketTakepartMember.getUserId());
			thisMember.setWrongCount(vieRedPacketTakepartMember.getWrongCount());
			thisMember.setTimeLong(vieRedPacketTakepartMember.getTimeLong());
		
		}
		//本用户的参与名额
		httpServletRequest.setAttribute("thisMember", thisMember);
		
		return "vie/vieRedPacket";
	}
	
	
	@HandlerAnnotation(hanlerFilter=GetRedPacketProblemFilter.class)
	@RequestMapping(value="vie_set_problem")
	public String vieSetProblem(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		VieRedPacketProblemVo vieRedPacketProblemVo = (VieRedPacketProblemVo)sessionManager.getObject(VieRedPacketProblemVo.class);
		httpServletRequest.setAttribute("redPacketProblem", vieRedPacketProblemVo);
		return "vie/vieSetProblem";
	}
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="add")
	public String add(HttpServletRequest httpServletRequest)throws Exception{
		
		String roomId = httpServletRequest.getParameter("room_id");
		
		String isRoom = httpServletRequest.getParameter("isRoom");
		String subjectId = httpServletRequest.getParameter("subjectId");
		httpServletRequest.setAttribute("roomId", roomId);
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		Account account = accountService.findOne(drawUser.getAccountId());
		httpServletRequest.setAttribute("amountBalance", account.getAmountBalance());
		List<DrawRoom> drawRooms = drawRoomService.findAllByDrawUserId(drawUser.getId());
	
		httpServletRequest.setAttribute("rooms",drawRooms);
		
		httpServletRequest.setAttribute("subjectId", subjectId);
		httpServletRequest.setAttribute("isRoom", isRoom);
		return "vie/addVieRedPacket";
	}
	
	@HandlerAnnotation(hanlerFilter=GetRedPacketProblemListFilter.class)
	@RequestMapping(value="vie_answer_problem")
	public String answer(HttpServletRequest httpServletRequest)throws Exception{
		
		String memberId = httpServletRequest.getParameter("member_id");
		
		String redPacketId = httpServletRequest.getParameter("red_packet_id");
		String currentSeq = httpServletRequest.getParameter("current_seq");
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		VieRedPacketProblemListVo vieRedPacketProblemListVo = (VieRedPacketProblemListVo)sessionManager.getObject(VieRedPacketProblemListVo.class);
		
		httpServletRequest.setAttribute("problems", vieRedPacketProblemListVo.getVieRedPacketProblemVos());
		
		httpServletRequest.setAttribute("count", vieRedPacketProblemListVo.getCount());
		
		httpServletRequest.setAttribute("memberId", memberId);
		
		httpServletRequest.setAttribute("redPacketId", redPacketId);
		httpServletRequest.setAttribute("currentSeq", currentSeq);
		return "vie/vieAnswerProblem";
	}
	
	@HandlerAnnotation(hanlerFilter=GetVieRedPacketResultFilter.class)
	@RequestMapping(value="vie_answer_result")
	public String answerResult(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		VieProblemAnswerListVo vieProblemAnswerListVo = (VieProblemAnswerListVo)sessionManager.getObject(VieProblemAnswerListVo.class);
		
		httpServletRequest.setAttribute("vieProblemAnswers", vieProblemAnswerListVo.getVieProblemAnswerVos());
		return "vie/vieAnswerResult";
	}
	
	
}
