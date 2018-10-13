package lab27.svc;

import static lab27.db.JdbcUtils.*;

import java.sql.Connection;

import lab27.vo.Lab27_DAO;

public class CCommunityDeleteService {

	public boolean deleteCommunity(String c_name) {
		Connection conn = getConnection();
		Lab27_DAO dao = new Lab27_DAO(conn);
		int result = dao.deleteC(c_name);
		
		if(result > 0) {
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
