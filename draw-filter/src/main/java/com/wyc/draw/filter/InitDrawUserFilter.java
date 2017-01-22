package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.ApplyForm;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.BaseActionFilter;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.ApplyFormService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.DrawUserService;
import com.wyc.draw.service.other.UserInfoApplyFormHandleService;

public class InitDrawUserFilter extends Filter{

	@Autowired
	private DrawUserService drawUserService;
	
	@Autowired
	private ApplyFormService applyFormService;
	
	@Autowired
	private UserInfoApplyFormHandleService userInfoApplyFormHandleService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		UserInfo userInfo = (UserInfo)filterManager.getObject(UserInfo.class);
		if(userInfo==null){
			filterManager.setEnd(true);
			
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setMsg("找不到用户信息，请用微信客户端登录");
			filterManager.setReturnValue(resultVo);
			return null;
		}
		DrawUser drawUser = drawUserService.findByUserId(userInfo.getId());
		if(drawUser==null){
			drawUser = new DrawUser();
			drawUser.setOpenid(userInfo.getOpenid());
			drawUser.setUserId(userInfo.getId());
			drawUser.setAmountBalance(new BigDecimal("0"));
			drawUser.setAnswerNum(0);
			drawUser.setGetRedPacketAmount(new BigDecimal("0"));
			drawUser.setGetRedPacketNum(0);
			drawUser.setCanTakeOutCount(3);
			drawUser.setWrongAnswerNum(0);
			drawUser.setHandRedPacketAmount(new BigDecimal("0"));
			drawUser.setHandRedPacketNum(0);
			drawUser.setNickname(userInfo.getNickname());
			drawUser.setImgUrl(userInfo.getHeadimgurl());
			drawUser = drawUserService.add(drawUser);
		}
		
		
		
		List<ApplyForm> applyForms = applyFormService.findAllByOpenidAndTypeAndStatus(drawUser.getOpenid(),Constant.APPLY_FORM_TYPE_TAKE_IN,Constant.AUDIT_DRAW_ROOM_MEMEBER_STATUS);
		
		for(ApplyForm applyForm:applyForms){
			userInfoApplyFormHandleService.handTakeIn(drawUser,applyForm);
		}
		
		return drawUser;
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
		filterClasses.add(BaseActionFilter.class);
		return filterClasses;
	}

}
