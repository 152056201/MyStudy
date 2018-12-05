create table Provincial(
	pid int not null,
	title varchar(50),
	constraint pk_pid primary key(pid)
);


create table City(
	cid int not null,
	city varchar(50) primary key,
	pid int not null,
	constraint fk_cid foreign key(pid) references Provincial(pid)
);