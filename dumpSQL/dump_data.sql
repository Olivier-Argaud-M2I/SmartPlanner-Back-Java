


INSERT INTO user(user_name,password,first_name,last_name,email,telephone) VALUES
('admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','admin','ADMIN','admin@smartplanner.com','01 23 45 67 89'),
('olivier','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','olivier','ARGAUD','o.argaud@smartplanner.com','01 23 45 67 88'),
('melvin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','melvin','DOLET','m.dolet@smartplanner.com','01 23 45 67 87'),
('enzo','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','enzo','FARINOT','e.farinot@smartplanner.com','01 23 45 67 88'),
('mills','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Bernard','Flynn','sit.amet@protonmail.couk','03 22 86 44 26'),
('molman','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Hedley','Oliver','fermentum.convallis@aol.ca','05 65 14 91 73'),
('malone','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Tanner','Williams','ipsum.dolor.sit@aol.org','08 72 18 28 78'),
('reese','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Kennan','Cox','enim.condimentum@outlook.ca','09 51 17 08 81'),
('everett','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Arsenio','Stephens','in.condimentum@icloud.edu','05 65 28 61 26'),
('watkins','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Elvis','Rios','fermentum.metus@icloud.net','03 35 61 15 42'),
('wolf','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Dean','Mcclure','egestas@google.couk','03 83 08 76 34'),
('shaw','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Marvin','Edwards','sapien.cursus@aol.com','05 31 11 35 22'),
('bright','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Aquila','Sherman','dignissim.magna@google.edu','05 32 28 82 53'),
('holder','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Reese','Bryan','varius.et.euismod@aol.net','04 46 17 11 66'),
('jimenez','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Xanthus','Whitney','libero.proin@google.com','06 49 74 74 29'),
('sweet','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Basil','Lee','placerat.velit@google.net','03 33 57 13 56'),
('flynn','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Cullen','Mayer','ullamcorper@hotmail.com','04 26 86 28 05'),
('webb','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Aaron','Griffin','velit.aliquam@outlook.org','09 92 57 75 28'),
('mcintosh','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Hedley','Fernandez','urna.nullam@aol.net','05 32 87 21 97'),
('hartman','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Asher','Clark','mauris.eu.turpis@yahoo.net','03 53 34 23 87'),
('lowery','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Kuame','Pacheco','a.arcu@google.org','04 31 86 15 96'),
('martinez','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Samson','Ellis','ac.tellus@icloud.com','04 42 91 41 91'),
('cote','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Ezra','Gallagher','nec.leo@protonmail.com','06 67 14 58 24'),
('norton','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','Connor','Huber','scelerisque.lorem@yahoo.ca','08 98 72 48 67');



INSERT INTO privilege(name) VALUES ('crudrole');
INSERT INTO privilege(name) VALUES ('crudprivilege');
INSERT INTO privilege(name) VALUES ('cruduser');
INSERT INTO privilege(name) VALUES ('read user');
INSERT INTO privilege(name) VALUES ('create user');
INSERT INTO privilege(name) VALUES ('delete user');
INSERT INTO privilege(name) VALUES ('read role');
INSERT INTO privilege(name) VALUES ('create role');
INSERT INTO privilege(name) VALUES ('delete role');
INSERT INTO privilege(name) VALUES ('read privilege');
INSERT INTO privilege(name) VALUES ('create privilege');
INSERT INTO privilege(name) VALUES ('delete privilege');


INSERT INTO role(name) VALUES ('Admin');
INSERT INTO role(name) VALUES ('Ressources Humaines');
INSERT INTO role(name) VALUES ('Responsable de projet');
INSERT INTO role(name) VALUES ('Scrum Master');
INSERT INTO role(name) VALUES ('Tech Lead');
INSERT INTO role(name) VALUES ('Ingénieur Logiciel');
INSERT INTO role(name) VALUES ('Collaborateur');


INSERT INTO calendar_privilege(name) VALUES ('read event');
INSERT INTO calendar_privilege(name) VALUES ('modify event');
INSERT INTO calendar_privilege(name) VALUES ('create event');
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



