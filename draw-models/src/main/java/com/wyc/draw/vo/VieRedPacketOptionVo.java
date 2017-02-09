package com.wyc.draw.vo;
import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
@ParamEntityAnnotation
public class VieRedPacketOptionVo {
	@IdAnnotation
	private String id;
	
	//是否删除
	@ParamAnnotation
	private Integer isDel;
	
	
	//红包id
	@ParamAnnotation
	private String redPacketId;
	
	//问题id
	@ParamAnnotation
	private String redPacketProblemId;

	//选项内容
	@ParamAnnotation
	private String content;
	
	//是否正确选项
	@ParamAnnotation
	private Integer isRight;
	
	//序号
	@ParamAnnotation
	private Integer seq;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public String getRedPacketId() {
		return redPacketId;
	}

	public void setRedPacketId(String redPacketId) {
		this.redPacketId = redPacketId;
	}

	public String getRedPacketProblemId() {
		return redPacketProblemId;
	}

	public void setRedPacketProblemId(String redPacketProblemId) {
		this.redPacketProblemId = redPacketProblemId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIsRight() {
		return isRight;
	}

	public void setIsRight(Integer isRight) {
		this.isRight = isRight;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	
	
	
	
}
