INSERT INTO image (file_name, content_type, url) VALUES ('Brikkon_stad.jpg', 'image/jpg', 'http://localhost:8080/images/download/Brikkon_stad.jpg');
INSERT INTO image (file_name, content_type, url) VALUES ('Clementoni_Frame_Me_Up_Tokyo.jpg', 'image/jpeg', 'http://localhost:8080/images/download/Clementoni_Frame_Me_Up_Tokyo.jpg');
INSERT INTO image (file_name, content_type, url) VALUES ('Clementoni_Vintage.jpg', 'image/jpg', 'http://localhost:8080/images/download/Clementoni_Vintage.jpg');
INSERT INTO image (file_name, content_type, url) VALUES ('Brikkon_huis.jpg', 'image/jpg', 'http://localhost:8080/images/download/Brikkon_huis.jpg');
INSERT INTO image (file_name, content_type, url) VALUES ('superpetit_castle.jpeg', 'image/jpeg', 'http://localhost:8080/images/download/superpetit_castle.jpeg');
INSERT INTO image (file_name, content_type, url) VALUES ('clementoni_Frame_Me_Up_Foosball.jpg', 'image/jpg', 'http://localhost:8080/images/download/clementoni_Frame_Me_Up_Foosball.jpg');


INSERT INTO address (address_id, street_name, house_number, house_number_addition, city, zipcode, phone_number) VALUES (5001,'Userstraat', '45', 'bis', 'Amsterdam', '1234AB', 0644355490);
INSERT INTO address (address_id, street_name, house_number, house_number_addition, city, zipcode, phone_number) VALUES (5002, 'Userstraat', '54', 'A', 'Amsterdam', '2222AZ', 0644355490);
INSERT INTO address (address_id, street_name, house_number, house_number_addition, city, zipcode, phone_number) VALUES (5003, 'Lombokstraat', '400', 'bis', 'Utrecht', '1453PX', 0644355490);
INSERT INTO address (address_id, street_name, house_number, house_number_addition, city, zipcode, phone_number) VALUES (5004, 'Balitraat', '200', 'bis', 'Utrecht', '1244DD', 0644355490);


INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1000, 'Brikkon - Stad', 'Met de Brikkon World stad bouw je een prachtige stad van hout.', 64.95, 'Brikkon_stad.jpg');
INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1001, 'Frame me up - Tokyo Lights', 'Puzzel de stad Tokyo en frame het op', 15.95, 'Clementoni_Frame_Me_Up_Tokyo.jpg');
INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1002, 'Frame me up - Vintage', 'Puzzel een vintage kamer en frame het op', 15.95, 'Clementoni_Vintage.jpg');
INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1003, 'Brikkon - Huis', 'Met Brikkon Huis heb je een toffe huis voor de kleintjes', 24.95, 'Brikkon_huis.jpg');
INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1004, 'Superpetit Artiste Placemat Kasteel', 'Een placemat voor de creatieve painter thuis', 24.95, 'superpetit_castle.jpeg');
INSERT INTO products (product_id, product_name, product_description, product_price, image_file_name) VALUES (1005, 'Frame me up - Foosball','Puzzel een foosball tafel voor de foosball liefhebber', 15.95, 'clementoni_Frame_Me_Up_Foosball.jpg');

INSERT INTO wishlists(wishlist_id) VALUES (200);
INSERT INTO wishlists(wishlist_id) VALUES (201);
INSERT INTO wishlists(wishlist_id) VALUES (202);
INSERT INTO wishlists(wishlist_id) VALUES (203);

INSERT INTO wishlist_product_table(wishlist_id, product_id) VALUES (200, 1001);
INSERT INTO wishlist_product_table(wishlist_id, product_id) VALUES (200, 1002);
INSERT INTO wishlist_product_table(wishlist_id, product_id) VALUES (200, 1003);
INSERT INTO wishlist_product_table(wishlist_id, product_id) VALUES (201, 1002);
INSERT INTO wishlist_product_table(wishlist_id, product_id) VALUES (201, 1005);

INSERT INTO remarks (contact_name, contact_email, contact_phone, contact_organisation, contact_remark) VALUES ('Contact Test', 'contact@test.nl', 0611111111, 'Testers', 'Hoi, Ik ben een tester voor testbureau Tester. Graag zou ik een telefonisch gesprek houden over een van uw producten. Mijn mobiel is 06123455678. Fijne dag nog');
INSERT INTO remarks (contact_name, contact_email, contact_phone, contact_remark) VALUES ('Wim Test', 'Wim@test.nl', 0611111112, 'Hoi, Ik ben een tester voor testbureau Tester. Graag zou ik een telefonisch gesprek houden over een van uw producten. Mijn mobiel is 06123455678. Fijne dag nog');


INSERT INTO users (user_email, password, user_id, first_name, last_name, address_address_id, wishlist_wishlist_id) VALUES ('user@test.nl', '$2a$12$5Opf8AKt28//iIdms4dXZuHzQTPjBmOV92SQSELfGB0g9LdmAWQ9O', 1,  'User', 'Test', 5001, 200);
INSERT INTO users (user_email, password, user_id, first_name, last_name, address_address_id, wishlist_wishlist_id) VALUES ('admin@test.nl', '$2a$12$lgPKHPD.92GF8Dd8gjH.TeBh9O5SzlmipOpbUiqRHKVbjg7HgZj.S', 2,  'Admin', 'Test', 5002, 203);
INSERT INTO users (user_email, password, user_id, first_name, last_name, address_address_id, wishlist_wishlist_id) VALUES ('jenfromlomok@test.nl', '$2a$12$BmMv.oCR96Hcw81S7yoW/uNPBGPADmdBI45EZS6I1tlq3FwTv3Ncu', 3, 'Jen', 'van Lombok', 5003, 202);
INSERT INTO users (user_email, password, user_id, first_name, last_name, address_address_id, wishlist_wishlist_id) VALUES ('Guilfromlombok@test.nl', '$2a$12$v8obCBMrcCq6s9qBRAUEZuWAK9oSWSn1JzceR7/BWt3UnN643QMOW', 4, 'Guil', 'Dag', 5004, 201);

INSERT INTO authorities (user_email, authority) VALUES ('user@test.nl', 'ROLE_USER');
INSERT INTO authorities (user_email, authority) VALUES ('jenfromlombok@test.nl', 'ROLE_USER');
INSERT INTO authorities (user_email, authority) VALUES ('admin@test.nl', 'ROLE_ADMIN');
INSERT INTO authorities (user_email, authority) VALUES ('guilfromlombok@test.nl', 'ROLE_USER');
--
-- INSERT INTO orders (order_id, product_list, comment, order_date, user_email, address_id) VALUES (72, ARRAY [["id: 1000","Brikkon - Stad","€ 64.95","qty: 3"],["id: 1001","Frame me up - Tokyo Lights","€ 15.95","qty: 2"],["id: 1002","Frame me up - Vintage","€ 15.95","qty: 1"]], 'Mijn eerste order, dank je wel', '"Wed Jun 28 2023 12:04:31 GMT+0200 (Midden-Europese zomertijd)"','user@test.nl',5001 );