package com.homewin.entity;

public class Word {
	private String user_id;
	private String user_name;
	private String word_name;
	private String word_path;
	private String create_time;
	public String getUser_id() {
		return user_id;
	}
	public Word(String user_id, String user_name, String word_name, String word_path, String create_time) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.word_name = word_name;
		this.word_path = word_path;
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Word [user_id=" + user_id + ", user_name=" + user_name + ", word_name=" + word_name + ", word_path="
				+ word_path + ", create_time=" + create_time + "]";
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getWord_name() {
		return word_name;
	}
	public void setWord_name(String word_name) {
		this.word_name = word_name;
	}
	public String getWord_path() {
		return word_path;
	}
	public void setWord_path(String word_path) {
		this.word_path = word_path;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
}
