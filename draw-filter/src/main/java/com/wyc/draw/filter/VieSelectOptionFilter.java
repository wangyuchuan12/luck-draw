package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.VieRedPacketOption;
import com.wyc.draw.domain.VieRedPacketTakepartMember;
import com.wyc.draw.domain.VieRedPacketTakepartMemberRecord;
import com.wyc.draw.service.VieRedPacketOptionService;
import com.wyc.draw.service.VieRedPacketTakepartMemberRecordService;
import com.wyc.draw.service.VieRedPacketTakepartMemberService;

public class VieSelectOptionFilter extends Filter{

	@Autowired
	private VieRedPacketOptionService vieRedPacketOptionService;
	
	@Autowired
	private VieRedPacketTakepartMemberService vieRedPacketTakepartMemberService;
	
	@Autowired
	private VieRedPacketTakepartMemberRecordService vieRedPacketTakepartMemberRecordService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		String optionId = httpServletRequest.getParameter("option_id");
		String problemId = httpServletRequest.getParameter("problem_id");
		String memberId = httpServletRequest.getParameter("member_id");
		
		String isTimeout = httpServletRequest.getParameter("is_timeout");
		
		String timeLong  = httpServletRequest.getParameter("time_long");
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		
		
		if(CommonUtil.isEmpty(timeLong)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("timeLong参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		Long timeLongLong;
		
		try{
			timeLongLong = Long.parseLong(timeLong);
		}catch(Exception e){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("timeLong参数转换失败");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(timeLongLong==0){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("timeLong不能为0");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(timeLongLong>60){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("timeLong不能大于60");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(optionId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("optionId参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		if(CommonUtil.isEmpty(problemId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("problemId参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		VieRedPacketOption vieRedPacketOption = vieRedPacketOptionService.findOne(optionId);
		if(vieRedPacketOption==null){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("传送的选项id不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(!vieRedPacketOption.getRedPacketProblemId().equals(problemId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("选项所对应的问题和传出的问题id不匹配");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(memberId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("memberId参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(isTimeout)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("isTimeout参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		Integer isTimeoutInt;
		try{
			isTimeoutInt = Integer.parseInt(isTimeout);
		}catch(Exception e){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("isTimeout转数字失败，不是数字类型");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(isTimeoutInt!=0&&isTimeoutInt!=1){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("isTimeout参数超出范围");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		VieRedPacketTakepartMember vieRedPacketTakepartMember = vieRedPacketTakepartMemberService.findOne(memberId);
		if(vieRedPacketTakepartMember==null){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("返回的vieRedPacketTakepartMember对象为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(!vieRedPacketTakepartMember.getDrawUserId().equals(drawUser.getId())){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("返回的该红包参与对象不属于该用户");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		VieRedPacketTakepartMemberRecord vieRedPacketTakepartMemberRecord = new VieRedPacketTakepartMemberRecord();
		vieRedPacketTakepartMemberRecord.setIsTimeout(isTimeoutInt);
		vieRedPacketTakepartMemberRecord.setVieRedPacketOptionId(optionId);
		vieRedPacketTakepartMemberRecord.setVieRedPacketProblemId(problemId);
		if(isTimeoutInt==1){
			vieRedPacketTakepartMemberRecord.setIsRight(0);
		}else{
			int isRight = vieRedPacketOption.getIsRight();
			vieRedPacketTakepartMemberRecord.setIsRight(isRight);
		}
		vieRedPacketTakepartMemberRecord.setTimeLong(timeLongLong);
		vieRedPacketTakepartMemberRecord = vieRedPacketTakepartMemberRecordService.add(vieRedPacketTakepartMemberRecord);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(vieRedPacketTakepartMemberRecord);
		resultVo.setMsg("参与成功");
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
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(DrawUserFilter.class);
		return filters;
	}

}
