/* schedule.sql */

show tables;

create table schedule (
  idx   int not null auto_increment primary key,
  memberIdx int not null,
  mid   varchar(20) not null,   /* 회원 아이디(일정검색시 필요) */
  sDate datetime not null,			/* 일정 등록 날짜 */
  part	varchar(10) not null,		/* 분류(1.모임, 2.업무, 3.학습, 4.여행, 5:기타) */
  content text not null,					/* 일정 상세내역 */
  foreign key(mid,memberIdx) references member(mid, idx)
);
desc schedule;
drop table schedule;

