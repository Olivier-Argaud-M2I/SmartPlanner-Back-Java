package fr.m2i.smartplanner.cruds;


import fr.m2i.smartplanner.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class UserCrud {

    private EntityManagerFactory factory;

    public UserCrud(){
        this.factory = Persistence.createEntityManagerFactory("smartplanner");
    }

    public List<User> getUsers(){
        EntityManager em = factory.createEntityManager();
        List<User> users = em.createNamedQuery("selectAllUser").getResultList();
        em.close();


//        users.forEach(user -> {
//            user.getCollaborators().forEach(collaborator -> {
//                collaborator.getCollab().getUserName();
//
//            });
//        });

//        users.forEach(user -> {
//            user.getCollaborators().forEach(collaborator -> {
//                collaborator.getCalendarPrivileges();
//
//            });
//        });


        return users;
    }

    public User getUserById(Integer id){
        EntityManager em = factory.createEntityManager();
        User user = (User)em.createNamedQuery("findUserById").setParameter("id",id).getSingleResult();
        em.close();
        return user;
    }

    public User getUserByName(String username){
        User user = null;
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        boolean valid = false;
        try{
            user = (User)em.createNamedQuery("findUserByUsername")
                    .setParameter("username",username)
                    .getSingleResult();
            valid = true;
        }
        catch (Exception e){
            System.out.println("erreur");
        }
        finally {
            if (valid){
                em.getTransaction().commit();
            }
            else{
                em.getTransaction().rollback();
                System.out.println("utilisateur de nom "+username+" non trouvé");
            }
        }
        em.close();
        return user;
    }

    public User saveUser(User user){
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        boolean valid = false;
        try{
            if(user.getId()!=null){
                user = em.merge(user);
            }
            em.persist(user);
//            addContact(user,em);
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
        em.refresh(user);

        em.close();
        return user;
    }

//    private void addContact(User user,EntityManager em){
//        for (User contact:user.getCollaborators()) {
//            if(contact.getCollaborators().stream().anyMatch(collabo->collabo.getId().equals(user.getId()))){
//                return;
//            }
//            contact.getCollaborators().add(user);
//            em.persist(contact);
//        }
//
//    }

    public void deleteUser(User user){
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        boolean valid = false;
        try{
            em.remove(user);
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

    public void deleteUserById(Integer id){
        EntityManager em = factory.createEntityManager();
        User user = em.find(User.class,id);
        em.getTransaction().begin();
        boolean valid = false;
        try{
            em.remove(user);
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
