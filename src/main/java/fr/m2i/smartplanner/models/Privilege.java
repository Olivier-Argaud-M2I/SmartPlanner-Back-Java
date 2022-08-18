package fr.m2i.smartplanner.models;


import javax.persistence.*;

@Entity
@Table(name = "privilege")
@NamedQueries({
        @NamedQuery(name="selectAllPrivilege", query="SELECT privilege FROM Privilege privilege"),
        @NamedQuery(name="findPrivilegeById", query="SELECT privilege FROM Privilege privilege WHERE id = :id"),
        @NamedQuery(name="deletePrivilegeById",query ="DELETE FROM Privilege WHERE id = :id")
})
public class Privilege {

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

    public Privilege() {
    }

    public Privilege(String name) {
        this.name = name;
    }

    public Privilege(Integer id, String name) {
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
