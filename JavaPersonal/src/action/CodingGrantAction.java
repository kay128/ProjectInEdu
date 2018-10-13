package action;

import java.util.Scanner;

import consol.Consol;
import model.Member;
import model.Query;
import service.CustomerCoingLoadService;

public class CodingGrantAction implements Action {
	Member inMember;

	public CodingGrantAction() {
	}

	public CodingGrantAction(Member inMember) {
		this.inMember = inMember;
	}

	public void run(Scanner sc) throws Exception {
		Consol co = new Consol(inMember);
		co.title("권한 부여 SQL");
		co.coWrite("권한 부여 SQL", "권한 명", "대상 객체", "UserName", "Option");
		int choice = 0;
		String authority = null;
		String target = null;
		String userName = null;
		boolean stop = false;
		String query = null;
		String keyWord = "GRANT";
		do {
			choice = co.yesOrno("DataBase 전체에 대한 권한을 입력하시겠습니까?", sc);
			userName = co.coUserName(sc);
			if (userName == null) {
				choice = co.yesOrno("UserName을 입력하지 않으시면 SQL문 작성이 불가능합니다. \n      취소하시겠습니까?", sc);
				if (choice == 1) {
					co.goBack();
					stop = true;
				} else {
					int option = co.yesOrno("해당 사용자가 다른 사용자에게 권한을 부여할 수 있게 하시겠습니까?", sc);
					if (choice == 1) {
						authority = co.coAutorityAll(sc);
						if (option == 1) {
							query = keyWord +" "+ authority +" TO " + userName + " WITH GRANT OPTION " + ";";
						} else if (option == 2) {
							query = keyWord +" "+ authority + " TO " + userName + ";";

						}
					} else {
						authority = co.coAutorityTarget(sc);
						target = co.coTarget(sc, "권한을 부여하고자 하는");

						if (option == 1) {
							query = keyWord +" "+ authority +" ON " + target + " TO " + userName + " WITH GRANT OPTION " + ";";
						} else if (option == 2) {
							query = keyWord +" "+ authority +" ON " + target + " TO " + userName + ";";
						}
					}
				}
			} else {
				stop = true;
				int option = co.yesOrno("해당 사용자가 다른 사용자에게 권한을 부여할 수 있게 하시겠습니까?", sc);
				if (choice == 1) {
					authority = co.coAutorityAll(sc);
					if (option == 1) {
						query = keyWord +" "+ authority +" TO " + userName + " WITH GRANT OPTION " + ";";
					} else if (option == 2) {
						query = keyWord +" "+ authority + " TO " + userName + ";";

					}
				} else {
					authority = co.coAutorityTarget(sc);
					target = co.coTarget(sc, "권한을 부여하고자 하는");

					if (option == 1) {
						query = keyWord +" "+ authority +" ON " + target + " TO " + userName + " WITH GRANT OPTION " + ";";
					} else if (option == 2) {
						query = keyWord +" "+ authority +" ON " + target + " TO " + userName + ";";
					}
				}
			}
			String structure = "GRANT (권한 명) ON (대상 명) TO (UserName) WITH GRANT OPTION";
			String explain = "GRANT란? " + "\n        사용자에게 권한을 부여할 때 사용"
					+ "\n         DDL(Data Definition Language_자료 정의 언어) 중 하나" + "\n   > 권한 명이란?"
					+ "\n         사용자에게 부여되는 권한의 종류"
					+ "\n         시스템 권한: CREATE(USER, ANY TABLE, SESSION, TABLE, VIEW, PROCED USER, SEQUECE) / SELECT ANY TABLE / SYSDBA / SYSOPER"
					+ "\n         특정 대상에 대한 권한 : ALTER, DELETE, INSERT, UPDATE, INDEX, SELECT" + "\n   > Option이란?"
					+ "\n          'WITH GRANT OPTION'을 입력할 경우 다른 사용자에게 권한을 부여할 수 있는 권한을 가지게 된다.";

			Query makedQuery = new Query(inMember, keyWord, query, structure, explain);

			CustomerCoingLoadService coacService = new CustomerCoingLoadService();
			boolean result = coacService.setQuery(makedQuery);
			stop = true;
			if (result == false) {
				co.codingFail();
			} else if (result == true) {
				co.codingSuccess();
			}
		} while (stop == false);
	}
}
