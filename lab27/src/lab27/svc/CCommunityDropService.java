package lab27.svc;

import lab27.vo.CMemberVO;
import lab27.vo.Lab27_DAO;

import static lab27.db.JdbcUtils.*;

import java.sql.Connection;

public class CCommunityDropService {

	public boolean CDropCMemberService(CMemberVO cMem) {
		Connection conn = getConnection();
		Lab27_DAO dao = new Lab27_DAO(conn);
		int result = dao.outC(cMem);
		if(result >0) {
			commit(conn);
			close(conn, null, null);
			return true;
		} else {
			rollback(conn);
			close(conn, null, null);
			return false;
		}
	
	}

}
