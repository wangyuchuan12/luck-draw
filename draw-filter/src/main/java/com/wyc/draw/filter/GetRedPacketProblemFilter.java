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
import com.wyc.draw.vo.VieRedPacketProblemVo;

public class GetRedPacketProblemFilter extends Filter{

	@Autowired
	private VieRedPacketProblemService vieRedPacketProblemService;
	
	@Autowired
	private VieRedPacketOptionService vieRedPacketOptionService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		//设置状态，0表示还未设置 1表示已经设置
		String status = httpServletRequest.getParameter("status");
		Integer statusInt = Integer.parseInt(status);
		String problemId = httpServletRequest.getParameter("problem_id");
		
		String redPacketId = httpServletRequest.getParameter("red_packet_id");
		VieRedPacketProblemVo vieRedPacketProblemVo  = new VieRedPacketProblemVo();
		vieRedPacketProblemVo.setCount(0l);
		vieRedPacketProblemVo.setSeq(0);
		
		Long count = vieRedPacketProblemService.coutByRedPacketId(redPacketId);
		
		String previousProblemId = httpServletRequest.getParameter("previous_problem_id");
		
		if(previousProblemId!=null){
			VieRedPacketProblem previousProblem = vieRedPacketProblemService.findOne(previousProblemId);
			if(previousProblem!=null){
				vieRedPacketProblemVo.setIsFirst(0);
				vieRedPacketProblemVo.setPreviousProblemId(previousProblemId);
			}else{
				vieRedPacketProblemVo.setIsFirst(1);
			}
		}else{
			vieRedPacketProblemVo.setIsFirst(1);
		}
		if(statusInt==0){
			
			if(count>0){
				vieRedPacketProblemVo.setIsFirst(0);
			}else{
				vieRedPacketProblemVo.setIsFirst(1);
			}
			vieRedPacketProblemVo.setStatus(0);
			vieRedPacketProblemVo.setIsLast(1);
			vieRedPacketProblemVo.setRedPacketId(redPacketId);
			vieRedPacketProblemVo.setSeq(Integer.parseInt((count+1)+""));
		}else if(statusInt==1){
			
			VieRedPacketProblem vieRedPacketProblem  = vieRedPacketProblemService.findOne(problemId);
			
			List<VieRedPacketOption> vieRedPacketOptions = vieRedPacketOptionService.findAllByRedPacketProblemIdAndIsDelOrderBySeqAsc(problemId,0);
			
			List<VieRedPacketOptionVo> vieRedPacketOptionVos = new ArrayList<>();
			
			for(VieRedPacketOption vieRedPacketOption:vieRedPacketOptions){
				VieRedPacketOptionVo vieRedPacketOptionVo = new VieRedPacketOptionVo();
				vieRedPacketOptionVo.setContent(vieRedPacketOption.getContent());
				vieRedPacketOptionVo.setId(vieRedPacketOption.getId());
				vieRedPacketOptionVo.setIsDel(vieRedPacketOption.getIsDel());
				vieRedPacketOptionVo.setIsRight(vieRedPacketOption.getIsRight());
				vieRedPacketOptionVo.setRedPacketId(vieRedPacketOption.getRedPacketId());
				vieRedPacketOptionVo.setRedPacketProblemId(vieRedPacketOption.getRedPacketProblemId());
				vieRedPacketOptionVo.setSeq(vieRedPacketOption.getSeq());
				vieRedPacketOptionVos.add(vieRedPacketOptionVo);
			}
			
			
			if(vieRedPacketProblem!=null){
				VieRedPacketProblem nextRedPacketProblem = vieRedPacketProblemService.findOneByPreviousProblemId(vieRedPacketProblem.getId());
				
				if(nextRedPacketProblem!=null){
					vieRedPacketProblemVo.setNextProblemId(nextRedPacketProblem.getId());
					vieRedPacketProblemVo.setIsLast(0);
				}else{
					vieRedPacketProblemVo.setIsLast(1);
				}
				
				vieRedPacketProblemVo.setId(vieRedPacketProblem.getId());
			}
			
			
			
			vieRedPacketProblemVo.setImgUrl(vieRedPacketProblem.getImgUrl());
			vieRedPacketProblemVo.setIsDel(vieRedPacketProblem.getIsDel());
			vieRedPacketProblemVo.setIsFirst(vieRedPacketProblem.getIsFirst());
			vieRedPacketProblemVo.setPreviousProblemId(vieRedPacketProblem.getPreviousProblemId());
			vieRedPacketProblemVo.setQuestion(vieRedPacketProblem.getQuestion());
			vieRedPacketProblemVo.setRedPacketId(vieRedPacketProblem.getRedPacketId());
			vieRedPacketProblemVo.setSeq(vieRedPacketProblem.getSeq());
			vieRedPacketProblemVo.setStatus(1);
			vieRedPacketProblemVo.setVieRedPacketOptionVos(vieRedPacketOptionVos);
		}
		
		
		
		vieRedPacketProblemVo.setCount(count+1);
		
		return vieRedPacketProblemVo;
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
