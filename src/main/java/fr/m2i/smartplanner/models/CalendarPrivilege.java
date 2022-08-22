package fr.m2i.smartplanner.models;


import javax.persistence.*;

@Entity
@Table(name = "calendar_privilege")
@NamedQueries({
        @NamedQuery(name="selectAllCalendarPrivilege", query="SELECT calendarPrivilege FROM CalendarPrivilege calendarPrivilege"),
        @NamedQuery(name="findCalendarPrivilegeById", query="SELECT calendarPrivilege FROM CalendarPrivilege calendarPrivilege WHERE id = :id"),
        @NamedQuery(name="deleteCalendarPrivilegeById",query ="DELETE FROM CalendarPrivilege WHERE id = :id")
})
public class CalendarPrivilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CalendarPrivilege() {
    }

    public CalendarPrivilege(String name) {
        this.name = name;
    }

    public CalendarPrivilege(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "name='" + name + '\'' +
                '}';
    }
}
