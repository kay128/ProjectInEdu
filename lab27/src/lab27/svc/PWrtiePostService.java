package lab27.svc;

import lab27.vo.Lab27_DAO;
import lab27.vo.PostVO;

import java.sql.Connection;

import static lab27.db.JdbcUtils.*;

public class PWrtiePostService {

	public boolean postWrite(PostVO post) {
		int check = 0;
		Connection conn = getConnection();
		
		Lab27_DAO dao = new Lab27_DAO(conn);
		
		check = dao.writePost(post);
		
		
		if(check == 0) {
			rollback(conn);
			close(conn, null, null);
			return false;
		} else {
			commit(conn);
			close(conn, null, null);
			return true;
		}
		
		
	}

}
