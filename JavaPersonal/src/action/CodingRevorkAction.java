package action;

import java.util.Scanner;

import consol.Consol;
import model.Member;
import model.Query;
import service.CustomerCoingLoadService;

public class CodingRevorkAction implements Action {
	Member inMember;
	
	public CodingRevorkAction() {}
	
	public CodingRevorkAction(Member inMember) {
		this.inMember = inMember;
	}
	public void run(Scanner sc) throws Exception {
		Consol co = new Consol(inMember);
		co.title("권한 회수 SQL");
		co.coWrite("권한 회수 SQL", "UserName");
		String userName = null;
		String keyWord = "REVOKE ";
		String query = null;
		String structure = null;
		String explain = null;
		String authority = null;
		int fchoice = 0;
		int schoice = 0;
		boolean stop = false;
		String target = null;
		
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
		
		if(query != null) {
			structure = "RVOKE (권한 명) ON (대상 명) FROM (UserName);";
			explain = "REVOKE란? "
					+ "\n          사용자에게 권한을 회수할 때 사용 "
					+ "\n       DDL(Data Definition Language_자료 정의 언어) 중 하나"
					+ "\n         사용자에게 부여되는 권한의 종류"
					+ "\n         시스템 권한: CREATE(USER, ANY TABLE, SESSION, TABLE, VIEW, PROCED USER, SEQUECE) / SELECT ANY TABLE / SYSDBA / SYSOPER"
					+ "\n         특정 대상에 대한 권한 : ALTER, DELETE, INSERT, UPDATE, INDEX, SELECT";
			
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

}
