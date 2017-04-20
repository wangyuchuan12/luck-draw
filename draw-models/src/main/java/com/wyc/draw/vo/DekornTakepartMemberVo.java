package com.wyc.draw.vo;
import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class DekornTakepartMemberVo {
	
	@IdAnnotation
	private String id;

	
	@ParamAnnotation
	private String dekornId;
	
	@ParamAnnotation
	private String drawUserId;
	
	//参加时间
	@ParamAnnotation
	private String takepartDateTime;
	
	//是否领取成功
	@ParamAnnotation
	private Integer isSuccess;
	
	//使用爱心个数，这个爱心指的是参加这个挑战消耗了多少爱心
	@ParamAnnotation
	private Long useLoveLife;
	
	//别呢
	@ParamAnnotation
	private String nickname;
	
	//头像
	@ParamAnnotation
	private String headImg;
	
	//分数
	@ParamAnnotation
	private Long score;
	
	//所用时间
	@ParamAnnotation
	private Long timeLong;
	
	//获取智慧豆个数
	@ParamAnnotation
	private Long obtainWisdomNum;
	
	//获取经验数量
	@ParamAnnotation
	private Long obtainIntegralNum;
	
	@ParamAnnotation
	private Integer takepartStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDekornId() {
		return dekornId;
	}

	public void setDekornId(String dekornId) {
		this.dekornId = dekornId;
	}

	public String getDrawUserId() {
		return drawUserId;
	}

	public void setDrawUserId(String drawUserId) {
		this.drawUserId = drawUserId;
	}

	public String getTakepartDateTime() {
		return takepartDateTime;
	}

	public void setTakepartDateTime(String takepartDateTime) {
		this.takepartDateTime = takepartDateTime;
	}

	public Integer getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Integer isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Long getUseLoveLife() {
		return useLoveLife;
	}

	public void setUseLoveLife(Long useLoveLife) {
		this.useLoveLife = useLoveLife;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getTimeLong() {
		return timeLong;
	}

	public void setTimeLong(Long timeLong) {
		this.timeLong = timeLong;
	}

	public Long getObtainWisdomNum() {
		return obtainWisdomNum;
	}

	public void setObtainWisdomNum(Long obtainWisdomNum) {
		this.obtainWisdomNum = obtainWisdomNum;
	}

	public Long getObtainIntegralNum() {
		return obtainIntegralNum;
	}

	public void setObtainIntegralNum(Long obtainIntegralNum) {
		this.obtainIntegralNum = obtainIntegralNum;
	}

	public Integer getTakepartStatus() {
		return takepartStatus;
	}

	public void setTakepartStatus(Integer takepartStatus) {
		this.takepartStatus = takepartStatus;
	}
	
	
}
