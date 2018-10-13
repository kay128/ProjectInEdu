package lab27.vo;

import java.util.Date;

public class ReplyVO {
   private int reply_id;
   private int post_id;
   private String user_id;
   private Date reply_regdate;
   private int lev;
   private int sort;
   private int reply_rate;
   private String content;
   private int is_del;
   
   
   public ReplyVO() {}
   
   
   public ReplyVO(int reply_id, int post_id, String user_id, Date reply_regdate, int lev, int sort, int reply_rate,
         String content, int is_del) {
      super();
      this.reply_id = reply_id;
      this.post_id = post_id;
      this.user_id = user_id;
      this.reply_regdate = reply_regdate;
      this.lev = lev;
      this.sort = sort;
      this.reply_rate = reply_rate;
      this.content = content;
      this.is_del = is_del;
   }


   public int getReply_id() {
      return reply_id;
   }


   public void setReply_id(int reply_id) {
      this.reply_id = reply_id;
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


   public String getContent() {
      return content;
   }


   public void setContent(String content) {
      this.content = content;
   }


   public int getIs_del() {
      return is_del;
   }


   public void setIs_del(int is_del) {
      this.is_del = is_del;
   }


   @Override
   public String toString() {
      return "ReplyVO [reply_id=" + reply_id + ", post_id=" + post_id + ", user_id=" + user_id + ", reply_regdate="
            + reply_regdate + ", lev=" + lev + ", sort=" + sort + ", reply_rate=" + reply_rate + ", content="
            + content + ", is_del=" + is_del + "]";
   }
   
}