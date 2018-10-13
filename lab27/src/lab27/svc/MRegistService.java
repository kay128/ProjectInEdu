package lab27.svc;

import static lab27.db.JdbcUtils.*;

import java.sql.Connection;

import lab27.vo.Lab27_DAO;
import lab27.vo.MemberVO;

public class MRegistService {
   
   public boolean  memberRegist(MemberVO member) {
      Connection conn = getConnection();
      int check = 0;
      
      Lab27_DAO dao = new Lab27_DAO(conn);
      
      check = dao.memberJoin(member);      
      
      if(check == 0) {
         rollback(conn);
         close(conn, null, null);
         return false;
      } else {
         commit(conn);
         close(conn, null, null);
         return true;
      }
      
   }
   
}