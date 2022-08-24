

CREATE DATABASE IF NOT EXISTS `smartplanner`;
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


DROP TABLE IF EXISTS `user_calendar_privilege` ;
CREATE TABLE `user_calendar_privilege`(
    `user_id` INTEGER   ,
    `collaborator_id` INTEGER   ,
    `privilege_calendar_id` INTEGER
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



DROP TABLE IF EXISTS `user` ;
CREATE TABLE `user`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `user_name` VARCHAR(20) NOT NULL ,
    `password` TEXT NOT NULL ,
    `first_name` VARCHAR(20) NOT NULL ,
    `last_name` VARCHAR(20) NOT NULL
);



DROP TABLE IF EXISTS events ;
CREATE TABLE events(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL ,
    description TEXT NOT NULL ,
    user_id INTEGER NOT NULL ,
    date_debut_timestamp LONG NOT NULL,
    date_fin_timestamp LONG NOT NULL
);



ALTER TABLE user_role ADD CONSTRAINT FK_user_user_role FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE;
ALTER TABLE user_role ADD CONSTRAINT FK_role_user_role FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE;


ALTER TABLE role_privilege ADD CONSTRAINT FK_role_role_privilege FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE;
ALTER TABLE role_privilege ADD CONSTRAINT FK_privilege_role_privilege FOREIGN KEY (privilege_id) REFERENCES privilege (id) ON DELETE CASCADE;


ALTER TABLE user_calendar_privilege ADD CONSTRAINT FK_user_user_calendar_privilege FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE;
ALTER TABLE user_calendar_privilege ADD CONSTRAINT FK_collaborator_user_calendar_privilege FOREIGN KEY (collaborator_id) REFERENCES user (id) ON DELETE CASCADE;
ALTER TABLE user_calendar_privilege ADD CONSTRAINT FK_privilege_calendar_user_calendar_privilege FOREIGN KEY (privilege_calendar_id) REFERENCES calendar_privilege (id) ON DELETE CASCADE;


ALTER TABLE events ADD CONSTRAINT FK_events_user FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE;



INSERT INTO user(user_name,password,first_name,last_name) VALUES ('admin','admin','admin','admin');
INSERT INTO user(user_name,password,first_name,last_name) VALUES ('user','user','user','user');
INSERT INTO user(user_name,password,first_name,last_name) VALUES ('visitor','visitor','visitor','visitor');


INSERT INTO privilege(name) VALUES ('crudrole');
INSERT INTO privilege(name) VALUES ('crudprivilege');
INSERT INTO privilege(name) VALUES ('cruduser');


INSERT INTO role(name) VALUES ('Admin');
INSERT INTO role(name) VALUES ('User');
INSERT INTO role(name) VALUES ('Visitor');


INSERT INTO role_privilege(role_id, privilege_id) VALUES (1,1);
INSERT INTO role_privilege(role_id, privilege_id) VALUES (1,2);
INSERT INTO role_privilege(role_id, privilege_id) VALUES (1,3);


INSERT INTO user_role(user_id, role_id) VALUES (1,1);
INSERT INTO user_role(user_id, role_id) VALUES (2,2);
INSERT INTO user_role(user_id, role_id) VALUES (3,3);