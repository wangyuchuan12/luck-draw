package com.wyc.draw.web.api;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.VieRedPacketOption;
import com.wyc.draw.filter.HandRedPacketQuestionFilter;
import com.wyc.draw.filter.VieSelectOptionFilter;
import com.wyc.draw.filter.VieTakepartFilter;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.service.VieRedPacketOptionService;
import com.wyc.draw.vo.VieRedPacketProblemVo;

@Controller
@RequestMapping(value="/api/vie/draw/vie_red_pack/")
public class VieRedPacketApi {
	
	@Autowired
	private RedPacketService redPacketService;
	
	@Autowired
	private VieRedPacketOptionService vieRedPacketOptionService;
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
	
	
	//设置完选项卡提交数据
	@ResponseBody
	@RequestMapping(value="submit_problem")
	public Object submitProblem(HttpServletRequest httpServletRequest)throws Exception{
		String redPacketId = httpServletRequest.getParameter("red_packet_id");
		
		RedPacket redPacket = redPacketService.findOne(redPacketId);
		
		redPacket.setIsGiveQuestion(1);
		
		redPacketService.update(redPacket);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setMsg("设置成功");
		resultVo.setSuccess(true);
		
		return resultVo;
		
		
	}
	
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=VieSelectOptionFilter.class)
	@RequestMapping(value="select_option")
	public Object selectOption(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.isReturn()){
			return sessionManager.getReturnValue();
		}else{
			ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
			return resultVo;
		}
	}
	
	
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=VieTakepartFilter.class)
	@RequestMapping(value="takepart")
	public Object takepart(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.isReturn()){
			return sessionManager.getReturnValue();
		}else{
			ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
			return resultVo;
		}
	}
}