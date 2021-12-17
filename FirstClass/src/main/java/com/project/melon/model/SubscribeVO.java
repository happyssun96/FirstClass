package com.project.melon.model;

import java.util.Date;

public class SubscribeVO {
	
	private int subscribe_no = 0;
	private int member_no = 0;
	private String expire_reservation = "";
	private Date purchaseDate = null;
	private Date expireDate = null;
	public SubscribeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubscribeVO(int subscribe_no, int member_no, String expire_reservation, Date purchaseDate, Date expireDate) {
		super();
		this.subscribe_no = subscribe_no;
		this.member_no = member_no;
		this.expire_reservation = expire_reservation;
		this.purchaseDate = purchaseDate;
		this.expireDate = expireDate;
	}
	public int getSubscribe_no() {
		return subscribe_no;
	}
	public void setSubscribe_no(int subscribe_no) {
		this.subscribe_no = subscribe_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getExpire_reservation() {
		return expire_reservation;
	}
	public void setExpire_reservation(String expire_reservation) {
		this.expire_reservation = expire_reservation;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	@Override
	public String toString() {
		return "SubscribeVO [subscribe_no=" + subscribe_no + ", member_no=" + member_no + ", expire_reservation="
				+ expire_reservation + ", purchaseDate=" + purchaseDate + ", expireDate=" + expireDate + "]";
	}
	
	
}
