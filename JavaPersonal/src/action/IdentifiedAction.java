package action;

import java.util.Scanner;

import consol.Consol;
import model.Member;
import service.IdentifiedService;

public class IdentifiedAction implements Action {

	@Override
	public void run(Scanner sc) throws Exception {

		Consol co = new Consol();
		co.title("Id / Password 찾기");
		int choice = co.identified(sc);
		String kind = null;
		if (choice == 0) {
			co.goBack();
		} else {
			if (choice == 1) {
				kind = "customer";
			} else if (choice == 2) {
				kind = "manager";
			}

			String name = co.nameInput(sc);
			String configWord = co.configWordInput(sc);
			if (configWord.replaceAll(" ", "").equals("")) {
				co.identifiedFail();
			} else {
				Member identifiedMember = new Member(name, kind, configWord);

				IdentifiedService identiSer = new IdentifiedService();
				Member infoMember = identiSer.infoMember(identifiedMember);
				if (infoMember == null) {
					int jChoice = 0;
					jChoice = co.logFail("회원정보를 찾을 수 없습니다.", sc);
					if (jChoice == 0) {
					} else if (jChoice == 1) {
						JoinAction joAction = new JoinAction();
						joAction.run(sc);
					} else if (jChoice == 2) {
						co.fPage();
					}
				} else {
					int logChoice = 0;
					co.title("회원정보 조회 결과");
					logChoice = co.infoView(infoMember, sc);
					if (logChoice == 1) {
						LoginAction logAction = new LoginAction();
						logAction.run(sc);
					} else if (logChoice == 2) {
						co.fPage();
					}
				}

			}

		}

	}

}
