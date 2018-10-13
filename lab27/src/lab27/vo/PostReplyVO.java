package lab27.vo;

import java.util.Date;

public class PostReplyVO {
   private int post_id;
   private String p_user_id;
   private Date regdate;
   private int hit;
   private int notice;
   private String title;
   private String p_content;
   private String image_or;
   private String image_sa;
   private String board_name;
   private int reply_id;
   private String r_user_id;
   private Date reply_regdate;
   private int lev;
   private int sort;
   private int reply_rate;
   private String r_content;
   private int is_del;

   public PostReplyVO() {
   }

   public PostReplyVO(int post_id, String p_user_id, Date regdate, int hit, int notice, String title, String p_content,
         String image_or, String image_sa, String board_name, int reply_id, String r_user_id, Date reply_regdate,
         int lev, int sort, int reply_rate, String r_content, int is_del) {
      super();
      this.post_id = post_id;
      this.p_user_id = p_user_id;
      this.regdate = regdate;
      this.hit = hit;
      this.notice = notice;
      this.title = title;
      this.p_content = p_content;
      this.image_or = image_or;
      this.image_sa = image_sa;
      this.board_name = board_name;
      this.reply_id = reply_id;
      this.r_user_id = r_user_id;
      this.reply_regdate = reply_regdate;
      this.lev = lev;
      this.sort = sort;
      this.reply_rate = reply_rate;
      this.r_content = r_content;
      this.is_del = is_del;
   }

   public int getPost_id() {
      return post_id;
   }

   public void setPost_id(int post_id) {
      this.post_id = post_id;
   }

   public String getP_user_id() {
      return p_user_id;
   }

   public void setP_user_id(String p_user_id) {
      this.p_user_id = p_user_id;
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

   public String getP_content() {
      return p_content;
   }

   public void setP_content(String p_content) {
      this.p_content = p_content;
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

   public int getReply_id() {
      return reply_id;
   }

   public void setReply_id(int reply_id) {
      this.reply_id = reply_id;
   }

   public String getR_user_id() {
      return r_user_id;
   }

   public void setR_user_id(String r_user_id) {
      this.r_user_id = r_user_id;
   }

   public Date getReply_regdate() {
      return reply_regdate;
   }

   public void setReply_regdate(Date reply_regdate) {
      this.reply_regdate = reply_regdate;
   }

   public int getLev() {
      return lev;
   }

   public void setLev(int lev) {
      this.lev = lev;
   }

   public int getSort() {
      return sort;
   }

   public void setSort(int sort) {
      this.sort = sort;
   }

   public int getReply_rate() {
      return reply_rate;
   }

   public void setReply_rate(int reply_rate) {
      this.reply_rate = reply_rate;
   }

   public String getR_content() {
      return r_content;
   }

   public void setR_content(String r_content) {
      this.r_content = r_content;
   }

   public int getIs_del() {
      return is_del;
   }

   public void setIs_del(int is_del) {
      this.is_del = is_del;
   }

   @Override
   public String toString() {
      return "PostReplyVO [post_id=" + post_id + ", p_user_id=" + p_user_id + ", regdate=" + regdate + ", hit=" + hit
            + ", notice=" + notice + ", title=" + title + ", p_content=" + p_content + ", image_or=" + image_or
            + ", image_sa=" + image_sa + ", board_name=" + board_name + ", reply_id=" + reply_id + ", r_user_id="
            + r_user_id + ", reply_regdate=" + reply_regdate + ", lev=" + lev + ", sort=" + sort + ", reply_rate="
            + reply_rate + ", r_content=" + r_content + ", is_del=" + is_del + "]";
   }

}