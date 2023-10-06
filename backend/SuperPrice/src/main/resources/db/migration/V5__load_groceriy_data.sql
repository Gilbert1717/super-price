-- Insert statements for the Product table
INSERT INTO product (Barcode, Name, Category) VALUES ('7804878010', 'Kangaroo', 'Meats');
INSERT INTO product (Barcode, Name, Category) VALUES ('0158487904', 'Pineapple', 'Fruit');
INSERT INTO product (Barcode, Name, Category) VALUES ('5115724408', 'Kiwi fruit', 'Fruit');
INSERT INTO product (Barcode, Name, Category) VALUES ('2643583734', 'Watermelon', 'Fruit');
INSERT INTO product (Barcode, Name, Category) VALUES ('0719826212', 'Milk', 'Dairy');
INSERT INTO product (Barcode, Name, Category) VALUES ('0647468526', 'Cheese', 'Dairy');
INSERT INTO product (Barcode, Name, Category) VALUES ('0997713558', 'Pear', 'Fruit');
INSERT INTO product (Barcode, Name, Category) VALUES ('9722190511', 'Yogurt', 'Dairy');
INSERT INTO product (Barcode, Name, Category) VALUES ('3073117453', 'Turkey', 'Meats');
INSERT INTO product (Barcode, Name, Category) VALUES ('2414426942', 'Beans', 'Vegetables');
INSERT INTO product (Barcode, Name, Category) VALUES ('6240329296', 'Cucumber', 'Vegetables');
INSERT INTO product (Barcode, Name, Category) VALUES ('1213033488', 'Bread', 'Bakery');
INSERT INTO product (Barcode, Name, Category) VALUES ('0143798185', 'Cod', 'Fish');
INSERT INTO product (Barcode, Name, Category) VALUES ('5696289701', 'Beef', 'Meats');
INSERT INTO product (Barcode, Name, Category) VALUES ('5454225255', 'Cauliflower', 'Vegetables');
INSERT INTO product (Barcode, Name, Category) VALUES ('1518416384', 'Mango', 'Fruit');
INSERT INTO product (Barcode, Name, Category) VALUES ('2612543971', 'Chicken', 'Meats');
INSERT INTO product (Barcode, Name, Category) VALUES ('8495670518', 'Capsicum', 'Vegetables');
INSERT INTO product (Barcode, Name, Category) VALUES ('2800551945', 'Muffin', 'Bakery');
INSERT INTO product (Barcode, Name, Category) VALUES ('9782726022', 'Butter', 'Dairy');
INSERT INTO product (Barcode, Name, Category) VALUES ('6046408818', 'Sardines', 'Fish');
INSERT INTO product (Barcode, Name, Category) VALUES ('2629672915', 'Tuna', 'Fish');
INSERT INTO product (Barcode, Name, Category) VALUES ('1123496664', 'Potato', 'Vegetables');
INSERT INTO product (Barcode, Name, Category) VALUES ('1500093146', 'Lamb', 'Meats');
INSERT INTO product (Barcode, Name, Category) VALUES ('1127198759', 'Passion fruit', 'Fruit');
INSERT INTO product (Barcode, Name, Category) VALUES ('2737230901', 'Corn', 'Vegetables');
INSERT INTO product (Barcode, Name, Category) VALUES ('5863457012', 'Cookie', 'Bakery');
INSERT INTO product (Barcode, Name, Category) VALUES ('4012735350', 'Salmon', 'Fish');
INSERT INTO product (Barcode, Name, Category) VALUES ('7278422693', 'Banana', 'Fruit');
INSERT INTO product (Barcode, Name, Category) VALUES ('0810131236', 'Donut', 'Bakery');
INSERT INTO product (Barcode, Name, Category) VALUES ('4926096131', 'Croissant', 'Bakery');
INSERT INTO product (Barcode, Name, Category) VALUES ('7937746068', 'Broccoli', 'Vegetables');
INSERT INTO product (Barcode, Name, Category) VALUES ('6484771081', 'Apple', 'Fruit');
INSERT INTO product (Barcode, Name, Category) VALUES ('8211988981', 'Cake', 'Bakery');
INSERT INTO product (Barcode, Name, Category) VALUES ('9347163130', 'Anchovies', 'Fish');
INSERT INTO product (Barcode, Name, Category) VALUES ('4243143660', 'Lettuce', 'Vegetables');
INSERT INTO product (Barcode, Name, Category) VALUES ('6961117658', 'Pork', 'Meats');
INSERT INTO product (Barcode, Name, Category) VALUES ('6929622293', 'Orange', 'Fruit');
INSERT INTO product (Barcode, Name, Category) VALUES ('3216493951', 'Peas', 'Vegetables');
INSERT INTO product (Barcode, Name, Category) VALUES ('5743008014', 'Roe', 'Fish');
INSERT INTO product (Barcode, Name, Category) VALUES ('9959397480', 'Carrot', 'Vegetables');

