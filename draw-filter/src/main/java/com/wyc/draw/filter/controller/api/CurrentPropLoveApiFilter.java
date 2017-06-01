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
import com.wyc.draw.domain.PropLove;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.CurrentPropFilter;
import com.wyc.draw.filter.CurrentPropLoveFilter;

public class CurrentPropLoveApiFilter extends Filter{

	@Autowired
	private MyLongDateFormat myLongDateFormat;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Prop prop = sessionManager.getObject(Prop.class);
		PropLove propLove = sessionManager.getObject(PropLove.class);
		Map<String, Object> data = new HashMap<>();
		data.put("status", prop.getLoveStatus());
		data.put("generateCount", prop.getGenerateLoveCount());
		data.put("millisec", propLove.getMillisec());
		data.put("propId", propLove.getPropId());
		data.put("rangeMax", propLove.getRangeMax());
		data.put("rangeMin", propLove.getRangeMin());
		data.put("unit", propLove.getUnit());
		data.put("unitName", propLove.getUnitName());
		data.put("upperLimit", propLove.getUpperLimit());
		data.put("startDatetime", myLongDateFormat.format(propLove.getStartDatetime().toDate()));
		data.put("nowDatetime", myLongDateFormat.format(new Date()));
		data.put("schedule", propLove.getSchedule());
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(data);
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		classes.add(CurrentPropFilter.class);
		classes.add(CurrentPropLoveFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
