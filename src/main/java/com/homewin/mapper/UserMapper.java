package com.homewin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.homewin.entity.User;

@Mapper
public interface UserMapper {
	@Select("select * from user where id = #{id}")
	public User getUser(String id);
	@Insert("insert into user(id, username,password,phone) values(#{id},#{username},#{password},#{phone})")
	public int addUser(User user);
	@Select("select * from user where username = #{username}")
	public List<User> getUserByName(String username);
}
