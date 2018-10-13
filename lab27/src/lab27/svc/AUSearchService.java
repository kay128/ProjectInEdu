package lab27.svc;

import static lab27.db.JdbcUtils.close;
import static lab27.db.JdbcUtils.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import lab27.vo.Lab27_DAO;
import lab27.vo.MemberVO;


public class AUSearchService {

		public ArrayList<MemberVO> getMemberSearch(HashMap map){
			Connection conn = getConnection();
			Lab27_DAO dao = new Lab27_DAO(conn);
			ArrayList<MemberVO> memberList = dao.getMemberList(map);
			
			close(conn, null, null);
			return memberList;
		}
}
