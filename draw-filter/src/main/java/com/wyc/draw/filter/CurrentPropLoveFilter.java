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
import com.wyc.draw.domain.PropLove;
import com.wyc.draw.service.BattleContextService;
import com.wyc.draw.service.PropLoveService;

public class CurrentPropLoveFilter extends Filter{
	@Autowired
	private PropLoveService propLoveService;
	
	@Autowired
	private BattleContextService battleContextService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Prop prop = sessionManager.getObject(Prop.class);
		String propId = prop.getId();
		PropLove propLove = propLoveService.findOneByPropId(propId);
		if(propLove==null){
			
			List<String> codes = new ArrayList<>();
			
			codes.add(BattleContext.PROP_LOVE_MILLISEC_CODE);
			codes.add(BattleContext.PROP_LOVE_RANAGE_MAX_CODE);
			codes.add(BattleContext.PROP_LOVE_RANAGE_MIN_CODE);
			codes.add(BattleContext.PROP_LOVE_SCHEDULE_CODE);
			codes.add(BattleContext.PROP_LOVE_UNIT_CODE);
			codes.add(BattleContext.PROP_LOVE_UPPER_LIMIT_CODE);
			List<BattleContext> battleContexts = battleContextService.findAllByCodeIn(codes);
			
			String millisec = "1000";
			String rangeMax = "100";
			String rangeMin = "10";
			String unit = "1";
			String upperLimit = "10000";
			String schedule = "10000";
			for(BattleContext battleContext:battleContexts){
				if(battleContext.equals(BattleContext.PROP_LOVE_MILLISEC_CODE)){
					millisec = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_LOVE_RANAGE_MAX_CODE)){
					rangeMax = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_LOVE_RANAGE_MIN_CODE)){
					rangeMin = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_LOVE_SCHEDULE_CODE)){
					schedule = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_LOVE_UNIT_CODE)){
					unit = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_LOVE_UPPER_LIMIT_CODE)){
					upperLimit = battleContext.getValue();
				}
			}
			
			
			propLove = new PropLove();
			propLove.setMillisec(Long.parseLong(millisec));
			propLove.setPropId(propId);
			propLove.setRangeMax(Long.parseLong(rangeMax));
			propLove.setRangeMin(Long.parseLong(rangeMin));
			propLove.setStartDatetime(new DateTime());
			propLove.setUnit(Integer.parseInt(unit));
			propLove.setUnitName("");
			propLove.setUpperLimit(Long.parseLong(upperLimit));
			propLove.setSchedule(Long.parseLong(schedule));
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
