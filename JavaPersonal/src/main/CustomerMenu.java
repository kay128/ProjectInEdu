package main;

import java.util.ArrayList;
import java.util.Scanner;

import action.Action;
import action.CodingCreateUserAction;
import action.CodingDropUserAction;
import action.CodingGrantAction;
import action.CodingRevorkAction;
import action.CustomerCodingListShowAction;
import action.CustomerInformationModifyAction;
import action.CustomerWithdrawAction;
import action.LogoutAction;
import consol.Consol;
import frontcontroller.FrontController;
import model.Member;

public class CustomerMenu {
		private ArrayList<String> cMenu = new ArrayList<String>();
		private ArrayList<String> cCoMenu = new ArrayList<String>();
		private Member inMember;
	public CustomerMenu() {
		cMenu.add("ㅡㅡ CoCo Menu ㅡㅡ");
		cMenu.add("SQL 코딩하기");
		cMenu.add("내 코딩 목록");
		cMenu.add("회원정보 수정");
		cMenu.add("로그아웃");
		cMenu.add("회원탈퇴");
		cMenu.add("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		cCoMenu.add("ㅡㅡ SQL 코딩 페이지 ㅡㅡ");
		cCoMenu.add("계정 관리 SQL");
		cCoMenu.add("권한 관리 SQL");
/*		cCoMenu.add("전체 DB 조회 SQL");
		cCoMenu.add("DB 생성 SQL");
		cCoMenu.add("DB 수정 SQL");
		cCoMenu.add("DB 삭제 SQL");
		cCoMenu.add("Data 입력 SQL");
		cCoMenu.add("Data 선택 SQL");
		cCoMenu.add("Data 수정 SQL");
		cCoMenu.add("Data 삭제 SQL");*/
		cCoMenu.add("이전 메뉴로");
		cCoMenu.add("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
	}
	
	public void cMenu(Scanner sc, Member inMember) {
		this.inMember = inMember;
		int cChoice = 0;
		int cCoChoice = 0;
		int cInChoice = 0;

		FrontController fc = new FrontController();
		Consol co = new Consol();

		boolean cStop = false;
		boolean inputStop = false;

		Action action = null;

/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■  회원 메뉴  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ */
		do {
			System.out.print("\n " + cMenu.get(0));
			for (int i = 1; i < cMenu.size() - 1; i++) {
				System.out.print("\n  " + (i) + ". " + cMenu.get(i) + " ");
			}
			System.out.print("\n " + cMenu.get(cMenu.size() - 1));
			do {
				try {
					System.out.print("\n  메뉴 선택 >>  ");
					cChoice = Integer.parseInt(sc.nextLine());
					System.out.println();
					if (cChoice > cMenu.size()-1 || cChoice < 1) {
						System.out.print("\n  # 잘 못 선택하셨습니다. 다시 선택해주세요 ");
						inputStop = false;
					}else if (cChoice <= cMenu.size()-1 || cChoice >= 1) {
						inputStop = true;
					}
				} catch (NumberFormatException e) {
					System.out.print("\n  # 잘 못 선택하셨습니다. 다시 선택해주세요 ");
					inputStop = false;
				}
			} while (inputStop == false);
			inputStop = false;

/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■  sql문 작성  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ */
			switch(cChoice) {
			case 1: 
					System.out.print("\n " + cCoMenu.get(0));
					for (int i = 1; i < cCoMenu.size() - 1; i++) {
						System.out.print("\n  " + (i) + ". " + cCoMenu.get(i) + " ");
					}
					System.out.print("\n " + cCoMenu.get(cCoMenu.size() - 1));
					do {
						try {
							System.out.print("\n  메뉴 선택 >>  ");
							cCoChoice = Integer.parseInt(sc.nextLine());
							System.out.println();
							if (cCoChoice > cCoMenu.size()-2 || cCoChoice < 1) {
								System.out.print("\n  # 잘 못 선택하셨습니다. 다시 선택해주세요 ");
								inputStop = false;
							}else if (cCoChoice <= cCoMenu.size()-2 || cCoChoice >= 1) {
								inputStop = true;
							}
						} catch (NumberFormatException e) {
							System.out.print("\n  # 잘 못 선택하셨습니다. 다시 선택해주세요 ");
							inputStop = false;
						}
					} while (inputStop == false);
					inputStop = false;
					switch(cCoChoice) {
					case 1: 
 /* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■  계정 관리  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
						System.out.print("\n ㅡㅡㅡ 계정 관리 SQL ㅡㅡㅡ");
						System.out.print("\n 1. 계정 생성 SQL" );
						System.out.print("\n 2. 계정 삭제 SQL" );
						System.out.print("\n 3. 이전메뉴로" );
						System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" );
						do {
							try {
								System.out.print("\n  메뉴 선택 >>  ");
								cInChoice = Integer.parseInt(sc.nextLine());
								System.out.println();
								if (cInChoice > 3 || cInChoice < 1) {
									System.out.print("\n  # 잘 못 선택하셨습니다. 다시 선택해주세요 ");
									inputStop = false;
								}else if (cInChoice <= 3 || cInChoice >= 1) {
									inputStop = true;
								} 
							} catch (NumberFormatException e) {
								System.out.print("\n  # 잘 못 선택하셨습니다. 다시 선택해주세요 ");
								inputStop = false;
							}
						} while (inputStop == false);
						switch(cInChoice) {
						case 1:
							action = new CodingCreateUserAction(inMember);
							break;
						case 2:
							action = new CodingDropUserAction(inMember);
							break;
						case 3:
							System.out.print("\n  # 이전 페이지로 돌아갑니다. ");
							action = null;
							break;
						}
						break;
					case 2:
 /* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
						System.out.print("\n ㅡㅡㅡ 권한 관리 SQL ㅡㅡㅡ");
						System.out.print("\n 1. 권한 부여 SQL" );
						System.out.print("\n 2. 권한 회수 SQL" );
						System.out.print("\n 3. 이전메뉴로" );
						System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" );
						do {
							try {
								System.out.print("\n  메뉴 선택 >>  ");
								cInChoice = Integer.parseInt(sc.nextLine());
								System.out.println();
								if (cInChoice > 3 || cInChoice < 1) {
									System.out.print("\n  # 잘 못 선택하셨습니다. 다시 선택해주세요 ");
									inputStop = false;
								}else if (cInChoice <= 3 || cInChoice >= 1) {
									inputStop = true;
								}
							} catch (NumberFormatException e) {
								System.out.print("\n  # 잘 못 선택하셨습니다. 다시 선택해주세요 ");
								inputStop = false;
							}
						} while (inputStop == false);
						switch(cInChoice) {
						case 1:
							action = new CodingGrantAction(inMember);
							break;
						case 2:
							action = new CodingRevorkAction(inMember);
							break;
						case 3:
							System.out.print("\n  # 이전 페이지로 돌아갑니다. ");
							action = null;
							break;
						}
						break;
						
/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■*/
					case 3:
						co.goBack();
						cStop = true;
						break;
					/*case 4:
						action = new CoCreateAction();
						break;
					case 5:
						action = new CoAlterAction();
						break;
					case 6:
						action = new CoDropAction();
						break;
					case 7:
						action = new CoInsertAction();
						break;
					case 8:
						action = new CoSelectAction();
						break;
					case 9:
						action = new CoUpdateAction();
						break;
					case 10:
						action = new CoDeleteAction();
						break;*/
					}
					break;
			case 2: 
/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■  sql문 조회  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ */
				action = new CustomerCodingListShowAction(inMember);
				break;
			case 3: 
				action = new CustomerInformationModifyAction(inMember);
				break;
			case 4:
				action = new LogoutAction(inMember);
				cStop = true;
				break;
			case 5:
				action = new CustomerWithdrawAction(inMember);			
			}
			if(action != null) {
				fc.request(action, sc);
			}else {
				action = null;
			}				
		}while(cStop == false);

	}
}
