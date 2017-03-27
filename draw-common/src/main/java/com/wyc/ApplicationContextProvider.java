package com.wyc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class ApplicationContextProvider{
    private static ApplicationContext context;

    public ApplicationContextProvider() {
		System.out.println("......................ApplicationContextProvider");
	}

    public static ApplicationContext getApplicationContext() {
        return context;
    }
    
//    @Override
//    public void setApplicationContext(ApplicationContext ctx) {
//        context = ctx;
//    }
}
