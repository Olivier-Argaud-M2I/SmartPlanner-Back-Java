package fr.m2i.smartplanner.resources;



import fr.m2i.smartplanner.cruds.UserCrud;
import fr.m2i.smartplanner.dtos.UserDto;
import fr.m2i.smartplanner.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/users")
public class UserResources {

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto getUserById(@PathParam("id")int id,@Context HttpServletRequest request){
        User user1 = (User)request.getAttribute("user");
        if(user1.hasPrivilege("read user")){
            UserCrud userCrud = new UserCrud();
            return new UserDto(userCrud.getUserById(id));
        }
        return null;
    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDto> getUsers(@Context HttpServletRequest request){
        User user1 = (User)request.getAttribute("user");
        if(user1.hasPrivilege("read user")){
            UserCrud userCrud = new UserCrud();
            List<UserDto> userDtos = userCrud.getUsers().stream().map(user -> new UserDto(user)).collect(Collectors.toList());
            return userDtos;
        }
        return null;
    }


    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User saveUser(User user,@Context HttpServletRequest request){
        User user1 = (User)request.getAttribute("user");
        if(user1.hasPrivilege("create user")){
            UserCrud userCrud = new UserCrud();
            return userCrud.saveUser(user);
        }
        return null;

    }


    @POST
    @Path("/delete/{id}")
    public void deleteUser(@PathParam("id")int id,@Context HttpServletRequest request){
        User user1 = (User)request.getAttribute("user");
        if(user1.hasPrivilege("delete user")){
            UserCrud userCrud = new UserCrud();
            userCrud.deleteUserById(id);
        }
    }





}
