package com.sist.dao;
/*
IUNO    NOT NULL NUMBER         
SUBJECT NOT NULL VARCHAR2(1000) 
CONTENT NOT NULL CLOB           
IMAGE   NOT NULL VARCHAR2(260)  
REGDATE          DATE           
HIT              NUMBER         
 */
import java.util.*;

public class InformationUseVO {
	private int iuno,hit;
	private String subject,content,image;
	private Date regdate;
	public int getIuno() {
		return iuno;
	}
	public void setIuno(int iuno) {
		this.iuno = iuno;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
    
}

