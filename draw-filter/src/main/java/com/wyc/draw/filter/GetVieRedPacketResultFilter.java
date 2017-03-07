package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.domain.VieRedPacketOption;
import com.wyc.draw.domain.VieRedPacketProblem;
import com.wyc.draw.domain.VieRedPacketTakepartMemberRecord;
import com.wyc.draw.service.VieRedPacketOptionService;
import com.wyc.draw.service.VieRedPacketProblemService;
import com.wyc.draw.service.VieRedPacketTakepartMemberRecordService;
import com.wyc.draw.service.VieRedPacketTakepartMemberService;
import com.wyc.draw.vo.VieProblemAnswerListVo;
import com.wyc.draw.vo.VieProblemAnswerVo;
import com.wyc.draw.vo.VieRedPacketOptionVo;


//获取答题结果
public class GetVieRedPacketResultFilter extends Filter{

	@Autowired
	private VieRedPacketTakepartMemberService redPacketTakepartMemberService;
	
	@Autowired
	private VieRedPacketTakepartMemberRecordService vieRedPacketTakepartMemberRecordService;
	
	@Autowired
	private VieRedPacketProblemService vieRedPacketProblemService;
	
	@Autowired
	private VieRedPacketOptionService vieRedPacketOptionService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String redPacketId = httpServletRequest.getParameter("id");
		
		List<RedPacketTakepartMember> vieRedPacketTakepartMembers = redPacketTakepartMemberService.findByRedPacketIdAndDrawUserId(redPacketId, drawUser.getId());
		
		RedPacketTakepartMember vieRedPacketTakepartMember = vieRedPacketTakepartMembers.get(0);
		VieProblemAnswerListVo vieProblemAnswerListVo = new VieProblemAnswerListVo();
		
		List<VieProblemAnswerVo> vieProblemAnswerVos = new ArrayList<>();
		vieProblemAnswerListVo.setVieProblemAnswerVos(vieProblemAnswerVos);
		
		List<VieRedPacketProblem> vieRedPacketProblems = vieRedPacketProblemService.findAllByRedPacketIdOrderBySeqAsc(redPacketId);
		
		for(VieRedPacketProblem vieRedPacketProblem:vieRedPacketProblems){
			VieProblemAnswerVo vieProblemAnswerVo = new VieProblemAnswerVo();
			vieProblemAnswerVo.setId(vieRedPacketProblem.getId());
			vieProblemAnswerVo.setQuestion(vieRedPacketProblem.getQuestion());
			vieProblemAnswerVo.setSeq(vieRedPacketProblem.getSeq());
			VieRedPacketTakepartMemberRecord vieRedPacketTakepartMemberRecord = vieRedPacketTakepartMemberRecordService.findByMemberIdAndVieRedPacketProblemId(vieRedPacketTakepartMember.getId(),vieRedPacketProblem.getId());
			if(vieRedPacketTakepartMemberRecord!=null){
				vieProblemAnswerVo.setTimelong(vieRedPacketTakepartMemberRecord.getTimeLong());
				List<VieRedPacketOption> vieRedPacketOptions = vieRedPacketOptionService.findAllByRedPacketProblemIdAndIsDelOrderBySeqAsc(vieRedPacketProblem.getId(), 0);
				
				List<VieRedPacketOptionVo> vieRedPacketOptionVos = new ArrayList<>();
				
				for(VieRedPacketOption vieRedPacketOption:vieRedPacketOptions){
					VieRedPacketOptionVo vieRedPacketOptionVo = new VieRedPacketOptionVo();
					vieRedPacketOptionVo.setContent(vieRedPacketOption.getContent());
					vieRedPacketOptionVo.setId(vieRedPacketOption.getId());
					vieRedPacketOptionVo.setIsDel(0);
					vieRedPacketOptionVo.setIsRight(vieRedPacketOption.getIsRight());
					vieRedPacketOptionVo.setRedPacketId(redPacketId);
					vieRedPacketOptionVo.setRedPacketProblemId(vieRedPacketOption.getRedPacketProblemId());
					vieRedPacketOptionVo.setSeq(vieRedPacketOption.getSeq());
					
					vieRedPacketOptionVos.add(vieRedPacketOptionVo);

					if(vieRedPacketOptionVo.getId().equals(vieRedPacketTakepartMemberRecord.getVieRedPacketOptionId())){
						vieProblemAnswerVo.setMyOption(vieRedPacketOptionVo);
					}
				}
				vieProblemAnswerVo.setVieRedPacketOptionVos(vieRedPacketOptionVos);
				vieProblemAnswerVos.add(vieProblemAnswerVo);
			}
		}
		return vieProblemAnswerListVo;
	}

	@Override
	public Object handlerAfter(SessionManager filterManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPrivateException(SessionManager filterManager, Method method, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPublicException(SessionManager filterManager, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(DrawUserFilter.class);
		return filters;
	}

}
