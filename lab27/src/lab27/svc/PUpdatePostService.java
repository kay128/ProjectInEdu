package lab27.svc;

import lab27.vo.Lab27_DAO;
import lab27.vo.PostVO;
import static lab27.db.JdbcUtils.*;

import java.sql.Connection;
import java.util.HashMap;

public class PUpdatePostService {

	public boolean postUpdate(HashMap param) {
		Connection conn = getConnection();
		
		Lab27_DAO dao = new Lab27_DAO(conn);
		
		int result = dao.updatePost(param);
		
		if(result > 0) {
			commit(conn);
			close(conn,null,null);
			return true;
		} else {
			rollback(conn);
			close(conn, null, null);
			return false;
		}
		
	}
	
}
