package fr.m2i.smartplanner.resources;


import fr.m2i.smartplanner.cruds.PrivilegeCrud;
import fr.m2i.smartplanner.cruds.RoleCrud;
import fr.m2i.smartplanner.models.Privilege;
import fr.m2i.smartplanner.models.Role;
import fr.m2i.smartplanner.models.User;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/privileges")
public class PrivilegeResources {


    @GET
    @Path("/privilege/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Privilege getPrivilegeById(@PathParam("id")int id, @Context HttpServletRequest request){
        User user1 = (User)request.getAttribute("user");
        if(user1.hasPrivilege("privilegeRead")){
            PrivilegeCrud privilegeCrud = new PrivilegeCrud();
            return privilegeCrud.getPrivilegeById(id);
        }
        return null;
    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Privilege> getPrivileges(@Context HttpServletRequest request){
        User user1 = (User)request.getAttribute("user");
        if(user1.hasPrivilege("privilegeRead")){
            PrivilegeCrud privilegeCrud = new PrivilegeCrud();
            return privilegeCrud.getPrivileges();
        }
        return null;
    }


    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Privilege savePrivilege(Privilege privilege, @Context HttpServletRequest request){
        User user1 = (User)request.getAttribute("user");
        if(user1.hasPrivilege("privilegeCreate")){
            PrivilegeCrud privilegeCrud = new PrivilegeCrud();
            return privilegeCrud.savePrivilege(new Privilege(privilege.getName()));
        }
        return null;
    }


    @POST
    @Path("/delete/{id}")
    public void deletePrivilege(@PathParam("id")int id, @Context HttpServletRequest request){
        User user1 = (User)request.getAttribute("user");
        if(user1.hasPrivilege("privilegeDelete")){
            PrivilegeCrud privilegeCrud = new PrivilegeCrud();
            privilegeCrud.deletePrivilegeById(id);
        }
    }

}
