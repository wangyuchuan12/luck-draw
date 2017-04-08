package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.service.DekornService;

public class SelectGameDekornFilter extends Filter{

	@Autowired
	private DekornService dekornService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String gameId = httpServletRequest.getParameter("gameId");
		String passScore = httpServletRequest.getParameter("passScore");
		String index = httpServletRequest.getParameter("index");
		if(CommonUtil.isEmpty(index)){
			index="0";
		}
		Integer indexInt = Integer.parseInt(index);
		
		Long passScoreLong = Long.parseLong(passScore);
		Long count = dekornService.countByGameIdAndBiggerThanPassScoreAndStatus(gameId,passScoreLong,Constant.DEKORN_PROGRESS_STATUS);
		Pageable pageable = new PageRequest(indexInt, 1);
		
		List<Dekorn> dekorns = dekornService.findAllByGameIdAndBiggerThanPassScoreAndStatus(gameId, passScoreLong, Constant.DEKORN_PROGRESS_STATUS, pageable);
		
		if(dekorns!=null&&dekorns.size()>0){
			return dekorns.get(0);
		}
		
		return null;
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
