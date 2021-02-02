insert into authority(id,name) values (1,'ROLE_PATIENT');
insert into authority(id,name) values (2, 'ROLE_SYSTEM_ADMIN');
insert into authority(id,name) values (3, 'ROLE_PHARMACY_ADMIN');
insert into authority(id,name) values (4, 'ROLE_DERMATOLOGIST');
insert into authority(id,name) values (5, 'ROLE_PHARMACIST');
insert into authority(id,name) values (6, 'ROLE_SUPPLIER');

insert into contraindications(id,name) values (1, 'Preosetljivost na metronidazol');
insert into contraindications(id,name) values (2, 'Abdominalni bol');
insert into contraindications(id,name) values (3, 'Pogoršanje astme');
insert into contraindications(id,name) values (4, 'Deca mlađa od 2 godine');

/* pera@gmail.com, pera */
insert into dermatologist(id,address, city, country, email, name, password, phone_number, surname, price, rating) 
values (1,'Jovana Ducica 22','Beograd','Srbija','pera@gmail.com','Pera','$2y$10$4pqzt42GblUIbx6vrwSGhObU5wtpGd1EaCXSLqnXh0dIeouX5P98e',
		'231432123','Peric', 1500, 4.7);
		
/* zika@gmail.com, zika */
insert into dermatologist(id,address, city, country, email, name, password, phone_number, surname, price, rating) 
values (2,'Janka Cmelika 9','Novi Sad','Srbija','zika@gmail.com','Zika','$2y$10$MN616XcMIPO4vqY2bjNEQO97f9mmT6fbFuinbLLylKr0QrJoIJSWm',
		'0617788996','Zikic', 2000, 4.1);
		
/* marko@gmail.com, marko */
insert into dermatologist(id,address, city, country, email, name, password, phone_number, surname, price, rating) 
values (3,'Bulevar Oslobodjenja 49','Nis','Srbija','marko@gmail.com','Marko','$2y$10$zsoFKgzcVBAUFgjNLNPrGeIK1Utd7ZBEik9GlhDNYZXA.0yVltuaq',
		'021879554','Markovic', 1700, 4.8);
		
/* petar@gmail.com, petar */
insert into dermatologist(id,address, city, country, email, name, password, phone_number, surname, price, rating) 
values (4,'Trg Slobode 4','Subotica','Srbija','petar@gmail.com','Petar','$2y$10$8a2ynifL9RQtjOOVJA3RfO.LcNzmievmarf54iJTM.fg8LgTtGwbu ',
		'06987445','Petrovic', 1400, 4.6);
		
/* --- PATIENTS --- */
		
/* filip@gmail.com, filip */
insert into patient(id,address, city, country, email, name, password, phone_number, surname, loyalty_points, penalty_points) 
values (5,'Bulevar Mihajla Pupina 2','Beograd','Srbija','filip@gmail.com','Filip','$2y$10$Y8ssB0gdD8hGqvTmAeh6n.ZD7lpKoQkNYlKzUJrCCsjsTy73tGVJS',
		'061985622','Filipovic', 120, 1);
		
/* mihajlo@gmail.com, mihajlo */
insert into patient(id,address, city, country, email, name, password, phone_number, surname, loyalty_points, penalty_points) 
values (6,'Ruzveltova 34','Beograd','Srbija','mihajlo@gmail.com','Mihajlo','$2y$10$RsVLRg9b4gIw8IegArZGi.FGP3IkbG8/97D/TyYjSyslbEDSIzq2.',
		'01147884','Mihajlovic', 10, 0);
		
/* ana@gmail.com, ana */
insert into patient(id,address, city, country, email, name, password, phone_number, surname, loyalty_points, penalty_points) 
values (7,'Bulevar Oslobodjenja 56','Novi Sad','Srbija','ana@gmail.com','Ana','$2y$10$Ot3AbKBsBoZSRign2IFkI.vuY6iuUbKxGhtWJY39D9oH6OGJWbUFq',
		'061985622','Anic', 0, 0);
		
/* kristina@gmail.com, kristina */
insert into patient(id,address, city, country, email, name, password, phone_number, surname, loyalty_points, penalty_points) 
values (8,'Somborski bulevar 97','Zajecar','Srbija','kristina@gmail.com','Kristina','$2y$10$IZLi/JPnH2LrQ9TxyVVhZOpLCY.Z3ZJGp1szResXjLUOFCTb/4vum',
		'061985622','Krstic', 27, 0);



/* --- PHARMACIES --- */
insert into pharmacy values (1,'Narodnoog Fronta 12','gradska apoteka','Apoteka Novi Sad');
insert into pharmacy values (2,'Petra Kocica 3','gradska apoteka','Apoteka Sirmijum');



/* --- PHARMACISTS --- */
		
