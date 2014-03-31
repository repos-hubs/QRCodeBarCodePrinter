package com.allinpay.printer.constants;

import com.allinpay.entity.Demo1Entity;
import com.allinpay.printer.exception.AccessException;

public abstract class EBuyConstant {
	
	protected static final String TAG_DTITAL = "e-Buy电子凭证";

	protected static final String TAG_LINE = "******************************";
	
	protected static final String TAG_LINE2 = "------------------------------";
	
	protected static final String TAG_MERCHANT = "商户名称：";
	
	protected static final String TAG_TERMINAL = "终端编号：";

	protected static final String TAG_REF = "参考号  ：";
	
	protected static final String TAG_DATE = "日  期  ：";

	protected static final String TAG_TIME = "时  间  ：";
	
	protected static final String TAG_PAYTYPE = "交易类型：";

	protected static final String TAG_TRACE = "流水号  ：";
	
	protected static final String TAG_ACCOUNT = "支付账户：";

	protected static final String TAG_CHANNEL = "支付渠道：";
	
	protected static final String TAG_AMOUNT = "支付金额：";
	
	protected static final String TAG_TELLERNO = "柜员号  ：";
	
	protected static final String TAG_SIGNATURE = "用户签名：";
	
	public abstract void print(Demo1Entity demodata) throws AccessException;
}
