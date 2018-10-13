package dao;

import static db.JdbcUtils.close;
import static db.JdbcUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Customer;
import model.Result;

public class ResultDAO {	
		
	private Connection conn = null;
	
	public ResultDAO() {
		try {
			this.conn = getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Result> getCustomerSchedule(String email) {
		String sql = "select distinct scheduleTitle from result where email=?";
		ArrayList<Result> list = new ArrayList<Result>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String title = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				title = rs.getString(1);
				if(title != null) {
				list.add(new Result(title));
				System.out.println("dao:title: "+title);	
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return list;
	}

	public int createSchedule(String title, JSONArray array, String lastday,Customer customer) {
		String[] sql = new String[array.size()];
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		String today = sdf.format(date);
		System.out.println("오늘날짜: " +today);
		
		PreparedStatement pstmt = null;
		int result = 0;
		/*insert into result(resultId, email, nickName, writeDate, scheduleTitle, placeName, visitDate) 
		 * values(resultId_seq.nextval, 'jsl271@naver.com', '고객1', 
		 * '17/10/5', '떠나고싶은 날 1', '오사카성' , '1일차');*/
		 
		
		try {
			for(int i=0;i<array.size();i++) {
				JSONObject tempObj = (JSONObject) array.get(i);
				sql[i]= new String();
				sql[i] = "insert into result(resultId, email, nickName, writeDate, scheduleTitle, placeName, visitDate, scheduleLastDay) values(resultId_seq.nextval,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql[i]);
				pstmt.setString(1, customer.getEmail());
				pstmt.setString(2, customer.getNickName());
				pstmt.setString(3, today);
				pstmt.setString(4, title);
				pstmt.setString(5, tempObj.get("place").toString());
				pstmt.setInt(6, Integer.parseInt(tempObj.get("day").toString()));
				pstmt.setInt(7, Integer.parseInt(lastday));
				
				pstmt.executeUpdate();
				result+=1;
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		
		return result;
	}

	public ArrayList<Result> getMyHotelBookingList(String email) {
		String sql = "select resultId, hotelName, checkIn, checkOut from result where email=? and checkIn not in('null')";
		ArrayList<Result> hotellist = new ArrayList<Result>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int resultId = 0;
		String hotelName = null;
		String checkIn = null;
		String checkOut = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {				
				resultId = rs.getInt(1);
				hotelName = rs.getString(2);
				checkIn = rs.getString(3);
				checkOut = rs.getString(4);
				
				hotellist.add(new Result(resultId, hotelName, checkIn, checkOut));
				
				//System.out.println("dao:hotellist"+hotellist.get(arg0));					
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return hotellist;
					
	}
	
	/*
	 * create table result(
	resultId number primary key,
	email varchar2(40) not null,
	nickName varchar2(20) not null,
	writeDate varchar2(40) not null,
	scheduleTitle varchar2(40),
	placeName varchar2(40),
	visitDate varchar2(20),
	hotelName varchar2(40),
	checkIn varchar2(20),
	checkOut varchar2(20),
	reviewGrade number default 0,
	reviewContent varchar2(1000)
);

	 */

	public ArrayList<Result> getScheduleDetail(String title, String email) {
		
		String sql = "select visitDate, placeName, scheduleTitle, scheduleLastDay from result where email=? and scheduleTitle=?";
		ArrayList<Result> list = new ArrayList<Result>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int visitDate = 0;
		String placeName = null;
		String scheduleTitle = null;
		int lastDay = 0;
		
		System.out.println("getSchduleTitle:"+title);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, title);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Result result = null;
				visitDate = rs.getInt(1);
				placeName = rs.getString(2);
				scheduleTitle = rs.getString(3);
				lastDay = rs.getInt(4);
				
				list.add(new Result(visitDate, placeName, scheduleTitle, lastDay));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		
		return list;
	}	
	public int deletescheduleByTitle(String title, String email) {
		String sql = "delete from result where scheduleTitle=? and email=?";
		int deleteResult = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, email);
			
			deleteResult = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		
		return deleteResult;
		
	}	
}




