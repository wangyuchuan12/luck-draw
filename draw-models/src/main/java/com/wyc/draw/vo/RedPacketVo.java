package com.wyc.draw.vo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.draw.domain.RedPacketOption;

@ParamEntityAnnotation
public class RedPacketVo {

	@IdAnnotation
    private String id;
	
	
	//红包所属房间参与用户id
	@ParamAnnotation
	private String handRoomMemberId;
	
	//本用户的房间成员id;
	@ParamAnnotation
	private String myRoomMemberId;
	
	//所属房间id
	@ParamAnnotation
	private String drawRoomId;
	
	//红包类型
	@ParamAnnotation
	private Integer type;
	
	//红包用户id
	@ParamAnnotation
	private String handDrawUserId;
	
	
	//红包接收人
	@ParamAnnotation
	private String receiveDrawUserId;
	
	//发送时间
//	@JsonSerialize(as=MyDateSerializer.class)
	@ParamAnnotation
	private String handTime;
	
	//红包截止时长
	@ParamAnnotation
	private int timeLong;
	
	//红包金额
	@ParamAnnotation
	private BigDecimal amount;
	
	//问题
	@ParamAnnotation
	private String question;
	
	//答案
	@ParamAnnotation
	private String answer;
	
	
	//红包付款订单号
	@ParamAnnotation
	private String outTradeNo;

	//是否可领取
	@ParamAnnotation
	private Integer isReceiveAble;
	
	//红包是否已接受
	@ParamAnnotation
	private Integer isReceive;
	
	//红包是否已到时间
	@ParamAnnotation
	private Integer isTimeout;
	
	//允许错误次数
	@ParamAnnotation
	private Integer allowWrongCount;
	
	
	//是否已付款
	@ParamAnnotation
	private Integer isPay;
	
	//支付类型
	@ParamAnnotation
	private Integer payType;
	
	//提示信息
	@ParamAnnotation
	private String prompt;
	
	//是否退款
	@ParamAnnotation
	private Integer isRefund;
	
	@ParamAnnotation
	private String nickname;
	
	@ParamAnnotation
	private String userImgUrl;
	
	@ParamAnnotation
	private Integer count;
	
	@ParamAnnotation
	private Integer isInRoom;
	
	@ParamAnnotation
	private Integer isCreater;
	
	
	//是否有图片
	@ParamAnnotation
	private Integer isImg;
	
	
	//图片地址
	@ParamAnnotation
	private String imgUrl;
	
	@ParamAnnotation
	private Integer takePartCount;
	
	@ParamAnnotation
	private Integer isAmountDisplay;
	
	@ParamAnnotation
	private Integer shareNumShowAnswer;
	
	
	//已经分享的数量
	@ParamAnnotation
	private Integer shareCount;
	
	@ParamAnnotation
	private Integer isSetOption;
	
	//是否是房间红包
	@ParamAnnotation
	private Integer isRoom;
	
	@ParamAnnotation
	private String theme;
	
	@ParamAnnotation
	private String instruction;
	
	//题目数量
	@ParamAnnotation
	private Integer questionNum;
	
	//正确数量
	@ParamAnnotation
	private Long rightCount;
	
	//错误数量
	@ParamAnnotation
	private Long wrongCount;
	
	//参赛费用
	@ParamAnnotation
	private BigDecimal entryFee;
	
	//是否需要参赛费
	@ParamAnnotation
	private Integer isEntryFee;
	
	//是否已经答题，用于竞答红包
	@ParamAnnotation
	private Integer isAnswer;
	
	//问题已经设置，这个字段用于竞答红包
	@ParamAnnotation
	private Integer isGiveQuestion;
	
	//是否已经上缴参赛费
	@ParamAnnotation
	private Integer isGiveEntryFee;
	
	@ParamAnnotation
	private BigDecimal getAmount;
	
	@ParamAnnotation
	private int placesNum;
	
	@ParamAnnotation
	private List<RedPacketTakepartMemberVo> redPacketTakepartMemberVos;
	
