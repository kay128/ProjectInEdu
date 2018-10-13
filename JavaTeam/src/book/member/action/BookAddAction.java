package book.member.action;

import java.util.Scanner;

import book.member.dto.Book;
import book.member.svc.BookAddService;
import book.member.util.ConsoleUtils;

public class BookAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		// TODO Auto-generated method stub
		//등록할 회원의 정보를 입력받아 객체화를 하는 작업을 수행한다
		ConsoleUtils cu=new ConsoleUtils();//회원 등록 하는 클래스
		Book newBook=cu.getNewBook(sc);//회원 등록
		Book insert =null;
		boolean isAddCheck= false;
		//객체를 서비스클래스에 전달하여 DB에 저장한느 작업을 수행한 후 결과를 받아서 처리한다.
		BookAddService addService =new BookAddService();
		insert=addService.serch(newBook.getName());
		if(insert==null) {
			 isAddCheck = addService.addBook(newBook);
			 if(isAddCheck){
				cu.showAddSuccess(newBook);//책등록 성공시 출력문
			}else{
				cu.showAddfail(newBook);//책등록 실패시 출력문
			}
		}else {
			cu.showAddfail(newBook.getName());
		}
		
	}

}
