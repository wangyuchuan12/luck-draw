package com.wyc.draw.filter;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.BattleContext;
import com.wyc.draw.domain.Prop;
import com.wyc.draw.domain.PropBean;
import com.wyc.draw.service.BattleContextService;
import com.wyc.draw.service.PropBeanService;

public class CurrentPropBeanFilter extends Filter{
	
	@Autowired
	private PropBeanService propBeanService;
	
	@Autowired
	private BattleContextService battleContextService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		
		Prop prop = sessionManager.getObject(Prop.class);
		String propId = prop.getId();
		PropBean propBean = propBeanService.findOneByPropId(propId);
		if(propBean==null){
			
			List<String> codes = new ArrayList<>();
			
			codes.add(BattleContext.PROP_BEAN_MILLISEC_CODE);
			codes.add(BattleContext.PROP_BEAN_RANAGE_MAX_CODE);
			codes.add(BattleContext.PROP_BEAN_RANAGE_MIN_CODE);
			codes.add(BattleContext.PROP_BEAN_SCHEDULE_CODE);
			codes.add(BattleContext.PROP_BEAN_UNIT_CODE);
			codes.add(BattleContext.PROP_BEAN_UPPER_LIMIT_CODE);
			
			List<BattleContext> battleContexts = battleContextService.findAllByCodeIn(codes);
			String millisec = "1000";
			String rangeMax = "100";
			String rangeMin = "10";
			String unit = "1";
			String upperLimit = "10000";
			String schedule = "10000";
			for(BattleContext battleContext:battleContexts){
				if(battleContext.equals(BattleContext.PROP_BEAN_MILLISEC_CODE)){
					millisec = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_BEAN_RANAGE_MAX_CODE)){
					rangeMax = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_BEAN_RANAGE_MIN_CODE)){
					rangeMin = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_BEAN_SCHEDULE_CODE)){
					schedule = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_BEAN_UNIT_CODE)){
					unit = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_BEAN_UPPER_LIMIT_CODE)){
					upperLimit = battleContext.getValue();
				}
			}
			
			
			propBean = new PropBean();
			propBean.setMillisec(Long.parseLong(millisec));
			propBean.setPropId(propId);
			propBean.setRangeMax(Long.parseLong(rangeMax));

			propBean.setRangeMin(Long.parseLong(rangeMin));
			propBean.setStartDatetime(new DateTime());
			propBean.setUnit(Integer.parseInt(unit));
			propBean.setUnitName("");
			propBean.setUpperLimit(Long.parseLong(upperLimit));
			propBean.setSchedule(Long.parseLong(schedule));
			propBean = propBeanService.add(propBean);
		}else{
			
			if(prop.getBeanStatus()==Constant.PROP_COOLING_STATUS){
				Long millisec = propBean.getMillisec();
				Integer unit = propBean.getUnit();
				DateTime startDatetime = propBean.getStartDatetime();
				Long upperLimit = propBean.getUpperLimit();
				
				DateTime nowDatetime = new DateTime();
				
				Long differ = nowDatetime.getMillis()-startDatetime.getMillis();
				
				long schedule = (differ/millisec)*unit+propBean.getSchedule();
				
				propBean.setStartDatetime(new DateTime());
				
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
