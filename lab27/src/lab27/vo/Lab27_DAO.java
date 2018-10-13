package lab27.vo;

import static lab27.db.JdbcUtils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Lab27_DAO {
   /*코딩시 참조사항
    * 1. connection은 service에서 만들어서, dao 생성자의 parameter 값으로 받는다.
    * 2. pstmt 및 rs의 close는 dao에서 한다
    * 3. update 및 insert method의 경우 결과에 따라 service에서 commit 또는 rollback 한다.
    * 4. conn의 close는 모든 것이 끝난 뒤 service에서 한다.*/

   private Connection conn;

   public Lab27_DAO(Connection conn) {
      this.conn = conn;
   }

   /* ============== member ============== */

   /* 회원가입 sql */
   public int memberJoin(MemberVO member) {
      String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

      PreparedStatement pstmt = null;
      int check = -1;
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, member.getUser_id());
         pstmt.setString(2, member.getPass());
         pstmt.setString(3, member.getName());
         pstmt.setInt(4, member.getGrade_id());
         pstmt.setString(5, member.getEmail());
         pstmt.setString(6, member.getPhone());
         pstmt.setString(7, member.getLocation());
         pstmt.setString(8, member.getPhoto_or());
         pstmt.setString(9, member.getPhoto_sa());
         pstmt.setString(10, member.getStudy_jp());
         pstmt.setString(11, member.getStudy_it());
         pstmt.setInt(12, member.getAdmin());

         check = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }

      return check;
   }

   /*
    * idCheck : param에 id만 입력할 때 로그인 : param에 id랑 pass를 함께 입력할 때
    */
   public MemberVO getOneM(MemberVO param) {
      String sql = "select * from member where ";
      if (param.getUser_id().length() > 0) {
         sql += "user_id = ? ";
      }
      if (param.getPass().length() > 0) {
         sql += "and pass = ? ";
      }

      PreparedStatement pstmt = null;
      ResultSet rs = null;

      MemberVO loginUser = null;

      try {
         pstmt = conn.prepareStatement(sql);
         if (param.getUser_id().length() > 0) {
            pstmt.setString(1, param.getUser_id());
         }
         if (param.getPass().length() > 0) {
            pstmt.setString(2, param.getPass());
         }

         rs = pstmt.executeQuery();
         if (rs.next()) {
            loginUser = new MemberVO(rs.getString("user_id"), 
                  rs.getString("pass"), 
                  rs.getString("name"),
                  rs.getInt("grade_id"), 
                  rs.getString("email"), 
                  rs.getString("phone"), 
                  rs.getString("location"),
                  rs.getString("photo_or"), 
                  rs.getString("photo_sa"), 
                  rs.getString("study_jp"),
                  rs.getString("study_it"),
                  rs.getInt("admin"));
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, rs);
      }

      return loginUser;
   }
   
   public ArrayList<MemberVO> getMemberList(HashMap param){
      String sql = "select * from member ";
      switch((String)param.get("type")) {
      case "name":
         sql +="where name = ? order by name";
         break;
      case "grade":
         sql += "where grade_id = ? order by name";
         break;
      }
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      ArrayList<MemberVO> list = new ArrayList<MemberVO>();
      
      try {
         pstmt = conn.prepareStatement(sql);
         switch((String)param.get("type")) {
         case "name":
            pstmt.setString(1, (String)param.get("param"));
            break;
         case "grade":
            pstmt.setInt(1, Integer.parseInt((String)param.get("param")));
            break;
         }
         rs = pstmt.executeQuery();
         while(rs.next()) {
            list.add(new MemberVO(rs.getString("user_id"), 
                        rs.getString("pass"), 
                        rs.getString("name"),
                        rs.getInt("grade_id"), 
                        rs.getString("email"), 
                        rs.getString("phone"), 
                        rs.getString("location"),
                        rs.getString("photo_or"), 
                        rs.getString("photo_sa"), 
                        rs.getString("study_jp"),
                        rs.getString("study_it"),
                        rs.getInt("admin")));
         }
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         close(null, pstmt, rs);
      }
      return list;
   }

   /* 회원정보 수정 메소드
    * HashMap 내 key를 기준으로 구분.
    * 1. admin: 관리자 권한을 부여하거나 뺏는다.
    * 2. modify: 회원 정보를 수정한다.
    * 3. study_j: 일본어 학습 기록을 업데이트 한다.
    * 4. study_i: it 학습 기록을 업데이트 한다.*/
   public int updateMember(HashMap param) {
      String sql = "update member set ";
      switch ((String)param.get("type")) {
      case "admin":
         sql += "admin = ?";
         break;
      case "modify":
         sql += "pass=?, email=?, phone=?, location=?, photo_or=?, photo_sa=?";
         break;
      case "study_j":
         sql += "study_jp = ?";
         break;
      case "study_i":
         sql += "study_it = ?";
         break;
      }
      sql += " where user_id=?";

      PreparedStatement pstmt = null;
      int result = -1;

      try {
         pstmt = conn.prepareStatement(sql);

         switch ((String)param.get("type")) {
         case "admin":
            pstmt.setInt(1, ((MemberVO)param.get("mem")).getAdmin());
            pstmt.setString(2, ((MemberVO)param.get("mem")).getUser_id());
            break;
         case "modify":
            pstmt.setString(1, ((MemberVO)param.get("mem")).getPass());
            pstmt.setString(2, ((MemberVO)param.get("mem")).getEmail());
            pstmt.setString(3, ((MemberVO)param.get("mem")).getPhone());
            pstmt.setString(4, ((MemberVO)param.get("mem")).getLocation());
            pstmt.setString(5, ((MemberVO)param.get("mem")).getPhoto_or());
            pstmt.setString(6, ((MemberVO)param.get("mem")).getPhoto_sa());
            pstmt.setString(7, ((MemberVO)param.get("mem")).getUser_id());
            break;
         case "study_j":
            pstmt.setString(1, ((MemberVO)param.get("mem")).getStudy_jp());
            pstmt.setString(2, ((MemberVO)param.get("mem")).getUser_id());
            break;
         case "study_i":
            pstmt.setString(1, ((MemberVO)param.get("mem")).getStudy_it());
            pstmt.setString(2, ((MemberVO)param.get("mem")).getUser_id());
            break;
         }

         result = pstmt.executeUpdate();

      } catch (SQLException e) {

         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }

      return result;
   }

   /* id별 회원 삭제 혹은 탈퇴 */
   public int deleteMember(MemberVO mvo) {
      String sql = "delete from member where user_id=?";
      PreparedStatement pstmt = null;
      int result = -1;

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, mvo.getUser_id());

         result = pstmt.executeUpdate();

      } catch (SQLException e) {

         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }

      return result;
   }

   /* ============== post ============== */

   /*새로운 post를 작성한다. _ board_name에 unique 제약이 걸려있다.*/
   public int writePost(PostVO post) {
      String sql = "insert into post values (((select max(post_id) from post)+1), "
            + "?, sysdate, 0, ?, ?, ?, ?, ?, ?)";
      PreparedStatement pstmt = null;
      int result = -1;
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, post.getUser_id());
         pstmt.setInt(2, post.getNotice());
         pstmt.setString(3, post.getTitle());
         pstmt.setString(4, post.getContent());
         pstmt.setString(5, post.getImage_or());
         pstmt.setString(6, post.getImage_sa());
         pstmt.setString(7, post.getBoard_name());

         result = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }

      return result;
   }

   /*1개의 게시물을 가져온다.
    * HashMap으로 2개중 1개의 parameter 값을 가져온다.
    * HashMap 내 key를 기준으로 구분.
    * 1. my_notice: my page에서 출력할. 특정 모임(board_name으로 구분)의 공지사항 글중 
    *             가장 최신의 것을 1개 선택해서 가져온다.
    * 2. recent: my page 에서 출력할. 특정 모임의 최신글을 1개 가져온다.*/
   public PostVO onePost(HashMap param) {
      String sql = "select * from post ";
      switch ((String) param.get("type")) {
      case "my_notice":
         sql += "where notice > 0 and regdate = (select max(regdate) from post)";
         break;
      case "recent":
         sql += "where regdate = (select max(regdate) from post)";
      }
      sql += " and board_name = ?";

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      PostVO vo = null;
      try {
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, (String) param.get("board_name"));

         rs = pstmt.executeQuery();

         if (rs.next()) {
            vo = new PostVO(rs.getInt("post_id"), 
                  rs.getString("user_id"), 
                  rs.getDate("regdate"), 
                  rs.getInt("hit"),
                  rs.getInt("notice"), 
                  rs.getString("title"), 
                  rs.getString("content"), 
                  rs.getString("image_or"),
                  rs.getString("image_sa"), 
                  rs.getString("board_name"));
         }

      } catch (Exception e) {
         e.printStackTrace();
      }
      return vo;
   }
   
   /*post 목록을 출력한다.
    * HashMap 내 key를 기준으로 구분.
    * 1. user_id: my page에서 출력할. 사용자가 작성한 post 목록을 가져온다.
    * 2. board_name: board별 게시글 목록을 가져온다.
    * 3. block: 금지어를 포함한 게시글 목록을 가져온다.*/
   /*post 목록을 출력한다.
    * HashMap 내 key를 기준으로 구분.
    * 1. user_id: my page에서 출력할. 사용자가 작성한 post 목록을 가져온다.
    * 2. board_name: board별 게시글 목록을 가져온다.
    * 3. block: 금지어를 포함한 게시글 목록을 가져온다.
    * 4. my_post : 내가 개시한 게시글 목록을 가져온다.
    * */
   public ArrayList<PostVO> selectP(HashMap param) {
      String sql = "select * from post ";

      switch ((String) param.get("type")) {
      case "user_id":
         sql += "where user_id = ? order by board_name, regdate";
         break;
      case "board_name":
         sql += "where board_name = ? order by regdate";
         break;
      case "block":
         sql += "where title like '%"+((String)param.get("word")).trim()+
         "%' or content like '%"+((String)param.get("word")).trim()+"%'";
          break;
      case "my_post" : 
         sql += "where board_name = ? and user_id = ? order by regdate ";
         break;
      case "market":
         sql += "where board_name in (?, ?) order by regdate";
      }

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      ArrayList<PostVO> list = new ArrayList<PostVO>();

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, (String)param.get("param"));
         if((String) param.get("type") == "my_post") {
            pstmt.setString(2, (String) param.get("param2"));
         }else if(param.get("type").equals("market")) {
            pstmt.setString(1, (String)param.get("board_name1"));
            pstmt.setString(2, (String)param.get("board_name2"));
         }
         rs = pstmt.executeQuery();

         while (rs.next()) {
            list.add(new PostVO(rs.getInt("post_id"), 
                  rs.getString("user_id"), 
                  rs.getDate("regdate"),
                  rs.getInt("hit"), 
                  rs.getInt("notice"), 
                  rs.getString("title"), 
                  rs.getString("content"),
                  rs.getString("image_or"), 
                  rs.getString("image_sa"), 
                  rs.getString("board_name")));
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, rs);
      }
      return list;
   }
   
   /* 게시글 자세히 보기 method.
    * 게시글 + 댓글의 join 문이기 때문에 arraylist를 반환한다.
    * 주의점. 게시글 및 댓글 table에 attribute 값의 이름이 중복되는 경우 as 로 다른 이름으로 가져온다.
    * */
   public ArrayList<PostReplyVO> selectOneP(int poN) {
      String sql = "select a.post_id, a.user_id as p_user_id, a.regdate, a.hit, a.notice, a.title, a.content as p_content, a.image_or, a.image_sa, a.board_name, b.reply_id, b.user_id as r_user_id, b.reply_regdate, b.lev, b.sort, b.reply_rate, b.content as r_content, b.is_del from post a left outer join reply b on a.post_id = b.post_id where a.post_id = ? order by b.sort";

      PreparedStatement pstmt = null;
      ResultSet rs = null;

      ArrayList<PostReplyVO> list = new ArrayList<PostReplyVO>();
      System.out.println(poN);
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, poN);

         rs = pstmt.executeQuery();

         while (rs.next()) {
            list.add(new PostReplyVO(rs.getInt("post_id"), 
                  rs.getString("p_user_id"), 
                  rs.getDate("regdate"),
                  rs.getInt("hit"), 
                  rs.getInt("notice"), 
                  rs.getString("title"), 
                  rs.getString("p_content"),
                  rs.getString("image_or"), 
                  rs.getString("image_sa"), 
                  rs.getString("board_name"),
                  rs.getInt("reply_id"), 
                  rs.getString("r_user_id"), 
                  rs.getDate("reply_regdate"), 
                  rs.getInt("lev"),
                  rs.getInt("sort"), 
                  rs.getInt("reply_rate"), 
                  rs.getString("r_content"), 
                  rs.getInt("is_del")));
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, rs);
      }
      System.out.println(list.size());
      return list;
   }

   /* 게시글 내용을 수정한다.
    * HashMap 내 key를 기준으로 구분.
    * 1. hit: 게시글 조회시 조회수 증가
    * 2. notice: 게시글을 공지글 로 변경시 notice 변경
    * 3. modify: 게시글 내용을 변경*/
   public int updatePost(HashMap param) {
      String sql = "update post set ";

      switch ((String) param.get("type")) {
      case "hit":
         sql += "hit = hit+1";
         break;
      case "notice":
         sql += "notice = ?";
         break;
      case "modify":
         sql += "title = ?, content = ?, image_or = ?, image_sa = ? board_name = ?";
         break;
      }
      sql += " where post_id = ?";

      PreparedStatement pstmt = null;
      int result = -1;
      try {
         pstmt = conn.prepareStatement(sql);

         switch ((String) param.get("type")) {
         case "hit":
            pstmt.setInt(1, ((int)param.get("param")));
            break;
         case "notice":
            pstmt.setInt(1, ((PostVO)param.get("modi_post")).getNotice());
            pstmt.setInt(2, ((PostVO)param.get("modi_post")).getPost_id());
            break;
         case "modify":
            pstmt.setString(1, ((PostVO)param.get("modi_post")).getTitle());
            pstmt.setString(2, ((PostVO)param.get("modi_post")).getContent());
            pstmt.setString(3, ((PostVO)param.get("modi_post")).getImage_or());
            pstmt.setString(4, ((PostVO)param.get("modi_post")).getImage_sa());
            pstmt.setString(5, ((PostVO)param.get("modi_post")).getBoard_name());
            pstmt.setInt(6, ((PostVO)param.get("modi_post")).getPost_id());
            break;
         }

         result = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }

      return result;
   }

   /*post_id 별 post를 삭제하는 메소드*/
   public int deletePost(PostVO pvo) {
      String sql = "delete from post where post_id=?";
      PreparedStatement pstmt = null;
      int result = -1;

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, pvo.getPost_id());

         result = pstmt.executeUpdate();

      } catch (SQLException e) {

         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }

      return result;
   }

   /* 게시판 자체를 삭제하는 메소드.
    * 모임 삭제 시 해당 메소드를 사용하여 게시판도 삭제한다.*/
   public int deleteBoard(String brdN) {
      String sql = "delete from post where board_name = ?";
      PreparedStatement pstmt = null;
      int result = -1;

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, brdN);

         result = pstmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }

      return result;
   }

   /* ============== reply ============== */

   /* 댓글의 마지막 정렬값을 가져오는 메소드.
    * : 게시글에 댓글을 작성할 경우, 게시글에 속하는 마지막 정렬값을 가져올 필요가 있다.
    * */
   public int getLastSort(int poN) {

      String sql = "select max(sort) from reply where post_id = ?";

      PreparedStatement pstmt = null;
      ResultSet rs = null;

      int result = 0;

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, poN);
         rs = pstmt.executeQuery();
         if (rs.next()) {
            result = rs.getInt(1);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, rs);
      }

      return result;
   }

   /* 댓글을 작성하는 메소드.
    * */
   public int writeReply(ReplyVO reply) {
      String sql = "insert into reply values (((select max(reply_id) from reply)+1), ?, ?, "
            + "sysdate, ?, ?, ?, ?, ?)";
      PreparedStatement pstmt = null;
      int result = -1;
      try {
         pstmt = conn.prepareStatement(sql);

         pstmt.setInt(1, reply.getPost_id());
         pstmt.setString(2, reply.getUser_id());
         pstmt.setInt(3, reply.getLev());
         pstmt.setInt(4, reply.getSort());
         pstmt.setInt(5, reply.getReply_rate());
         pstmt.setString(6, reply.getContent());
         pstmt.setInt(7, reply.getIs_del());

         result = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }

      return result;
   }

   /*댓글에 대한 댓글이 작성될 경우(lev != 0) sort값을 변경시킬 필요가 있다.
    * ReplyVO에는 댓글이 작성되는 해당 게시글 id와 대댓글이 작성될 위치
    * 바로 위에 위치한 댓글의 sort값을 parameter값으로 가져와
    * 해당 sort 값 보다 sort 값이 클 경우 전부 1개씩 밀어내는 method다.*/
   public int reSort(ReplyVO reply) {
      String sql = "update set sort = (sort+1) where post_id = ? and sort > ?";
      PreparedStatement pstmt = null;
      int result = -1;

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, reply.getPost_id());
         pstmt.setInt(2, reply.getSort());

         result = pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }
      return result;
   }

   /* 특정 board에서 특정회원이 작성한 댓글을 조회하는 메소드
    * : myPage에서 출력할 - 내가 작성한 댓글 을 조회하는 데 사용된다.
    * */
   public ReplyVO selectOneRnB(HashMap param) {
      String sql = "select * from reply " 
            + "where post_id = (select post_id from post where board_name = ?) "
            + "and user_id = ?";

      PreparedStatement pstmt = null;
      ResultSet rs = null;

      ReplyVO result = null;

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, (String) param.get("board_name"));
         pstmt.setString(2, (String) param.get("user_id"));

         rs = pstmt.executeQuery();

         if (rs.next()) {
            result = new ReplyVO(rs.getInt("reply_id"), 
                  rs.getInt("post_id"), 
                  rs.getString("user_id"),
                  rs.getDate("reply_regdate"), 
                  rs.getInt("lev"), 
                  rs.getInt("sort"), 
                  rs.getInt("reply_rate"),
                  rs.getString("content"), 
                  rs.getInt("is_del"));
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, rs);
      }

      return result;
   }

   /*댓글 수정 method
    * HashMap 내 key를 기준으로 구분.
    * 1. reply_rate: 댓글 추천을 클릭할 경우 실행 method. 평가에 +1증가한다.
    * 2. id_del: 댓글을 삭제할 경우 실행 method. 댓글의 경우 실제 삭제하지 않는다.
    * 3. content: 댓글의 내용을 수정하는 method*/
   public int updateReply(HashMap param) {
      String sql = "update reply set ";

      switch ((String)param.get("type")) {
      case "reply_rate":
         sql += "reply_rate = reply_rate+1";
         break;
      case "is_del":
         sql += "is_del = ?";
         break;
      case "content":
         sql += "content = ?";
         break;
      }
      sql += " where reply_id = ?";

      PreparedStatement pstmt = null;
      int result = -1;
      try {
         pstmt = conn.prepareStatement(sql);

         switch ((String)param.get("type")) {
         case "reply_rate":
            pstmt.setInt(1, ((ReplyVO)param.get("reply")).getReply_id());
            break;
         case "is_del":
            pstmt.setInt(1, ((ReplyVO)param.get("reply")).getIs_del());
            pstmt.setInt(2, ((ReplyVO)param.get("reply")).getReply_id());
            break;
         case "content":
            pstmt.setString(1, ((ReplyVO)param.get("reply")).getContent());
            pstmt.setInt(2, ((ReplyVO)param.get("reply")).getReply_id());
            break;
         }

         result = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }

      return result;
   }

   /* ============== rate ============== */

   /* 같은 댓글에 1인이 중복 추천을 방지하기 위한 목적 */
   
   /* 댓글에 추천이 발생할 경우 추천자의 id 및 해당 댓글의 id가 입력되는 메소드*/
   public int insertRate(RateVO rate) {
      String sql = "insert into rate values(?, ?)";
      PreparedStatement pstmt = null;
      int result = -1;
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, rate.getReply_id());
         pstmt.setString(2, rate.getUser_id());

         result = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }
      return result;
   }

   /*추천 action이 실행 될 경우 추천 기록이 있는 지 확인하는 메소드 */
   public RateVO checkR(RateVO rate) {
      String sql = "select * from rate where reply_id = ? and user_id = ?";
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      RateVO result = null;

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, rate.getReply_id());
         pstmt.setString(2, rate.getUser_id());

         rs = pstmt.executeQuery();
         if (rs.next()) {
            result = new RateVO(rs.getInt("reply_id"), rs.getString("user_id"));
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, rs);
      }

      return result;
   }
   
   /* ============== community ============== */
   
   /*모임 개설 메소드*/
   public int makeC(CommunityVO commu) {
      String sql = "insert into community values(?, ?, sysdate, ?)";
      PreparedStatement pstmt = null;
      int result = -1;
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, commu.getC_name());
         pstmt.setString(2, commu.getC_theme());
         pstmt.setString(3, commu.getC_master());

         result = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }
      return result;
   }

   /*모임 조회 메소드
    * HashMap 내 key를 기준으로 구분.
    * 1. c_master: 개설자 id 로 검색. 
    *       개설자는 1인 1 모임밖에 개설하지 못하기 때문에 해당 check에 사용한다
    * 2. c_name: 모임 이름으로 검색. 모임 이름은 중복될 수 없기 때문에 해당 check에 사용한다.*/
   public CommunityVO getOneC(HashMap param) {
      String sql = "select * from community ";

      switch ((String)param.get("type")) {
      case "c_master":
         sql += "where c_master = ?";
         break;
      case "c_name":
         sql += "where c_name = ?";
         break;
      }
      
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      CommunityVO result = null;

      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, (String)param.get("param"));

         rs = pstmt.executeQuery();
         if (rs.next()) {
            result = new CommunityVO(rs.getString("c_name"), 
                  rs.getString("c_theme"), 
                  rs.getDate("c_date"),
                  rs.getString("c_master"));
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, rs);
      }
      return result;
   }
   
   /*모임 목록 조회 메소드
    * HashMap 내 key를 기준으로 구분.
    * 1. recent: 입력한 기간 내 설된 모임을 출력한다.
    * 2. search: 검색 키워드. 모임 명 혹은 모임 소개 중 키워드가 포함 된 모임을 출력한다.
    * 3. all : 존재하는 모든 모임을 출력한다.*/
      
   public ArrayList<CommunityVO> getListC(HashMap param) {
      String sql = "select * from community ";

      switch ((String)param.get("type")) {
      case "period":
         sql += " where c_date between to_date('"+(String)param.get("start_day")
         +"', 'yyyy-mm-dd') and to_date('"+(String)param.get("end_day")+"', 'yyyy-mm-dd')";
         break;
      case "search":
         sql += "where c_name like '%"+((String)param.get("param")).trim()
         +"%' or c_theme like '%"+((String)param.get("param")).trim()+"%'";
         break;
      case "all" :
         break;
      }

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      ArrayList<CommunityVO> list =new ArrayList<CommunityVO>();

      try {
         pstmt = conn.prepareStatement(sql);

         rs = pstmt.executeQuery();
         while (rs.next()) {
            list.add( new CommunityVO(rs.getString("c_name"), 
                  rs.getString("c_theme"), 
                  rs.getDate("c_date"),
                  rs.getString("c_master")));
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, rs);
      }
      return list;
   }
   
   
   public ArrayList<CommunityVO> getListC_count(HashMap param) {
	   String sql = "select distinct a.c_name, a.c_theme, a.c_date, a.c_master, "
	             + "(select count(user_id) from COMMUNITY_MEMBER where c_name = a.c_name) "
	             + "from COMMUNITY a left join COMMUNITY_MEMBER b on a.c_name = b.c_name "
	             + "where c_date between to_date('"+(String)param.get("start_day")+"', 'yyyy-mm-dd') and to_date('"+(String)param.get("end_day")+"', 'yyyy-mm-dd')";


       PreparedStatement pstmt = null;
       ResultSet rs = null;
       
       ArrayList<CommunityVO> list =new ArrayList<CommunityVO>();

       try {
          pstmt = conn.prepareStatement(sql);

          rs = pstmt.executeQuery();
          while (rs.next()) {
             list.add( new CommunityVO(rs.getString("c_name"), 
                   rs.getString("c_theme"), 
                   rs.getDate("c_date"),
                   rs.getString("c_master"),
                   rs.getString(5)));
          }
       } catch (Exception e) {
          e.printStackTrace();
       } finally {
          close(null, pstmt, rs);
       }
       return list;
    }
   
   /* 특정모임 전체 조회 메소드
    * 모임의 인원수, 모임의 인원 등을 포함하여 전체 정보를 조회한다
    * HashMap 내 key를 기준으로 구분.
    * 1. c_name: 특정 모임 조회
    * 2. user_id: 회원이 가입한 커뮤니티 전체를 조회한다
    * 3. favorite: 회원이 즐겨찾기한 커뮤니티 전체를 조회한다 */
   public ArrayList<CAllVO> getOneCAll(HashMap param){
      String sql = "select a.c_name, a.c_theme, a.c_date, a.c_master, (select count(user_id) from COMMUNITY_MEMBER)as count,b.user_id, b.c_favorite from COMMUNITY a, COMMUNITY_MEMBER b where a.c_name = b.c_name ";
      
      switch((String)param.get("type")) {
      case "c_name":
         sql += "and a.c_name = ?";
         break;
      case "user_id":
         sql += "and user_id = ? order by c_name";
         break;
      case "favorite":
         sql += "and user_id = ? and c_favorite > 0 order by c_name";
         break;
      }
      
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      ArrayList<CAllVO> list = new ArrayList<CAllVO>();
      
      try {
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, (String)param.get("param"));
         
         rs=pstmt.executeQuery();
         
         while(rs.next()) {
            list.add(new CAllVO(rs.getString("c_name"),
                  rs.getString("c_theme"),
                  rs.getDate("c_date"),
                  rs.getString("c_master"),
                  rs.getInt("count"),
                  rs.getString("user_id"),
                  rs.getInt("c_favorite")));
         }
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         close(null, pstmt, rs);
      }
      return list;
   
   }
   

   /*모임 수정 메소드
    * HashMap 내 key를 기준으로 구분.
    * 1. c_master: 개설자 id 변경. 모임 관리자 변경시 사용한다.
    * 2. theme: 모임 소개 변경*/
   public int updateC(HashMap param) {
      String sql = "update community ";

      switch ((String)param.get("type")) {
      case "c_master":
         sql += "set c_master = ?";
         break;
      case "theme":
         sql += "set c_theme = ?";
         break;
      }

      sql += " where c_name = ?";

      PreparedStatement pstmt = null;
      int result = -1;

      try {
         pstmt = conn.prepareStatement(sql);

         switch ((String)param.get("type")) {
         case "master":
            pstmt.setString(1, ((CommunityVO)param.get("community")).getC_master());
            break;
         case "theme":
            pstmt.setString(1, ((CommunityVO)param.get("community")).getC_theme());
            break;
         }
         pstmt.setString(2, ((CommunityVO)param.get("community")).getC_name());

         result = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }
      return result;
   }

   /*특정 모임을 삭제할 때 사용한다.*/
   public int deleteC(String c_name) {
      String sql = "delete from community where c_name = ?";

      PreparedStatement pstmt = null;
      int result = -1;

      try {
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, c_name);

         result = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }
      return result;
   }

   /* ============== community_member ============== */
   
   /*모임 가입 메소드*/
   public int joinC(CMemberVO cMem) {
      String sql = "insert into community_member values(?, ?, 0, ?)";
      PreparedStatement pstmt = null;
      int result = -1;

      try {
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, cMem.getC_name());
         pstmt.setString(2, cMem.getUser_id());
         pstmt.setInt(3, cMem.getC_grade());

         result = pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }
      return result;
   }

   /*즐겨찾기 추가를 위해, user가 추가한 즐겨찾기의 갯수를 검사한다*/
   
   public int getCountFavorite(String user_id) {
      String sql = "select count(user_id) from community_member where user_id = ? and favorite > 0";
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      int result = -1;
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, user_id);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            result = rs.getInt(1);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         close(null, pstmt,rs);
      }
      return result;
   }

   /*즐겨찾기를 추가 혹은 제거하는 method*/
   public int modifyFavorit(CMemberVO c_member) {
      String sql = "update community_member set favorit = ? where user_id = ? and c_name = ?";
      PreparedStatement pstmt = null;
      int result = -1;
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, c_member.getC_favorite());
         pstmt.setString(2, c_member.getUser_id());
         pstmt.setString(3, c_member.getC_name());
         result = pstmt.executeUpdate();
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         close(null, pstmt, null);
      }
      return result;
   }
   
   /*모임에서 탈퇴 및 추방하는 메소드*/
   public int outC(CMemberVO cMem) {
      String sql = "delete from community_member where user_id = ?";
      PreparedStatement pstmt = null;
      int result = -1;

      try {
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, cMem.getUser_id());

         result = pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(null, pstmt, null);
      }
      return result;
   }

}