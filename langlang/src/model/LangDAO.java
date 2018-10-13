package model;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class LangDAO {
	
	private static LangDAO dao;
	private static Reader reader;
	private static SqlMapClient sqlmapper;
	
	public LangDAO(){
		
	}

	public static LangDAO getDAO() throws Exception{
		if(dao == null) {
			dao = new LangDAO();
		}
		if(sqlmapper == null) {
				reader = Resources.getResourceAsReader("sqlMapConfig.xml");
				sqlmapper = SqlMapClientBuilder.buildSqlMapClient(reader);
				reader.close();			
		}
		return dao;
	}
	
	public void join(Student st) throws Exception{
			sqlmapper.insert("insert_st", st);
	}

	public Student login(Student st) throws Exception{
		
		 Student result = (Student) sqlmapper.queryForObject("select_st", st);
		
		return result;
	}

	public Student checkEmail(Student st) throws Exception {
		Student result = (Student)sqlmapper.queryForObject("select_check_email", st.getEmail());
		return result;
	}
	
	public Student checkName(Student st) throws Exception {
		Student result = (Student)sqlmapper.queryForObject("select_check_name", st.getName());
		return result;
	}

	public ArrayList<Written> getList() throws Exception {
		ArrayList<Written> list = (ArrayList<Written>) sqlmapper.queryForList("select_all_wr");
		return list;
	}

	public ArrayList<Written> getOne(int res_id) throws Exception {
		ArrayList<Written> selected = (ArrayList<Written>) sqlmapper.queryForList("select_wr_join", res_id);
		return selected;
	}

	public void upHit(int res_id) throws Exception {
		sqlmapper.update("update_hit", res_id);		
	}

	public void loadWr(Written load) throws Exception {
		sqlmapper.insert("insert_wr",load);		
	}

	public int getLastId() throws Exception {
		int last = (int) sqlmapper.queryForObject("last_id");
		return last;
	}

	public int getLastFeedId() throws Exception {
		int lastFeed = (int) sqlmapper.queryForObject("last_feedback_id");
		return lastFeed;
	}

	public void loadFe(Feedback fe) throws Exception {
		sqlmapper.insert("insert_fe",fe);	
		
	}

	public void deleteWritten(int res_id) throws Exception {
		sqlmapper.delete("delete_wr", res_id);
		
	}

	public void modify(Written modify) throws Exception {
		sqlmapper.update("modify_wr", modify);
		
	}

	public void deleteFeedback(int feedback_id) throws Exception {
		sqlmapper.delete("delete_fe", feedback_id);
		
	}

	public void modifyFe(Feedback modify) throws Exception {
		sqlmapper.update("modify_fe", modify);
		
	}

	public void deleteUser(Student st) throws Exception {
		sqlmapper.delete("delete_st", st);
		
	}

	public void modifySt(Student modify) throws Exception {
		sqlmapper.update("modify_st", modify);
		
	}
	
}
