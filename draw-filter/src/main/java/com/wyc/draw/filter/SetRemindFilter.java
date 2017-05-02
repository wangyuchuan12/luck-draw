package com.wyc.draw.filter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.DrawRoomMemberService;

public class SetRemindFilter extends Filter{

	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		String remind = httpServletRequest.getParameter("remind");
		String roomId = httpServletRequest.getParameter("room_id");
		
		String remberId = httpServletRequest.getParameter("rember_id");
		if(CommonUtil.isEmpty(remind)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("remind参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(roomId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("roomId参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(remberId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("remberId参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		DrawRoomMember drawRoomMember = drawRoomMemberService.findOne(remberId);
		
		if(CommonUtil.isEmpty(drawRoomMember)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("返回drawRoomMember为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(!drawRoomMember.getDrawUserId().equals(drawUser.getId())){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("drawRoomMember所对应的drawUserId跟当前的drawUser的id不对应");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		Integer remindInteger = Integer.parseInt(remind);
		
		if(remindInteger==0||remindInteger==1){
			drawRoomMember.setRemind(remindInteger);
			drawRoomMember = drawRoomMemberService.update(drawRoomMember);
		}else{
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("remind参数超出了范围");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		return drawRoomMember;
	}


	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
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
