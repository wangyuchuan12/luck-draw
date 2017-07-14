package com.wyc.draw.web.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.draw.domain.BattleStage;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.service.BattleStageService;

@Controller
@RequestMapping(value="/view/draw/main/")
public class MainController {
	@Autowired
	private BattleStageService battleStageService;
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="home")
	public String drawRooms(HttpServletRequest httpServletRequest)throws Exception{
		String battleId = httpServletRequest.getParameter("battleId");
		httpServletRequest.setAttribute("battleId", battleId);
		return "mainView";
	}
	
	@RequestMapping(value="subjectCheck")
	public String subjectCheck(HttpServletRequest httpServletRequest)throws Exception{
		return "mainSubjectCheck";
	}
	
	
	@RequestMapping(value="themeCheck")
	public String themeCheck(HttpServletRequest httpServletRequest)throws Exception{
		return "mainThemeCheck";
	}
	
	
	@RequestMapping(value="test")
	public String test(HttpServletRequest httpServletRequest)throws Exception{
		return "test/test";
	}
	
	@RequestMapping(value="skipToStage")
	public String skipToStage(HttpServletRequest httpServletRequest)throws Exception{
		String stageIndex = httpServletRequest.getParameter("stageIndex");
		String battleId = httpServletRequest.getParameter("battleId");
		
		BattleStage battleStage = battleStageService.findOneByBattleIdAndStageIndex(battleId,Integer.parseInt(stageIndex));
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(battleStage);
		
		return "redirect:/view/question/paperInfo?id="+battleStage.getPaperId()+"&keyId=1111";
		
	}
}
