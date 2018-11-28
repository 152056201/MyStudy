CREATE TABLE admin(
	id 	varchar(20),
	password varchar(20),
	constraint pk_id primary key(id)
);
insert into admin(id,password) values('yuanhao','yh123');
insert into admin(id,password) values('yh123','yuanhao');
commit;

ALTER TABLE emp add(photo varchar(50) default 'nophoto.jpg');
ALTER TABLE emp add(note CLOB);
