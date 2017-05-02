package com.wyc.draw.filter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.ApplyForm;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.ApplyFormService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.other.UserInfoApplyFormHandleService;

public class InitDrawUserFilter extends Filter{
	
	@Autowired
	private ApplyFormService applyFormService;
	
	@Autowired
	private UserInfoApplyFormHandleService userInfoApplyFormHandleService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		
		
		
		List<ApplyForm> applyForms = applyFormService.findAllByOpenidAndTypeAndStatus(drawUser.getOpenid(),Constant.APPLY_FORM_TYPE_TAKE_IN,Constant.AUDIT_DRAW_ROOM_MEMEBER_STATUS);
		
		if(applyForms!=null&&applyForms.size()>0){
			for(ApplyForm applyForm:applyForms){
				userInfoApplyFormHandleService.handTakeIn(drawUser.getId(),applyForm);
				
			}
		}
		
		return drawUser;
	}
	
	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(BaseDrawActionFilter.class);
		return filterClasses;
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
