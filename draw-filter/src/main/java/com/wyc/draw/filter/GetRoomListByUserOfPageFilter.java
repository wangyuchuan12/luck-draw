package com.wyc.draw.filter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.DrawRoom;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.service.DrawRoomService;
import com.wyc.draw.vo.DrawRoomInfoVo;
import com.wyc.draw.vo.DrawRoomListVo;

public class GetRoomListByUserOfPageFilter extends Filter{

	@Autowired
	private DrawRoomService drawRoomService;
	
	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {

		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String page = httpServletRequest.getParameter("page");
		String size = httpServletRequest.getParameter("size");
		
		if(CommonUtil.isEmpty(page)){
			page = "0";
		}
		
		if(CommonUtil.isEmpty(size)){
			size = "10";
		}
		
		int pageInt = Integer.parseInt(page);
		
		int sizeInt = Integer.parseInt(size);
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		Sort sort = new Sort(Direction.DESC,"createDateTime");
		PageRequest pageRequest = new PageRequest(pageInt, sizeInt, sort);
		Page<DrawRoom> roomPage = drawRoomService.findAllByDrawUserId(drawUser.getId(),pageRequest);
		
		DrawRoomListVo drawRoomListVo = new DrawRoomListVo();
		
		drawRoomListVo.setCount(roomPage.getTotalElements());
		
		drawRoomListVo.setSize(roomPage.getSize());
		
		drawRoomListVo.setPage(pageInt);
		List<DrawRoomInfoVo> drawRoomInfoVos = new ArrayList<>();
		
		for(DrawRoom drawRoom:roomPage.getContent()){
			
			DrawRoomMember createDrawRoomMember = drawRoomMemberService.findOneByDrawRoomIdDrawUserId(drawRoom.getId(),drawRoom.getCreateDrawUserId());
			DrawRoomInfoVo drawRoomInfoVo = new DrawRoomInfoVo();
			drawRoomInfoVo.setId(drawRoom.getId());
			drawRoomInfoVo.setImgUrl(drawRoom.getImgUrl());
			drawRoomInfoVo.setMaxNum(drawRoom.getMaxNum());
			drawRoomInfoVo.setMemberCount(drawRoom.getMemberCount());
			drawRoomInfoVo.setName(drawRoom.getName());
			
			drawRoomInfoVo.setCreaterNickname(createDrawRoomMember.getName());
			drawRoomInfoVo.setCreaterHeadImg(createDrawRoomMember.getImgUrl());
			drawRoomInfoVo.setMaxRedPacketAmount(drawRoom.getMaxRedPacketAmount());
			drawRoomInfoVos.add(drawRoomInfoVo);
		}
		drawRoomListVo.setDrawRoomInfos(drawRoomInfoVos);
		return drawRoomListVo;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(BaseDrawActionFilter.class);
		return filters;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
