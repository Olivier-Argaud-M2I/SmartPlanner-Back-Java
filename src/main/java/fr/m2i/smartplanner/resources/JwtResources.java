package fr.m2i.smartplanner.resources;


import fr.m2i.smartplanner.cruds.UserCrud;
import fr.m2i.smartplanner.dtos.UserDto;
import fr.m2i.smartplanner.models.JwtResponse;
import fr.m2i.smartplanner.models.User;
import fr.m2i.smartplanner.services.JwtService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/jwt")
public class JwtResources {


    JwtService jwtService = new JwtService();




    @POST
    @Path("/log")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JwtResponse login(User user){
        UserCrud userCrud = new UserCrud();
        try{
            User user1 = userCrud.getUserByName(user.getUserName());
            if(user.getPassword().equals(user1.getPassword())){

//                return new UserDto(user1);
                return jwtService.createJwtToken(user1);
            }
            return null;
        }
        catch (Exception e){
            return null;
        }

    }


}
