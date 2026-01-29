use om;


create table User( 
id int primary key auto_increment,
username varchar(50) not null unique,
email varchar(100) not null unique,
password varchar(255) not null,
role enum('ROLE_ADMIN' , 'ROLE_CUSTOMER') not null);


create table Product (
id int primary key auto_increment,
productName varchar(255) not null,
price double not null,
stockQuantity int not null);



create table orders (
id int primary key auto_increment,
user_id int not null,
state varchar(50),
price double not null,
constraint fk_order_user
foreign key(user_id)
references User(id));

create table order_item (
id int primary key auto_increment,
order_id int not null,
product_id int not null,
quantity int not null ,
price double not null,

constraint fk_order_item
foreign key(order_id)
references orders(id)
on delete cascade,

constraint fk_order_item_product
foreign key(product_id)
references Product(id)
);





