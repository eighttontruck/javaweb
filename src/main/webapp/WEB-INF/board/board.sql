show tables;

create table board(
	idx int not null auto_increment,
	mid varchar(20) not null,
	nickName varchar(20) not null,
	title varchar(100) not null,
	email varchar(50),
	homePage varchar(50),
	content text not null, 
	readNum int default 0,
	hostIp varchar(40) not null,
	openSw char(2) default 'OK',
	wDate datetime default now(),
	good int default 0,
	primary key(idx)
);

insert into board values(default,'admin','관리맨','게시판 서비스를 시작합니다.','2ju4885@naver.com','www.naver.com','이곳은 게시판 입니다.',default,'192,168.50.99',default,default,default);

select * from board;