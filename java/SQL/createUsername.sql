drop table if exists emp;
create table emp(
  empno int(4) primary key auto_increment,
  ename varchar(10) not null,
  hiredate varchar(10),
  sal varchar(10) 
);

insert into emp(ename,hiredate,sal) values('zhangsan','2017-7-12','6000')；

drop table if exists t_user;
create table t_user(
  username varchar(10) primary key ,
  password varchar(10) not null

);

insert into t_user values('zhangsan','123');