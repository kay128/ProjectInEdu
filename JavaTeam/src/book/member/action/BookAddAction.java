package book.member.action;

import java.util.Scanner;

import book.member.dto.Book;
import book.member.svc.BookAddService;
import book.member.util.ConsoleUtils;

public class BookAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		// TODO Auto-generated method stub
		//����� ȸ���� ������ �Է¹޾� ��üȭ�� �ϴ� �۾��� �����Ѵ�
		ConsoleUtils cu=new ConsoleUtils();//ȸ�� ��� �ϴ� Ŭ����
		Book newBook=cu.getNewBook(sc);//ȸ�� ���
		Book insert =null;
		boolean isAddCheck= false;
		//��ü�� ����Ŭ������ �����Ͽ� DB�� �����Ѵ� �۾��� ������ �� ����� �޾Ƽ� ó���Ѵ�.
		BookAddService addService =new BookAddService();
		insert=addService.serch(newBook.getName());
		if(insert==null) {
			 isAddCheck = addService.addBook(newBook);
			 if(isAddCheck){
				cu.showAddSuccess(newBook);//å��� ������ ��¹�
			}else{
				cu.showAddfail(newBook);//å��� ���н� ��¹�
			}
		}else {
			cu.showAddfail(newBook.getName());
		}
		
	}

}
