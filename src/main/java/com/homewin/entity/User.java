package com.homewin.entity;

import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
public class User {
	private String id;
	@Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$" , message="请输入正确格式的用户名")
	private String username;
	@Pattern(regexp="^[\\w_-]{6,16}$",message="请输入正确格式的密码")
	private String password;
	@Pattern(regexp="^1([38]\\d|5[0-35-9]|7[3678])\\d{8}$",message="请输入正确的号码")
	private String phone;
//	@Pattern(regexp="^[0-9]{6}$",message="请输入正确的验证码")
//	private String vercode;
	
	
//	public String getVercode() {
//		return vercode;
//	}
//	public void setVercode(String vercode) {
//		this.vercode = vercode;
//	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