	@ParamAnnotation
	private List<RedPacketOption> redPacketOptions;
	
	//所需智慧豆
	@ParamAnnotation
	private Long wisdomCount;
	
	//是否需要智慧豆
	@ParamAnnotation
	private Integer isWisdom;
	
	@ParamAnnotation
	private BigDecimal receiveAmount;
	
	//已经领取的个数
	@ParamAnnotation
	private Integer receiveNum;
	
	
	//累计智慧豆数量
	@ParamAnnotation
	private Long getWisdomCount;
	
	
	
	public BigDecimal getGetAmount() {
		return getAmount;
	}

	public void setGetAmount(BigDecimal getAmount) {
		this.getAmount = getAmount;
	}

	
	
	public Integer getReceiveNum() {
		return receiveNum;
	}

	public void setReceiveNum(Integer receiveNum) {
		this.receiveNum = receiveNum;
	}

	public BigDecimal getReceiveAmount() {
		return receiveAmount;
	}

	public void setReceiveAmount(BigDecimal receiveAmount) {
		this.receiveAmount = receiveAmount;
	}

	public Long getWisdomCount() {
		return wisdomCount;
	}

	public void setWisdomCount(Long wisdomCount) {
		this.wisdomCount = wisdomCount;
	}

	public Integer getIsWisdom() {
		return isWisdom;
	}

	public void setIsWisdom(Integer isWisdom) {
		this.isWisdom = isWisdom;
	}

	public int getPlacesNum() {
		return placesNum;
	}

	public void setPlacesNum(int placesNum) {
		this.placesNum = placesNum;
	}

	public Integer getIsGiveEntryFee() {
		return isGiveEntryFee;
	}

	public void setIsGiveEntryFee(Integer isGiveEntryFee) {
		this.isGiveEntryFee = isGiveEntryFee;
	}

	public Integer getIsAnswer() {
		return isAnswer;
	}

	public void setIsAnswer(Integer isAnswer) {
		this.isAnswer = isAnswer;
	}

	public Integer getIsRoom() {
		return isRoom;
	}

	public Integer getIsEntryFee() {
		return isEntryFee;
	}

	public void setIsEntryFee(Integer isEntryFee) {
		this.isEntryFee = isEntryFee;
	}

	public void setIsRoom(Integer isRoom) {
		this.isRoom = isRoom;
	}

	
	
	public Integer getIsGiveQuestion() {
		return isGiveQuestion;
	}

	public void setIsGiveQuestion(Integer isGiveQuestion) {
		this.isGiveQuestion = isGiveQuestion;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public Integer getQuestionNum() {
		return questionNum;
	}

	public void setQuestionNum(Integer questionNum) {
		this.questionNum = questionNum;
	}

	public Long getRightCount() {
		return rightCount;
	}

	public void setRightCount(Long rightCount) {
		this.rightCount = rightCount;
	}

	public Long getWrongCount() {
		return wrongCount;
	}

	public void setWrongCount(Long wrongCount) {
		this.wrongCount = wrongCount;
	}

	public BigDecimal getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(BigDecimal entryFee) {
		this.entryFee = entryFee;
	}

	public Integer getIsSetOption() {
		return isSetOption;
	}

	public void setIsSetOption(Integer isSetOption) {
		this.isSetOption = isSetOption;
	}

	public List<RedPacketOption> getRedPacketOptions() {
		return redPacketOptions;
	}

	public void setRedPacketOptions(List<RedPacketOption> redPacketOptions) {
		this.redPacketOptions = redPacketOptions;
	}

	public Integer getShareCount() {
		return shareCount;
	}
	
	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	public Integer getTakePartCount() {
		return takePartCount;
	}

	public void setTakePartCount(Integer takePartCount) {
		this.takePartCount = takePartCount;
	}

	public Integer getShareNumShowAnswer() {
		return shareNumShowAnswer;
	}

	public void setShareNumShowAnswer(Integer shareNumShowAnswer) {
		this.shareNumShowAnswer = shareNumShowAnswer;
	}




	public List<RedPacketTakepartMemberVo> getRedPacketTakepartMemberVos() {
		return redPacketTakepartMemberVos;
	}




	public void setRedPacketTakepartMemberVos(List<RedPacketTakepartMemberVo> redPacketTakepartMemberVos) {
		this.redPacketTakepartMemberVos = redPacketTakepartMemberVos;
	}




	public Integer getIsCreater() {
		return isCreater;
	}




	public Integer getIsAmountDisplay() {
		return isAmountDisplay;
	}




	public void setIsAmountDisplay(Integer isAmountDisplay) {
		this.isAmountDisplay = isAmountDisplay;
	}




	public void setIsCreater(Integer isCreater) {
		this.isCreater = isCreater;
	}




	public String getMyRoomMemberId() {
		return myRoomMemberId;
	}




	public void setMyRoomMemberId(String myRoomMemberId) {
		this.myRoomMemberId = myRoomMemberId;
	}




	public Integer getIsInRoom() {
		return isInRoom;
	}




	public void setIsInRoom(Integer isInRoom) {
		this.isInRoom = isInRoom;
	}




	public Integer getCount() {
		return count;
	}




	public void setCount(Integer count) {
		this.count = count;
	}




	public String getNickname() {
		return nickname;
	}




	public void setNickname(String nickname) {
		this.nickname = nickname;
	}




	public String getUserImgUrl() {
		return userImgUrl;
	}




	public void setUserImgUrl(String userImgUrl) {
		this.userImgUrl = userImgUrl;
	}




	public Integer getIsPay() {
		return isPay;
	}




	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}




