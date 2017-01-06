package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.BaseActionFilter;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.domain.DrawRoom;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.service.DrawRoomService;

public class AddDrawRoomFilter extends Filter{
	
	@Autowired
	private DrawRoomService drawRoomService;
	
	@Autowired
	private DrawRoomMemberService drawRoomMemberService;

	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		UserInfo userInfo = (UserInfo)filterManager.getObject(UserInfo.class);
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String name = httpServletRequest.getParameter("name");
		String isVerify = httpServletRequest.getParameter("isVerify");
		
		String password = httpServletRequest.getParameter("password");
		String verifyQuestion = httpServletRequest.getParameter("verifyQuestion");
		String verifyAnswer = httpServletRequest.getParameter("verifyAnswer");
		String verifyType = httpServletRequest.getParameter("verifyType");
		
		System.out.println("verfyType:"+verifyType);
		String imgUrl = httpServletRequest.getParameter("imgUrl");
		String imgResourceId = httpServletRequest.getParameter("imgResourceId");
		int verifyTypeInt = 0;
		int isVerifyInt = 0;
		if(CommonUtil.isEmpty(name)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入参数name不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		String maxNum = httpServletRequest.getParameter("maxNum");
		if(CommonUtil.isEmpty(maxNum)){
			maxNum = "50";
		}
		
		int maxNumInt = 0;
		try{
			maxNumInt = Integer.parseInt(maxNum);
		}catch(Exception e){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入参数maxNum不是数字类型");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		
		if(CommonUtil.isEmpty(isVerify)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入参数isVerify不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		try{
			isVerifyInt = Integer.parseInt(isVerify);
		}catch(Exception e){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入的参数isVerify不合法，无法转换为数字");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		if(isVerifyInt==1){

			if(CommonUtil.isEmpty(verifyType)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("输入参数verifyType为null");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			
			
			try{
				verifyTypeInt = Integer.parseInt(verifyType);
			}catch(Exception e){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("输入参数verifyType不是数字类型");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			
			if(verifyTypeInt==Constant.PASSWORD_VERIFY_TYPE){
				if(CommonUtil.isEmpty(password)){
					ResultVo resultVo = new ResultVo();
					resultVo.setSuccess(false);
					resultVo.setErrorMsg("验证类型为密码验证，输入的密码为空");
					filterManager.setReturn(true);
					filterManager.setReturnValue(resultVo);
					return null;
				}
			}else if(verifyTypeInt==Constant.QUESTION_VERIFY_TYPE){
				if(CommonUtil.isEmpty(verifyQuestion)){
					ResultVo resultVo = new ResultVo();
					resultVo.setSuccess(false);
					resultVo.setErrorMsg("验证类型为问题验证，输入的验证问题参数为空");
					filterManager.setReturn(true);
					filterManager.setReturnValue(resultVo);
					return null;
				}
				
				if(CommonUtil.isEmpty(verifyAnswer)){
					ResultVo resultVo = new ResultVo();
					resultVo.setSuccess(false);
					resultVo.setErrorMsg("验证类型为问题验证，输入的验证答案参数为空");
					filterManager.setReturn(true);
					filterManager.setReturnValue(resultVo);
					return null;
				}
			}else{
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("输入的验证类型参数不合法");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
		}
		
		
		
		
		
		DrawRoom drawRoom = new DrawRoom();
		drawRoom.setMaxNum(maxNumInt);
		drawRoom.setCreaterUserId(userInfo.getId());
		drawRoom.setCreaterOpenid(userInfo.getOpenid());
		drawRoom.setMemberCount(1);
		drawRoom.setName(name);
		drawRoom.setPassword(password);
		drawRoom.setVerifyAnswer(verifyAnswer);
		drawRoom.setVerifyQuestion(verifyQuestion);
		drawRoom.setVerifyType(verifyTypeInt);
		drawRoom = drawRoomService.add(drawRoom);
		
		
		DrawRoomMember drawRoomMember = new DrawRoomMember();
		drawRoomMember.setAnswerNum(0);
		drawRoomMember.setDrawRoomId(drawRoom.getId());
		drawRoomMember.setGetRedPacketAmount(new BigDecimal("0"));
		drawRoomMember.setGetRedPacketNum(0);
		drawRoomMember.setHandRedPacketAmount(new BigDecimal("0"));
		drawRoomMember.setHandRedPacketNum(0);
		drawRoomMember.setIsCreater(1);
		drawRoomMember.setIsOut(0);
		drawRoomMember.setName(name);
		drawRoomMember.setOpenid(userInfo.getOpenid());
		drawRoomMember.setTakepartTime(new DateTime());
		drawRoomMember.setUserId(userInfo.getId());
		drawRoomMember.setWrongAnswerNum(0);
		drawRoomMemberService.add(drawRoomMember);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("保存成功");
		resultVo.setData(drawRoom);
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
		filters.add(BaseActionFilter.class);
		return filters;
	}

}
