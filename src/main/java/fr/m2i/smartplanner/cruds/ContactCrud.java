package fr.m2i.smartplanner.cruds;


import fr.m2i.smartplanner.models.Contact;
import fr.m2i.smartplanner.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


public class ContactCrud {

    private EntityManagerFactory factory;

    public ContactCrud(){
        this.factory = Persistence.createEntityManagerFactory("smartplanner");
    }

    public List<Contact> getContacts(Integer id){
        List<Contact>contacts = new ArrayList<>();
        try{
            EntityManager em = factory.createEntityManager();
            contacts = em.createNamedQuery("selectAllContactByUser")
                    .setParameter("id",id)
                    .getResultList();
            em.close();
        }
        catch (Exception e){

        }
        return contacts;
    }


    public Contact getContactById(Integer id){
        Contact contact = null;
        try{
            EntityManager em = factory.createEntityManager();
            contact = em.find(Contact.class,id);
            em.close();
        }
        catch (Exception e){

        }
        return contact;
    }


    public Contact getContactByIds(Integer idU,Integer idC){
        Contact contact = null;
        try{
            EntityManager em = factory.createEntityManager();
            contact = (Contact) em.createNamedQuery("getContactByIds")
                    .setParameter("idU",idU)
                    .setParameter("idC",idC)
                    .getSingleResult();
            em.close();
        }
        catch (Exception e){

        }
        return contact;
    }



    public Contact createContact(Integer idU, Integer idC){

        EntityManager em = factory.createEntityManager();
        Contact contact = null  ;
        User user = null;
        User collab = null;
        try{
            user = em.find(User.class,idU);
            collab = em.find(User.class,idC);
        }
        catch (Exception e){

        }
        if(user!=null && collab!=null){
            contact = new Contact(user,collab);
        }

        if(contact!=null){

            em.getTransaction().begin();
            boolean valid = false;
            try{
                em.persist(contact);
                reciproqueContact( idU, idC,em);
                valid = true;
            }
            finally {
                if (valid){
                    em.getTransaction().commit();
                }
                else{
                    em.getTransaction().rollback();
                }
            }
            em.refresh(contact);
            em.close();
        }

        return contact;
    }

    public void reciproqueContact(Integer idU,Integer idC,EntityManager em){
        Contact contact = new Contact(em.find(User.class,idC), em.find(User.class,idU));
        em.persist(contact);
    }

    public Contact updateContact(Contact contact){
        EntityManager em = factory.createEntityManager();
        if(contact!=null){
            em.getTransaction().begin();
            boolean valid = false;
            try{
                contact = em.merge(contact);
                em.persist(contact);
                valid = true;
            }
            finally {
                if (valid){
                    em.getTransaction().commit();
                }
                else{
                    em.getTransaction().rollback();
                }
            }
            em.refresh(contact);
            em.close();
        }

        return contact;
    }

    // Supprimer le contact user par ID x & y
    public void deleteContact(Integer idU,Integer idC){
        Contact contact = getContactByIds(idU,idC);
        EntityManager em = factory.createEntityManager();
        if(contact!=null){
            em.getTransaction().begin();
            boolean valid = false;
            try{
                contact = em.merge(contact);
                em.remove(contact);
                reciproquedel(idU,idC,em);
                valid = true;
            }
            finally {
                if (valid){
                    em.getTransaction().commit();
                }
                else{
                    em.getTransaction().rollback();
                }
            }
            em.close();
        }
    }

    public void reciproquedel(Integer idU,Integer idC,EntityManager em){
        Contact contact = getContactByIds(idC,idU);
        contact = em.merge(contact);
        em.remove(contact);
    }









}
