package fr.m2i.smartplanner.resources;


import fr.m2i.smartplanner.cruds.PrivilegeCrud;
import fr.m2i.smartplanner.cruds.RoleCrud;
import fr.m2i.smartplanner.cruds.UserCrud;
import fr.m2i.smartplanner.models.Privilege;
import fr.m2i.smartplanner.models.Role;
import fr.m2i.smartplanner.models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/roles")
public class RoleResources {

    @GET
    @Path("/role/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Role getRoleById(@PathParam("id")int id){
        RoleCrud roleCrud = new RoleCrud();
        return roleCrud.getRoleById(id);
    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Role> getRoles(){
        RoleCrud roleCrud = new RoleCrud();
        return roleCrud.getRoles();
    }


    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Role saveRole(Role role){
        RoleCrud roleCrud = new RoleCrud();
        return roleCrud.saveRole(role);
    }


    @POST
    @Path("/delete/{id}")
    public void deleteRole(@PathParam("id")int id){
        RoleCrud roleCrud = new RoleCrud();
        roleCrud.deleteRoleById(id);
    }



}
