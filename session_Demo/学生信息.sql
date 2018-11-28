CREATE TABLE student(
	num varchar(10),
	name varchar(10),
	gander varchar(2),
	birth DATE,
	phone varchar(11),
	address varchar(20),
	CONSTRAINT pk_num primary key(num)
);
commit;
insert into student(num,name,gander,birth,phone,address) values('152056201','袁浩','男',to_date('1997-03-12','yyyy-mm-dd'),'18902187323','26号楼224宿舍');
insert into student(num,name,gander,birth,phone,address) values('152056202','梅西','男',to_date('1991-07-12','yyyy-mm-dd'),'12302187323','23号楼274宿舍');
insert into student(num,name,gander,birth,phone,address) values('152056203','C罗','男',to_date('1990-08-12','yyyy-mm-dd'),'18356895014','21号楼324宿舍');
insert into student(num,name,gander,birth,phone,address) values('152056204','科比','男',to_date('1987-03-30','yyyy-mm-dd'),'17892447895','18号楼333宿舍');