package fr.m2i.smartplanner.dtos;

import fr.m2i.smartplanner.models.Role;
import fr.m2i.smartplanner.models.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDto {


    private Integer id;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private Role role;

    private Set<UserDto> collaborators;

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


    public Set<UserDto> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(Set<UserDto> collaborators) {
        this.collaborators = collaborators;
    }

    public UserDto() {
    }

public UserDto(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.role = user.getRole();
    }

    public UserDto fromCollaborateur(User collab) {
        UserDto col = new UserDto();
        col.id = collab.getId();
        col.userName = collab.getUserName();
        col.password = collab.getPassword();
        col.firstName = collab.getFirstName();
        col.lastName = collab.getLastName();
        col.role = collab.getRole();
        col.setCollaborators(new HashSet<>());

        return col;
    }



}
