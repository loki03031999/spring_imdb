--drop database test;
use test;

create table a(
a_id int,
a_name varchar(255)
);

create table b(
b_id int,
b_name varchar(255)
);

create table a_b(
a_id int,
b_id int,
constraint PK_a_b primary key(a_id,b_id),
constraint FK_a foreign key(a_id) references a(a_id),
constraint FK_b foreign key(b_id) references b(b_id)
);

describe a;
describe b;
describe a_b;