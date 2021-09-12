CREATE DATABASE springDemo

create table usersDemo(
id int  AUTO_INCREMENT  primary key,
name varchar(25) not null,
password varchar(20) not null,
create_time date
);

insert into usersDemo(name,password,create_time) values("Annie","123","2015-03-26");
insert into usersDemo(name,password,create_time) values("Tom","123","2015-03-26");
insert into usersDemo(name,password,create_time) values("Jack","123","2015-03-26");
insert into usersDemo(name,password,create_time) values("Bob","123","2015-03-26");
