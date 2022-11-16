create table product
(
    id        bigint auto_increment,
    name      varchar(100),
    image_url varchar(300),
    price     bigint,
    quantity  bigint,
    category  varchar(100),
    primary key (id)
);