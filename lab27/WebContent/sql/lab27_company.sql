--on delete cascade 넣어주자

--drop
drop table company cascade constraint;
drop table recruit cascade constraint;
drop table favorite_company cascade constraint;
drop table rating cascade constraint;

--회사 정보를 저장하는 테이블--
create table company(
	company_id number primary key,	--회사id
	company_name varchar2(60) not null, --회사명
	read_count number default 0,	--회사 조회수
	company_logo varchar2(60),	--회사 로고
	company_type varchar2(60), --업종
	company_area varchar2(60), --분야
	company_ceo varchar2(60), --대표자명
	company_year number(4),	--설립연도
	company_page varchar2(60),	--홈페이지
	company_info varchar2(1500), --회사소개
	company_emp number, --사원 수
	company_money number, --매출액(숫자 그대로 집어넣고 vo에서 수정하는 메소드 만들것)
	company_cap number, --자본금
	company_loc varchar2(20), --소재지
	is_korea_ceo number(1) check(is_korea_ceo in (-1,1))--1한국계 0일본계
);

--채용 정보를 저장하는 테이블--
create table recruit(
	company_id number not null,	--회사 id
	start_day timestamp not null, --모집 시작일
	end_day timestamp not null,	--모집 마감일
	recuruit_id number primary key,	--채용 id
	recuruit_type varchar2(60), --직종
	recuruit_info varchar2(600), --업무내용
	recuruit_rtype varchar2(60), --채용형태
	recuruit_visa varchar2(60),--비자
	recuruit_pbt varchar2(60), --수습기간
	recruit_tr varchar2(60), --연수기간
	recruit_roc varchar2(90), --근무지
	recruit_time varchar2(60), --근무시간
	recruit_pay varchar2(60), --급여
	recruit_bonus varchar2(60),	--상여금
	recruit_benefit varchar2(60), --수당
	recruit_tray varchar2(60), --교통비
	recruit_ins varchar2(60), --보험
	recruit_vac varchar2(60), --휴가
	recruit_dom varchar2(60), --기숙사
	recruit_plane varchar2(60), --항공임
	recruit_domp varchar2(60), --본인부담금
	recruit_etc varchar2(600), --기타
	interview_1 varchar2(60), --1차전형
	interview_2 varchar2(60), --2차전형
	interview_3 varchar2(60), --3차전형
	interview_4 varchar2(60), --4차전형
	constraint company_fk foreign key (company_id) references company(company_id)
);

--관심기업를 저장하는 테이블--
create table favorite_company(
	user_id varchar2(20), --  유저 id
	company_id number,	 --회사 id
	constraint fovarite primary key(user_id, company_id),
	constraint company_fk2 foreign key (company_id) references company(company_id),
	constraint user_fk foreign key(user_id) references member(user_id)
);


--평점을 저장하는 테이블--
create table rating(
	user_id varchar2(20) not null,  	--유저 id
	rating_id number primary key,		--평점 id
	company_id number not null,			--회사 id
	rating_adv varchar2(600),			--회사 장점
	rating_disadv varchar2(600),		--회사 단점
	rating_star number default 0 check(rating_star in (1, 2, 3, 4, 5)),		--평점 
	rating_regdate timestamp default sysdate, --현재 시간
	constraint company_fk3 foreign key (company_id) references company(company_id),
	constraint user_fk2 foreign key(user_id) references member(user_id)
);


select TO_CHAR(rating_regdate, 'HH24:MI:SS') from rating;

--회사 정보 입력을 위한 데이터 삽입--
insert into company values((select count(*)+1 from company), '주식회사 CAL', 0, 'CAL.png',  '정보처리, 기계전기', 'IT, 기계', '이와사키 히로시', 1999, 'www.cal.co.jp', '2016년부터 한국인재를 채용하기 시작하여 현재 30명 이상을 채용하였습니다.<br>사업내용은 다음과 같습니다.<br> ■소프트웨어 설계개발, 네트워크, 인프라구축, 소프트평가·시험 <br> ■기계·기계설계, 전기·전자설계, 장치계발, 각종해석·실험', 350, 1869000000, 50000000, '오사카', -1);

