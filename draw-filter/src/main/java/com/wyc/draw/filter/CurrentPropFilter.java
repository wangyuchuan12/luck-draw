package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.Prop;
import com.wyc.draw.service.PropService;

public class CurrentPropFilter extends Filter{

	@Autowired
	private PropService propService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		DrawUser drawUser = sessionManager.getObject(DrawUser.class);
		Prop prop = propService.findOneByDrawUserId(drawUser.getId());
		if(prop==null){
			prop = new Prop();
			prop.setBeanStatus(Constant.PROP_COOLING_STATUS);
			prop.setPhyStatus(Constant.PROP_COOLING_STATUS);
			prop.setRandomStatus(Constant.PROP_COOLING_STATUS);
			prop.setLoveStatus(Constant.PROP_COOLING_STATUS);
			prop.setDrawUserId(drawUser.getId());
			prop.setGenerateBeanCount(0L);
			prop.setGenerateLoveCount(0L);
			prop.setGeneratePhyCount(0L);
			prop.setGenerateRandomCount(0L);
			prop.setOpenid(drawUser.getOpenid());
			propService.add(prop);
		}
		return prop;
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
