package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.view.MainImg;
import com.wyc.draw.domain.view.MainPeriod;
import com.wyc.draw.service.MainImgService;
import com.wyc.draw.vo.MainImgListVo;

public class GetMainImgFilter extends Filter{

	@Autowired
	private MainImgService mainImgService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		MainPeriod mainPeriod = (MainPeriod)filterManager.getObject(MainPeriod.class);
		
		List<MainImg> mainImgs = mainImgService.findAllByPeriodId(mainPeriod.getId());
		
		MainImgListVo mainImgListVo = new MainImgListVo();
		mainImgListVo.setMainImgs(mainImgs);
		
		return mainImgListVo;
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
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(GetMainPeriodFilter.class);
		
		return classes;
	}

}
