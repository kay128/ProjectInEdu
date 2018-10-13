package action;

import java.util.ArrayList;
import java.util.Scanner;

import consol.Consol;
import model.Member;
import model.Query;
import service.CodingDropService;
import service.CustomerCoingListShowService;
import service.ManagerCustomerInformationShowService;

public class ManagerSQLDeleteAction implements Action {
	Member inMember;

	public ManagerSQLDeleteAction() {
	}

	public ManagerSQLDeleteAction(Member inMember) {
		this.inMember = inMember;
	}

	@Override
	public void run(Scanner sc) throws Exception {

		Consol co = new Consol(inMember);
		ManagerCustomerInformationShowService scSer = new ManagerCustomerInformationShowService();
		ArrayList<Member> list = new ArrayList<Member>();
		Member customerMember = new Member();
		CodingDropService ser = new CodingDropService();

		String key = null;
		String word = null;
		String keyWord = null;
		int choice = 0;
		boolean result = false;

		key = co.cSearch(sc);

		switch (key) {
		case "id":
			word = co.idSInput(sc);
			break;
		case "name":
			word = co.nameSInput(sc);
			break;
		case "kind":
			word = co.kindSInput(sc);
			break;
		case "exit":
			co.goBack();
			break;
		}
		if (key.equals("exit")) {

		} else {
			list = scSer.mSearch(key, word);
			if (list.size() == 0) {
				co.csSearchFail(key, word);
			} else {
				co.title("회원 검색 결과");
				co.csSearchSuccess(list);

				customerMember = co.cChoice("SQL문 삭제", list, sc);
				if (customerMember == null) {
					co.goBack();
				} else {
					CustomerCoingListShowService listSer = new CustomerCoingListShowService();
					ArrayList<Query> sqlList = listSer.getList(customerMember);

					Query choicedQuery = null;
					int sChoice = 0;
					boolean stop = false;
					do {
						if (list.size() != 0) {
							co.title(customerMember.getName() + "님께서 공부했던 SQL문 목록");
							co.showList(sqlList);
							choicedQuery = co.choiceQuery(sqlList, "조회", sc);
							if (choicedQuery == null) {
								co.goBack();
									stop = true;
							} else {
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
								sChoice = co.yesOrno("다른 SQL문의 내용도 삭제하시겠습니까?", sc);
								if (sChoice == 1) {
									stop = false;
								} else {
									stop = true;
								}
							}
						} else {
							co.noList();
						}

					} while (stop == false);

				}
			}
		}

	

	}

}
