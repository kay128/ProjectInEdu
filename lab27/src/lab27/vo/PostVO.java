package lab27.vo;

import java.util.Date;

public class PostVO {
   private int post_id;
   private String user_id;
   private Date regdate;
   private int hit;
   private int notice;
   private String title;
   private String content;
   private String image_or;
   private String image_sa;
   private String board_name;

   public PostVO() {
   }

   public PostVO(int post_id, String user_id, Date regdate, int hit, int notice, String title, String content,
         String image_or, String image_sa, String board_name) {
      super();
      this.post_id = post_id;
      this.user_id = user_id;
      this.regdate = regdate;
      this.hit = hit;
      this.notice = notice;
      this.title = title;
      this.content = content;
      this.image_or = image_or;
      this.image_sa = image_sa;
      this.board_name = board_name;
   }

   public int getPost_id() {
      return post_id;
   }

   public void setPost_id(int post_id) {
      this.post_id = post_id;
   }

   public String getUser_id() {
      return user_id;
   }

   public void setUser_id(String user_id) {
      this.user_id = user_id;
   }

   public Date getRegdate() {
      return regdate;
   }

   public void setRegdate(Date regdate) {
      this.regdate = regdate;
   }

   public int getHit() {
      return hit;
   }

   public void setHit(int hit) {
      this.hit = hit;
   }

   public int getNotice() {
      return notice;
   }

   public void setNotice(int notice) {
      this.notice = notice;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public String getImage_or() {
      return image_or;
   }

   public void setImage_or(String image_or) {
      this.image_or = image_or;
   }

   public String getImage_sa() {
      return image_sa;
   }

   public void setImage_sa(String image_sa) {
      this.image_sa = image_sa;
   }

   public String getBoard_name() {
      return board_name;
   }

   public void setBoard_name(String board_name) {
      this.board_name = board_name;
   }

   @Override
   public String toString() {
      return "PostVO [post_id=" + post_id + ", user_id=" + user_id + ", regdate=" + regdate + ", hit=" + hit
            + ", notice=" + notice + ", title=" + title + ", content=" + content + ", image_or=" + image_or
            + ", image_sa=" + image_sa + ", board_name=" + board_name + "]";
   }

}