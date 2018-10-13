package book.member.action;

import java.util.ArrayList;
import java.util.Scanner;

import book.member.dto.Book;
import book.member.svc.MoneyModifyService;
import book.member.util.ConsoleUtils;

public class MoneyModifyAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		// TODO Auto-generated method stub
		//Book oldbook=null;	//수정할 책 변경
		ArrayList<Book> list =null;
		ConsoleUtils cu =new ConsoleUtils();
		String name=cu.getName("할인율을 입력", sc);
		
		MoneyModifyService moneymodifyservice = new MoneyModifyService();
		list = moneymodifyservice.getBooklist(name);

		
		if(list == null){
			cu.showBookFail(name);
		}
		cu.show(list);
		Book updateBook = cu.buyChoice("할인을",sc, list);
		
		updateBook = cu.getUpdateBook(updateBook, sc);

		boolean isUpdate = MoneyModifyService.update(name,updateBook);
		
		if(isUpdate){
			cu.showUpdateSuccess();
		}else{
			cu.showUpdateFail();
		}
	}

}
