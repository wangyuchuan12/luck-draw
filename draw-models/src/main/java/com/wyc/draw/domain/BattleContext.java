package com.wyc.draw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@Entity(name="b_battle_context")
@ParamEntityAnnotation
public class BattleContext {
	
	//新增红包时默认消耗智慧豆数量
	public static final String REDPACKET_WISDOM_CODE = "redpacket_wisdom";
	
	//智慧豆冷却单位
	public static final String PROP_BEAN_UNIT_CODE = "prop_bean_unit";
	
	//智慧豆冷却上限
	public static final String PROP_BEAN_UPPER_LIMIT_CODE = "prop_bean_upper_limit";
	
	//智慧豆冷却时间间隔
	public static final String PROP_BEAN_MILLISEC_CODE = "prop_bean_millisec";
	
	//智慧豆产生数量最小
	public static final String PROP_BEAN_RANAGE_MIN_CODE = "prop_bean_ranage_min_code";
	
	//智慧豆产生数量最大
	public static final String PROP_BEAN_RANAGE_MAX_CODE = "prop_bean_ranage_max_code";
	
	//智慧豆初始值
	public static final String PROP_BEAN_SCHEDULE_CODE = "prop_bean_schedule_code";
	
	
	//爱心冷却单位
	public static final String PROP_LOVE_UNIT_CODE = "prop_love_unit";
	
	//爱心冷却上限
	public static final String PROP_LOVE_UPPER_LIMIT_CODE = "prop_love_upper_limit";
	
	//爱心冷却时间间隔
	public static final String PROP_LOVE_MILLISEC_CODE = "prop_love_millisec";
	
	//爱心产生数量最小
	public static final String PROP_LOVE_RANAGE_MIN_CODE = "prop_love_ranage_min_code";
	
	//爱心产生数量最大
	public static final String PROP_LOVE_RANAGE_MAX_CODE = "prop_love_ranage_max_code";
	
	//爱心初始值
	public static final String PROP_LOVE_SCHEDULE_CODE = "prop_love_schedule_code";
	
	
	//随机道具冷却单位
	public static final String PROP_RANDOM_UNIT_CODE = "prop_random_unit";
	
	//随机道具冷却上限
	public static final String PROP_RANDOM_UPPER_LIMIT_CODE = "prop_random_upper_limit";
	
	//随机道具冷却时间间隔
	public static final String PROP_RANDOM_MILLISEC_CODE = "prop_random_millisec";
	
	//随机道具产生数量最小
	public static final String PROP_RANDOM_BEAN_RANAGE_MIN_CODE = "prop_random_bean_ranage_min_code";
	
	//随机道具产生数量最大
	public static final String PROP_RANDOM_BEAN_RANAGE_MAX_CODE = "prop_random_bean_ranage_max_code";
	
	//随机道具产生数量最小
	public static final String PROP_RANDOM_LOVE_RANAGE_MIN_CODE = "prop_random_love_ranage_min_code";
	
	//随机道具产生数量最大
	public static final String PROP_RANDOM_LOVE_RANAGE_MAX_CODE = "prop_random_love_ranage_max_code";
	
	//随机道具初始值
	public static final String PROP_RANDOM_SCHEDULE_CODE = "prop_random_schedule_code";
	
	
	
	//体力道具冷却单位
	public static final String PROP_PHY_UNIT_CODE = "prop_phy_unit";
	
	//体力道具冷却上限
	public static final String PROP_PHY_UPPER_LIMIT_CODE = "prop_phy_upper_limit";
	
	//体力道具冷却时间间隔
	public static final String PROP_PHY_MILLISEC_CODE = "prop_phy_millisec";
	
	//体力道具产生数量最小
	public static final String PROP_PHY_RANAGE_MIN_CODE = "prop_phy_ranage_min_code";
	
	//体力道具产生数量最大
	public static final String PROP_PHY_RANAGE_MAX_CODE = "prop_phy_ranage_max_code";
	
	//体力道具初始值
	public static final String PROP_PHY_SCHEDULE_CODE = "prop_phy_schedule_code";

	@Id
	@IdAnnotation
	private String id;
	
	@Column(unique=true)
	@ParamAnnotation
	private String code;
	
	@Column
	@ParamAnnotation
	private String name;
	
	@Column
	@ParamAnnotation
	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
