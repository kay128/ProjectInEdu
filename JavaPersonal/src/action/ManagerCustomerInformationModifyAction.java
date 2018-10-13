package action;

import java.util.ArrayList;
import java.util.Scanner;

import consol.Consol;
import model.Member;
import service.ManagerCustomerInformationModifyService;
import service.ManagerCustomerInformationShowService;

public class ManagerCustomerInformationModifyAction implements Action {
	Member inMember;

	public ManagerCustomerInformationModifyAction() {
	}

	public ManagerCustomerInformationModifyAction(Member inMember) {
		this.inMember = inMember;
	}

	@Override
	public void run(Scanner sc) throws Exception {
		Consol co = new Consol(inMember);
		ManagerCustomerInformationShowService scSer = new ManagerCustomerInformationShowService();
		ArrayList<Member> list = new ArrayList<Member>();
		ManagerCustomerInformationModifyService cmSer = new ManagerCustomerInformationModifyService();
		Member modifyMember = new Member();
		Member afterMember = new Member();
		boolean pwCheck = false;
		boolean result = false;

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
				modifyMember = co.cChoice("회원정보 수정", list, sc);
				if(modifyMember == null) {
					co.goBack();
				}else {
					co.title("수정 정보 입력");
					afterMember = co.mModify(modifyMember, sc);
					pwCheck = co.passCheck(inMember, sc, "회원정보 수정");
					if (pwCheck) {
						result = cmSer.cModify(afterMember);
						if (result == false) {
							co.dropFail(modifyMember, "회원정보 수정");
						} else if (result == true) {
							co.dropSuccess(modifyMember, "회원정보 수정");
						}	
					}else {
						co.pwCheckFail();
					}
				}
				
				
			}
		}
	}

}
