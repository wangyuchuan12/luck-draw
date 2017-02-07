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
import com.wyc.draw.domain.VieRedPacketOption;
import com.wyc.draw.domain.VieRedPacketProblem;
import com.wyc.draw.service.VieRedPacketOptionService;
import com.wyc.draw.service.VieRedPacketProblemService;

public class HandRedPacketQuestionFilter extends Filter{

	@Autowired
	private VieRedPacketOptionService vieRedPacketOptionService;
	
	@Autowired
	private VieRedPacketProblemService vieRedPacketProblemService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String type = httpServletRequest.getParameter("type");
		
		String redPacketId = httpServletRequest.getParameter("red_packet_id");
		
		String problemId =  httpServletRequest.getParameter("problem_id");
		
		String optionJson = httpServletRequest.getParameter("options");
		
		String seq = httpServletRequest.getParameter("seq");
		
		String imgUrl = httpServletRequest.getParameter("imgUrl");
		
		String question = httpServletRequest.getParameter("question");
		
		if(CommonUtil.isEmpty(redPacketId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("redPacketId参数不能为空");
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
		
		List<Map<String, Object>> addOptions = (List<Map<String, Object>>)optionMap.get("add");
		
		List<String> delOptionIds = (List<String>)optionMap.get("del");
		
		List<Map<String, Object>> updateOptionMaps = (List<Map<String,Object>>)optionMap.get("update");
		
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
		
		
		if(typeInt==0){
			
			
			if(CommonUtil.isEmpty(seq)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("seq参数不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			Integer seqInt = null;
			try{
				seqInt = Integer.parseInt(seq);
			}catch(Exception e){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("seq不是数字");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			
			
			
			VieRedPacketProblem vieRedPacketProblem = new VieRedPacketProblem();
			vieRedPacketProblem.setSeq(seqInt);
			vieRedPacketProblem.setIsDel(0);
			vieRedPacketProblem.setQuestion(question);
			vieRedPacketProblem.setRedPacketId(redPacketId);
			vieRedPacketProblemService.add(vieRedPacketProblem);
			ResultVo resultVo = checkOptions(addOptions,filterManager);
			if(resultVo!=null){
				return resultVo;
			}
			for(Map<String, Object> addMap:addOptions){
				resultVo = checkOption(addMap, filterManager);
				
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
				
				vieRedPacketOptionService.add(vieRedPacketOption);
			}
		}else if(typeInt==1){
			
		}else{
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("type不在范围");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		return null;
	}
	
	
	private ResultVo checkOptions(List<Map<String, Object>>options,SessionManager filterManager){
		if(options==null||options.size()<2){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("问题不能少于2个选项");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
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
					return null;
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
			return null;
		}
		
		return null;
		
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
