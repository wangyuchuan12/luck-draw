package com.wyc.draw.service;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.RedPacketOwner;
import com.wyc.draw.repositories.RedPacketOnwerRepository;

@Service
public class RedPacketOwnerService {

	@Autowired
	private RedPacketOnwerRepository redPacketOnwerRepository;

	public List<RedPacketOwner> findAllByDrawUserIdAndIsDel(String drawUserId, int isDel) {
		
		return redPacketOnwerRepository.findAllByDrawUserIdAndIsDel(drawUserId,isDel);
	}

	public RedPacketOwner findOneByDrawUserIdAndRedPacketId(String drawUserId, String redPacketId) {
		
		return redPacketOnwerRepository.findOneByDrawUserIdAndRedPacketId(drawUserId,redPacketId);
	}

	public void update(RedPacketOwner redPacketOwner) {
		redPacketOwner.setUpdateAt(new DateTime());
		
		redPacketOnwerRepository.save(redPacketOwner);
	}

	public List<RedPacketOwner> findAllByDrawUserIdAndIsMyselfAndIsDel(String drawUserId, Integer isMyself, int isDel) {
		return redPacketOnwerRepository.findAllByDrawUserIdAndIsMyselfAndIsDel(drawUserId,isMyself,isDel);
	}
	
	//获取该用户的所有红包id
	public List<String> redPacketIdsByDrawUserId(String drawUserId){
		return redPacketOnwerRepository.redPacketIdsByDrawUserId(drawUserId);
	}

	public void add(RedPacketOwner redPacketOwner) {
		redPacketOwner.setId(UUID.randomUUID().toString());
		
		redPacketOwner.setCreateAt(new DateTime());
		redPacketOwner.setUpdateAt(new DateTime());
		
		redPacketOnwerRepository.save(redPacketOwner);
		
	}
}
