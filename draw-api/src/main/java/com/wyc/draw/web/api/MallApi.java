package com.wyc.draw.web.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.draw.domain.GoodDisplay;
import com.wyc.draw.service.GoodDisplayService;

@Controller
@RequestMapping(value="/api/mall/")
public class MallApi{

	@Autowired
	private GoodDisplayService goodDisplayService;
	@ResponseBody
	@RequestMapping(value="good_list")
	public Object goodList(HttpServletRequest httpServletRequest){
		String clazz = httpServletRequest.getParameter("clazz");
		
		List<GoodDisplay> goodDisplays = goodDisplayService.findAllByClazzAndIsDisplayOrderByIndexAsc(Integer.parseInt(clazz),1);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(goodDisplays);
		
		return resultVo;
	}
}
