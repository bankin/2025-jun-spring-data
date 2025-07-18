create table `ip-addresses` (
    id bigint not null auto_increment,
    country varchar(255),
    ip varchar(255),
    user_id bigint not null,
    primary key (id),
    foreign key fk_users_ip_addresses (user_id)
        references users(id)
);

-- INSERT INTO ip-addresses

alter table users
drop column ip_address;

