insert into InventoryApp.products (product_brand, apparal_type, description, price, inventory) values ('BBC', 'Shirt', 'A BBC logo shirt', 55.00, 10);
insert into InventoryApp.products (product_brand, apparal_type, description, price, inventory) values ('BBC', 'LongSleeve', 'A BBC long sleeve shirt with Script Logo on front.', 59.00, 15);
insert into InventoryApp.products (product_brand, apparal_type, description, price, inventory) values ('BBC', 'Sweatshirt', 'A BBC Astronaut Hoodie with a small embroidered Standing Astronaut logo on wearers right chest.', 130.00, 5);
insert into InventoryApp.products (product_brand, apparal_type, description, price, inventory) values ('Supreme', 'Shirt', 'Supreme t-shirt with printed graphic on front and back.', 44.00, 5);
insert into InventoryApp.products (product_brand, apparal_type, description, price, inventory) values ('Supreme', 'LongSleeve', 'Classic supreme long sleeve t-shirt with printied logo and graphic on back.', 54.00, 12);
insert into InventoryApp.products (product_brand, apparal_type, description, price, inventory) values ('Supreme', 'Sweatshirt', 'Crossgrain fleece with rib gussets, pouch pocket and jacquard stripe cuffs. Flock logo on chest', 138.00, 7);



insert into InventoryApp.users (first_name, last_name, password, email, phone_number, active) values ('John', 'Turner', 'abc123', 'jturner@email.com', '123-456-7890', true);
insert into InventoryApp.users (first_name, last_name, password, email, phone_number, active) values ('Stephen', 'Baynes', 'def456', 'sbaynes@email.com', '123-456-1234', true);
insert into InventoryApp.users (first_name, last_name, password, email, phone_number, active) values ('Ken', 'Bone', 'lol123', 'kbone@email.com', '123-456-4321', true);
insert into InventoryApp.users (first_name, last_name, password, email, phone_number, active) values ('James', 'Handshoe', 'password123', 'jhandshoe@email.com', '123-456-5566', true);
insert into InventoryApp.users (first_name, last_name, password, email, phone_number, active) values ('Paul', 'OConnor', 'testtest', 'poconnor@email.com', '123-456-5566', true);

insert into InventoryApp.user_roles (user_id, role) values ((select id from InventoryApp.users where email = 'jturner@email.com'), 'USER');
insert into InventoryApp.user_roles (user_id, role) values ((select id from InventoryApp.users where email = 'sbaynes@email.com'), 'USER');
insert into InventoryApp.user_roles (user_id, role) values ((select id from InventoryApp.users where email = 'kbone@email.com'), 'USER');
insert into InventoryApp.user_roles (user_id, role) values ((select id from InventoryApp.users where email = 'jhandshoe@email.com'), 'USER');
insert into InventoryApp.user_roles (user_id, role) values ((select id from InventoryApp.users where email = 'poconnor@email.com'), 'USER');

insert into InventoryApp.orders (user_id, product_id, transaction_date) values (2, 1, 'January 30th, 2016');
insert into InventoryApp.orders (user_id, product_id, transaction_date) values (3, 1, 'June 10th, 2016');
insert into InventoryApp.orders (user_id, product_id, transaction_date) values (4, 1, 'April 30th, 2016');
insert into InventoryApp.orders (user_id, product_id, transaction_date) values (5, 1, 'January 3rd, 2016');
insert into InventoryApp.orders (user_id, product_id, transaction_date) values (1, 1, 'February 4th, 2016');

