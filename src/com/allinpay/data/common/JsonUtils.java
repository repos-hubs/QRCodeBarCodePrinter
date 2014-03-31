package com.allinpay.data.common;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.allinpay.entity.Demo1Entity;


/**
 * <p>Title: JsonUtils.java</p>
 * <p>Description: be used for parsing json objects.</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: All In Pay</p>
 * @author 		Teddy
 * @date 		2013-11-5
 * @version 	
 */
public class JsonUtils {
	
	/**
	* @Title: getStringValue
	* @Description: TODO
	* @param @param jsonObject
	* @param @param jsonNameKey
	* @param @return
	* @param @throws JSONException
	* @return String 
	* @throws
	*/
	public static String getStringValue(JSONObject jsonObject, String jsonNameKey) throws JSONException {
		if(null == jsonObject) {
			return null;
		}
		if(!jsonObject.isNull(jsonNameKey)) {
			return jsonObject.getString(jsonNameKey);
		}
		return null;
	}
	
	public static int getIntValue(JSONObject jsonObject, String jsonNameKey) throws JSONException {
		if(null == jsonObject) {
			return -1;
		}
		if(!jsonObject.isNull(jsonNameKey)) {
			return jsonObject.getInt(jsonNameKey);
		}
		return -1;
	}
	public static long getLongValue(JSONObject jsonObject, String jsonNameKey) throws JSONException {
		if(null == jsonObject) {
			return -1L;
		}
		if(!jsonObject.isNull(jsonNameKey)) {
			return jsonObject.getLong(jsonNameKey);
		}
		return -1L;
	}
	
	public static JSONObject getJSONObject(JSONObject jsonObject, String jsonNameKey) throws JSONException {
		if(null == jsonObject) {
			return null;
		}
		if(!jsonObject.isNull(jsonNameKey)) {
			return jsonObject.getJSONObject(jsonNameKey);
		}
		return null;	
	}
	
	public static JSONArray getJSONArray(JSONObject jsonObject, String jsonNameKey) throws JSONException {
		if(null == jsonObject) {
			return null;
		}
		if(!jsonObject.isNull(jsonNameKey)) {
			return jsonObject.getJSONArray(jsonNameKey);
		}
		return null;	
	}
	/*
	public static ReceiptEntity parseReceipt(String jsonStr) {
		ReceiptEntity receipt = null;
		try {
			JSONObject jsonObj = new JSONObject(jsonStr);
			receipt = new ReceiptEntity();
			receipt.setReceiptTitle(getStringValue(jsonObj, "restaurant"));
			receipt.setReceiptType(getStringValue(jsonObj, "type"));
			receipt.setContactPerson(getStringValue(jsonObj, "contactPerson"));
			receipt.setContactTel(getStringValue(jsonObj, "contactTel"));
			receipt.setDeliveryAddress(getStringValue(jsonObj, "deliverAddress"));
			receipt.setDeliveryTime(getStringValue(jsonObj, "deliverTime"));
			receipt.setOperator(getStringValue(jsonObj, "operator"));
			receipt.setOrderNo(getStringValue(jsonObj, "orderNo"));
			receipt.setPaidAmount(getStringValue(jsonObj, "payedAmount"));
			receipt.setTotalAmount(getStringValue(jsonObj, "totalAmount"));
			receipt.setTableNumber(getStringValue(jsonObj, "seat"));
			
			JSONArray items = getJSONArray(jsonObj, "items");
			String[][] menuArray = null;
			if (items != null && items.length() > 0) {
				
				menuArray = new String[items.length()][];
				for (int i = 0; i < items.length(); i++) {
					JSONArray menu = items.getJSONArray(i);					
					menuArray[i] = new String[menu.length()];
					if (menu != null && menu.length() > 0) {
						for (int j = 0; j < menu.length(); j++) {
							menuArray[i][j] = menu.getString(j);
						}
					}
				}
			}
			receipt.setMenusArray(menuArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return receipt;
	}
	*/
	/*
	public static QueueEntity parseQueue(String jsonStr) {
		QueueEntity queue = null;
		try {
			JSONObject jsonObj = new JSONObject(jsonStr);
			queue = new QueueEntity();
			queue.setRestaurantName(getStringValue(jsonObj, "restaurant"));
			queue.setCreateTime(getStringValue(jsonObj, "createdTime"));
			queue.setSeat(getStringValue(jsonObj, "seat"));
			queue.setNumber(getStringValue(jsonObj, "number"));
			queue.setRemindInAdvance(getIntValue(jsonObj, "remindInAdvance"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queue;
	}
	*/
	
	public static Demo1Entity parseDemo1(String jsonStr) {
		Demo1Entity demo1 = null;
		try {
			
			JSONObject jsonObj = new JSONObject(jsonStr);
			demo1 = new Demo1Entity();
			demo1.setDate(getStringValue(jsonObj, "date"));
			demo1.setDealType(getStringValue(jsonObj, "dealType"));
			demo1.setMerchant(getStringValue(jsonObj, "merchant"));
			demo1.setOrderNo(getStringValue(jsonObj, "orderNo"));
			demo1.setPayAccount(getStringValue(jsonObj, "payAccount"));
			demo1.setPayAmount(getStringValue(jsonObj, "payAmount"));
			demo1.setPayMethod(getStringValue(jsonObj, "payMethod"));
			demo1.setReceoptTitle(getStringValue(jsonObj, "receoptTitle"));
			demo1.setRefNo(getStringValue(jsonObj, "refNo"));
			demo1.setTerminalNo(getStringValue(jsonObj, "terminalNo"));
			demo1.setTime(getStringValue(jsonObj, "time"));
			demo1.setTraceNo(getStringValue(jsonObj, "traceNo"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return demo1;
	}
	
}
