package book.member.action;

import java.util.ArrayList;
import java.util.Scanner;

import book.member.dto.Book;
import book.member.svc.BookBuyService;
import book.member.svc.BookSaleService;
import book.member.util.ConsoleUtils;

public class BookSaleAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		// TODO Auto-generated method stub
		BookSaleService bsser = new BookSaleService();
		ArrayList<Book> list = bsser.saleBook();
		ArrayList<Book> buy_list = new ArrayList<Book>();
		
		ConsoleUtils con = new ConsoleUtils();
		if(list != null) {
			//con.sale(list,sc);
			Book book=con.showlistSuccess(list, sc, "«“¿Œ");
			
			if(book!=null){
				buy_list.add(book);
				BookBuyService buy_ser=new BookBuyService();
				buy_ser.buyBook(buy_list);
			}
			
		}else {
			con.saleFail();
		}
	}

}
