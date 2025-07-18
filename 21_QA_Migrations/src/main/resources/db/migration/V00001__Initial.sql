create table users (
   id bigint not null auto_increment,
   email varchar(255) not null,
   username varchar(255) not null,
   ip_address varchar(255),
   primary key (id)
);

alter table users
    add constraint uk_users_email unique (email);

alter table users
    add constraint uk_users_username unique (username);




