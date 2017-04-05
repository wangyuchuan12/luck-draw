package com.wyc.draw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@Entity
@Table(name="v_game_to_draw_user")
@ParamEntityAnnotation
public class GameToDrawUser {
	@Id
	@IdAnnotation
	private String id;
	
	@Column(name="game_id")
	@ParamAnnotation
	private String gameId;
	
	@Column(name="draw_user_id")
	@ParamAnnotation
	private String drawUserId;
	
	//挑战别人次数
	@Column(name="takepart_count")
	@ParamAnnotation
	private Integer takepartCount;
	
	//发起挑战次数
	@Column(name="initiate_count")
	@ParamAnnotation
	private Integer initiateCount;
	
	//已经挑战的id，用逗号分割开来
	@Column(name="dekorn_ids")
	@ParamAnnotation
	private String dekornIds;
	
	@Column(name = "create_at")
	@ParamAnnotation
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime createAt;
	
    @Column(name = "update_at")
    @ParamAnnotation
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime updateAt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public String getDrawUserId() {
		return drawUserId;
	}
	public void setDrawUserId(String drawUserId) {
		this.drawUserId = drawUserId;
	}
	public Integer getTakepartCount() {
		return takepartCount;
	}
	public void setTakepartCount(Integer takepartCount) {
		this.takepartCount = takepartCount;
	}
	public Integer getInitiateCount() {
		return initiateCount;
	}
	public void setInitiateCount(Integer initiateCount) {
		this.initiateCount = initiateCount;
	}
	public String getDekornIds() {
		return dekornIds;
	}
	public void setDekornIds(String dekornIds) {
		this.dekornIds = dekornIds;
	}
	public DateTime getCreateAt() {
		return createAt;
	}
	public void setCreateAt(DateTime createAt) {
		this.createAt = createAt;
	}
	public DateTime getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(DateTime updateAt) {
		this.updateAt = updateAt;
	}
}
