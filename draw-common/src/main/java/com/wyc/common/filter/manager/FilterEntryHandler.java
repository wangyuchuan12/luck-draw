package com.wyc.common.filter.manager;

import com.wyc.common.session.SessionManager;

public class FilterEntryHandler {

	private FilterEntry filterEntry;
	
	private SessionManager sessionManager;
	public FilterEntryHandler(FilterEntry filterEntry,SessionManager sessionManager){
		this.filterEntry = filterEntry;
		this.sessionManager = sessionManager;
	}
	
	public Object executePre()throws Exception{
		return filterEntry.getFilter().handlerPre(sessionManager);
	}
	
	public Object executeHandler()throws Exception{
		Object returnValue = filterEntry.getFilter().handlerFilter(sessionManager);
		
		sessionManager.save(returnValue);
		
		return returnValue;
	}

	public Object executeAfter() throws Exception{
		Object returnValue = filterEntry.getFilter().handlerAfter(sessionManager);
		return returnValue;
	}
}
