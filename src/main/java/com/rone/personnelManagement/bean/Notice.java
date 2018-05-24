package com.rone.personnelManagement.bean;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private Date date;
	@Column(nullable = false)
	private String title;
	@Column(columnDefinition = "text", nullable = false)
	private String content;
	
	public Notice(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public Notice() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", date=" + date + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
}
