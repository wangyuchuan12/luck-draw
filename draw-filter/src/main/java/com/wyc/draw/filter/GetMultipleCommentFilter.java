package com.wyc.draw.filter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacketToComent;
import com.wyc.draw.domain.param.GetCommentParam;
import com.wyc.draw.service.RedPacketToComentService;

//获取综合评分
public class GetMultipleCommentFilter extends Filter{

	@Autowired
	private RedPacketToComentService redPacketToCommentService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		GetCommentParam getCommentParam = (GetCommentParam)filterManager.getObject(GetCommentParam.class);
		String redPacketId = getCommentParam.getRedPacketId();
		
		RedPacketToComent redPacketToComent = redPacketToCommentService.findByRedPacketId(redPacketId);
		return redPacketToComent;
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
