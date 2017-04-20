use fog; 
DROP TABLE IF EXISTS orderitems;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS materials;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	username VARCHAR(100) PRIMARY KEY NOT NULL,
	password VARCHAR(100) NOT NULL
);

INSERT INTO users (username, password)
VALUES ('admin', '12345');

CREATE TABLE materials (
	id INTEGER PRIMARY KEY NOT NULL,
	name VARCHAR(100) NOT NULL,
	type VARCHAR(100) NOT NULL,
	size INTEGER(7) NOT NULL,
    price double(8,2) NOT NULL
);

insert into materials (id, name, type, size, price) 
values (1, "stolpe", "stolpe", 200, 10),
(7, "Træ stolpe3", "stolpe", 0, 6),
(2, "Plastik stolpe2", "stolpe", 500, 20),
(3, "Træ brædde", "brædde", 500, 10), 
(4, "Plastik brædde2", "brædde", 0, 5),
(5, "Normalt tag", "tag", 0, 10),
(6, "Normalt tag2", "tag", 0, 12), 
(8, "Træ plade", "plade", 0, 7)
;

CREATE TABLE orders (
	id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
	customer_name VARCHAR(100) NOT NULL,
	customer_email VARCHAR(100) NOT NULL,
	customer_phone VARCHAR(100) NOT NULL, 
	status BOOLEAN NOT NULL,
	width INTEGER NOT NULL,
	length INTEGER NOT NULL,
	height INTEGER NOT NULL,
	skur BOOLEAN NOT NULL,
	deleted BOOLEAN NOT NULL
);

CREATE TABLE orderitems (
	id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
	order_id INTEGER NOT NULL REFERENCES orders(id),
	material_id INTEGER NOT NULL REFERENCES materials(id),
	quantity INTEGER NOT NULL,
    length INTEGER NOT NULL,
    width INTEGER NOT NULL,
    price  DOUBLE (8,2) NOT NULL
);



