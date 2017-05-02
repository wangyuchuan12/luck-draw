package com.wyc.draw.filter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.RedPacketOption;
import com.wyc.draw.domain.param.VieDrawInfoParam;
import com.wyc.draw.service.RedPacketOptionService;
import com.wyc.draw.vo.RedPacketOptionListVo;

public class GetRedPacketOptionsByRedPacketIdFilter extends Filter{

	@Autowired
	private RedPacketOptionService redPacketOptionService;
	
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		VieDrawInfoParam vieDrawInfoParam = (VieDrawInfoParam)filterManager.getObject(VieDrawInfoParam.class);
		String id = vieDrawInfoParam.getRedPacketId();
		
		RedPacket packet = (RedPacket)filterManager.getObject(RedPacket.class);
		
		List<RedPacketOption> redPacketOptions = redPacketOptionService.findAllByRedPacketIdAndIsDelOrderBySeqAsc(id,0);
		
		
		RedPacketOptionListVo redPacketOptionListVo = new RedPacketOptionListVo();
		
		redPacketOptionListVo.setAnswer(packet.getAnswer());
		
		redPacketOptionListVo.setRedPacketOptions(redPacketOptions);
		
		return redPacketOptionListVo;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
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
