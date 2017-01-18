package com.wyc.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;import com.wyc.common.domain.ApplyForm;
import com.wyc.common.domain.vo.TransfersResultVo;
import com.wyc.common.service.ApplyFormService;
import com.wyc.common.util.Constant;
import com.wyc.common.wx.domain.WxContext;
import com.wyc.pay.service.PayService;

@Component
public class ApplyFormTask {
	
	@Autowired
	private ApplyFormService applyFormService;
	
	@Autowired
	private PayService payService;
	
	@Autowired
	private WxContext wxContext;
	
	
	//定时执行转行失败的任务
	@Scheduled(cron = "0 30 18 * * ?")
	public void handleTakeOut(){
		List<ApplyForm> applyForms = applyFormService.findAllByTypeAndStatusOrderByApplyTimeDesc(Constant.APPLY_FORM_TYPE_TAKE_OUT,Constant.APPLY_FORM_STATUS_FAILURE);
		for(ApplyForm applyForm:applyForms){
			try{
				TransfersResultVo transfersResultVo = payService.reTakeout(applyForm, wxContext.getDomainName());
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
}
