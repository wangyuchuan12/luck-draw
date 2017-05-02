package com.wyc.draw.filter.controller.api;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.domain.DekornTakepartMember;
import com.wyc.draw.domain.DekornToTakepartMember;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.CurrentDekornToTakepartFilter;

public class SubmitScoreApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String score = httpServletRequest.getParameter("score");
		String takepartMemberId = httpServletRequest.getParameter("takepart_member_id");
		
		if(CommonUtil.isEmpty(score)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入参数score不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(takepartMemberId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入参数takepartMemberId不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		DekornToTakepartMember dekornToTakepartMember = (DekornToTakepartMember)filterManager.getObject(DekornToTakepartMember.class);
		if(!dekornToTakepartMember.getCurrentTakepartMemberId().equals(takepartMemberId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入参数takepartMemberId不匹配");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		if(dekornToTakepartMember.getTakepartStatus()!=Constant.DEKORN_UNDERWAY_TAKEPART_STATUS){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("该挑战参赛状态不是正在进行中");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		DekornTakepartMember dekornTakepartMember = filterManager.findOne(DekornTakepartMember.class, takepartMemberId);
		Dekorn dekorn = filterManager.findOne(Dekorn.class, dekornTakepartMember.getDekornId());
		Long scoreLong = Long.parseLong(score);
		if(dekorn.getPassScore()>scoreLong){
			dekornTakepartMember.setIsSuccess(0);
		}else{
			dekornTakepartMember.setIsSuccess(1);
		}
		
		dekornTakepartMember.setTakepartStatus(Constant.DEKORN_COMPLETE_TAKEPART_STATUS);
		dekornToTakepartMember.setTakepartStatus(Constant.DEKORN_COMPLETE_TAKEPART_STATUS);
		filterManager.update(dekornTakepartMember);
		filterManager.update(dekornToTakepartMember);
		ResultVo resultVo = new ResultVo();
		resultVo.setMsg("提交数据成功");
		resultVo.setSuccess(true);
		resultVo.setData(dekornTakepartMember);
		return resultVo;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		classes.add(CurrentDekornToTakepartFilter.class);
		return classes;
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
