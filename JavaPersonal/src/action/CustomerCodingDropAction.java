package action;

import java.util.Scanner;

import consol.Consol;
import model.Member;
import model.Query;
import service.CodingDropService;

public class CustomerCodingDropAction implements Action {
	Member inMember;
	Query choicedQuery;
	
	public CustomerCodingDropAction() {}
	
	public CustomerCodingDropAction(Member inMember, Query choicedQuery) {
		this.choicedQuery = choicedQuery;
		this.inMember = inMember;
	}

	@Override
	public void run(Scanner sc) throws Exception {
		Consol co = new Consol(inMember);
		String keyWord = choicedQuery.getKeyWord();
		CodingDropService ser = new CodingDropService();
		boolean result = false;
		int choice = 0;
		
		
		keyWord = choicedQuery.getKeyWord();
		co.coSpecific(choicedQuery);
		choice = co.yesOrno(keyWord + " 문을 삭제하시겠습니까?", sc);
		if (choice == 1) {
			result = ser.coDrop(choicedQuery);
			if (result == false) {
				co.coDropFail(keyWord, "삭제");
			} else if (result == true) {
				co.coDropSuccess(keyWord, "삭제");
			}
		}else {}
	}

}
