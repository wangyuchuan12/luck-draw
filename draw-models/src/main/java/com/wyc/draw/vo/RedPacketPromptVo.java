package com.wyc.draw.vo;
import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;


@ParamEntityAnnotation
public class RedPacketPromptVo {
	
	@IdAnnotation
	private String id;
	
	//提示信息
	@ParamAnnotation
	private String prompt;
	
	//红包id
	@ParamAnnotation
	private String redPacketId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getRedPacketId() {
		return redPacketId;
	}

	public void setRedPacketId(String redPacketId) {
		this.redPacketId = redPacketId;
	}
	
	
	
}
