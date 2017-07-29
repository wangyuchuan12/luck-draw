package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleMemberIndex;
import com.wyc.draw.domain.BattleMemberStage;
import com.wyc.draw.domain.BattleRankMember;
import com.wyc.draw.service.BattleMemberStageIndexService;
import com.wyc.draw.service.BattleMemberStageService;
import com.wyc.draw.service.BattleRankMemberService;
import com.wyc.draw.vo.BattleMemberStageIndexListVo;
import com.wyc.draw.vo.RewardVo;

public class BattleSubmitResultFilter extends Filter{

	@Autowired
	private BattleMemberStageService battleMemberStageService;
	
	
	@Autowired
	private BattleRankMemberService battleRankMemberService;
	
	@Autowired
	private BattleMemberStageIndexService battleMemberStageIndexService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		BattleMemberStage battleMemberStage = sessionManager.getObject(BattleMemberStage.class);
		BattleMember battleMember = sessionManager.getObject(BattleMember.class);
		
		
		if(battleMemberStage.getStatus()==Constant.BM_STATUS_IN){
			battleMemberStage.setStatus(Constant.BM_STATUS_END);
			
			
			BattleMemberStageIndexListVo battleMemberStageIndexListVo = sessionManager.getObject(BattleMemberStageIndexListVo.class);
			
			List<BattleMemberIndex> battleMemberIndexs = battleMemberStageIndexListVo.getBattleMemberIndexs();
			BattleRankMember battleRankMember = sessionManager.getObject(BattleRankMember.class);
			RewardVo rewardVo = new RewardVo();
			for(BattleMemberIndex battleMemberIndex:battleMemberIndexs){
				if(battleMemberIndex.getIsRight()==1){
					Integer score = battleMemberStage.getScore();
					if(score==null){
						score = 0;
					}
					score = score+battleMemberIndex.getScore();
					battleMemberStage.setScore(score);
					
					Integer allScore = battleMember.getScore();
					if(allScore==0){
						allScore = 0;
					}
					allScore = allScore+battleMemberIndex.getScore();
					battleMember.setScore(allScore);
					
					Long addWisdomNum = rewardVo.getAddWisdomNum();
					if(addWisdomNum==null){
						addWisdomNum = 0l;
					}
					addWisdomNum = battleMemberIndex.getRewardBeanNum()+addWisdomNum;
					rewardVo.setAddWisdomNum(addWisdomNum);;
				}else{
					Integer loveScore = battleMember.getLoveLife();
					if(loveScore==null){
						loveScore = 0;
					}
					loveScore--;
					if(loveScore<0){
						loveScore = 0;
					}
					battleMember.setLoveLife(loveScore);
					
					battleMemberIndex.setRewardBeanNum(0);
					battleMemberStageIndexService.update(battleMemberIndex);
				}
				
				battleRankMember.setIndex(battleMemberIndex.getIndex());
			}
			
			sessionManager.save(rewardVo);
			Integer score = battleMemberStage.getScore();
			if(score>=battleMemberStage.getPassScore()){
				battleMemberStage.setIsPass(1);
			}else{
				battleMemberStage.setIsPass(0);
			}
			
			battleMemberStageService.update(battleMemberStage);
			
			sessionManager.update(battleMember);;
			
			battleRankMemberService.update(battleRankMember);
			
			return battleMemberStage;
		}else{
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("该阶段状态不对");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(resultVo);
		}
		return battleMemberStage;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
