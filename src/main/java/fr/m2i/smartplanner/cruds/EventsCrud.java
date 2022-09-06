package fr.m2i.smartplanner.cruds;

import fr.m2i.smartplanner.models.Events;
import fr.m2i.smartplanner.utils.DateManipulation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.util.ArrayList;
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

    public Events updateEvent(Events event){
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        boolean valid = false;
        try{
            event = em.merge(event);
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

        em.close();
        return event;
    }

    public Events createEvent(Events event){
        event.setId(null);
        EntityManager em = factory.createEntityManager();
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

    public List<Events> getEventsByUserId(Integer idUser){
        EntityManager em = factory.createEntityManager();
        List<Events> events = em.createNamedQuery("selectAllEventsByUserId")
                .setParameter("idUser",idUser)
                .getResultList();
        em.close();
        return events;
    }

    public List<Events> getEventsByDay(Long timestamp) throws ParseException {
        EntityManager em = factory.createEntityManager();
        DateManipulation dm = new DateManipulation();
        ArrayList<Long> timeRange = dm.getDayRange(timestamp);
        List<Events> events = em.createNamedQuery("selectAllEventsByDay")
                .setParameter("timestamp1",timeRange.get(0)).setParameter("timestamp2",timeRange.get(1))
                .getResultList();
        em.close();
        return events;
    }

    public List<Events> getEventsByDayAndUserId(Long timestamp, Integer id) throws ParseException {
        EntityManager em = factory.createEntityManager();
        DateManipulation dm = new DateManipulation();
        ArrayList<Long> timeRange = dm.getDayRange(timestamp);
        List<Events> events = em.createNamedQuery("selectAllEventsByRangeAndUserId")
                .setParameter("timestamp1",timeRange.get(0)).setParameter("timestamp2",timeRange.get(1))
                .setParameter("idUser",id).getResultList();
        em.close();
        return events;
    }

    public List<Events> getEventsByMonthAndUserId(Long timestamp, Integer id) throws ParseException {

        EntityManager em = factory.createEntityManager();

        DateManipulation dm = new DateManipulation();

        ArrayList<Long> timeRange = dm.getMonthRange(timestamp);

        List<Events> events = em.createNamedQuery("selectAllEventsByRangeAndUserId")
                .setParameter("timestamp1",timeRange.get(0)).setParameter("timestamp2",timeRange.get(1))
                .setParameter("idUser",id)
                .getResultList();
        em.close();

        return events;
    }

    public List<Events> getEventsByWeekAndUserId(Long timestamp, Integer id) throws ParseException {

        EntityManager em = factory.createEntityManager();

        DateManipulation dm = new DateManipulation();

        ArrayList<Long> timeRange = dm.getMonthRange(timestamp);

        List<Events> events = em.createNamedQuery("selectAllEventsByRangeAndUserId")
                .setParameter("timestamp1",timeRange.get(0)).setParameter("timestamp2",timeRange.get(1))
                .setParameter("idUser",id)
                .getResultList();
        em.close();

        return events;
    }


}