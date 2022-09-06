package fr.m2i.smartplanner.resources;


import fr.m2i.smartplanner.cruds.EventsCrud;
import fr.m2i.smartplanner.models.Events;
import fr.m2i.smartplanner.utils.DateManipulation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
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
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Events createEvent(Events events){
        EventsCrud eventsCrud = new EventsCrud();
        return eventsCrud.createEvent(events);
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Events updateEvent(Events events){
        EventsCrud eventsCrud = new EventsCrud();
        return eventsCrud.updateEvent(events);
    }


    @POST
    @Path("/delete/{id}")
    public void deleteEvent(@PathParam("id")int id){
        EventsCrud eventsCrud = new EventsCrud();
        eventsCrud.deleteEventById(id);
    }

    @GET
    @Path("/allByUserId/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Events> getEventsByUserId(@PathParam("userId")Integer idUser){
        EventsCrud eventsCrud = new EventsCrud();
        return eventsCrud.getEventsByUserId(idUser);
    }

    @GET
    @Path("/allByDay/{timestamp}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Events> getEventsByDay(@PathParam("timestamp")Long timestamp) throws ParseException {
        EventsCrud eventsCrud = new EventsCrud();
        return eventsCrud.getEventsByDay(timestamp);
    }

    @GET
    @Path("/allByDayAndUserId/{id}/{timestamp}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Events> getEventsByDayAndUserId(@PathParam("timestamp")Long timestamp,@PathParam("id")Integer id) throws ParseException {
        EventsCrud eventsCrud = new EventsCrud();
        return eventsCrud.getEventsByDayAndUserId(timestamp,id);
    }

    @GET
    @Path("/allByWeekAndUserId/{id}/{timestamp}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Events> getEventsByWeekAndUserId(@PathParam("timestamp")Long timestamp,@PathParam("id")Integer id) throws ParseException {
        EventsCrud eventsCrud = new EventsCrud();
        return eventsCrud.getEventsByWeekAndUserId(timestamp,id);
    }

    @GET
    @Path("/allByMonthAndUserId/{id}/{timestamp}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Events> getEventsByMonthAndUserId(@PathParam("timestamp")Long timestamp,@PathParam("id")Integer id) throws ParseException {
        EventsCrud eventsCrud = new EventsCrud();
        return eventsCrud.getEventsByMonthAndUserId(timestamp,id);
    }

}
