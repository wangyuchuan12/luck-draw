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
import com.wyc.draw.filter.AddRedPacketPromptFilter;
import com.wyc.draw.filter.BaseHandRedPackFilter;
import com.wyc.draw.filter.DelRedPacketPromptFilter;
import com.wyc.draw.filter.GetRedPacketPromptsByRedPacketIdFilter;
import com.wyc.draw.vo.RedPacketPromptListVo;
import com.wyc.draw.vo.RedPacketVo;
import com.wyc.pay.service.PayService;

@Controller
@RequestMapping(value="/api/draw/red_pack/")
public class RedPackApi {
	
	
	@Autowired
	private PayService payService;
	
	@Transactional
	@RequestMapping(value="add")
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=BaseHandRedPackFilter.class)
	public ResultVo handRedPack(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		if(sessionManager.isReturn()){
			ResultVo resultVo = (ResultVo)sessionManager.getReturnValue();
			if(resultVo!=null&&!resultVo.isSuccess()){
				return resultVo;
			}
		}
		
		RedPacketVo redPacketVo = (RedPacketVo)sessionManager.getObject(RedPacketVo.class);
		
		
		System.out.println("redPack is:"+redPacketVo.getId());
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("保存成功");
		resultVo.setData(redPacketVo);
		return resultVo;
	}
	
	
	
	@RequestMapping(value="prompts")
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=GetRedPacketPromptsByRedPacketIdFilter.class)
	public ResultVo prompts(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		
		RedPacketPromptListVo redPacketPromptListVo = (RedPacketPromptListVo)sessionManager.getObject(RedPacketPromptListVo.class);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("保存成功");
		resultVo.setData(redPacketPromptListVo);
		return resultVo;
	}
	
	
	@RequestMapping(value="add_prompt")
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=AddRedPacketPromptFilter.class)
	public ResultVo addPrompt(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		
		RedPacketVo redPacketVo = (RedPacketVo)sessionManager.getObject(RedPacketVo.class);
		
		ResultVo resultVo = new ResultVo();
		if(redPacketVo!=null){
			resultVo.setSuccess(true);
			resultVo.setMsg("保存成功");
			resultVo.setData(redPacketVo);
		}else{
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("保存失败");
		}
		return resultVo;
	}
	
	
	
	@RequestMapping(value="del_prompt")
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=DelRedPacketPromptFilter.class)
	public ResultVo delPrompt(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
	
		return resultVo;
	}
}
