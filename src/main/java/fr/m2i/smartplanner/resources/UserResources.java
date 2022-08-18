package fr.m2i.smartplanner.resources;


import fr.m2i.smartplanner.cruds.UserCrud;
import fr.m2i.smartplanner.models.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserResources {

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id")int id){
        UserCrud userCrud = new UserCrud();
        return userCrud.getUserById(id);
    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(){
        UserCrud userCrud = new UserCrud();
        return userCrud.getUsers();
    }


}
