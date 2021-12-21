package com.project.melon.model;

public class MelonVO {
	
	private int mrank;
	private String mname;
	private String martist;
	private String malbum;
	public MelonVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MelonVO(int mrank, String mname, String martist, String malbum) {
		super();
		this.mrank = mrank;
		this.mname = mname;
		this.martist = martist;
		this.malbum = malbum;
	}
	public int getMrank() {
		return mrank;
	}
	public void setMrank(int mrank) {
		this.mrank = mrank;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMartist() {
		return martist;
	}
	public void setMartist(String martist) {
		this.martist = martist;
	}
	public String getMalbum() {
		return malbum;
	}
	public void setMalbum(String malbum) {
		this.malbum = malbum;
	}
	@Override
	public String toString() {
		return "MelonVO [mrank=" + mrank + ", mname=" + mname + ", martist=" + martist + ", malbum=" + malbum + "]";
	}
	


	
	
	
}
