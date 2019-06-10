package com.homewin.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homewin.entity.User;
import com.homewin.mapper.UserMapper;
import com.homewin.util.MD5Util;
import com.homewin.util.MessageUtil;

@Controller
public class UserController {
	@Autowired
	UserMapper userMapper;
	//存放phone和uid
	 Map<String, String> uidMap=new HashMap<>();
	//存放uid和vercode
	Map<String, String> verMap= new HashMap<>();
	@RequestMapping("/welcome")
	public String login() {
		
		return "login";
	}
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
	@ResponseBody
	@RequestMapping(value="/sendVerCode/{phone}")
	public String sendVerCode(@PathVariable String phone) {
		String result = "";
		String regEx ="^1([38]\\d|5[0-35-9]|7[3678])\\d{8}$";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(phone);
		Random random = new Random();
		String vercode = "";
		//生成6位随机验证码
		for (int j = 0; j <6; j++) {
			vercode += String.valueOf(random.nextInt(10));
		}
		System.out.println(vercode);
		boolean flag = matcher.matches();
		if (flag) {
			
			String uid =UUID.randomUUID().toString().replaceAll("-", "");
			uidMap.put(phone, uid);
			verMap.put(uid, vercode);
			MessageUtil.testSendSms(vercode+",60", phone, uid);
			result = vercode;
		}else {
			result = "no";
		}
		
		return result;
		
	}
	

	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String name(HttpServletRequest request,HttpSession session,Map<String, Object> map) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		boolean flag= false;
		String username = request.getParameter("username");
		String password = MD5Util.EncodeByMd5(request.getParameter("password"));
		List<User> userList =  userMapper.getUserByName(username);
		for(User user : userList) {
				if (user.getUsername().equals(username)&&user.getPassword().equals(password)) {
					flag=true;
					if (session.getAttribute("user")!=null) {
						session.removeAttribute("user");
						session.setAttribute("user", user);
					}else {
						session.setAttribute("user", user);
					}
					
					
					break;
				}
			}
		if (flag==true) {
			return "main";
		}
		else {
			map.put("lg_msg", "用户名密码不正确");
			return "login";
		}
		
	}
//	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addUser(@Valid  User user,BindingResult bindingResult, Map<String, Object> map,HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String vercode = request.getParameter("vercode");
		String regEx ="^[0-9]{6}$";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(vercode);
		boolean flag = matcher.matches();
		if (flag==false||uidMap.get(user.getPhone())==null||verMap.get(uidMap.get(user.getPhone()))==null||!verMap.get(uidMap.get(user.getPhone())).equals(vercode)) {
			map.put("msg4", "请填写正确的验证码！");
			if (bindingResult.hasErrors()) {
				FieldError userValid = bindingResult.getFieldError("username");
				FieldError pwValid = bindingResult.getFieldError("password");
				FieldError phValid = bindingResult.getFieldError("phone");
				if (userValid!=null) {
					map.put("msg1", userValid.getDefaultMessage());	
				}
				if (pwValid!=null) {
					map.put("msg2", pwValid.getDefaultMessage());	
				}
				if (phValid!=null) {
					map.put("msg3", phValid.getDefaultMessage());	
				}
			
			}
			return "register";
		}
		
		

		else {
			user.setPassword(MD5Util.EncodeByMd5(user.getPassword()));
			user.setId(UUID.randomUUID().toString().substring(0, 10));
			userMapper.addUser(user);
			return "redirect:/welcome";
		}
		
	}
}
