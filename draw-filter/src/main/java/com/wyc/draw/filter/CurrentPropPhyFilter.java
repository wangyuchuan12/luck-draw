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
import com.wyc.draw.domain.PropPhy;
import com.wyc.draw.service.BattleContextService;
import com.wyc.draw.service.PropPhyService;

public class CurrentPropPhyFilter extends Filter{

	@Autowired
	private PropPhyService propPhyService;
	
	@Autowired
	private BattleContextService battleContextService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Prop prop = sessionManager.getObject(Prop.class);
		String propId = prop.getId();
		PropPhy propPhy = propPhyService.findOneByPropId(propId);
		if(propPhy==null){
			
			List<String> codes = new ArrayList<>();
			codes.add(BattleContext.PROP_PHY_MILLISEC_CODE);
			codes.add(BattleContext.PROP_PHY_RANAGE_MAX_CODE);
			codes.add(BattleContext.PROP_PHY_RANAGE_MIN_CODE);
			codes.add(BattleContext.PROP_PHY_SCHEDULE_CODE);
			codes.add(BattleContext.PROP_PHY_UNIT_CODE);
			codes.add(BattleContext.PROP_PHY_UPPER_LIMIT_CODE);
			
			List<BattleContext> battleContexts = battleContextService.findAllByCodeIn(codes);
			
			String millisec = "1000";
			String rangeMax = "100";
			String rangeMin = "10";
			String unit = "1";
			String upperLimit = "10000";
			String schedule = "10000";
			for(BattleContext battleContext:battleContexts){
				if(battleContext.equals(BattleContext.PROP_PHY_MILLISEC_CODE)){
					millisec = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_PHY_RANAGE_MAX_CODE)){
					rangeMax = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_PHY_RANAGE_MIN_CODE)){
					rangeMin = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_PHY_SCHEDULE_CODE)){
					schedule = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_PHY_UNIT_CODE)){
					unit = battleContext.getValue();
				}else if(battleContext.equals(BattleContext.PROP_PHY_UPPER_LIMIT_CODE)){
					upperLimit = battleContext.getValue();
				}
			}
			
			propPhy = new PropPhy();
			propPhy.setMillisec(Long.parseLong(millisec));
			propPhy.setPropId(propId);
			propPhy.setRangeMax(Long.parseLong(rangeMax));
			propPhy.setRangeMin(Long.parseLong(rangeMin));
			propPhy.setStartDatetime(new DateTime());
			propPhy.setUnit(Integer.parseInt(unit));
			propPhy.setUnitName("");
			propPhy.setUpperLimit(Long.parseLong(upperLimit));
			propPhy.setSchedule(Long.parseLong(schedule));
			propPhy.setStartDatetime(new DateTime());
			propPhy = propPhyService.add(propPhy);
		}else{
			
			if(prop.getPhyStatus()==Constant.PROP_COOLING_STATUS){
				Long millisec = propPhy.getMillisec();
				Integer unit = propPhy.getUnit();
				DateTime startDatetime = propPhy.getStartDatetime();
				Long upperLimit = propPhy.getUpperLimit();
				
				DateTime nowDatetime = new DateTime();
				
				Long differ = nowDatetime.getMillis()-startDatetime.getMillis();
				
				long schedule = (differ/millisec)*unit+propPhy.getSchedule();

				propPhy.setStartDatetime(new DateTime());
				if(schedule<upperLimit){
					prop.setPhyStatus(Constant.PROP_COOLING_STATUS);
					propPhy.setSchedule(schedule);
				}else{
					prop.setPhyStatus(Constant.PROP_COMPLETE_STATUS);
					propPhy.setSchedule(upperLimit);
				}
			}else{
				propPhy.setSchedule(propPhy.getUpperLimit());
				propPhy.setStartDatetime(new DateTime());
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
