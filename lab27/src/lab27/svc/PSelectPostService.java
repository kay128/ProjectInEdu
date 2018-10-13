package lab27.svc;

import lab27.vo.Lab27_DAO;
import lab27.vo.PostVO;
import static lab27.db.JdbcUtils.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public class PSelectPostService {

	public ArrayList<PostVO> selectPost(HashMap param) {
		Connection conn = getConnection();
		Lab27_DAO dao = new Lab27_DAO(conn);
		
		ArrayList<PostVO> vo =  dao.selectP(param);
		
		close(conn, null, null);
		
		return vo;
	}

}
