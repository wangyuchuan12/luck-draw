package com.wyc.common.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.common.domain.ApplyForm;
import com.wyc.common.repositories.ApplyFormRepository;

@Service
public class ApplyFormService {
	
	@Autowired
	private ApplyFormRepository applyFormRepository;

	public ApplyForm add(ApplyForm applyForm) {
		
		applyForm.setId(UUID.randomUUID().toString());
		applyForm.setUpdateAt(new DateTime());
		applyForm.setCreateAt(new DateTime());
		return applyFormRepository.save(applyForm);
		
	}
}
