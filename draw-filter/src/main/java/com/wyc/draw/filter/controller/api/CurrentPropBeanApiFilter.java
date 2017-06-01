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
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.CurrentPropBeanFilter;
import com.wyc.draw.filter.CurrentPropFilter;

public class CurrentPropBeanApiFilter extends Filter{

	@Autowired
	private MyLongDateFormat myLongDateFormat;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Prop prop = sessionManager.getObject(Prop.class);
		PropBean propBean = sessionManager.getObject(PropBean.class);
		Map<String, Object> data = new HashMap<>();
		data.put("status", prop.getLoveStatus());
		data.put("generateCount", prop.getGenerateLoveCount());
		data.put("millisec", propBean.getMillisec());
		data.put("propId", propBean.getPropId());
		data.put("rangeMax", propBean.getRangeMax());
		data.put("rangeMin", propBean.getRangeMin());
		data.put("unit", propBean.getUnit());
		data.put("unitName", propBean.getUnitName());
		data.put("upperLimit", propBean.getUpperLimit());
		data.put("startDatetime", myLongDateFormat.format(propBean.getStartDatetime().toDate()));
		data.put("nowDatetime", myLongDateFormat.format(new Date()));
		data.put("schedule", propBean.getSchedule());
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
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
