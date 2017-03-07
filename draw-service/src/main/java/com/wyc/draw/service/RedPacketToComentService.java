package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.RedPacketToComent;
import com.wyc.draw.repositories.RedPacketToComentRepository;

@Service
public class RedPacketToComentService {

	@Autowired
	private RedPacketToComentRepository redPacketToComentRepository;

	public RedPacketToComent findByRedPacketId(String redPacketId) {
		return redPacketToComentRepository.findByRedPacketId(redPacketId);
	}
	
	public RedPacketToComent commentRedPacket(RedPacketToComent redPacketToComent , 
			int accordStar , 
			int usefulStar, 
			int interestingStar,
			int type){
		
		if(accordStar==1){
			redPacketToComent.setAccordStar1Num(redPacketToComent.getAccordStar1Num()+1);
		}else if(accordStar==2){
			redPacketToComent.setAccordStar2Num(redPacketToComent.getAccordStar2Num()+1);
		}else if(accordStar==3){
			redPacketToComent.setAccordStar3Num(redPacketToComent.getAccordStar3Num()+1);
		}else if(accordStar==4){
			redPacketToComent.setAccordStar4Num(redPacketToComent.getAccordStar4Num()+1);
		}else if(accordStar==5){
			redPacketToComent.setAccordStar5Num(redPacketToComent.getAccordStar5Num()+1);
		}
		
		if(usefulStar==1){
			redPacketToComent.setUsefulStar1Num(redPacketToComent.getUsefulStar1Num()+1);
		}else if(usefulStar==2){
			redPacketToComent.setUsefulStar2Num(redPacketToComent.getUsefulStar2Num()+1);
		}else if(usefulStar==3){
			redPacketToComent.setUsefulStar3Num(redPacketToComent.getUsefulStar3Num()+1);
		}else if(usefulStar==4){
			redPacketToComent.setUsefulStar4Num(redPacketToComent.getUsefulStar4Num()+1);
		}else if(usefulStar==5){
			redPacketToComent.setUsefulStar5Num(redPacketToComent.getUsefulStar5Num()+1);
		}
		
		if(interestingStar==1){
			redPacketToComent.setInterestingStar1Num(redPacketToComent.getInterestingStar1Num()+1);
		}else if(interestingStar==2){
			redPacketToComent.setInterestingStar2Num(redPacketToComent.getInterestingStar2Num()+1);
		}else if(interestingStar==3){
			redPacketToComent.setInterestingStar3Num(redPacketToComent.getInterestingStar3Num()+1);
		}else if(interestingStar==4){
			redPacketToComent.setInterestingStar4Num(redPacketToComent.getInterestingStar4Num()+1);
		}else if(interestingStar==5){
			redPacketToComent.setInterestingStar5Num(redPacketToComent.getInterestingStar5Num()+1);
		}
		
		if(type==0){
			redPacketToComent.setGoodCommentNum(redPacketToComent.getGoodCommentNum()+1);
		}else if(type==1){
			redPacketToComent.setBadCommentNum(redPacketToComent.getBadCommentNum()+1);
		}
		
		redPacketToComent.setUpdateAt(new DateTime());
		return redPacketToComentRepository.save(redPacketToComent);
	}

	public RedPacketToComent add(RedPacketToComent redPacketToComent) {
		
		redPacketToComent.setId(UUID.randomUUID().toString());
		redPacketToComent.setUpdateAt(new DateTime());
		redPacketToComent.setCreateAt(new DateTime());
		
		return redPacketToComentRepository.save(redPacketToComent);
	}
}
