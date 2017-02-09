package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.VieRedPacketOption;
import com.wyc.draw.domain.VieRedPacketProblem;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.service.VieRedPacketOptionService;
import com.wyc.draw.service.VieRedPacketProblemService;

public class HandRedPacketQuestionFilter extends Filter{

	@Autowired
	private VieRedPacketOptionService vieRedPacketOptionService;
	
	@Autowired
	private VieRedPacketProblemService vieRedPacketProblemService;
	
	@Autowired
	private RedPacketService redPacketService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String type = httpServletRequest.getParameter("type");
		
		String redPacketId = httpServletRequest.getParameter("red_packet_id");
		
		String problemId =  httpServletRequest.getParameter("problem_id");
		
		String optionJson = httpServletRequest.getParameter("options");

		String imgUrl = httpServletRequest.getParameter("imgUrl");
		
		String question = httpServletRequest.getParameter("question");
		
		String previousProblemId = httpServletRequest.getParameter("previous_problem_id");
		
		String isFirst = httpServletRequest.getParameter("is_first");
		
		
		if(CommonUtil.isEmpty(redPacketId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("redPacketId参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		
		RedPacket redPacket = redPacketService.findOne(redPacketId);
		
		if(CommonUtil.isEmpty(redPacket)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("返回的redPacket为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(optionJson)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("options参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(type)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("type不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(question)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("question不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		TypeReference<Map<String, Object>> typeReference = new TypeReference<Map<String,Object>>() {
		};
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> optionMap = null;
		
		try{

			optionMap = objectMapper.readValue(optionJson, typeReference);
		}catch(Exception e){	
			e.printStackTrace();
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("解析选项数据产生异常");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		
		//0表示新增，1表示修改
		Integer typeInt = null;
		try{
			typeInt = Integer.parseInt(type);
		}catch(Exception e){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("type不是int类型");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		List<Map<String, Object>> addOptions = (List<Map<String, Object>>)optionMap.get("add");
		
		List<String> delOptionIds = (List<String>)optionMap.get("del");
		
		List<Map<String, Object>> updateOptions = (List<Map<String,Object>>)optionMap.get("update");
		
		
		if(typeInt==0){
			
			if(CommonUtil.isEmpty(isFirst)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("isFirst参数不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			Integer isFirstInt = null;
			
			try{
				isFirstInt = Integer.parseInt(isFirst);
			}catch(Exception e){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("isFirst参数不能数字类型");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			if(isFirstInt!=0&&isFirstInt!=1){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("isFirst参数不在范围中");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			
			
			
			ResultVo resultVo = checkAddOptions(addOptions,filterManager);
			if(resultVo!=null){
				return resultVo;
			}
			
			
			VieRedPacketProblem vieRedPacketProblem = new VieRedPacketProblem();
			Long count = vieRedPacketProblemService.coutByRedPacketId(redPacketId);
			if(count==null){
				count=0l;
			}
			vieRedPacketProblem.setSeq(new Integer((count+1)+""));
			vieRedPacketProblem.setIsDel(0);
			vieRedPacketProblem.setQuestion(question);
			vieRedPacketProblem.setRedPacketId(redPacketId);
			
			vieRedPacketProblem.setIsFirst(isFirstInt);
			vieRedPacketProblem = vieRedPacketProblemService.add(vieRedPacketProblem);
			
			problemId = vieRedPacketProblem.getId();
			
		}else if(typeInt==1){
			
			if(CommonUtil.isEmpty(problemId)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("problemId不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			VieRedPacketProblem vieRedPacketProblem = vieRedPacketProblemService.findOne(problemId);
			
			if(CommonUtil.isEmpty(vieRedPacketProblem)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("返回的问题为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			if(!vieRedPacketProblem.getRedPacketId().equals(redPacketId)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("返回的问题id不属于该红包");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			vieRedPacketProblem.setQuestion(question);
			vieRedPacketProblemService.update(vieRedPacketProblem);
		}else{
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("type不在范围");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		
		if(delOptionIds!=null&&delOptionIds.size()>0){
			for(String delId:delOptionIds){
				VieRedPacketOption vieRedPacketOption = vieRedPacketOptionService.findOne(delId);
				
				if(CommonUtil.isEmpty(vieRedPacketOption)){
					ResultVo resultVo = new ResultVo();
					resultVo.setSuccess(false);
					resultVo.setErrorMsg("删除的选项不存在");
					filterManager.setReturn(true);
					filterManager.setReturnValue(resultVo);
					return null;
				}
				
				vieRedPacketOption.setIsDel(1);
				
				vieRedPacketOptionService.update(vieRedPacketOption);
			}
		}
		
		
		if(addOptions!=null&&addOptions.size()>0){
			for(Map<String, Object> addMap:addOptions){
				ResultVo resultVo = checkOption(addMap, filterManager);
				
				if(resultVo!=null){
					return resultVo;
				}
				String isRight = addMap.get("isRight")+"";
				String optionSeq = addMap.get("seq")+"";
				String content = addMap.get("content")+"";
				
				Integer isRightInt = Integer.parseInt(isRight);
				
				Integer optionSeqInt = Integer.parseInt(optionSeq);
				
				
				
				VieRedPacketOption vieRedPacketOption = new VieRedPacketOption();
				vieRedPacketOption.setContent(content);
				vieRedPacketOption.setIsRight(isRightInt);
				vieRedPacketOption.setSeq(optionSeqInt);
				vieRedPacketOption.setRedPacketId(redPacketId);
				vieRedPacketOption.setRedPacketProblemId(problemId);
				
				vieRedPacketOptionService.add(vieRedPacketOption);
			}
		}
		
		
		
		if(updateOptions!=null&&updateOptions.size()>0){
			for(Map<String, Object> updateMap:updateOptions){
				
				ResultVo resultVo = checkOption(updateMap, filterManager);
				if(resultVo!=null){
					return resultVo;
				}
				
				if(CommonUtil.isEmpty(updateMap.get("id"))){
					resultVo = new ResultVo();
					resultVo.setSuccess(false);
					resultVo.setErrorMsg("更新选项id不能为空");
					filterManager.setReturn(true);
					filterManager.setReturnValue(resultVo);
					return null;
				}
				
				String isRight = updateMap.get("isRight")+"";
				String optionSeq = updateMap.get("seq")+"";
				String content = updateMap.get("content")+"";
				
				String optionId = updateMap.get("id")+"";
				
				Integer isRightInt = Integer.parseInt(isRight);
				
				Integer optionSeqInt = Integer.parseInt(optionSeq);
				
				VieRedPacketOption vieRedPacketOption = vieRedPacketOptionService.findOne(optionId);
				
				if(CommonUtil.isEmpty(vieRedPacketOption)){
					resultVo = new ResultVo();
					resultVo.setSuccess(false);
					resultVo.setErrorMsg("更新选项返回的对象为空");
					filterManager.setReturn(true);
					filterManager.setReturnValue(resultVo);
					return null;
				}
				
				vieRedPacketOption.setContent(content);
				vieRedPacketOption.setIsRight(isRightInt);
				vieRedPacketOption.setSeq(optionSeqInt);
				vieRedPacketOption = vieRedPacketOptionService.update(vieRedPacketOption);
			}
		}
		
		return null;
	}
	
	
	private ResultVo checkOptions(List<Map<String, Object>>options,SessionManager filterManager){
		boolean flag = true;
		for(Map<String, Object> option:options){
			
			ResultVo resultVo = null;
			String isRight = option.get("isRight")+"";
			Integer isRightInt = Integer.parseInt(isRight);
			
			if(isRightInt==1){
			
				if(!flag){
					resultVo = new ResultVo();
					resultVo.setSuccess(false);
					resultVo.setErrorMsg("同一道题不能有两个正确选项");
					filterManager.setReturn(true);
					filterManager.setReturnValue(resultVo);
					return resultVo;
				}
				flag = false;
				
			}
		}
		
		if(flag){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("至少需要一个正确选项");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return resultVo;
		}
		return null;
	}
	
	private ResultVo checkAddOptions(List<Map<String, Object>>options,SessionManager filterManager){
		if(options==null||options.size()<2){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("问题不能少于2个选项");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return resultVo;
		}
		
		return checkOptions(options, filterManager);
		
	}
	
	private ResultVo checkOption(Map<String, Object>optionMap,SessionManager filterManager){
		Object isRight = optionMap.get("isRight");
		Object seq = optionMap.get("seq");
		Object content = optionMap.get("content");
		if(CommonUtil.isEmpty(isRight)){
			
			
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("isRight参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return resultVo;
		}
		
		if(CommonUtil.isEmpty(seq)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("seq参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return resultVo;
		}
		
		if(CommonUtil.isEmpty(content)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("content参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return resultVo;
		}
		
		Integer isRightInt = null;
		
		try{
			isRightInt = Integer.parseInt(isRight+"");
		}catch(Exception e){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("isRight不是int类型");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return resultVo;
		}
		
		try{
			Integer.parseInt(seq+"");
		}catch(Exception e){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("seq不是int类型");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return resultVo;
		}
		
		if(isRightInt!=0&&isRightInt!=1){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("isRight参数不在范围");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return resultVo;
		}
		
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
