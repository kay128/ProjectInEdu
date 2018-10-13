drop table customer cascade constraint;
drop table schedule cascade constraint;
drop table hotel cascade constraint;
drop table result cascade constraint;
drop table board cascade constraint;

drop sequence placeId_seq;
drop sequence hotelId_seq;
drop sequence resultId_seq;
drop sequence boardId_seq;
drop sequence boardGroupId_seq;

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
   placeName varchar2(80) unique,
   placeAddress varchar2(100) not null
);


create table hotel(
   hotelId number primary key, 
   hotelName varchar2(80) unique,
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
    boardTitle varchar2(80) not null,
    boardContent varchar2(2000) not null,
    boardDate varchar2(40) not null,
    boardHit number not null,
    boardGroup number,
    boardSequence number,
    boardLevel number,
    boardAvailable number
 );

insert all
   into customer values('jsl271@naver.com', '1234', '会員1', 'customer')
   into customer values('jsl272@naver.com', '1234', '会員2', 'customer')
   into customer values('jsl273@naver.com', '1234', '会員3', 'customer')
   into customer values('web@naver.com', '1234', '管理者', 'manager')
select * from DUAL;
   

insert into schedule values(placeId_seq.nextval, 34.687448, 135.526169, '大阪城', '大阪府大阪市中央区大阪城1-1');
insert into schedule values(placeId_seq.nextval, 34.665751, 135.432285, 'ユニバーサル・スタジオ・ジャパン', '大阪府大阪市此花区桜島2-1-33');
insert into schedule values(placeId_seq.nextval, 34.966908, 135.768618, '伏見稲荷大社', '京都府京都市伏見区深草薮之内町68番地');
insert into schedule values(placeId_seq.nextval, 34.995146, 135.785036, '清水寺', '京都府京都市東山区清水1丁目294');
insert into schedule values(placeId_seq.nextval, 34.839757, 134.693862, '姫路城', '兵庫県姫路市本町68');
insert into schedule values(placeId_seq.nextval, 34.685338, 135.843023, '奈良公園', '奈良県奈良市雑司町469');
   
insert into hotel values(hotelId_seq.nextval, 'ホテルサンルート大阪なんば', '大阪', 10000,'大阪府大阪市中央区日本橋１－１－１３', 3, 0);
insert into hotel values(hotelId_seq.nextval, 'ホテルモントレ グラスミア大阪', '大阪', 7000,'大阪市浪速区湊町１－２－３', 4, 0);
insert into hotel values(hotelId_seq.nextval, 'ピースホステル三条', '京都', 12000,'京都府京都市中京区富小路三条下る朝倉町５３１番地', 2, 0);
insert into hotel values(hotelId_seq.nextval, 'サクラテラスザギャラリー', '京都', 5000,'京都府京都市南区東九条上殿田町３９番地', 3, 0);
insert into hotel values(hotelId_seq.nextval, '奈良ホテル', '奈良',15000,'奈良県奈良市高畑町１０９６', 5, 0);
insert into hotel values(hotelId_seq.nextval, 'センチュリオンホテル クラシック 奈良', '奈良',8000,'奈良県奈良油阪町 1-51', 2, 0);
insert into hotel values(hotelId_seq.nextval, '福岡ヒルトンホテル', '福岡',10000,'福岡県福岡市中央区地行浜2-2-3', 5, 0);
insert into hotel values(hotelId_seq.nextval, '福岡 グランドハイアット', '福岡',9000,'福岡県福岡市博多区住吉1-2-82',2, 0);
insert into hotel values(hotelId_seq.nextval, '北海道ホテル森のスパリゾート', '北海道',17000,'北海道帯広市西7条南19丁目1番地',5, 0);
insert into hotel values(hotelId_seq.nextval, 'アリストンホテル宮崎', '宮崎',7000,'宮崎県宮崎市 橘通西３丁目１−１',3, 0);


insert into result(resultId, email, nickName, writeDate, scheduleTitle, placeName, visitDate, scheduleLastDay) values(resultId_seq.nextval, 'jsl271@naver.com', '会員1', sysdate, '旅行日和', '大阪城' , 1,3);
insert into result(resultId, email, nickName, writeDate, scheduleTitle, placeName, visitDate, scheduleLastDay) values(resultId_seq.nextval, 'jsl271@naver.com', '会員1', sysdate, '旅行日和','ユニバーサル・スタジオ・ジャパン', 1,3);
insert into result(resultId, email, nickName, writeDate, scheduleTitle, placeName, visitDate, scheduleLastDay) values(resultId_seq.nextval, 'jsl271@naver.com', '会員1', sysdate, '旅行日和','伏見稲荷大社', 2,3);
insert into result(resultId, email, nickName, writeDate, scheduleTitle, placeName, visitDate, scheduleLastDay) values(resultId_seq.nextval, 'jsl271@naver.com', '会員1', sysdate, '旅行日和','清水寺', 2,3);
insert into result(resultId, email, nickName, writeDate, scheduleTitle, placeName, visitDate, scheduleLastDay) values(resultId_seq.nextval, 'jsl271@naver.com', '会員1', sysdate, '旅行日和','奈良公園', 3,3);


