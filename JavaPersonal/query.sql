drop table query;

create table query(
	id varchar2(13) not null,
	day varchar2(30) primary key,
	keyWord varchar2(20) not null,
	query varchar2(1000) not null,
	structure varchar2(1000) not null,
	explain varchar2(1000),
	constraint reference
	foreign key(id)
	references member(id) on delete cascade
);