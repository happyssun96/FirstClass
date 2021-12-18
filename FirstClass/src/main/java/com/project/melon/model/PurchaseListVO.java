package com.project.melon.model;

public class PurchaseListVO {

	private int purchase_no = 0;
	private int member_no = 0;
	private int subscribe_no = 0;
	
	
	
	public PurchaseListVO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PurchaseListVO(int purchase_no, int member_no, int subscribe_no) {
		super();
		this.purchase_no = purchase_no;
		this.member_no = member_no;
		this.subscribe_no = subscribe_no;
	}



	public int getPurchase_no() {
		return purchase_no;
	}



	public void setPurchase_no(int purchaseList_no) {
		this.purchase_no = purchaseList_no;
	}



	public int getMember_no() {
		return member_no;
	}



	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}



	public int getSubscribe_no() {
		return subscribe_no;
	}



	public void setSubscribe_no(int subscribe_no) {
		this.subscribe_no = subscribe_no;
	}



	@Override
	public String toString() {
		return "PurchaseListVO [purchaseList_no=" + purchase_no + ", member_no=" + member_no + ", subscribe_no="
				+ subscribe_no + "]";
	}
	
	
	
	
}
