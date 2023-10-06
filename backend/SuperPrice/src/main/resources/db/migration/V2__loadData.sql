-- Insert statements for the product table
INSERT INTO product (Barcode, Name, Category) VALUES ('5369979017', 'Digital Camera', 'Electronics');
INSERT INTO product (Barcode, Name, Category) VALUES ('7132509187', 'Golf Clubs', 'Sports');
INSERT INTO product (Barcode, Name, Category) VALUES ('3143850651', 'Hoodie', 'Clothing');
INSERT INTO product (Barcode, Name, Category) VALUES ('0667219603', 'Jeans', 'Clothing');
INSERT INTO product (Barcode, Name, Category) VALUES ('6475076782', 'Gaming Console', 'Electronics');
INSERT INTO product (Barcode, Name, Category) VALUES ('7634992603', 'Watch', 'Accessories');
INSERT INTO product (Barcode, Name, Category) VALUES ('8442785121', 'Refrigerator', 'Appliances');
INSERT INTO product (Barcode, Name, Category) VALUES ('2913924977', 'Hat', 'Accessories');
INSERT INTO product (Barcode, Name, Category) VALUES ('2555900856', 'Running Shoes', 'Sports');
INSERT INTO product (Barcode, Name, Category) VALUES ('8702625512', 'Food Processor', 'Appliances');
INSERT INTO product (Barcode, Name, Category) VALUES ('7952748205', 'Skirt', 'Clothing');
INSERT INTO product (Barcode, Name, Category) VALUES ('4798134020', 'Tennis Racket', 'Sports');
INSERT INTO product (Barcode, Name, Category) VALUES ('8266403416', 'Blender', 'Appliances');
INSERT INTO product (Barcode, Name, Category) VALUES ('9782091926', 'Jacket', 'Clothing');
INSERT INTO product (Barcode, Name, Category) VALUES ('7576444527', 'Basketball', 'Sports');
INSERT INTO product (Barcode, Name, Category) VALUES ('2309044110', 'T-shirt', 'Clothing');
INSERT INTO product (Barcode, Name, Category) VALUES ('7440555220', 'Yoga Mat', 'Sports');
INSERT INTO product (Barcode, Name, Category) VALUES ('6275649219', 'Smart TV', 'Electronics');
INSERT INTO product (Barcode, Name, Category) VALUES ('2854375392', 'Backpack', 'Accessories');
INSERT INTO product (Barcode, Name, Category) VALUES ('1176391128', 'Sunglasses', 'Accessories');
INSERT INTO product (Barcode, Name, Category) VALUES ('9120974954', 'Air Fryer', 'Appliances');
INSERT INTO product (Barcode, Name, Category) VALUES ('0332882601', 'Sneakers', 'Clothing');
INSERT INTO product (Barcode, Name, Category) VALUES ('6201527499', 'Coffee Maker', 'Appliances');
INSERT INTO product (Barcode, Name, Category) VALUES ('5260689007', 'Washing Machine', 'Appliances');
INSERT INTO product (Barcode, Name, Category) VALUES ('2367891309', 'Headphones', 'Electronics');
INSERT INTO product (Barcode, Name, Category) VALUES ('4901652484', 'Laptop', 'Electronics');
INSERT INTO product (Barcode, Name, Category) VALUES ('4556938463', 'Bracelet', 'Accessories');
INSERT INTO product (Barcode, Name, Category) VALUES ('2702724549', 'Handbag', 'Accessories');
INSERT INTO product (Barcode, Name, Category) VALUES ('0592016589', 'Cycling Helmet', 'Sports');
INSERT INTO product (Barcode, Name, Category) VALUES ('1497891731', 'Smartphone', 'Electronics');
INSERT INTO product (Barcode, Name, Category) VALUES ('9071843915', 'Wallet', 'Accessories');
INSERT INTO product (Barcode, Name, Category) VALUES ('0187853414', 'Fitness Tracker', 'Sports');
INSERT INTO product (Barcode, Name, Category) VALUES ('4481139299', 'Tablet', 'Electronics');
INSERT INTO product (Barcode, Name, Category) VALUES ('0898699756', 'Soccer Ball', 'Sports');
INSERT INTO product (Barcode, Name, Category) VALUES ('8133485005', 'Dress', 'Clothing');
INSERT INTO product (Barcode, Name, Category) VALUES ('2162232520', 'Microwave', 'Appliances');
INSERT INTO product (Barcode, Name, Category) VALUES ('5547960313', 'Wireless Mouse', 'Electronics');
INSERT INTO product (Barcode, Name, Category) VALUES ('2733473300', 'Toaster', 'Appliances');
INSERT INTO product (Barcode, Name, Category) VALUES ('1288354562', 'Necklace', 'Accessories');
INSERT INTO product (Barcode, Name, Category) VALUES ('6340912821', 'Socks', 'Clothing');

-- Insert statements for the Store table
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (101, 'Electronics Store', '123 Main St', '12345');
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (102, 'Fashion Store', '456 Elm St', '54321');
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (103, 'Appliance Store', '789 Oak St', '98765');
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (104, 'Sports Store', '101 Maple St', '13579');
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (105, 'Accessories Store', '202 Cedar St', '24680');
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (106, 'Tech Gadgets Store', '345 Elm St', '67890');
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (107, 'Home Decor Store', '567 Oak St', '54321');
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (108, 'Outdoor Sports Store', '789 Pine St', '98765');
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (109, 'Jewelry Store', '234 Maple St', '13579');
INSERT INTO store (store_id, Name, Address, Postcode) VALUES (110, 'Kitchen Appliances Store', '678 Birch St', '24680');

