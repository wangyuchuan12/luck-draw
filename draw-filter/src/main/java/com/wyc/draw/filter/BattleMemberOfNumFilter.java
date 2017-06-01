package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.service.BattleMemberService;
import com.wyc.draw.vo.BattleMemberListVo;

public class BattleMemberOfNumFilter extends Filter{

	@Autowired
	private BattleMemberService battleMemberService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		String num = sessionManager.getAttribute("num").toString();
		String battleId = sessionManager.getAttribute("battleId").toString();
		int pageInt = 0;
		int sizeInt = Integer.parseInt(num);
		Sort sort = new Sort(Direction.DESC,"takepartTime");
		PageRequest pageRequest = new PageRequest(pageInt, sizeInt, sort);
		List<BattleMember> battleMembers = battleMemberService.findAllByBattleId(battleId,pageRequest);
		
		BattleMemberListVo battleMemberListVo = new BattleMemberListVo();
		battleMemberListVo.setBattleMembers(battleMembers);
		return battleMemberListVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		String num = sessionManager.getHttpServletRequest().getParameter("num");
		if(CommonUtil.isEmpty(num)){
			sessionManager.setAttribute("num", 4);
		}else{
			sessionManager.setAttribute("num", num);
		}
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
