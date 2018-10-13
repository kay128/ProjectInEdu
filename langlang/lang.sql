drop table student cascade constraint;
drop table manager cascade constraint;
drop table written cascade constraint;
drop table feedback cascade constraint;

create table student(
	email varchar2(80) primary key,
	pw varchar2(20) not null,
	name varchar2(20) not null,
	contry varchar2(80) not null,
	main_lang varchar2(80)
);

create table manager(
	email varchar2(80) primary key,
	pw varchar2(20) not null,
	message_email varchar2(80),
	message_content varchar2(3500),
	block_title varchar2(1000),
	block_email	varchar2(80)
);


create table written(
	res_id number primary key,
	name varchar2(80) not null,
	lang varchar2(80) not null,
	regdate date default sysdate,
	hit number default 0,
	title varchar2(1000),
	content varchar2(3500)
);

create table feedback(
	feedback_id number primary key,
	res_id number not null,
	feedback_name varchar2(80) not null,
	feedback_regdate date default sysdate,
	super_id number,
	lev number default 0,
	feedback_rate number not null,
	feedback_content varchar2(3500)
);
	
insert all
	into student values('123@123.123', '123', '123', 'en', 'ko')
	into student values('kkk@kkk.kkk', 'kkk', 'kkk', 'ko', 'js')
	into student values('jjj@jjj.jjj', 'jjj', 'jjj', 'js', 'en')
	into student values('qqq@qqq.qqq', 'qqq', 'qqq', 'js', 'ko')
	into written values( 1 , '123' , 'en' , sysdate , 0, 'hello' , 'hello' )
	into written values( 2 , 'kkk', 'en' , sysdate , 0,'yaho' , 'yaho' )
	into written values( 3 , 'jjj' , 'en' , sysdate , 0,'hooo' , 'hooo' )
	into written values( 4 , 'qqq', 'en' , sysdate , 0,'hello' , 'hello' )
	into written values( 5 , '123' , 'en' , sysdate , 0,'yaho' , 'yaho' )
	into written values( 6 , 'kkk' , 'en' , sysdate , 0,'hooo' , 'hooo' )
	into written values( 7 , 'jjj' , 'en' ,sysdate , 0,'hello' , 'hello' )
	into written values( 8 , 'qqq' , 'en' , sysdate , 0,'yaho' , 'yaho' )
	into written values( 9 , '123' , 'en' , sysdate , 0,'hooo' , 'hooo' )
	into written values( 10 , 'kkk' , 'en' , sysdate , 0,'hello' , 'hello' )
	into written values( 11 , 'jjj' , 'ko' , sysdate , 0,'yaho' , 'yaho' )
	into written values( 12 , 'qqq' , 'ko' , sysdate , 0,'hooo' , 'hooo' )
	into written values( 13 , '123' , 'ko' , sysdate , 0,'hello' , 'hello' )
	into written values( 14 , 'kkk' , 'ko' , sysdate , 0,'yaho' , 'yaho' )
	into written values( 15 , 'jjj' , 'ko' , sysdate , 0,'hooo' , 'hooo' )
	into written values( 16 , 'qqq' , 'ko' , sysdate , 0,'hello' , 'hello' )
	into written values( 17 , '123' , 'ko' , sysdate , 0,'yaho' , 'yaho' )
	into written values( 18 , 'kkk' , 'ko' , sysdate , 0,'hooo' , 'hooo' )
	into written values( 19 , 'jjj' , 'ko' , sysdate , 0,'hello' , 'hello' )
	into written values( 20 , 'qqq' , 'ko' , sysdate , 0,'yaho' , 'yaho' )
	into written values( 21 , '123' , 'js' , sysdate , 0,'hooo' , 'hooo' )
	into written values( 22 , 'kkk' , 'js' , sysdate , 0,'hello' , 'hello' )
	into written values( 23 , 'jjj' , 'js' , sysdate , 0,'yaho' , 'yaho' )
	into written values( 24 , 'qqq' , 'js' , sysdate , 0,'hooo' , 'hooo' )
	into written values( 25 , '123' , 'js' , sysdate , 0,'hello' , 'hello' )
	into written values( 26 , '123' , 'js' , sysdate , 0,'yaho' , 'yaho' )
	into written values( 27 , '123' , 'js' , sysdate , 0,'hooo' , 'hooo' )
	into written values( 28 , '123' , 'js' , sysdate , 0,'hello' , 'hello' )
	into written values( 29 , '123' , 'js' , sysdate , 0,'yaho' , 'yaho' )
	into written values( 30 , '123' , 'js' , sysdate , 0,'hooo' , 'hooo' )
	into written values (  31 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  32 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  33 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  34 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  35 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  36 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  37 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  38 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  39 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  40 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  41 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  42 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  43 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  44 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  45 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  46 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  47 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  48 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  49 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  50 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  51 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  52 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  53 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  54 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  55 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  56 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  57 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  58 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  59 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  60 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  61 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  62 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  63 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  64 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  65 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  66 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  67 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  68 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  69 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )
	into written values (  70 , '123' , 'en' , sysdate , 0 , 'hello' , 'hello' )

	into feedback values( 1 , 1 , 'kkk' , sysdate , 0 , 1 , 5, 'thanks' )
	into feedback values( 2 , 1 , 'jjj' , sysdate , 0 , 1 , 5, 'good' )
	into feedback values( 3 , 1 , 'qqq' , sysdate , 2 , 2 , 5, 'thanks' )
	into feedback values( 4 , 1 , 'kkk' , sysdate , 0 , 1 , 5, 'good' )
	into feedback values( 5 , 2 , 'jjj' , sysdate , 4 , 2 , 5, 'thanks' )
	into feedback values( 6 , 2 , '123' , sysdate , 0 , 1 , 5, 'good' )
	into feedback values( 7 , 2 , 'kkk' , sysdate , 0 , 1 , 5, 'thanks' )
	into feedback values( 8 , 2 , '123' , sysdate , 0 , 1 , 5, 'good' )
	into feedback values( 9 , 3 , 'qqq' , sysdate , 0 , 1 , 5, 'thanks' )
	into feedback values( 10 , 3 , 'kkk' , sysdate , 0 , 1 , 5, 'good' )
	into feedback values( 11 , 3 , 'jjj' , sysdate , 0 , 1 , 5, 'thanks' )
	into feedback values( 12 , 3 , 'qqq' , sysdate , 0 , 1 , 5, 'good' )
	into feedback values( 13 , 4 , 'kkk' , sysdate , 0 , 1 , 5, 'thanks' )
	into feedback values( 14 , 4 , 'jjj' , sysdate , 0 , 1 , 5, 'good' )
	into feedback values( 15 , 4 , 'qqq' , sysdate , 0 , 1 , 5, 'thanks' )
	into feedback values( 16 , 4 , 'kkk' , sysdate , 0 , 1 , 5, 'good' )
	into feedback values( 17 , 5 , 'jjj' , sysdate , 0 , 1 , 5, 'thanks' )
	into feedback values( 18 , 5 , 'qqq' , sysdate , 0 , 1 , 5, 'good' )
	into feedback values( 19 , 5 , 'kkk' , sysdate , 0 , 1 , 5, 'thanks' )
	into feedback values( 20 , 5 , 'jjj' , sysdate , 0 , 1 , 5, 'good' )
	into feedback values( 21 , 6 , 'qqq' , sysdate , 0 , 1 , 5, 'thanks' )
	into feedback values( 22 , 6 , 'kkk' , sysdate , 21 , 2 , 5, 'good' )
	into feedback values( 23 , 6 , 'jjj' , sysdate , 21 , 2 , 5, 'thanks' )
	into feedback values( 24 , 6 , 'qqq' , sysdate , 21 , 2 , 5, 'good' )
	into feedback values( 25 , 7 , 'kkk' , sysdate , 21 , 2 , 5, 'thanks' )
	into feedback values( 26 , 7 , 'jjj' , sysdate , 21 , 2 , 5, 'good' )
	into feedback values( 27 , 7 , 'qqq' , sysdate , 21 , 2 , 5, 'thanks' )
	into feedback values( 28 , 7 , 'kkk' , sysdate , 21 , 2 , 5, 'good' )
	into feedback values( 29 , 8 , 'jjj' , sysdate , 21 , 2 , 5, 'thanks' )
	into feedback values( 30 , 8 , 'qqq' , sysdate , 21 , 2 , 5, 'good' )
	
select * from DUAL;

select * from written;

select a.res_id, name, lang, regdate, hit, title, content, feedback_id, feedback_name, super_id, lev, feedback_rate, feedback_content  from written a, feedback b where a.res_id = b.res_id and a.res_id=1 order by lang, res_id desc;

select a.res_id as res_id, a.name, a.lang, a.regdate, a.hit, a.title, a.content, 
			b.feedback_id, b.feedback_name, b.feedback_regdate, b.super_id, b.lev, b.feedback_rate, b.feedback_content
			from written a left join feedback b
			on a.res_id = b.res_id where a.res_id=1;