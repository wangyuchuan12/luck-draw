package com.wyc.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wyc.draw.service.DrawUserService;

@Component
public class DrawUserTask {
	
	@Autowired
	private DrawUserService drawUserService;
	@Scheduled(cron = "0 0 0 1 * ?")
	public void handleTakeOut(){
		drawUserService.initDrawUserCanTakeOutCount(3);
	}
}
