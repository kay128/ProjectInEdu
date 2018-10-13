package action;

import java.util.Scanner;

import consol.Consol;
import model.Member;
import service.JoinService;

public class JoinAction implements Action {

	@Override
	public void run(Scanner sc) throws Exception{
		
		Consol con = new Consol();
		boolean idStop = false;
		JoinService joSer = new JoinService();
		
		String joinId = null;
		String joinPw = null;
		String joinName = null;
		String joinKind = null;
		String joinConfigWord = null;
		Member joinMember;
		boolean result = false;
		
		do {
			con.title("회원가입");
			joinId = con.idInput(sc);
			
			String checkId = joSer.idCheck(joinId);
			
			if(checkId == null) {
				con.idOk();
				idStop = false;
			}else if(checkId != null) {
				con.idNo();
				idStop = true;
			}
		}while(idStop);
		joinPw = con.pwInput(sc);
		joinName = con.nameInput(sc);
		joinConfigWord = con.configWordJoin(sc);
		joinKind = "custommer";
		joinMember = new Member(joinId, joinPw, joinName, joinKind, joinConfigWord);
		result = joSer.join(joinMember);
		if(result == false) {
			con.joinFail();
		}else if(result == true){
			con.joinSuccess(joinMember.getId());
		}

	}

}
