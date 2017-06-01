package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.MyLongDateFormat;
import com.wyc.draw.domain.Prop;
import com.wyc.draw.domain.PropBean;
import com.wyc.draw.domain.PropLove;
import com.wyc.draw.domain.PropPhy;
import com.wyc.draw.domain.PropRandom;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.CurrentPropBeanFilter;
import com.wyc.draw.filter.CurrentPropFilter;
import com.wyc.draw.filter.CurrentPropLoveFilter;
import com.wyc.draw.filter.CurrentPropPhyFilter;
import com.wyc.draw.filter.CurrentPropRandomFilter;

public class CurrentPropApiFilter extends Filter{

	@Autowired
	private MyLongDateFormat myLongDateFormat;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Prop prop = sessionManager.getObject(Prop.class);
		PropLove propLove = sessionManager.getObject(PropLove.class);
		Map<String, Object> loveData = new HashMap<>();
		loveData.put("status", prop.getLoveStatus());
		loveData.put("generateCount", prop.getGenerateLoveCount());
		loveData.put("millisec", propLove.getMillisec());
		loveData.put("propId", propLove.getPropId());
		loveData.put("rangeMax", propLove.getRangeMax());
		loveData.put("rangeMin", propLove.getRangeMin());
		loveData.put("unit", propLove.getUnit());
		loveData.put("unitName", propLove.getUnitName());
		loveData.put("upperLimit", propLove.getUpperLimit());
		loveData.put("startDatetime", myLongDateFormat.format(propLove.getStartDatetime().toDate()));
		loveData.put("nowDatetime", myLongDateFormat.format(new Date()));
		loveData.put("schedule", propLove.getSchedule());

		
		
		PropBean propBean = sessionManager.getObject(PropBean.class);
		Map<String, Object> beanData = new HashMap<>();
		beanData.put("status", prop.getLoveStatus());
		beanData.put("generateCount", prop.getGenerateLoveCount());
		beanData.put("millisec", propBean.getMillisec());
		beanData.put("propId", propBean.getPropId());
		beanData.put("rangeMax", propBean.getRangeMax());
		beanData.put("rangeMin", propBean.getRangeMin());
		beanData.put("unit", propBean.getUnit());
		beanData.put("unitName", propBean.getUnitName());
		beanData.put("upperLimit", propBean.getUpperLimit());
		beanData.put("startDatetime", myLongDateFormat.format(propBean.getStartDatetime().toDate()));
		beanData.put("nowDatetime", myLongDateFormat.format(new Date()));
		beanData.put("schedule", propBean.getSchedule());
		
		
		
		PropPhy propPhy = sessionManager.getObject(PropPhy.class);
		Map<String, Object> phyData = new HashMap<>();
		phyData.put("status", prop.getLoveStatus());
		phyData.put("generateCount", prop.getGenerateLoveCount());
		phyData.put("millisec", propPhy.getMillisec());
		phyData.put("propId", propPhy.getPropId());
		phyData.put("rangeMax", propPhy.getRangeMax());
		phyData.put("rangeMin", propPhy.getRangeMin());
		phyData.put("unit", propPhy.getUnit());
		phyData.put("unitName", propPhy.getUnitName());
		phyData.put("upperLimit", propPhy.getUpperLimit());
		phyData.put("startDatetime", myLongDateFormat.format(propPhy.getStartDatetime().toDate()));
		phyData.put("nowDatetime", myLongDateFormat.format(new Date()));
		phyData.put("schedule", propPhy.getSchedule());
		
		
		PropRandom propRandom = sessionManager.getObject(PropRandom.class);
		Map<String, Object> randomData = new HashMap<>();
		randomData.put("status", prop.getLoveStatus());
		randomData.put("generateCount", prop.getGenerateLoveCount());
		randomData.put("millisec", propRandom.getMillisec());
		randomData.put("propId", propRandom.getPropId());
		randomData.put("beanRangeMax", propRandom.getBeanRangeMax());
		randomData.put("beanRangeMin", propRandom.getBeanRangeMin());
		
		randomData.put("loveRangeMax", propRandom.getLoveRangeMax());
		randomData.put("loveRangeMin", propRandom.getLoveRangeMin());
		
		randomData.put("moneyRangeMax", propRandom.getMoneyRangeMax());
		randomData.put("moneyRangeMin", propRandom.getMoneyRangeMin());
		
		randomData.put("unit", propRandom.getUnit());
		randomData.put("unitName", propRandom.getUnitName());
		randomData.put("upperLimit", propRandom.getUpperLimit());
		randomData.put("startDatetime", myLongDateFormat.format(propRandom.getStartDatetime().toDate()));
		randomData.put("nowDatetime", myLongDateFormat.format(new Date()));
		randomData.put("schedule", propRandom.getSchedule());
		
		Map<String, Object> data = new HashMap<>();
		
		data.put("bean", beanData);
		data.put("love", loveData);
		data.put("phy", phyData);
		data.put("random", randomData);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(data);
		
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		classes.add(CurrentPropFilter.class);
		classes.add(CurrentPropBeanFilter.class);
		classes.add(CurrentPropLoveFilter.class);
		classes.add(CurrentPropPhyFilter.class);
		classes.add(CurrentPropRandomFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
