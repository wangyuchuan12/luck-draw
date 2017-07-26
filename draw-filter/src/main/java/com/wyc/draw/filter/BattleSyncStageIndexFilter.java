package com.wyc.draw.filter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleMemberIndex;
import com.wyc.draw.domain.BattleMemberStage;
import com.wyc.draw.domain.QuestionAnswer;
import com.wyc.draw.service.BattleMemberStageIndexService;
import com.wyc.draw.service.BattleMemberStageService;
import com.wyc.draw.service.QuestionAnswerService;
import com.wyc.draw.vo.BattleMemberStageIndexListVo;

public class BattleSyncStageIndexFilter extends Filter{
	
	@Autowired
	private QuestionAnswerService questionAnswerService;
	
	@Autowired
	private BattleMemberStageIndexService battleMemberStageIndexService;
	
	@Autowired
	private BattleMemberStageService battleMemberStageService;
	
	/*@Autowired
	private BattleMemberService battleMemberService;*/
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		BattleMember battleMember = (BattleMember)sessionManager.getObject(BattleMember.class);
		Integer stage = (Integer)sessionManager.getAttribute("stage");
		String battleId = (String)sessionManager.getAttribute("battleId");
		BattleMemberStage battleMemberStage = battleMemberStageService.findOneByMemberIdAndBattleIdAndStageIndexAndIsDel(battleMember.getId(),battleId,stage,0);
		sessionManager.save(battleMemberStage);
		if(battleMemberStage.getStatus()==Constant.BM_STATUS_IN){
			List<QuestionAnswer> questionAnswers = questionAnswerService.findAllByKeyIdAndPaperIdAndTypeAndIsDel(battleMember.getId()+"_"+stage, battleMemberStage.getPaperId(), Constant.PAPER_ANSWER_TYPE_BATTLE,0);
			Map<String, QuestionAnswer> questionAnswerMap = new HashMap<>();
			for(QuestionAnswer questionAnswer:questionAnswers){
				questionAnswerMap.put(questionAnswer.getQuestionId(), questionAnswer);
			}
			List<BattleMemberIndex> battleMemberIndexs = battleMemberStageIndexService.findAllByBattleIdAndMemberIdAndStageIndexAndIsDelOrderByIndexAsc(battleMemberStage.getBattleId(), battleMemberStage.getMemberId(), battleMemberStage.getStageIndex(),0);
			
			for(BattleMemberIndex battleMemberIndex:battleMemberIndexs){
				QuestionAnswer questionAnswer = questionAnswerMap.get(battleMemberIndex.getQuestionId());
				
				if(questionAnswer!=null){
					battleMemberIndex.setIsRight(questionAnswer.getIsRight());
				}
				battleMemberIndex.setStatus(Constant.BM_STATUS_END);
				
				if(battleMemberIndex.getIsRight()!=1){
					/*battleMemberIndex.setRewardBeanNum(0);
					
					Integer loveLifeCount = battleMember.getLoveLife();
					if(loveLifeCount==null){
						loveLifeCount = 0; 
					}
					loveLifeCount--;
					if(loveLifeCount<0){
						loveLifeCount = 0;
					}
					battleMember.setLoveLife(loveLifeCount);*/
				}else{
//					Integer stageScore = battleMemberStage.getScore();
//					if(stageScore==null){
//						stageScore = 0;
//					}
//					stageScore = stageScore+battleMemberIndex.getScore();
//					battleMemberStage.setScore(stageScore);
//					
//					System.out.println("..................stageScore:"+stageScore);
				}
				battleMemberStageIndexService.update(battleMemberIndex);
			}
			BattleMemberStageIndexListVo battleMemberStageIndexListVo = new BattleMemberStageIndexListVo();
			battleMemberStageIndexListVo.setBattleMemberIndexs(battleMemberIndexs);
		//	battleMemberStageService.update(battleMemberStage);
		//	battleMemberService.update(battleMember);
			return battleMemberStageIndexListVo;
		}else{
			
		}
		return null;
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
