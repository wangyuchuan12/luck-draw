package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/plug")
public class PlugController {
	
	@RequestMapping(value="gameCompltePlug")
	public String gameCompletePlug(HttpServletRequest httpServletRequest){
		return "plug/gameCompletePlug";
	}
	
	@RequestMapping(value="switchSubjectPlug")
	public String switchSubjectPlug(HttpServletRequest httpServletRequest){
		return "plug/switchSubjectPlug";
	}
}
