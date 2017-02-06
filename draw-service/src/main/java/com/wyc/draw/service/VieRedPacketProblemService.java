package com.wyc.draw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.repositories.VieRedPacketProblemRepository;

@Service
public class VieRedPacketProblemService {

	@Autowired
	private VieRedPacketProblemRepository vieRedPacketProblemRepository;
}
