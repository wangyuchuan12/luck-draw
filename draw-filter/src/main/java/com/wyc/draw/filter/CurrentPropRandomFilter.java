package com.wyc.draw.filter;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Prop;
import com.wyc.draw.domain.PropRandom;
import com.wyc.draw.service.PropRandomService;

public class CurrentPropRandomFilter extends Filter{

	@Autowired
	private PropRandomService propRandomService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Prop prop = sessionManager.getObject(Prop.class);
		String propId = prop.getId();
		PropRandom propRandom = propRandomService.findOneByPropId(propId);
		if(propRandom==null){
			propRandom = new PropRandom();
			propRandom.setMillisec(1000L);
			propRandom.setPropId(propId);
			propRandom.setBeanRangeMax(2l);
			propRandom.setBeanRangeMin(1l);
			propRandom.setLoveRangeMax(2l);
			propRandom.setLoveRangeMin(1l);
			propRandom.setMoneyRangeMax(new BigDecimal(0.5));
			propRandom.setMoneyRangeMin(new BigDecimal(0.1));
			propRandom.setStartDatetime(new DateTime());
			propRandom.setUnit(2);
			propRandom.setUnitName("");
			propRandom.setUpperLimit(10000L);
			propRandom.setSchedule(0l);
			propRandom = propRandomService.add(propRandom);
		}else{
			
			if(prop.getRandomStatus()==Constant.PROP_COOLING_STATUS){
				Long millisec = propRandom.getMillisec();
				Integer unit = propRandom.getUnit();
				DateTime startDatetime = propRandom.getStartDatetime();
				Long upperLimit = propRandom.getUpperLimit();
				
				DateTime nowDatetime = new DateTime();
				
				Long differ = nowDatetime.getMillis()-startDatetime.getMillis();
				
				long schedule = (differ/millisec)*unit+propRandom.getSchedule();
				
				propRandom.setStartDatetime(new DateTime());
				
				if(schedule<upperLimit){
					prop.setRandomStatus(Constant.PROP_COOLING_STATUS);
					propRandom.setSchedule(schedule);
				}else{
					prop.setRandomStatus(Constant.PROP_COMPLETE_STATUS);
					propRandom.setSchedule(upperLimit);
				}
			}else{
				propRandom.setSchedule(propRandom.getUpperLimit());
			}
			
		}
		sessionManager.update(prop);
		sessionManager.update(propRandom);
		return propRandom;
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
