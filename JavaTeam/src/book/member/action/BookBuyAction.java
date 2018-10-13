package book.member.action;

import java.util.ArrayList;
import java.util.Scanner;

import book.member.dto.Book;
import book.member.svc.BookBuyService;
import book.member.util.ConsoleUtils;

public class BookBuyAction implements Action { // ���� ���� action

	public void execute(Scanner sc) throws Exception {
		int choice = 0;
		Book book = null;
		Book bookResult = null;
		ConsoleUtils con = new ConsoleUtils();
		BookBuyService bbser = new BookBuyService(); // ���� ���� service ����
		ArrayList<Book> list = new ArrayList<Book>();
		ArrayList<Book> buyList = new ArrayList<Book>();

		do {
			String name = con.getName("����", sc);// �ܼ��� ���� �޴� ��� + ���� ���� �˻� = ���� �˻��� ���� ���� ���̱� ������ ������ ����ǵ��� ����
			list = bbser.getBook(name); // �Է¹��� å ������ service�� ����. > service�� DB���� �޾ƿ� book�� ����

			if (list.size()==0) { // å �̸����� å ������ �޾ƿ��� ���Ѵٸ�
				con.searchFail(name); // ���� �� ���
			} else { // å �̸��� ������ å�� �����Ѵٸ�
				con.show(list); // �ܼ� - å ���� ���
				//if(list.size()>1) {
					book = con.buyChoice("���Ÿ�", sc, list);				
				//} 
				bookResult = con.buy(sc, book); // �ܼ� - å ��ü�� �ַܼ� ���� å ���� �޼ҵ� ���� > collection���� ����
				if (bookResult == null) {
					if(buyList.size() == 0) {break;}
					else {choice = 2;}
				} else {
					buyList.add(bookResult);
					
					choice = con.buyContinue(sc);
				}
			}
		} while (choice == 1); // ��� ���Ÿ� ������ �� �ݺ�!

		if (choice == 2) {
			boolean isBuy = bbser.buyBook(buyList); // service�� list�� ���� > DB ���� �� ������ �Ϸ�Ǹ� true / �ƴϸ� false
			if (bookResult == null) {
				if(buyList.size() == 0) {}
				else {con.buySuccess("����", buyList);}
			} else if (isBuy == false) { // DB ���� ���� _ å ���� ����
				con.buyFail(); // �ܼ� - ���� ���� ���
			} else {
				con.buySuccess("����", buyList); // �ܼ� - ���� ���� ���
			}
		}
	}
}
