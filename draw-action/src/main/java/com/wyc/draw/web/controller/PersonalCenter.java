package com.wyc.draw.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.Account;
import com.wyc.common.service.AccountService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.filter.InitDataBaseDrawActionFilter;

@Controller
@RequestMapping(value="/view/draw/personal_center/")
public class PersonalCenter {
	
	@Autowired
	private AccountService accountService;
	@HandlerAnnotation(hanlerFilter=InitDataBaseDrawActionFilter.class)
	@RequestMapping(value="main")
	@Transactional
	public String main(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DrawUser drawUser = (DrawUser) sessionManager.getObject(DrawUser.class);
		
		UserInfo userInfo = (UserInfo)sessionManager.getObject(UserInfo.class);
		httpServletRequest.setAttribute("drawUser", drawUser);
		
		httpServletRequest.setAttribute("userInfo", userInfo);
		Account account = accountService.fineOneSync(drawUser.getAccountId());
		httpServletRequest.setAttribute("account", account);
		return "personalCenter";
	}
	
	
	@RequestMapping(value="qrcode")
	public String qrcode(HttpServletRequest httpServletRequest)throws Exception{
		return "qrcode";
	}
	
	
	@HandlerAnnotation(hanlerFilter=InitDataBaseDrawActionFilter.class)
	@Transactional
	@RequestMapping(value="takeOut")
	public String takeOut(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		UserInfo userInfo = (UserInfo)sessionManager.getObject(UserInfo.class);
		Account account = accountService.fineOneSync(drawUser.getAccountId());
		Map<String, Object> user = new HashMap<>();
		user.put("nickname", userInfo.getNickname());
		user.put("headimgurl", userInfo.getHeadimgurl());
		user.put("amountBalance", account.getAmountBalance());
		user.put("canTakeOutCount", account.getCanTakeOutCount());
		httpServletRequest.setAttribute("user", user);
		return "takeOut";
	}
	
	
	@HandlerAnnotation(hanlerFilter=InitDataBaseDrawActionFilter.class)
	@Transactional
	@RequestMapping(value="takeIn")
	public String takeIn(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		UserInfo userInfo = (UserInfo)sessionManager.getObject(UserInfo.class);
		Account account = accountService.fineOneSync(drawUser.getAccountId());
		Map<String, Object> user = new HashMap<>();
		user.put("nickname", userInfo.getNickname());
		user.put("headimgurl", userInfo.getHeadimgurl());
		user.put("amountBalance", account.getAmountBalance());
		user.put("canTakeOutCount", account.getCanTakeOutCount());
		httpServletRequest.setAttribute("user", user);
		return "takeIn";
	}
}
