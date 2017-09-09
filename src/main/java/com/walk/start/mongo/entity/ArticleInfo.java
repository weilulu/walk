package com.walk.start.mongo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ArticleInfo")
public class ArticleInfo {

	@Id ObjectId _id;
	private int id;
	@Field ("title")
	private String title;
	//private String author;
	//private String summary;
	@Field ("content")
	private String content;
	@Field ("post_time")
	private String postTime;
	
	
	/*public ArticleInfo(int id, String title, String content, String postTime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.postTime = postTime;
	}*/
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	/*public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}*/
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	
	
}
