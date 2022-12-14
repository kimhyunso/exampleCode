create table member(
user_id varchar2(15) primary key,
user_pw varchar2(15) not null unique,
nickname varchar2(25) not null unique,
email varchar2(255) not null unique,
location varchar2(255) not null,
job varchar2(25) not null,
crt_date date
);

create table login(
user_id varchar2(15) primary key,
user_pw varchar2(15) not null unique,
nickname varchar2(25) not null unique,
delable number(1) default 0,
constraint login_id_fk foreign key(user_id) references member(user_id) on delete cascade,
constraint login_pw_fk foreign key(user_pw) references member(user_pw) on delete cascade
);

create table bord(
num number(10) primary key,
user_id varchar2(15) not null,
user_pw varchar2(15) not null,
nickname varchar2(25) not null,
img varchar2(255) not null ,
title varchar2(25) not null,
content varchar2(255) not null,
bord_view number(15) default 0,
co_date date,
constraint bord_id_fk foreign key(user_id) references login(user_id) on delete cascade,
constraint bord_pw_fk foreign key(user_pw) references login(user_pw) on delete cascade,
constraint bord_nickname_fk foreign key(nickname) references login(nickname) on delete cascade
);

create table bordreply(
user_id varchar2(15) not null,
user_pw varchar2(15) not null,
nickname varchar2(25) not null , 
num number(10) not null,
kind number(10) primary key,
img varchar2(255) not null,
content varchar2(255) not null,
re_date date,
reply_view number(15) default 0,
constraint num_fk foreign key(num) references bord(num) on delete cascade,
constraint reply_id_fk foreign key(user_id) references login(user_id) on delete cascade,
constraint reply_pw_fk foreign key(user_pw) references login(user_pw) on delete cascade,
constraint reply_nickname_fk foreign key(nickname) references login(nickname) on delete cascade
);

create sequence bordreply_seq;

create table list(
user_id varchar2(15) not null,
user_pw varchar2(15) not null,
nickname varchar2(25) not null ,
kind number(10) primary key,
count number(10) not null,
op varchar2(25) not null,
num number(15) not null,
constraint list_fk foreign key(num) references bord(num) on delete cascade,
constraint list_id_fk foreign key(user_id) references login(user_id) on delete cascade,
constraint list_pw_fk foreign key(user_pw) references login(user_pw) on delete cascade,
constraint list_nickname_fk foreign key(nickname) references login(nickname) on delete cascade
);

create sequence list_seq;

create table wishlist(
user_id varchar2(15) not null,
user_pw varchar2(15) not null,
nickname varchar2(25) not null ,
kind number(10) primary key,
count number(10) not null,
op varchar2(25) not null,
num number(15) not null,
grade number(1) not null,
constraint wishlist_fk foreign key(num) references bord(num) on delete cascade,
constraint wishlist_id_fk foreign key(user_id) references login(user_id) on delete cascade,
constraint wishlist_pw_fk foreign key(user_pw) references login(user_pw) on delete cascade,
constraint wishlist_nickname_fk foreign key(nickname) references login(nickname) on delete cascade
);
create sequence wishlist_seq;

commit;