/* dimitrije@gmail.com, dimi */
insert into pharmacist(id,address, city, country, email, name, password, phone_number, surname, rating, end_date,start_date,pharmacy_id) 
values (9,'Bulevar Mihajla Pupina 2','Zitiste','Srbija','dimitrije@gmail.com','Dimitrije','$2y$10$3vrKs8fQ4UL9h93TCSfOPOGsGYks8rKmvkUPHgwonIfv.8Jl1yQhi',
		'061985022','Bulaja', 50,'2021-03-15','2021-03-01', 1);
		
/* mihajlo@gmail.com, mika */
insert into pharmacist(id,address, city, country, email, name, password, phone_number, surname, rating, end_date,start_date,pharmacy_id) 
values (10,'Ruzveltova 21','Zrenjanin','Srbija','mihajlo@gmail.com','Mihajlo','$2y$10$JIe9RowUDmlOW7vKSDiBnuZup7wo/I0y1l052uWHNaIuWMYPJkB7m ',
		'01147881','Omaljev', 54,'2021-05-29','2021-01-11', 2);

/* mario@gmail.com, kima */		
insert into pharmacist(id,address, city, country, email, name, password, phone_number, surname, rating, end_date,start_date,pharmacy_id) 
values (17,'Bulevar Mihajla Pupina 11','Zrenjanin','Srbija','mario@gmail.com','Mario','$2y$10$zbIaMV.WAa0D4vj7kS274O8awW6OJoC1KIUBiJ3NpgdAjBGtefcy2 ',
		'061985022','Petromanjanc', 33,'2021-09-11','2021-02-11', 1);
		
/* ivica@gmail.com, ivica */
insert into pharmacist(id,address, city, country, email, name, password, phone_number, surname, rating, end_date,start_date,pharmacy_id) 
values (18,'Ruzveltova 21','Zrenjanin','Srbija','mihajlo@gmail.com','Ivica','$2y$10$cavm.nwcllSXz6W8aPjtKuYrkafL9nSPaKDz45LVaHWmRMWJBZXp2  ',
		'01147881','Novakov', 84,'2021-06-29','2021-01-21', 2);
		
/* --- SYSTEM_ADMINISTRATORS --- */
		
/* dejan@gmail.com, deki */
insert into system_administrator(id,address, city, country, email, name, password, phone_number, surname) 
values (11,'Bulevar Oslobodjenja 9','Novi Sad','Srbija','dejan@gmail.com','Dejan','$2y$10$c.hDMq1zCr96WdxerDedN.LwjiWQHUB/1nrpP6XGfLY.gninxZUqG ',
		'061385622','Nedeljkovic');
		
/* nemanja@gmail.com, neca */
insert into system_administrator(id,address, city, country, email, name, password, phone_number, surname) 
values (12,'Somborski bulevar 97','Zvornik','Srbija','nemanja@gmail.com','Nemanja','$2y$10$bRNOF2hrIy9CROZ8ZHcreumOotmoKt6JCxgb3PoigVz0p.VxATlBC ',
		'061981622','Jevtic');

/* --- PHARMACY_ADMINISTRATORS --- */
		
/* milena@gmail.com, milence */
insert into pharmacy_administrator(id,address, city, country, email, name, password, phone_number, surname, pharmacy_id) 
values (13,'Balzakova 1','Novi Sad','Srbija','milena@gmail.com','Milena','$2y$10$7u1AWYA7wW3UkcB2PchaTOnenZwVo0TTSbL9w2I68feFLt/u9vI8G ',
		'061385600','Kovacevic', 1);
		
/* denis@gmail.com, denis */
insert into pharmacy_administrator(id,address, city, country, email, name, password, phone_number, surname, pharmacy_id) 
values (14,'Somborski bulevar 90','Zrenjanin','Srbija','denis@gmail.com','Denis','$2y$10$ihpttwUywTQ2Iw2FBXYfGueEACL239/xdGRguelnU/3GsS4sPxQja ',
		'062981622','Fruza', 2);


/* --- SUPPLIER --- */
		
/* jovan@gmail.com, jovan */
insert into supplier(id,address, city, country, email, name, password, phone_number, surname) 
values (15,'Balzakova 2','Novi Sad','Srbija','jovan@gmail.com','Jovan','$2y$10$GnY077C6faJvHeE8nfEr.e3rFBxQfaY7mz62ChyKiRp/Nchpglw4m ',
		'061385600','Cvijovic');
		
/* danijel@gmail.com, danijel */
insert into supplier(id,address, city, country, email, name, password, phone_number, surname) 
values (16,'Somborski bulevar 91','Zrenjanin','Srbija','danijel@gmail.com','Danijel','$2y$10$tmCL0qXq3J797yMJtd9xmuaaeOVYolsFPZfSPbhm/1rcoJL7DMDZO ',
		'062981622','Novakovic');
		
