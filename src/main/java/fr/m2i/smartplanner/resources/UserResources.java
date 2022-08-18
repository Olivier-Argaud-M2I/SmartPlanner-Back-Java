package fr.m2i.smartplanner.resources;


import fr.m2i.smartplanner.cruds.UserCrud;
import fr.m2i.smartplanner.models.User;

import javax.ws.rs.*;
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

    @POST
    @Path("/log")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User login(User user){
        UserCrud userCrud = new UserCrud();
        try{
            User user1 = userCrud.getUserByName(user.getUserName());
            if(user.getPassword().equals(user1.getPassword())){
                return user1;
            }
            return null;
        }
        catch (Exception e){
            return null;
        }

    }


}
