package com.wyc.draw.filter;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.wyc.common.filter.Filter;
import com.wyc.common.service.WxUserInfoService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.MyLongDateFormat;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.domain.param.VieDrawInfoParam;
import com.wyc.draw.service.RedPacketTakepartMemberService;
import com.wyc.draw.vo.RedPacketTakepartMemberListVo;
import com.wyc.draw.vo.RedPacketTakepartMemberVo;

public class GetTakepartMemberListByRedPacketOfPageFilter extends Filter{

	@Autowired
	private RedPacketTakepartMemberService redPacketTakepartMemberService;
	
	@Autowired
	private MyLongDateFormat mySimpleDateFormat;
	
	@Autowired
	private WxUserInfoService userInfoService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
		VieDrawInfoParam vieDrawInfoParam = (VieDrawInfoParam)filterManager.getObject(VieDrawInfoParam.class);
		
		String id = vieDrawInfoParam.getRedPacketId();
		
		int pageInt = vieDrawInfoParam.getTakepartMemberPage();
		
		int sizeInt = vieDrawInfoParam.getTakepartMemberSize();
		Sort sort = new Sort(Direction.DESC,"takepartDateTime");
		PageRequest pageRequest = new PageRequest(pageInt, sizeInt, sort);
		Page<RedPacketTakepartMember> packetTakePage = redPacketTakepartMemberService.findAllByRedPacketId(id,pageRequest);

		RedPacketTakepartMemberListVo redPacketTakepartMemberListVo = new RedPacketTakepartMemberListVo();
		List<RedPacketTakepartMemberVo> redPacketTakepartMemberVos = new ArrayList<>();
		
		redPacketTakepartMemberListVo.setCount(packetTakePage.getTotalElements());
		
		redPacketTakepartMemberListVo.setSize(packetTakePage.getSize());
		
		redPacketTakepartMemberListVo.setPage(pageInt);
		
		for(RedPacketTakepartMember redPacketTakepartMember:packetTakePage.getContent()){
			
			UserInfo userInfo = userInfoService.findByOpenid(redPacketTakepartMember.getOpenid());
			RedPacketTakepartMemberVo redPacketTakepartMemberVo = new RedPacketTakepartMemberVo();
			redPacketTakepartMemberVo.setAdminId(redPacketTakepartMember.getAdminId());
			redPacketTakepartMemberVo.setAnswer(redPacketTakepartMember.getAnswer());
			redPacketTakepartMemberVo.setDrawUserId(redPacketTakepartMember.getDrawUserId());
			redPacketTakepartMemberVo.setGetAmount(redPacketTakepartMember.getGetAmount());
			
			redPacketTakepartMemberVo.setId(redPacketTakepartMember.getId());
			redPacketTakepartMemberVo.setIsSuccess(redPacketTakepartMember.getIsSuccess());
			redPacketTakepartMemberVo.setOpenid(redPacketTakepartMember.getOpenid());
			redPacketTakepartMemberVo.setRedPacketId(redPacketTakepartMember.getRedPacketId());
			redPacketTakepartMemberVo.setRoomMemberId(redPacketTakepartMember.getRoomMemberId());
			redPacketTakepartMemberVo.setTakepartDateTime(mySimpleDateFormat.format(redPacketTakepartMember.getTakepartDateTime().toDate()));
			redPacketTakepartMemberVo.setType(redPacketTakepartMember.getType());
			redPacketTakepartMemberVo.setUserId(redPacketTakepartMember.getUserId());
			
			redPacketTakepartMemberVo.setNickname(userInfo.getNickname());
			redPacketTakepartMemberVo.setHeadImg(userInfo.getHeadimgurl());
			redPacketTakepartMemberVos.add(redPacketTakepartMemberVo);
		}
		redPacketTakepartMemberListVo.setRedPacketTakepartMemberVos(redPacketTakepartMemberVos);
		return redPacketTakepartMemberListVo;
		
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
