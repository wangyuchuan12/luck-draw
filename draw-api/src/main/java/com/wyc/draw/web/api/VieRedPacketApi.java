package com.wyc.draw.web.api;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.HandRedPacketQuestionFilter;
import com.wyc.draw.vo.VieRedPacketProblemVo;

@Controller
@RequestMapping(value="/api/vie/draw/vie_red_pack/")
public class VieRedPacketApi {
	
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=HandRedPacketQuestionFilter.class)
	@RequestMapping(value="hand_problem")
	@Transactional
	public Object handProblem(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		if(sessionManager.isReturn()){
			ResultVo resultVo = (ResultVo)sessionManager.getReturnValue();
			
			return resultVo;
		}
		
		VieRedPacketProblemVo vieRedPacketProblemVo = (VieRedPacketProblemVo)sessionManager.getObject(VieRedPacketProblemVo.class);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("success");
		resultVo.setData(vieRedPacketProblemVo);
		return resultVo;
	}
}
