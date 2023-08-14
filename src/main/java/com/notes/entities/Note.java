package com.notes.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
@Entity
@Table(name="notes")
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;	
	
	@Column(length = 100)
	private String title;
	@Column(length = 2000)
	private String content;	
	private Date createDate;
	
	
	public Note(String title, String content, Date createDate) {
		super();
		this.title = title;
		this.content = content;
		this.createDate = createDate;
	}
	
	
	


	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}





	public int getId() {
		return Id;
	}


	public String getTitle() {
		return title;
	}


	public String getContent() {
		return content;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setId(int id) {
		Id = id;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	

}
