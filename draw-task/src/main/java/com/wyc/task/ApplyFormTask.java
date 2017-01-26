package com.wyc.task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	@Scheduled(cron = "0 0 18 * * ?")
	public void handleTakeOut(){
		PageRequest pageRequest = new PageRequest(0, 100);
		doHandleTakeOut(pageRequest);
	}
	
	private void doHandleTakeOut(PageRequest pageRequest){

		Page<ApplyForm> applyForms = applyFormService.findAllByTypeAndStatusOrderByApplyTimeDesc(Constant.APPLY_FORM_TYPE_TAKE_OUT,Constant.APPLY_FORM_STATUS_FAILURE,pageRequest);
		
		if(applyForms.getTotalElements()==0){
			return;
		}else{
			for(ApplyForm applyForm:applyForms.getContent()){
				try{
					TransfersResultVo transfersResultVo = payService.reTakeout(applyForm, wxContext.getDomainName());
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		//	doHandleTakeOut(pageRequest);
		}
		
		
	}
}
