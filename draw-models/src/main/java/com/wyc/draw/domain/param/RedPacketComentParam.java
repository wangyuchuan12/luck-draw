package com.wyc.draw.domain.param;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class RedPacketComentParam {
	
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private String redPacketId;
	
	@ParamAnnotation
	private Integer usefulStar;
	
	@ParamAnnotation
	private String content;
	
	@ParamAnnotation
	private Integer accordStar;
	
	@ParamAnnotation
	private Integer interestingStar;
	
	@ParamAnnotation
	private Integer type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getRedPacketId() {
		return redPacketId;
	}

	public void setRedPacketId(String redPacketId) {
		this.redPacketId = redPacketId;
	}

	public Integer getUsefulStar() {
		return usefulStar;
	}

	public void setUsefulStar(Integer usefulStar) {
		this.usefulStar = usefulStar;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getAccordStar() {
		return accordStar;
	}

	public void setAccordStar(Integer accordStar) {
		this.accordStar = accordStar;
	}

	public Integer getInterestingStar() {
		return interestingStar;
	}

	public void setInterestingStar(Integer interestingStar) {
		this.interestingStar = interestingStar;
	}
	
	
	
	
}
