package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class VieRedPacketProblemListVo {
	
	@IdAnnotation
	private String id;
	@ParamAnnotation
	private List<VieRedPacketProblemVo> vieRedPacketProblemVos;
	
	@ParamAnnotation
	private Long count;
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
	public List<VieRedPacketProblemVo> getVieRedPacketProblemVos() {
		return vieRedPacketProblemVos;
	}
	public void setVieRedPacketProblemVos(List<VieRedPacketProblemVo> vieRedPacketProblemVos) {
		this.vieRedPacketProblemVos = vieRedPacketProblemVos;
	}
	
	
}
