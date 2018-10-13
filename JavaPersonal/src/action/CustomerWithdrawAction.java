package action;

import java.util.Scanner;

import consol.Consol;
import model.Member;
import service.ManagerCustomerInformationDropService;

public class CustomerWithdrawAction implements Action {
	Member inMember;

	public CustomerWithdrawAction() {
	}

	public CustomerWithdrawAction(Member inMember) {
		this.inMember = inMember;
	}

	@Override
	public void run(Scanner sc) throws Exception {
		Consol co = new Consol(inMember);
		ManagerCustomerInformationDropService cdSer = new ManagerCustomerInformationDropService();
		boolean pwCheck = false;
		boolean result = false;
		int last = 0;
		
		
		pwCheck = co.passCheck(inMember, sc, "탈퇴");
		if (pwCheck) {
			co.caution();
			last = co.yesOrno(inMember.getId()+"님 탈퇴하시겠습니까?", sc);
			if (last == 1) {
				result = cdSer.cDrop(inMember);
				if (result == false) {
					co.dropFail(inMember, "탈퇴");
				} else if (result == true) {
					co.dropSuccess(inMember, "탈퇴");
				}
			} else {
				co.pwCheckFail();
			}
		} else {
			co.goBack();
		}

	}

}
