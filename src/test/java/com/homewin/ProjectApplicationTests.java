package com.homewin;

import java.security.MessageDigest;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import sun.misc.BASE64Encoder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationTests {

	@SuppressWarnings("restriction")
	@Test
	public void contextLoads() {
//		String aString = "123asdaz";
//		try {
//			MessageDigest md5=MessageDigest.getInstance("MD5");
//			BASE64Encoder base64en = new BASE64Encoder();
//			String newstr=base64en.encode(md5.digest(aString.getBytes("utf-8")));
//			System.out.println(newstr);
//			System.out.println(base64en.encode(md5.digest("123asdaz".getBytes("utf-8"))));
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}
//	@Test
//	public void Test() {
//		
//		String uid =UUID.randomUUID().toString().replaceAll("-", "");
//		System.out.println();
//		String sid=(com.homewin.util.mail.SysConfig.getInstance().getProperty("sid"));
//		System.out.println(sid);
//		MessageUtil.testSendSms("222222,60", "18559179737",uid );
//	}
//	@Test
//	public void Test1() {
//		String phone="18559179737";
//		String regEx ="^1([38]\\d|5[0-35-9]|7[3678])\\d{8}$";
//		Pattern pattern = Pattern.compile(regEx);
//		Matcher matcher =pattern.matcher(phone);
//		System.out.println(matcher.matches());
//		
//		
//	}
//	@Test
//	public void Test() {
//		Random random = new Random();
//		String a = "";
//		for (int j = 0; j <6; j++) {
//			a += String.valueOf(random.nextInt(10));
//		}
//		System.out.println(a);
//	}

}
