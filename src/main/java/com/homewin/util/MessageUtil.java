package com.homewin.util;

import com.homewin.util.mail.AbsRestClient;
import com.homewin.util.mail.JsonReqClient;

public class MessageUtil {
	static AbsRestClient InstantiationRestAPI() {
		return new JsonReqClient();
	}
	public static String testSendSms( String param, String mobile, String uid){
		String result = "";
		try {
			 result=InstantiationRestAPI().sendSms(param, mobile, uid);
			System.out.println("Response content is: " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
