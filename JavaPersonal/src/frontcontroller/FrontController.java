package frontcontroller;

import java.util.Scanner;

import action.Action;
import model.Member;

public class FrontController {
	public void request(Action action, Scanner sc) {
		try {
			action.run(sc);
		} catch (Exception e) {
			System.out.println("FrontController 에서 오류가 발생하였습니다.");
			e.printStackTrace();
		}
	}
	public void request(Action action, Scanner sc, Member inMember) {
		try {
			action.run(sc);
		} catch (Exception e) {
			System.out.println("FrontController 에서 오류가 발생하였습니다.");
			e.printStackTrace();
		}
	}
}
