package com.sist.dao;
/*
 * NINO       NOT NULL NUMBER        
	IMAGE      NOT NULL VARCHAR2(260) 
	TIME                DATE          
	WORK_STATE NOT NULL VARCHAR2(20)  
 */
import java.util.*;
public class NationIntroduceVO {
	private int nino;
	private String image,nation,title,work_state;
	private Date time;
	
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNino() {
		return nino;
	}
	public void setNino(int nino) {
		this.nino = nino;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getWork_state() {
		return work_state;
	}
	public void setWork_state(String work_state) {
		this.work_state = work_state;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
