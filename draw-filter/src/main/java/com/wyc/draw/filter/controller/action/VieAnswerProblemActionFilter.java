package com.wyc.draw.filter.controller.action;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.RedPacketToTakepartMember;
import com.wyc.draw.filter.CurrentVieRedPacketToTakepartMemberFilter;
import com.wyc.draw.filter.GetRedPacketProblemListFilter;
import com.wyc.draw.filter.controller.param.VieAnswerProblemParamFilter;
import com.wyc.draw.service.VieRedPacketToTakepartMemberService;

public class VieAnswerProblemActionFilter extends Filter{

	@Autowired
	private VieRedPacketToTakepartMemberService vieRedPacketToTakepartMemberService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		RedPacketToTakepartMember vieRedPacketToTakepartMember = (RedPacketToTakepartMember)filterManager.getObject(RedPacketToTakepartMember.class);
		
		if(vieRedPacketToTakepartMember.getIsPay()==1){
			vieRedPacketToTakepartMember.setTakepartStatus(Constant.UNDERWAY_TAKEPART_STATUS);
			
			vieRedPacketToTakepartMemberService.update(vieRedPacketToTakepartMember);
			
			return vieRedPacketToTakepartMember;
		}else{
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("该用户未付款");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
	}


	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(VieAnswerProblemParamFilter.class);
		filterClasses.add(GetRedPacketProblemListFilter.class);
		filterClasses.add(CurrentVieRedPacketToTakepartMemberFilter.class);
		return filterClasses;
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
