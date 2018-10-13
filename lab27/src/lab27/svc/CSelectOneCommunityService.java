package lab27.svc;

import java.sql.Connection;
import java.util.HashMap;

import static lab27.db.JdbcUtils.*;

import lab27.vo.CommunityVO;
import lab27.vo.Lab27_DAO;

public class CSelectOneCommunityService {

	public CommunityVO oneCommuGet(HashMap map) {
		Connection conn = getConnection();
		Lab27_DAO dao = new Lab27_DAO(conn);
		CommunityVO vo = new CommunityVO();
		vo =  dao.getOneC(map);
		close(conn, null, null);
		return vo;
	}

}
