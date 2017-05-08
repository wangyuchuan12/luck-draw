package com.wyc.common.filter.manager;
import java.lang.reflect.Method;

import com.wyc.common.session.SessionManager;

public class FilterEntryHandler {

	private FilterEntry filterEntry;
	
	private SessionManager sessionManager;
	public FilterEntryHandler(FilterEntry filterEntry,SessionManager sessionManager){
		this.filterEntry = filterEntry;
		this.sessionManager = sessionManager;
	}
	
	public Object executePre()throws Exception{
		Object  handlePreReturnValue = null;
		Method[] methods = filterEntry.getFilter().getClass().getDeclaredMethods();
		for(Method method:methods){
			if(method.getName().startsWith("handlerPre")){
				Object returnValue = method.invoke(filterEntry.getFilter(), sessionManager);
				if(method.getName().equals("handlerPre")){
					handlePreReturnValue = returnValue;
				}
			}
		}
		return handlePreReturnValue;
	}
	
	public Object executeHandler()throws Exception{
		Object returnValue = filterEntry.getFilter().handlerFilter(sessionManager);
		
		sessionManager.save(returnValue);
		
		return returnValue;
	}

	public Object executeAfter() throws Exception{
		
		Object handlerAfterReturnValue = null;
		Method[] methods = filterEntry.getFilter().getClass().getDeclaredMethods();
		for(Method method:methods){
			if(method.getName().startsWith("handlerAfter")){
				Object returnValue = method.invoke(filterEntry.getFilter(), sessionManager);
				if(method.getName().equals("handlerAfter")){
					handlerAfterReturnValue = returnValue;
				}
			}
		}
		return handlerAfterReturnValue;
	}
}
