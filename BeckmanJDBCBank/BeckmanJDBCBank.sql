create schema if not exists bankapp authorization kittycat;
set search_path to bankapp;


create table customer(
cid serial primary key not null,
cfirst_name varchar(20) not null,
clast_name varchar(20) not null,
cusername varchar(20) not null unique,
cpassword varchar(20) not null
);

create table admin_empl(
aid serial primary key not null,
afirst_name varchar(20) not null,
alast_name varchar(20) not null,
ausername varchar(20) not null unique,
apassword varchar(20) not null
);

create table account(
acct_id serial primary key not null,
cid int not null,
acct_type varchar(15)  not null,
balance numeric(100,2),
foreign key (cid) references customer(cid) on delete cascade
);

create type acct_type as enum('checking', 'savings');


create table logs(
cid int not null,
dated date not null,
logger varchar(50) not null,
level_type varchar(10) not null,
message varchar(100) not null,
foreign key (cid) references customer(cid) on delete cascade
);

create table account_user(
cid int,
acct_id int,
foreign key (cid) references customer(cid) on delete cascade,
foreign key (acct_id) references account(acct_id) on delete cascade
);



select * from account;
select * from customer;
