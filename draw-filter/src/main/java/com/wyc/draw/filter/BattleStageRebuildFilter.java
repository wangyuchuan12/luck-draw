package com.wyc.draw.filter;

import java.util.List;

import org.joda.time.DateTime;
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

public class BattleStageRebuildFilter extends Filter{

	@Autowired
	private BattleMemberStageService battleMemberStageService;
	
	@Autowired
	private BattleMemberStageIndexService battleMemberStageIndexService;
	
	@Autowired
	private PaperAnswerService paperAnswerService;
	
	@Autowired
	private QuestionAnswerService questionAnswerService;
	
	@Autowired
	private BattleMemberService battleMemberService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Integer stage = (Integer)sessionManager.getAttribute("stage");
		String battleId = (String)sessionManager.getAttribute("battleId");
		BattleMember battleMember = (BattleMember)sessionManager.getObject(BattleMember.class);
		BattleMemberStage battleMemberStage = battleMemberStageService.findOneByMemberIdAndBattleIdAndStageIndexAndIsDel(battleMember.getId(), battleId, stage, 0);
		if(battleMemberStage!=null){
			battleMemberStage.setIsDel(1);
			battleMemberStageService.update(battleMemberStage);
		}else{

			sessionManager.setEnd(true);
			return null;
		}
		
		Integer score = battleMember.getScore();
		if(score==null){
			score = 0;
		}
		System.out.println("..........score:"+score);
		score = score-battleMemberStage.getScore();
		battleMember.setScore(score);
		
		System.out.println("...............score:"+score);
		
		sessionManager.update(battleMember);
		
		PaperAnswer paperAnswer = paperAnswerService.findOneByKeyIdAndPaperIdAndIsDel(battleMember.getId()+"_"+stage, battleMemberStage.getPaperId(), 0);
		if(paperAnswer!=null){
			paperAnswer.setIsDel(1);
			paperAnswerService.update(paperAnswer);
		}
		
		List<QuestionAnswer> questionAnswers = questionAnswerService.findAllByPaperIdAndKeyIdAndIsDel(battleMemberStage.getPaperId(), battleMember.getId()+"_"+stage, 0);
		
		if(questionAnswers!=null&&questionAnswers.size()>0){
			for(QuestionAnswer questionAnswer:questionAnswers){
				questionAnswer.setIsDel(1);
				questionAnswerService.update(questionAnswer);
			}
		}
		BattleMemberStage battleMemberStage2 =  new BattleMemberStage();
		battleMemberStage2.setBattleId(battleId);
		battleMemberStage2.setConsumeBean(battleMemberStage.getConsumeBean());
		battleMemberStage2.setCurrentIndex(0);
		battleMemberStage2.setEndTime(battleMemberStage.getEndTime());
		battleMemberStage2.setIconUrl(battleMemberStage.getIconUrl());
		battleMemberStage2.setImgUrl(battleMemberStage.getImgUrl());
		battleMemberStage2.setIndex(battleMemberStage.getIndex());
		battleMemberStage2.setIsDel(0);
		battleMemberStage2.setIsPass(0);
		battleMemberStage2.setPassScore(battleMemberStage.getPassScore());
		battleMemberStage2.setPassScore2(battleMemberStage.getPassScore2());
		battleMemberStage2.setPassScore3(battleMemberStage.getPassScore3());
		battleMemberStage2.setPassScore4(battleMemberStage.getPassScore4());
		battleMemberStage2.setRewardBeanNum(battleMemberStage.getRewardBeanNum());
		battleMemberStage2.setScore(0);
		battleMemberStage2.setStageIndex(battleMemberStage.getStageIndex());
		battleMemberStage2.setIsSyncIndex(0);
		battleMemberStage2.setStatus(Constant.BM_STATUS_FREE);
		battleMemberStage2.setStartTime(new DateTime());
		battleMemberStage2.setPaperId(battleMemberStage.getPaperId());
		battleMemberStage2.setName(battleMemberStage.getName());
		battleMemberStage2.setMemberId(battleMemberStage.getMemberId());
		battleMemberStage2.setIsWin(0);
		battleMemberStage2.setIsReadResult(battleMemberStage.getIsReadResult());
		battleMemberStageService.add(battleMemberStage2);
		
		List<BattleMemberIndex> battleMemberIndexs = battleMemberStageIndexService.findAllByBattleIdAndMemberIdAndStageIndexAndIsDelOrderByIndexAsc(battleId, battleMember.getId(), stage,0);
		for(BattleMemberIndex battleMemberIndex:battleMemberIndexs){
			battleMemberIndex.setIsDel(1);
			battleMemberStageIndexService.update(battleMemberIndex);
			
			/*BattleMemberIndex battleMemberIndex2 = new BattleMemberIndex();
			battleMemberIndex2.setBattleId(battleMemberIndex.getBattleId());
			battleMemberIndex2.setIconUrl(battleMemberIndex.getIconUrl());
			battleMemberIndex2.setIndex(battleMemberIndex.getIndex());
			battleMemberIndex2.setIsDel(0);
			battleMemberIndex2.setIsGuide(battleMemberIndex.getIsGuide());
			battleMemberIndex2.setIsRight(0);
			battleMemberIndex2.setMemberId(battleMemberIndex.getMemberId());
			battleMemberIndex2.setQuestionId(battleMemberIndex.getQuestionId());
			battleMemberIndex2.setRewardBeanNum(0);
			battleMemberIndex2.setScore(0);
			battleMemberIndex2.setStageIndex(battleMemberIndex.getStageIndex());
			battleMemberIndex2.setStatus(Constant.BM_STATUS_FREE);
			battleMemberIndex2.setToHide(battleMemberIndex.getToHide());
			battleMemberStageIndexService.add(battleMemberIndex2);*/
		}
		
		
		return battleMemberStage2;
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
