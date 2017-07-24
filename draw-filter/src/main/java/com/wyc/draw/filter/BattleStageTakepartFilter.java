package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleMemberStage;
import com.wyc.draw.service.BattleMemberService;
import com.wyc.draw.service.BattleMemberStageService;
import com.wyc.draw.vo.RewardVo;

public class BattleStageTakepartFilter extends Filter{

	@Autowired
	private BattleMemberStageService battleMemberStageService;
	
	@Autowired
	private BattleMemberService battleMemberService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		BattleMember battleMember = sessionManager.getObject(BattleMember.class);
		Integer stage = (Integer)sessionManager.getAttribute("stage");
		String battleId = sessionManager.getAttribute("battleId").toString();
		BattleMemberStage battleMemberStage = battleMemberStageService.findOneByMemberIdAndBattleIdAndStageIndexAndStatus(battleMember.getId(),battleId, stage,Constant.BM_STATUS_FREE);
		if(battleMemberStage==null){
			sessionManager.setReturn(true);
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("该阶段不存在或者极端状态不是游离状态");
			sessionManager.setReturnValue(resultVo);
			return null;
		}else{
			battleMemberStage.setStatus(Constant.BM_STATUS_IN);
			battleMemberStageService.update(battleMemberStage);

			battleMember.setCurrentStageIndex(stage);
			battleMemberService.update(battleMember);
			
			RewardVo rewardVo = new RewardVo();
			if(battleMemberStage.getConsumeBean()!=null&&battleMemberStage.getConsumeBean()!=0){
				
				rewardVo.setSubWisdomNum(battleMemberStage.getConsumeBean().longValue());
				sessionManager.save(rewardVo);
			}else{
				sessionManager.addNotExecuteFilterClass(RewardFilter.class);
			}
			
			
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(true);
			resultVo.setMsg("参加成功");
			resultVo.setData(rewardVo);
			return resultVo;
			
		}

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
