package com.wyc.draw.filter;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Prop;
import com.wyc.draw.domain.PropLove;
import com.wyc.draw.service.PropLoveService;

public class CurrentPropLoveFilter extends Filter{
	@Autowired
	private PropLoveService propLoveService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Prop prop = sessionManager.getObject(Prop.class);
		String propId = prop.getId();
		PropLove propLove = propLoveService.findOneByPropId(propId);
		if(propLove==null){
			propLove = new PropLove();
			propLove.setMillisec(1000L);
			propLove.setPropId(propId);
			propLove.setRangeMax(50l);
			propLove.setRangeMin(5l);
			propLove.setStartDatetime(new DateTime());
			propLove.setUnit(2);
			propLove.setUnitName("");
			propLove.setUpperLimit(10000L);
			propLove.setSchedule(0l);
			propLove = propLoveService.add(propLove);
		}else{
			
			if(prop.getLoveStatus()==Constant.PROP_COOLING_STATUS){
				Long millisec = propLove.getMillisec();
				Integer unit = propLove.getUnit();
				DateTime startDatetime = propLove.getStartDatetime();
				Long upperLimit = propLove.getUpperLimit();
				
				DateTime nowDatetime = new DateTime();
				
				Long differ = nowDatetime.getMillis()-startDatetime.getMillis();
				
				long schedule = (differ/millisec)*unit+propLove.getSchedule();
				
				propLove.setStartDatetime(new DateTime());
				
				if(schedule<upperLimit){
					prop.setLoveStatus(Constant.PROP_COOLING_STATUS);
					propLove.setSchedule(schedule);
				}else{
					prop.setLoveStatus(Constant.PROP_COMPLETE_STATUS);
					propLove.setSchedule(upperLimit);
				}
			}else{
				propLove.setSchedule(propLove.getUpperLimit());
			}
			
		}
		sessionManager.update(prop);
		sessionManager.update(propLove);
		return propLove;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
