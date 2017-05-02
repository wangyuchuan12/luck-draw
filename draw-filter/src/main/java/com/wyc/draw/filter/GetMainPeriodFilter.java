package com.wyc.draw.filter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.view.MainPeriod;
import com.wyc.draw.service.MainPeriodService;

public class GetMainPeriodFilter extends Filter{

	@Autowired
	private MainPeriodService mainPeriodService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
		MainPeriod period = (MainPeriod)filterManager.getObject(MainPeriod.class);
		
		if(period!=null){
			return period;
		}
		List<MainPeriod> mainPeriods = mainPeriodService.findAllByIsDefault(1);
		if(mainPeriods==null||mainPeriods.size()==0){
			mainPeriods = mainPeriodService.findAllByIsDefault(0);
			if(mainPeriods!=null&&mainPeriods.size()>0){
				return mainPeriods.get(0);
			}
		}else{
			return mainPeriods.get(0);
		}
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
