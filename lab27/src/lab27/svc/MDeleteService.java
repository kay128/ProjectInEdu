package lab27.svc;

import static lab27.db.JdbcUtils.*;

import java.sql.Connection;

import lab27.vo.Lab27_DAO;
import lab27.vo.MemberVO;

public class MDeleteService {

	public boolean deleteMember(MemberVO vo) {
		
		Connection conn = getConnection();
		
		Lab27_DAO dao = new Lab27_DAO(conn);
		
		int result = dao.deleteMember(vo);
		
		   if(result > 0) {
			   commit(conn);
		         close(conn, null, null);
		         return true;
		      } else {
		         
		         rollback(conn);
		         close(conn, null, null);
		         return false;
		      }
		      
	}

}
