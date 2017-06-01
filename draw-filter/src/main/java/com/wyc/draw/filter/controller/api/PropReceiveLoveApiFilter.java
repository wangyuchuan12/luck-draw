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
import com.wyc.draw.domain.PropLove;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.CurrentPropFilter;
import com.wyc.draw.filter.CurrentPropLoveFilter;

public class PropReceiveLoveApiFilter extends Filter{

	@Autowired
	private AccountService accountService;

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Prop prop = (Prop)sessionManager.getObject(Prop.class);
		PropLove propLove = (PropLove)sessionManager.getObject(PropLove.class);
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		Account account = accountService.fineOneSync(drawUser.getAccountId());
		
		Long randMin = propLove.getRangeMin();
		Long randMax = propLove.getRangeMax();
		
		Random random = new Random();
		
		//取一个范围的随机数
		Long num = random.nextInt(randMax.intValue())%(randMax-randMin+1)+randMin.longValue();
		
		if(account.getLoveLife()+num<=account.getLoveLifeLimit()){
			account.setLoveLife(account.getLoveLife().intValue()+num.intValue());
		}else{
			account.setLoveLife(account.getLoveLifeLimit());
			num = account.getLoveLifeLimit().longValue()-account.getLoveLife();
		}
		
		accountService.update(account);
		prop.setLoveStatus(Constant.PROP_COOLING_STATUS);
		propLove.setSchedule(0l);
		propLove.setStartDatetime(new DateTime());
		
		sessionManager.update(propLove);
		sessionManager.update(prop);
		
		Map<String, Object> data = new HashMap<>();
		data.put("num", num);
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
		classes.add(CurrentPropLoveFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
