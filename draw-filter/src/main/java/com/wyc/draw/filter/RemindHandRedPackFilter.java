package com.wyc.draw.filter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.common.wx.domain.Article;
import com.wyc.common.wx.domain.WxContext;
import com.wyc.common.wx.service.SendMessageService;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.vo.RedPacketVo;

public class RemindHandRedPackFilter extends Filter{

	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	
	@Autowired
	private SendMessageService sendMessageService;
	
	@Autowired
	private WxContext wxContext;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
		
		RedPacketVo redPacketVo = (RedPacketVo)filterManager.getObject(RedPacketVo.class);
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		
		if(redPacketVo.getIsInRoom()==1){
			List<DrawRoomMember> drawRoomMembers = drawRoomMemberService.findAllByDrawRoomIdAndStatusOrderByTakepartTimeAsc(redPacketVo.getDrawRoomId(), Constant.PASSED_DRAW_ROOM_MEMEBER_STATUS);

			for(DrawRoomMember drawRoomMember:drawRoomMembers){
				
				if(drawRoomMember.getRemind()==1){
					if(!drawUser.getOpenid().equals(drawRoomMember.getOpenid())){
						List<Article> articles = new ArrayList<>();
						Article article = new Article();
						article.setDescription("你的房间["+drawRoomMember.getRoomName()+"]"+drawUser.getNickname()+"发布了一个红包，请查看");
						article.setTitle("["+drawUser.getNickname()+"]发布红包通知");
						
						article.setUrl(wxContext.getDomainName()+"/view/draw/draw_room/info?id="+redPacketVo.getDrawRoomId());
						if(redPacketVo.getIsImg()==0){
							article.setPicurl(drawRoomMember.getRoomImgUrl());
						}else{
							article.setPicurl(redPacketVo.getImgUrl());
						}
						articles.add(article);
						
						sendMessageService.sendImgMessage(drawRoomMember.getOpenid(), articles);
					}else{
						
					}
				}
			}
		}
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(BaseHandRedPackFilter.class);
		return filters;
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
