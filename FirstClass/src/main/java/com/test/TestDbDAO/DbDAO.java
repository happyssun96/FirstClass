package com.test.TestDbDAO;

import java.sql.*;
import java.util.*;

import com.test.TestSongVo.SongVo;

public class DbDAO {
	
	//DB저장하는 메소드
	public static void UploadToDB(ArrayList<SongVo> SL) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@220.77.164.30:1521:xe";
		String user = "FirstClass";
		String password = "1234";
		
		Connection con;
		
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			if (con != null) {
				System.out.println("접속 성공!");
			}
			for (int i = 0; i < SL.size(); i++) {
//				 SL(0) ==> songVo
				SongVo tmpVo = SL.get(i);
				String sql = "insert into MELONDB(rank, NAME, artist, album) values(?,?,?,?)";
				PreparedStatement pst = con.prepareStatement(sql);
				
				pst.setInt(1, tmpVo.getRank());
				pst.setString(2, tmpVo.getName());
				pst.setString(3, tmpVo.getArtist());
				pst.setString(4, tmpVo.getAlbum());
				int su = pst.executeUpdate();
				if (su != 0) {
					System.out.println(su + "rows 업로드 성공!");
				}else {
					System.out.println("업로드 실패!");
				}
			}
			System.out.println("업로드 성공!");
		
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
		//uploadToDB 종료
	
	public static ArrayList<SongVo> DownloadToDB() {
		ArrayList<SongVo> SL = new ArrayList<SongVo>();
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@220.77.164.30:1521:xe";
		String user = "FirstClass";
		String password = "1234";
		
		Connection con;
		
		
		int rank = 0;
		String NT, ST, AT;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			if (con != null) {
				System.out.println("접속 성공!");
			}
			String sql = "select * from MELONDB";
//			System.out.println(sql);
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet re = pst.executeQuery();
			while (re.next()) {
				rank = re.getInt("rank");
				NT = re.getString("NAME");
				ST = re.getString("artist");
				AT = re.getString("album");
				SongVo tmpVo = new SongVo(rank, NT, ST, AT);
				SL.add(tmpVo);
//				System.out.println(rank);
//				System.out.println(NT);
//				System.out.println(ST);
//				System.out.println(AT);
			}
			
			System.out.println("다운로드 성공!");
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return SL;	
	}
		
		
	
	
	
}
