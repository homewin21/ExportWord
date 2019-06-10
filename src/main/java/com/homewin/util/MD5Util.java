package com.homewin.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Util {
 public	static String EncodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
			MessageDigest md5=MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
		return newstr;
	}
 public	static boolean CheckMd5(String a,String b) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (EncodeByMd5(a).equals(EncodeByMd5(b))) {
			return true;
		} else {
			return false;
		}
		
		
	}
	
}
