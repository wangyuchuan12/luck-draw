package com.wyc.draw.filter.controller.api;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.RedPacketComent;
import com.wyc.draw.domain.RedPacketToComent;
import com.wyc.draw.domain.param.RedPacketComentParam;
import com.wyc.draw.filter.controller.param.RedPacketComentParamFilter;
import com.wyc.draw.service.RedPacketComentService;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.service.RedPacketToComentService;

public class RedPacketComentFilter extends Filter{

	@Autowired
	private RedPacketComentService redPacketComentService;
	
	@Autowired
	private RedPacketToComentService redPacketToComentService;
	
	@Autowired
	private RedPacketService redPacketService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		RedPacketComentParam redPacketComentParam = (RedPacketComentParam)filterManager.getObject(RedPacketComentParam.class);
		RedPacketComent redPacketComent = new RedPacketComent();
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		redPacketComent.setAccordStar(redPacketComentParam.getAccordStar());
		
		redPacketComent.setComentDrawUserId(drawUser.getId());
		
		redPacketComent.setContent(redPacketComentParam.getContent());
		
		redPacketComent.setInterestingStar(redPacketComentParam.getInterestingStar());
		
		redPacketComent.setRedPacketId(redPacketComentParam.getRedPacketId());
		
		redPacketComent.setType(redPacketComentParam.getType());
		
		redPacketComent.setUsefulStar(redPacketComentParam.getUsefulStar());
		
		redPacketComent = redPacketComentService.add(redPacketComent);
		
		if(redPacketComentParam.getType()==0){
			RedPacket redPacket = redPacketService.findOne(redPacketComentParam.getRedPacketId());
			
			redPacket.setGetWisdomCount(redPacket.getGetWisdomCount()+2);
			
			filterManager.update(redPacket);
		}else if(redPacketComentParam.getType()==1){
			
		}
		
		RedPacketToComent redPacketToComent = redPacketToComentService.findByRedPacketId(redPacketComentParam.getRedPacketId());
		redPacketToComentService.commentRedPacket(redPacketToComent, redPacketComentParam.getAccordStar(), redPacketComentParam.getUsefulStar(), redPacketComentParam.getInterestingStar(),redPacketComentParam.getType());
		
		ResultVo resultVo = new ResultVo();
		
		resultVo.setData(redPacketComent);
		
		resultVo.setMsg("评论成功");
		
		resultVo.setSuccess(true);
		
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
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		
		filterClasses.add(RedPacketComentParamFilter.class);
		
		return filterClasses;
	}

}
