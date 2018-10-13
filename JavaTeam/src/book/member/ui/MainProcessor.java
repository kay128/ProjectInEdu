package book.member.ui;

import java.util.Scanner;

import book.member.action.Action;
import book.member.action.BookAddAction;
import book.member.action.BookBuyAction;
import book.member.action.BookEnterAction;
import book.member.action.BookRecommendAction;
import book.member.action.BookRefundAction;
import book.member.action.BookRemoveAction;
import book.member.action.BookSaleAction;
import book.member.action.BookSearchAction;
import book.member.action.MoneyModifyAction;
import book.member.action.TotalMoneyAction;
import book.member.controller.FrontController;

public class MainProcessor {

	public static void admin_memu(Scanner sc) {
		boolean isStop = false;
		do {
			Action action=null;
			int menu = 0;
			boolean inStop = false;
			FrontController fc=new FrontController();//프로그램의 전체 흐름을 관리 하는 클래스
			
			System.out.println("== 관리자 모드 ==");
			System.out.println("  1. 도서등록");
			System.out.println("  2. 도서삭제");
			System.out.println("  3. 입고");
			System.out.println("  4. 금액수정[할인 도서 설정]");
			System.out.println("  5. 총매출");
			System.out.println("  6. 관리자 모드 종료");
			System.out.println("==============");
			do {
				System.out.print("선택 >> ");
				try {
					menu = Integer.parseInt(sc.nextLine());
					if (menu < 1 || menu > 6) {
						System.out.println("잘 못 입력하셨습니다.");
						System.out.println("다시 입력해주세요.");
						inStop = true;
					} else {
						inStop = false;
					}
				} catch (NumberFormatException e) {
					System.out.println("잘 못 입력하셨습니다.");
					System.out.println("다시 입력해주세요.");
					inStop = true;
				}
			} while (inStop);
			
			
			
		
			switch(menu) {
				case 1:
					System.out.println();
					action=new BookAddAction();//도서등록-김현승
					break;
				case 2:
					System.out.println();
					action=new BookRemoveAction();//도서삭제-이승환
					break;
				case 3:
					System.out.println();
					action=new BookEnterAction();//입고-김종호
					break;
				case 4:
					System.out.println();
					action=new MoneyModifyAction();//금액수정-김현승
					break;
				case 5:
					System.out.println();
					action=new TotalMoneyAction();//총매출-채형섭
					break;
				case 6:
					System.out.println();
					System.out.println("관리자 프로그램을 종료 합니다.");
					isStop=true;
					break;
				default:
					System.out.println();
					System.out.println("선택이 올바르지 않습니다.");
			}//switch end
			if(action != null) {
				fc.processRequest(action, sc);
			}
			
		}while(!isStop);
		
		
	}

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);// 입력
		int c_menu = 0;
		boolean cStop = false;
		FrontController fc=new FrontController();//프로그램의 전체 흐름을 관리 하는 클래스
		
		while(true) {
			System.out.println("== 도서구매 프로그램 ==");
			System.out.println("  1. 도서검색");
			System.out.println("  2. 추천도서");
			System.out.println("  3. 할인도서");
			System.out.println("  4. 도서구매");
			System.out.println("  5. 도서환불");
			System.out.println("  6. 프로그램종료");
			System.out.println("===================");
			do {
				System.out.print("선택 >> ");
				try {
					c_menu = Integer.parseInt(sc.nextLine());
					if (c_menu < 0 || c_menu > 6) {
						System.out.println("잘 못 입력하셨습니다.");
						System.out.println("다시 입력해주세요.");
						cStop = true;
					} else {
						cStop = false;
					}
				} catch (NumberFormatException e) {
					System.out.println("잘 못 입력하셨습니다.");
					System.out.println("다시 입력해주세요.");
					cStop = true;
				}
			} while (cStop);
			
			Action action=null;
			switch(c_menu) {
				case 0:
					int pwd =Integer.parseInt(sc.nextLine());
					if(pwd==1234) {
						admin_memu(sc);//관리자 모드 
					}
					System.out.println();
					break;
				case 1:
					System.out.println();
					action=new BookSearchAction();//도서검색-김종호  가능
					break;
				case 2:
					System.out.println();
					action=new BookRecommendAction();//추천도서-채형섭 가능
					break;
				case 3:
					System.out.println();
					action=new BookSaleAction();//할인도서-김아영  가능
					break;
				case 4:
					System.out.println();
					action=new BookBuyAction();//도서구매-김아영  가능
					break;
				case 5:
					System.out.println();
					action=new BookRefundAction();//도서환불-이승환 가능
					break;
				case 6:
					System.out.println();
					System.out.println("프로그램을 종료 합니다.");
					System.exit(0);
				default:
					System.out.println();
					System.out.println("선택이 올바르지 않습니다.");
			}//switch end
			if(action != null) {
				fc.processRequest(action, sc);
			}
		}

	}

}
