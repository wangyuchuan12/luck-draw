package com.wyc.draw.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.BattleContext;
import com.wyc.draw.domain.Prop;
import com.wyc.draw.domain.PropRandom;
import com.wyc.draw.service.BattleContextService;
import com.wyc.draw.service.PropRandomService;

public class CurrentPropRandomFilter extends Filter{

	@Autowired
	private PropRandomService propRandomService;
	
	@Autowired
	private BattleContextService battleContextService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Prop prop = sessionManager.getObject(Prop.class);
		String propId = prop.getId();
		PropRandom propRandom = propRandomService.findOneByPropId(propId);
		if(propRandom==null){
			
			List<String> codes = new ArrayList<>();
			codes.add(BattleContext.PROP_RANDOM_MILLISEC_CODE);
			codes.add(BattleContext.PROP_RANDOM_BEAN_RANAGE_MAX_CODE);
			codes.add(BattleContext.PROP_RANDOM_BEAN_RANAGE_MIN_CODE);
			codes.add(BattleContext.PROP_RANDOM_LOVE_RANAGE_MAX_CODE);
			codes.add(BattleContext.PROP_RANDOM_LOVE_RANAGE_MIN_CODE);
			codes.add(BattleContext.PROP_RANDOM_SCHEDULE_CODE);
			codes.add(BattleContext.PROP_RANDOM_UNIT_CODE);
			codes.add(BattleContext.PROP_RANDOM_UPPER_LIMIT_CODE);
			List<BattleContext> battleContexts = battleContextService.findAllByCodeIn(codes);
			
			String millisec = "1000";
			String beanRangeMax = "20";
			String beanRangeMin = "10";
			
			String loveRangeMax = "20";
			String loveRangeMin = "10";
			
			String unit = "1";
			String upperLimit = "10000";
			String schedule = "10000";
			for(BattleContext battleContext:battleContexts){
				if(battleContext.equals(BattleContext.PROP_RANDOM_MILLISEC_CODE)){
					millisec = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_RANDOM_BEAN_RANAGE_MAX_CODE)){
					beanRangeMax = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_RANDOM_BEAN_RANAGE_MIN_CODE)){
					beanRangeMin = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_RANDOM_LOVE_RANAGE_MAX_CODE)){
					loveRangeMax = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_RANDOM_LOVE_RANAGE_MIN_CODE)){
					loveRangeMin = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_RANDOM_SCHEDULE_CODE)){
					schedule = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_RANDOM_UNIT_CODE)){
					unit = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_RANDOM_UPPER_LIMIT_CODE)){
					upperLimit = battleContext.getValue();
				}
			}
			
			propRandom = new PropRandom();
			propRandom.setMillisec(Long.parseLong(millisec));
			propRandom.setPropId(propId);
			propRandom.setBeanRangeMax(Long.parseLong(beanRangeMax));
			propRandom.setBeanRangeMin(Long.parseLong(beanRangeMin));
			propRandom.setLoveRangeMax(Long.parseLong(loveRangeMax));
			propRandom.setLoveRangeMin(Long.parseLong(loveRangeMin));
			propRandom.setMoneyRangeMax(new BigDecimal(0.5));
			propRandom.setMoneyRangeMin(new BigDecimal(0.1));
			propRandom.setStartDatetime(new DateTime());
			propRandom.setUnit(Integer.parseInt(unit));
			propRandom.setUnitName("");
			propRandom.setUpperLimit(Long.parseLong(upperLimit));
			propRandom.setSchedule(Long.parseLong(schedule));
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
