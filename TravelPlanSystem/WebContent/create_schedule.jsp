<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@page import="model.Result"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<title>Insert title here</title>
<style>
#map{
	height:900px;
	width:100%;
}



</style>
</head>
<body>
<div class="container-fluid">
	<div class="row content">
		<div class="col-sm-1 sidenav" id="add">
		<div><button type="button" class="btn btn-success" id="save" data-toggle="modal" data-target="#myModal"  onclick = "return checkLogin(<%=(Customer)session.getAttribute("loginUser")%>);">プラン保存</button></div>
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">
				<!-- Modal Dialog -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">保存</h4>
					</div>
					<div class="modal-body">
						<form action="create_schedule.do" role="form">
							<div class="from-group">
							<input type="hidden" name="schedule_arr" value=""/>
							<input type="hidden" name="schedule_lastday" value=""/>
							<input type="text" class="form-control" name="scheduletitle" placeholder="プランの名前を入力してください。">
							</div>
							<br/>
							<button type="submit" class="btn btn-success btn-block">保存</button>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取り消す</button>
					</div>
				</div>
			</div>
		</div>
		<br/>
		<div><button type="button" class="btn btn-warning" id="delete">プラン削除</button></div>
		<br/>
		<div><button type="button" class="btn btn-primary" id="createschedule">プラン追加</button></div>
		<br/>
		<div id="schedule_day">
		<div><button type="button" class="btn btn-info" id="day1" >&nbsp;+&nbsp;Day&nbsp;1&nbsp;</button></div>
		<br/>
		</div>
		</div>
		<div id="addplace" class="col-sm-1 sidnav">
			<div id="addplace1">
			</div>
		</div>
		<div class="col-sm-10">
		<div id="map"></div>
		</div>
	</div>
</div>
<div id="data"></div>
 <script>
 	 // var result = new Result;
 	  var day = 1;
 	  var current_clickday=1;
 	  var aJson;
 	  var aJsonArray = new Array();
 	  var sJsonSchedule = new Object();
 	  var sJson = new Object();
      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 4,
          center: {lat: 34.687448, lng: 135.526169 }
        });

        var bounds = {
          north: 34.65,
          south: 35.01,
          east: 135.79,
          west: 134.68
        };

        // Display the area between the location southWest and northEast.
        map.fitBounds(bounds);

        var locationMessages = [];
        var lat=[];
        var lng=[];
        
        /** OsakaCastle **/
        locationMessages.push('大阪城');
        lat.push(34.687448);
        lng.push(135.526169);
        /** UniversalStudioJapan **/
        locationMessages.push('ユニバーサル・スタジオ・ジャパン™');
        lat.push(34.665751);
        lng.push(135.432285);
        /** HusiminariSinsa **/
        locationMessages.push('伏見稲荷大社');
        lat.push(34.966908);
        lng.push(135.768618);
        /** Giyoumizdera **/
        locationMessages.push('清水寺');
        lat.push(34.995146);
        lng.push(135.785036);
        /** HimesiCastle **/
        locationMessages.push('姫路城');
        lat.push(34.839757);
        lng.push(134.693862);
        /** NaraPark **/
        locationMessages.push('奈良公園');
        lat.push(34.685338);
        lng.push(135.843023);


        for (var i = 0; i < locationMessages.length; ++i) {
          var marker = new google.maps.Marker({
            position: {
              lat: lat[i],
              lng: lng[i]
            },
            map: map
          });
          attachSecretMessage(marker, locationMessages[i],lat[i],lng[i]);

        }
 
      }

      // Attaches an info window to a marker with the provided message. When the
      // marker is clicked, the info window will open with the secret message.
      function attachSecretMessage(marker, locationMessage,lat,lng) {
        var infowindow = new google.maps.InfoWindow({
          content: locationMessage
        });
        
        infowindow.open(marker.get('map'), marker);

        marker.addListener('click', function() {
          infowindow.open(marker.get('map'), marker);
         // console.log(marker.get('position'));
          console.log(lat);
          console.log(lng);
          
          var html = '<div><button type="button" class="btn">'+locationMessage+'</button></div><br>';
          $("#addplace"+current_clickday).append(html);
         // $("#data").data(current_clickday,locationMessage);
         // console.log($(span).data(value));
         //map을 활용하여 데이터 저장
         //$(Result).setnickName("aaa");
         //console.log($(Result).getnickName());
          aJson = new Object();
          aJson.day = current_clickday;
          console.log(current_clickday)
          aJson.place = locationMessage;
          aJsonArray.push(aJson);
          //JSON.stringify(aJson);
          console.log(aJson);
        });
      }
      
	 $(document).ready(function(){
		 $("#createschedule").click(function(){
			 console.log("createschedule clicked");
			 day++;
			 var html = '<div><button type="button" class="btn btn-info" id="day'+day+'"'+'>&nbsp;+&nbsp;Day&nbsp;'+day+'&nbsp;</button></div><br>';
			 var addplacehtml = '<div class="col-sm-1 sidnav" id="addplace'+day+'"'+'></div>'
			// $("#add").append(html);
			 $("#schedule_day").append(html);
			 $("#addplace").append(addplacehtml);
			 
			 if(day !=1){
				 $("#addplace"+day).hide();
				 console.log("day1이 아닐때");
			 }
			   
		 });
		 
		
		$(document).on("click","[id^=day]",function(){
			console.log("day button is clicked"+day);
			
			console.log($(this).attr('id'));
			console.log(day);
			
			var show = $(this).attr('id');
			console.log(show);
			
			current_clickday = show.substr(3, 1);
			
			console.log("current_clickday:"+current_clickday);
			
			for(var i=1;i<=day;i++){
				$("#addplace"+i).hide();
			}
			
			$("#addplace"+current_clickday).show();
	

		});

		 
		 /*
		 $(document).on("click","#day1",function(){
			 console.log("day1 is clicked");
			 current_clickday=1;
			 $("#addplace1").show();
			 $("#addplace2").hide();
			 $("#addplace3").hide();
		 });
		 

		 $(document).on("click","#day2" ,function(){
			 console.log("day2 is clicked");
			 current_clickday=2;
			 $("#addplace1").hide();
			 $("#addplace2").show();
			 $("#addplace3").hide();
		 });
		 
		 $(document).on("click","#day3" ,function(){
			 console.log("day3 is clicked");
			 current_clickday=3;
			 $("#addplace3").show();
			 $("#addplace1").hide();
			 $("#addplace2").hide();
			 
		 });*/
		 
		 $(document).on("click","#save",function(){
			 console.log("schedule save is clicked");
			 //console.log($("#addplace").text());
			 sJsonSchedule.plan = aJsonArray;
			
			 sJson= JSON.stringify(sJsonSchedule);
			 //console.log(aJsonArray);
			 console.log(sJson);
			 $("input[name=schedule_arr]").val(sJson);
			 $("input[name=schedule_lastday]").val(day);

		 });
		 
		 $(document).on("click","#delete",function(){
			 console.log("schedule delete is clicked");
			 $("#schedule_day").empty();
			 $("#addplace").empty();
			 day=0;
		 });
		 
		 
 
	 });
    </script>
    <script type="text/javascript" src = "/TravelPlanSystem/js/loginCheck.js"></script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD9Kp_3AojAwdwW7Cb0kgS8L6ZH_uJhDz8&callback=initMap">
    </script>
</body>
</html>