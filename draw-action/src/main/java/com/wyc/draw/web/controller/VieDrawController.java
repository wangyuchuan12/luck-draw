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
import com.wyc.common.util.Constant;
import com.wyc.common.util.MySimpleDateFormat;
import com.wyc.draw.domain.DrawRoom;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.domain.RedPacketToComent;
import com.wyc.draw.domain.RedPacketToTakepartMember;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.GetRedPacketProblemFilter;
import com.wyc.draw.filter.GetVieRedPacketResultFilter;
import com.wyc.draw.filter.controller.action.VieAnswerProblemActionFilter;
import com.wyc.draw.filter.controller.action.VieDrawInfoActionFilter;
import com.wyc.draw.service.DrawRoomService;
import com.wyc.draw.service.VieRedPacketTakepartMemberService;
import com.wyc.draw.service.VieRedPacketToTakepartMemberService;
import com.wyc.draw.vo.RedPacketAmountDistributionListVo;
import com.wyc.draw.vo.RedPacketComentListVo;
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
	private VieRedPacketToTakepartMemberService vieRedPacketToTakepartMemberService;

	
	@Autowired
	private VieRedPacketTakepartMemberService vieRedPacketTakepartMemberService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private MySimpleDateFormat mySimpleDateFormat;
	
	@Transactional
	@HandlerAnnotation(hanlerFilter=VieDrawInfoActionFilter.class)
	@RequestMapping(value="info")
	public String info(HttpServletRequest httpServletRequest)throws Exception{
		
		String firstVisit = httpServletRequest.getParameter("firstVisit");
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		if(sessionManager.isReturn()){
			return null;
		}
		
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		RedPacketVo redPacketVo = (RedPacketVo)sessionManager.getObject(RedPacketVo.class);
		
		//加入还未设置选项卡就跳到设置选项卡界面
		if(redPacketVo.getHandDrawUserId().equals(drawUser.getId())&&redPacketVo.getIsGiveQuestion()==0){
			return "redirect:vie_set_problem?status=0&red_packet_id="+redPacketVo.getId();
		}
		
		httpServletRequest.setAttribute("redPacketInfo", redPacketVo);
		
		
		
		
		
		ResultPageListVo resultPageListVo = (ResultPageListVo)sessionManager.getObject(ResultPageListVo.class);

		
		httpServletRequest.setAttribute("takePartMembers", resultPageListVo);
		
		
		RedPacketToTakepartMember vieRedPacketToTakepartMember = (RedPacketToTakepartMember)sessionManager.getObject(RedPacketToTakepartMember.class);
		
		if(vieRedPacketToTakepartMember.getTakepartStatus()==Constant.UNDERWAY_TAKEPART_STATUS){
			vieRedPacketToTakepartMember.setTakepartStatus(Constant.RENEGINT_TAKEPART_STATUS);
			sessionManager.save(vieRedPacketToTakepartMember);
			vieRedPacketToTakepartMemberService.update(vieRedPacketToTakepartMember);
			
			String currentTakepartMemberId = vieRedPacketToTakepartMember.getCurrentTakepartMemberId();
			
			RedPacketTakepartMember redPacketTakepartMember = vieRedPacketTakepartMemberService.findOne(currentTakepartMemberId);
			redPacketTakepartMember.setIsComplete(1);
			vieRedPacketTakepartMemberService.update(redPacketTakepartMember);
		}else if(vieRedPacketToTakepartMember.getTakepartStatus()==Constant.COMPLETE_TAKEPART_STATUS){
			
		}
		
		VieRedPacketTakepartMemberVo thisMember = null;
		if(vieRedPacketToTakepartMember.getTakepartStatus()!=Constant.NOT_INVOLVED_TAKEPART_STATUS){

			RedPacketTakepartMember vieRedPacketTakepartMember = vieRedPacketTakepartMemberService.findOne(vieRedPacketToTakepartMember.getCurrentTakepartMemberId());

			if(vieRedPacketTakepartMember!=null){
				thisMember = new VieRedPacketTakepartMemberVo();
				thisMember.setCurrentProblemId(vieRedPacketTakepartMember.getCurrentProblemId());
				thisMember.setDrawUserId(vieRedPacketTakepartMember.getDrawUserId());
				thisMember.setHeadImg(vieRedPacketTakepartMember.getHeadImg());
				thisMember.setId(vieRedPacketTakepartMember.getId());
				thisMember.setIsBest(vieRedPacketTakepartMember.getIsBest());
				thisMember.setIsComplete(vieRedPacketTakepartMember.getIsComplete());
				thisMember.setIsPay(vieRedPacketTakepartMember.getIsPay());
				thisMember.setNickname(vieRedPacketTakepartMember.getNickname());
				thisMember.setOpendid(vieRedPacketTakepartMember.getOpenid());
				thisMember.setRedPacketId(vieRedPacketTakepartMember.getRedPacketId());
				thisMember.setRightCount(vieRedPacketTakepartMember.getRightCount());
				thisMember.setTimeLong(vieRedPacketTakepartMember.getTimeLong());
				thisMember.setUserId(vieRedPacketTakepartMember.getUserId());
				thisMember.setWrongCount(vieRedPacketTakepartMember.getWrongCount());
				thisMember.setTimeLong(vieRedPacketTakepartMember.getTimeLong());
				thisMember.setTakepartStatus(vieRedPacketToTakepartMember.getTakepartStatus());
				thisMember.setRank(vieRedPacketTakepartMemberService.rowNumberByRedPacketId(vieRedPacketTakepartMember.getRightCount(), vieRedPacketTakepartMember.getTimeLong(), vieRedPacketTakepartMember.getRedPacketId()));
				thisMember.setGetAmount(vieRedPacketTakepartMember.getGetAmount());
				thisMember.setTakepartDateTime(mySimpleDateFormat.format(vieRedPacketTakepartMember.getTakepartDateTime().toDate()));
			}
		
		}
		

		//总共参与人数
		
		Long takeMemberCount = vieRedPacketTakepartMemberService.countByRedPacketId(redPacketVo.getId());
		httpServletRequest.setAttribute("takePartCount", takeMemberCount);
		//本用户的参与名额
		httpServletRequest.setAttribute("thisMember", thisMember);
		Account account = accountService.fineOneSync(drawUser.getAccountId());
		httpServletRequest.setAttribute("account", account);
		
		List<RedPacketTakepartMember> bestTakepartMemberts = vieRedPacketTakepartMemberService.findAllByRedPacketIdAndIsBest(redPacketVo.getId(), 1);
		if(bestTakepartMemberts!=null&&bestTakepartMemberts.size()>0){
			httpServletRequest.setAttribute("bestTakepartMember", bestTakepartMemberts.get(0));
		}
		
		RedPacketAmountDistributionListVo redPacketAmountDistributionListVo = (RedPacketAmountDistributionListVo)sessionManager.getObject(RedPacketAmountDistributionListVo.class);
		
		httpServletRequest.setAttribute("distributions", redPacketAmountDistributionListVo.getRedPacketAmountDistributions());
		
		httpServletRequest.setAttribute("drawUser", drawUser);
		
		RedPacketToComent redPacketToComent = (RedPacketToComent)sessionManager.getObject(RedPacketToComent.class);
		
		httpServletRequest.setAttribute("redPacketToComment", redPacketToComent);
		
		httpServletRequest.setAttribute("firstVisit", firstVisit);
		
		RedPacketComentListVo redPacketComentListVo = (RedPacketComentListVo)sessionManager.getObject(RedPacketComentListVo.class);
		
		if(redPacketComentListVo!=null&&redPacketComentListVo.getComents()!=null&&redPacketComentListVo.getComents().size()>0){
			httpServletRequest.setAttribute("coment", redPacketComentListVo.getComents().get(0));
		}

		
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
	
	@HandlerAnnotation(hanlerFilter=VieAnswerProblemActionFilter.class)
	@RequestMapping(value="vie_answer_problem")
	public String answer(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.isReturn()){
			return null;
		}
		String memberId = httpServletRequest.getParameter("member_id");
		
		String redPacketId = httpServletRequest.getParameter("red_packet_id");
		String currentSeq = httpServletRequest.getParameter("current_seq");
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
