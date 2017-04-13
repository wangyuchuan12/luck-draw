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


//游戏挑战
@ParamEntityAnnotation
@Entity
@Table(name="v_dekorn")
public class Dekorn {
	@Id
	@IdAnnotation
	private String id;
	
	
	//0游戏挑战 1答题挑战
	@ParamAnnotation
	@Column
	private Integer type;
	
	//游戏类型
	@ParamAnnotation
	@Column(name="game_code")
	private String gameCode;
	
	//游戏id
	@ParamAnnotation
	@Column(name="game_id")
	private String gameId;
	
	//试卷id
	@ParamAnnotation
	@Column(name="test_paper_id")
	private String testPaperId;
	
	//发起人
	@ParamAnnotation
	@Column(name="hand_draw_user_id")
	private String handDrawUserId;
	
	//发起人图片
	@ParamAnnotation
	@Column(name="hand_draw_user_img")
	private String handDrawUserImg;
	
	//发起人名称
	@ParamAnnotation
	@Column(name="hand_draw_user_name")
	private String handDrawUserName;
	
	//及格分数
	@ParamAnnotation
	@Column(name="pass_score")
	private Long passScore;
	
	//主题图片
	@ParamAnnotation
	@Column(name="item_img")
	private String itemImg;
	
	//挑战成功获取智慧豆数量
	@ParamAnnotation
	@Column(name="fight_success_wisdom_num")
	private Long fightSuccessWisdomNum;
	
	//挑战失败获取智慧豆数量
	@ParamAnnotation
	@Column(name="fight_fail_wisdom_num")
	private Long fightFailWisdomNum;
	
	//挑战成功获取积分数
	@ParamAnnotation
	@Column(name="fight_success_integral_num")
	private Long fightSuccessIntegralNum;
	
	//挑战失败获取积分数
	@ParamAnnotation
	@Column(name="fight_fail_integral_num")
	private Long fightFailIntegralNum;
	
	
	//接受挑战成功获取智慧豆数量
	@ParamAnnotation
	@Column(name="accept_fight_success_wisdom_num")
	private Long acceptFightSuccessWisdomNum;
	
	//接受挑战失败获取智慧豆数量
	@ParamAnnotation
	@Column(name="accept_fight_fail_wisdom_num")
	private Long acceptFightFailWisdomNum;
	
	//接受挑战成功获取积分数
	@ParamAnnotation
	@Column(name="accept_fight_success_integral_num")
	private Long acceptFightSuccessIntegralNum;
	
	//接受挑战失败获取积分数
	@ParamAnnotation
	@Column(name="accept_fight_fail_integral_num")
	private Long acceptFightFailIntegralNum;
	
	//好评获取智慧豆数量
	@ParamAnnotation
	@Column(name="praise_wisdom_num")
	private Long praiseWisdomNum;
	
	//好评获取积分数量
	@ParamAnnotation
	@Column(name="praise_integral_num")
	private Long praiseIntegralNum;
	
	//总参与数量
	@ParamAnnotation
	@Column(name="takepart_count")
	private Long takepartCount;
	
	//挑战成功数量
	@ParamAnnotation
	@Column(name="takepart_success_count")
	private Long takepartSuccessCount;
	
	//挑战失败数量
	@ParamAnnotation
	@Column(name="takepart_fail_count")
	private Long takepartFailCount;
	
	//最高纪录
	@ParamAnnotation
	@Column(name="highest_score")
	private Long highestScore;
	
	//平均成绩
	@ParamAnnotation
	@Column(name="average_score")
	private Long averageScore;
	
	//需要智慧豆数量
	@ParamAnnotation
	@Column(name="require_wisdom_num")
	private Long requireWisdomNum;
	
	//挑战状态
	@ParamAnnotation
	@Column
	private Integer status;
	
	
	/**
	 * 创建该挑战，创建人可获得的奖励，激活该记录之后才可获取
	 */
	@ParamAnnotation
	@Column(name="reward_id")
	private String rewardId;
	
	
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	
	

	public String getGameCode() {
		return gameCode;
	}

	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getTestPaperId() {
		return testPaperId;
	}

	public void setTestPaperId(String testPaperId) {
		this.testPaperId = testPaperId;
	}

	public String getHandDrawUserId() {
		return handDrawUserId;
	}

	public void setHandDrawUserId(String handDrawUserId) {
		this.handDrawUserId = handDrawUserId;
	}

