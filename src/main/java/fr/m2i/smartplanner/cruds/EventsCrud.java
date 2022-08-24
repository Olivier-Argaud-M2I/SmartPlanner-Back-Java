package fr.m2i.smartplanner.cruds;

import fr.m2i.smartplanner.models.Events;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EventsCrud {

    private EntityManagerFactory factory;

    public EventsCrud(){
        this.factory = Persistence.createEntityManagerFactory("smartplanner");
    }

    public List<Events> getEvents(){
        EntityManager em = factory.createEntityManager();
        List<Events> events = em.createNamedQuery("selectAllEvents")
                .getResultList();
        em.close();
        return events;
    }

    public Events getEventById(Integer id){
        EntityManager em = factory.createEntityManager();
        Events event = (Events)em.createNamedQuery("findEventById")
                .setParameter("id",id)
                .getSingleResult();
        em.close();
        return event;
    }

    public Events saveEvent(Events event){
        EntityManager em = factory.createEntityManager();
        if(event.getId()==null){
            em.getTransaction().begin();
            boolean valid = false;
            try{
                em.persist(event);
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
            em.refresh(event);
        }
        else{
            event = em.merge(em.find(Events.class,event.getId()));
        }
        em.close();
        return event;
    }

    public void deleteEvent(Events event){
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        boolean valid = false;
        try{
            em.remove(event);
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

    public void deleteEventById(Integer id){
        EntityManager em = factory.createEntityManager();
        Events event = em.find(Events.class,id);
        em.getTransaction().begin();
        boolean valid = false;
        try{
            em.remove(event);
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