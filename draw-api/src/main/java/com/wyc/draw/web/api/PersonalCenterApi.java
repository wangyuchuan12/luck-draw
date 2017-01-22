package com.wyc.draw.web.api;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.ApplyForm;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.GetApplyFormListFilterByUser;
import com.wyc.draw.filter.TakeInApplyFilter;
import com.wyc.draw.filter.TakeOutApplyFilter;
import com.wyc.draw.vo.ApplyFormListVo;

@Controller
@RequestMapping(value="/api/draw/personal_center/")
public class PersonalCenterApi {
	
	
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=TakeOutApplyFilter.class)
	@RequestMapping("take_out_amount")
	@Transactional
	public ResultVo takeOutAmount(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		ResultVo resultVo = (ResultVo)sessionManager.getReturnValue();
		
		if(resultVo!=null){
			return resultVo;
		}
		ApplyForm applyForm = (ApplyForm)sessionManager.getObject(ApplyForm.class);
		
		if(applyForm!=null){
			resultVo = new ResultVo();
			resultVo.setSuccess(true);
			resultVo.setMsg("申请成功");
			resultVo.setData(applyForm);
			return resultVo;
		}
		return null;
	}
	
	
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=TakeInApplyFilter.class)
	@RequestMapping("take_in_amount")
	@Transactional
	public ResultVo takeInAmount(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		ResultVo resultVo = (ResultVo)sessionManager.getReturnValue();
		
		if(resultVo!=null){
			return resultVo;
		}
		ApplyForm applyForm = (ApplyForm)sessionManager.getObject(ApplyForm.class);
		
		if(applyForm!=null){
			resultVo = new ResultVo();
			resultVo.setSuccess(true);
			resultVo.setMsg("申请成功");
			resultVo.setData(applyForm);
			return resultVo;
		}
		return null;
	}
	
	
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=GetApplyFormListFilterByUser.class)
	@RequestMapping("apply_forms")
	public ResultVo applyForms(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		ApplyFormListVo applyFormListVo = (ApplyFormListVo)sessionManager.getObject(ApplyFormListVo.class);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("获取数据成功");
		
		resultVo.setData(applyFormListVo.getApplyForms());
		
		return resultVo;
	}
	
	
}
