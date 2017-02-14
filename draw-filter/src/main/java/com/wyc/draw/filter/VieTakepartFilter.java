package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.VieRedPacketTakepartMember;
import com.wyc.draw.service.VieRedPacketTakepartMemberService;

public class VieTakepartFilter extends Filter{

	@Autowired
	private VieRedPacketTakepartMemberService vieRedPacketTakepartMemberService;
	
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		String redPacketId = httpServletRequest.getParameter("red_packet_id");
		
		if(CommonUtil.isEmpty(redPacketId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("redPacketId参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		VieRedPacketTakepartMember vieRedPacketTakepartMember = new VieRedPacketTakepartMember();
		vieRedPacketTakepartMember.setDrawUserId(drawUser.getId());
		vieRedPacketTakepartMember.setIsBest(0);
		vieRedPacketTakepartMember.setIsPay(0);
		vieRedPacketTakepartMember.setOpendid(drawUser.getOpenid());
		vieRedPacketTakepartMember.setRedPacketId(redPacketId);
		vieRedPacketTakepartMember.setRightCount(0l);
		vieRedPacketTakepartMember.setTimeLong(0l);
		vieRedPacketTakepartMember.setUserId(drawUser.getUserId());
		vieRedPacketTakepartMember.setWrongCount(0l);
		
		vieRedPacketTakepartMember = vieRedPacketTakepartMemberService.add(vieRedPacketTakepartMember);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setData(vieRedPacketTakepartMember);
		resultVo.setSuccess(true);
		resultVo.setMsg("参加成功");
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
