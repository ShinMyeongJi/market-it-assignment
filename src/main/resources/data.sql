insert into orders (order_id, created, modified, order_status) values (1, CURRENT_TIMESTAMP(), null, 'CREATED');
insert into order_item (id, name, order_id, cnt) values (1, 'jeans', 1, 2);
insert into order_item (id, name, order_id, cnt) values (2, 'gloves', 1, 4);

