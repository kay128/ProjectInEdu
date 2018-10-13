drop table member cascade constraint;
drop table post cascade constraint;
drop table reply cascade constraint;
drop table rate cascade constraint;
drop table community cascade constraint;
drop table community_member cascade constraint;

/*회원정보 table*/
create table member(
   user_id varchar2(20) primary key,   --식별자
   pass varchar2(1000) not null,         --개인 확인_비밀번호
   name varchar2(20) not null,         --학생 이름
   grade_id number not null,         --JSL 기수
   email varchar2(40),               --email 수신 가능 주소
   phone varchar2(20),               --연락가능 휴대전화번호
   location varchar2(20),            --한국 내 출신 지역
   photo_or varchar2(100),            --사진 원본 이름
   photo_sa varchar2(100),            --사진 이름이 중복될 경우 변경 이름
   study_jp varchar2(100),            --일본어 최신 학습기록
   study_it varchar2(100),            --it 최신 학습 기록
   admin number                  --관리자 여부. 일반회원 0. 관리자 회원 1
);

/*게시물 table*/
create table post(
   post_id number primary key,         --게시글 식별자. 마지막 번호에서 +1하여 구분함
   user_id varchar2(80) not null,      --작성자 id
   regdate date default sysdate,      --작성일
   hit number default 0,            --조회수
   notice number default 0,         --공지글 여부. 일반글 0. 공지글 1
   title varchar2(1000),            --게시글 제목
   content varchar2(3500),            --게시글 내용
   image_or varchar2(100),            --게시글 삽입 사진 원본 이름
   image_sa varchar2(100),            --게시글 삽입 사진 이름이 중복될 경우 변경 이름
   board_name varchar2(100)          --게시판 구분
);

/*댓글 table*/
create table reply(
   reply_id number primary key,      -- 댓글 식별자. 마지막 번호에서 +1하여 구분함
   post_id number not null,         -- 댓글이 소속한 게시글 식별자. 참조키.
   user_id varchar2(20) not null,      -- 댓글 작성자 id
   reply_regdate date default sysdate,   -- 댓글 작성일
   lev number,                     -- 댓글 수준. 0 게시글에 대한 댓글. 1+a 댓글에 대한 댓글
   sort number,                  -- 정렬 순서. 새로 입력 시 최종 sort 값 +1 중간 입력시 sort값을 기준으로 하여 보다 큰 값을 +1
   reply_rate number default 0,      -- 댓글에 대한 추천 수
   content varchar2(1000),            -- 댓글 내용
   is_del number,                  -- 댓글 삭제 여부. 댓글 삭제시 '삭제된 댓글입니다'가 뜬다
   constraint p_id_fk               -- 참조키 설정. post 삭제시 해당 댓글은 전부 삭제되는 제약이 있음
   foreign key(post_id)
   references post(post_id)
   on delete cascade
);

/*댓글 추천 기록. 1명의 사용자가 1개의 댓글에 추천횟수를 1번으로 제한하는 데 사용*/
create table rate(
   user_id varchar2(40),            -- 추천인 id
   reply_id number,               -- 추천 대상 댓글 식별자
   constraint r_id_fk               -- 댓글 식별자 참조키. 댓글이 삭제시 해당 정보 연쇄 삭제 제약 설정
   foreign key(reply_id)
   references reply(reply_id)
   on delete cascade,
   constraint r_user_id_fk            -- 회원 식별자 참조키. 회원탈퇴시 해당 정보 연쇄 삭제 제약 설정
   foreign key(user_id)
   references member(user_id)
   on delete cascade
);

/*모임 정보 table*/
create table community(
   c_name   varchar2(80) primary key,   -- 모임 이름. 중복 불가.
   c_theme varchar2(1000),            -- 모임에 대한 간단한 소개
   c_date date default sysdate,         -- 모임 개설 일자
   c_master varchar2(20),            -- 모임 개설자. 참조키. 변경가능. 1인이 1개의 모임밖에 개설 불가하다.
   constraint c_id_fk               -- 모임 개설자 참조키. 개설자가 탈퇴시 해당 모임도 삭제된다.
   foreign key(c_master)
   references member (user_id)
   on delete cascade
);

