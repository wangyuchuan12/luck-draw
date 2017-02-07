package com.wyc.draw.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;


//红包
@ParamEntityAnnotation
@Entity
@Table(name="d_red_packet",indexes={@Index(columnList="hand_room_member_id",name="hand_room_member_id_index"),
				@Index(columnList="draw_room_id",name="draw_room_id_index"),
//				@Index(columnList="type",name="type_index"),
				@Index(columnList="hand_draw_user_id",name="hand_draw_user_id_index"),
//				@Index(columnList="is_img",name="is_img_index"),
//				@Index(columnList="pay_type",name="pay_type_index"),
//				@Index(columnList="is_pay",name="is_pay_index"),
//				@Index(columnList="is_refund",name="is_refund_index"),
				@Index(columnList="is_timeout",name="is_timeout_index")})
public class RedPacket {
	
	@IdAnnotation
	@Id
    private String id;
	
	
	//红包所属房间参与用户id
	@ParamAnnotation
	@Column(name="hand_room_member_id")
	private String handRoomMemberId;
	
	//所属房间id
	@ParamAnnotation
	@Column(name="draw_room_id")
	private String drawRoomId;
	
	//红包类型
	@Column
	@ParamAnnotation
	private Integer type;
	
	//红包用户id
	@ParamAnnotation
	@Column(name="hand_draw_user_id")
	private String handDrawUserId;
	
	
	//红包接收人
	@ParamAnnotation
	@Column(name="receive_draw_user_id")
	private String receiveDrawUserId;
	
	//发送时间
	@ParamAnnotation
	@Column(name="hand_time")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime handTime;
	
	//红包截止时长
	@ParamAnnotation
	@Column(name="time_long")
	private int timeLong;
	
	//红包金额
	@ParamAnnotation
	@Column
	private BigDecimal amount;
	
	//问题
	@ParamAnnotation
	@Column
	private String question;
	
	//答案
	@ParamAnnotation
	@Column
	private String answer;
	
	
	//红包付款订单号
	@ParamAnnotation
	@Column(name="out_trade_no")
	private String outTradeNo;

	//是否可领取
	@ParamAnnotation
	@Column(name="is_receive_able")
	private Integer isReceiveAble;
	
	//红包是否已接受
	@ParamAnnotation
	@Column(name="is_receive")
	private Integer isReceive;
	
	//红包是否已到时间
	@ParamAnnotation
	@Column(name="is_timeout")
	private Integer isTimeout;
	
	//允许错误次数
	@ParamAnnotation
	@Column(name="allow_wrong_count")
	private Integer allowWrongCount;
	
	
	//是否已付款
	@ParamAnnotation
	@Column(name="is_pay")
	private Integer isPay;
	
	//支付类型
	@ParamAnnotation
	@Column(name="pay_type")
	private Integer payType;
	
	//提示信息
	@ParamAnnotation
	@Column
	private String prompt;
	
	//是否退款
	@ParamAnnotation
	@Column(name="is_refund")
	private Integer isRefund;
	
	@ParamAnnotation
	@Column(name="is_refund_error")
	private Integer isRefundError;
	
	//是否有图片
	@ParamAnnotation
	@Column(name="is_img")
	private Integer isImg;
	
	
	//已参与用户数量
	@ParamAnnotation
	@Column(name="take_part_count")
	private Integer takePartCount;
	
	//图片地址
	@ParamAnnotation
	@Column(name="img_url")
	private String imgUrl;
	
	@Column(name="user_img_url")
	@ParamAnnotation
	private String handUserImgUrl;
	
	@Column(name="hand_nick_name")
	@ParamAnnotation
	private String handNickname;
	
	
	//金额是否显示
	@ParamAnnotation
	@Column(name="is_amount_display")
	private Integer isAmountDisplay;
	
	//分享几个人可看答案
	@ParamAnnotation
    @Column(name="share_num_show_answer")
	private Integer shareNumShowAnswer;
	
	//主题
	@ParamAnnotation
	@Column
	private String theme;
	
	
	//说明
	@ParamAnnotation
	@Column
	private String instruction;
	
	//分类id
	@ParamAnnotation
	@Column
	private String subjectId;
	
	
	//分类名称
	@ParamAnnotation
	@Column(name="subject_name")
	private String subjectName;
	
	
	//是否设置选项卡
	@ParamAnnotation
	@Column(name="is_set_option")
	private Integer isSetOption;
	
	
	//中奖名额，在竞答红包中才有此字段
	@ParamAnnotation
	@Column
	private Integer placesNum;
	
