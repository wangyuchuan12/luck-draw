package com.wyc.draw.filter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.RedPacketOption;
import com.wyc.draw.service.RedPacketOptionService;
import com.wyc.draw.service.RedPacketService;

public class HandRedPacketOptionsFilter extends Filter{

	@Autowired
	private RedPacketOptionService redPacketOptionService;
	
	@Autowired
	private RedPacketService redPacketService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		String data = httpServletRequest.getParameter("data");

		TypeReference<Map<String, Object>> typeReference = new TypeReference<Map<String,Object>>() {
		};
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = null;
		
		try{

			map = objectMapper.readValue(data, typeReference);
		}catch(Exception e){	
			e.printStackTrace();
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("解析数据残生异常");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		String redPacketId = map.get("id")+"";
		
		
		
		if(CommonUtil.isEmpty(redPacketId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("参数id不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		RedPacket redPacket = redPacketService.findOne(redPacketId);
		
		if(redPacket==null){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("id所引用的红包对象不存在");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		redPacket.setIsSetOption(1);
		
		redPacketService.update(redPacket);
		
		List<Map<String, Object>> addOptions = (List<Map<String, Object>>)map.get("add");
		
		List<String> delOptionIds = (List<String>)map.get("del");
		
		List<Map<String, Object>> updateOptionMaps = (List<Map<String,Object>>)map.get("update");
		
		if(addOptions==null){
			addOptions = new ArrayList<>();
		}
		
		if(delOptionIds==null){
			delOptionIds = new ArrayList<>();
		}
		
		if(updateOptionMaps==null){
			updateOptionMaps = new ArrayList<>();
		}
		
		for(Map<String, Object> updateOptionMap:updateOptionMaps){
			
			String id = updateOptionMap.get("id")+"";
			String answer = updateOptionMap.get("answer")+"";
			
			String seq = updateOptionMap.get("seq")+"";
			
			if(CommonUtil.isEmpty(id)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("更新的选项id不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			if(CommonUtil.isEmpty(answer)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("更新的选项answer不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			if(CommonUtil.isEmpty(seq)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("seq不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			Integer seqInt = Integer.parseInt(seq);
			
			RedPacketOption redPacketOption = redPacketOptionService.findOne(id);
			redPacketOption.setAnswer(answer);	
			redPacketOption.setSeq(seqInt);
			redPacketOptionService.update(redPacketOption);
			
		}
		
		for(Map<String, Object> addOption:addOptions){
			
			if(CommonUtil.isEmpty(addOption)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("新增的选项不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			String annswer = addOption.get("answer")+"";
			if(annswer.length()>15){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("新增的选项不能大于15个字节");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			String seq = addOption.get("seq")+"";
			
			if(CommonUtil.isEmpty(seq)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("新增seq不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			Integer seqInt = Integer.parseInt(seq);
			RedPacketOption redPacketOption = new RedPacketOption();
			
			redPacketOption.setAnswer(annswer);
			
			redPacketOption.setRedPacketId(redPacketId);
			
			redPacketOption.setIsDel(0);
			
			redPacketOption.setSeq(seqInt);
			
			redPacketOptionService.add(redPacketOption);
		}
		
		for(String delOptionId:delOptionIds){
			
			if(CommonUtil.isEmpty(delOptionId)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("删除选项id不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			RedPacketOption delRedPacketOption = redPacketOptionService.findOne(delOptionId);
			
			if(delRedPacketOption==null){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("删除选项id所对应的对象为空啊");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			delRedPacketOption.setIsDel(1);
			
			delRedPacketOption = redPacketOptionService.update(delRedPacketOption);
		}
		
		ResultVo resultVo = new ResultVo();
		
		resultVo.setMsg("同步选项卡成功");
		
		resultVo.setSuccess(true);
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
