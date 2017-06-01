package com.wyc.draw.service.updateExecuter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.common.session.DbServiceExecuter;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.domain.DekornTakepartMember;
import com.wyc.draw.domain.DekornToTakepartMember;
import com.wyc.draw.domain.Game;
import com.wyc.draw.domain.Prop;
import com.wyc.draw.domain.PropBean;
import com.wyc.draw.domain.PropLove;
import com.wyc.draw.domain.PropRandom;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.RedPacketAmountDistribution;
import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.domain.RedPacketToTakepartMember;
import com.wyc.draw.domain.Reward;
import com.wyc.draw.service.DekornService;
import com.wyc.draw.service.DekornTakepartMemberService;
import com.wyc.draw.service.DekornToTakepartMemberService;
import com.wyc.draw.service.GameService;
import com.wyc.draw.service.PropBeanService;
import com.wyc.draw.service.PropLoveService;
import com.wyc.draw.service.PropRandomService;
import com.wyc.draw.service.PropService;
import com.wyc.draw.service.RedPacketAmountDistributionService;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.service.RedPacketTakepartMemberService;
import com.wyc.draw.service.RewardService;
import com.wyc.draw.service.VieRedPacketToTakepartMemberService;

@Service
public class DrawUpdateExecuter implements DbServiceExecuter{

	@Autowired
	private VieRedPacketToTakepartMemberService vieRedPacketToTakepartMemberService;
	
	@Autowired
	private RedPacketTakepartMemberService redPacketTakepartMemberService;
	
	@Autowired
	private RedPacketService redPacketService;
	
	@Autowired
	private RedPacketAmountDistributionService redPacketAmountDistributionService;
	
	@Autowired
	private DekornService dekornService;
	
	@Autowired
	private GameService gameService;

	@Autowired
	private DekornTakepartMemberService dekornTakepartMemberService;
	
	@Autowired
	private RewardService rewardService;
	
	@Autowired
	private DekornToTakepartMemberService dekornToTakepartMemberService;
	
	@Autowired
	private PropService propService;
	
	@Autowired
	private PropLoveService propLoveService;
	
	@Autowired
	private PropBeanService propBeanService;
	
	@Autowired
	private PropRandomService propRandomService;
	
	
	@Override
	public void update(List<Object> objs) {
		if(objs!=null){
			for(Object object:objs){
				if(object.getClass().equals(RedPacketToTakepartMember.class)){
					vieRedPacketToTakepartMemberService.update((RedPacketToTakepartMember)object);
				}else if(object.getClass().equals(RedPacketTakepartMember.class)){
					redPacketTakepartMemberService.update((RedPacketTakepartMember)object);
				}else if(object.getClass().equals(RedPacket.class)){
					redPacketService.update((RedPacket)object);
				}else if(object.getClass().equals(RedPacketAmountDistribution.class)){
					redPacketAmountDistributionService.update((RedPacketAmountDistribution)object);
				}else if(object.getClass().equals(DekornTakepartMember.class)){
					dekornTakepartMemberService.update((DekornTakepartMember)object);
				}else if(object.getClass().equals(DekornToTakepartMember.class)){
					dekornToTakepartMemberService.update((DekornToTakepartMember)object);
				}else if(object.getClass().equals(Prop.class)){
					propService.update((Prop)object);
				}else if(object.getClass().equals(PropLove.class)){
					propLoveService.update((PropLove)object);
				}else if(object.getClass().equals(PropBean.class)){
					propBeanService.update((PropBean)object);
				}else if(object.getClass().equals(PropRandom.class)){
					propRandomService.update((PropRandom)object);
				}
			}
		}
		
	}

	@Override
	public <T> T findOne(Class<T> clazz, String id) {
		if(clazz.equals(RedPacket.class)){
			
			T obj = (T)redPacketService.findOne(id);
			return obj;
		}
		if(clazz.equals(Dekorn.class)){
			T obj = (T)dekornService.findOne(id);
			return obj;
		}
		
		if(clazz.equals(Game.class)){
			T obj = (T)gameService.findOne(id);
			return obj;
		}
		
		if(clazz.equals(DekornTakepartMember.class)){
			T obj = (T)dekornTakepartMemberService.findOne(id);
			return obj;
		}
		
		if(clazz.equals(Reward.class)){
			T obj = (T)rewardService.findOne(id);
			return obj;
		}

		return null;
	}

}
