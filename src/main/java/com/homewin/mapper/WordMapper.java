package com.homewin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.homewin.entity.Word;

@Mapper
public interface WordMapper {
	@Select("select * from word where user_id = #{user_id}")
	public List<Word> getWord(String user_id);
	@Insert("insert into word(user_id,user_name,word_name,word_path,create_time) values(#{user_id},#{user_name},#{word_name},#{word_path},#{create_time})")
	public int addWord(Word word);
	@Delete("delete from word where word_name = #{word_name}")
	public int delWord(String word_name);
}
