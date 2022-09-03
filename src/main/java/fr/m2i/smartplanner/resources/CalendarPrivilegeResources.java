package fr.m2i.smartplanner.resources;


import fr.m2i.smartplanner.cruds.CalendarPrivilegeCrud;
import fr.m2i.smartplanner.cruds.PrivilegeCrud;
import fr.m2i.smartplanner.models.CalendarPrivilege;
import fr.m2i.smartplanner.models.Privilege;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/calendarPrivileges")
public class CalendarPrivilegeResources {


    @GET
    @Path("/privilege/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CalendarPrivilege getCalendarPrivilegeById(@PathParam("id")int id){
        CalendarPrivilegeCrud calendarPrivilegeCrud = new CalendarPrivilegeCrud();
        return calendarPrivilegeCrud.getCalendarPrivilegeById(id);
    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CalendarPrivilege> getCalendarPrivileges(){
        CalendarPrivilegeCrud calendarPrivilegeCrud = new CalendarPrivilegeCrud();
        return calendarPrivilegeCrud.getCalendarPrivileges();
    }


//    @POST
//    @Path("/save")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Privilege savePrivilege(Privilege privilege){
//        PrivilegeCrud privilegeCrud = new PrivilegeCrud();
//        return privilegeCrud.savePrivilege(new Privilege(privilege.getName()));
//    }
//
//
//    @POST
//    @Path("/delete/{id}")
//    public void deletePrivilege(@PathParam("id")int id){
//        PrivilegeCrud privilegeCrud = new PrivilegeCrud();
//        privilegeCrud.deletePrivilegeById(id);
//    }

}
