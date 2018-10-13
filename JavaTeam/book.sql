drop table book;

create table book(
	name varchar2(100) primary key,
	cost number not null,
	amount number not null,
	sale number not null,
	count number not null
);

insert all
		into book values('화차', 12000, 15, 0, 0)
		into book values('마지막여름의장미', 10000, 10, 0, 0)
		into book values('삼월은붉은구렁을', 9000, 20, 0, 0)
		into book values('왕국', 5000, 8, 0, 0)
		into book values('반짝반짝빛나는', 7000, 5, 0, 0)
		into book values('하악하악', 9000, 7, 0, 0)
		into book values('피를마시는새', 15000, 12, 0, 0)
		into book values('눈물을마시는새', 14000, 10, 0, 0)		
		into book values('종이여자', 11500, 5, 0, 0)
		into book values('구해줘', 10500, 4, 0, 0)
		into book values('보복대행전문주식회사', 10000, 8, 0, 0)
		into book values('나는공부를못해', 6500, 6, 0, 0)
		into book values('나는고양이로소이다', 8500, 7, 0, 0)
		into book values('채식주의자', 9000, 5, 0, 0)
		into book values('1Q84', 13500, 7, 0, 0)
		into book values('양을쫓는모험', 8500, 9, 0, 0)
		into book values('모방범', 9500, 4, 0, 0)
		into book values('악인', 10000, 8, 0, 0)
		into book values('메롱', 8000, 6, 0, 0)
		into book values('야시', 9000, 7, 0, 0)
		into book values('미움받을용기', 11000, 5, 0, 0)
		into book values('해리포터', 9900, 7, 0, 0)
		into book values('변신', 7000, 3, 0, 0)
		into book values('1984', 6500, 4, 0, 0)
		into book values('향수', 9500, 3, 0, 0)
		into book values('눈먼자들의도시', 11500, 7, 0, 0)
		into book values('죽음의중지', 10700, 3, 0, 0)
		into book values('JAVA의정석', 25000, 4, 0, 0)
		into book values('정보처리기사필기이론', 32000, 17, 0, 0)
		into book values('정보처리기사필기기출문제', 32000, 17, 0, 0)
		into book values('정보처리기사실기이론', 35000, 20, 0, 0)
		into book values('정보처리기사실기기출문제', 35000, 20, 0, 0)
		into book values('JLPT3급', 27000, 10, 0, 0)
		into book values('JLPT2급', 27000, 10, 0, 0)
		into book values('JLPT1급', 31000, 5, 0, 0)
		into book values('브레이킹던', 8500, 5, 0, 0)
		into book values('나미야잡화점의기적', 9000, 7, 0, 0)
		into book values('수상한식모들', 7500, 6, 0, 0)
		into book values('냉정과열정사이', 6500, 3, 0, 0)
		into book values('캐비닛', 6000, 7, 0, 0)
		into book values('왜나는너를사랑하는가', 10000, 3, 0, 0)
		into book values('JAVA의이해' , 22000, 5, 0, 0)
		select* from DUAL;