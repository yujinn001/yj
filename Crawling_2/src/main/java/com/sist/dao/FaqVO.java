package com.sist.dao;
//sul_faq_2_2
/*
 * FNO     NOT NULL NUMBER         
	TYPE    NOT NULL VARCHAR2(20)   
	SUBJECT NOT NULL VARCHAR2(1000) 
	CONTENT NOT NULL CLOB           
	HIT              NUMBER   
 */
public class FaqVO {
	private int fno,hit,fcno;
	private String cate,type,subject,content;
	
	public int getFcno() {
		return fcno;
	}
	public void setFcno(int fcno) {
		this.fcno = fcno;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	

	
}
