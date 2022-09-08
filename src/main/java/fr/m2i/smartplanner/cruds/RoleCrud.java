package fr.m2i.smartplanner.cruds;


import fr.m2i.smartplanner.models.Role;
import fr.m2i.smartplanner.models.User;
import fr.m2i.smartplanner.services.ConnectionService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class RoleCrud {

    private EntityManagerFactory factory;

    public RoleCrud(){
        this.factory = this.factory = ConnectionService.getFatcory();
    }

    public List<Role> getRoles(){
        EntityManager em = factory.createEntityManager();
        List<Role> roles = em.createNamedQuery("selectAllRole").getResultList();
        em.close();
        return roles;
    }

    public Role getRoleById(Integer id){
        EntityManager em = factory.createEntityManager();
        Role role = (Role)em.createNamedQuery("findRoleById")
                .setParameter("id",id)
                .getSingleResult();
        em.close();
        return role;
    }


    public Role saveRole(Role role){
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        if(role.getId()!=null) {
            role = em.merge(role);
        }
        boolean valid = false;
        try{
            em.persist(role);
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
        em.refresh(role);

        em.close();
        return role;
    }

    public void deleteRole(Role role){
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        boolean valid = false;
        try{
            em.remove(role);
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

    public void deleteRoleById(Integer id){
        EntityManager em = factory.createEntityManager();
        Role role = em.find(Role.class,id);
        em.getTransaction().begin();
        boolean valid = false;
        try{
            em.remove(role);
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
