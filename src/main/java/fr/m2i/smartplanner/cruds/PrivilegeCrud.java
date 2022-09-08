package fr.m2i.smartplanner.cruds;


import fr.m2i.smartplanner.models.Privilege;
import fr.m2i.smartplanner.services.ConnectionService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class PrivilegeCrud {

    private EntityManagerFactory factory;

    public PrivilegeCrud(){
        this.factory = this.factory = ConnectionService.getFatcory();
    }

    public List<Privilege> getPrivileges(){
        EntityManager em = factory.createEntityManager();
        List<Privilege> privileges = em.createNamedQuery("selectAllPrivilege")
                .getResultList();
        em.close();
        return privileges;
    }

    public Privilege getPrivilegeById(Integer id){
        EntityManager em = factory.createEntityManager();
        Privilege privilege = (Privilege)em.createNamedQuery("findPrivilegeById")
                .setParameter("id",id)
                .getSingleResult();
        em.close();
        return privilege;
    }

    public Privilege savePrivilege(Privilege privilege){
        EntityManager em = factory.createEntityManager();
        if(privilege.getId()==null){
            em.getTransaction().begin();
            boolean valid = false;
            try{
                em.persist(privilege);
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
            em.refresh(privilege);
        }
        else{
            privilege = em.merge(em.find(Privilege.class,privilege.getId()));
        }
        em.close();
        return privilege;
    }

    public void deletePrivilege(Privilege privilege){
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        boolean valid = false;
        try{
            em.remove(privilege);
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

    public void deletePrivilegeById(Integer id){
        EntityManager em = factory.createEntityManager();
        Privilege privilege = em.find(Privilege.class,id);
        em.getTransaction().begin();
        boolean valid = false;
        try{
            em.remove(privilege);
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
