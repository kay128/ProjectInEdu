package dbDAO;

import static dbUtil.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Member;
import model.Query;

public class Dao {
	Connection conn;

	public Dao() {
		conn = getConnection();
	}

	public Member logIn(Member logMember) {
		String sql = "select * from member where id = ? and pw = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member inMember = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, logMember.getId());
			pstmt.setString(2, logMember.getPw());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String kind = rs.getString("kind");
				String configWord = rs.getString("configWord");
				inMember = new Member(id, pw, name, kind, configWord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DataBase 에서 찾는 중 오류가 발생하였습니다.");
		} finally {
			close(conn, pstmt, rs);
		}
		return inMember;
	}

	public String joinId(String joinId) {
		String sql = "select id from member where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, joinId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DataBase 에서 찾는 중 오류가 발생하였습니다.");
		} finally {
			close(conn, pstmt, rs);
		}
		return id;
		
	}

	public int join(Member joinMember) {
		String sql = "insert into member values (?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int record = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, joinMember.getId());
			pstmt.setString(2, joinMember.getPw());
			pstmt.setString(3, joinMember.getName());
			pstmt.setString(4, joinMember.getKind());
			pstmt.setString(5, joinMember.getConfigWord());
			record = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("DataBase 에 등록하는 중 오류가 발생하였습니다.");
		}finally {
			close(conn, pstmt);
		}
		return record;
	}

	public Member infoMember(Member identifiedMember) {
		String sql = "select * from member where name = ? and configWord = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member infoMember = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, identifiedMember.getName());
			pstmt.setString(2, identifiedMember.getConfigWord());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String kind = rs.getString("kind");
				String configWord = rs.getString("configWord");
				infoMember = new Member(id, pw, name, kind, configWord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DataBase 에서 찾는 중 오류가 발생하였습니다.");
		} finally {
			close(conn, pstmt, rs);
		}
		return infoMember;
	}

	public ArrayList<Member> searchMember(String key, String word) {
		String sql = "select * from member where "+ key +" like '%"+word+"%'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<Member>();
		Member getMember = null;
		boolean isStop = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); 
			do {
				if (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String kind = rs.getString("kind");
				String configWord = rs.getString("configWord");
				getMember = new Member(id, pw, name, kind, configWord);
				list.add(getMember);
				}else {isStop = true;}
			}while(isStop==false);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DataBase에서 찾는 중 오류가 발생하였습니다.");
		} finally {
			close(conn, pstmt,rs);
		}
		return list;
	}

	public int cModify(Member afterMember) {
		String sql = "update member set pw = ?, name = ?, kind = ?, configWord = ?  where id = ?";
		PreparedStatement pstmt = null;
		int record = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, afterMember.getPw());
			pstmt.setString(2, afterMember.getName());
			pstmt.setString(3, afterMember.getKind());
			pstmt.setString(4, afterMember.getConfigWord());
			pstmt.setString(5, afterMember.getId());
			record = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DataBase에 등록하는 중 오류가 발생하였습니다.");
		} finally {
			close(conn, pstmt);
		}
		return record;
	}

	public int cAutority(Member afterMember) {
		String sql = "update member set kind = ?  where id = ?";
		PreparedStatement pstmt = null;
		int record = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, afterMember.getKind());
			pstmt.setString(2, afterMember.getId());
			record = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DataBase에 등록하는 중 오류가 발생하였습니다.");
		} finally {
			close(conn, pstmt);
		}
		return record;
	}

	public int setQuery(Query makedQuery) {
		String sql = "insert into query values(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		int record = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, makedQuery.getMember().getId());
			pstmt.setString(2, makedQuery.getDay());
			pstmt.setString(3, makedQuery.getKeyWord());
			pstmt.setString(4, makedQuery.getQuery());
			pstmt.setString(5, makedQuery.getStructure());
			pstmt.setString(6, makedQuery.getExplain());
			record = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("DataBase에 등록하는 중 오류가 발생하였습니다.");
		}finally {
			close(conn, pstmt);
		}
		return record;
		
	}

	public ArrayList<Query> getList(Member inMember) {
		ArrayList<Query> list = new ArrayList<Query>();
		
		String sql = "select * from query where id = ?";
		PreparedStatement pstmt =null;
		String id = inMember.getId();
		ResultSet rs = null;
		Query result = null;
		boolean stop = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			do{if(rs.next()) {
				result = new Query(rs.getString("id"), rs.getString("day"), rs.getString("keyWord"),
						rs.getString("query"), rs.getString("structure"), rs.getString("explain"));
				list.add(result);
				}else {
					stop = true;
				}
			}while(stop == false);
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("DataBase에서 찾는 중 오류가 발생하였습니다.");
		} finally {
			close(conn, pstmt,rs);
		}
		return list;
	}

	public int cDrop(Member modifyMember) {
		String sql = "delete member where id = ?";
		PreparedStatement pstmt = null;
		int record = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modifyMember.getId());
			record = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DataBase에서 삭제하는 도중 오류가 발생하였습니다.");
		} finally {
			close(conn, pstmt);
		}
		return record;
	}

	public int qModify(Query afterQuery) {
	
		String sql = "update query set query = ? where id = ? and day = ?";
		PreparedStatement pstmt = null;
		int record = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, afterQuery.getQuery());
			pstmt.setString(2, afterQuery.getId());
			pstmt.setString(3, afterQuery.getDay());
			record = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DataBase에 등록하는 중 오류가 발생하였습니다.");
		} finally {
			close(conn, pstmt);
		}
		return record;
	}

	public int codingDrop(Query choicedQuery) {
		String sql = "delete query where id = ? and day = ?";
		PreparedStatement pstmt = null;
		int record = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, choicedQuery.getId());
			pstmt.setString(2, choicedQuery.getDay());
			record = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DataBase에서 삭제하는 도중 오류가 발생하였습니다.");
		} finally {
			close(conn, pstmt);
		}
		return record;
	}

}
