package fr.m2i.smartplanner.resources;


import fr.m2i.smartplanner.cruds.ContactCrud;
import fr.m2i.smartplanner.cruds.EventsCrud;
import fr.m2i.smartplanner.cruds.RoleCrud;
import fr.m2i.smartplanner.models.Contact;
import fr.m2i.smartplanner.models.Events;
import fr.m2i.smartplanner.models.Role;
import fr.m2i.smartplanner.models.User;
import fr.m2i.smartplanner.utils.DateManipulation;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Path("/events")
public class EventResources {

    @GET
    @Path("/event/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Events getEventById(@PathParam("id")int id, @Context HttpServletRequest request){
        User user1 = (User)request.getAttribute("user");
        // on teste si le calendrier est demandé par quelqu'un d'autre que le propriétaire
        if(!(id == user1.getId())){
            ContactCrud contactCrud = new ContactCrud();
            Contact contact = contactCrud.getContactByIds(id,user1.getId());
            // si la demande provient de quelqu'un d'autre on verifie qu'il ait les droits
            if(!contact.getCalendarPrivileges().stream().map((priv)-> priv.getName()).collect(Collectors.toList()).contains("readEvent")){
                return null;
            }
        }
        EventsCrud eventsCrud = new EventsCrud();
        return eventsCrud.getEventById(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Events> getEvents(@Context HttpServletRequest request){
        User user1 = (User)request.getAttribute("user");
        if(user1.hasPrivilege("cruduser")){
            EventsCrud eventsCrud = new EventsCrud();
            return eventsCrud.getEvents();
        }
        return null;
    }


    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Events createEvent(Events events, @Context HttpServletRequest request){
        User user1 = (User)request.getAttribute("user");
        if(user1.hasPrivilege("userRead")){
            EventsCrud eventsCrud = new EventsCrud();
            return eventsCrud.createEvent(events);
        }
        return null;
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Events updateEvent(Events events, @Context HttpServletRequest request){
        User user1 = (User)request.getAttribute("user");
        if(user1.hasPrivilege("userRead")){
            EventsCrud eventsCrud = new EventsCrud();
            return eventsCrud.updateEvent(events);
        }
        return null;
    }


    @POST
    @Path("/delete/{id}")
    public void deleteEvent(@PathParam("id")int id, @Context HttpServletRequest request){
        User user1 = (User)request.getAttribute("user");
        if(user1.hasPrivilege("userRead")){
            EventsCrud eventsCrud = new EventsCrud();
            eventsCrud.deleteEventById(id);
        }
    }

    @GET
    @Path("/allByUserId/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Events> getEventsByUserId(@PathParam("userId")Integer idUser, @Context HttpServletRequest request){

        User user1 = (User)request.getAttribute("user");
        // on teste si le calendrier est demandé par quelqu'un d'autre que le propriétaire
        if(!(idUser == user1.getId())){
            ContactCrud contactCrud = new ContactCrud();
            Contact contact = contactCrud.getContactByIds(idUser,user1.getId());
            // si la demande provient de quelqu'un d'autre on verifie qu'il ait les droits
            if(!contact.getCalendarPrivileges().stream().map((priv)-> priv.getName()).collect(Collectors.toList()).contains("readEvent")){
                return null;
            }
        }

        EventsCrud eventsCrud = new EventsCrud();
        return eventsCrud.getEventsByUserId(idUser);

    }

    @GET
    @Path("/allByDay/{timestamp}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Events> getEventsByDay(@PathParam("timestamp")Long timestamp, @Context HttpServletRequest request) throws ParseException {
        User user1 = (User)request.getAttribute("user");
        if(user1.hasPrivilege("userRead")){
            EventsCrud eventsCrud = new EventsCrud();
            return eventsCrud.getEventsByDay(timestamp);
        }
        return null;
    }

    @GET
    @Path("/allByDayAndUserId/{id}/{timestamp}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Events> getEventsByDayAndUserId(@PathParam("timestamp")Long timestamp,@PathParam("id")Integer id, @Context HttpServletRequest request) throws ParseException {

        User user1 = (User)request.getAttribute("user");
        // on teste si le calendrier est demandé par quelqu'un d'autre que le propriétaire
        if(!(id == user1.getId())){
            ContactCrud contactCrud = new ContactCrud();
            Contact contact = contactCrud.getContactByIds(id,user1.getId());
            // si la demande provient de quelqu'un d'autre on verifie qu'il ait les droits
            if(!contact.getCalendarPrivileges().stream().map((priv)-> priv.getName()).collect(Collectors.toList()).contains("readEvent")){
                return null;
            }
        }

        EventsCrud eventsCrud = new EventsCrud();
        return eventsCrud.getEventsByDayAndUserId(timestamp,id);

    }

    @GET
    @Path("/allByWeekAndUserId/{id}/{timestamp}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Events> getEventsByWeekAndUserId(@PathParam("timestamp")Long timestamp,@PathParam("id")Integer id, @Context HttpServletRequest request) throws ParseException {

        User user1 = (User)request.getAttribute("user");
        // on teste si le calendrier est demandé par quelqu'un d'autre que le propriétaire
        if(!(id == user1.getId())){
            ContactCrud contactCrud = new ContactCrud();
            Contact contact = contactCrud.getContactByIds(id,user1.getId());
            // si la demande provient de quelqu'un d'autre on verifie qu'il ait les droits
            if(!contact.getCalendarPrivileges().contains("readEvent")){
                return null;
            }
        }

        EventsCrud eventsCrud = new EventsCrud();
        return eventsCrud.getEventsByWeekAndUserId(timestamp,id);

    }

    @GET
    @Path("/allByMonthAndUserId/{id}/{timestamp}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Events> getEventsByMonthAndUserId(@PathParam("timestamp")Long timestamp,@PathParam("id")Integer id, @Context HttpServletRequest request) throws ParseException {

        User user1 = (User)request.getAttribute("user");
        // on teste si le calendrier est demandé par quelqu'un d'autre que le propriétaire
        if(!(id == user1.getId())){
            ContactCrud contactCrud = new ContactCrud();
            Contact contact = contactCrud.getContactByIds(id,user1.getId());
            // si la demande provient de quelqu'un d'autre on verifie qu'il ait les droits
            if(!contact.getCalendarPrivileges().contains("readEvent")){
                return null;
            }
        }

        EventsCrud eventsCrud = new EventsCrud();
        return eventsCrud.getEventsByMonthAndUserId(timestamp,id);

    }

    @GET
    @Path("/allByTimeRangeAndUserId/{id}/{timestamp1}/{timestamp2}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Events> getEventsByTimeRangeAndUserId(@PathParam("timestamp1")Long timestamp1,
                                                  @PathParam("timestamp2")Long timestamp2,
                                                  @PathParam("id")Integer id,
                                                  @Context HttpServletRequest request) throws ParseException {
        User user1 = (User)request.getAttribute("user");
        if(user1.hasPrivilege("userRead")){
            EventsCrud eventsCrud = new EventsCrud();
            return eventsCrud.getEventsByTimeRangeAndUserId(timestamp1,timestamp2,id);
        }
        return null;
    }

}
