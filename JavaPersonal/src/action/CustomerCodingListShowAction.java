package action;

import java.util.ArrayList;
import java.util.Scanner;

import consol.Consol;
import frontcontroller.FrontController;
import model.Member;
import model.Query;
import service.CustomerCoingListShowService;

public class CustomerCodingListShowAction implements Action {
	Member inMember;

	public CustomerCodingListShowAction(Member inMember) {
		this.inMember = inMember;
	}

	@Override
	public void run(Scanner sc) throws Exception {
		Consol co = new Consol(inMember);
		CustomerCoingListShowService listSer = new CustomerCoingListShowService();
		ArrayList<Query> list = listSer.getList(inMember);
		Action action = null;
		FrontController fc = new FrontController();

		Query choicedQuery = null;
		int sChoice = 0;
		int tChoice = 0;

		if (list.size() != 0) {
			co.title(inMember.getName() + "님께서 공부했던 SQL문 목록");
			co.showList(list);
			choicedQuery = co.choiceQuery(list, "조회", sc);
			if (choicedQuery == null) {
				co.goBack();
			} else {
				co.quSpecific(choicedQuery);
				sChoice = co.yesOrno("해당 SQL문을 수정 또는 삭제 하시겠습니까?", sc);
				if(sChoice == 0) {
				}else if (sChoice == 1) {
					tChoice = co.quChoice(sc);
					switch (tChoice) {
					case 1:
						action = new CodingModifyAction(inMember, choicedQuery);
						break;
					case 2:
						action = new CustomerCodingDropAction(inMember, choicedQuery);
						break;
					case 3:
						co.goBack();
						break;
					}
					if (action != null) {
						fc.request(action, sc);
					}

				} else {
					co.goBack();
				}
			}
		} else {
			co.noList();
		}
	}

}
