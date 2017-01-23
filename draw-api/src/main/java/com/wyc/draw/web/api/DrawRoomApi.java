package com.wyc.draw.web.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.BaseActionFilter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.filter.AddDrawRoomFilter;
import com.wyc.draw.filter.DrawRoomViewFilter;
import com.wyc.draw.filter.GetDrawRoomInfoFilter;
import com.wyc.draw.filter.GetDrawRoomMembersByRoomIdFilter;
import com.wyc.draw.filter.GetRoomListByUserOfPageFilter;
import com.wyc.draw.filter.JoinRoomFilter;
import com.wyc.draw.filter.SetRemindFilter;
import com.wyc.draw.vo.DrawRoomInfoVo;
import com.wyc.draw.vo.DrawRoomListVo;
import com.wyc.draw.vo.DrawRoomMemberListVo;

@Controller
@RequestMapping(value="/api/draw/draw_room/")
public class DrawRoomApi {
	
	//新建房间api
	@HandlerAnnotation(hanlerFilter=AddDrawRoomFilter.class)
	@ResponseBody
	@RequestMapping(value="add")
	public Object doAddDrawRoom(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		if(sessionManager.getObject(ResultVo.class)!=null){
			return sessionManager.getObject(ResultVo.class);
		}else{
			return sessionManager.getReturnValue();
		}
	}
	
	//进入房间获取房间所有信息
	@HandlerAnnotation(hanlerFilter=DrawRoomViewFilter.class)
	@ResponseBody
	@RequestMapping(value="detail_info")
	public Object getDrawRoomDetailInfo(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		DrawRoomInfoVo drawRoomInfoVo = (DrawRoomInfoVo)sessionManager.getObject(DrawRoomInfoVo.class);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setData(drawRoomInfoVo);
		resultVo.setSuccess(true);
		resultVo.setMsg("获取数据成功");
		return resultVo;
	}
	
	
	
	//获取房间基本信息api
	@HandlerAnnotation(hanlerFilter=GetDrawRoomInfoFilter.class)
	@ResponseBody
	@RequestMapping(value="info")
	public Object getDrawRoomInfo(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		DrawRoomInfoVo drawRoomInfoVo = (DrawRoomInfoVo)sessionManager.getObject(DrawRoomInfoVo.class);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setData(drawRoomInfoVo);
		resultVo.setSuccess(true);
		resultVo.setMsg("获取数据成功");
		return resultVo;
	}
	
	
	//获取房间用户
	@HandlerAnnotation(hanlerFilter=GetDrawRoomMembersByRoomIdFilter.class)
	@ResponseBody
	@RequestMapping(value="members")
	public Object getDrawRoomMembers(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		DrawRoomMemberListVo drawRoomMemberListVo = (DrawRoomMemberListVo)sessionManager.getObject(DrawRoomMemberListVo.class);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setData(drawRoomMemberListVo);
		resultVo.setSuccess(true);
		resultVo.setMsg("获取数据成功");
		return resultVo;
	}
	
	
	//获取房间用户
	@HandlerAnnotation(hanlerFilter=GetRoomListByUserOfPageFilter.class)
	@ResponseBody
	@RequestMapping(value="rooms")
	public Object rooms(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		DrawRoomListVo drawRoomListVo = (DrawRoomListVo)sessionManager.getObject(DrawRoomListVo.class);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setData(drawRoomListVo);
		resultVo.setSuccess(true);
		resultVo.setMsg("获取数据成功");
		return resultVo;
	}
	
	
	
	
	
	//申请加入房间
	@HandlerAnnotation(hanlerFilter=JoinRoomFilter.class)
	@ResponseBody
	@RequestMapping(value="join_room")
	public Object JoinRoom(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		if(sessionManager.getObject(ResultVo.class)!=null){
			return sessionManager.getObject(ResultVo.class);
		}else{
			return sessionManager.getReturnValue();
		}
	}
	
	//设置房间提醒
	@HandlerAnnotation(hanlerFilter=SetRemindFilter.class)
	@ResponseBody
	@RequestMapping(value="set_remind")
	public Object setRemind(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		if(sessionManager.getObject(ResultVo.class)!=null){
			return sessionManager.getObject(ResultVo.class);
		}else{
			DrawRoomMember drawRoomMember = (DrawRoomMember)sessionManager.getObject(DrawRoomMember.class);
			ResultVo resultVo = new ResultVo();
			Map<String, String> remind = new HashMap<>();
			remind.put("remind",drawRoomMember.getRemind()+"");
			resultVo.setMsg("设置房间提醒成功");
			resultVo.setData(remind);
			return resultVo;
		}
	}
}
