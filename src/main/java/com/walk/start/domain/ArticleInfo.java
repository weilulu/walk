package com.walk.start.domain;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "article_index", type = "article_content")
public class ArticleInfo {

	private int id;
	private String title;
	//private int category;
	private String author;
	private String summary;
	private String content;
	private String postTime;
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
	/*public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}*/
	public String getAuthor() {
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
	}
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
