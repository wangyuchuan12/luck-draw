package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.GoodDisplay;
import com.wyc.draw.repositories.GoodDisplayRejpository;

@Service
public class GoodDisplayService {

	@Autowired
	private GoodDisplayRejpository goodDisplayRejpository;

	public List<GoodDisplay> findAllByClazzAndIsDisplayOrderByIndexAsc(int clazz, int isDisplay) {
	
		return goodDisplayRejpository.findAllByClazzAndIsDisplayOrderByIndexAsc(clazz,isDisplay);
		
	}
}