insert into result(resultId, email, nickName, writeDate, hotelName, checkIn, checkOut) values(resultId_seq.nextval, 'jsl271@naver.com', '会員1', sysdate, 'サクラテラスザギャラリー', '2017-12-27', '2017-12-29');
insert into result(resultId, email, nickName, writeDate, hotelName, checkIn, checkOut) values(resultId_seq.nextval, 'jsl272@naver.com', '会員2', sysdate, 'サクラテラスザギャラリー', '2018-02-27', '2018-03-01');
insert into result(resultId, email, nickName, writeDate, hotelName, checkIn, checkOut) values(resultId_seq.nextval, 'jsl273@naver.com', '会員3', sysdate, 'サクラテラスザギャラリー', '2017-12-29', '2017-12-30');
insert into result(resultId, email, nickName, writeDate, hotelName, checkIn, checkOut) values(resultId_seq.nextval, 'jsl271@naver.com', '会員1', sysdate, '奈良ホテル', '2017-12-29', '2017-12-30');
insert into result(resultId, email, nickName, writeDate, hotelName, checkIn, checkOut) values(resultId_seq.nextval, 'jsl272@naver.com', '会員2', sysdate, '奈良ホテル', '2018-03-20', '2018-04-01');
insert into result(resultId, email, nickName, writeDate, hotelName, checkIn, checkOut) values(resultId_seq.nextval, 'jsl273@naver.com', '会員3', sysdate, '奈良ホテル', '2018-02-20', '2018-02-30');
insert into result(resultId, email, nickName, writeDate, hotelName, checkIn, checkOut) values(resultId_seq.nextval, 'jsl271@naver.com', '会員1', sysdate, 'ホテルサンルート大阪なんば', '2017-12-25', '2017-12-27');
insert into result(resultId, email, nickName, writeDate, hotelName, checkIn, checkOut) values(resultId_seq.nextval, 'jsl272@naver.com', '会員2', sysdate, 'ホテルサンルート大阪なんば', '2017-12-25', '2017-12-27');
insert into result(resultId, email, nickName, writeDate, hotelName, checkIn, checkOut) values(resultId_seq.nextval, 'jsl272@naver.com', '会員3', sysdate, 'ホテルサンルート大阪なんば', '2017-12-30', '2018-1-12');

insert into board values(boardId_seq.nextval, 'jsl271@naver.com', '大阪旅行に一緒に行く人を募集します！', 'こんにちは。私は29歳キム・ヒョンスンです。私はテクォンドーが得意です。日本語がある程度上達しているので日本旅行を楽しむのに問題ありません。私と一緒に旅行する人を探します。ありがとうございます。','2018/04/04 01:35:02', 0,boardGroupId_seq.nextVal,0,0,0);
insert into board values(boardId_seq.nextval, 'jsl271@naver.com', '奈良の有名な料理は何ですか。', '今度奈良に旅行しようと思っているんですが、「奈良でこれは絶対食べないと」と言う料理は何でしょうか。あ！そして宿泊の紹介もお願いします。','2018-03-03 11:12:52', 0,boardGroupId_seq.nextVal,0,0,0);
insert into board values(boardId_seq.nextval, 'jsl271@naver.com', '一緒に旅行に行こう！友よ!', 'こんにちは。30歳のチェ・ヒョンソプです。私は東京で働いてて日本語には自身があります。今回大阪に出張に行きますがついでに一緒に大阪を旅行する友達を探しています。大阪旅行は四度目なので道探しには自身があります。一緒に行きましょう！','2018-01-05 09:48:44', 0,boardGroupId_seq.nextVal,0,0,0);

update result set reviewGrade = 5, reviewContent = 'いいね' where email = 'jsl271@naver.com' and hotelName = 'ホテルサンルート大阪なんば';
update result set reviewGrade = 4, reviewContent = '気楽な所でした' where email = 'jsl272@naver.com' and hotelName = 'ホテルサンルート大阪なんば';
update result set reviewGrade = 4, reviewContent = 'また利用するうつもりです' where email = 'jsl273@naver.com' and hotelName = 'ホテルサンルート大阪なんば';
update result set reviewGrade = 4, reviewContent = 'いいね' where email = 'jsl271@naver.com' and hotelName = '奈良ホテル';
update result set reviewGrade = 3, reviewContent = '気楽な所でした' where email = 'jsl272@naver.com' and hotelName = '奈良ホテル';
update result set reviewGrade = 3, reviewContent = 'また利用するうつもりです' where email = 'jsl273@naver.com' and hotelName = '奈良ホテル';
update result set reviewGrade = 5, reviewContent = 'いいね' where email = 'jsl271@naver.com' and hotelName = 'サクラテラスザギャラリー';
update result set reviewGrade = 5, reviewContent = '気楽な所でした' where email = 'jsl272@naver.com' and hotelName = 'サクラテラスザギャラリー';
update result set reviewGrade = 4, reviewContent = 'また利用するうつもりです' where email = 'jsl273@naver.com' and hotelName = 'サクラテラスザギャラリー';
update hotel set avgReviewGrade = (select avg(reviewGrade) from result where hotelName='ホテルサンルート大阪なんば' and reviewGrade > 0) where hotelName='ホテルサンルート大阪なんば';
update hotel set avgReviewGrade = (select avg(reviewGrade) from result where hotelName='奈良ホテル' and reviewGrade > 0) where hotelName='奈良ホテル';
update hotel set avgReviewGrade = (select avg(reviewGrade) from result where hotelName='サクラテラスザギャラリー' and reviewGrade > 0) where hotelName='サクラテラスザギャラリー';