package com.wyc.common.util;



public class Constant {

	
	
	public static final int SEX_FEMALE_TYPE =0; // 女
	public static final int SEX_MALE_TYPE =1; // 男
	public static final int SEX_UNKNOW_TYPE =2; // 未知
	
	
	
	/***********************房间验证类型************************/
	//密码验证
	public static final int PASSWORD_VERIFY_TYPE = 0;
	
	//问题验证
	public static final int QUESTION_VERIFY_TYPE = 1;
	
	
	/***********************房间用户状态************************/
	
	//申请中
	public static final int AUDIT_DRAW_ROOM_MEMEBER_STATUS = 0;
	
	//申请通过
	public static final int PASSED_DRAW_ROOM_MEMEBER_STATUS = 1;
	
	//已退出
	public static final int OUT_DRAW_ROOM_MEMEBER_STATUS = 2;
	
	
	/***********************红包类型************************/
	//房间问答红包
	public static final int ROOM_QUESTION_TYPE = 0;
	//个人问答红包
	public static final int PERSONAL_QUESTION_TYPE=1;
	
	
	/***********************支付类型************************/
	//余额支付
	public static final int ACCOUNT_PAY_TYPE=0;
	
	//微信支付
	public static final int WX_PAY_TYPE=1;
	
	
	/***********************申请单状态************************/
	//申请单申请中状态
	public static final int APPLY_FORM_STATUS_IN = 0;
	
	//申请单申请成功状态
	public static final int APPLY_FORM_STATUS_SUCCESS = 1;
	
	//申请单申请失败状态
	public static final int APPLY_FORM_STATUS_FAILURE = 2;
	
	
	
	/***********************申请单类型************************/
	//申请单提现申请
	public static final int APPLY_FORM_TYPE_TAKE_OUT = 0;
	
	
}
