drop table if exists adults cascade;

drop sequence if exists hibernate_sequence;

create sequence hibernate_sequence start 1 increment 1;

create table adults(
  id int8 not null,
  name varchar(2048),
  primary key (id)
);