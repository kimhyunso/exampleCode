create table member(
user_id varchar2(10) not null unique,
user_pw varchar2(10) not null unique,
user_nicname varchar2(10) not null unique,
email varchar2(255) not null unique,
loc varchar2(255) not null,
job varchar2(255) not null,
jumin number(13) primary key,
cr_date date
);

create table login(
num number(10) primary key,
user_id varchar2(10) not null unique ,
user_pw varchar2(10) not null unique ,
user_nicname varchar2(10) not null unique,
constraint user_name_fk foreign key(user_nicname) references member(user_nicname) on delete cascade,
constraint user_id_fk foreign key(user_id) references member(user_id) on delete cascade,
constraint user_pw_fk foreign key(user_pw) references member(user_pw) on delete cascade
);

create table board(
v_count number(5)  default 0,
title varchar2(255) not null,
ul_time date,
content varchar(255) not null,
img varchar(255) not null,
cate varchar(255) not null,
num number(10) primary key
);