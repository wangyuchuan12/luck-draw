package com.wyc.draw.filter.controller.param;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.param.RedPacketComentParam;
import com.wyc.draw.filter.BaseDrawActionFilter;

public class RedPacketComentParamFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String redPacketId = httpServletRequest.getParameter("red_packet_id");
		
		String usefulStar = httpServletRequest.getParameter("useful_star");
		
		String accordStar = httpServletRequest.getParameter("accord_star");
		
		String interestingStar = httpServletRequest.getParameter("interesting_star");
		
		String content = httpServletRequest.getParameter("content");
		
		String type = httpServletRequest.getParameter("type");
		
		if(CommonUtil.isEmpty(redPacketId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("redPacketId参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(usefulStar)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("usefulStar参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(accordStar)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("accordStar参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(interestingStar)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("interestingStar参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(content)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("content参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(type)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("type参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		Integer usefulStarInt = null;
		
		try{
			usefulStarInt = Integer.parseInt(usefulStar);
		}catch(Exception e){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("usefulStar转换int失败");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(usefulStarInt==0){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("usefulStar不能为0");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(usefulStarInt>5){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("usefulStar不能大于5");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		Integer accordStarInt = null;
		
		try{
			accordStarInt = Integer.parseInt(accordStar);
		}catch(Exception e){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("accordStar转换int失败");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		if(accordStarInt==0){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("accordStarInt不能为0");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(accordStarInt>5){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("accordStarInt不能大于5");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		Integer interestingStarInt = null;
		
		try{
			interestingStarInt = Integer.parseInt(interestingStar);
		}catch(Exception e){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("interestingStar转换int失败");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		if(interestingStarInt==0){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("interestingStarInt不能为0");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(interestingStarInt>5){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("interestingStarInt不能大于5");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		Integer typeInt = null;
		try{
			typeInt = Integer.parseInt(type);
		}catch(Exception e){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("type转换int失败");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(typeInt!=0&&typeInt!=1){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("type只能是0或者1");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		RedPacketComentParam redPacketComentParam = new RedPacketComentParam();
		redPacketComentParam.setAccordStar(accordStarInt);
		redPacketComentParam.setContent(content);
		redPacketComentParam.setInterestingStar(interestingStarInt);
		redPacketComentParam.setRedPacketId(redPacketId);
		redPacketComentParam.setUsefulStar(usefulStarInt);
		redPacketComentParam.setType(typeInt);
		return redPacketComentParam;
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
