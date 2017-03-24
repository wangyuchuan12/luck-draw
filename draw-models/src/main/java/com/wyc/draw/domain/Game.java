package com.wyc.draw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@Entity
@Table(name="v_game")
@ParamEntityAnnotation
public class Game {
	@Id
	@IdAnnotation
	private String id;
	
	@Column
	@ParamAnnotation
	private String name;
	
	@ParamAnnotation
	@Column(unique=true)
	private String code;
	
	@ParamAnnotation
	@Column
	private String url;
	
	@ParamAnnotation
	//游戏主题图片
	@Column(name="item_img_url")
	private String itemImgUrl;
	
	@ParamAnnotation
	//已经参与挑战的数量
	@Column(name="dekorn_takepart_num")
	private Long dekornTakepartNum;
	
	@ParamAnnotation
	//发布挑战的个数
	@Column(name="dekorn_num")
	private Long dekornNum;
	
	//难度指数
	@ParamAnnotation
	@Column(name="difficulty_index")
	private Integer difficultyIndex;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

	public String getItemImgUrl() {
		return itemImgUrl;
	}

	public void setItemImgUrl(String itemImgUrl) {
		this.itemImgUrl = itemImgUrl;
	}

	public Long getDekornTakepartNum() {
		return dekornTakepartNum;
	}

	public void setDekornTakepartNum(Long dekornTakepartNum) {
		this.dekornTakepartNum = dekornTakepartNum;
	}

	public Long getDekornNum() {
		return dekornNum;
	}

	public void setDekornNum(Long dekornNum) {
		this.dekornNum = dekornNum;
	}

	public Integer getDifficultyIndex() {
		return difficultyIndex;
	}

	public void setDifficultyIndex(Integer difficultyIndex) {
		this.difficultyIndex = difficultyIndex;
	}
	
	
	

}
