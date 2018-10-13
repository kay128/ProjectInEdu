package action;

import java.util.ArrayList;
import java.util.Scanner;

import consol.Consol;
import model.Member;
import service.ManagerAutorityModifyService;
import service.ManagerCustomerInformationShowService;

public class ManagerAutorityModifyAction implements Action {
	Member inMember;

	public ManagerAutorityModifyAction() {
	}

	public ManagerAutorityModifyAction(Member inMember) {
		this.inMember = inMember;
	}

	@Override
	public void run(Scanner sc) throws Exception {
		Consol co = new Consol(inMember);
		ManagerCustomerInformationShowService scSer = new ManagerCustomerInformationShowService();
		ManagerAutorityModifyService autoService = new ManagerAutorityModifyService();
		ArrayList<Member> list = new ArrayList<Member>();
		Member autorityMember = new Member();
		Member afterMember = new Member();
		boolean result = false;
		boolean pwCheck = false;

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
				autorityMember = co.cChoice("회원권한 수정", list, sc);
				if (autorityMember == null) {
					co.goBack();
				} else {
					co.title("권한 선택");
					afterMember = co.autorityCheck(autorityMember, sc);
					pwCheck = co.passCheck(inMember, sc, "수정");
					if (pwCheck) {
						result = autoService.cAutority(afterMember);
						if (result == false) {
							co.autorityFail(afterMember);
						} else if (result == true) {
							co.autoritySuccess(afterMember);
						}
					} else {
						co.pwCheckFail();
					}
				}
			}
		}

	}

}
