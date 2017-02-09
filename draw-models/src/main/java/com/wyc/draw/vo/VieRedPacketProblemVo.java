package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;


@ParamEntityAnnotation
public class VieRedPacketProblemVo {
	@IdAnnotation
	private String id;
	
	
	//问题
	@ParamAnnotation
	private String question;
	
	//是否删除
	@ParamAnnotation
	private Integer isDel;
	
	//题目序号
	@ParamAnnotation
	private Integer seq;
	
	//图片url
	@ParamAnnotation
	private String imgUrl;
	
	//红包id
	@ParamAnnotation
	private String redPacketId;
	
	
	//上一个节点
	@ParamAnnotation
	private String previousProblemId;
	
	//下一个节点
	@ParamAnnotation
	private String nextProblemId;
	
	
	//是否是第一个节点
	@ParamAnnotation
	private Integer isFirst;
	
	//是否是最后一个节点
	@ParamAnnotation
	private Integer isLast;
	
	//0表示游离状态 1表示数据库中存在该记录
	@ParamAnnotation
	private Integer status;
	
	@ParamAnnotation
	private Long count;
	
	@ParamAnnotation
	private List<VieRedPacketOptionVo> vieRedPacketOptionVos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Integer getIsLast() {
		return isLast;
	}

	public void setIsLast(Integer isLast) {
		this.isLast = isLast;
	}

	public String getNextProblemId() {
		return nextProblemId;
	}

	public void setNextProblemId(String nextProblemId) {
		this.nextProblemId = nextProblemId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getRedPacketId() {
		return redPacketId;
	}

	public void setRedPacketId(String redPacketId) {
		this.redPacketId = redPacketId;
	}

	public String getPreviousProblemId() {
		return previousProblemId;
	}

	public void setPreviousProblemId(String previousProblemId) {
		this.previousProblemId = previousProblemId;
	}

	public Integer getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(Integer isFirst) {
		this.isFirst = isFirst;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<VieRedPacketOptionVo> getVieRedPacketOptionVos() {
		return vieRedPacketOptionVos;
	}

	public void setVieRedPacketOptionVos(List<VieRedPacketOptionVo> vieRedPacketOptionVos) {
		this.vieRedPacketOptionVos = vieRedPacketOptionVos;
	}
}
