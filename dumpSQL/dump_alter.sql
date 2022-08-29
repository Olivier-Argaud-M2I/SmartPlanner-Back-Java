
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



