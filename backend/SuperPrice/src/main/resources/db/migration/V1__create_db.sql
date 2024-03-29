DROP TABLE if exists product;
CREATE TABLE product
(
    barcode  varchar(12) NOT NULL,
    name     varchar(100) DEFAULT NULL,
    category varchar(45)  DEFAULT NULL,
    PRIMARY KEY (barcode)
);

DROP TABLE if exists store;
CREATE TABLE store
(
    store_id int NOT NULL,
    name     varchar(45)  DEFAULT NULL,
    address  varchar(200) DEFAULT NULL,
    postcode varchar(6)   DEFAULT NULL,
    PRIMARY KEY (store_id)
);


DROP TABLE if exists store_price;
CREATE TABLE store_price
(
    barcode  varchar(12) NOT NULL,
    store_id int         NOT NULL,
    price    double      NOT NULL,
    status   varchar(20) NOT NULL,
    FOREIGN KEY (barcode) REFERENCES product(barcode),
    FOREIGN KEY (store_id) REFERENCES store(store_id),
    PRIMARY KEY (barcode, store_id)
);