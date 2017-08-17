package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/view/battle/edit")
public class BattleEditController {

	@RequestMapping(value="addBattleModel")
	public String addBattleModel(HttpServletRequest httpServletRequest){
		return "battle/addBattleModel";
	}
}
