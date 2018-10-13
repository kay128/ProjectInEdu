package action;

import java.util.Scanner;

import consol.Consol;
import model.Member;
import service.ManagerCustomerInformationModifyService;

public class CustomerInformationModifyAction implements Action {

	Member inMember;

	public CustomerInformationModifyAction() {
	}

	public CustomerInformationModifyAction(Member inMember) {
		this.inMember = inMember;
	}

	@Override
	public void run(Scanner sc) throws Exception {
		Consol co = new Consol(inMember);
		ManagerCustomerInformationModifyService cmSer = new ManagerCustomerInformationModifyService();
		Member afterMember = new Member();
		boolean pwCheck = false;
		boolean result = false;

		co.title("수정 정보 입력");
		afterMember = co.cModify(inMember, sc);
		pwCheck = co.passCheck(inMember, sc, "회원정보 수정");
		if (pwCheck) {
			result = cmSer.cModify(afterMember);
			if (result == false) {
				co.dropFail(inMember, "회원정보 수정");
			} else if (result == true) {
				co.dropSuccess(inMember, "회원정보 수정");
			}
		} else {
			co.pwCheckFail();
		}
	}
}
