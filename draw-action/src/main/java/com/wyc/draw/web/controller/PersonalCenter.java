package com.wyc.draw.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.filter.BaseDrawActionFilter;

@Controller
@RequestMapping(value="/view/draw/personal_center/")
public class PersonalCenter {
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="main")
	public String main(HttpServletRequest httpServletRequest){
		return "personalCenter";
	}
	
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="takeOut")
	public String takeOut(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		UserInfo userInfo = (UserInfo)sessionManager.getObject(UserInfo.class);
		
		Map<String, Object> user = new HashMap<>();
		user.put("nickname", userInfo.getNickname());
		user.put("headimgurl", userInfo.getHeadimgurl());
		user.put("amountBalance", drawUser.getAmountBalance());
		user.put("canTakeOutCount", drawUser.getCanTakeOutCount());
		httpServletRequest.setAttribute("user", user);
		return "takeOut";
	}
}
