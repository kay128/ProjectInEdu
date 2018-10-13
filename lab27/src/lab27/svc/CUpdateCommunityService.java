package lab27.svc;

import java.sql.Connection;
import java.util.HashMap;

import lab27.vo.Lab27_DAO;

import static lab27.db.JdbcUtils.*;

public class CUpdateCommunityService {

	public boolean updateCommunity(HashMap map) {
		Connection conn = getConnection();
		Lab27_DAO dao = new Lab27_DAO(conn);
		int result = dao.updateC(map);
		
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
