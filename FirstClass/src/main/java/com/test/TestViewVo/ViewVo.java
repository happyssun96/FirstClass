package com.test.TestViewVo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.test.TestDbDAO.DbDAO;
import com.test.TestSongVo.SongVo;

public class ViewVo{
	

	
	
	
	//검색창
	
	public static void Searching(String search, ArrayList<SongVo> SL, HashSet<Integer> Key) {
		
		char[] atmp, btmp;
		int count = 0;
		atmp = search.toCharArray();
		for (int i = 0; i < SL.size(); i++) {
			
			//이름중에서 검색할때
			btmp = SL.get(i).getName().toCharArray();
			for (char a : atmp) {
				for (char b : btmp) {
					if (a == b && a != ' ') {
						count++;
					}
				}
				
				if (count == 0) {
					break;
				}
				if (count == atmp.length) {
					Key.add(i);
					System.out.println(Key);
				}
				count = 0;
			}	
				// 아티스트중에서 검색할때
				btmp = SL.get(i).getArtist().toCharArray();
				
				for (char a : atmp) {
					for (char b : btmp) {
						if (a == b && a != ' ') {
							count++;
						}
					}
					
					if (count == 0) {
						break;
					}
					if (count == atmp.length) {
						Key.add(i);
					}
					count = 0;
				}
					
					
				//앨범 중에서 검색할 때
				btmp = SL.get(i).getAlbum().toCharArray();
				for (char a : atmp) {
					for (char b : btmp) {
						if (a == b && a != ' ') {
							count++;
						}
					}
					
					if (count == 0) {
						break;
					}
					if (count == atmp.length) {
						Key.add(i);
					}
					count = 0;
					
				}	
				
		}
	}		
		
	
		static int console(Scanner sc, int num, ArrayList<SongVo> SL) {
			String search;
			int length = SL.size();
			if (num == 1) {
				System.out.println("******************차트 top10******************");
				System.out.println("---------------------------------------------");
				for (int i = 0; i < length; i++) {
					System.out.printf("%d위\t%s\t%s\t%s\n", SL.get(i).getRank(), SL.get(i).getName(), SL.get(i).getArtist(), SL.get(i).getAlbum());
				}
				System.out.println("---------------------------------------------");
				return 1;
			}
			
			else if (num == 2) {
				HashSet<Integer> resultKey = new HashSet<Integer>();
				System.out.println("---------------------------------------------");
				System.out.println("노래/가수/앨범명을 입력하세요(반드시 택1)");
				search = sc.nextLine();
				
				Searching(search, SL, resultKey);
				Iterator<Integer> itr = resultKey.iterator();
				
				if (resultKey.size() == 0) {
					System.out.println("\t검색 결과가 없습니다.\t");
				}
				else {
					int i = 0;
					System.out.printf("총 %d 개의 검색 결과가 있습니다.\n", resultKey.size());
					while (itr.hasNext()) {
						i = (int) itr.next();
						System.out.printf("%d위\t%s\t%s\t%s\n", SL.get(i).getRank(), SL.get(i).getName(), SL.get(i).getArtist(), SL.get(i).getAlbum());
					}
				}
				
				System.out.println("----------------------끝----------------------");
				return 2;
			}
			else if (num == 3) {
				return -1;
			}
			else {
				System.out.println("1,2,3번 중에서 선택해 주세요");
			}
			return 0;
		}
			
		//메인 콘솔창
		
		public static void view_console(ArrayList<SongVo> SL) {
			
			
			
			Scanner sc = new Scanner(System.in);
			String MainMenu = "*************Water Melon*************\n1. 음원 차트 확인\n2. 검색\n3. 종료\n";
			int choice = 0;
			
			while (choice != -1) {
				System.out.println(MainMenu);
				System.out.printf("번호를 선택하세요 : ");
				choice = Integer.parseInt(sc.nextLine());
				
				choice=console(sc, choice, SL);
			}
		}
		
		
	
	
	
	
	
	
}
