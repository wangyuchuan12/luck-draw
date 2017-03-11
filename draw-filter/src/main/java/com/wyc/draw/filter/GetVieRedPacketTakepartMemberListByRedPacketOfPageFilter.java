package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.wyc.common.domain.vo.ResultPageListVo;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.MySimpleDateFormat;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.service.VieRedPacketTakepartMemberService;
import com.wyc.draw.vo.VieRedPacketTakepartMemberVo;

public class GetVieRedPacketTakepartMemberListByRedPacketOfPageFilter extends Filter{

	@Autowired
	private VieRedPacketTakepartMemberService vieRedPacketTakepartMemberService;
	
	@Autowired
	private MySimpleDateFormat mySimpleDateFormat;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		String redPacketId = httpServletRequest.getParameter("id");

		if(CommonUtil.isEmpty(redPacketId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("请输入redPacketId参数");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		String page = httpServletRequest.getParameter("page");
		String size = httpServletRequest.getParameter("size");
		
		if(CommonUtil.isEmpty(page)){
			page = "0";
		}
		
		if(CommonUtil.isEmpty(size)){
			size = "50";
		}
		
		Integer pageInt = Integer.parseInt(page);
		
		Integer sizeInt = Integer.parseInt(size);
		
		Order rightCountOrder = new Order(Direction.DESC, "rightCount");
		
		Order timelongOrder = new Order(Direction.ASC,"timeLong");
		
		Order updateAt = new Order(Direction.ASC,"updateAt");
		
		List<Order> orders = new ArrayList<>();
		orders.add(rightCountOrder);
		orders.add(timelongOrder);
		Sort sort = new Sort(rightCountOrder,timelongOrder,updateAt);
		
		PageRequest pageRequest = new PageRequest(pageInt, sizeInt, sort);
		
		Page<RedPacketTakepartMember> vieRedPacketTakepartMembers = vieRedPacketTakepartMemberService.findAllByRedPacketIdAndIsComplete(redPacketId, 1,pageRequest);
		
		ResultPageListVo resultPageListVo = new ResultPageListVo();
		List<VieRedPacketTakepartMemberVo> vieRedPacketTakepartMemberVos = new ArrayList<>();
		int index= 0;
		for(RedPacketTakepartMember vieRedPacketTakepartMember:vieRedPacketTakepartMembers){
			index++;
			VieRedPacketTakepartMemberVo vieRedPacketTakepartMemberVo = new VieRedPacketTakepartMemberVo();
			vieRedPacketTakepartMemberVo.setCurrentProblemId(vieRedPacketTakepartMember.getCurrentProblemId());
			vieRedPacketTakepartMemberVo.setDrawUserId(vieRedPacketTakepartMember.getDrawUserId());
			vieRedPacketTakepartMemberVo.setHeadImg(vieRedPacketTakepartMember.getHeadImg());
			vieRedPacketTakepartMemberVo.setId(vieRedPacketTakepartMember.getId());
			vieRedPacketTakepartMemberVo.setIsBest(vieRedPacketTakepartMember.getIsBest());
			vieRedPacketTakepartMemberVo.setIsComplete(vieRedPacketTakepartMember.getIsComplete());
			vieRedPacketTakepartMemberVo.setIsPay(vieRedPacketTakepartMember.getIsPay());
			vieRedPacketTakepartMemberVo.setNickname(vieRedPacketTakepartMember.getNickname());
			vieRedPacketTakepartMemberVo.setOpendid(vieRedPacketTakepartMember.getOpenid());
			vieRedPacketTakepartMemberVo.setRedPacketId(vieRedPacketTakepartMember.getRedPacketId());
			vieRedPacketTakepartMemberVo.setRightCount(vieRedPacketTakepartMember.getRightCount());
			vieRedPacketTakepartMemberVo.setTimeLong(vieRedPacketTakepartMember.getTimeLong());
			vieRedPacketTakepartMemberVo.setUserId(vieRedPacketTakepartMember.getUserId());
			vieRedPacketTakepartMemberVo.setWrongCount(vieRedPacketTakepartMember.getWrongCount());
			vieRedPacketTakepartMemberVo.setTimeLong(vieRedPacketTakepartMember.getTimeLong());
			vieRedPacketTakepartMemberVo.setRank(Long.parseLong((pageInt*sizeInt+index)+""));
			vieRedPacketTakepartMemberVo.setGetAmount(vieRedPacketTakepartMember.getGetAmount());
			vieRedPacketTakepartMemberVo.setTakepartDateTime(mySimpleDateFormat.format(vieRedPacketTakepartMember.getTakepartDateTime().toDate()));
			vieRedPacketTakepartMemberVo.setAnswer(vieRedPacketTakepartMember.getAnswer());
			vieRedPacketTakepartMemberVo.setIsSuccess(vieRedPacketTakepartMember.getIsSuccess());
			vieRedPacketTakepartMemberVos.add(vieRedPacketTakepartMemberVo);
			
			if(vieRedPacketTakepartMember.getDrawUserId().equals(drawUser.getId())){
				filterManager.save(vieRedPacketTakepartMemberVo);
			}
		}
		resultPageListVo.setDatas(vieRedPacketTakepartMemberVos);
		resultPageListVo.setPage(pageInt);
		resultPageListVo.setSize(sizeInt);
		resultPageListVo.setTotalSize(vieRedPacketTakepartMembers.getTotalElements());
		
		
		return resultPageListVo;
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
		return null;
	}

}
