package action;

import java.util.ArrayList;
import java.util.Scanner;

import consol.Consol;
import model.Member;
import service.ManagerCustomerInformationShowService;

public class ManagerCustomerInformationShowAction implements Action {
	Member inMember;
	public ManagerCustomerInformationShowAction(Member inMember) {
		this.inMember = inMember;
	}
	public ManagerCustomerInformationShowAction() {}

	@Override
	public void run(Scanner sc) throws Exception {
		Consol co = new Consol(inMember);
		ManagerCustomerInformationShowService scSer = new ManagerCustomerInformationShowService();
		ArrayList<Member> list = new ArrayList<Member>();
		String key = "";
		String word = "";
		Member choicedMember = null;
		key = co.cSearch(sc);
		switch(key) {
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
		if(key.equals("exit")) {
		}else {
			list = scSer.mSearch(key, word);
			if(list.size() == 0) {
				co.csSearchFail(key, word);
			}else {
				co.title("회원 검색 결과");
				co.csSearchSuccess(list);
				choicedMember = co.cChoice("회원정보 조회", list, sc);
				co.showMember(choicedMember);
			}
		}
			
	}

}
