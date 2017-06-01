package com.wyc.draw.filter;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Prop;
import com.wyc.draw.domain.PropPhy;
import com.wyc.draw.service.PropPhyService;

public class CurrentPropPhyFilter extends Filter{

	@Autowired
	private PropPhyService propPhyService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Prop prop = sessionManager.getObject(Prop.class);
		String propId = prop.getId();
		PropPhy propPhy = propPhyService.findOneByPropId(propId);
		if(propPhy==null){
			propPhy = new PropPhy();
			propPhy.setMillisec(1000L);
			propPhy.setPropId(propId);
			propPhy.setRangeMax(50l);
			propPhy.setRangeMin(5l);
			propPhy.setStartDatetime(new DateTime());
			propPhy.setUnit(2);
			propPhy.setUnitName("");
			propPhy.setUpperLimit(10000L);
			propPhy.setSchedule(0l);
			propPhy = propPhyService.add(propPhy);
		}else{
			
			if(prop.getPhyStatus()==Constant.PROP_COOLING_STATUS){
				Long millisec = propPhy.getMillisec();
				Integer unit = propPhy.getUnit();
				DateTime startDatetime = propPhy.getStartDatetime();
				Long upperLimit = propPhy.getUpperLimit();
				
				DateTime nowDatetime = new DateTime();
				
				Long differ = nowDatetime.getMillis()-startDatetime.getMillis();
				
				long schedule = (differ/millisec)*unit;
				
				if(schedule<upperLimit){
					prop.setPhyStatus(Constant.PROP_COOLING_STATUS);
					propPhy.setSchedule(schedule);
				}else{
					prop.setPhyStatus(Constant.PROP_COMPLETE_STATUS);
					propPhy.setSchedule(upperLimit);
				}
			}else{
				propPhy.setSchedule(propPhy.getUpperLimit());
			}
			
		}
		sessionManager.update(prop);
		sessionManager.update(propPhy);
		return propPhy;
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
