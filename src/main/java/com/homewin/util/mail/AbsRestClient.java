package com.homewin.util.mail;


public abstract class AbsRestClient {
	public String server=SysConfig.getInstance().getProperty("rest_server");
	public abstract String sendSms( String param, String mobile, String uid);

	public StringBuffer getStringBuffer() {
		StringBuffer sb = new StringBuffer("https://");
		sb.append(server).append("/ol/sms");
		return sb;
	}
}
