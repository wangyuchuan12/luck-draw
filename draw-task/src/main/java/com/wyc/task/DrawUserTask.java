package com.wyc.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wyc.common.service.AccountService;

@Component
public class DrawUserTask {
	
	@Autowired
	private AccountService accountService;
	@Scheduled(cron = "0 0 0 1 * ?")
	public void handleTakeOut(){
		accountService.initDrawUserCanTakeOutCount(3);
	}
}
