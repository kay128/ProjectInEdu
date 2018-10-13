function checkLogin(or){
            var check;
            
            if(or == null){
               check = 'ログインが必要な機能です。 \nログインしますか。';
               var bool = confirm(check);
               if(bool){
                  location.href='login.jsp';
               }else{
                  alert('いいえボタンをクリックしました。');
               }
               return false;
            }else if(or == true){
                check = 'ログインが必要な機能です。 \nログインしますか。';
                var bool = confirm(check);
                if(bool){
                   location.href='login.jsp';
                }else{
                   alert('いいえボタンをクリックしました。');
                }
                return false;
            }else {
               /*if(checkIn == null || checkIn.equals("")|| checkIn.lenght() == 0 || checkIn.equals('null')|| checkIn.equals("null")||
                     checkIn == "" || checkIn == 'null'|| checkIn == "null" || checkIn.lenght == 0){
                  alert('チェックインを入力してください。');
                  return false;
               }
               if(checkOut == null || checkOut.equals("")|| checkOut.lenght() == 0 || checkOut.equals('null')|| checkOut.equals("null")||
                     checkOut == "" || checkOut == 'null'|| checkOut == "null" || checkOut.lenght == 0){
                  alert('チェックアウトを入力してください。');
                  return false;
               }*/
               
               return true;
            }
            
         }