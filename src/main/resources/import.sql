--INSERT INTO USERS (password,email,is_active,is_admin) VALUES ('1111', 'mirko@gmail.com',TRUE, FALSE)
INSERT INTO ADDRESSES(country,city,zip_code,street_address) VALUES ('Zemlja1','Grad1',11111,'Adresa1');

INSERT INTO USERS (username,password,first_name,last_name,email,enabled,followers_count,address_id) VALUES ('bunny1', '$2a$10$IRvxaFqh6oX8wJUDRDIuiuKNE9lr5Q6n0qlV6cgLSxwVIyRp1GFNS','Pero', 'Peric','pero.peric@gmail.com',TRUE,0,1);


INSERT INTO ROLE (name) VALUES ('ROLE_USER');
INSERT INTO ROLE (name) VALUES ('ROLE_ADMIN');

INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 1);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 2);

INSERT INTO LOCATION(address,longitude,latitude) VALUES ('po',0,0);

INSERT INTO POST (description,image_path,location_id,user_id,likes, created_at) VALUES ('po','src\\main\\resources\\static\\pictures\\landing1.jpg',1,1,100, '2024-11-07 14:11:49.90685');