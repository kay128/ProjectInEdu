package action;

import java.util.Scanner;

import action.Action;
import consol.Consol;
import model.Member;
import model.Query;
import service.CustomerCoingLoadService;

public class CodingDropUserAction implements Action {
	Member inMember;
	
	public CodingDropUserAction() {}
	public CodingDropUserAction(Member inMember) {
		this.inMember = inMember;
	}

	@Override
	public void run(Scanner sc) throws Exception {
		Consol co = new Consol(inMember);
		co.title("계정 삭제 SQL");
		co.coWrite("계정 삭제 SQL", "UserName");
		String userName = co.coUserName(sc);
		String keyWord = null;
		String query = null;
		String structure = null;
		String explain = null;
		keyWord = "DROP USER";
		query = keyWord + " " + userName + " CASCADE; ";
		structure = "DROP USER (username) CASCADE;";
		explain = "DROP이란? "
				+ "\n          사용자, 테이블 등을 삭제할 때 사용 "
				+ "\n       DDL(Data Definition Language_자료 정의 언어) 중 하나"
				+ "\n    > CASCADE란? "
				+ "\n           해당 사용자, 변수 등을 참조하는 대상이 있다면, 함께 삭제할 때 사용 "
				+ "\n          사용하지 않을 경우, 다른 테이블의 무결성 제약조건에 의해 삭제가 되지 않을 수 있다.";
		
		Query makedQuery = new Query(inMember, keyWord, query, structure, explain);
		
		CustomerCoingLoadService coacService = new CustomerCoingLoadService();
		boolean result = coacService.setQuery(makedQuery);
		
		if(result == false) {
			co.codingFail();
		}else if(result == true) {
			co.codingSuccess();
		}
	}

}
