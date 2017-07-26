package com.wyc.draw.filter.test;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.service.RedPacketService;

public class GetRedPacketFilter extends Filter{

	@Autowired
	private RedPacketService redPacketService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		RedPacket redPacket = (RedPacket)filterManager.getObject(RedPacket.class);
	
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String id = httpServletRequest.getParameter("id");
		
		System.out.println(".......id:"+id);
		if(CommonUtil.isEmpty(id)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入的红包id为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			
			System.out.println("this1");
			return null;
		}
		redPacket = redPacketService.findOne(id);
		
		System.out.println(".......redPacket:"+redPacket);
		if(redPacket==null){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("获取的红包为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			System.out.println("this2");
			return null;
		}
		return redPacket;
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
