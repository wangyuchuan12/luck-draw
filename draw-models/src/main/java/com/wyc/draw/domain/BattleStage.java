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


/**
 * 比赛的阶段，一般分为13个阶段
 * @author root
 *
 */
@ParamEntityAnnotation
@Entity
@Table(name="b_battle_stage")
public class BattleStage {
	@Id
	@IdAnnotation
	private String id;
	
	//阶段序号
	@ParamAnnotation
	@Column(name="stage_index")
	private Integer stageIndex;
	
	//该阶段总分
	@ParamAnnotation
	@Column
	private Integer score;
	
	//比赛id
	@ParamAnnotation
	@Column(name="battle_id")
	private String battleId;
	
	//该阶段试卷
	@ParamAnnotation
	@Column(name="paper_id")
	private String paperId;
	
	@ParamAnnotation
	@Column(name="is_del")
	private Integer isDel;
	
	//一颗星分数
	@ParamAnnotation
	@Column(name="pass_score")
	private Integer passScore;
	
	//二颗星分数
	@ParamAnnotation
	@Column(name="pass_score2")
	private Integer passScore2;
	
	//三颗星分数
	@ParamAnnotation
	@Column(name="pass_score3")
	private Integer passScore3;
	
	//四颗星分数
	@ParamAnnotation
	@Column(name="pass_score4")
	private Integer passScore4;
	
	//阶段显示图片
	@ParamAnnotation
	@Column(name="img_url")
	private String imgUrl;
	
	//阶段名称
	@ParamAnnotation
	@Column
	private String name;
	
	//消耗智慧豆数量
	@ParamAnnotation
	@Column(name="consume_bean")
	private Integer consumeBean;
	
	//重新挑战消耗砖石
	@ParamAnnotation
	@Column(name="retakepart_consume_masonry")
	private Integer retakepartConsumeMasonry;
	
	@ParamAnnotation
	@Column(name = "create_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime createAt;
	
	@ParamAnnotation
    @Column(name = "update_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime updateAt;

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

	public Integer getStageIndex() {
		return stageIndex;
	}

	public void setStageIndex(Integer stageIndex) {
		this.stageIndex = stageIndex;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getBattleId() {
		return battleId;
	}

	public void setBattleId(String battleId) {
		this.battleId = battleId;
	}
	
	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public Integer getPassScore() {
		return passScore;
	}

	public void setPassScore(Integer passScore) {
		this.passScore = passScore;
	}

	public Integer getPassScore2() {
		return passScore2;
	}

	public void setPassScore2(Integer passScore2) {
		this.passScore2 = passScore2;
	}

	public Integer getPassScore3() {
		return passScore3;
	}

	public void setPassScore3(Integer passScore3) {
		this.passScore3 = passScore3;
	}

	public Integer getPassScore4() {
		return passScore4;
	}

	public void setPassScore4(Integer passScore4) {
		this.passScore4 = passScore4;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getConsumeBean() {
		return consumeBean;
	}

	public void setConsumeBean(Integer consumeBean) {
		this.consumeBean = consumeBean;
	}
	
	

	public Integer getRetakepartConsumeMasonry() {
		return retakepartConsumeMasonry;
	}

	public void setRetakepartConsumeMasonry(Integer retakepartConsumeMasonry) {
		this.retakepartConsumeMasonry = retakepartConsumeMasonry;
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
