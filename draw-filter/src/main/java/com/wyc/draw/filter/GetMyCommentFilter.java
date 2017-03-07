package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacketComent;
import com.wyc.draw.domain.param.GetCommentParam;
import com.wyc.draw.service.RedPacketComentService;
import com.wyc.draw.vo.RedPacketComentListVo;

public class GetMyCommentFilter extends Filter{

	@Autowired
	private RedPacketComentService redPacketComentService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		GetCommentParam getCommentParam = (GetCommentParam)filterManager.getObject(GetCommentParam.class);
		
		List<RedPacketComent> redPacketComents = redPacketComentService.findAllByComentDrawUserIdAndRedPacketId(getCommentParam.getDrawUserId(),getCommentParam.getRedPacketId());
		
		RedPacketComentListVo redPacketComentListVo = new RedPacketComentListVo();
		
		redPacketComentListVo.setComents(redPacketComents);
		
		return redPacketComentListVo;
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
