package com.wyc.draw.domain.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//房间
@Entity(name="d_main_room")
public class MainRoom {
	@Id
	private String id;
	
	@Column(name="is_display")
	private Integer isDisplay;
	
	@Column(name="room_id")
	private String roomId;
	
	@Column(name="period_id")
	private String periodId;
	
	@Column
	private String name;
	
	@Column
	private String imgUrl;
	
	@Column
	private Integer seq;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getPeriodId() {
		return periodId;
	}

	public void setPeriodId(String periodId) {
		this.periodId = periodId;
	}

	public Integer getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
}
