package fr.m2i.smartplanner.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="contact")
@NamedQueries({
        @NamedQuery(name="selectAllContactByUser", query="SELECT contact FROM Contact contact WHERE contact.user.id = :id"),
        @NamedQuery(name="getContactByIds", query="SELECT contact FROM Contact contact WHERE contact.user.id = :idU AND contact.collaborator.id = :idC"),

})
public class Contact{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "collab_id")
    private User collaborator;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name="contact_calendar_privilege",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "calendar_privilege_id")
    )
    private Set<CalendarPrivilege> CalendarPrivilege;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(User collaborator) {
        this.collaborator = collaborator;
    }

    public Set<fr.m2i.smartplanner.models.CalendarPrivilege> getCalendarPrivilege() {
        return CalendarPrivilege;
    }

    public void setCalendarPrivilege(Set<fr.m2i.smartplanner.models.CalendarPrivilege> calendarPrivilege) {
        CalendarPrivilege = calendarPrivilege;
    }

    public Contact() {
    }

    public Contact(User user, User collaborator) {
        this.user = user;
        this.collaborator = collaborator;
    }

    public Contact(Integer id, User user, User collaborator, Set<fr.m2i.smartplanner.models.CalendarPrivilege> calendarPrivilege) {
        this.id = id;
        this.user = user;
        this.collaborator = collaborator;
        CalendarPrivilege = calendarPrivilege;
    }
}
