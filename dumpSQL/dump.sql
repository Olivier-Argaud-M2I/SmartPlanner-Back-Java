
DROP DATABASE IF EXISTS `smartplanner`;
CREATE DATABASE `smartplanner`;
USE `smartplanner`;



DROP TABLE IF EXISTS `user_role` ;
CREATE TABLE `user_role`(
    `user_id` INTEGER  ,
    `role_id` INTEGER
);


DROP TABLE IF EXISTS `role_privilege` ;
CREATE TABLE `role_privilege`(
    `role_id` INTEGER   ,
    `privilege_id` INTEGER
);



DROP TABLE IF EXISTS `contact_calendar_privilege` ;
CREATE TABLE `contact_calendar_privilege`(
    `contact_id` INTEGER  ,
    `calendar_privilege_id` INTEGER

);


DROP TABLE IF EXISTS `contact` ;
CREATE TABLE `contact`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `user_id` INTEGER  ,
    `collab_id` INTEGER

);



DROP TABLE IF EXISTS `calendar_privilege` ;
CREATE TABLE `calendar_privilege`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL
);



DROP TABLE IF EXISTS `role` ;
CREATE TABLE `role`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL
);



DROP TABLE IF EXISTS `privilege` ;
CREATE TABLE `privilege`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20) NOT NULL
);



DROP TABLE IF EXISTS events ;
CREATE TABLE events(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL ,
    description TEXT ,
    user_id INTEGER NOT NULL ,
    date_debut_timestamp LONG NOT NULL,
    date_fin_timestamp LONG NOT NULL
);


DROP TABLE IF EXISTS `user` ;
CREATE TABLE `user`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `user_name` VARCHAR(20) NOT NULL ,
    `password` TEXT NOT NULL ,
    `first_name` VARCHAR(20) NOT NULL ,
    `last_name` VARCHAR(20) NOT NULL,
    `email` VARCHAR(50) NOT NULL ,
    `telephone` VARCHAR(20) NOT NULL

);



ALTER TABLE user_role ADD CONSTRAINT FK_user_user_role FOREIGN KEY (user_id) REFERENCES user (id);
ALTER TABLE user_role ADD CONSTRAINT FK_role_user_role FOREIGN KEY (role_id) REFERENCES role (id);


ALTER TABLE role_privilege ADD CONSTRAINT FK_role_role_privilege FOREIGN KEY (role_id) REFERENCES role (id);
ALTER TABLE role_privilege ADD CONSTRAINT FK_privilege_role_privilege FOREIGN KEY (privilege_id) REFERENCES privilege (id);


ALTER TABLE contact ADD CONSTRAINT FK_contact_user FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE;
ALTER TABLE contact ADD CONSTRAINT FK_contact_collab FOREIGN KEY (collab_id) REFERENCES user (id) ON DELETE CASCADE;

CREATE UNIQUE INDEX contact_unique ON contact (user_id,collab_id);


ALTER TABLE contact_calendar_privilege ADD CONSTRAINT FK_contact_calendar_privilege_contact FOREIGN KEY (contact_id) REFERENCES contact (id) ON DELETE CASCADE;
ALTER TABLE contact_calendar_privilege ADD CONSTRAINT FK_contact_calendar_privilege_calendar_privilege FOREIGN KEY (calendar_privilege_id) REFERENCES calendar_privilege (id) ON DELETE CASCADE;



ALTER TABLE events ADD CONSTRAINT FK_events_user FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE;





INSERT INTO user(user_name,password,first_name,last_name,email,telephone) VALUES ('admin','admin','admin','admin','adminadmin@smartplanner.com','01 23 45 67 89');
INSERT INTO user(user_name,password,first_name,last_name,email,telephone) VALUES ('user','user','user','user','useruser@smartplanner.com','01 23 45 67 88');
INSERT INTO user(user_name,password,first_name,last_name,email,telephone) VALUES ('visitor','visitor','visitor','visitor','visitorvisitor@smartplanner.com','01 23 45 67 87');


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



