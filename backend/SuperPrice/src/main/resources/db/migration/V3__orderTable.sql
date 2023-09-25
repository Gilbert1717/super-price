DROP TABLE if exists orders;
CREATE TABLE orders
(
    id BIGINT AUTO_INCREMENT,
    creating_time TIMESTAMP NOT NULL,
    delivery_time TIMESTAMP NOT NULL,
    delivery_address VARCHAR(150) NOT NULL,
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS order_product_store;
CREATE TABLE order_product_store
(
    order_id BIGINT,
    barcode varchar(12) NOT NULL,
    store_id int NOT NULL,
    quantity int NOT NULL,
    PRIMARY KEY (order_id,barcode,store_id),
    FOREIGN KEY (barcode) REFERENCES product(barcode),
    FOREIGN KEY (store_id) REFERENCES store(store_id),
    CONSTRAINT fk_parent FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE ON UPDATE NO ACTION
);