package lab27.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import lab27.vo.Lab27_DAO;
import lab27.vo.PostReplyVO;
import lab27.vo.PostVO;

import static lab27.db.JdbcUtils.*;

public class PSelectOnePostService {

	public ArrayList<PostReplyVO> selectOnePost(HashMap map) {
		Connection conn = getConnection();
		
		Lab27_DAO dao = new Lab27_DAO(conn);
		
		if(((String)map.get("type")).equals("hit")) {
			
			dao.updatePost(map);
		}
		
		int poN = (int) map.get("param");
		System.out.println("service"+poN);
		ArrayList<PostReplyVO> postReplyList = dao.selectOneP(poN);
		
		close(conn, null, null);
		
		return postReplyList;
	}

}
