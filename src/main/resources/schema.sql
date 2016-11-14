create table clients (
pesel bigint(11) NOT NULL,
name varchar(50)  NOT NULL,
surname varchar(50)  NOT NULL,
primary key(pesel)
);

create table accounts (
pesel bigint(11) NOT NULL,
currency char(3) NOT NULL,
number bigint(10) NOT NULL,
balance double(10) NOT NULL,
primary key(number),
foreign key(pesel)
REFERENCES public.clients(pesel)
);

create table deposits (
pesel bigint(11),
currency char(3),
number bigint(10),
balance double(10),
period varchar(20),
rate double(5),
opening_date date,
primary key(number),
foreign key(pesel)
REFERENCES public.clients(pesel)
);

create table deposits_definitions (
deposit_type varchar (40),
name varchar(40),
starting_date date,
rate double,
primary key(name)
);

create table currencies (
definition_name varchar NOT NULL,
currency char(3),
primary key (definition_name, currency),
foreign key (definition_name)
REFERENCES public.deposits_definitions(name)
);

create table ranges (
definition_name varchar NOT NULL,
minimum int,
rate double,
primary key(definition_name, minimum),
foreign key (definition_name)
REFERENCES public.deposits_definitions(name)
);

create table periods (
definition_name varchar NOT NULL,
period varchar,
primary key (definition_name, period),
foreign key (definition_name)
REFERENCES public.deposits_definitions(name)
);












