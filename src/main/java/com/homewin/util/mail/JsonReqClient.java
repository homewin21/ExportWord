package com.homewin.util.mail;

import com.alibaba.fastjson.JSONObject;

public class JsonReqClient extends AbsRestClient {

	@Override
	public String sendSms(String param, String mobile,
			String uid) {
String result = "";
		
		try {
			String url = getStringBuffer().append("/sendsms").toString();
			String sid=(SysConfig.getInstance().getProperty("sid"));
			String token=(SysConfig.getInstance().getProperty("token"));
			String appid=(SysConfig.getInstance().getProperty("appid"));
			String templateid=(SysConfig.getInstance().getProperty("templateid"));
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("templateid", templateid);
			jsonObject.put("param", param);
			jsonObject.put("mobile", mobile);
			jsonObject.put("uid", uid);
			
			String body = jsonObject.toJSONString();
			
			System.out.println("body = " + body);
			
			result = HttpClientUtil.postJson(url, body, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
