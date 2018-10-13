package action;

import java.util.ArrayList;
import java.util.Scanner;

import consol.Consol;
import model.Member;
import service.ManagerCustomerInformationDropService;
import service.ManagerCustomerInformationShowService;

public class ManagerCustomerInformationDropAction implements Action {
	Member inMember;

	public ManagerCustomerInformationDropAction() {
	}

	public ManagerCustomerInformationDropAction(Member inMember) {
		this.inMember = inMember;
	}

	public void run(Scanner sc) throws Exception {
		Consol co = new Consol(inMember);
		ManagerCustomerInformationShowService scSer = new ManagerCustomerInformationShowService();
		ArrayList<Member> list = new ArrayList<Member>();
		ManagerCustomerInformationDropService cdSer = new ManagerCustomerInformationDropService();
		Member modifyMember = new Member();
		boolean pwCheck = false;
		boolean result = false;
		int last = 0;

		String key = null;
		String word = null;

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
				modifyMember = co.cChoice("회원정보 삭제", list, sc);
				if (modifyMember == null) {
					co.goBack();
				} else {
					pwCheck = co.passCheck(inMember, sc, "회원정보 삭제");
					if (pwCheck) {
						last = co.yesOrno(modifyMember.getId() + "님을 정말로 삭제하시겠습니까?", sc);
						if (last == 1) {
							result = cdSer.cDrop(modifyMember);
							if (result == false) {
								co.dropFail(modifyMember, "회원정보 삭제");
							} else if (result == true) {
								co.dropSuccess(modifyMember, "회원정보 삭제");
							}
						} else {
							co.pwCheckFail();
						}
					} else {
						co.goBack();
					}

				}

			}
		}

	}

}
