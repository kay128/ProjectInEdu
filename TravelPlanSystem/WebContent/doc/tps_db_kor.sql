drop table customer cascade constraint;
drop table schedule cascade constraint;
drop table hotel cascade constraint;
drop table result cascade constraint;


drop sequence placeId_seq;
drop sequence hotelId_seq;
drop sequence resultId_seq;
drop sequence boardId_seq;


create sequence placeId_seq minvalue 0;
create sequence hotelId_seq minvalue 0;
create sequence resultId_seq minvalue 0;
create sequence boardId_seq minvalue 0;
create sequence boardGroupId_seq minvalue 0;


create table customer(
	email varchar2(40) primary key,
	pass varchar2(20) not null,
	nickName varchar2(20) unique,
	authority varchar2(20) default 'customer',
	constraint auth check (authority in('customer','manager'))
);


create table schedule(
	placeId number primary key,
	logitude number not null,
	latitude number not null,
	placeName varchar2(40) unique,
	placeAddress varchar2(100) not null
);


create table hotel(
	hotelId number primary key, 
	hotelName varchar2(40) unique,
	hotelCity varchar2(20) not null,
	hotelPrice number not null,
	hotelAddress varchar2(100) not null,
	quality number not null,
	avgReviewGrade number default 0
);

create table result(
	resultId number primary key,
	email varchar2(40) not null,
	nickName varchar2(20) not null,
	writeDate varchar2(40) not null,
	scheduleTitle varchar2(40),
	scheduleLastDay number,
	placeName varchar2(80),
	visitDate number,
	hotelName varchar2(40),
	checkIn varchar2(20),
	checkOut varchar2(20),
	reviewGrade number default 0,
	reviewContent varchar2(1000)
);

create table board(
 	boardId number primary key,
 	userEmail varchar2(40) not null,
 	boardTitle varchar2(40) not null,
 	boardContent varchar2(2000) not null,
 	boardDate varchar2(40) not null,
 	boardHit number not null,
 	boardGroup number,
 	boardSequence number,
 	boardLevel number,
 	boardAvailable number
 );


insert all
	into customer values('jsl271@naver.com', '1234', '고객1', 'customer')
	into customer values('jsl272@naver.com', '1234', '고객2', 'customer')
	into customer values('jsl273@naver.com', '1234', '고객3', 'customer')
	into customer values('web@naver.com', '1234', '관리자', 'manager')
select * from DUAL;
	

insert into schedule values(placeId_seq.nextval, 34.687448, 135.526169, '오사카성', '1-1 Osakajo, Chuo, Osaka, Osaka Prefecture 540-0002 Japan');
insert into schedule values(placeId_seq.nextval, 34.665751, 135.432285, '유니버설 스튜디오 재팬', '2 Chome-1-33 Sakurajima, Konohana Ward, Osaka, Osaka Prefecture 554-0031 Japan');
insert into schedule values(placeId_seq.nextval, 34.966908, 135.768618, '후시미이나리 신사', '68 Kyōto-fu, Kyōto-shi, Fushimi-ku, Fukakusa Yabunouchichō, Japan');
insert into schedule values(placeId_seq.nextval, 34.995146, 135.785036, '기요미즈데라', '294 Kiyomizu 1-chome, Higashiyama Ward, Kyoto, Kyoto Prefecture 605-0862 Japan');
insert into schedule values(placeId_seq.nextval, 34.839757, 134.693862, '히메지성', '68 Honmachi, Himeji-shi, Hyōgo-ken 670-0012 Japan');
insert into schedule values(placeId_seq.nextval, 34.685338, 135.843023, '나라공원', '30 Noborioji-cho, Nara City 630-8501');
	
insert into hotel values(hotelId_seq.nextval, '호텔 선루트 오사카 난바', '오사카', 100000,'Nippombashi 1-1-13, 추오, 오사카, 일본', 3, 0);
insert into hotel values(hotelId_seq.nextval, '호텔 몬토레그라스미아오사카', '오사카', 70000,'1-2-3, Minatomachi, 나니와, 오사카, 일본', 4, 0);
insert into hotel values(hotelId_seq.nextval, '피스 호스텔 산조', '교토', 120000,'531, Asakura-cho, Tominokoji Sanjo Sagaru, 나카교구, 교토, 일본', 2, 0);
insert into hotel values(hotelId_seq.nextval, '사쿠라 테라스 더 갤러리', '교토', 50000,'Minamiku Higashikujyo Kamitonodacho 39, 미나미구, 교토, 일본', 3, 0);
insert into hotel values(hotelId_seq.nextval, '나라 호텔', '나라',150000,'1096 Takabatake Cho, 나라, 일본', 5, 8.9);

insert into result(resultId, email, nickName, writeDate, scheduleTitle, placeName, visitDate, scheduleLastDay) values(resultId_seq.nextval, 'jsl271@naver.com', '고객1', '17/10/5', '떠나고싶은 날 1', '오사카성' , 1,3);
insert into result(resultId, email, nickName, writeDate, scheduleTitle, placeName, visitDate, scheduleLastDay) values(resultId_seq.nextval, 'jsl271@naver.com', '고객1', '17/10/5', '떠나고싶은 날 1','유니버설 스튜디오 재팬', 1,3);
insert into result(resultId, email, nickName, writeDate, scheduleTitle, placeName, visitDate, scheduleLastDay) values(resultId_seq.nextval, 'jsl271@naver.com', '고객1', '17/10/5', '떠나고싶은 날 1','후시미이나리 신사', 2,3);
insert into result(resultId, email, nickName, writeDate, scheduleTitle, placeName, visitDate, scheduleLastDay) values(resultId_seq.nextval, 'jsl271@naver.com', '고객1', '17/10/5', '떠나고싶은 날 1','기요미즈데라', 2,3);
insert into result(resultId, email, nickName, writeDate, scheduleTitle, placeName, visitDate, scheduleLastDay) values(resultId_seq.nextval, 'jsl271@naver.com', '고객1', '17/10/5', '떠나고싶은 날 1','나라공원', 3,3);

