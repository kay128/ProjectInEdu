package lab27.vo;

public class MemberVO {
   private String user_id;
   private String pass;
   private String name;
   private int grade_id;
   private String email;
   private String phone;
   private String location;
   private String photo_or;
   private String photo_sa;
   private String study_jp;         
   private String study_it;   
   private int admin;

   public MemberVO() {
   }

/*   public MemberVO(String user_id, String pass, String name, int grade_id, String email, String phone, String location,
         String photo_or, String photo_sa, int admin) {
      super();
      this.user_id = user_id;
      this.pass = pass;
      this.name = name;
      this.grade_id = grade_id;
      this.email = email;
      this.phone = phone;
      this.location = location;
      this.photo_or = photo_or;
      this.photo_sa = photo_sa;
      this.admin = admin;
   }*/
   
   public MemberVO(String user_id, String pass, String name, int grade_id, String email, String phone, String location,
         String photo_or, String photo_sa, String study_jp, String study_it, int admin) {
      super();
      this.user_id = user_id;
      this.pass = pass;
      this.name = name;
      this.grade_id = grade_id;
      this.email = email;
      this.phone = phone;
      this.location = location;
      this.photo_or = photo_or;
      this.photo_sa = photo_sa;
      this.study_jp = study_jp;
      this.study_it = study_it;
      this.admin = admin;
   }

   public String getUser_id() {
      return user_id;
   }

   public void setUser_id(String user_id) {
      this.user_id = user_id;
   }

   public String getPass() {
      return pass;
   }

   public void setPass(String pass) {
      this.pass = pass;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getGrade_id() {
      return grade_id;
   }

   public void setGrade_id(int grade_id) {
      this.grade_id = grade_id;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getLocation() {
      return location;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public String getPhoto_or() {
      return photo_or;
   }

   public void setPhoto_or(String photo_or) {
      this.photo_or = photo_or;
   }

   public String getPhoto_sa() {
      return photo_sa;
   }

   public void setPhoto_sa(String photo_sa) {
      this.photo_sa = photo_sa;
   }

   public String getStudy_jp() {
      return study_jp;
   }

   public void setStudy_jp(String study_jp) {
      this.study_jp = study_jp;
   }

   public String getStudy_it() {
      return study_it;
   }

   public void setStudy_it(String study_it) {
      this.study_it = study_it;
   }

   public int getAdmin() {
      return admin;
   }

   public void setAdmin(int admin) {
      this.admin = admin;
   }

   @Override
   public String toString() {
      return "MemberVO [user_id=" + user_id + ", pass=" + pass + ", name=" + name + ", grade_id=" + grade_id
            + ", email=" + email + ", phone=" + phone + ", location=" + location + ", photo_or=" + photo_or
            + ", photo_sa=" + photo_sa + ", study_jp=" + study_jp + ", study_it=" + study_it + ", admin=" + admin
            + "]";
   }

}