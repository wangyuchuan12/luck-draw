package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.service.RedPacketTakepartMemberService;

public class ShareRedPacketFilter extends Filter{

	@Autowired
	private RedPacketService redPacketService;
	
	@Autowired
	private RedPacketTakepartMemberService redPacketTakepartMemberService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		String id = httpServletRequest.getParameter("id");
		
		if(CommonUtil.isEmpty(id)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入的id参数为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		RedPacket redPacket = redPacketService.findOne(id);
		
		if(redPacket==null){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("返回红包对象为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		RedPacketTakepartMember redPacketTakepartMember = redPacketTakepartMemberService.findByRedPacketIdAndDrawUserId(id, drawUser.getId());
		
		if(redPacketTakepartMember==null){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("该用户未参与该红包抢答");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(redPacketTakepartMember.getIsShareComplete()==1){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("该用户已经分享完成了，无需再调用分享接口");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		Integer shareCount = redPacketTakepartMember.getShareCount();
		
		if(shareCount==null){
			shareCount=0;
		}
		shareCount = shareCount +1;
		
		if(shareCount>=redPacket.getShareNumShowAnswer()){
			redPacketTakepartMember.setIsShareComplete(1);
		}else{
			redPacketTakepartMember.setIsShareComplete(0);
		}
		redPacketTakepartMember.setShareCount(shareCount);
		
		redPacketTakepartMember = redPacketTakepartMemberService.update(redPacketTakepartMember);
		
		ResultVo resultVo = new ResultVo();
		
		Map<String, Object> map = new HashMap<>();
		map.put("shareCount", redPacketTakepartMember.getShareCount());
		map.put("isShareComplete", redPacketTakepartMember.getIsShareComplete());
		
		resultVo.setSuccess(true);
		resultVo.setMsg("分享数据成功");
		resultVo.setData(map);
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
