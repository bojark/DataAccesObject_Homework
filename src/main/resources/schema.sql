create table netology.customers_hw(
    id serial primary key,
    name varchar not null,
    age int not null,
    phone_number int8
);

create table netology.orders_hw(
    id serial primary key,
    date date not null,
    customer_id int not null,
    product_name varchar(64) not null,
    amount int not null,
    foreign key (customer_id) references netology.customers_hw (id)
);

insert into netology.customers_hw (name, age, phone_number)
values ('Ivan', 22, 78382348292);
insert into netology.customers_hw (name, age, phone_number)
values ('Oleg', 25, 78343555634);

insert into netology.orders_hw (date, customer_id, product_name, amount)
values (date '2022-02-22', 1, 'Product name', 2);
insert into netology.orders_hw (date, customer_id, product_name, amount)
values (date '2023-01-26', 2, 'Offer', 1);
