package com.sist.dao;
/*
 * SFCNO NOT NULL NUMBER       
	CATE  NOT NULL VARCHAR2(34) 
 */
public class FaqCategoryVO {
	private int sfcno;
	private String cate;
	public int getSfcno() {
		return sfcno;
	}
	public void setSfcno(int sfcno) {
		this.sfcno = sfcno;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	
}
