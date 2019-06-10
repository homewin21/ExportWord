package com.homewin.util;

public class StringUtil {
	public static String getParam(String param1,String param2) {
		String result;
		if (param1.equals("")) {
			result=param2;
		}else {
			result=param1;
		}
		return result;
	}
	
}
