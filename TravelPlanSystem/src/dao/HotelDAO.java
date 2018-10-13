package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import static db.JdbcUtils.*;

import model.Customer;
import model.Hotel;
import model.Result;

public class HotelDAO {
		Connection conn;
	
	public HotelDAO() {
		this.conn = getConnection();
	}
	
	public ArrayList<Hotel> getHotelList() {
		
		ArrayList<Hotel> HotelList =new ArrayList<Hotel>();
		String sql = "select * from hotel";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HotelList.add(new Hotel(
						rs.getString("hotelName"),
						rs.getString("hotelCity"),
						rs.getString("hotelAddress"),
						rs.getInt("hotelPrice"),
						rs.getInt("quality")));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}

		return HotelList;
	}


	public int addHotel(Hotel Hotel) {
		String sql = "insert into hotel values(hotelId_seq.nextval,?,?,?,?,?,0)";
		HotelDAO AddHotel =null;
		PreparedStatement pstmt = null;
		int rs = -1;
		Connection conn  = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Hotel.getHotelName());
			pstmt.setString(2, Hotel.getHotelCity());
			pstmt.setInt(3, Hotel.getHotelPrice());
			pstmt.setString(4, Hotel.getHotelAddress());
			pstmt.setInt(5, Hotel.getQuality());
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		return rs;
	}

	public int modifyHotel(Hotel hotel) {
		String sql = "update hotel set hotelCity=?, hotelPrice=?, hotelAddress=?, quality=? where hotelName = ?";
		PreparedStatement pstmt = null;
		int rs = -1;
		Connection conn = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, hotel.getHotelCity());
			pstmt.setInt(2, hotel.getHotelPrice());
			pstmt.setString(3, hotel.getHotelAddress());
			pstmt.setInt(4, hotel.getQuality());
			pstmt.setString(5, hotel.getHotelName());
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}

		return rs;

	}
	
	public int deleteHotel(String hotelName) {
		String sql = "delete from hotel where hotelName=?";
		PreparedStatement pstmt = null;
		int rs = -1;
		Connection conn = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotelName);
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
			}
		  return rs;
	}
	
	
	
	/*실시간 인기숙소*/
	public ArrayList<Hotel> getRandomHotel(){
		ArrayList<Hotel> randomList = new ArrayList<Hotel>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int count = 0;
		int index = 0;
		int k = 0;
		
		try {
			pstmt = conn.prepareStatement("select count(hotelId) from hotel");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
				System.out.println("count? " + count);
			}
			if(count != 0) {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				for(int i = 1; i<=count; i++){
					arr.add(i);
				}
				Collections.shuffle(arr);
				for(int i = 0; i<count; i++){
					System.out.println(arr.get(i));
				}
					if(count > 9) {
						k = 9;
					}else if(count <= 9) {
						k = arr.size();
					}
					for(int i = 0; i<k; i++) {
						index = (arr.get(i))-1;
						pstmt = conn.prepareStatement("select * from hotel where hotelId = ?");
						pstmt.setInt(1, index);
						rs = pstmt.executeQuery();
						if(rs.next()) {
							randomList.add(new Hotel(rs.getInt("hotelId"), 
									rs.getString("hotelName"), 
									rs.getString("hotelCity"),
									rs.getInt("hotelPrice"),
									rs.getInt("quality"), 
									rs.getFloat("avgReviewGrade")));
						
						}
					}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) close(rs);
			if(pstmt != null) close(pstmt);
			if(conn != null) close(conn);
		}
		
		return randomList;
	}
	
	/*도시별 호텔 검색 결과*/
	public ArrayList<Hotel> getCityHotel(String cityName){
		ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		System.out.println("도시이름:"+cityName);
		try {
			pstmt = conn.prepareStatement("select * from hotel where hotelCity like '%"+cityName+"%'");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				hotelList.add(new Hotel(rs.getInt("hotelId"), 
						rs.getString("hotelName"), 
						rs.getString("hotelCity"),
						rs.getInt("hotelPrice"),
						rs.getInt("quality"), rs.getFloat("avgReviewGrade")));
					}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) close(rs);
			if(pstmt != null) close(pstmt);
			if(conn != null) close(conn);
		}
		
		return hotelList;
	}
	
	/*호텔 상세보기*/
	public ArrayList<Hotel> selectHotel(String hotelName){
		ArrayList<Hotel> selectedHotel = new ArrayList<Hotel>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("select c.hotelName, c.hotelCity, c.hotelAddress, c.hotelPrice, "
					+ "c.quality, c.avgReviewGrade, a.nickName, a.reviewGrade, a.reviewContent"
					+ " from result a, hotel c where a.hotelName(+) = c.hotelName and c.hotelName = ?");
			pstmt.setString(1, hotelName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				selectedHotel.add(new Hotel(rs.getString("hotelName"), rs.getString("hotelCity"),rs.getString("hotelAddress"),
						rs.getInt("hotelPrice"), rs.getInt("quality"), rs.getFloat("avgReviewGrade"),
						rs.getString("nickName"), rs.getInt("reviewGrade"), rs.getString("reviewContent")));
					}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) close(rs);
			if(pstmt != null) close(pstmt);
			if(conn != null) close(conn);
		}
		return selectedHotel;
	}
	
	/*사용자 호텔 예약기능*/
	public int bookingHotel(Result bookingInfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement("insert into result(resultId, email, nickName, writeDate, "
					+ "hotelName, checkIn, checkOut) values(resultId_seq.nextval, ?, ?, sysdate, ?, ?, ?)");
			pstmt.setString(1, bookingInfo.getEmail());
			pstmt.setString(2, bookingInfo.getNickName());
			pstmt.setString(3, bookingInfo.getHotelName());
			pstmt.setString(4, bookingInfo.getCheckIn());
			pstmt.setString(5, bookingInfo.getCheckOut());
			result = pstmt.executeUpdate();
			if(result != 0) {
				commit(conn);
			}
		}catch(Exception e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			if(pstmt != null) close(pstmt);
			if(conn != null) close(conn);}
		return result;
	}
	
	/*사용자 예약 호텔 조회 기능*/
	public ArrayList<Result> myInfoHotel(String email){
		ArrayList<Result> userHotelList = new ArrayList<Result>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Result result = null;
		System.out.println("넘어온 이메일 주소: "+email);
		
		try {
			pstmt = conn.prepareStatement("select nickName, hotelName, checkIn, checkOut from result "
					+ "where email = ? order by checkIn ASC");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new Result();
					result.setNickName(rs.getString("nickName"));
					result.setHotelName(rs.getString("hotelName"));
					result.setCheckIn(rs.getString("checkIn"));
					result.setCheckOut(rs.getString("checkOut"));
				userHotelList.add(result);
					}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) close(rs);
			if(pstmt != null) close(pstmt);
			if(conn != null) close(conn);
		}
		return userHotelList;
	}
	
	/*사용자 호텔 후기 작성 기능 + 평균 평점 반영*/
	public int writeReview(Result review) {
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println("넘어온 후기 평점: "+review.getReviewGrade());
		System.out.println("넘어온 후기 내용: "+review.getReviewContent());
		try {
			pstmt = conn.prepareStatement("update result set "
					+ "reviewGrade = ?, reviewContent = ? "
					+ "where resultId = ?");
			pstmt.setInt(1, review.getReviewGrade());
			pstmt.setString(2, review.getReviewContent());
			pstmt.setInt(3, review.getResultId());
			result = pstmt.executeUpdate();
			if(result != 0) {
				commit(conn);
			}
		}catch(Exception e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			if(pstmt != null) close(pstmt);
			if(conn != null) close(conn);}
		return result;
	}
	
	public int updateReview(String hotelName) {
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println("평점 반영할 호텔 이름: "+hotelName);
		try {
			pstmt = conn.prepareStatement("update hotel "
					+ "set avgReviewGrade = (select avg(reviewGrade) "
					+ "from result where hotelName=? and reviewGrade > 0) where hotelName=?");
			pstmt.setString(1, hotelName);
			pstmt.setString(2, hotelName);
			result = pstmt.executeUpdate();
			if(result !=0) {
				commit(conn);
			}
		}catch(Exception e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			if(pstmt != null) close(pstmt);
			if(conn != null) close(conn);}
		return result;
	}
	
	public int cancleHotel(Customer loginUser, int resultId) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement("delete from result where email = ? and resultId = ?");
			pstmt.setString(1, loginUser.getEmail());
			pstmt.setInt(2, resultId);
			result = pstmt.executeUpdate();
			if(result != 0) {
				commit(conn);
			}
		}catch(Exception e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			if(pstmt != null) close(pstmt);
			if(conn != null) close(conn);}
		return result;
	}
	public int getResultId(Result bookingInfo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultId = 0;
		
		try {
			pstmt = conn.prepareStatement("select resultId from result where email=? and hotelName =? and checkIn = ? and checkOut=?");
			pstmt.setString(1, bookingInfo.getEmail());
			pstmt.setString(2, bookingInfo.getHotelName());
			pstmt.setString(3, bookingInfo.getCheckIn());
			pstmt.setString(4, bookingInfo.getCheckOut());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultId = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			if(pstmt != null) close(pstmt);
			if(conn != null) close(conn);}
		return resultId;
	}
	public Result getBookingInfo(int resultId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Result bookingInfo = null;
		
		try {
			pstmt = conn.prepareStatement("select * from result where resultId = ?");
			pstmt.setInt(1, resultId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bookingInfo = new Result(rs.getInt("resultId"), rs.getString("email"), 
						rs.getString("nickName"), rs.getString("writeDate"), rs.getString("hotelName"), 
						rs.getString("checkIn"), rs.getString("checkOut"), rs.getInt("reviewGrade"));
				bookingInfo.setReviewContent(rs.getString("reviewContent"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			rollback(conn);
		}finally {
			if(pstmt != null) close(pstmt);
			if(conn != null) close(conn);}
		
		return bookingInfo;
		
	}
	
}
