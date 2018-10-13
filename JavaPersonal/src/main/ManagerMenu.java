package main;

import java.util.ArrayList;
import java.util.Scanner;

import action.Action;
import action.LogoutAction;
import action.ManagerAutorityModifyAction;
import action.ManagerCustomerInformationDropAction;
import action.ManagerCustomerInformationModifyAction;
import action.ManagerCustomerInformationShowAction;
import action.ManagerSQLDeleteAction;
import action.ManagerSQLModifyAction;
import action.ManagerSQLShowAction;
import consol.Consol;
import frontcontroller.FrontController;
import model.Member;

public class ManagerMenu {
	private ArrayList<String> mMenu = new ArrayList<String>();
	private ArrayList<ArrayList> mmMenu = new ArrayList<ArrayList>();
	private ArrayList<String> msMenu = new ArrayList<String>();
	private Member inMember;

	public ManagerMenu() {
		mMenu.add("ㅡㅡ Manager Menu ㅡㅡ");
		mMenu.add("SQL문 관리");
		mMenu.add("회원관리");
		mMenu.add("로그아웃");
		mMenu.add("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

		ArrayList<String> dmMenu = new ArrayList<String>();
		dmMenu.add("ㅡㅡ SQL(written by Customer) Management ㅡㅡ");
		dmMenu.add("SQL문 조회");
		dmMenu.add("SQL문 수정");
		dmMenu.add("SQL문 삭제");
		dmMenu.add("이전메뉴로");
		dmMenu.add("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		mmMenu.add(dmMenu);

		ArrayList<String> cmMenu = new ArrayList<String>();
		cmMenu.add("ㅡㅡ Customer Management ㅡㅡ");
		cmMenu.add("회원정보조회");
		cmMenu.add("회원정보수정");
		cmMenu.add("회원권한수정");
		cmMenu.add("회원정보삭제");
		cmMenu.add("이전메뉴로");
		cmMenu.add("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		mmMenu.add(cmMenu);

		msMenu.add("ㅡㅡ Data Search ㅡㅡ");
		msMenu.add("종류별 목록");
		msMenu.add("명령어로 검색");
		msMenu.add("이전메뉴로");
		msMenu.add("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}

	public void mMenu(Scanner sc, Member inMember) {
		Consol co = new Consol();
		this.inMember = inMember;
		int mChoice = 0;
		int mmChoice = 0;

		FrontController fc = new FrontController();

		boolean mStop = false;
		boolean inputStop = false;
		boolean mmStop = false;

		Action action = null;

		do {
/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■  관리자 메뉴  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ */
			System.out.print("\n " + mMenu.get(0));
			for (int i = 1; i < mMenu.size() - 1; i++) {
				System.out.print("\n  " + (i) + ". " + mMenu.get(i) + " ");
			}
			System.out.print("\n " + mMenu.get(mMenu.size() - 1));
			do {
				try {
					System.out.print("\n  메뉴 선택 >>  ");
					mChoice = Integer.parseInt(sc.nextLine());
					System.out.println();
					if (mChoice > mMenu.size()-2 || mChoice < 1 ) {
						System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
						inputStop = false;
					}else if (mChoice <= mMenu.size()-2 || mChoice >= 1) {
						inputStop = true;
					}
				} catch (NumberFormatException e) {
					System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
					inputStop = false;
				}
			} while (inputStop == false);
			inputStop = false;
			
			
			if (mChoice == mMenu.size() - 2) {
				action = new LogoutAction(inMember);
				mStop = true;
				
				
			} else {
				
				
				do {
					for (int i = 0; i < mMenu.size(); i++) {
						if (mChoice == (i + 1)) {
							System.out.print("\n " + mmMenu.get(i).get(0));
							for (int k = 1; k < mmMenu.get(i).size() - 1; k++) {
								System.out.print("\n  " + (k) + ". " + mmMenu.get(i).get(k) + " ");
							}
							System.out.print("\n " + mmMenu.get(i).get(mmMenu.get(i).size() - 1));
							do {
								try {
									System.out.print("\n  메뉴 선택 >>  ");
									mmChoice = Integer.parseInt(sc.nextLine());
									if (mmChoice > mmMenu.get(i).size()-2 || mmChoice < 1) {
										System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
										inputStop = false;
									}else if (mmChoice <= mmMenu.get(i).size()-2 || mmChoice >= 1) {
										inputStop = true;
									} 
								} catch (NumberFormatException e) {
									System.out.print("\n > 잘 못 선택하셨습니다. 다시 선택해주세요 ");
									inputStop = false;
								}
							} while (inputStop == false);
							inputStop = false;
						
							if (mmChoice == mmMenu.get(i).size()-2) {
								co.goBack();
								mmStop = true;
							} else { 
									if (mChoice == 1) {
/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■  자료 관리  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ */

										
										switch (mmChoice) {
										case 1: 											
											action = new ManagerSQLShowAction(inMember);
											break;
										case 2: 
											action = new ManagerSQLModifyAction(inMember);
											break;
										case 3: 
											action = new ManagerSQLDeleteAction(inMember);
											break;
										case 4:
											System.out.print("\n  # 이전 페이지로 돌아갑니다. ");
											action = null;
											break;
										}
										
										
									} else if (mChoice == 2) {
/* ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■  회원 관리  ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ */
									
										switch (mmChoice) {
										case 1: 											
											action = new ManagerCustomerInformationShowAction(inMember);
											break;
										case 2: 
											action = new ManagerCustomerInformationModifyAction(inMember);
											break;
										case 3: 
											action = new ManagerAutorityModifyAction(inMember);
											break;
										case 4:
											action = new ManagerCustomerInformationDropAction(inMember);
											break;
										case 5:
											System.out.print("\n  # 이전 페이지로 돌아갑니다. ");
											action = null;
											break;
										}
										
									}
									if(action != null) {
										fc.request(action, sc, inMember);
									}
							}

						}
					}
				} while (mmStop == false);
			}
		} while (mStop == false);

	}

}