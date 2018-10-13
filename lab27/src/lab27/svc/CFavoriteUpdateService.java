package lab27.svc;

import lab27.vo.CMemberVO;
import lab27.vo.Lab27_DAO;

import static lab27.db.JdbcUtils.*;

import java.sql.Connection;

public class CFavoriteUpdateService {

   public boolean updateFavorite(CMemberVO cMem) {
      Connection conn = getConnection();
      Lab27_DAO dao = new Lab27_DAO(conn);
      int count = dao.getCountFavorite(cMem.getUser_id());
      if(count >3) {
         close(conn, null, null);
         return false;
      } else {
         int result = dao.modifyFavorit(cMem);
         if(result >0) {
            commit(conn);
            close(conn,null, null);
            return true;
         } else {
            rollback(conn);
            close(conn, null, null);
            return false;
         }
      }
      
   }

}