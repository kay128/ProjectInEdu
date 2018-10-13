package book.member.action;


import java.util.ArrayList;
import java.util.Scanner;
import book.member.dto.Book;
import book.member.svc.BookEnterService;
import book.member.svc.BookSearchService;
import book.member.util.ConsoleUtils;

public class BookEnterAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtils cu = new ConsoleUtils();
		Book book = null;
		ArrayList<Book> list =null;
		
		
		BookSearchService searchservice = new BookSearchService();

		String name = cu.getName("�԰�", sc);// �ܼ��� ���� �޴� ��� + ���� ���� �˻� = ���� �˻��� ���� ���� ���̱� ������ ������ ����ǵ��� ����
		list = searchservice.getBook(name); // �Է¹��� å ������ service�� ����. > service�� DB���� �޾ƿ� book�� ����

		if (list.size()==0) { // å �̸����� å ������ �޾ƿ��� ���Ѵٸ�
			cu.searchFail(name); // ���� �� ���
		} else { // å �̸��� ������ å�� �����Ѵٸ�
			cu.show(list); // �ܼ� - å ���� ���
			
			book =cu.buyChoice("�԰�",sc, list);
			
			book =cu.getEnterBook(book, sc);
			
			BookEnterService enterservice=new BookEnterService();
			
			boolean isUpdate = enterservice.Enterbook(book);
			if(isUpdate) {
				cu.showEnterSuccess();
			}else {
				cu.showEnterFail();
			}

		}

	}
}