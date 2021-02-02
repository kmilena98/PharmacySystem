insert into patient values (1,'a','a','a','pera','pera','$2y$10$8zaNcQyi4ODHJPhWldm87.Kx1r3LrwhB3yb6vApKpVXC2Ia1Ky86q',
						   null,'pera', 0,0);
						   
insert into patient values (2,'a','a','a','a','pera','$2y$10$ZFOBiqPubrfzeiplrylYN.chSDpvoGg4o0mHSz7wyjre/oglmlUlq',
						   null,'pera', 0,0);

insert into dermatologist values (3,'Jovana Ducica 22','Beograd','Srbija','pera@gmail.com','pera','$2y$10$8zaNcQyi4ODHJPhWldm87.Kx1r3LrwhB3yb6vApKpVXC2Ia1Ky86q',
						   '231432123','pera', 20,5);

insert into authority values (1,'ROLE_PATIENT');
insert into authority values (2, 'ROLE_SISTEM_ADMIN');
insert into authority values (3, 'ROLE_DERMATOLOGIST');
insert into authority values (4, 'ROLE_PHARMACIST');
insert into authority values (5, 'ROLE_ADMIN');
insert into authority values (6, 'ROLE_SUPPLIER');

insert into user_authority values (1,1);
insert into user_authority values (2,2);
insert into user_authority values (3,3);