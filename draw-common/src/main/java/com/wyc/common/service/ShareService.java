package com.wyc.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.common.repositories.ShareRepository;

@Service
public class ShareService {

	@Autowired
	private ShareRepository shareRepository;
}
