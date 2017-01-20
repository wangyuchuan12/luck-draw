package com.wyc.draw.domain.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//红包
@Entity(name="d_main_red_pack")
public class MainRedPack {
	@Id
	private String id;
	
	@Column(name="is_display")
	private Integer isDisplay;
	
	@Column(name="red_packet_id")
	private String redPacketId;
	
	@Column
	private Integer seq;
	
	@Column(name="period_id")
	private String periodId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}

	public String getRedPacketId() {
		return redPacketId;
	}

	
	
	public String getPeriodId() {
		return periodId;
	}

	public void setPeriodId(String periodId) {
		this.periodId = periodId;
	}

	public void setRedPacketId(String redPacketId) {
		this.redPacketId = redPacketId;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
}
