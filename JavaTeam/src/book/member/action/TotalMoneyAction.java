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
		
		ArrayList<Book> list =totalservice.allMoney();//DB�� ��� ������ �����ͼ� arrylist�� ����
		
		int num = (int)91.1/10;
		
		ConsoleUtils cu=new ConsoleUtils();//��� class 
		
		if(list !=null) {//list�� null �̸� db �����Ͱ� ���ų� ���� ���� ��� �Դϴ�.
			cu.showtotalmoneySuccess(list);// list�� ����� �����͸� ��� 
		}else {
			cu.showtotalmoneyFail();
		}
	}

}
