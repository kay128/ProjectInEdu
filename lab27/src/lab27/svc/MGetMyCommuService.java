package lab27.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import lab27.vo.CAllVO;
import lab27.vo.CommunityVO;
import lab27.vo.Lab27_DAO;

import static lab27.db.JdbcUtils.*;

public class MGetMyCommuService {

	public ArrayList<CAllVO> getMyCommunity(HashMap map) {
		Connection conn = getConnection();
		Lab27_DAO dao = new Lab27_DAO(conn);
		CommunityVO commu = dao.getOneC(map);
		ArrayList<CAllVO> cAll = new ArrayList<CAllVO>();
		if(commu !=null) {
			map.put("type", "c_name");
			map.put("param", commu.getC_name());
			cAll = dao.getOneCAll(map);
		}
		
		close(conn, null, null);
		return cAll;
	}

}
