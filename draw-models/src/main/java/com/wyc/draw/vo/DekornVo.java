package com.wyc.draw.vo;
import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class DekornVo {
	@IdAnnotation
	private String id;
	
	
	//0游戏挑战 1答题挑战
	@ParamAnnotation
	private int type;
	
	//游戏id
	@ParamAnnotation
	private String gameId;
	
	//试卷id
	@ParamAnnotation
	private String testPaperId;
	
	//发起人
	@ParamAnnotation
	private String handDrawUserId;
	
	//发起人图片
	@ParamAnnotation
	private String handDrawUserImg;
	
	//及格分数
	@ParamAnnotation
	private Long passScore;
	
	//主题图片
	@ParamAnnotation
	private String itemImg;
	
	//挑战成功获取智慧豆数量
	@ParamAnnotation
	private Long fightSuccessWisdomNum;
	
	//挑战失败获取智慧豆数量
	@ParamAnnotation
	private Long fightFailWisdomNum;
	
	//挑战成功获取积分数
	@ParamAnnotation
	private Long fightSuccessIntegralNum;
	
	//挑战失败获取积分数
	@ParamAnnotation
	private Long fightFailIntegralNum;
	
	
	//接受挑战成功获取智慧豆数量
	@ParamAnnotation
	private Long acceptFightSuccessWisdomNum;
	
	//接受挑战失败获取智慧豆数量
	@ParamAnnotation
	private Long acceptFightFailWisdomNum;
	
	//接受挑战成功获取积分数
	@ParamAnnotation
	private Long acceptFightSuccessIntegralNum;
	
	//接受挑战失败获取积分数
	@ParamAnnotation
	private Long acceptFightFailIntegralNum;
	
	//好评获取智慧豆数量
	@ParamAnnotation
	private Long praiseWisdomNum;
	
	//好评获取积分数量
	@ParamAnnotation
	private Long praiseIntegralNum;
	
	//总参与数量
	@ParamAnnotation
	private Long takepartCount;
	
	//挑战成功数量
	@ParamAnnotation
	private Long takepartSuccessCount;
	
	//挑战失败数量
	@ParamAnnotation
	private Long takepartFailCount;
	
	//最高纪录
	@ParamAnnotation
	private Long highestScore;
	
	//平均成绩
	@ParamAnnotation
	private Long averageScore;
	
	@ParamAnnotation
	private String gameUrl;

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

	public String getGameUrl() {
		return gameUrl;
	}

	public void setGameUrl(String gameUrl) {
		this.gameUrl = gameUrl;
	}
	
	
	
}
