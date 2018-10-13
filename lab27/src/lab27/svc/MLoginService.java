package lab27.svc;

import static lab27.db.JdbcUtils.close;
import static lab27.db.JdbcUtils.getConnection;

import java.sql.Connection;

import lab27.vo.Lab27_DAO;
import lab27.vo.MemberVO;

public class MLoginService {

	public MemberVO login(MemberVO vo) {
		Connection conn = getConnection();
		
		Lab27_DAO dao = new Lab27_DAO(conn);
		MemberVO loginUser = new MemberVO();
		loginUser = dao.getOneM(vo);
		close(conn, null, null);
		
		return loginUser;
		
	}

}
