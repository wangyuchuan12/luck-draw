package com.wyc.draw.filter;
import java.util.List;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.domain.param.PutUpRingParam;

public class PutUpRingRejectFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		PutUpRingParam putUpRingParam = (PutUpRingParam)sessionManager.getObject(PutUpRingParam.class);
		String dekornId = putUpRingParam.getDekornId();
		if(CommonUtil.isEmpty(dekornId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("您输入的dekornId为空");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(resultVo);
			return null;
		}
		

		Dekorn dekorn = sessionManager.findOne(Dekorn.class, dekornId);
		dekorn.setStatus(Constant.DEKORN_PROGRESS_REJECT);
		
		sessionManager.update(dekorn);
		return dekorn;
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
