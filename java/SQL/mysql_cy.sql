use cy;
drop table if exists t_student;
drop table if exists t_class;
create table t_class(
  cid int(3) primary key,
  cname varchar(24) not null unique
 );
create table t_student(
  sid int(6) primary key auto_increment,
  sname varchar(24),
  cid int(3),
  constraint t_student_FK_to_t_class 
  foreign key (cid) references t_class(cid)
 );
insert into t_class(cid,cname)values(100,'一中');
insert into t_class(cid,cname)values(200,'二中');
insert into t_class(cid,cname)values(300,'三中');

insert into t_student(sname,cid)values('赵',100);
insert into t_student(sname,cid)values('钱',200);
insert into t_student(sname,cid)values('孙',300);
insert into t_student(sname,cid)values('李',300);
insert into t_student(sname,cid)values('周',100);
insert into t_student(sname,cid)values('吴',100);
insert into t_student(sname,cid)values('郑',200);
insert into t_student(sname,cid)values('王',200);

select * from t_student;
select s.sid,s.sname,c.cname from t_student s 
  join t_class c on s.cid=c.cid order by c.cid ;