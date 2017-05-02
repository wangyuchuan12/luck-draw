package com.wyc.draw.filter;
import java.util.List;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.domain.DekornTakepartMember;
import com.wyc.draw.domain.param.DekornResultParam;
import com.wyc.draw.vo.RewardVo;

public class DekornFailHandleFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		DekornResultParam dekornResultParam = (DekornResultParam)sessionManager.getObject(DekornResultParam.class);
		String takepartMemberId = dekornResultParam.getTakepartMemberId();
		
		String dekornId = dekornResultParam.getDekornId();
		if(CommonUtil.isEmpty(takepartMemberId)){
			ResultVo errorResultVo = new ResultVo();
			errorResultVo.setSuccess(false);
			errorResultVo.setErrorMsg("takepartMemberId参数不能为空");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(errorResultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(dekornId)){
			ResultVo errorResultVo = new ResultVo();
			errorResultVo.setSuccess(false);
			errorResultVo.setErrorMsg("dekornId参数不能为空");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(errorResultVo);
			return null;
		}
	
		
		DekornTakepartMember dekornTakepartMember = (DekornTakepartMember)sessionManager.findOne(DekornTakepartMember.class, takepartMemberId);
		if(CommonUtil.isEmpty(dekornTakepartMember)){
			ResultVo errorResultVo = new ResultVo();
			errorResultVo.setSuccess(false);
			errorResultVo.setErrorMsg("dekornTakepartMember对象为空");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(errorResultVo);
			return null;
		}
		
		Dekorn dekorn = (Dekorn)sessionManager.findOne(Dekorn.class,dekornId);
		
		if(CommonUtil.isEmpty(dekorn)){
			ResultVo errorResultVo = new ResultVo();
			errorResultVo.setSuccess(false);
			errorResultVo.setErrorMsg("dekorn对象为空");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(errorResultVo);
			return null;
		}
		
		if(!dekornTakepartMember.getDekornId().equals(dekornId)){
			ResultVo errorResultVo = new ResultVo();
			errorResultVo.setSuccess(false);
			errorResultVo.setErrorMsg("参选对象不属于该挑战");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(errorResultVo);
			return null;
		}
		
		Long fightFailIntegralNum = dekorn.getFightFailIntegralNum();
		
		Long fightFailWisdomNum = dekorn.getFightFailWisdomNum();
		
		RewardVo rewardVo = new RewardVo();
		
		rewardVo.setAddIntegralNum(fightFailIntegralNum);
		
		if(fightFailWisdomNum>0){
			rewardVo.setAddWisdomNum(fightFailWisdomNum);
		}else{
			rewardVo.setSubWisdomNum(-fightFailWisdomNum);
		}
		
		return rewardVo;
	}


	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
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
