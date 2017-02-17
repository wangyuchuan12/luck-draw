package com.wyc.draw.vo;
import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class ShareVo {
	@IdAnnotation
    private String id;

	@ParamAnnotation
	private String hrefId;
	
	@ParamAnnotation
	private String sponsorOpenid;
	
	@ParamAnnotation
	private int type;

	@ParamAnnotation
	private String url;
	
	@ParamAnnotation
	private int shareCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHrefId() {
		return hrefId;
	}

	public void setHrefId(String hrefId) {
		this.hrefId = hrefId;
	}

	public String getSponsorOpenid() {
		return sponsorOpenid;
	}

	public void setSponsorOpenid(String sponsorOpenid) {
		this.sponsorOpenid = sponsorOpenid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getShareCount() {
		return shareCount;
	}

	public void setShareCount(int shareCount) {
		this.shareCount = shareCount;
	}

}
