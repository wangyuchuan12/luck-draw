package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class RedPacketListVo {
	
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<RedPacketVo> redPacketVos;
	
	@ParamAnnotation
	private Integer page;
	
	@ParamAnnotation
	private Integer size;
	
	@ParamAnnotation
	private Long count;
	
	//总页数
	@ParamAnnotation
	private Integer totalPages;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<RedPacketVo> getRedPacketVos() {
		return redPacketVos;
	}

	public void setRedPacketVos(List<RedPacketVo> redPacketVos) {
		this.redPacketVos = redPacketVos;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	
	
	
}
