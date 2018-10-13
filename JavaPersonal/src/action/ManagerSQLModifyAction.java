package action;

import java.util.ArrayList;
import java.util.Scanner;

import consol.Consol;
import model.Member;
import model.Query;
import service.CustomerCodingModifyService;
import service.CustomerCoingListShowService;
import service.ManagerCustomerInformationShowService;

public class ManagerSQLModifyAction implements Action {
	Member inMember;

	public ManagerSQLModifyAction() {
	}

	public ManagerSQLModifyAction(Member inMember) {
		this.inMember = inMember;
	}

	@Override
	public void run(Scanner sc) throws Exception {

		Consol co = new Consol(inMember);
		ManagerCustomerInformationShowService scSer = new ManagerCustomerInformationShowService();
		CustomerCodingModifyService ser = new CustomerCodingModifyService();
		ArrayList<Member> list = new ArrayList<Member>();
		Member customerMember = null;

		String keyWord = "";

		Query afterQuery = null;
		boolean result = false;

		String key = null;
		String word = null;

		boolean stop = false;
		int fchoice = 0;
		int schoice = 0;
		int tchoice = 0;
		String userName = null;
		String passWord = null;
		String query = null;
		String structure = null;
		String explain = null;
		String authority = null;
		String target = null;
		Query choicedQuery = null;
		String day = null;

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

				customerMember = co.cChoice("SQL문 수정", list, sc);
				if (customerMember == null) {
					co.goBack();
				} else {
					CustomerCoingListShowService listSer = new CustomerCoingListShowService();
					ArrayList<Query> sqlList = listSer.getList(customerMember);

					do {
						if (list.size() != 0) {
							co.title(customerMember.getName() + "님께서 공부했던 SQL문 목록");
							co.showList(sqlList);
							choicedQuery = co.choiceQuery(sqlList, "수정", sc);
							if (choicedQuery == null) {
								co.goBack();
								stop = true;
							} else {
								keyWord = choicedQuery.getKeyWord();
								day = choicedQuery.getDay();
								switch (keyWord) {
								case "CREATE USER":
									co.coModify(choicedQuery);
									userName = co.coUserName(sc);
									passWord = co.coPassWord(sc);
									query = keyWord + " " + userName + " IDENTIFIED BY " + passWord + ";";
									structure = choicedQuery.getStructure();
									explain = choicedQuery.getExplain();
									break;
								case "DROP USER":
									co.coModify(choicedQuery);
									userName = co.coUserName(sc);
									query = keyWord + " " + userName + " CASCADE; ";
									structure = choicedQuery.getStructure();
									explain = choicedQuery.getExplain();
									break;
								case "GRANT":
									co.coModify(choicedQuery);
									fchoice = co.yesOrno("DataBase 전체에 대한 권한을 입력하시겠습니까?", sc);
									userName = co.coUserName(sc);
									if (userName == null) {
										schoice = co.yesOrno("UserName을 입력하지 않으시면 SQL문 작성이 불가능합니다. \n      취소하시겠습니까?",
												sc);
										if (schoice == 1) {
											co.goBack();
											query = null;
											stop = true;
										} else {
											int option = co.yesOrno("해당 사용자가 다른 사용자에게 권한을 부여할 수 있게 하시겠습니까?", sc);
											if (fchoice == 1) {
												authority = co.coAutorityAll(sc);
												if (option == 1) {
													query = keyWord + " TO " + userName + " WITH GRANT OPTION " + ";";
												} else if (option == 2) {
													query = keyWord + " TO " + userName + ";";

												}
											} else {
												authority = co.coAutorityTarget(sc);
												target = co.coTarget(sc, "권한을 부여하고자 하는");

												if (option == 1) {
													query = keyWord + " ON " + target + " TO " + userName
															+ " WITH GRANT OPTION " + ";";
												} else if (option == 2) {
													query = keyWord + " ON " + target + " TO " + userName + ";";
												}
											}
										}
									} else {
										stop = true;
										int option = co.yesOrno("해당 사용자가 다른 사용자에게 권한을 부여할 수 있게 하시겠습니까?", sc);
										if (fchoice == 1) {
											authority = co.coAutorityAll(sc);
											if (option == 1) {
												query = keyWord + " TO " + userName + " WITH GRANT OPTION " + ";";
											} else if (option == 2) {
												query = keyWord + " TO " + userName + ";";

											}
										} else {
											authority = co.coAutorityTarget(sc);
											target = co.coTarget(sc, "권한을 부여하고자 하는");

											if (option == 1) {
												query = keyWord + " ON " + target + " TO " + userName
														+ " WITH GRANT OPTION " + ";";
											} else if (option == 2) {
												query = keyWord + " ON " + target + " TO " + userName + ";";
											}
										}
									}
									break;
								case "REVOKE":
									co.coModify(choicedQuery);
									do {
										userName = co.coUserName(sc);
										if (userName == null) {
											schoice = co.yesOrno(
													"UserName을 입력하지 않으시면 SQL문 작성이 불가능합니다. \n      취소하시겠습니까?", sc);
											if (schoice == 1) {
												co.goBack();
												stop = true;
											} else {
												fchoice = co.yesOrno("DataBase 전체에 대한 권한을 선택하시겠습니까?", sc);
												if (fchoice == 1) {
													authority = co.coAutorityAll(sc);
													query = keyWord + " " + authority + " FROM " + userName + ";";
													stop = true;
												} else {
													authority = co.coAutorityTarget(sc);
													target = co.coTarget(sc, "권한을 부여하고자 하는");
													query = keyWord + " " + authority + " ON " + target + " FROM "
															+ userName + ";";
													stop = true;
												}
											}
										} else {
											stop = true;
											fchoice = co.yesOrno("DataBase 전체에 대한 권한을 선택하시겠습니까?", sc);
											if (fchoice == 1) {
												authority = co.coAutorityAll(sc);
												query = keyWord + " " + authority + " FROM " + userName + ";";
												stop = true;
											} else {
												authority = co.coAutorityTarget(sc);
												target = co.coTarget(sc, "권한을 부여하고자 하는");
												query = keyWord + " " + authority + " ON " + target + " FROM "
														+ userName + ";";
												stop = true;
											}
										}
									} while (stop == false);
									break;
								}
								if (query != null) {
									afterQuery = new Query(inMember, day, keyWord, query, structure, explain);
									schoice = co.yesOrno("해당 내용으로 수정하시겠습니까?", sc);
									if (schoice == 1) {
										result = ser.modifyCoding(afterQuery);
										if (result == true) {
											co.codingModifySuccess(afterQuery);
										} else if (result == false) {
											co.codingModifyFail();
										}
									} else {
									}
								}
								tchoice = co.yesOrno("다른 SQL문의 내용도 수정하시겠습니까?", sc);
								if (tchoice == 1) {
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
