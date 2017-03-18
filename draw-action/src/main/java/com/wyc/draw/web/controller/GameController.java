package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/view/game/game_draw")
public class GameController {

	@RequestMapping(value="info")
	public String info(HttpServletRequest httpServletRequest){
		return "game/gameRedPacket";
	}
}
