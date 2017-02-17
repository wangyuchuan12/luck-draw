package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.DoWxShareFilter;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.wx.domain.Share;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.vo.ShareVo;

public class ShareRedPacketFilter extends Filter{

	@Autowired
	private RedPacketService redPacketService;
	

	@Override
	public Object handlerBefore(SessionManager sessionManager) throws Exception {
		
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		String id = httpServletRequest.getParameter("id");
		
		if(CommonUtil.isEmpty(id)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("id参数不能为空");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(resultVo);
			return null;
		}
		if(sessionManager.isReturn()){
			return null;
		}
		
		RedPacket redPacket = redPacketService.findOne(id);
		if(CommonUtil.isEmpty(redPacket)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("返回的redPacket对象为空");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(resultVo);
			return null;
		}
		
		Integer shareNum = redPacket.getShareNum();
		if(shareNum==null){
			shareNum=0;
		}
		
		ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
		Share share = (Share)resultVo.getData();
		redPacket.setShareNum(shareNum+1);
		
		redPacketService.update(redPacket);
		
		ShareVo shareVo = new ShareVo();
		shareVo.setHrefId(share.getHrefId());
		shareVo.setShareCount(redPacket.getShareNum());
		shareVo.setSponsorOpenid(share.getSponsorOpenid());
		shareVo.setType(share.getType());
		shareVo.setUrl(share.getUrl());
		return shareVo;
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
		filters.add(DoWxShareFilter.class);
		return filters;
	}

}
