package com.project.melon.model;

import java.util.Date;

public class SongVO {
	private int songNo = 0;
	private String songName = "";
	private String artist = "";
	private String albumName = "";
	private String publisher = "";
	private Date releaseDate = null;
	private Date modifyDate = null;
	private String musicResourcePath = "";
	private String albumImagePath = "";
	
	
	public SongVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SongVO(int songNo, String songName, String artist, String albumName, String publisher, Date releaseDate,
			Date modifyDate, String musicResourcePath, String albumImagePath) {
		super();
		this.songNo = songNo;
		this.songName = songName;
		this.artist = artist;
		this.albumName = albumName;
		this.publisher = publisher;
		this.releaseDate = releaseDate;
		this.modifyDate = modifyDate;
		this.musicResourcePath = musicResourcePath;
		this.albumImagePath = albumImagePath;
	}



	public int getSongNo() {
		return songNo;
	}
	public void setSongNo(int songNo) {
		this.songNo = songNo;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getMusicResourcePath() {
		return musicResourcePath;
	}
	public void setMusicResourcePath(String musicResourcePath) {
		this.musicResourcePath = musicResourcePath;
	}
	public String getAlbumImagePath() {
		return albumImagePath;
	}
	public void setAlbumImagePath(String albumImagePath) {
		this.albumImagePath = albumImagePath;
	}

	@Override
	public String toString() {
		return "SongVo [songNo=" + songNo + ", songName=" + songName + ", artist=" + artist + ", albumName=" + albumName
				+ ", publisher=" + publisher + ", releaseDate=" + releaseDate + ", modifyDate=" + modifyDate
				+ ", musicResourcePath=" + musicResourcePath + ", albumImagePath=" + albumImagePath + "]";
	}
	
	
}