insert into company values((select count(*)+1 from company), 'E-net', 0, 'enet.png',  '정보처리업', 'IT', '우케다 신지', 2000, 'www.e-net-1.com', '직원 평균연령 28세, 젊은 회사로 IT분야에서 활약하고 있고 우수한 서비스를 위해 사원들의 교육, 연수 시스템을 충실하게 일하고 있는 기업입니다.', 95, 430000000, 22000000, '도쿄', -1);
insert into company values((select count(*)+1 from company), '글로벌 사이버넷 시스템(GCS)', 0, 'GCS.png',  'IT', '소프트웨어 개발', '이광우', 2001, 'www.gcns.co.jp', '그룹 회사는 다음과 같습니다. <br> 누보사이버비즈니스, 파워소프트시스템, 크리에이티브소프트웨어시스템', 110, 0, 10000000, '도쿄', 1);
insert into company values((select count(*)+1 from company), '아이비넷(IBNET)', 0, 'IBINET.png',  '정보통신', '시스템개발, ec사업, 연구개발', '정희섭', 2003, 'www.ibi-net.co.jp', '1995년~2002년까지 오사카에서 설계한 시스템을 한국에서 프로그램제조/테스트하는 오프셰어 작업으로 성장해온 회사이며, 현재는 동경과 오사카를 중심으로 기업업무시스템의 WEB개발(JAVA/JSP, PHP, Oracle등)을 메인으로 사업하고 있습니다. 영업부가 특화되어있어 현재 정보교류중인 회사는 약 2000회사에 이르러 방대한 영업력을 가지고 있습니다. 15년연속 꾸준히 흑자를 내고 있으며 영업이익, 현금보유량등 재무상태는 상당히 양호합니다. <br> 회사의 복리제도로는 4대보험완비, 사원회, 기숙사, 사원여행등 기본적 복리후생제도는 물론, 차별화된 제도로서, 연2회(7월, 12월)의 상여금과 연 1회의 기말수당제도(3월) 그리고 서비스 잔업없는 100%잔업제도를 들 수 있습니다. 잔업제도는 효율적인 공정 관리를 위해 반드시 필요한 기본적인 복리후생제도인데, 저희 아이비넷은 월근무 일수와 상관없이 하루당 8시간을 초과하는 업무시간에 대해서는 무조건 100%잔업비가 지급되며, 야간업무, 휴일출근일경우는 1.25배씩 추가 지급됩니다.', 43, 0, 10000000, '도쿄, 오사카', 1);

