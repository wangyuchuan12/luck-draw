package com.wyc.draw.filter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.Account;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.filter.WxShareFilter;
import com.wyc.common.service.AccountService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.DrawUserService;

public class DrawUserFilter extends Filter{

	@Autowired
	private DrawUserService drawUserService;
	
	@Autowired
	private AccountService accountService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		if(drawUser!=null){
			return drawUser;
		}
		
		UserInfo userInfo = (UserInfo)filterManager.getObject(UserInfo.class);
		if(userInfo==null){
			filterManager.setEnd(true);
			
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setMsg("找不到用户信息，请用微信客户端登录");
			filterManager.setReturnValue(resultVo);
			return null;
		}
		drawUser = drawUserService.findByUserId(userInfo.getId());
		
		System.out.println("...........drawUser:"+drawUser);
		if(drawUser==null){
			drawUser = new DrawUser();
			drawUser.setOpenid(userInfo.getOpenid());
			drawUser.setUserId(userInfo.getId());
			drawUser.setAnswerNum(0);
			drawUser.setGetRedPacketAmount(new BigDecimal("0"));
			drawUser.setGetRedPacketNum(0);
			
			drawUser.setWrongAnswerNum(0);
			drawUser.setHandRedPacketAmount(new BigDecimal("0"));
			drawUser.setHandRedPacketNum(0);
			drawUser.setNickname(userInfo.getNickname());
			drawUser.setImgUrl(userInfo.getHeadimgurl());
			drawUser = drawUserService.add(drawUser);
		
		}
		
		if(CommonUtil.isEmpty(drawUser.getAccountId())){
			Account account = new Account();
			account.setAmountBalance(new BigDecimal("0"));
			account.setCanTakeOutCount(3);
			account.setWisdomCount(0l);
			account = accountService.add(account);
			drawUser.setAccountId(account.getId());
			drawUserService.update(drawUser);
		}else{
			Account account = accountService.findOne(drawUser.getAccountId());
			if(account==null){
				account = new Account();
				account.setAmountBalance(new BigDecimal("0"));
				account.setCanTakeOutCount(3);
				account.setWisdomCount(0l);
				account.setEmpiricalValue(new BigDecimal(0));
				account.setIntegral(0);
				account.setLoveLife(0);
				//最多可以有爱心10颗
				account.setLoveLifeLimit(10);
				//最多可以有智慧豆10万颗
				account.setWisdomLimit(100000l);
				account = accountService.add(account);
				drawUser.setAccountId(account.getId());
				drawUserService.update(drawUser);
			}
		}
		
		
		return drawUser;
	}


	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(WxShareFilter.class);
		return filterClasses;
	}


	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		
		if(drawUser!=null){
			sessionManager.addNotExecuteFilterClass(DrawUserFilter.class);
		}
		
		return null;
	}


	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
