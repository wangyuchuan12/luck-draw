package com.wyc.draw.filter;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Prop;
import com.wyc.draw.domain.PropBean;
import com.wyc.draw.service.PropBeanService;

public class CurrentPropBeanFilter extends Filter{
	
	@Autowired
	private PropBeanService propBeanService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Prop prop = sessionManager.getObject(Prop.class);
		String propId = prop.getId();
		PropBean propBean = propBeanService.findOneByPropId(propId);
		if(propBean==null){
			propBean = new PropBean();
			propBean.setMillisec(1000L);
			propBean.setPropId(propId);
			propBean.setRangeMax(50l);

			propBean.setRangeMin(5l);
			propBean.setStartDatetime(new DateTime());
			propBean.setUnit(2);
			propBean.setUnitName("");
			propBean.setUpperLimit(10000L);
			propBean.setSchedule(0l);
			propBean = propBeanService.add(propBean);
		}else{
			
			if(prop.getBeanStatus()==Constant.PROP_COOLING_STATUS){
				Long millisec = propBean.getMillisec();
				Integer unit = propBean.getUnit();
				DateTime startDatetime = propBean.getStartDatetime();
				Long upperLimit = propBean.getUpperLimit();
				
				DateTime nowDatetime = new DateTime();
				
				Long differ = nowDatetime.getMillis()-startDatetime.getMillis();
				
				long schedule = (differ/millisec)*unit;
				
				if(schedule<upperLimit){
					prop.setBeanStatus(Constant.PROP_COOLING_STATUS);
					propBean.setSchedule(schedule);
				}else{
					prop.setBeanStatus(Constant.PROP_COMPLETE_STATUS);
					propBean.setSchedule(upperLimit);
				}
			}else{
				propBean.setSchedule(propBean.getUpperLimit());
			}
			
		}
		sessionManager.update(prop);
		sessionManager.update(propBean);
		return propBean;
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
