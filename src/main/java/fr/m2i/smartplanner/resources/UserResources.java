package fr.m2i.smartplanner.resources;


import fr.m2i.smartplanner.cruds.RoleCrud;
import fr.m2i.smartplanner.cruds.UserCrud;
import fr.m2i.smartplanner.dtos.UserDto;
import fr.m2i.smartplanner.models.Role;
import fr.m2i.smartplanner.models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/users")
public class UserResources {

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto getUserById(@PathParam("id")int id){
        UserCrud userCrud = new UserCrud();
        return new UserDto(userCrud.getUserById(id));
    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDto> getUsers(){
        UserCrud userCrud = new UserCrud();
        List<UserDto> userDtos = userCrud.getUsers().stream().map(user -> new UserDto(user)).collect(Collectors.toList());
        return userDtos;
    }


    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User saveUser(User user){
        UserCrud userCrud = new UserCrud();
        return userCrud.saveUser(user);
    }


    @POST
    @Path("/delete/{id}")
    public void deleteUser(@PathParam("id")int id){
        UserCrud userCrud = new UserCrud();
        userCrud.deleteUserById(id);
    }


//    @POST
//    @Path("/log")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public UserDto login(User user){
//        UserCrud userCrud = new UserCrud();
//        try{
//            User user1 = userCrud.getUserByName(user.getUserName());
//            if(user.getPassword().equals(user1.getPassword())){
//
//                return new UserDto(user1);
//            }
//            return null;
//        }
//        catch (Exception e){
//            return null;
//        }
//
//    }



}
