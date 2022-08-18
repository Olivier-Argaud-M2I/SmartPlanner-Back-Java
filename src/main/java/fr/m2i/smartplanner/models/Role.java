package fr.m2i.smartplanner.models;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
@NamedQueries({
        @NamedQuery(name="selectAllRole", query="SELECT role FROM Role role"),
        @NamedQuery(name="findRoleById", query="SELECT role FROM Role role WHERE id = :id"),
        @NamedQuery(name="deleteRoleById",query ="DELETE FROM Role WHERE id = :id")
})
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="role_privilege",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id")
    )
    private Set<Privilege> privilegeList;

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

    public Set<Privilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(Set<Privilege> privilegeList) {
        this.privilegeList = privilegeList;
    }

    public Role() {
    }

    public Role(Integer id, String name, Set<Privilege> privilegeList) {
        this.id = id;
        this.name = name;
        this.privilegeList = privilegeList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
//                ", privilegeList=" + privilegeList +
                '}';
    }
}
