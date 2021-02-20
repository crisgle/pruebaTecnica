
create table users(username varchar_ignorecase(50) not null primary key,password varchar_ignorecase(500) not null,enabled boolean not null);
insert into users (username, password, enabled) values ('user', 'user', true);


insert into heroes (id,name,description)values(1, 'Superman','Description Superman');
insert into heroes (id,name,description)values(2, 'Batman','Description Batman');
insert into heroes (id,name,description)values(3, 'Spiderman','Description Spiderman');