	public String getHandDrawUserImg() {
		return handDrawUserImg;
	}

	public void setHandDrawUserImg(String handDrawUserImg) {
		this.handDrawUserImg = handDrawUserImg;
	}

	public String getHandDrawUserName() {
		return handDrawUserName;
	}

	public void setHandDrawUserName(String handDrawUserName) {
		this.handDrawUserName = handDrawUserName;
	}

	public Long getPassScore() {
		return passScore;
	}

	public void setPassScore(Long passScore) {
		this.passScore = passScore;
	}

	public String getItemImg() {
		return itemImg;
	}

	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}

	public Long getFightSuccessWisdomNum() {
		return fightSuccessWisdomNum;
	}

	public void setFightSuccessWisdomNum(Long fightSuccessWisdomNum) {
		this.fightSuccessWisdomNum = fightSuccessWisdomNum;
	}

	public Long getFightFailWisdomNum() {
		return fightFailWisdomNum;
	}

	public void setFightFailWisdomNum(Long fightFailWisdomNum) {
		this.fightFailWisdomNum = fightFailWisdomNum;
	}

	public Long getFightSuccessIntegralNum() {
		return fightSuccessIntegralNum;
	}

	public void setFightSuccessIntegralNum(Long fightSuccessIntegralNum) {
		this.fightSuccessIntegralNum = fightSuccessIntegralNum;
	}

	public Long getFightFailIntegralNum() {
		return fightFailIntegralNum;
	}

	public void setFightFailIntegralNum(Long fightFailIntegralNum) {
		this.fightFailIntegralNum = fightFailIntegralNum;
	}

	public Long getAcceptFightSuccessWisdomNum() {
		return acceptFightSuccessWisdomNum;
	}

	public void setAcceptFightSuccessWisdomNum(Long acceptFightSuccessWisdomNum) {
		this.acceptFightSuccessWisdomNum = acceptFightSuccessWisdomNum;
	}

	public Long getAcceptFightFailWisdomNum() {
		return acceptFightFailWisdomNum;
	}

	public void setAcceptFightFailWisdomNum(Long acceptFightFailWisdomNum) {
		this.acceptFightFailWisdomNum = acceptFightFailWisdomNum;
	}

	public Long getAcceptFightSuccessIntegralNum() {
		return acceptFightSuccessIntegralNum;
	}

	public void setAcceptFightSuccessIntegralNum(Long acceptFightSuccessIntegralNum) {
		this.acceptFightSuccessIntegralNum = acceptFightSuccessIntegralNum;
	}

	public Long getAcceptFightFailIntegralNum() {
		return acceptFightFailIntegralNum;
	}

	public void setAcceptFightFailIntegralNum(Long acceptFightFailIntegralNum) {
		this.acceptFightFailIntegralNum = acceptFightFailIntegralNum;
	}

	public Long getPraiseWisdomNum() {
		return praiseWisdomNum;
	}

	public void setPraiseWisdomNum(Long praiseWisdomNum) {
		this.praiseWisdomNum = praiseWisdomNum;
	}

	public Long getPraiseIntegralNum() {
		return praiseIntegralNum;
	}

	public void setPraiseIntegralNum(Long praiseIntegralNum) {
		this.praiseIntegralNum = praiseIntegralNum;
	}

	public Long getTakepartCount() {
		return takepartCount;
	}

	public void setTakepartCount(Long takepartCount) {
		this.takepartCount = takepartCount;
	}

	public Long getTakepartSuccessCount() {
		return takepartSuccessCount;
	}

	public void setTakepartSuccessCount(Long takepartSuccessCount) {
		this.takepartSuccessCount = takepartSuccessCount;
	}

	public Long getTakepartFailCount() {
		return takepartFailCount;
	}

	public void setTakepartFailCount(Long takepartFailCount) {
		this.takepartFailCount = takepartFailCount;
	}

	public Long getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(Long highestScore) {
		this.highestScore = highestScore;
	}

	public Long getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(Long averageScore) {
		this.averageScore = averageScore;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRewardId() {
		return rewardId;
	}

	public void setRewardId(String rewardId) {
		this.rewardId = rewardId;
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

	public Long getRequireWisdomNum() {
		return requireWisdomNum;
	}

	public void setRequireWisdomNum(Long requireWisdomNum) {
		this.requireWisdomNum = requireWisdomNum;
	}
}
