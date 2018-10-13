package action;

import java.util.Scanner;

import consol.Consol;
import model.Member;

public class LogoutAction implements Action {
	Member inMember;
	public LogoutAction(Member inMember) {
		this.inMember = inMember;
	}

	@Override
	public void run(Scanner sc) throws Exception {
		Consol co = new Consol(inMember);
		co.logOut();
	}

}
