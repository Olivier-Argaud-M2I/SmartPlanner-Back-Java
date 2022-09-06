package fr.m2i.smartplanner.models;

import javax.persistence.*;

@Entity
@Table(name="events")
@NamedQueries({
        @NamedQuery(name="selectAllEvents", query="SELECT event FROM Events event ORDER BY date_debut_timestamp DESC"),
        @NamedQuery(name="selectEventsByUser", query="SELECT event FROM Events event WHERE user_id = :idUser ORDER BY date_debut_timestamp DESC"),
        @NamedQuery(name="findEventById", query="SELECT event FROM Events event WHERE id=:id ORDER BY date_debut_timestamp DESC"),
        @NamedQuery(name="selectAllEventsByUserId", query="SELECT event FROM Events event WHERE user_id=:idUser ORDER BY date_debut_timestamp"),
        @NamedQuery(name="selectAllEventsByDay", query="SELECT event FROM Events event WHERE date_debut_timestamp BETWEEN :timestamp1 AND :timestamp2 ORDER BY date_debut_timestamp ASC"),
        @NamedQuery(name="selectAllEventsByRangeAndUserId", query="SELECT event FROM Events event WHERE user_id=:idUser AND date_debut_timestamp BETWEEN :timestamp1 AND :timestamp2 ORDER BY date_debut_timestamp ASC")
})
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="user_id")
    private Integer user_id;
    @Column(name="date_debut_timestamp")
    private Long date_debut_timestamp;
    @Column(name="date_fin_timestamp")
    private Long date_fin_timestamp;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Long getDate_debut_timestamp() {
        return date_debut_timestamp;
    }

    public void setDate_debut_timestamp(Long date_debut_timestamp) {
        this.date_debut_timestamp = date_debut_timestamp;
    }

    public Long getDate_fin_timestamp() {
        return date_fin_timestamp;
    }

    public void setDate_fin_timestamp(Long date_fin_timestamp) {
        this.date_fin_timestamp = date_fin_timestamp;
    }

    public Events(){}

    public Events(Integer id, String name, String description, Integer userId, Long dateDebutTimestamp, Long dateFinTimestamp){
        this.id=id;
        this.name=name;
        this.description=description;
        this.user_id=userId;
        this.date_debut_timestamp=dateDebutTimestamp;
        this.date_fin_timestamp=dateFinTimestamp;
    }

}