package com.wyc.draw.service;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.DekornToTakepartMember;
import com.wyc.draw.repositories.DekornToTakepartMemberRepository;
import com.wyc.draw.service.redis.RedisService;

@Service
public class DekornToTakepartMemberService{

	@Autowired
	private DekornToTakepartMemberRepository dekornToTakepartMemberRepository;
	
	@Autowired
	private RedisService redisService;
	

	public DekornToTakepartMember findOneByDekornIdAndDrawUserId(String dekornId, String drawUserId) {
		String key = "dekornToTakepartMemberService:findOneByDekornIdAndDrawUserId_"+dekornId+"_"+drawUserId;
		DekornToTakepartMember dekornToTakepartMember = redisService.getObject(key, DekornToTakepartMember.class);
		
		if(dekornToTakepartMember==null){
			dekornToTakepartMember = dekornToTakepartMemberRepository.findOneByDekornIdAndDrawUserId(dekornId,drawUserId);
		}
		
		if(dekornToTakepartMember!=null){
			try{
				redisService.setObject(key, dekornToTakepartMember);
			}catch(Exception e){
				
			}
			
		}
		
		return dekornToTakepartMember;
	}

	public void add(DekornToTakepartMember dekornToTakepartMember) {

		synchronized(DekornToTakepartMember.class){
			//为了避免重复插入
			DekornToTakepartMember dekornToTakepartMember2 = findOneByDekornIdAndDrawUserId(dekornToTakepartMember.getDekornId(), dekornToTakepartMember.getDrawUserId());
			if(dekornToTakepartMember2!=null){
				return;
			}
			dekornToTakepartMember.setUpdateAt(new DateTime());
			dekornToTakepartMember.setCreateAt(new DateTime());
			dekornToTakepartMember.setId(UUID.randomUUID().toString());
			dekornToTakepartMemberRepository.save(dekornToTakepartMember);
			String key = "dekornToTakepartMemberService:findOneByDekornIdAndDrawUserId_"+dekornToTakepartMember.getDekornId()+"_"+dekornToTakepartMember.getDrawUserId();

			try{
				redisService.setObject(key, dekornToTakepartMember);
			}catch(Exception e){
				
			}
			
		}
		
		
	}

	public DekornToTakepartMember update(DekornToTakepartMember dekornToTakepartMember) {
		dekornToTakepartMember.setUpdateAt(new DateTime());
		dekornToTakepartMember =  dekornToTakepartMemberRepository.save(dekornToTakepartMember);
		
		String key = "dekornToTakepartMemberService:findOneByDekornIdAndDrawUserId_"+dekornToTakepartMember.getDekornId()+"_"+dekornToTakepartMember.getDrawUserId();

		try{
			redisService.setObject(key, dekornToTakepartMember);
		}catch(Exception e){
			
		}
		
		return dekornToTakepartMember;
		
		
	}
}
