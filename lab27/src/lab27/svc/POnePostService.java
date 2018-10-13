package lab27.svc;

import java.sql.Connection;
import java.util.HashMap;

import static lab27.db.JdbcUtils.*;

import lab27.vo.Lab27_DAO;
import lab27.vo.PostVO;

public class POnePostService {

	public PostVO onePost(HashMap map) {
		Connection conn = getConnection();
		Lab27_DAO dao = new Lab27_DAO(conn);
				PostVO vo = new PostVO();
					vo = dao.onePost(map);
		close(conn, null, null);
		
		return vo;
	}

}
