package com.wyc.common.domain.vo;
import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation(type=ParamEntityAnnotation.CONTEXT_TYPE)
public class WxConfigBean {
	
	@IdAnnotation
	private String id;
	@ParamAnnotation
	private String signature;
	
	@ParamAnnotation(type=ParamEntityAnnotation.CONTEXT_TYPE)
    private String noncestr;
	
	@ParamAnnotation(type=ParamEntityAnnotation.CONTEXT_TYPE)
    private String appId;

	
	@ParamAnnotation(type=ParamEntityAnnotation.CONTEXT_TYPE)
	private String datetime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getNoncestr() {
		return noncestr;
	}

	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	
	
}