insert into company values((select count(*)+1 from company), '주식회사 파워 소프트 시스템(PSS)', 0, 'pss.png',  'IT', '소프트웨어 개발', '이광우', 2008, 'www.psfs.biz/index_jp.php', '그룹 회사로 글로벌사이버넷시스템, 누보사이버비즈니스, 크리에이티브소프트웨어시스템이 있습니다.', 50, 0, 8000000, '도쿄', 1);
insert into company values((select count(*)+1 from company), '주식회사 TPS', 0, 'TPS.png',  'IT', '소프트웨어 개발, 시스템 개발', '김선태', 2001, 'www.tpsinc.co.jp', 'TPS의 경영이념은 [Top professional Solution]로<br>고객에게는 [Top professional Service]를<br>사원에게는 [Top professional Support]를 체재는 [Top professional System[을 입니다.', 105, 0, 30000000, '도쿄', 1);
insert into company values((select count(*)+1 from company), '모리시스템', 0, 'morisystem.jpg',  'IT', '시스템 설계, 개발', '김석환', 2014, 'www.morisystem.com', '프로젝트에 맞는 적절한 서비스로 모리시스템은 고객의 요구에 유연하게 대응합니다. 시스템의 설계부터 개발 보수까지 애플리케이션의 개발을 실시하는 백 오피스 업무로 항상 섬세하고 신속한 대응을 약속합니다. 이렇게 고객과 당사가 신뢰를 가지고 더 강하게 서로 보완함으로써 고객과 더 강하게 연결될 것이라고 생각합니다.', 50, 0, 30000000, '도쿄', 1);
select * from company;
--채용정보 입력을 위한 데이터 삽입--
insert into recruit values(1, SYSDATE, to_date('20180805170000', 'YYYYMMDDHH24MISS'), (select count(*)+1 from recruit), 'IT엔지니어','입사후, 일본생활연수, 비즈니스매너, 보안연수를 진행주요 개발분야는 JAVA, .NET등의 언어를 이용한 어플리케이션개발', '정규직', '취업비자', '3개월' , '약3개월(수습기간에 포함)', '도쿄, 삿포로, 요코하마, 나고야, 오사카, 후쿠오카(본인희망 참고)', '10:00 ~ 19:00(월~금)', '월 22만 8000엔 이상', '실적 상여', '잔업', '실비 지급','사회보험 완비', '토일 및 유급휴가, 출산휴가, 육아휴가 등', '기숙사 제공(기간 비공개)','지급', '3만8천엔/월(공동생활일 경우 있음)', '1. 임금: 월급 25만엔 보장 제도(3년 근속시 승급 보장)<br>2.입사시 개인 물품의 국제배송(EMS)비용으로 2만엔까지 지급<br>3.복리후생:사원기숙사 있음, FA제도, 자격 취득 지원 제도, 혹정 거출형연금<br> 4.JLPT N2이상 보유, 정보통신관련 학과인 경우 정보처리 필수 조건 아님','대인면접(그룹면접) ','일반교양시험, 자바기초시험, 적성검사, 작문' , '대인면접(그룹면접)', NULL);
insert into recruit values(2, SYSDATE, to_date('20180805170000', 'YYYYMMDDHH24MISS'), (select count(*)+1 from recruit), '시스템 소프트웨어 프로그래머','SE, PG(프로그래머), NE(네트워크 기술자) 기업 대상 시스템 개발에 관한 SES(SE서비스) 기업대상 업무 어플리케이션의 개발, 판매 및 서버, 네트워크 구축, 운영, 보수, Web어플리케이션 등', '정규직', '취업비자', '일본에서 10일간 인턴쉽(참가 후 내정 확정)' , '입사후 10일간', '도쿄', '9:30 ~ 18:30(월~금)', '2,460,000엔~2,520,000엔', '업무성과에 따라 지급(연 2회)', '잔업수당, 자격증 수당', '실비지급','있음', '토일 휴무 및 하계휴가, 연말 연시 유급 휴가', '2개월간','미제공', '무료(광열비는 반액 회사 부담)', '임금: 대학 졸업자 21만엔/단기대학(전문대학)졸업자 20만 5천엔<br> 교육/연수: 입사 전부터 IT관련 자격 취득 지원 있음<br> 직원 동아리 지원금(풋살부, 골프부, 탁구부, 온천부), 연 1회 사원 여행 있음. <br> 다음 조건을 충족하는 경우에는 2년간 주택수당(15,000엔)을 지급<br>-회사에서 알아봐준 주택으로 계약한 경우, <br>-주택이 회사까지 정기권으로 15,000엔 이내의 거리에 있을 경우','서류전형','화상 면접' , '필기시험 (일본어, IT)', '화상면접');
insert into recruit values(3, SYSDATE, to_date('20180706180000', 'YYYYMMDDHH24MISS'), (select count(*)+1 from recruit), '프로그래머','소프트웨어 개발 엔지니어', '정규직', '취업비자', '3개월', '약 3개월(수습기간에 포함)', '도쿄', '9:00~18:00', '월 23만엔 이상', NULL, '직급별, 가족, 육아, 잔업', '실비지급','건강보험', '경조일, 연말연시, GW, 하계휴가', '2년(상담 가능)','제공(입사시)', '4만엔 (3명 공동생활일 경우)', '1. 채용기준: 관련학과 전공자 및 산업기사 이상의 정보처리 자격증취득자<br>2. 잔업수당은 월 200시간을 써 초과하는 경우, [기본급 +200시간]으로 산출한 금액을 잔업수당으로 지급한다.<br>3.사원여행 회식, 여성사원모임 지원 있음.<br>4.연1회 종합건강검진 지원','서류전형','대면면접' , NULL, NULL);


