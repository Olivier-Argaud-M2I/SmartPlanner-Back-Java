package fr.m2i.smartplanner.dtos;

import fr.m2i.smartplanner.models.CalendarPrivilege;
import fr.m2i.smartplanner.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactDto {


    private final String firstName;

    private final String lastName;

    private final List<String> calendarPrivileges;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getCalendarPrivileges() {
        return calendarPrivileges;
    }

    public ContactDto(Contact contact) {
        this.firstName = contact.getCollaborator().getFirstName();
        this.lastName = contact.getCollaborator().getLastName();
        this.calendarPrivileges = new ArrayList<>();
        for (CalendarPrivilege privilege:contact.getCalendarPrivileges()) {
            this.calendarPrivileges.add(privilege.getName());
        }
    }


}