-- Insert statements for the Store Price table
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6475076782', 108, 808.85, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2733473300', 110, 705.79, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2854375392', 103, 34.46, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7952748205', 109, 939.05, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8442785121', 104, 624.86, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8266403416', 103, 745.52, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8133485005', 107, 468.84, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8702625512', 104, 482.18, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9120974954', 103, 592.12, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2555900856', 101, 828.21, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2733473300', 103, 517.09, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6275649219', 108, 535.42, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6340912821', 110, 415.58, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9782091926', 108, 901.42, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('3143850651', 110, 535.42, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7634992603', 109, 651.9, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4556938463', 101, 368.97, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2309044110', 104, 728.96, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1288354562', 108, 959.59, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4901652484', 107, 266.0, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2733473300', 102, 110.12, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('3143850651', 107, 213.4, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7132509187', 110, 939.05, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0898699756', 108, 738.36, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7440555220', 104, 53.05, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7576444527', 102, 70.1, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6340912821', 103, 671.79, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0187853414', 106, 53.98, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6201527499', 101, 430.26, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6201527499', 105, 101.96, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2367891309', 108, 185.14, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7952748205', 105, 674.14, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8442785121', 103, 499.41, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8702625512', 101, 743.77, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5369979017', 104, 240.6, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4481139299', 108, 439.89, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6340912821', 108, 45.24, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4556938463', 110, 65.84, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4798134020', 101, 235.68, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6275649219', 109, 110.38, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0667219603', 104, 959.59, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9782091926', 103, 308.07, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4556938463', 106, 601.04, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1497891731', 110, 443.97, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8133485005', 103, 148.86, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0592016589', 102, 66.34, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4798134020', 102, 376.02, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0187853414', 104, 416.8, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8266403416', 104, 917.11, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6340912821', 102, 548.7, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0667219603', 105, 828.21, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9071843915', 103, 153.0, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2913924977', 110, 224.05, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9782091926', 110, 440.86, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8266403416', 108, 440.86, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9120974954', 110, 52.31, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9120974954', 106, 242.3, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4798134020', 107, 785.75, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6201527499', 106, 544.49, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5260689007', 106, 432.4, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4481139299', 104, 785.75, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0898699756', 103, 366.77, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1288354562', 107, 110.65, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8442785121', 110, 17.29, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2702724549', 102, 671.79, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0667219603', 103, 45.24, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1288354562', 106, 745.52, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0332882601', 107, 150.8, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0592016589', 110, 646.46, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('3143850651', 101, 292.35, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7634992603', 107, 222.7, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1176391128', 102, 555.55, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0187853414', 102, 788.15, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2367891309', 104, 110.65, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0667219603', 109, 339.59, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('3143850651', 108, 535.42, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('3143850651', 109, 308.12, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7576444527', 101, 328.26, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5547960313', 102, 817.37, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0898699756', 106, 389.83, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1288354562', 104, 345.06, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2555900856', 107, 227.93, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2913924977', 103, 347.9, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0332882601', 102, 339.59, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1176391128', 108, 383.03, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2913924977', 105, 186.9, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2367891309', 106, 529.01, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2162232520', 103, 505.05, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5369979017', 109, 835.86, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2854375392', 108, 144.59, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4798134020', 103, 405.14, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8133485005', 106, 646.46, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0667219603', 110, 817.37, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0667219603', 108, 153.63, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7634992603', 110, 743.77, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6475076782', 101, 308.07, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7634992603', 104, 723.76, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0898699756', 104, 45.24, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7952748205', 102, 728.96, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6201527499', 109, 363.86, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9120974954', 102, 867.06, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0898699756', 105, 994.44, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4798134020', 104, 651.81, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4481139299', 110, 651.9, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0898699756', 109, 124.77, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6475076782', 104, 240.6, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1176391128', 106, 944.38, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0592016589', 105, 779.74, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1176391128', 107, 110.38, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4901652484', 105, 443.97, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2309044110', 105, 490.54, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6475076782', 105, 389.83, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2854375392', 107, 953.06, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('3143850651', 102, 601.04, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('6275649219', 102, 835.86, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5260689007', 105, 914.8, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8266403416', 102, 148.86, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7576444527', 106, 767.6, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8266403416', 107, 64.6, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9120974954', 101, 137.74, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2702724549', 107, 333.25, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2555900856', 106, 224.05, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8442785121', 105, 376.02, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9782091926', 106, 767.6, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4798134020', 106, 513.0, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7576444527', 105, 227.93, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0592016589', 109, 923.71, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8266403416', 110, 723.76, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9071843915', 104, 185.14, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8133485005', 102, 201.07, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2555900856', 108, 651.9, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7634992603', 106, 308.07, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('3143850651', 105, 31.91, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7952748205', 108, 671.79, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1176391128', 104, 248.6, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2367891309', 109, 184.46, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1176391128', 109, 499.41, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8442785121', 106, 747.92, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2162232520', 105, 840.82, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2367891309', 103, 482.18, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4901652484', 104, 110.12, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2702724549', 104, 66.34, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('1497891731', 109, 165.83, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2555900856', 102, 213.4, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9071843915', 102, 453.57, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9782091926', 104, 808.85, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9120974954', 107, 488.83, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5369979017', 107, 828.21, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('5369979017', 110, 914.8, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('9071843915', 109, 102.07, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4901652484', 103, 183.92, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('8442785121', 102, 261.56, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7952748205', 101, 17.29, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2162232520', 101, 93.38, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7634992603', 102, 328.26, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('4798134020', 105, 544.49, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('0187853414', 107, 478.54, 'MSRP');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('7952748205', 104, 548.7, 'Special Offer');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2913924977', 107, 136.15, 'Price Down');
INSERT INTO store_price (Barcode, store_id, Price, Status) VALUES ('2854375392', 101, 227.93, 'Special Offer');
