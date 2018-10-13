drop table member cascade constraint;

create table member(
	id varchar2(13) primary key,
	pw varchar2(13) not null,
	name varchar2(16) not null,
	kind varchar2(10) not null,
	configWord varchar2(30)
);

insert all
	into member values('admin', 'jsl271234+', '관리자','manager',null)
	into member values('y32628', 'jsl271234+', '김아영','customer','코딩')
	into member values('y1234', 'jsl271234+', '김메롱','customer',null)
	into member values('y5678', 'jsl271234+', '김방방','customer','요정')
			select* from DUAL;
	