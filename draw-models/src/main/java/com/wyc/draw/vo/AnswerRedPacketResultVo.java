package com.wyc.draw.vo;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.draw.domain.RedPacket;

@ParamEntityAnnotation
public class AnswerRedPacketResultVo {
	
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private Integer isRight;
	
	@ParamAnnotation
	private String myAnswer;
	
	@ParamAnnotation
	private RedPacket redPacket;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getIsRight() {
		return isRight;
	}

	public void setIsRight(Integer isRight) {
		this.isRight = isRight;
	}

	public String getMyAnswer() {
		return myAnswer;
	}

	public void setMyAnswer(String myAnswer) {
		this.myAnswer = myAnswer;
	}

	public RedPacket getRedPacket() {
		return redPacket;
	}

	public void setRedPacket(RedPacket redPacket) {
		this.redPacket = redPacket;
	}

}
