package com.wyc.common.domain.vo;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class TransfersResultVo {
	
	@IdAnnotation
	private String id;
	
	@ParamAnnotation(name="return_code")
	private String returnCode;
	
	@ParamAnnotation(name="return_msg")
	private String returnMsg;
	
	@ParamAnnotation(name="result_code")
	private String resultCode;
	
	@ParamAnnotation(name="err_code")
	private String errCode;
	
	@ParamAnnotation(name="err_code_des")
	private String errCodeDes;

	@ParamAnnotation(name="out_trade_no")
	private String outTradeNo;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCodeDes() {
		return errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}
	
	
	
}
