create database if not exists invmsdb;
CREATE TABLE if not exists invmsdb.products(
productID int not null auto_increment,
productname varchar(100) not null,
price double not null,
stock int not null,
primary key (productID)
);

CREATE TABLE if not exists invmsdb.customers(
customerID int not null auto_increment,
fullname varchar(30) not null,
address varchar(50) not null,
postcode varchar(7) not null,
email varchar(30) not null,
primary key(customerID)
);

CREATE TABLE if not exists invmsdb.orders(
orderID int not null auto_increment,
customerID int not null,
totalcost double,
primary key(orderID),
foreign key(customerID) references customers(customerID)
);

CREATE TABLE if not exists invmsdb.orderline(
orderlineID int not null auto_increment,
orderID int not null,
productID int not null,
quantity int not null,
cost double not null,
primary key(orderlineID),
foreign key(orderID) references orders(orderID),
foreign key(productID) references products(productID)
);