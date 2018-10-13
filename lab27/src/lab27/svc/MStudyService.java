package lab27.svc;

import static lab27.db.JdbcUtils.close;
import static lab27.db.JdbcUtils.getConnection;

import java.sql.Connection;
import java.util.HashMap;

import lab27.vo.Lab27_DAO;
import lab27.vo.MemberVO;

public class MStudyService {

   public int update(HashMap<String, String> hash) {
      Connection conn = getConnection();
      
      Lab27_DAO dao = new Lab27_DAO(conn);
      int result = dao.updateMember(hash);
      
      close(conn, null, null);
      return result;
   }



}