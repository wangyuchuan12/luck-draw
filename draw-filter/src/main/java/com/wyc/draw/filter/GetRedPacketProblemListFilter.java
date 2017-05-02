package com.wyc.draw.filter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.VieRedPacketOption;
import com.wyc.draw.domain.VieRedPacketProblem;
import com.wyc.draw.domain.param.VieDrawInfoParam;
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
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
		VieDrawInfoParam vieDrawInfoParam = (VieDrawInfoParam)filterManager.getObject(VieDrawInfoParam.class);
		String redPacketId = vieDrawInfoParam.getRedPacketId();
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
	public List<Class<? extends Filter>> dependClasses() {
		return null;
	}


	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
