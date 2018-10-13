package lab27.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import static lab27.db.JdbcUtils.*;
import lab27.vo.CAllVO;
import lab27.vo.Lab27_DAO;

public class CFavoriteService {

	public ArrayList<CAllVO> selectFavorite(HashMap map) {
		Connection conn = getConnection();
		
		Lab27_DAO dao = new Lab27_DAO(conn);
		
		ArrayList<CAllVO> fList = dao.getOneCAll(map);
		
		close(conn, null ,null);
		
		return fList;
	}

}
