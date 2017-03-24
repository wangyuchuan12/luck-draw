package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.Account;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.AccountService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DekornTakepartMember;
import com.wyc.draw.domain.DekornToTakepartMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.param.DekornTakepartParam;
import com.wyc.draw.service.DekornTakepartMemberService;

public class DekornTakepartFilter extends Filter{
	
	@Autowired
	private DekornTakepartMemberService dekornTakepartMemberService;
	
	@Autowired
	private AccountService accountService;

	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		DekornTakepartParam dekornTakepartParam = (DekornTakepartParam)filterManager.getObject(DekornTakepartParam.class);
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		String dekornId = dekornTakepartParam.getDekornId();
		if(CommonUtil.isEmpty(dekornId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("您输入的dekornId为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		DekornToTakepartMember dekornToTakepartMember = (DekornToTakepartMember)filterManager.getObject(DekornToTakepartMember.class);
		//设置剩余爱心总数
		dekornToTakepartMember.setResidueLifeLove(4);
		dekornToTakepartMember.setTakepartStatus(Constant.DEKORN_UNDERWAY_TAKEPART_STATUS);
		filterManager.update(dekornToTakepartMember);
		
		DekornTakepartMember dekornTakepartMember = new DekornTakepartMember();
		
		dekornTakepartMember.setDekornId(dekornId);
		dekornTakepartMember.setAdminId(drawUser.getAdminId());
		dekornTakepartMember.setDrawUserId(drawUser.getId());
		dekornTakepartMember.setHeadImg(drawUser.getImgUrl());
		dekornTakepartMember.setIsSuccess(0);
		dekornTakepartMember.setNickname(drawUser.getNickname());
		dekornTakepartMember.setObtainIntegralNum(0l);
		dekornTakepartMember.setObtainWisdomNum(0l);
		dekornTakepartMember.setOpenid(drawUser.getOpenid());
		dekornTakepartMember.setScore(0l);
		dekornTakepartMember.setTakepartDateTime(new DateTime());
		dekornTakepartMemberService.add(dekornTakepartMember);
		Integer deductLoveLife = 4;
		
		System.out.println(".............drawUser_id:"+drawUser.getId());
		System.out.println(".............accountId:"+drawUser.getAccountId());
		Account account = accountService.fineOneSync(drawUser.getAccountId());
		Integer loveLife = account.getLoveLife();
		if(loveLife >= deductLoveLife){
			account.setLoveLife(loveLife-deductLoveLife);
			accountService.update(account);
		}else{
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("您的爱心数量不足"+deductLoveLife+"颗");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("参选成功");
		resultVo.setData(dekornTakepartMember);
		return resultVo;
	}
	

	@Override
	public Object handlerAfter(SessionManager filterManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPrivateException(SessionManager filterManager, Method method, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPublicException(SessionManager filterManager, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(CurrentDekornToTakepartFilter.class);
		return classes;
	}

}
