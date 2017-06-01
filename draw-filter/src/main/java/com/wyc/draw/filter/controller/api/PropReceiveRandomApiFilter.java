package com.wyc.draw.filter.controller.api;

import java.math.BigDecimal;
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
import com.wyc.draw.domain.PropRandom;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.CurrentPropFilter;
import com.wyc.draw.filter.CurrentPropRandomFilter;

public class PropReceiveRandomApiFilter extends Filter{

	@Autowired
	private AccountService accountService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Prop prop = (Prop)sessionManager.getObject(Prop.class);
		PropRandom propRandom = (PropRandom)sessionManager.getObject(PropRandom.class);
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		Account account = accountService.fineOneSync(drawUser.getAccountId());
		
		Long loveRandMin = propRandom.getLoveRangeMin();
		Long loveRandMax = propRandom.getLoveRangeMax();
		
		Long beanRandMin = propRandom.getBeanRangeMin();
		Long beanRandMax = propRandom.getBeanRangeMax();
		
		BigDecimal moneyRandMin = propRandom.getMoneyRangeMin();
		BigDecimal moneyRandMax = propRandom.getMoneyRangeMax();
		
		Random random = new Random();
		
		//取一个范围的随机数
		Long loveNum = random.nextInt(loveRandMax.intValue())%(loveRandMax-loveRandMin+1)+loveRandMax.longValue();
		Long beanNum = random.nextInt(beanRandMax.intValue())%(beanRandMax-beanRandMin+1)+beanRandMax.longValue();
		double moneyNum =(moneyRandMax.floatValue()+Math.random()*(moneyRandMax.floatValue()-moneyRandMin.floatValue()+1));
		
		if(account.getLoveLife()+loveNum<=account.getLoveLifeLimit()){
			account.setLoveLife(account.getLoveLife().intValue()+loveNum.intValue());
		}else{
			account.setLoveLife(account.getLoveLifeLimit());
		}
		
		if(account.getWisdomCount()+beanNum<=account.getWisdomLimit()){
			account.setWisdomCount(account.getWisdomCount().longValue()+beanNum.intValue());
		}else{
			account.setWisdomCount(account.getWisdomLimit());
		}
		
		
		
		accountService.update(account);
		prop.setRandomStatus(Constant.PROP_COOLING_STATUS);
		propRandom.setSchedule(0l);
		propRandom.setStartDatetime(new DateTime());
		
		sessionManager.update(propRandom);
		sessionManager.update(prop);
		
		Map<String, Object> data = new HashMap<>();
		data.put("loveNum", loveNum);
		data.put("beanNum", beanNum);
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
		classes.add(CurrentPropRandomFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
