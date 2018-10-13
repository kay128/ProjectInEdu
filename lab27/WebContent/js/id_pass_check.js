function idPassCheck(){
	/*<input type="submit" onclick="return idPassCheck()"/>
	 * <script type="text/javascript" src = "/lab27/js/id_pass_check.js"></script>*/
	
	var id = document.frm.id.value;
	var pass = document.frm.pass.value;

	var reg_uid = /^[a-z0-9_]{5,12}$/;
	var reg_upw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-]|.*[0-9]).{6,24}$/;
	
	 if( !reg_uid.test( id ) ) {
         alert("아이디는 영문자로 시작하는 5~12자 영문자 또는 숫자이어야 합니다.");
         return;
     }
	 if( !reg_upw.test( pass ) ) {
         alert("비밀번호는 영문자, 숫자, 특수문자 포함 6~24자여야 합니다.");
         return;
     }
	
	
}