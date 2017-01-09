package com.wyc.draw.web.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.BaseHandRedPackFilter;
import com.wyc.draw.vo.RedPacketVo;

@Controller
@RequestMapping(value="/api/draw/red_pack/")
public class RedPackApi {
	
	@HandlerAnnotation(hanlerFilter=BaseHandRedPackFilter.class)
	public ResultVo handRedPack(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		RedPacketVo redPacketVo = (RedPacketVo)sessionManager.getObject(RedPacketVo.class);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("保存成功");
		return resultVo;
	}
}
