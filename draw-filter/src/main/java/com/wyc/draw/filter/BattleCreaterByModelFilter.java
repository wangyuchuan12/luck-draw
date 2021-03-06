package com.wyc.draw.filter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Battle;
import com.wyc.draw.domain.BattleModel;
import com.wyc.draw.domain.BattleModelReward;
import com.wyc.draw.domain.BattleModelStage;
import com.wyc.draw.domain.BattleModelStageIndex;
import com.wyc.draw.domain.BattleReward;
import com.wyc.draw.domain.BattleStage;
import com.wyc.draw.domain.BattleStageIndexDetail;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.BattleModelRewardService;
import com.wyc.draw.service.BattleModelService;
import com.wyc.draw.service.BattleModelStageIndexService;
import com.wyc.draw.service.BattleModelStageService;
import com.wyc.draw.service.BattleRewardService;
import com.wyc.draw.service.BattleService;
import com.wyc.draw.service.BattleStageIndexDetailService;
import com.wyc.draw.service.BattleStageService;

public class BattleCreaterByModelFilter extends Filter{

	@Autowired
	private BattleModelService battleModelService;
	
	@Autowired
	private BattleModelStageService battleModelStageService;
	
	@Autowired
	private BattleModelStageIndexService battleModelStageIndexService;
	
	@Autowired
	private BattleService battleService;
	
	@Autowired
	private BattleStageService battleStageService;
	
	@Autowired
	private BattleStageIndexDetailService battleStageIndexDetailService;
	
	@Autowired
	private BattleModelRewardService battleModelRewardService;
	
	@Autowired
	private BattleRewardService battleRewardService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();

		String modelId = (String)sessionManager.getAttribute("modelId");
		
		DrawUser drawUser = sessionManager.getObject(DrawUser.class);
		BattleModel battleModel = battleModelService.findOne(modelId);
		
		List<BattleModelStage> battleModelStages = battleModelStageService.findAllByBattleModelId(battleModel.getId());
		
		
		List<BattleModelStageIndex> battleModelStageIndexs = battleModelStageIndexService.findAllByBattleModelId(modelId);
		/*Map<Integer, List<BattleModelStageIndex>> battleModelStageIndexMap = new HashMap<>();
		
		for(BattleModelStageIndex battleModelStageIndex:battleModelStageIndexs){
			List<BattleModelStageIndex> thisBattleModelStageIndexs = battleModelStageIndexMap.get(battleModelStageIndex.getStageindex());
			if(thisBattleModelStageIndexs == null){
				thisBattleModelStageIndexs =  new ArrayList<>();
				battleModelStageIndexMap.put(battleModelStageIndex.getStageindex(), thisBattleModelStageIndexs);
			}
			thisBattleModelStageIndexs.add(battleModelStageIndex);
		}*/
		Battle battle = new Battle();
		battle.setBeanConsume(battleModel.getBeanConsume());
		battle.setImgUrl(battleModel.getImgUrl());
		battle.setInstruction(battleModel.getInstruction());
		battle.setLoveLifeConsume(battleModel.getLoveLifeConsume());
		battle.setModelId(battleModel.getId());
		battle.setName(battleModel.getName());
		battle.setPaperId(battleModel.getPaperId());
		battle.setSubjectId(battleModel.getSubjectId());
		battle.setTakepartCount(0);
		battle.setTitle(battleModel.getTitle());
		battle.setType(battleModel.getType());
		battle.setSubjectId(battleModel.getSubjectId());
		battle.setLoveLifeGive(battleModel.getLoveLifeGive());
		battle.setCode(battleModel.getCode());
		battle.setCreaterDrawUserId(drawUser.getId());
		battle.setStageCount(battleModel.getStageCount());
		battle.setStageIndexCount(battleModel.getStageIndexCount());
		battle.setBeginDate(new DateTime());
		battle.setTimeLong(24);
		battle.setStatus(Constant.BATTLE_STATUS_FREE);
		battle.setIsReceiveReward(0);
		
		battleService.add(battle);
		for(BattleModelStage battleModelStage:battleModelStages){
			BattleStage battleStage = new BattleStage();
			battleStage.setBattleId(battle.getId());
			battleStage.setIsDel(0);
			battleStage.setPaperId(battleModelStage.getPaperId());
			battleStage.setScore(battleModelStage.getScore());
			battleStage.setStageIndex(battleModelStage.getStageIndex());
			battleStage.setPassScore(battleModelStage.getPassScore());
			battleStage.setPassScore2(battleModelStage.getPassScore2());
			battleStage.setPassScore3(battleModelStage.getPassScore3());
			battleStage.setPassScore4(battleModelStage.getPassScore4());
			battleStage.setImgUrl(battleModelStage.getImgUrl());
			battleStage.setName(battleModelStage.getName());
			battleStage.setConsumeBean(battleModelStage.getConsumeBean());
			battleStage.setRetakepartConsumeMasonry(battleModelStage.getRetakepartConsumeMasonry());
			battleStageService.add(battleStage);
		}
		
		for(BattleModelStageIndex battleModelStageIndex:battleModelStageIndexs){
			BattleStageIndexDetail battleStageIndexDetail = new BattleStageIndexDetail();
			battleStageIndexDetail.setBattleId(battle.getId());
			battleStageIndexDetail.setIconUrl(battleModelStageIndex.getIconUrl());
			battleStageIndexDetail.setIndex(battleModelStageIndex.getIndex());
			battleStageIndexDetail.setIsDel(0);
			battleStageIndexDetail.setIsGuide(battleModelStageIndex.getIsGuide());
			battleStageIndexDetail.setQuestionId(battleModelStageIndex.getQuestionId());
			battleStageIndexDetail.setRewardBeanNum(battleModelStageIndex.getRewardBeanNum());
			battleStageIndexDetail.setScore(battleModelStageIndex.getScore());
			battleStageIndexDetail.setStageindex(battleModelStageIndex.getStageindex());
			battleStageIndexDetail.setToHide(battleModelStageIndex.getToHide());
			
			battleStageIndexDetailService.add(battleStageIndexDetail);
		}
		
		List<BattleModelReward> battleModelRewards = battleModelRewardService.findAllByModelIdAndIsDel(modelId,0);
		
		for(BattleModelReward battleModelReward:battleModelRewards){
			BattleReward battleReward = new BattleReward();
			battleReward.setBattleId(battle.getId());
			battleReward.setRank(battleModelReward.getRank());
			battleReward.setRewardBean(battleModelReward.getRewardBean());
			battleReward.setRewardLove(battleModelReward.getRewardLove());
			battleReward.setRewardMasonry(battleModelReward.getRewardMasonry());
			battleReward.setRewardMoney(battleModelReward.getRewardMoney());
			battleReward.setStatus(Constant.BATTLE_REWARD_STATUS_FRESS);
			battleReward.setIsDel(0);
			battleRewardService.add(battleReward);
		}
		
		return battle;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
