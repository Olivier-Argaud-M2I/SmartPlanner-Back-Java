
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



# DROP TABLE IF EXISTS `collaborator_by_user_calendar_privilege` ;
# CREATE TABLE `collaborator_by_user_calendar_privilege`(
#     `collab_id` INTEGER ,
#     `user_id` INTEGER ,
#     `calendar_privilege_id` INTEGER
# );



# DROP TABLE IF EXISTS `user_calendar_privilege` ;
# CREATE TABLE `user_calendar_privilege`(
#     `user_id` INTEGER   ,
#     `calendar_privilege_id` INTEGER
# );


# DROP TABLE IF EXISTS `collaborator_by_user` ;
# CREATE TABLE `collaborator_by_user`(
#     `user_id` INTEGER  ,
#     `collab_id` INTEGER
#
# );



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
    description TEXT NOT NULL ,
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
    `last_name` VARCHAR(20) NOT NULL
);
