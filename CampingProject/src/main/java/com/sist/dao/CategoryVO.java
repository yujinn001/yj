package com.sist.dao;
/*
 * ICNO NOT NULL NUMBER       
	NAME NOT NULL VARCHAR2(34) 
 */
public class CategoryVO {
	private int icno;
	private String name, link;
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getIcno() {
		return icno;
	}
	public void setIcno(int icno) {
		this.icno = icno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
