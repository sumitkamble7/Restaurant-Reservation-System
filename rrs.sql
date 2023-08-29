drop database if exists project_rrs;   

create database project_rrs;

use project_rrs;

SELECT * FROM category;

insert into category (cat_id, category) values (1, 'Veg');

insert into category (category) values ('Non_Veg');


SELECT * FROM user;

insert into user(email, fname, lname, password, phone_number) 
values ('sumit@gmail.com','sumit','kamble','sumit@123','9876543201');

insert into user(email, fname, lname, password, phone_number) 
values ('omkar@gmail.com','omkar','lende','omkar@123','9786451023');


SELECT * FROM hotel_owner;

insert into hotel_owner(email, fname, lname, password, phone_number) 
values ('rahul@gmail.com','rahul','hulsure','rahul@123','8794653014');

insert into hotel_owner(email, fname, lname, password, phone_number) 
values ('somnath@gmail.com','somnath','gaikwad','somnath@123','7890123458');


SELECT * FROM hotel;

insert into hotel(address, capacity, hotel_name, ratings, status, category_id, hotel_owner_id)
values ('Jangali Maharaj Rd, Shivajinagar, Pune, Maharashtra 411004', 45,'Shiv Sagar Veg Restaurant', 4.5, 0, 1, 1);

insert into hotel(address, capacity, hotel_name, ratings, status, category_id, hotel_owner_id)
values ('Kapila Building, Satara Rd, Pune, Maharashtra 411043', 50,'Jai Bhavani Restaurant', 4.3, 0, 2, 2);



SELECT * FROM veg_menu;

insert into veg_menu(item, price, hotel_id) values ('Pav Bhaji',200,1);
insert into veg_menu(item, price, hotel_id) values ('Masala Dosa',150,1);
insert into veg_menu(item, price, hotel_id) values ('Punjabi Thali',250,1);


SELECT * FROM nonveg_menu;

insert into nonveg_menu(item, price, hotel_id) values ('Chicken Thali',300,2);
insert into nonveg_menu(item, price, hotel_id) values ('Mutton Thali',400,2);
insert into nonveg_menu(item, price, hotel_id) values ('Chicken Dum Birayni',350,2);

update hotel
SET image_name = 'shivsagar.jpg'  
WHERE hotel_id = 1;

update hotel
SET image_name = 'JaiBhavani.jpeg'  
WHERE hotel_id = 2;