insert into result(resultId, email, nickName, writeDate, hotelName, checkIn, checkOut) values(resultId_seq.nextval, 'jsl271@naver.com', '고객1', '17/10/5', '호텔 선루트 오사카 난바', '17/12/25', '17/12/27');
insert into result(resultId, email, nickName, writeDate, hotelName, checkIn, checkOut) values(resultId_seq.nextval, 'jsl271@naver.com', '고객1', '17/10/5', '사쿠라 테라스 더 갤러리', '17/12/27', '17/12/29');
insert into result(resultId, email, nickName, writeDate, hotelName, checkIn, checkOut) values(resultId_seq.nextval, 'jsl271@naver.com', '고객1', '17/10/5', '나라 호텔', '17/12/29', '17/12/30');
insert into result(resultId, email, nickName, writeDate, hotelName, checkIn, checkOut) values(resultId_seq.nextval, 'jsl272@naver.com', '고객2', '17/10/5', '호텔 선루트 오사카 난바', '17/12/25', '17/12/27');

insert into board values(boardId_seq.nextval, 'jsl271@naver.com', '오사카 여행 같이할 친구 구합니다!', '안녕하세요! 저는 29살 김현승입니다. 저는 태권도가 주특기입니다.일본어도 상급이어서 일본여행을 즐기는 것에 문제가 없습니다. 저랑같이 여행할 친구구합니다. 감사합니다!','2018/04/04 01:35:02', 0,boardGroupId_seq.nextVal,0,0,0);
insert into board values(boardId_seq.nextval, 'jsl271@naver.com', '나라에서 유명한 음식이 무엇인가요?', '이번에 나라에 여행 갈려고하는데 나라에서 꼭 먹어야할 요리는 무엇인가요? 아! 그리고 숙박도 추천해주세요!','2018-03-03 11:12:52', 0,boardGroupId_seq.nextVal,0,0,0);
insert into board values(boardId_seq.nextval, 'jsl271@naver.com', '여행 같이 가자 친구야!', '안녕하세요 30살 채형섭입니다. 저는 도쿄에서 일하고있어서 일본어는 능숙합니다. 이번에 오사카로 출장가는데  같이 오사카 여행할 친구 구합니다. 오사카에 3번 여행한적이 있어서 지리는 모두알고 있습니다. 같이갑시다!! ','2018-01-05 09:48:44', 0,boardGroupId_seq.nextVal,0,0,0);


update result set reviewGrade = 5, reviewContent = '좋아요' where email = 'jsl271@naver.com' and hotelName = '호텔 선루트 오사카 난바';

update hotel set avgReviewGrade = (select avg(reviewGrade) from result where hotelName='호텔 선루트 오사카 난바') where hotelName='호텔 선루트 오사카 난바';

update table result set(reviewGrade = 5, reviewContent = '좋아요') where email = 'jsl271@naver.com' and hotelName = '사쿠라 테라스 더 갤러리';

update table result set(reviewGrade = 5, reviewContent = '좋아요') where email = 'jsl271@naver.com' and hotelName = '나라 호텔';

select a.email, a.nickName, a.writeDate, a.scheduleTitle, a.visitDate, a.placeName, b.logitude, b.latitude, b.placeAddress
	   from	result a, schedule b
	   where a.placeName = b.placeName(+) and email = 'jsl271@naver.com' and scheduleTitle = '떠나고싶은 날 1' order by visitDate ASC;

	   
select a.email, a.nickName, a.writeDate, a.hotelName, a.checkIn, a.checkOut, a.reviewGrade, a.reviewContent, c.hotelAddress, c.hotelPrice, c.quality, c.avgReviewGrade
	   from	result a, hotel c
	   where a.hotelName = c.hotelName(+) and email = 'jsl271@naver.com' and checkIn between '17/12/25' and '17/12/29' order by checkIn ASC;

	   
select a.email, a.nickName, a.writeDate, a.scheduleTitle, a.visitDate, a.placeName, b.logitude, b.latitude,
	   b.placeAddress, a.hotelName, a.checkIn, a.checkOut, a.reviewGrade, a.reviewContent, c.hotelAddress, c.hotelPrice, c.quality, c.avgReviewGrade
	   from	result a, schedule b, hotel c
	   where a.placeName = b.placeName(+) and a.hotelName = c.hotelName(+);


select c.hotelName, c.hotelAddress, c.hotelPrice, c.quality, c.avgReviewGrade, a.nickName, a.reviewGrade, 
	a.reviewContent from result a, hotel c where a.hotelName(+) = c.hotelName and c.hotelName = '호텔 선루트 오사카 난바';
	
	
select distinct scheduleTitle from result where email='jsl271@naver.com';

select * from result where hotelName = '나라 호텔';