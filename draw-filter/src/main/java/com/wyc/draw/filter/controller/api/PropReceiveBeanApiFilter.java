package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.Account;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.AccountService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.Prop;
import com.wyc.draw.domain.PropBean;
import com.wyc.draw.domain.PropPhy;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.CurrentPropBeanFilter;
import com.wyc.draw.filter.CurrentPropFilter;
import com.wyc.draw.filter.CurrentPropPhyFilter;

public class PropReceiveBeanApiFilter extends Filter{

	@Autowired
	private AccountService accountService;

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Prop prop = (Prop)sessionManager.getObject(Prop.class);
		PropBean propBean = sessionManager.getObject(PropBean.class);
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		Account account = accountService.fineOneSync(drawUser.getAccountId());
		
		
		PropPhy propPhy = sessionManager.getObject(PropPhy.class);
		
		Long schedulePhy = propPhy.getSchedule();
		if(schedulePhy==null){
			schedulePhy = 0l;
		}
		Long consumePhy = propBean.getCounsumePhy();
		if(consumePhy==null){
			consumePhy = 0l;
		}

		schedulePhy = schedulePhy - consumePhy;

		if(schedulePhy<0){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("体力不够");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(resultVo);
			return null;
		}
		
		propPhy.setSchedule(schedulePhy);
		
		Long randMin = propBean.getRangeMin();
		Long randMax = propBean.getRangeMax();
		
		Random random = new Random();
		
		//取一个范围的随机数
		Long num = random.nextInt(randMax.intValue())%(randMax-randMin+1)+randMin.longValue();
		
		if(account.getWisdomCount()+num<=account.getWisdomLimit()){
			account.setWisdomCount(account.getWisdomCount().intValue()+num);
		}else{
			account.setWisdomCount(account.getWisdomCount());
			num = account.getWisdomLimit().longValue()-account.getWisdomCount();
		}
		
		accountService.update(account);
		prop.setBeanStatus(Constant.PROP_COOLING_STATUS);
		prop.setPhyStatus(Constant.PROP_COOLING_STATUS);
		
		propBean.setSchedule(0l);
		propBean.setStartDatetime(new DateTime());
		
		propPhy.setStartDatetime(new DateTime());
		
		sessionManager.update(propBean);
		sessionManager.update(prop);
		sessionManager.update(propPhy);
		
		Map<String, Object> data = new HashMap<>();
		data.put("num", num);
		data.put("beanSchedule",propBean.getSchedule());
		data.put("phySchedule", propPhy.getSchedule());
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(data);;
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
		classes.add(CurrentPropPhyFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
