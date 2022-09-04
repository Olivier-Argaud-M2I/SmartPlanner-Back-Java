package fr.m2i.smartplanner.models;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name="user")
@NamedQueries({
        @NamedQuery(name="selectAllUser", query="SELECT user FROM User user"),
        @NamedQuery(name="findUserById", query="SELECT user FROM User user WHERE id = :id"),
        @NamedQuery(name="findUserByUsername", query="SELECT user FROM User user WHERE user.userName = :username"),
        @NamedQuery(name="deleteUserById",query ="DELETE FROM User WHERE id = :id")

})
//@NamedNativeQueries({
//        @NamedNativeQuery(name = "selectAllCollaboratorById",query = "SELECT u.* FROM user u JOIN collaborator c on u.id = c.collab_id  WHERE c.user_id=:id"),
//        @NamedNativeQuery(name = "selectAllCollaboratorPossibleById",query = "SELECT u.* FROM user u JOIN collaborator c on u.id = c.collab_id  WHERE c.user_id!=:id")
//})
public class User implements Serializable {

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

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "telephone")
    private String telephone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Role role;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
        return getRole().getPrivileges().stream().map(priv -> priv.getName()).collect(Collectors.toList()).contains(privilege);
    }

}
