insert into patient values (1,'a','a',true,'a','pera','pera','$2y$10$8zaNcQyi4ODHJPhWldm87.Kx1r3LrwhB3yb6vApKpVXC2Ia1Ky86q',
						   null,'pera', 0,0);
	
insert into authority values (1,'ROLE_PATIENT');
insert into user_authority values (1,1);

insert into drug(id, name,code,loyality_points, drug_specification_id) values (1, 'Aspirin','231432', 5, 1);
insert into drug(id, name,code,loyality_points, drug_specification_id) values (2, 'Bensedin','125697', 3, 2);
insert into drug(id, name,code,loyality_points, drug_specification_id) values (3, 'Bisoprolol','365895', 4, 3);
insert into drug(id, name,code,loyality_points, drug_specification_id) values (4, 'Brufen','023547', 5, 4);
insert into drug(id, name,code,loyality_points, drug_specification_id) values (5, 'Probiotic','785493', 5, 5);

insert into drug_allergies(id, drug_id, patient_id) values (1, 1, 1);
insert into drug_allergies(id, drug_id, patient_id) values (2, 2, 1);
insert into drug_allergies(id, drug_id, patient_id) values (3, 3, 1);