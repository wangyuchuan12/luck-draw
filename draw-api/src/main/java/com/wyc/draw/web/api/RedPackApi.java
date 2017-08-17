package com.wyc.draw.web.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.filter.AddRedPacketPromptFilter;
import com.wyc.draw.filter.DelRedPacketPromptFilter;
import com.wyc.draw.filter.GetRedPackListByRoomOfPageFilter;
import com.wyc.draw.filter.GetRedPacketListOfPageFilter;
import com.wyc.draw.filter.GetRedPacketPromptsByRedPacketIdFilter;
import com.wyc.draw.filter.GetTakepartMemberListByRedPacketOfPageFilter;
import com.wyc.draw.filter.HandRedPacketOptionsFilter;
import com.wyc.draw.filter.SetRedPacketIsAmountDisplay;
import com.wyc.draw.filter.ShareRedPacketFilter;
import com.wyc.draw.filter.controller.api.HandRedPackApiFilter;
import com.wyc.draw.filter.controller.api.RedPackApiAnswerApiFilter;
import com.wyc.draw.filter.controller.api.RedPacketComentFilter;
import com.wyc.draw.vo.AnswerRedPacketResultVo;
import com.wyc.draw.vo.RedPacketListVo;
import com.wyc.draw.vo.RedPacketPromptListVo;
import com.wyc.draw.vo.RedPacketTakepartMemberListVo;
import com.wyc.draw.vo.RedPacketVo;
import com.wyc.draw.vo.ShareVo;

@Controller
@RequestMapping(value="/api/draw/red_pack/")
public class RedPackApi {

	@ResponseBody
	@HandlerAnnotation(hanlerFilter=GetRedPacketListOfPageFilter.class)
	@RequestMapping(value="list")
	public ResultVo list(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		RedPacketListVo redPacketListVo = (RedPacketListVo)sessionManager.getObject(RedPacketListVo.class);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setData(redPacketListVo);
		resultVo.setSuccess(true);
		resultVo.setMsg("获取数据成功");
		return resultVo;
	}
	
	@Transactional
	@RequestMapping(value="listByRoom")
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=GetRedPackListByRoomOfPageFilter.class)
	public ResultVo listByRoom(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		RedPacketListVo redPacketListVo = (RedPacketListVo)sessionManager.getObject(RedPacketListVo.class);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setData(redPacketListVo);
		resultVo.setSuccess(true);
		resultVo.setMsg("获取数据成功");
		return resultVo;
	}
	
	
	
	@Transactional
	@RequestMapping(value="add")
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=HandRedPackApiFilter.class)
	public ResultVo handRedPack(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);

		if(sessionManager.isReturn()){
			ResultVo resultVo = (ResultVo)sessionManager.getReturnValue();
			if(resultVo!=null&&!resultVo.isSuccess()){
				return resultVo;
			}
		}else{
			ResultVo resultVo = sessionManager.getObject(ResultVo.class);
			RedPacketVo redPacketVo = (RedPacketVo)sessionManager.getObject(RedPacketVo.class);
			resultVo.setData(redPacketVo);
			if(resultVo!=null){
				return resultVo;
			}
		}
		
		RedPacketVo redPacketVo = (RedPacketVo)sessionManager.getObject(RedPacketVo.class);
		
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
	
	@Transactional
	@RequestMapping(value="answer")
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=RedPackApiAnswerApiFilter.class)
	public ResultVo answer(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		if(sessionManager.isReturn()){
			ResultVo resultVo = (ResultVo)sessionManager.getReturnValue();
			return resultVo;
		}
		
		AnswerRedPacketResultVo answerRedPacketResultVo  = (AnswerRedPacketResultVo)sessionManager.getObject(AnswerRedPacketResultVo.class);
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(answerRedPacketResultVo);
		resultVo.setMsg("提交答案成功");
		return resultVo;
		
	}
	
	
	@RequestMapping(value="takepart_members")
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=GetTakepartMemberListByRedPacketOfPageFilter.class)
	public ResultVo takepartMembers(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		
		RedPacketTakepartMemberListVo redPacketTakepartMemberListVo  = (RedPacketTakepartMemberListVo)sessionManager.getObject(RedPacketTakepartMemberListVo.class);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("获取数据成功");
		resultVo.setData(redPacketTakepartMemberListVo);
		return resultVo;
	}
	
	
	@RequestMapping(value="set_amount_display")
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=SetRedPacketIsAmountDisplay.class)
	public ResultVo setAmountDisplay(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		if(sessionManager.isReturn()){
			return (ResultVo)sessionManager.getReturnValue();
		}
		
		RedPacket redPacket = (RedPacket)sessionManager.getObject(RedPacket.class);
		Map<String, Object> map = new HashMap<>();
		
		map.put("isDisplay", redPacket.getIsAmountDisplay());
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("获取数据成功");
		resultVo.setData(map);
		return resultVo;
	}
	
	
	@RequestMapping(value="share_red_packet_filter")
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=ShareRedPacketFilter.class)
	@Transactional
	public ResultVo shareRedPacketFilter(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.isReturn()){
			return (ResultVo)sessionManager.getReturnValue();
		}
		
		ShareVo shareRecord = (ShareVo)sessionManager.getObject(ShareVo.class);
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("返回数据成功");
		resultVo.setData(shareRecord);
		return resultVo;
	}
	
	
	@RequestMapping(value="hand_red_packet_option")
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=HandRedPacketOptionsFilter.class)
	public ResultVo handRedPacketOption(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		if(sessionManager.isReturn()){
			return (ResultVo)sessionManager.getReturnValue();
		}else{
			ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
			
			return resultVo;
		}
	}
	
	
	@Transactional
	@RequestMapping(value="coment")
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=RedPacketComentFilter.class)
	public ResultVo coment(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		if(sessionManager.isReturn()){
			return (ResultVo)sessionManager.getReturnValue();
		}else{
			ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
			
			return resultVo;
		}
	}
	
	
}
