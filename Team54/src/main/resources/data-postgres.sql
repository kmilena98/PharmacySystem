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
