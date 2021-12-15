package com.project.melon.model;

public class PlayListVO {
	
	int playList_no = 0;
	int member_no = 0;
	int song_no = 0;
	
	public PlayListVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PlayListVO(int playList_no, int member_no, int song_no) {
		super();
		this.playList_no = playList_no;
		this.member_no = member_no;
		this.song_no = song_no;
	}
	
	public int getPlayList_no() {
		return playList_no;
	}
	public void setPlayList_no(int playList_no) {
		this.playList_no = playList_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getSong_no() {
		return song_no;
	}
	public void setSong_no(int song_no) {
		this.song_no = song_no;
	}
	
	@Override
	public String toString() {
		return "PlayListVO [playList_no=" + playList_no + ", member_no=" + member_no + ", song_no=" + song_no + "]";
	}
	
	
	
	
}
