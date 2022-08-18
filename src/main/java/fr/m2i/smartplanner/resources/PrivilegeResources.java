package fr.m2i.smartplanner.resources;


import fr.m2i.smartplanner.cruds.PrivilegeCrud;
import fr.m2i.smartplanner.models.Privilege;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/privileges")
public class PrivilegeResources {


    @GET
    @Path("/privilege/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Privilege getPrivilegeById(@PathParam("id")int id){
        PrivilegeCrud privilegeCrud = new PrivilegeCrud();
        return privilegeCrud.getPrivilegeById(id);
    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Privilege> getPrivileges(){
        PrivilegeCrud privilegeCrud = new PrivilegeCrud();
        return privilegeCrud.getPrivileges();
    }


    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Privilege savePrivilege(Privilege privilege){
        PrivilegeCrud privilegeCrud = new PrivilegeCrud();
        return privilegeCrud.savePrivilege(new Privilege(privilege.getName()));
    }


    @POST
    @Path("/delete/{id}")
    public void deletePrivilege(@PathParam("id")int id){
        PrivilegeCrud privilegeCrud = new PrivilegeCrud();
        privilegeCrud.deletePrivilegeById(id);
    }

}
