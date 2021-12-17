package com.project.melon.model;

import java.util.Date;

public class MemberVO {
	/* Value Object*/
	private int member_no = 0;
	private String email = "";
	private String password = "";
	private String auth = "";
	private int memberClass = 0;
	private String nickName = "";
	private int cash = 0;
	private int age = 0;
	private String gender = "";
	private Date createDate = null;
	private Date modifyDate = null;

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVO(int member_no, String email, String password, String auth, int memberClass, String nickName,
			int cash, int age, String gender, Date createDate, Date modifyDate) {
		super();
		this.member_no = member_no;
		this.email = email;
		this.password = password;
		this.auth = auth;
		this.memberClass = memberClass;
		this.nickName = nickName;
		this.cash = cash;
		this.age = age;
		this.gender = gender;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public int getMemberClass() {
		return memberClass;
	}
	public void setMemberClass(int memberClass) {
		this.memberClass = memberClass;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "MemberVo [member_no=" + member_no + ", email=" + email + ", password=" + password + ", auth=" + auth
				+ ", memberClass=" + memberClass + ", nickName=" + nickName + ", cash=" + cash + ", age=" + age
				+ ", gender=" + gender + ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}	
	
}

