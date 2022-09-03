package fr.m2i.smartplanner.cruds;


import fr.m2i.smartplanner.models.CalendarPrivilege;
import fr.m2i.smartplanner.models.Privilege;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class CalendarPrivilegeCrud {

    private EntityManagerFactory factory;

    public CalendarPrivilegeCrud(){
        this.factory = Persistence.createEntityManagerFactory("smartplanner");
    }

    public List<CalendarPrivilege> getCalendarPrivileges(){
        EntityManager em = factory.createEntityManager();
        List<CalendarPrivilege> calendarPrivileges = em.createNamedQuery("selectAllCalendarPrivilege")
                .getResultList();
        em.close();
        return calendarPrivileges;
    }

    public CalendarPrivilege getCalendarPrivilegeById(Integer id){
        EntityManager em = factory.createEntityManager();
        CalendarPrivilege calendarPrivilege = (CalendarPrivilege)em.createNamedQuery("findCalendarPrivilegeById")
                .setParameter("id",id)
                .getSingleResult();
        em.close();
        return calendarPrivilege;
    }

//    public Privilege savePrivilege(Privilege privilege){
//        EntityManager em = factory.createEntityManager();
//        if(privilege.getId()==null){
//            em.getTransaction().begin();
//            boolean valid = false;
//            try{
//                em.persist(privilege);
//                valid = true;
//            }
//            finally {
//                if (valid){
//                    em.getTransaction().commit();
//                }
//                else{
//                    em.getTransaction().rollback();
//                }
//            }
//            em.refresh(privilege);
//        }
//        else{
//            privilege = em.merge(em.find(Privilege.class,privilege.getId()));
//        }
//        em.close();
//        return privilege;
//    }
//
//    public void deletePrivilege(Privilege privilege){
//        EntityManager em = factory.createEntityManager();
//        em.getTransaction().begin();
//        boolean valid = false;
//        try{
//            em.remove(privilege);
//            valid = true;
//        }
//        finally {
//            if (valid){
//                em.getTransaction().commit();
//            }
//            else{
//                em.getTransaction().rollback();
//            }
//        }
//        em.close();
//    }
//
//    public void deletePrivilegeById(Integer id){
//        EntityManager em = factory.createEntityManager();
//        Privilege privilege = em.find(Privilege.class,id);
//        em.getTransaction().begin();
//        boolean valid = false;
//        try{
//            em.remove(privilege);
//            valid = true;
//        }
//        finally {
//            if (valid){
//                em.getTransaction().commit();
//            }
//            else{
//                em.getTransaction().rollback();
//            }
//        }
//        em.close();
//    }



}