select * from recruit;

--관심기업 데이터 삽입--
insert into favorite_company values('au', 4);
insert into favorite_company values('au', 5);
insert into favorite_company values('au', 6);
insert into favorite_company values('bu', 6);

select * from favorite_company;
--별점 데이터 삽입--
insert into rating values('au', (select count(*)+1 from rating), 5, '마냥 좋다', '마냥 싫다', 5, sysdate);
insert into rating values('au', (select count(*)+1 from rating), 5, '마냥 좋다', '마냥 싫다', 4, sysdate);
insert into rating values('au', (select count(*)+1 from rating), 5, '마냥 좋다', '마냥 싫다', 4, sysdate);
insert into rating values('bu', (select count(*)+1 from rating), 1, '마냥 좋다', '마냥 싫다', 5, sysdate);

--order by로 현재 채용 중인지를 찾을 때 count() where endday>sysdate() 등의 서브쿼리를 활용하자--
--정렬 하자 가져와야 할 것은 관심기업 여부, 모집 여부, 별점, 조회수, 코멘트 수, 로고, 고유번호 --

--별점 평균, 조회수, 댓글 수 로고, id, 관심기업 등록 여부, 현재 모집 여부를 현재 모집 여부와 관심 기업 등록 여부, 별점평균 순으로 정렬하여 가져오기
select * from (select company.company_id, company.company_logo, avg(rating.rating_star) as is_star, company.read_count, count(rating.company_id), nvl2(favorite_company.company_id, 1, 0) as is_like, nvl2(recruit.company_id, 1, 0) as is_now from company left outer join rating on company.company_id = rating.company_id left outer join favorite_company on company.company_id = favorite_company.company_id and favorite_company.user_id='au' left outer join recruit on company.company_id = recruit.company_id and recruit.end_day >= sysdate group by company.company_id, company.company_logo, company.read_count, favorite_company.company_id, recruit.company_id order by is_now desc, is_like desc, is_star desc nulls last) where rownum between 1 and 5;

select * from(select row_lecord.*, rownum from (select company.company_id, company.company_logo, avg(rating.rating_star) as is_star, company.read_count, count(rating.company_id), nvl2(favorite_company.company_id, 1, 0) as is_like, nvl2(recruit.company_id, 1, 0) as is_now from company left outer join rating on company.company_id = rating.company_id left outer join favorite_company on company.company_id = favorite_company.company_id and favorite_company.user_id='au' left outer join recruit on company.company_id = recruit.company_id and recruit.end_day >= sysdate group by company.company_id, company.company_logo, company.read_count, favorite_company.company_id, recruit.company_id order by is_now desc, is_like desc, is_star desc nulls last)row_lecord) where rownum between 1 and 5;

select * from (select company_record.*, rownum as rn from (select company.company_id, company.company_logo, avg(rating.rating_star) as star_avg, company.read_count, count(rating.company_id) as rating_count, nvl2(favorite_company.company_id, 1, 0) as is_pavorite, nvl2(recruit.company_id, 1, 0) as recruit_now from company left outer join rating on company.company_id = rating.company_id left outer join favorite_company on company.company_id = favorite_company.company_id left outer join recruit on company.company_id = recruit.company_id and recruit.end_day >= sysdate group by company.company_id, company.company_logo, company.read_count, favorite_company.company_id, recruit.company_id order by recruit_now desc, is_pavorite desc, star_avg desc nulls last)company_record) where rn between 1 and 5;
--상세보기 클릭 시



