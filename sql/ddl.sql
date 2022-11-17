create table product
(
    id        bigint not null auto_increment,
    name      varchar(100) not null,
    image_url varchar(300),
    price     bigint,
    quantity  bigint,
    category  varchar(100),
    primary key (id)
);