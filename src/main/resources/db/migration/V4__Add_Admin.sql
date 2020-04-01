drop table if exists usr cascade;
drop table if exists user_role cascade;

insert into usr (id, active, password, username) values (2, true, '1', 'adm');

insert into user_role (user_id, roles) values (1, 'ADMIN');
insert into user_role (user_id, roles) values (2, 'USER');