create table clients (
pesel bigint(11) NOT NULL,
name varchar(50)  NOT NULL,
surname varchar(50)  NOT NULL,
primary key(pesel)
);

create table accounts (
pesel bigint(11) NOT NULL,
currency char(3) NOT NULL,
number int(10) NOT NULL,
balance double(10) NOT NULL,
primary key(number),
foreign key(pesel)
REFERENCES public.clients(pesel)
);

create table deposits (
pesel bigint(11),
currency char(3),
number int(10),
balance double(10),
period varchar(20),
rate double(5),
opening_date date,
primary key(number),
foreign key(pesel)
REFERENCES public.clients(pesel)
);

create table deposits_definitions (
def_name varchar(20),
ranges_list array(50),
currency_list array(50),
period_list array(50),
starting_date date,
rate double(5),
primary key(def_name)
);





