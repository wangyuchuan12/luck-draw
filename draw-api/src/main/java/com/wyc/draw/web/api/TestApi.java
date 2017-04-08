package com.wyc.draw.web.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.BaseActionFilter;
import com.wyc.common.filter.UserInfoFilter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.smart.service.UserSmartService;
import com.wyc.common.wx.domain.Article;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.common.wx.service.SendMessageService;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.filter.GetRedPacketListOfPageFilter;
import com.wyc.draw.filter.SelectGameDekornFilter;
import com.wyc.draw.vo.RedPacketListVo;

@Controller
@RequestMapping(value="/view/test")
public class TestApi {
	
	@Autowired
	private UserSmartService userSmartService;
	
	@Autowired
	private SendMessageService sendMessageService;
	@HandlerAnnotation(hanlerFilter=BaseActionFilter.class)
	@RequestMapping(value="userInfo")
	public Object userInfo(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		UserInfo userInfo = (UserInfo)sessionManager.getObject(UserInfo.class);
		
		System.out.println(userInfo);
		UserInfo userInfo2 = userSmartService.getFromAccessToken(userInfo.getOpenid());
		System.out.println("userInfo2:"+userInfo2);
		return userInfo2;
	}
	
	
	@ResponseBody
	@RequestMapping(value="sendMsg")
	public Object sendMsg(HttpServletRequest httpServletRequest)throws Exception{
		
		String openid = httpServletRequest.getParameter("openid");
		List<Article> articles = new ArrayList<>();
		Article article = new Article();
		article.setDescription("1");
		article.setTitle("2");
		
		article.setUrl("");
		
		
		
		articles.add(article);
		
		return sendMessageService.sendImgMessage(openid, articles);
	}
	
	
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=SelectGameDekornFilter.class)
	@RequestMapping(value="selectGameDekorn")
	public Object testSelectGameDekorn(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		Dekorn dekorn = (Dekorn)sessionManager.getObject(Dekorn.class);
		return dekorn;
	}
}
