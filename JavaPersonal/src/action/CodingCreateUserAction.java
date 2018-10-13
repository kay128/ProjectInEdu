package action;

import java.util.Scanner;

import consol.Consol;
import model.Member;
import model.Query;
import service.CustomerCoingLoadService;

public class CodingCreateUserAction implements Action {
	Member inMember;

	public CodingCreateUserAction() {
	}

	public CodingCreateUserAction(Member inMember) {
		this.inMember = inMember;
	}

	@Override
	public void run(Scanner sc) throws Exception {
		Consol co = new Consol(inMember);
		int choice = 0;
		boolean stop = false;
		co.title("계정 생성 SQL");
		co.coWrite("계정 생성 SQL", "UserName", "PassWord");
		String userName = "";
		String passWord = "";
		do {
			userName = co.coUserName(sc);
			if (userName == null) {
				choice = co.yesOrno("UserName을 입력하지 않으시면 SQL문 작성이 불가능합니다. \n      취소하시겠습니까?", sc);
				if (choice == 1) {
					co.goBack();
					stop = true;
				} else if(choice == 2){
					stop = false;
				}
			}else {stop = true;}
		}while (stop == false);

		stop = false;
		do {
			passWord = co.coPassWord(sc);
			if (passWord == null) {
				choice = co.yesOrno("PassWord를 입력하지 않으시면 SQL문 작성이 불가능합니다. \n      취소하시겠습니까?", sc);
				if (choice == 1) {
					co.goBack();
					stop = true;
				} else {
					stop = false;
				}
			} else {
				stop = true;
			}
		} while (stop == false);
		if (userName != null && passWord != null) {
			String keyWord = "CREATE USER";
			String query = keyWord + " " + userName + " IDENTIFIED BY " + passWord + ";";
			String structure = "CREATE USER (username) IDENTIFIED BY (password);";
			String explain = "CREATE란? " + "\n        사용자, 테이블 등을 생성할 때 사용 "
					+ "\n      DDL(Data Definition Language_자료 정의 언어) 중 하나";

			Query makedQuery = new Query(inMember, keyWord, query, structure, explain);

			CustomerCoingLoadService coacService = new CustomerCoingLoadService();
			boolean result = coacService.setQuery(makedQuery);

			if (result == false) {
				co.codingFail();
			} else if (result == true) {
				co.codingSuccess();
			}
		}

	}
}
