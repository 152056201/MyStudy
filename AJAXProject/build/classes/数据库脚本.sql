DROP DATABASE IF EXISTS ajax;
create database ajax character set utf8;
use ajax;
DROP table IF EXISTS member;

create table member(
	mid varchar(50),
	password varchar(32) not null,
	constraint pl_mid primary key(mid)
);
insert into member(mid,password) values('yuanhao','2c875b6c2a9cae9d989cc4d3fa85f21b');
insert into member(mid,password) values('hello','21232f297a57a5a743894a0e4a801fc3');