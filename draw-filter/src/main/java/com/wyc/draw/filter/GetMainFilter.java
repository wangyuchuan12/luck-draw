package com.wyc.draw.filter;
import java.util.ArrayList;
import java.util.List;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;

public class GetMainFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(GetMainImgFilter.class);
		
		filters.add(GetMainRoomFilter.class);
		
		filters.add(GetMainRedPacketFilter.class);
		
		filters.add(BaseDrawActionFilter.class);
		return filters;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
