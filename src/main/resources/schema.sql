create table clients (
pesel bigint(11),
name varchar(50),
surname varchar(50)
);


create table accounts (
pesel bigint(11),
currency char(3),
number int(10),
balance double(10)
);

create table deposits (
pesel bigint(11),
currency char(3),
number int(10),
balance double(10),
period varchar(20),
rate double(5),
opening_date date
);

