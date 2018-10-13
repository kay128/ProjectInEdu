package main;

import java.util.Scanner;

import action.Action;
import action.IdentifiedAction;
import action.JoinAction;
import action.LoginAction;
import frontcontroller.FrontController;
import model.Member;

public class Main {
	public static Member member = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		boolean stop = false;
		FrontController fc = new FrontController();
		boolean mStop = false;
		Action action = null;

		do{ 
			System.out.print("\n [ CoCo Program ] ");
			System.out.print("\n ㅡㅡㅡㅡ LogIn ㅡㅡㅡㅡ");
			System.out.print("\n  1. 로그인");
			System.out.print("\n  2. 회원가입");
			System.out.print("\n  3. Id / Password 찾기");
			System.out.print("\n  4. 프로그램 종료");
			System.out.print("\n ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			do {
				try{
					System.out.print("\n  메뉴 선택 >>  ");
					menu = Integer.parseInt(sc.nextLine());
					if(menu>4||menu<1){
						System.out.print("\n  # 잘 못 선택하셨습니다. 다시 선택해주세요 ");
						mStop = false;
					}else if(menu<=4||menu>=1) {
						mStop = true;
						}
				}catch(NumberFormatException e) {
					System.out.print("\n  # 잘 못 선택하셨습니다. 다시 선택해주세요 ");
					mStop = false;
				}
			 }while(mStop==false);
			
			switch(menu) {
			case 1:
				action = new LoginAction();
				break;
			case 2:
				action = new JoinAction();
				break;
			case 3:
				action = new IdentifiedAction();
				break;
			case 4:
				System.out.print("\n [ CoCo Program 종료 ] ");
				action = null;
				stop = true;
			}
			if(action != null) {
				fc.request(action, sc);
			}
		}while(stop == false);

	}

}
