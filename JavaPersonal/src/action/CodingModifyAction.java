package action;

import java.util.Scanner;

import consol.Consol;
import model.Member;
import model.Query;
import service.CustomerCodingModifyService;

public class CodingModifyAction implements Action {
	Member inMember;
	Query choicedQuery;

	public CodingModifyAction() {
	}

	public CodingModifyAction(Member inMember, Query choicedQuery) {
		this.choicedQuery = choicedQuery;
		this.inMember = inMember;
	}

	@Override
	public void run(Scanner sc) throws Exception {
		Consol co = new Consol(inMember);
		CustomerCodingModifyService ser = new CustomerCodingModifyService();
		String keyWord = "";
		keyWord = choicedQuery.getKeyWord();
		Query afterQuery = null;
		boolean result = false;
		boolean stop = false;
		int fchoice = 0;
		int schoice = 0;
		String userName = null;
		String passWord = null;
		String query = null;
		String structure = null;
		String explain = null;
		String authority = null;
		String target = null;
		String day = null;
		structure = choicedQuery.getStructure();
		explain = choicedQuery.getExplain();
		day = choicedQuery.getDay();

		
		switch (keyWord) {
		case "CREATE USER":
			co.coModify(choicedQuery);
			userName = co.coUserName(sc);
			passWord = co.coPassWord(sc);
			query = keyWord + " " + userName + " IDENTIFIED BY " + passWord + ";";
			
			break;
		case "DROP USER":
			co.coModify(choicedQuery);
			userName = co.coUserName(sc);
			query = keyWord + " " + userName + " CASCADE; ";

			break;
		case "GRANT":
			co.coModify(choicedQuery);
			fchoice = co.yesOrno("DataBase 전체에 대한 권한을 입력하시겠습니까?", sc);
			userName = co.coUserName(sc);
			if (userName == null) {
				schoice = co.yesOrno("UserName을 입력하지 않으시면 SQL문 작성이 불가능합니다. \n      취소하시겠습니까?", sc);
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
							query = keyWord + " ON " + target + " TO " + userName + " WITH GRANT OPTION " + ";";
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
						query = keyWord + " ON " + target + " TO " + userName + " WITH GRANT OPTION " + ";";
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
					schoice = co.yesOrno("UserName을 입력하지 않으시면 SQL문 작성이 불가능합니다. \n      취소하시겠습니까?", sc);
					if (schoice == 1) {
						co.goBack();
						stop = true;
					} else {
						fchoice = co.yesOrno("DataBase 전체에 대한 권한을 선택하시겠습니까?", sc);
						if (fchoice == 1) {
							authority = co.coAutorityAll(sc);
							query = keyWord +" "+ authority +" FROM " + userName + ";";
							stop = true;
						} else {
							authority = co.coAutorityTarget(sc);
							target = co.coTarget(sc, "권한을 부여하고자 하는");
							query = keyWord +" "+ authority +" ON " + target + " FROM " + userName + ";";
							stop = true;
						}
					}
				} else {
					stop = true;
					fchoice = co.yesOrno("DataBase 전체에 대한 권한을 선택하시겠습니까?", sc);
					if (fchoice == 1) {
						authority = co.coAutorityAll(sc);
						query = keyWord +" "+ authority +" FROM " + userName + ";";
						stop = true;
					} else {
						authority = co.coAutorityTarget(sc);
						target = co.coTarget(sc, "권한을 부여하고자 하는");
						query = keyWord +" "+ authority +" ON " + target + " FROM " + userName + ";";
						stop = true;
					}
				}
			}while(stop==false);
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

	}

}
