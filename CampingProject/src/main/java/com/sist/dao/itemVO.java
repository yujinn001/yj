package com.sist.dao;
/*
 * INO            NOT NULL NUMBER         
IMAGE          NOT NULL VARCHAR2(260)  
NAME           NOT NULL VARCHAR2(4000) 
PRICE                   NUMBER         
DESCRIPTION             CLOB           
STOCK                   NUMBER         
STATUS         NOT NULL VARCHAR2(100)  
DISCOUNT                NUMBER         
DELIVERY_PRICE          NUMBER         
LIKE_CNT                NUMBER         
JJIM_CNT                NUMBER         
ICNO                    NUMBER   

 */
public class itemVO {
	private int ino,price,stock,discount,delivery_price,like_cnt,jjim_cnt,icno;
	private String image,name,description,status,link;
	
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getDelivery_price() {
		return delivery_price;
	}
	public void setDelivery_price(int delivery_price) {
		this.delivery_price = delivery_price;
	}
	public int getLike_cnt() {
		return like_cnt;
	}
	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}
	public int getJjim_cnt() {
		return jjim_cnt;
	}
	public void setJjim_cnt(int jjim_cnt) {
		this.jjim_cnt = jjim_cnt;
	}
	public int getIcno() {
		return icno;
	}
	public void setIcno(int icno) {
		this.icno = icno;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
