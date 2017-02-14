package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.VieRedPacketOption;
import com.wyc.draw.domain.VieRedPacketProblem;
import com.wyc.draw.service.VieRedPacketOptionService;
import com.wyc.draw.service.VieRedPacketProblemService;
import com.wyc.draw.vo.VieRedPacketOptionVo;
import com.wyc.draw.vo.VieRedPacketProblemListVo;
import com.wyc.draw.vo.VieRedPacketProblemVo;

public class GetRedPacketProblemListFilter extends Filter{

	@Autowired
	private VieRedPacketProblemService vieRedPacketProblemService;
	
	@Autowired
	private VieRedPacketOptionService vieRedPacketOptionService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String redPacketId = httpServletRequest.getParameter("red_packet_id");
		List<VieRedPacketProblem> vieRedPacketProblems = vieRedPacketProblemService.findAllByRedPacketIdOrderBySeqAsc(redPacketId);
		List<VieRedPacketProblemVo> vieRedPacketProblemVos = new ArrayList<>();
		for(VieRedPacketProblem vieRedPacketProblem:vieRedPacketProblems){
			VieRedPacketProblemVo vieRedPacketProblemVo = new VieRedPacketProblemVo();
			vieRedPacketProblemVo.setId(vieRedPacketProblem.getId());
			vieRedPacketProblemVo.setImgUrl(vieRedPacketProblem.getImgUrl());
			vieRedPacketProblemVo.setIsDel(vieRedPacketProblem.getIsDel());
			vieRedPacketProblemVo.setIsFirst(vieRedPacketProblem.getIsFirst());
			vieRedPacketProblemVo.setIsLast(vieRedPacketProblem.getIsFirst());
			vieRedPacketProblemVo.setQuestion(vieRedPacketProblem.getQuestion());
			vieRedPacketProblemVo.setRedPacketId(vieRedPacketProblem.getRedPacketId());
			vieRedPacketProblemVo.setSeq(vieRedPacketProblem.getSeq());
			
			List<VieRedPacketOptionVo> optionVos = new ArrayList<>();
			List<VieRedPacketOption> vieRedPacketOptions = vieRedPacketOptionService.findAllByRedPacketProblemIdAndIsDelOrderBySeqAsc(vieRedPacketProblem.getId(), 0);
			for(VieRedPacketOption vieRedPacketOption:vieRedPacketOptions){
				VieRedPacketOptionVo vieRedPacketOptionVo = new VieRedPacketOptionVo();
				vieRedPacketOptionVo.setContent(vieRedPacketOption.getContent());
				vieRedPacketOptionVo.setId(vieRedPacketOption.getId());
				vieRedPacketOptionVo.setIsDel(vieRedPacketOption.getIsDel());
				vieRedPacketOptionVo.setIsRight(vieRedPacketOption.getIsRight());
				vieRedPacketOptionVo.setRedPacketId(vieRedPacketOption.getRedPacketId());
				vieRedPacketOptionVo.setRedPacketProblemId(vieRedPacketOption.getRedPacketProblemId());
				vieRedPacketOptionVo.setSeq(vieRedPacketOption.getSeq());
				optionVos.add(vieRedPacketOptionVo);
			}
			vieRedPacketProblemVo.setVieRedPacketOptionVos(optionVos);
			vieRedPacketProblemVos.add(vieRedPacketProblemVo);
		}
		
		VieRedPacketProblemListVo vieRedPacketProblemListVo = new VieRedPacketProblemListVo();
		vieRedPacketProblemListVo.setVieRedPacketProblemVos(vieRedPacketProblemVos);
		Long count = vieRedPacketProblemService.coutByRedPacketId(redPacketId);
		vieRedPacketProblemListVo.setCount(count);
		return vieRedPacketProblemListVo;
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
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		
		return classes;
	}

}
