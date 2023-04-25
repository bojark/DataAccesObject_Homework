select c.name, o.product_name from netology.orders_hw o
join netology.customers_hw c on o.customer_id = c.id
where c.name = ?;