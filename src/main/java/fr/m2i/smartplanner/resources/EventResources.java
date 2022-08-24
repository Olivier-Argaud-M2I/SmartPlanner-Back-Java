package fr.m2i.smartplanner.resources;


import fr.m2i.smartplanner.cruds.EventsCrud;
import fr.m2i.smartplanner.cruds.PrivilegeCrud;
import fr.m2i.smartplanner.models.Events;
import fr.m2i.smartplanner.models.Privilege;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/events")
public class EventResources {


    @GET
    @Path("/event/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Events getEventById(@PathParam("id")int id){
        EventsCrud eventsCrud = new EventsCrud();
        return eventsCrud.getEventById(id);
    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Events> getEvents(){
        EventsCrud eventsCrud = new EventsCrud();
        return eventsCrud.getEvents();
    }


    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Events saveEvent(Events events){
        EventsCrud eventsCrud = new EventsCrud();
        return eventsCrud.saveEvent(events);
    }


    @POST
    @Path("/delete/{id}")
    public void deleteEvent(@PathParam("id")int id){
        EventsCrud eventsCrud = new EventsCrud();
        eventsCrud.deleteEventById(id);
    }

}
