package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.VieRedPacketTakepartMemberRecord;
import com.wyc.draw.repositories.VieRedPacketTakepartMemberRecordRepository;

@Service
public class VieRedPacketTakepartMemberRecordService {
	@Autowired
	private VieRedPacketTakepartMemberRecordRepository vieRedPacketTakepartMemberRecordRepository;

	public VieRedPacketTakepartMemberRecord add(VieRedPacketTakepartMemberRecord vieRedPacketTakepartMemberRecord) {
		vieRedPacketTakepartMemberRecord.setId(UUID.randomUUID().toString());
		vieRedPacketTakepartMemberRecord.setCreateAt(new DateTime());
		vieRedPacketTakepartMemberRecord.setUpdateAt(new DateTime());
		
		return vieRedPacketTakepartMemberRecordRepository.save(vieRedPacketTakepartMemberRecord);
		
	}
}