	//报名参赛费
	@ParamAnnotation
	@Column(name="is_entry_fee")
	private Integer isEntryFee;
	
	//参赛费用
	@ParamAnnotation
	@Column(name="entry_fee")
	private String entryFee;
	
	
	//是否已经出题
	@ParamAnnotation
	@Column(name="is_give_question")
	private Integer isGiveQuestion;
	
	//题目数量
	@ParamAnnotation
	@Column(name="question_num")
	private Integer questionNum;
	
	@Column(name = "create_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime createAt;
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
	
	
	
	public Integer getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(Integer questionNum) {
		this.questionNum = questionNum;
	}
	public Integer getIsEntryFee() {
		return isEntryFee;
	}
	public void setIsEntryFee(Integer isEntryFee) {
		this.isEntryFee = isEntryFee;
	}
	public String getEntryFee() {
		return entryFee;
	}
	public void setEntryFee(String entryFee) {
		this.entryFee = entryFee;
	}
	public Integer getIsGiveQuestion() {
		return isGiveQuestion;
	}
	public void setIsGiveQuestion(Integer isGiveQuestion) {
		this.isGiveQuestion = isGiveQuestion;
	}
	public Integer getPlacesNum() {
		return placesNum;
	}
	public void setPlacesNum(Integer placesNum) {
		this.placesNum = placesNum;
	}
	public Integer getIsSetOption() {
		return isSetOption;
	}
	public void setIsSetOption(Integer isSetOption) {
		this.isSetOption = isSetOption;
	}
	public String getHandRoomMemberId() {
		return handRoomMemberId;
	}
	public void setHandRoomMemberId(String handRoomMemberId) {
		this.handRoomMemberId = handRoomMemberId;
	}
	public String getDrawRoomId() {
		return drawRoomId;
	}
	public void setDrawRoomId(String drawRoomId) {
		this.drawRoomId = drawRoomId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getHandDrawUserId() {
		return handDrawUserId;
	}
	public void setHandDrawUserId(String handDrawUserId) {
		this.handDrawUserId = handDrawUserId;
	}
	public String getReceiveDrawUserId() {
		return receiveDrawUserId;
	}
	public void setReceiveDrawUserId(String receiveDrawUserId) {
		this.receiveDrawUserId = receiveDrawUserId;
	}
	public DateTime getHandTime() {
		return handTime;
	}
	public void setHandTime(DateTime handTime) {
		this.handTime = handTime;
	}
	public int getTimeLong() {
		return timeLong;
	}
	public void setTimeLong(int timeLong) {
		this.timeLong = timeLong;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
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
	public Integer getIsTimeout() {
		return isTimeout;
	}
	public void setIsTimeout(Integer isTimeout) {
		this.isTimeout = isTimeout;
	}
	public Integer getAllowWrongCount() {
		return allowWrongCount;
	}
	public void setAllowWrongCount(Integer allowWrongCount) {
		this.allowWrongCount = allowWrongCount;
	}
	public Integer getIsPay() {
		return isPay;
	}
	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public Integer getIsRefund() {
		return isRefund;
	}
	public void setIsRefund(Integer isRefund) {
		this.isRefund = isRefund;
	}
	public Integer getIsRefundError() {
		return isRefundError;
	}
	public void setIsRefundError(Integer isRefundError) {
		this.isRefundError = isRefundError;
	}
	public Integer getIsImg() {
		return isImg;
	}
	public void setIsImg(Integer isImg) {
		this.isImg = isImg;
	}
	public Integer getTakePartCount() {
		return takePartCount;
	}
	public void setTakePartCount(Integer takePartCount) {
		this.takePartCount = takePartCount;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getHandUserImgUrl() {
		return handUserImgUrl;
	}
	public void setHandUserImgUrl(String handUserImgUrl) {
		this.handUserImgUrl = handUserImgUrl;
	}
	public String getHandNickname() {
		return handNickname;
	}
	public void setHandNickname(String handNickname) {
		this.handNickname = handNickname;
	}
	public Integer getIsAmountDisplay() {
		return isAmountDisplay;
	}
	public void setIsAmountDisplay(Integer isAmountDisplay) {
		this.isAmountDisplay = isAmountDisplay;
	}
	public Integer getShareNumShowAnswer() {
		return shareNumShowAnswer;
	}
	public void setShareNumShowAnswer(Integer shareNumShowAnswer) {
		this.shareNumShowAnswer = shareNumShowAnswer;
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
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
}
