package com.wyc.draw.filter.controller.action;
import java.util.ArrayList;
import java.util.List;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.CurrentVieRedPacketToTakepartMemberFilter;
import com.wyc.draw.filter.GetMultipleCommentFilter;
import com.wyc.draw.filter.GetMyCommentFilter;
import com.wyc.draw.filter.GetRedPackInfoFilter;
import com.wyc.draw.filter.GetRedPacketOptionsByRedPacketIdFilter;
import com.wyc.draw.filter.GetVieRedPacketTakepartMemberListByRedPacketOfPageFilter;
import com.wyc.draw.filter.RedPacketAmountDistributionFilter;
import com.wyc.draw.filter.controller.param.VieDrawInfoParamFilter;
import com.wyc.draw.filter.test.GetRedPacketFilter;
import com.wyc.draw.filter.test.RedPacketReceiveAbleTestFilter;

public class VieDrawInfoActionFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		System.out.println("...............VieDrawInfoActionFilter");
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(BaseDrawActionFilter.class);
		filterClasses.add(VieDrawInfoParamFilter.class);
		filterClasses.add(CurrentVieRedPacketToTakepartMemberFilter.class);
		
		filterClasses.add(GetRedPacketFilter.class);
		
		filterClasses.add(RedPacketReceiveAbleTestFilter.class);
		
		filterClasses.add(GetVieRedPacketTakepartMemberListByRedPacketOfPageFilter.class);
		
		filterClasses.add(GetRedPacketOptionsByRedPacketIdFilter.class);
		
		
		filterClasses.add(GetRedPackInfoFilter.class);
		filterClasses.add(RedPacketAmountDistributionFilter.class);
		filterClasses.add(GetMyCommentFilter.class);
		filterClasses.add(GetMultipleCommentFilter.class);
		return filterClasses;
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
