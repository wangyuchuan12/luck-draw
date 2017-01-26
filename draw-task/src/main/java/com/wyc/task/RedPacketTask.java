package com.wyc.task;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.service.other.RedPacketRefundService;

@Component
public class RedPacketTask {
	
	@Autowired
	private RedPacketService redPacketService;
	
	final static Logger logger = LoggerFactory.getLogger(RedPacketTask.class);
	
	@Autowired
	private RedPacketRefundService redPacketRefundService;
	@Scheduled(cron = "0 0/30 * * * ?")
	public void timeOutCheck(){
		
		Sort sort = new Sort(Direction.DESC,"handTime");
		PageRequest pageRequest = new PageRequest(0, 500,sort);
		Page<RedPacket> redPackets = redPacketService.findAllByIsTimeout(0,pageRequest);
		
		for(RedPacket redPacket:redPackets){
			handleRedPacketTimeOut(redPacket);
		}

	}
	
	@Scheduled(cron = "59 0/31 * * * ?")
	public void refund(){
		Sort sort = new Sort(Direction.DESC,"handTime");
		PageRequest pageRequest = new PageRequest(0, 550,sort);
		Page<RedPacket> redPackets = redPacketService.findAllByIsReceiveAndIsTimeoutAndIsPayAndIsRefundAndIsRefundError(0,1,1,0,0,pageRequest);
		
		for(RedPacket redPacket:redPackets){
			try{
				redPacketRefundService.refund(redPacket);
			}catch(Exception e){
				e.printStackTrace();
				logger.error("has an error of refund redpacket{}",e);
			}
			
		}
	}
	
	
	private void handleRedPacketTimeOut(RedPacket redPacket){

		DateTime handTime = redPacket.getHandTime();
		
		int timeLong = redPacket.getTimeLong();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(handTime.toDate());
        calendar.add(Calendar.HOUR, timeLong);
        
        if(calendar.getTime().getTime()<new Date().getTime()){
        	redPacket.setIsTimeout(1);
        	redPacketService.update(redPacket);
        }
	}
	
}
