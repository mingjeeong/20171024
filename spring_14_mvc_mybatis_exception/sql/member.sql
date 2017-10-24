drop table member;
drop table memberpoint;

create table member(
	id varchar2(20) primary key,
	password varchar2(20) not null,
	name varchar2(20) not null,
	address varchar2(50) not null
);

create table memberpoint( 
	info varchar2(30) NOT NULL,
	point number(5) NOT NULL 
);
      
select * from member;
select * from memberpoint; 

