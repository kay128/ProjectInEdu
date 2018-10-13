package lab27.svc;

import static lab27.db.JdbcUtils.*;

import java.sql.Connection;

import lab27.vo.LabCompanyDAO;

public class DeletePavoriteService {

	public boolean deletePavorite(String user_id, int company_id) {
		Connection conn = getConnection();
		LabCompanyDAO dao = new LabCompanyDAO();
		int result = 0;
		try {
		result = dao.deletePavorite(user_id, company_id, conn);
		commit(conn);
		}catch(Exception e){
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(conn, null, null);
		}

		return result==0? false: true;
	}

}
