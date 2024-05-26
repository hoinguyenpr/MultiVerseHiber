use ecommercedb;


#dum start
create table role(
    id int(11) primary key not null auto_increment,
    name nvarchar(50) not null,
    description nvarchar(100) default null
);

create table user(
    id int(11) primary key not null auto_increment,
    email nvarchar(128),
    first_name nvarchar(45),
    last_name nvarchar(45),
    password nvarchar(64) default null,
    photos nvarchar(64) default null,
    enabled boolean default true
);

create table users_roles(
    user_id int(11) not null,
    role_id int(11) not null,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE ON UPDATE CASCADE
)

insert into role(name, description) values('Admin', 'Manage everything');
insert into role(name, description) values('Salesperson', 'manage product price, customers, shipping, orders and sales report');
insert into role(name, description) values('Editor', 'manage categories, brands, products, articles and menus');
insert into role(name, description) values('Shipper', 'view products, view orders and update order status');
insert into role(name, description) values('Assistant', 'manage questions and reviews');


#dump end

delete from role where id in (2, 4, 6)

select * from user

select * from role;
select * from role where id = 1;

truncate table role;