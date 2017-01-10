package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.service.RedPackageService;
import com.wyc.draw.vo.RedPacketVo;

//获取红包信息
public class GetRedPackFilter extends Filter{

	@Autowired
	private RedPackageService redPackageService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		UserInfo userInfo = (UserInfo)filterManager.getObject(UserInfo.class);
		String id = httpServletRequest.getParameter("id");
		RedPacket redPacket  = redPackageService.findOne(id);
		
		if(redPacket.getIsTimeout()==0){
			
			Calendar calendar = Calendar.getInstance();
			DateTime handTime = redPacket.getHandTime();
			calendar.setTime(handTime.toDate());
			int timeLong = redPacket.getTimeLong();
			calendar.add(Calendar.HOUR_OF_DAY, timeLong);
			
			if(calendar.before(new Date())){
				redPacket.setIsTimeout(1);
				redPackageService.update(redPacket);
			}
			
		}
		
		RedPacketVo redPacketVo = new RedPacketVo();
		redPacketVo.setDrawRoomId(redPacket.getDrawRoomId());
		redPacketVo.setHandDrawUserId(redPacket.getHandDrawUserId());
		redPacketVo.setHandRoomMemberId(redPacket.getHandRoomMemberId());
		redPacketVo.setHandTime(redPacket.getHandTime());
		redPacketVo.setHandDrawUserId(redPacket.getHandDrawUserId());
		redPacketVo.setId(redPacket.getId());
		redPacketVo.setPayType(redPacket.getPayType());
		redPacketVo.setType(redPacket.getType());
		redPacketVo.setAmount(redPacket.getAmount());
		redPacketVo.setNickname(userInfo.getNickname());
		redPacketVo.setQuestion(redPacket.getQuestion());
		redPacketVo.setUserImgUrl(userInfo.getHeadimgurl());
		redPacketVo.setAnswer(redPacket.getAnswer());
		redPacketVo.setIsTimeout(redPacket.getIsTimeout());
		redPacketVo.setTimeLong(redPacket.getTimeLong());
		return redPacketVo;
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
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(BaseDrawActionFilter.class);
		return filterClasses;
	}

}
