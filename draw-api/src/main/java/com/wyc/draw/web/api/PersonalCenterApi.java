package com.wyc.draw.web.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.ApplyForm;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.TakeOutApplyFilter;

@Controller
@RequestMapping(value="/api/draw/personal_center/")
public class PersonalCenterApi {
	
	
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=TakeOutApplyFilter.class)
	@RequestMapping("take_out_amount")
	public ResultVo takeOutAmount(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ApplyForm applyForm = (ApplyForm)sessionManager.getObject(ApplyForm.class);
		
		if(applyForm!=null){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(true);
			resultVo.setMsg("申请成功");
			resultVo.setData(applyForm);
			return resultVo;
		}
		return null;
	}
}
