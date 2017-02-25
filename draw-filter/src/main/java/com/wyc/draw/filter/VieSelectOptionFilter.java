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
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.domain.VieRedPacketOption;
import com.wyc.draw.domain.VieRedPacketProblem;
import com.wyc.draw.domain.VieRedPacketTakepartMemberRecord;
import com.wyc.draw.domain.param.VieSelectOptionParam;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.service.RedPacketTakepartMemberService;
import com.wyc.draw.service.VieRedPacketOptionService;
import com.wyc.draw.service.VieRedPacketProblemService;
import com.wyc.draw.service.VieRedPacketTakepartMemberRecordService;
import com.wyc.draw.service.VieRedPacketTakepartMemberService;
import com.wyc.draw.vo.OptionSelectVo;

public class VieSelectOptionFilter extends Filter{

	@Autowired
	private VieRedPacketOptionService vieRedPacketOptionService;
	
	@Autowired
	private VieRedPacketTakepartMemberService vieRedPacketTakepartMemberService;
	
	@Autowired
	private VieRedPacketTakepartMemberRecordService vieRedPacketTakepartMemberRecordService;
	
	@Autowired
	private VieRedPacketProblemService vieRedPacketProblemService;
	
	@Autowired
	private RedPacketService redPacketService;
	
	@Autowired
	private RedPacketTakepartMemberService redPacketTakepartMemberService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		VieSelectOptionParam vieSelectOptionParam = (VieSelectOptionParam)filterManager.getObject(VieSelectOptionParam.class);
		
		String optionId = vieSelectOptionParam.getOptionId();
		String problemId = vieSelectOptionParam.getProblemId();
		String memberId = vieSelectOptionParam.getMemberId();
		
		String isTimeout = vieSelectOptionParam.getIsTimeout();
		
		String timeLong  = vieSelectOptionParam.getTimeLong();
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		
		
		if(CommonUtil.isEmpty(timeLong)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("timeLong参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		Float timeLongFloat;
		
		try{
			timeLongFloat = Float.parseFloat(timeLong);
		}catch(Exception e){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("timeLong参数转换失败");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(timeLongFloat==0){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("timeLong不能为0");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(timeLongFloat>60){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("timeLong不能大于60");
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
		RedPacketTakepartMember vieRedPacketTakepartMember = vieRedPacketTakepartMemberService.findOne(memberId);
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
		
		
		VieRedPacketProblem vieRedPacketProblem = vieRedPacketProblemService.findOne(problemId);
		
		if(vieRedPacketProblem==null){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("返回的红包问题对象为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		OptionSelectVo optionSelectVo = new OptionSelectVo();
		VieRedPacketTakepartMemberRecord vieRedPacketTakepartMemberRecord = new VieRedPacketTakepartMemberRecord();
		vieRedPacketTakepartMemberRecord.setIsTimeout(isTimeoutInt);
		vieRedPacketTakepartMemberRecord.setVieRedPacketOptionId(optionId);
		vieRedPacketTakepartMemberRecord.setVieRedPacketProblemId(problemId);
		if(isTimeoutInt==1){
			vieRedPacketTakepartMemberRecord.setIsRight(0);
			optionSelectVo.setIsRight(0);
			optionSelectVo.setIsTimeout(1);
		}else{
			if(CommonUtil.isEmpty(optionId)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("optionId参数不能为空");
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
			
			int isRight = vieRedPacketOption.getIsRight();
			vieRedPacketTakepartMemberRecord.setIsRight(isRight);
			optionSelectVo.setIsRight(isRight);
			optionSelectVo.setIsTimeout(0);
			
			if(isRight==1){
				Long rightCount = vieRedPacketTakepartMember.getRightCount();
				if(rightCount==null){
					rightCount=0L;
				}
				vieRedPacketTakepartMember.setRightCount(rightCount+1);
			}else{
				Long wrongCount = vieRedPacketTakepartMember.getWrongCount();
				if(wrongCount==null){
					wrongCount=0L;
				}
				vieRedPacketTakepartMember.setWrongCount(wrongCount+1);
			}
			
		}
		
		Float countTimeFloat = vieRedPacketTakepartMember.getTimeLong();
		if(countTimeFloat==null){
			countTimeFloat=0f;
		}
		countTimeFloat=countTimeFloat+timeLongFloat;
		vieRedPacketTakepartMember.setTimeLong(countTimeFloat);
		vieRedPacketTakepartMember.setCurrentProblemId(problemId);
		
		//判断选项是不是第一个
		VieRedPacketProblem firstVieRedPacketProblem = vieRedPacketProblemService.getFirstByRedPacketId(vieRedPacketProblem.getRedPacketId());
		if(firstVieRedPacketProblem.getId().equals(problemId)){
			optionSelectVo.setIsFirst(1);
		}else{
			optionSelectVo.setIsFirst(0);
		}
		
		//判断选项是不是最后一个
		VieRedPacketProblem lastVieRedPacketProblem = vieRedPacketProblemService.getLastByRedPacketId(vieRedPacketProblem.getRedPacketId());
		if(lastVieRedPacketProblem.getId().equals(problemId)){
			optionSelectVo.setIsLast(1);
			vieRedPacketTakepartMember.setIsComplete(1);

			
			List<RedPacketTakepartMember> bestTakepartMembers = vieRedPacketTakepartMemberService.findAllByRedPacketIdAndIsBest(vieRedPacketTakepartMember.getRedPacketId(),1);
			//设置最佳答案
			if(bestTakepartMembers==null||bestTakepartMembers.size()==0){
				vieRedPacketTakepartMember.setIsBest(1);
				vieRedPacketTakepartMemberService.update(vieRedPacketTakepartMember);
			}else{
				for(RedPacketTakepartMember bestRedPacketTakepartMember:bestTakepartMembers){
					Long bestRightCount = bestRedPacketTakepartMember.getRightCount();
					Float bestTimeLong = bestRedPacketTakepartMember.getTimeLong();
					
					if(bestRightCount>vieRedPacketTakepartMember.getRightCount()){
						
					}else if(bestRightCount<vieRedPacketTakepartMember.getRightCount()){
						vieRedPacketTakepartMember.setIsBest(1);
						bestRedPacketTakepartMember.setIsBest(0);
						vieRedPacketTakepartMemberService.update(vieRedPacketTakepartMember);
						vieRedPacketTakepartMemberService.update(bestRedPacketTakepartMember);
					}else{
						if(bestTimeLong>vieRedPacketTakepartMember.getTimeLong()){
							vieRedPacketTakepartMember.setIsBest(1);
							bestRedPacketTakepartMember.setIsBest(0);
							vieRedPacketTakepartMemberService.update(vieRedPacketTakepartMember);
							vieRedPacketTakepartMemberService.update(bestRedPacketTakepartMember);
						}else{
							vieRedPacketTakepartMember.setIsBest(0);
							vieRedPacketTakepartMemberService.update(vieRedPacketTakepartMember);
						}
					}
				}
			}
			
		}else{
			optionSelectVo.setIsLast(0);
		}

		
		vieRedPacketTakepartMember = vieRedPacketTakepartMemberService.update(vieRedPacketTakepartMember);
		vieRedPacketTakepartMemberRecord.setTimeLong(timeLongFloat);
		vieRedPacketTakepartMemberRecord.setMemberId(memberId);
		vieRedPacketTakepartMemberRecord = vieRedPacketTakepartMemberRecordService.add(vieRedPacketTakepartMemberRecord);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(optionSelectVo);
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
		return null;
	}

}
