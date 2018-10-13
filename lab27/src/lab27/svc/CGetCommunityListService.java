package lab27.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import static lab27.db.JdbcUtils.*;
import lab27.vo.CommunityVO;
import lab27.vo.Lab27_DAO;

public class CGetCommunityListService {

   public ArrayList<CommunityVO> getAllCommunity(HashMap map) {
      Connection conn = getConnection();
      Lab27_DAO dao = new Lab27_DAO(conn);
      ArrayList<CommunityVO> allList = new ArrayList<CommunityVO>();
            //allList =   dao.getListC(map);
      if(map.get("type").equals("period")) {
         allList = dao.getListC_count(map);
      }else {
         allList = dao.getListC(map);   
      }
      
      
      close(conn, null, null);
      
      return allList;
   }

}