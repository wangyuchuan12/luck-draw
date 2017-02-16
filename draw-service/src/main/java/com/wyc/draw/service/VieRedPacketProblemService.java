package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.VieRedPacketProblem;
import com.wyc.draw.repositories.VieRedPacketProblemRepository;

@Service
public class VieRedPacketProblemService {

	@Autowired
	private VieRedPacketProblemRepository vieRedPacketProblemRepository;

	public VieRedPacketProblem add(VieRedPacketProblem vieRedPacketProblem) {
		vieRedPacketProblem.setId(UUID.randomUUID().toString());
		
		vieRedPacketProblem.setCreateAt(new DateTime());
		
		vieRedPacketProblem.setUpdateAt(new DateTime());
		
		vieRedPacketProblemRepository.save(vieRedPacketProblem);
		
		return vieRedPacketProblem;
	}

	public VieRedPacketProblem findOne(String id) {
		
		return vieRedPacketProblemRepository.findOne(id);
	}

	public VieRedPacketProblem update(VieRedPacketProblem vieRedPacketProblem) {
		vieRedPacketProblem.setUpdateAt(new DateTime());
		return vieRedPacketProblemRepository.save(vieRedPacketProblem);
		
	}

	public Long coutByRedPacketId(String redPacketId) {
		return vieRedPacketProblemRepository.coutByRedPacketId(redPacketId);
	}

	public VieRedPacketProblem findOneByPreviousProblemId(String previousProblemId) {
		return vieRedPacketProblemRepository.findOneByPreviousProblemId(previousProblemId);
	}

	public List<VieRedPacketProblem> findFirstByRedPacketId(String redPacketId) {
		return vieRedPacketProblemRepository.findFirstByRedPacketId(redPacketId);
	}

	public List<VieRedPacketProblem> findAllByRedPacketIdOrderBySeqAsc(String redPacketId) {
		return vieRedPacketProblemRepository.findAllByRedPacketIdOrderBySeqAsc(redPacketId);
	}

	public VieRedPacketProblem getFirstByRedPacketId(String redPacketId) {
		return vieRedPacketProblemRepository.getFirstByRedPacketId(redPacketId);
	}
	
	public VieRedPacketProblem getLastByRedPacketId(String redPacketId) {
		return vieRedPacketProblemRepository.getLastByRedPacketId(redPacketId);
	}

	public VieRedPacketProblem findOneByRedPacketIdAndSeq(String redPacketId, int currentSeq) {
		return vieRedPacketProblemRepository.findOneByRedPacketIdAndSeq(redPacketId,currentSeq);
	}
}
