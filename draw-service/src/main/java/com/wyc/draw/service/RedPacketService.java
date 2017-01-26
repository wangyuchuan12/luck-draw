package com.wyc.draw.service;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.repositories.RedPackageRepository;

@Service
public class RedPacketService {
	
	@Autowired
	private RedPackageRepository redPackageRepository;

	public RedPacket add(RedPacket redPacket) {
		redPacket.setId(UUID.randomUUID().toString());
		redPacket.setCreateAt(new DateTime());
		redPacket.setUpdateAt(new DateTime());
		return redPackageRepository.save(redPacket);
	}

	public RedPacket findOne(String id) {
		return redPackageRepository.findOne(id);
	}

	public RedPacket update(RedPacket redPacket) {
		redPacket.setUpdateAt(new DateTime());
		redPackageRepository.save(redPacket);
		return redPacket;
		
	}

	public Page<RedPacket> findAllByDrawRoomId(String roomId, Pageable pageable) {
		return redPackageRepository.findAllByDrawRoomId(roomId,pageable);
	}

	public List<RedPacket> findAllOfMainByPeriodId(String periodId) {
		
		return redPackageRepository.findAllOfMainByPeriodId(periodId);
	}

	//所有我发起的
	public Page<RedPacket> findAllByHandDrawUserId(String drawUserId,Pageable pageable) {
		return redPackageRepository.findAllByHandDrawUserId(drawUserId,pageable);
	}

	
	
	//所有我参与的红包
	public List<RedPacket> findAllOfRelatedToDrawUserId(String drawUserId,int start,int limit){
		return redPackageRepository.findAllOfRelatedToDrawUserId(drawUserId,start,limit);
	}
	//我参与的红包
	public Page<RedPacket> findAllByHandDrawUserIdOfTakepart(String drawUserId,Pageable pageable) {
		return redPackageRepository.findAllByHandDrawUserIdOfTakepart(drawUserId,pageable);
	}


	public Page<RedPacket> findAllByIsTimeout(int isTimeout, Pageable pageable) {
		return redPackageRepository.findAllByIsTimeout(isTimeout,pageable);
	}

	public Page<RedPacket> findAllByIsReceiveAndIsTimeoutAndIsPayAndIsRefundAndIsRefundError(int isReceive, int isTimeout, int isPay, int isRefund,int isRefundError,
			Pageable pageable) {
		return redPackageRepository.findAllByIsReceiveAndIsTimeoutAndIsPayAndIsRefundAndIsRefundError(isReceive,isTimeout,isPay,isRefund,isRefundError,pageable);
	}
}