	public int getTimeLong() {
		return timeLong;
	}
	
	
	

	public String getOutTradeNo() {
		return outTradeNo;
	}




	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}




	public void setTimeLong(int timeLong) {
		this.timeLong = timeLong;
	}

	public Integer getIsTimeout() {
		return isTimeout;
	}

	public void setIsTimeout(Integer isTimeout) {
		this.isTimeout = isTimeout;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getHandDrawUserId() {
		return handDrawUserId;
	}

	public void setHandDrawUserId(String handDrawUserId) {
		this.handDrawUserId = handDrawUserId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getDrawRoomId() {
		return drawRoomId;
	}

	public void setDrawRoomId(String drawRoomId) {
		this.drawRoomId = drawRoomId;
	}

	

	public String getHandRoomMemberId() {
		return handRoomMemberId;
	}

	public void setHandRoomMemberId(String handRoomMemberId) {
		this.handRoomMemberId = handRoomMemberId;
	}

	

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	
	

	public String getHandTime() {
		return handTime;
	}




	public void setHandTime(String handTime) {
		this.handTime = handTime;
	}




	public String getReceiveDrawUserId() {
		return receiveDrawUserId;
	}




	public void setReceiveDrawUserId(String receiveDrawUserId) {
		this.receiveDrawUserId = receiveDrawUserId;
	}




	public Integer getIsReceiveAble() {
		return isReceiveAble;
	}




	public void setIsReceiveAble(Integer isReceiveAble) {
		this.isReceiveAble = isReceiveAble;
	}




	public Integer getIsReceive() {
		return isReceive;
	}




	public void setIsReceive(Integer isReceive) {
		this.isReceive = isReceive;
	}




	public Integer getAllowWrongCount() {
		return allowWrongCount;
	}




	public void setAllowWrongCount(Integer allowWrongCount) {
		this.allowWrongCount = allowWrongCount;
	}




	public Integer getIsRefund() {
		return isRefund;
	}




	public void setIsRefund(Integer isRefund) {
		this.isRefund = isRefund;
	}




	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}




	public Integer getIsImg() {
		return isImg;
	}




	public void setIsImg(Integer isImg) {
		this.isImg = isImg;
	}




	public String getImgUrl() {
		return imgUrl;
	}




	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Long getGetWisdomCount() {
		return getWisdomCount;
	}

	public void setGetWisdomCount(Long getWisdomCount) {
		this.getWisdomCount = getWisdomCount;
	}
	
	
}
