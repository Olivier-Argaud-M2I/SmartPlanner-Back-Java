

INSERT INTO user(user_name,password,first_name,last_name) VALUES ('admin','admin','admin','admin');
INSERT INTO user(user_name,password,first_name,last_name) VALUES ('user','user','user','user');
INSERT INTO user(user_name,password,first_name,last_name) VALUES ('visitor','visitor','visitor','visitor');


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
INSERT INTO user_role(user_id, role_id) VALUES (2,2);
INSERT INTO user_role(user_id, role_id) VALUES (3,3);




INSERT INTO contact(user_id, collab_id) VALUES (1,2);
INSERT INTO contact(user_id, collab_id) VALUES (2,1);

INSERT INTO contact_calendar_privilege(contact_id, calendar_privilege_id) VALUES (1,2);
INSERT INTO contact_calendar_privilege(contact_id, calendar_privilege_id) VALUES (1,3);

INSERT INTO contact_calendar_privilege(contact_id, calendar_privilege_id) VALUES (2,1);
INSERT INTO contact_calendar_privilege(contact_id, calendar_privilege_id) VALUES (2,3);



