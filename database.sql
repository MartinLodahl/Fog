use fog; 
DROP TABLE IF EXISTS orderitems;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS materials;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	username VARCHAR(100) PRIMARY KEY NOT NULL,
	password VARCHAR(100) NOT NULL
);

CREATE TABLE materials (
	id INTEGER PRIMARY KEY NOT NULL,
	name VARCHAR(100) NOT NULL,
	type VARCHAR(100) NOT NULL,
	size DECIMAL(5, 3) NOT NULL
);

CREATE TABLE orders (
	id INTEGER PRIMARY KEY NOT NULL,
	customer_name VARCHAR(100) NOT NULL,
	customer_email VARCHAR(100) NOT NULL,
	customer_phone VARCHAR(100) NOT NULL, 
    isFinished boolean
);

CREATE TABLE orderitems (
	id INTEGER PRIMARY KEY NOT NULL,
	order_id INTEGER NOT NULL REFERENCES orders(id),
	material_id INTEGER NOT NULL REFERENCES materials(id),
	quantity INTEGER NOT NULL
);



