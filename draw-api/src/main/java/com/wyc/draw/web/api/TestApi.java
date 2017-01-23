package com.wyc.draw.web.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.UserInfoFilter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.smart.service.UserSmartService;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.filter.GetRedPacketListOfPageFilter;
import com.wyc.draw.vo.RedPacketListVo;

@Controller
@RequestMapping(value="/api/test")
public class TestApi {
	
	@Autowired
	private UserSmartService userSmartService;
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=UserInfoFilter.class)
	@RequestMapping(value="userInfo")
	public Object userInfo(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		UserInfo userInfo = (UserInfo)sessionManager.getObject(UserInfo.class);
		UserInfo userInfo2 = userSmartService.getFromAccessToken(userInfo.getOpenid());
		
		return userInfo2;
	}
}
