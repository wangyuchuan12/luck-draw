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
import com.wyc.draw.domain.PaperAnswer;
import com.wyc.draw.domain.QuestionAnswer;
import com.wyc.draw.service.BattleMemberService;
import com.wyc.draw.service.BattleMemberStageIndexService;
import com.wyc.draw.service.BattleMemberStageService;
import com.wyc.draw.service.PaperAnswerService;
import com.wyc.draw.service.QuestionAnswerService;
import com.wyc.draw.vo.BattleMemberStageIndexListVo;

public class BattleSyncStageIndexFilter extends Filter{
	
	@Autowired
	private QuestionAnswerService questionAnswerService;
	
	@Autowired
	private BattleMemberStageIndexService battleMemberStageIndexService;
	
	@Autowired
	private BattleMemberStageService battleMemberStageService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		BattleMember battleMember = (BattleMember)sessionManager.getObject(BattleMember.class);
		Integer stage = (Integer)sessionManager.getAttribute("stage");
		String battleId = (String)sessionManager.getAttribute("battleId");
		BattleMemberStage battleMemberStage = battleMemberStageService.findOneByMemberIdAndBattleIdAndStageIndex(battleMember.getId(),battleId,stage);
		sessionManager.save(battleMemberStage);
		if(battleMemberStage.getStatus()==Constant.BM_STATUS_IN){
			List<QuestionAnswer> questionAnswers = questionAnswerService.findAllByKeyIdAndPaperIdAndType(battleMember.getId()+"_"+stage, battleMemberStage.getPaperId(), Constant.PAPER_ANSWER_TYPE_BATTLE);
			Map<String, QuestionAnswer> questionAnswerMap = new HashMap<>();
			for(QuestionAnswer questionAnswer:questionAnswers){
				questionAnswerMap.put(questionAnswer.getQuestionId(), questionAnswer);
			}
			List<BattleMemberIndex> battleMemberIndexs = battleMemberStageIndexService.findAllByBattleIdAndMemberIdAndStageIndexOrderByIndexAsc(battleMemberStage.getBattleId(), battleMemberStage.getMemberId(), battleMemberStage.getStageIndex());
			
			for(BattleMemberIndex battleMemberIndex:battleMemberIndexs){
				QuestionAnswer questionAnswer = questionAnswerMap.get(battleMemberIndex.getQuestionId());
				
				if(questionAnswer!=null){
					battleMemberIndex.setIsRight(questionAnswer.getIsRight());
				}
				battleMemberIndex.setStatus(Constant.BM_STATUS_END);
				battleMemberStageIndexService.update(battleMemberIndex);
			}
			BattleMemberStageIndexListVo battleMemberStageIndexListVo = new BattleMemberStageIndexListVo();
			battleMemberStageIndexListVo.setBattleMemberIndexs(battleMemberIndexs);
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
