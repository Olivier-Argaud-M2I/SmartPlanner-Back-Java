package fr.m2i.smartplanner.models;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
@NamedQueries({
        @NamedQuery(name="selectAllUser", query="SELECT user FROM User user"),
        @NamedQuery(name="findUserById", query="SELECT user FROM User user WHERE id = :id"),
        @NamedQuery(name="findUserByUsername", query="SELECT user FROM User user WHERE user.userName = :username"),
        @NamedQuery(name="deleteUserById",query ="DELETE FROM User WHERE id = :id")

})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "user_name")
    private String userName;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne()
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Role role;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="user_calendar_privilege",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "collaborator_id")
    )
    private List<User> collaborators;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<User> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<User> collaborators) {
        this.collaborators = collaborators;
    }

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(Integer id, String userName, String password, String firstName, String lastName, Role role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;

    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


    public Boolean hasPrivilege(String privilege){
        return getRole().getPrivileges().contains(privilege);
    }

}
