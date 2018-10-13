package book.member.action;

import java.util.ArrayList;
import java.util.Scanner;

import book.member.dto.Book;
import book.member.svc.TotalMoneyService;
import book.member.util.ConsoleUtils;

public class TotalMoneyAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		// TODO Auto-generated method stub
		TotalMoneyService totalservice =new TotalMoneyService();
		
		ArrayList<Book> list =totalservice.allMoney();//DB의 모든 정보를 가졍와서 arrylist에 저장
		
		int num = (int)91.1/10;
		
		ConsoleUtils cu=new ConsoleUtils();//출력 class 
		
		if(list !=null) {//list가 null 이면 db 데이터가 없거나 실패 했을 경우 입니다.
			cu.showtotalmoneySuccess(list);// list에 저장된 데이터를 출력 
		}else {
			cu.showtotalmoneyFail();
		}
	}

}
