drop table if exists  price;
create table price (
	brand_id int primary key not null auto_increment,
    starte_date TIMESTAMP ,
    end_date TIMESTAMP ,
    price_list double,
    product_id varchar(100),
    priority int,
    price double,
    curr varchar(100)
);