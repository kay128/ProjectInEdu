package lab27.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import lab27.vo.CAllVO;
import lab27.vo.Lab27_DAO;

import static lab27.db.JdbcUtils.*;

public class CSelectOneCAllService {

	public ArrayList<CAllVO> getCAllOne(HashMap map) {
		Connection conn = getConnection();
		Lab27_DAO dao = new Lab27_DAO(conn);
		ArrayList<CAllVO> cAll = dao.getOneCAll(map);
		close(conn, null, null);
		
		return cAll;
	}

}
