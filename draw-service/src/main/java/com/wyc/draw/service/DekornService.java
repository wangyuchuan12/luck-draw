package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.repositories.DekornRepository;

@Service
public class DekornService {
	@Autowired
	private DekornRepository dekornRepository;

	public Dekorn findOne(String id) {
		return dekornRepository.findOne(id);
	}

	public Dekorn add(Dekorn dekorn) {
		dekorn.setId(UUID.randomUUID().toString());
		dekorn.setUpdateAt(new DateTime());
		dekorn.setCreateAt(new DateTime());
		
		return dekornRepository.save(dekorn);
		
		
		
	}

	public Long countByGameIdAndBiggerThanPassScoreAndStatus(String gameId, Long passScoreLong,
			int dekornProgressStatus) {
		return dekornRepository.countByGameIdAndBiggerThanPassScoreAndStatus(gameId,passScoreLong,dekornProgressStatus);
	}
	
	public List<Dekorn> findAllByGameIdAndBiggerThanPassScoreAndStatus(@Param("gameId")String gameId,
			@Param("passScore")Long passScore,
			@Param("status")int status,Pageable pageable){
		return dekornRepository.findAllByGameIdAndBiggerThanPassScoreAndStatus(gameId,passScore,status,pageable);
	}
}
