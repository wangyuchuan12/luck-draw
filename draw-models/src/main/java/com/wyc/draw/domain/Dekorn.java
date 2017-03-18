package com.wyc.draw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wyc.annotation.IdAnnotation;


//游戏挑战
@Entity
@Table(name="v_dekorn")
public class Dekorn {
	@Id
	@IdAnnotation
	private String id;
	
	
	//0游戏挑战 1答题挑战
	@Column
	private int type;
	
	//游戏id
	@Column(name="game_id")
	private String gameId;
	
	//试卷id
	@Column(name="test_paper_id")
	private String testPaperId;
	
	//发起人
	@Column(name="hand_draw_user_id")
	private String handDrawUserId;
	
	//发起人图片
	@Column(name="hand_draw_user_img")
	private String handDrawUserImg;
	
	//及格分数
	@Column(name="pass_score")
	private Long passScore;
	
	//主题图片
	@Column(name="item_img")
	private String itemImg;
	
	//挑战成功获取智慧豆数量
	@Column(name="fight_success_wisdom_num")
	private Long fightSuccessWisdomNum;
	
	//挑战失败获取智慧豆数量
	@Column(name="fight_fail_wisdom_num")
	private Long fightFailWisdomNum;
	
	//挑战成功获取积分数
	@Column(name="fight_success_integral_num")
	private Long fightSuccessIntegralNum;
	
	//挑战失败获取积分数
	@Column(name="fight_fail_integral_num")
	private Long fightFailIntegralNum;
	
	
	//接受挑战成功获取智慧豆数量
	@Column(name="accept_fight_success_wisdom_num")
	private Long acceptFightSuccessWisdomNum;
	
	//接受挑战失败获取智慧豆数量
	@Column(name="accept_fight_fail_wisdom_num")
	private Long acceptFightFailWisdomNum;
	
	//接受挑战成功获取积分数
	@Column(name="accept_fight_success_integral_num")
	private Long acceptFightSuccessIntegralNum;
	
	//接受挑战失败获取积分数
	@Column(name="accept_fight_fail_integral_num")
	private Long acceptFightFailIntegralNum;
	
	//好评获取智慧豆数量
	@Column(name="praise_wisdom_num")
	private Long praiseWisdomNum;
	
	//好评获取积分数量
	@Column(name="praise_integral_num")
	private Long praiseIntegralNum;
	
	//总参与数量
	@Column(name="takepart_count")
	private Long takepartCount;
	
	//挑战成功数量
	@Column(name="takepart_success_count")
	private Long takepartSuccessCount;
	
	//挑战失败数量
	@Column(name="takepart_fail_count")
	private Long takepartFailCount;
	
	//最高纪录
	@Column(name="highest_score")
	private Long highestScore;
	
	//平均成绩
	@Column(name="average_score")
	private Long averageScore;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
	
	

}