/*모임 멤버 table*/
create table community_member(
   c_name varchar2(80),               -- 모임 이름. 참조키
   user_id varchar2(20),            -- 모임멤버 이름. 참조키
   c_favorite number default 0,         -- 모임 즐겨찾기 등록 여부. 0 즐겨찾기 아님. 1 즐겨찾기
   c_grade number default 0,         -- 일반회원/관리회원. 현재 기능과 무관. 기본값 0
   constraint c_name_fk1               -- 모임 이름 참조키. 모임이 삭제될 경우 멤버 기록이 삭제된다.
   foreign key(c_name)
   references community(c_name)
   on delete cascade,
   constraint cmember_id_fk1            -- 멤버 참조키. 회원탈퇴할 경우 모임 멤버 기록도 삭제된다.
   foreign key(user_id)
   references member(user_id)
   on delete cascade
);

insert all

   into member values('au','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
   into member values('cu','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
   into member values('du','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',0)
   into member values('eu','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
   into member values('fu','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
   into member values('gu','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',0)
   into member values('hu','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
   into member values('iu','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
   into member values('ju','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',0)
   into member values('ou','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
   into member values('uu','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
   
   into post values(1,'iu',sysdate,20,1,'야호','글글',null,null,'사가요')
   into post values(2,'au',sysdate,20,1,'야호','글글',null,null,'오사카 벚꽃')
   into post values(3,'hu',sysdate,20,1,'야호','글글',null,null,'도쿄 구루메')
   into post values(4,'iu',sysdate,20,1,'야호','글글',null,null,'후쿠오카 여름휴가')
   
   into post values(5,'iu',sysdate,20,1,'야호','글글',null,null,'free')
   into post values(6,'au',sysdate,20,1,'야호','글글',null,null,'free')
   into post values(7,'hu',sysdate,20,1,'야호','글글',null,null,'free')
   into post values(8,'iu',sysdate,20,1,'야호','글글',null,null,'free')
   into post values(9,'iu',sysdate,20,1,'야호','글글',null,null,'free')
   into post values(10,'au',sysdate,20,1,'야호','글글',null,null,'free')
   into post values(11,'hu',sysdate,20,1,'야호','글글',null,null,'free')
   into post values(12,'iu',sysdate,20,1,'야호','글글',null,null,'free')
   into post values(13,'iu',sysdate,20,1,'야호','글글',null,null,'free')
   into post values(14,'au',sysdate,20,1,'야호','글글',null,null,'exchange')
   into post values(15,'hu',sysdate,20,1,'야호','글글',null,null,'exchange')
   into post values(16,'iu',sysdate,20,1,'야호','글글',null,null,'exchange')
   into post values(17,'iu',sysdate,20,1,'야호','글글',null,null,'exchange')
   into post values(18,'au',sysdate,20,1,'야호','글글',null,null,'exchange')
   into post values(19,'hu',sysdate,20,1,'야호','글글',null,null,'exchange')
   into post values(20,'iu',sysdate,20,1,'야호','글글',null,null,'exchange')
   
   into reply values(1,1,'iu',sysdate,1,1,0,'좋아요', 0)
   into reply values(2,1,'ou',sysdate,1,2,0,'좋아요', 0)
   into reply values(3,1,'uu',sysdate,1,3,0,'좋아요', 0)
   into reply values(4,1,'iu',sysdate,1,4,0,'좋아요', 1)
   into reply values(5,1,'ou',sysdate,1,5,10,'좋아요', 0)
   into reply values(6,1,'uu',sysdate,1,6,0,'좋아요', 0)
   into reply values(7,1,'iu',sysdate,1,7,0,'좋아요', 0)
   into reply values(8,1,'ou',sysdate,1,8,0,'좋아요', 0)
   into reply values(9,1,'uu',sysdate,1,9,0,'좋아요', 0)
   into reply values(10,1,'iu',sysdate,1,10,0,'좋아요', 0)
   into reply values(11,1,'ou',sysdate,1,11,0,'좋아요', 0)
   into reply values(12,1,'uu',sysdate,1,12,0,'좋아요', 0)
   into reply values(13,1,'iu',sysdate,1,13,0,'좋아요', 0)
   into reply values(14,1,'ou',sysdate,1,14,0,'좋아요', 0)
   into reply values(15,1,'uu',sysdate,1,15,0,'좋아요', 0)
   into reply values(16,1,'iu',sysdate,1,16,0,'좋아요', 0)
   into reply values(17,1,'ou',sysdate,1,17,0,'좋아요', 0)
   into reply values(18,1,'uu',sysdate,1,18,0,'좋아요', 0)
   into reply values(19,1,'iu',sysdate,1,19,0,'좋아요', 0)
   into reply values(20,1,'ou',sysdate,1,20,0,'좋아요', 0)
   
   into rate values('au',5)
   into rate values('bu',5)
   into rate values('cu',5)
   into rate values('du',5)
   into rate values('eu',5)
   into rate values('fu',5)
   into rate values('gu',5)
   into rate values('hu',5)
   into rate values('iu',5)
   into rate values('ju',5)
   
   into community values('오사카 벚꽃', '오사카성으로', sysdate, 'au')
   into community values('도쿄 구루메', '월급날 만나요', sysdate, 'hu')
   into community values('후쿠오카 여름휴가', '살 좀 태워보자', sysdate, 'iu')
   
   into community_member values('오사카 벚꽃', 'bu', 1, 0)
   into community_member values('오사카 벚꽃', 'cu', 1, 0)
   into community_member values('오사카 벚꽃', 'du', 0, 0)
   into community_member values('오사카 벚꽃', 'eu', 1, 0)
   into community_member values('오사카 벚꽃', 'fu', 0, 0)
   into community_member values('오사카 벚꽃', 'gu', 0, 0)
   
   into community_member values('도쿄 구루메', 'bu', 1, 0)
   into community_member values('도쿄 구루메', 'cu', 0, 0)
   into community_member values('도쿄 구루메', 'du', 1, 0)
   into community_member values('도쿄 구루메', 'eu', 0, 0)
   into community_member values('도쿄 구루메', 'fu', 1, 0)
   into community_member values('도쿄 구루메', 'gu', 0, 0)
   
   into community_member values('후쿠오카 여름휴가', 'bu', 1, 0)
   into community_member values('후쿠오카 여름휴가', 'cu', 0, 0)
   into community_member values('후쿠오카 여름휴가', 'du', 1, 0)
   into community_member values('후쿠오카 여름휴가', 'eu', 1, 0)
   into community_member values('후쿠오카 여름휴가', 'fu', 0, 0)
   into community_member values('후쿠오카 여름휴가', 'gu', 1, 0)
   
select * from dual;

insert all
 
 
   into member values('bu0','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu0','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au1','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu1','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu1','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au2','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu2','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu2','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au3','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu3','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu3','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au4','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu4','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu4','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au5','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu5','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu5','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au6','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu6','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu6','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au7','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu7','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu7','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au8','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu8','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu8','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au9','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu9','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu9','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au10','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu10','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu10','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au11','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu11','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu11','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au12','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu12','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu12','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au13','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu13','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu13','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au14','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu14','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu14','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au15','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu15','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu15','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au16','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu16','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu16','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au17','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu17','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu17','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au18','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu18','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu18','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au19','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu19','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu19','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au20','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu20','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu20','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au21','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu21','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu21','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au22','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu22','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu22','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au23','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu23','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu23','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au24','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu24','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu24','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au25','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu25','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu25','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au26','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu26','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu26','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au27','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu27','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu27','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au28','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu28','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu28','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('au29','1234','김김',27,'123@123.123','123-123-1234','부산',null,null,'java_tutorial_op','japanese_tutorial_op',1)
   into member values('bu29','1234','이이',27,'123@123.123','123-123-1235','서울',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 into member values('cu29','1234', '박박',27,'123@123.123','123-123-1235','대전',null,null,'java_tutorial_op','japanese_tutorial_op',0)
 
 select * from dual;
 
 insert all 
   into community values('도쿄 구루메0','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu0')
 into community values('후쿠오카 여름휴가0','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu0')
 into community values('오사카 벚꽃1','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au1')
   into community values('도쿄 구루메1','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu1')
 into community values('후쿠오카 여름휴가1','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu1')
 into community values('오사카 벚꽃2','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au2')
   into community values('도쿄 구루메2','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu2')
 into community values('후쿠오카 여름휴가2','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu2')
 into community values('오사카 벚꽃3','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au3')
   into community values('도쿄 구루메3','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu3')
 into community values('후쿠오카 여름휴가3','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu3')
 into community values('오사카 벚꽃4','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au4')
   into community values('도쿄 구루메4','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu4')
 into community values('후쿠오카 여름휴가4','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu4')
 into community values('오사카 벚꽃5','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au5')
   into community values('도쿄 구루메5','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu5')
 into community values('후쿠오카 여름휴가5','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu5')
 into community values('오사카 벚꽃6','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au6')
   into community values('도쿄 구루메6','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu6')
 into community values('후쿠오카 여름휴가6','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu6')
 into community values('오사카 벚꽃7','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au7')
   into community values('도쿄 구루메7','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu7')
 into community values('후쿠오카 여름휴가7','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu7')
 into community values('오사카 벚꽃8','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au8')
   into community values('도쿄 구루메8','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu8')
 into community values('후쿠오카 여름휴가8','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu8')
 into community values('오사카 벚꽃9','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au9')
   into community values('도쿄 구루메9','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu9')
 into community values('후쿠오카 여름휴가9','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu9')
 into community values('오사카 벚꽃10','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au10')
   into community values('도쿄 구루메10','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu10')
 into community values('후쿠오카 여름휴가10','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu10')
 into community values('오사카 벚꽃11','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au11')
   into community values('도쿄 구루메11','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu11')
 into community values('후쿠오카 여름휴가11','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu11')
 into community values('오사카 벚꽃12','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au12')
   into community values('도쿄 구루메12','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu12')
 into community values('후쿠오카 여름휴가12','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu12')
 into community values('오사카 벚꽃13','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au13')
   into community values('도쿄 구루메13','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu13')
 into community values('후쿠오카 여름휴가13','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu13')
 into community values('오사카 벚꽃14','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au14')
   into community values('도쿄 구루메14','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu14')
 into community values('후쿠오카 여름휴가14','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu14')
 into community values('오사카 벚꽃15','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au15')
   into community values('도쿄 구루메15','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu15')
 into community values('후쿠오카 여름휴가15','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu15')
 into community values('오사카 벚꽃16','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au16')
   into community values('도쿄 구루메16','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu16')
 into community values('후쿠오카 여름휴가16','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu16')
 into community values('오사카 벚꽃17','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au17')
   into community values('도쿄 구루메17','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu17')
 into community values('후쿠오카 여름휴가17','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu17')
 into community values('오사카 벚꽃18','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au18')
   into community values('도쿄 구루메18','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu18')
 into community values('후쿠오카 여름휴가18','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu18')
 into community values('오사카 벚꽃19','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au19')
   into community values('도쿄 구루메19','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu19')
 into community values('후쿠오카 여름휴가19','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu19')
 into community values('오사카 벚꽃20','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au20')
   into community values('도쿄 구루메20','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu20')
 into community values('후쿠오카 여름휴가20','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu20')
 into community values('오사카 벚꽃21','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au21')
   into community values('도쿄 구루메21','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu21')
 into community values('후쿠오카 여름휴가21','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu21')
 into community values('오사카 벚꽃22','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au22')
   into community values('도쿄 구루메22','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu22')
 into community values('후쿠오카 여름휴가22','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu22')
 into community values('오사카 벚꽃23','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au23')
   into community values('도쿄 구루메23','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu23')
 into community values('후쿠오카 여름휴가23','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu23')
 into community values('오사카 벚꽃24','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au24')
   into community values('도쿄 구루메24','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu24')
 into community values('후쿠오카 여름휴가24','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu24')
 into community values('오사카 벚꽃25','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au25')
   into community values('도쿄 구루메25','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu25')
 into community values('후쿠오카 여름휴가25','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu25')
 into community values('오사카 벚꽃26','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au26')
   into community values('도쿄 구루메26','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu26')
 into community values('후쿠오카 여름휴가26','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu26')
 into community values('오사카 벚꽃27','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au27')
   into community values('도쿄 구루메27','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu27')
 into community values('후쿠오카 여름휴가27','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu27')
 into community values('오사카 벚꽃28','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au28')
   into community values('도쿄 구루메28','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu28')
 into community values('후쿠오카 여름휴가28','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu28')
 into community values('오사카 벚꽃29','오사카에서 뜨겁게 놀러 다닐 사람들의 모임!!!!! $!#&* 누구든 가입 환영합니다.', sysdate ,'au29')
   into community values('도쿄 구루메29','월급날 도쿄에서 밤새 도록 놀 사람들 구합니다 !!!  활발히 활동하시는 분들 환영합니다.',  sysdate ,'bu29')
 into community values('후쿠오카 여름휴가29','후쿠오카에서 여름휴가 제대로 놀아볼 사람들의 모임입니다. 남녀노소 어떤 분이든지 환영해요 !!! 언제든지 가입해주세요', sysdate ,'cu29')

select * from dual;

select max(post_id) from post;

insert into post values(((select max(post_id) from post)+1),'iu',sysdate,20,1,'야호','글글',null,null,'오예');

select max(reply_id) from reply;

update reply set sort = sort+1 where sort > 1;

insert into reply values(21,1,'ou',sysdate,1,2,0,'좋아요');

select * from reply order by sort;

update reply set is_del = 1 where reply_id=2;

update reply set sort = sort-1 where sort > 2;

delete from member where user_id = 'iu';

select * from community;
select * from community where c_date between to_date('20180703', 'yyyy-mm-dd') and to_date('20180706', 'yyyy-mm-dd');
select * from post order by user_id, regdate;

select * from post where title like '%야%' or content like '%야%';
select * from post where regdate = (select max(regdate) from post) and board_name='사가요';

select * from reply where post_id = (select post_id from post where board_name = '사가요') and user_id = 'iu';

select a.c_name, a.c_theme, a.c_date, a.c_master, (select count(user_id) from COMMUNITY_MEMBER)as count,b.user_id, b.c_favorit
   from COMMUNITY a, COMMUNITY_MEMBER b
   where a.c_name = b.c_name 
   and a.c_name = '후쿠오카 여름휴가';

select a.post_id, a.user_id as p_user_id, a.regdate, a.hit, 
   a.title, a.content as p_content, a.image, a.board_name,
   b.reply_id, b.user_id as r_user_id, b.reply_regdate, 
   b.lev, b.sort, b.reply_rate, b.content as r_content, b.is_del
   from post a, reply b where a.post_id = b.post_id and a.post_id = 1 order by b.sort;
   
select * from post a, reply b where post_id = 1 and a.post_id = b.post_id;
select * from post a left join reply b on a.post_id = b.post_id where a.post_id = 1;

select a.c_name, a.c_theme, a.c_date, a.c_master, (select count(user_id) from community_member where c_name = '오사카 벚꽃')as number from COMMUNITY a, COMMUNITY_MEMBER b where a.c_name = b.c_name and a.c_name = '오사카 벚꽃';

/*test*/
select a.c_name, a.c_theme, a.c_date, a.c_master, (select count(user_id) from COMMUNITY_MEMBER where c_name='오사카 벚꽃')as count,b.user_id, b.c_favorite from COMMUNITY a, COMMUNITY_MEMBER b where a.c_name = b.c_name and a.c_name = '오사카 벚꽃';

select distinct a.c_name, a.c_theme, a.c_date, a.c_master, (select count(user_id) from COMMUNITY_MEMBER where c_name='후쿠오카 여름휴가')as count
   from COMMUNITY a, COMMUNITY_MEMBER b
   where a.c_name = b.c_name 
   and c_date between to_date('2018-7-4', 'yyyy-mm-dd') and to_date('2018-7-8', 'yyyy-mm-dd');