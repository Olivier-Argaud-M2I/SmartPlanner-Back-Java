package fr.m2i.smartplanner.resources;


import fr.m2i.smartplanner.cruds.ContactCrud;
import fr.m2i.smartplanner.models.Contact;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/contacts")
public class ContactResources {

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getAllContactFromUser(@PathParam("id")int id){
        ContactCrud contactCrud = new ContactCrud();
        List<Contact>contacts = contactCrud.getContacts(id);

        return contacts;
    }


    @GET
    @Path("/contact/{idU}/{idC}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact getAllContactFromUser(@PathParam("idU")int idU,@PathParam("idC")int idC){
        ContactCrud contactCrud = new ContactCrud();
        Contact contact = contactCrud.getContactByIds(idU,idC);

        return contact;
    }





//
//    @GET
//    @Path("/all")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<UserDto> getUsers(){
//        UserCrud userCrud = new UserCrud();
//        List<UserDto> userDtos = userCrud.getUsers().stream().map(user -> new UserDto(user)).collect(Collectors.toList());
//        return userDtos;
//    }
//
//
    @POST
    @Path("/create/{idU}/{idC}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact saveContact(@PathParam("idU")int idU,@PathParam("idC")int idC){
        ContactCrud contactCrud = new ContactCrud();
        return contactCrud.createContact(idU,idC);
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Contact saveContact(Contact contact){
        ContactCrud contactCrud = new ContactCrud();
        return contactCrud.updateContact(contact);
    }


    @POST
    @Path("/delete/{idU}/{idC}")
    public void deleteUser(@PathParam("idU")int idU, @PathParam("idC")int idC){
        ContactCrud contactCrud = new ContactCrud();
        contactCrud.deleteContact(idU,idC);
    }

//
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

//    @POST
//    @Path("/test")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public User test(){
//        UserCrud userCrud = new UserCrud();
//        try{
//            User user1 = userCrud.getUserByName(user.getUserName());
//            if(user.getPassword().equals(user1.getPassword())){
//                return user1;
//            }
//            return null;
//        }
//        catch (Exception e){
//            return null;
//        }
//
//    }


}