CREATE TABLE IF NOT EXISTS category (
    id Integer PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS product (
    id Integer PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    available_quantity DOUBLE PRECISION NOT NULL,
    price NUMERIC(38, 2),
    category_id Integer,
    CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE SEQUENCE IF NOT EXISTS category_seq 
START WITH 1 
INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS product_seq 
START WITH 1 
INCREMENT BY 1;
