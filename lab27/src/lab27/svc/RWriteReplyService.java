package lab27.svc;

import lab27.vo.Lab27_DAO;
import lab27.vo.ReplyVO;

import static lab27.db.JdbcUtils.*;

import java.sql.Connection;

public class RWriteReplyService {

	public boolean replyWrite(ReplyVO reply) {
		Connection conn = getConnection();
		Lab27_DAO dao = new Lab27_DAO(conn);
		
	
			dao.writeReply(reply);
			
			if(reply.getLev()==0) {// Lv0의 댓글일 경우에
				int check = dao.writeReply(reply);
				
				if(check == 0) {
					rollback(conn);
					close(conn, null, null);
					return false;
				} else {
					commit(conn);
					close(conn, null, null);
					return true;
				}
				
			} else { //Lv.0의 댓글이 아닐경우
				dao.reSort(reply);
				int check = dao.writeReply(reply);

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
	
}
