

INSERT INTO user(user_name,password,first_name,last_name,email,telephone) VALUES
('admin','d033e22ae348aeb5660fc2140aec35850c4da997','admin','ADMIN','adminadmin@smartplanner.com','01 23 45 67 89'),
('olivier','d033e22ae348aeb5660fc2140aec35850c4da997','olivier','ARGAUD','o.ARGAUD@smartplanner.com','01 23 45 67 88'),
('melvin','d033e22ae348aeb5660fc2140aec35850c4da997','melvin','DOLET','m.DOLET@smartplanner.com','01 23 45 67 87'),
('enzo','d033e22ae348aeb5660fc2140aec35850c4da997','enzo','FARINOT','e.FARINOT@smartplanner.com','01 23 45 67 88'),
('Mills','d033e22ae348aeb5660fc2140aec35850c4da997','Bernard','Flynn','sit.amet@protonmail.couk','03 22 86 44 26'),
('Holman','d033e22ae348aeb5660fc2140aec35850c4da997','Hedley','Oliver','fermentum.convallis@aol.ca','05 65 14 91 73'),
('Malone','d033e22ae348aeb5660fc2140aec35850c4da997','Tanner','Williams','ipsum.dolor.sit@aol.org','08 72 18 28 78'),
('Reese','d033e22ae348aeb5660fc2140aec35850c4da997','Kennan','Cox','enim.condimentum@outlook.ca','09 51 17 08 81'),
('Everett','d033e22ae348aeb5660fc2140aec35850c4da997','Arsenio','Stephens','in.condimentum@icloud.edu','05 65 28 61 26'),
('Watkins','d033e22ae348aeb5660fc2140aec35850c4da997','Elvis','Rios','fermentum.metus@icloud.net','03 35 61 15 42'),
('Wolf','d033e22ae348aeb5660fc2140aec35850c4da997','Dean','Mcclure','egestas@google.couk','03 83 08 76 34'),
('Shaw','d033e22ae348aeb5660fc2140aec35850c4da997','Marvin','Edwards','sapien.cursus@aol.com','05 31 11 35 22'),
('Bright','d033e22ae348aeb5660fc2140aec35850c4da997','Aquila','Sherman','dignissim.magna@google.edu','05 32 28 82 53'),
('Holder','d033e22ae348aeb5660fc2140aec35850c4da997','Reese','Bryan','varius.et.euismod@aol.net','04 46 17 11 66'),
('Jimenez','d033e22ae348aeb5660fc2140aec35850c4da997','Xanthus','Whitney','libero.proin@google.com','06 49 74 74 29'),
('Sweet','d033e22ae348aeb5660fc2140aec35850c4da997','Basil','Lee','placerat.velit@google.net','03 33 57 13 56'),
('Flynn','d033e22ae348aeb5660fc2140aec35850c4da997','Cullen','Mayer','ullamcorper@hotmail.com','04 26 86 28 05'),
('Webb','d033e22ae348aeb5660fc2140aec35850c4da997','Aaron','Griffin','velit.aliquam@outlook.org','09 92 57 75 28'),
('Mcintosh','d033e22ae348aeb5660fc2140aec35850c4da997','Hedley','Fernandez','urna.nullam@aol.net','05 32 87 21 97'),
('Hartman','d033e22ae348aeb5660fc2140aec35850c4da997','Asher','Clark','mauris.eu.turpis@yahoo.net','03 53 34 23 87'),
('Lowery','d033e22ae348aeb5660fc2140aec35850c4da997','Kuame','Pacheco','a.arcu@google.org','04 31 86 15 96'),
('Martinez','d033e22ae348aeb5660fc2140aec35850c4da997','Samson','Ellis','ac.tellus@icloud.com','04 42 91 41 91'),
('Cote','d033e22ae348aeb5660fc2140aec35850c4da997','Ezra','Gallagher','nec.leo@protonmail.com','06 67 14 58 24'),
('Norton','d033e22ae348aeb5660fc2140aec35850c4da997','Connor','Huber','scelerisque.lorem@yahoo.ca','08 98 72 48 67');



INSERT INTO privilege(name) VALUES ('crudrole');
INSERT INTO privilege(name) VALUES ('crudprivilege');
INSERT INTO privilege(name) VALUES ('cruduser');


INSERT INTO role(name) VALUES ('Admin');
INSERT INTO role(name) VALUES ('User');
INSERT INTO role(name) VALUES ('Visitor');


INSERT INTO calendar_privilege(name) VALUES ('lecture');
INSERT INTO calendar_privilege(name) VALUES ('modify event');
INSERT INTO calendar_privilege(name) VALUES ('ajout event');
INSERT INTO calendar_privilege(name) VALUES ('delete event');



INSERT INTO role_privilege(role_id, privilege_id) VALUES (1,1);
INSERT INTO role_privilege(role_id, privilege_id) VALUES (1,2);
INSERT INTO role_privilege(role_id, privilege_id) VALUES (1,3);


INSERT INTO user_role(user_id, role_id) VALUES (1,1);
INSERT INTO user_role(user_id, role_id) VALUES (2,1);
INSERT INTO user_role(user_id, role_id) VALUES (3,1);
INSERT INTO user_role(user_id, role_id) VALUES (4,1);


INSERT INTO user_role(user_id, role_id) VALUES (5,3);
INSERT INTO user_role(user_id, role_id) VALUES (6,3);
INSERT INTO user_role(user_id, role_id) VALUES (7,3);
INSERT INTO user_role(user_id, role_id) VALUES (8,3);
INSERT INTO user_role(user_id, role_id) VALUES (9,3);
INSERT INTO user_role(user_id, role_id) VALUES (10,3);
INSERT INTO user_role(user_id, role_id) VALUES (11,3);
INSERT INTO user_role(user_id, role_id) VALUES (12,3);
INSERT INTO user_role(user_id, role_id) VALUES (13,3);
INSERT INTO user_role(user_id, role_id) VALUES (14,3);
INSERT INTO user_role(user_id, role_id) VALUES (15,3);
INSERT INTO user_role(user_id, role_id) VALUES (16,3);
INSERT INTO user_role(user_id, role_id) VALUES (17,3);
INSERT INTO user_role(user_id, role_id) VALUES (18,3);
INSERT INTO user_role(user_id, role_id) VALUES (19,3);
INSERT INTO user_role(user_id, role_id) VALUES (20,3);
INSERT INTO user_role(user_id, role_id) VALUES (21,3);
INSERT INTO user_role(user_id, role_id) VALUES (22,3);
INSERT INTO user_role(user_id, role_id) VALUES (23,3);




INSERT INTO contact(user_id, collab_id) VALUES (1,2);
INSERT INTO contact(user_id, collab_id) VALUES (2,1);

INSERT INTO contact_calendar_privilege(contact_id, calendar_privilege_id) VALUES (1,2);
INSERT INTO contact_calendar_privilege(contact_id, calendar_privilege_id) VALUES (1,3);

INSERT INTO contact_calendar_privilege(contact_id, calendar_privilege_id) VALUES (2,1);
INSERT INTO contact_calendar_privilege(contact_id, calendar_privilege_id) VALUES (2,3);



