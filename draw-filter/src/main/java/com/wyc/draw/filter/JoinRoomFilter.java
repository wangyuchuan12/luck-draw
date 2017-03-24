package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.domain.DrawRoom;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.service.DrawRoomService;

public class JoinRoomFilter extends Filter{

	
	@Autowired
	private DrawRoomService drawRoomService;
	
	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		DrawUser drawUser = (DrawUser) filterManager.getObject(DrawUser.class);
		
	    UserInfo userInfo = (UserInfo) filterManager.getObject(UserInfo.class);
		String verifyType = httpServletRequest.getParameter("verify_type");
		String verifyAnswer = httpServletRequest.getParameter("verify_answer");
		String password = httpServletRequest.getParameter("password");
		String roomId = httpServletRequest.getParameter("room_id");
		
		
		if(CommonUtil.isEmpty(roomId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("请输入room_id参数");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		DrawRoom drawRoom = drawRoomService.findOne(roomId);
		if(CommonUtil.isEmpty(drawRoom)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("room_id所对应的房间对象为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		Integer isInRoom = drawRoomMemberService.isInRoom(roomId, drawUser.getId());
		
		if(isInRoom==1){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("该用户已经在该房间中，无需再申请");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(verifyType)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("请输入verifyType参数");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		Integer verifyTypeInt = Integer.parseInt(verifyType);
		
		if(verifyTypeInt!=drawRoom.getVerifyType()){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入的verifyType和实际房间的类型不匹配");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(verifyTypeInt==0){
			if(CommonUtil.isEmpty(password)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("请输入password参数");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			if(!drawRoom.getPassword().equals(password)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("你输入的密码不匹配");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
		}else if(verifyTypeInt==1){
			
			if(CommonUtil.isEmpty(verifyAnswer)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("请输入verifyAnswer参数");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			if(!drawRoom.getVerifyAnswer().equals(verifyAnswer)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("你输入的回答不匹配");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
		}else if(verifyTypeInt==2){
			
		}
		
		Integer memberCount = drawRoom.getMemberCount();
		drawRoom.setMemberCount(memberCount+1);
		
		drawRoomService.update(drawRoom);
		DrawRoomMember drawRoomMember = new DrawRoomMember();
		drawRoomMember.setAnswerNum(0);
		drawRoomMember.setDrawRoomId(roomId);
		drawRoomMember.setDrawUserId(drawUser.getId());
		drawRoomMember.setGetRedPacketAmount(new BigDecimal(0));
		drawRoomMember.setGetRedPacketNum(0);
		drawRoomMember.setHandRedPacketAmount(new BigDecimal(0));
		drawRoomMember.setHandRedPacketNum(0);
		drawRoomMember.setImgUrl(userInfo.getHeadimgurl());
		drawRoomMember.setIsCreater(0);
		drawRoomMember.setName(userInfo.getNickname());
		drawRoomMember.setStatus(Constant.PASSED_DRAW_ROOM_MEMEBER_STATUS);
		drawRoomMember.setTakepartTime(new DateTime());
		drawRoomMember.setWrongAnswerNum(0);
		drawRoomMember.setOpenid(drawUser.getOpenid());
		drawRoomMember.setRoomName(drawRoom.getName());
		drawRoomMember.setRemind(0);
		drawRoomMember.setRoomImgUrl(drawRoom.getImgUrl());
		drawRoomMemberService.add(drawRoomMember);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("加入房间成功");
		resultVo.setData(drawRoomMember);
		
		return resultVo;
	}

	@Override
	public Object handlerAfter(SessionManager filterManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPrivateException(SessionManager filterManager, Method method, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPublicException(SessionManager filterManager, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(DrawUserFilter.class);
		return filters;
	}

}
