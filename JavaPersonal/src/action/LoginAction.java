package action;

import java.util.Scanner;

import consol.Consol;
import main.CustomerMenu;
import main.ManagerMenu;
import model.Member;
import service.LoginService;

public class LoginAction implements Action {

	@Override
	public void run(Scanner sc) throws Exception{
		
		Member logMember;
		Consol logCon = new Consol();
		logCon.title("login");
		String id = logCon.idInput(sc);
		String pw = logCon.pwInput(sc);
		logMember = new Member (id, pw);
		
		LoginService logSer = new LoginService();
		Member inMember;
		
		inMember = logSer.logSer(logMember);
		
		CustomerMenu cusMenu = new CustomerMenu();
		ManagerMenu manMenu = new ManagerMenu();
		
		if(inMember == null){
			int jChoice = 0;
			String str = "ID : "+ logMember.getId() +" 님을 찾을 수 없습니다.";
			jChoice = logCon.logFail(str, sc);
			if(jChoice==1) {
				JoinAction joAction = new JoinAction();
				joAction.run(sc);
			}else if(jChoice == 2) {
				logCon.fPage();
			}
		}else {
			if(inMember.getKind().equals("customer")) {
				logCon.logSuccess(inMember);
				cusMenu.cMenu(sc, inMember);
			 }else if(inMember.getKind().equals("manager")){
				 logCon.logSuccess(inMember);
				 manMenu.mMenu(sc, inMember);
			}
		}
	}
}