-- Insert statements for the Store table
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (201, 'Coles', '123 Main St', '12345');
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (202, 'Woolies', '456 Elm St', '54321');
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (203, 'Aldi', '789 Oak St', '98765');
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (204, 'IGA', '101 Maple St', '13579');
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (205, 'Assian groceries', '202 Cedar St', '24680');
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (206, 'SuperCheap groceries', '345 Elm St', '67890');

-- Insert statements for the Store Price table
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2737230901', 204, 6.85, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5115724408', 205, 8.5, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4243143660', 205, 2.73, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0158487904', 204, 8.74, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8495670518', 202, 6.12, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2643583734', 205, 8.5, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5454225255', 206, 4.97, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2414426942', 205, 9.8, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0143798185', 204, 2.78, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0719826212', 205, 7.96, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6240329296', 204, 5.37, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9959397480', 205, 8.68, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4012735350', 205, 2.13, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6240329296', 201, 7.58, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('3216493951', 203, 7.97, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1518416384', 201, 9.89, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0143798185', 203, 6.05, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8495670518', 205, 9.59, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1123496664', 206, 5.1, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5115724408', 203, 3.64, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1213033488', 206, 6.54, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9782726022', 202, 3.89, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6929622293', 206, 7.53, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2737230901', 202, 4.53, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7278422693', 201, 6.57, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0647468526', 206, 7.08, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2800551945', 202, 6.9, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5743008014', 202, 6.45, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5743008014', 205, 3.02, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9959397480', 201, 6.53, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6961117658', 201, 2.63, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0647468526', 205, 6.36, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7278422693', 202, 7.31, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2612543971', 203, 9.39, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2612543971', 201, 6.49, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0719826212', 203, 3.95, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0158487904', 205, 4.86, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9347163130', 206, 2.42, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2629672915', 206, 8.41, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7804878010', 203, 5.38, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2612543971', 202, 2.84, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7804878010', 205, 5.17, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7278422693', 206, 9.93, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7937746068', 206, 7.09, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6929622293', 202, 9.12, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8495670518', 201, 7.57, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4243143660', 202, 4.01, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2737230901', 203, 4.96, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7278422693', 204, 9.94, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4926096131', 205, 7.32, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2629672915', 203, 9.33, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6484771081', 201, 2.23, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2737230901', 205, 6.01, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6046408818', 205, 3.55, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0997713558', 204, 3.0, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5743008014', 201, 2.04, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7937746068', 202, 6.57, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6484771081', 204, 2.16, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6961117658', 203, 9.16, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5863457012', 205, 8.31, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2737230901', 206, 7.66, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5454225255', 205, 3.82, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9782726022', 206, 2.62, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5115724408', 204, 7.05, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7278422693', 203, 5.74, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5115724408', 201, 4.69, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0997713558', 203, 4.31, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4926096131', 203, 2.35, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4012735350', 201, 5.65, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2629672915', 201, 9.76, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4243143660', 203, 5.12, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2629672915', 202, 2.06, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1123496664', 203, 9.55, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1518416384', 206, 8.68, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2643583734', 201, 4.7, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7804878010', 201, 4.31, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1127198759', 205, 3.35, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9722190511', 203, 8.57, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1213033488', 201, 5.67, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0997713558', 205, 4.01, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0647468526', 203, 6.25, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6961117658', 204, 3.48, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9782726022', 203, 8.43, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5454225255', 204, 6.69, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4926096131', 201, 5.24, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('3216493951', 204, 2.32, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1518416384', 203, 5.09, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9782726022', 205, 9.68, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9722190511', 201, 9.64, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('3073117453', 203, 4.24, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7804878010', 206, 6.21, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4243143660', 204, 2.47, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0143798185', 201, 6.68, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4243143660', 206, 7.23, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0158487904', 203, 4.42, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0810131236', 203, 5.87, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9722190511', 206, 5.74, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0158487904', 206, 4.69, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7804878010', 204, 4.03, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8495670518', 206, 4.29, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2643583734', 204, 5.99, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7937746068', 203, 6.56, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6929622293', 205, 5.69, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1127198759', 202, 5.94, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5696289701', 205, 7.31, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8211988981', 206, 9.73, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4012735350', 202, 6.49, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9347163130', 201, 3.7, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6929622293', 201, 7.36, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0143798185', 202, 2.59, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0719826212', 202, 8.16, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('3073117453', 202, 8.58, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6929622293', 204, 2.45, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0158487904', 201, 4.98, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5863457012', 206, 3.63, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9722190511', 204, 8.62, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1500093146', 204, 4.53, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9722190511', 205, 8.04, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8211988981', 202, 5.03, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6961117658', 202, 5.31, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6240329296', 205, 7.82, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0810131236', 201, 6.28, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6046408818', 203, 7.84, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5696289701', 204, 3.28, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0997713558', 201, 7.04, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6046408818', 206, 5.89, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2800551945', 205, 5.87, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9959397480', 203, 7.76, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2612543971', 204, 5.55, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0158487904', 202, 8.47, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0810131236', 204, 2.85, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2612543971', 206, 6.77, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6240329296', 206, 7.94, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2629672915', 205, 2.37, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0719826212', 206, 5.8, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6484771081', 206, 7.43, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0810131236', 202, 8.71, 'Special Offer');
