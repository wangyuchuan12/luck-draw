package com.wyc.draw.filter;
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
	public Object handlerFilter(SessionManager filterManager) throws Exception {
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

		if(dekornToTakepartMember.getTakepartStatus()!=Constant.DEKORN_UNDERWAY_TAKEPART_STATUS||dekornToTakepartMember.getResidueLifeLove()<=0){
			Integer deductLoveLife = 4;
			Account account = accountService.fineOneSync(drawUser.getAccountId());
			Integer loveLife = account.getLoveLife();
			if(loveLife >= deductLoveLife){
				account.setLoveLife(loveLife-deductLoveLife);
				accountService.update(account);
				dekornToTakepartMember.setResidueLifeLove(deductLoveLife);
			}else{
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("您的爱心数量不足"+deductLoveLife+"颗");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				
				dekornToTakepartMember.setTakepartStatus(Constant.DEKORN_COMPLETE_TAKEPART_STATUS);
				return null;
			}
		}else{
			System.out.println("....................这里没有进来");
		}
		
		//设置剩余爱心总数
		dekornToTakepartMember.setResidueLifeLove(dekornToTakepartMember.getResidueLifeLove()-1);
		dekornToTakepartMember.setTakepartStatus(Constant.DEKORN_UNDERWAY_TAKEPART_STATUS);
		
		
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
		dekornTakepartMember.setTakepartStatus(Constant.DEKORN_UNDERWAY_TAKEPART_STATUS);
		dekornTakepartMemberService.add(dekornTakepartMember);
		
		dekornToTakepartMember.setCurrentTakepartMemberId(dekornTakepartMember.getId());
		
		filterManager.update(dekornToTakepartMember);
		
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("参选成功");
		resultVo.setData(dekornTakepartMember);
		return resultVo;
	}
	

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(CurrentDekornToTakepartFilter.class);
		return classes;
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