/* natasa@gmail.com, nata */
insert into supplier(id,address, city, country, email, name, password, phone_number, surname) 
values (19,'Somborski bulevar 99','Zrenjanin','Srbija','natasa@gmail.com','Natasa','$2y$10$SDsigowv761RRb9KIuiYwedVzSWvI05uIiR1o7MTp9QcaXS3fgS/. ',
		'062941622','Subotic');

insert into user_authority values (1,4);
insert into user_authority values (2,4);
insert into user_authority values (3,4);
insert into user_authority values (4,4);
insert into user_authority values (5,1);
insert into user_authority values (6,1);
insert into user_authority values (7,1);
insert into user_authority values (8,1);
insert into user_authority values (9,5);
insert into user_authority values (10,5);
insert into user_authority values (9,5);
insert into user_authority values (17,5);
insert into user_authority values (18,5);
insert into user_authority values (10,5);
insert into user_authority values (11,2);
insert into user_authority values (12,2);
insert into user_authority values (13,3);
insert into user_authority values (14,3);
insert into user_authority values (15,6);
insert into user_authority values (16,6);
insert into user_authority values (19,6);

		
		
insert into drug_specifications(id, suggested_dose) values (1, '20mg');
insert into drug_specifications(id, suggested_dose) values (2, '300mg');
insert into drug_specifications(id, suggested_dose) values (3, '1g');
insert into drug_specifications(id, suggested_dose) values (4, '10mg');
insert into drug_specifications(id, suggested_dose) values (5, '5mg');

insert into drug(id, name,code,loyality_points, drug_specification_id) values (1, 'Aspirin','231432', 5, 1);
insert into drug(id, name,code,loyality_points, drug_specification_id) values (2, 'Bensedin','125697', 3, 2);
insert into drug(id, name,code,loyality_points, drug_specification_id) values (3, 'Bisoprolol','365895', 4, 3);
insert into drug(id, name,code,loyality_points, drug_specification_id) values (4, 'Brufen','023547', 5, 4);
insert into drug(id, name,code,loyality_points, drug_specification_id) values (5, 'Probiotic','785493', 5, 5);

insert into drug_allergies(id, drug_id, patient_id) values (1, 1, 5);
insert into drug_allergies(id, drug_id, patient_id) values (2, 2, 5);
insert into drug_allergies(id, drug_id, patient_id) values (3, 3, 5);
insert into drug_allergies(id, drug_id, patient_id) values (4, 4, 6);
insert into drug_allergies(id, drug_id, patient_id) values (5, 4, 7);

insert into examination_loyalty_points(type, points) values ('DermatologistExamination', 15);
insert into examination_loyalty_points(type, points) values ('PharmacistExamiantion', 10);

insert into vacation_request values (1, 0,'2021-09-11', '2021-08-21', 1, 9);
insert into vacation_request values (2, 0,'2021-10-15', '2021-09-26', 2, 10);
insert into vacation_request values (3, 0,'2021-03-22', '2021-02-19', 3, 17);

insert into promotion values (1,'2021-03-22', '2021-02-19', '20 posto popusta', 1);
insert into promotion values (2,'2021-05-01', '2021-04-20','10 posto popusta' , 1);
insert into promotion values (3,'2021-11-20', '2021-11-26', '20 posto popusta', 2);
insert into promotion values (4,'2021-02-22', '2021-02-17', '30 posto popusta', 2);

insert into drug_in_storage values ( 1, 20, 1, 15);
insert into drug_in_storage values ( 2, 24, 2, 15);
insert into drug_in_storage values ( 3, 50, 3, 15);
insert into drug_in_storage values ( 4, 40, 4, 16);
insert into drug_in_storage values ( 5, 65, 5, 16);
insert into drug_in_storage values ( 6, 25, 1, 16);
insert into drug_in_storage values ( 7, 35, 2, 19);
insert into drug_in_storage values ( 8, 15, 3, 19);
insert into drug_in_storage values ( 9, 10, 4, 19);

insert into supplier_drugs_in_storage values ( 15, 1);
insert into supplier_drugs_in_storage values ( 15, 2);
insert into supplier_drugs_in_storage values ( 15, 3);
insert into supplier_drugs_in_storage values ( 16, 4);
insert into supplier_drugs_in_storage values ( 16, 5);
insert into supplier_drugs_in_storage values ( 16, 6);
insert into supplier_drugs_in_storage values ( 19, 7);
insert into supplier_drugs_in_storage values ( 19, 8);
insert into supplier_drugs_in_storage values ( 19, 9);

insert into orders values ( 1, '2021-02-17', 0, 13);
insert into orders values ( 2, '2021-06-22', 0, 13);
insert into orders values ( 3, '2021-05-08', 0, 14);
insert into orders values ( 4, '2021-01-22', 0, 14);
insert into orders values ( 5, '2021-12-11', 0, 14);


