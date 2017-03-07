package com.wyc.draw.filter.getter.handler;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.Account;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.AccountService;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawUser;

public class AccountGetterHandlerFilter extends Filter{

	@Autowired
	private AccountService accountService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		Account account = accountService.findOne(drawUser.getAccountId());
		return account;
	}

	@Override
	public Object handlerAfter(SessionManager filterManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPrivateException(SessionManager filterManager, Method method, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPublicException(SessionManager filterManager, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

}
