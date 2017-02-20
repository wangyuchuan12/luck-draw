package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class VieProblemAnswerVo {
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private String question;
	
	@ParamAnnotation
	private Float timelong;
	
	@ParamAnnotation
	private VieRedPacketOptionVo myOption;
	
	@ParamAnnotation
	private Integer seq;
	
	@ParamAnnotation
	private List<VieRedPacketOptionVo> vieRedPacketOptionVos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Float getTimelong() {
		return timelong;
	}

	public void setTimelong(Float timelong) {
		this.timelong = timelong;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public VieRedPacketOptionVo getMyOption() {
		return myOption;
	}

	public void setMyOption(VieRedPacketOptionVo myOption) {
		this.myOption = myOption;
	}

	public List<VieRedPacketOptionVo> getVieRedPacketOptionVos() {
		return vieRedPacketOptionVos;
	}

	public void setVieRedPacketOptionVos(List<VieRedPacketOptionVo> vieRedPacketOptionVos) {
		this.vieRedPacketOptionVos = vieRedPacketOptionVos;
	}
}
