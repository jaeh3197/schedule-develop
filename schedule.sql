create table user
(
    created_at  datetime(6)  null,
    id          bigint auto_increment primary key,
    modified_at datetime(6)  null,
    email       varchar(255) not null,
    password    varchar(255) not null,
    username    varchar(255) not null,
    unique (email)
);

create table schedule
(
    created_at  datetime(6)  null,
    id          bigint auto_increment primary key,
    modified_at datetime(6)  null,
    user_id     bigint       null,
    contents    longtext     null,
    title       varchar(255) not null,
    foreign key (user_id) references user (id)
);