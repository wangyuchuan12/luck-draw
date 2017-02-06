package com.wyc.draw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.repositories.VieRedPacketOptionRepository;

@Service
public class VieRedPacketOptionService {

	@Autowired
	private VieRedPacketOptionRepository vieRedPacketOptionRepository;
}
