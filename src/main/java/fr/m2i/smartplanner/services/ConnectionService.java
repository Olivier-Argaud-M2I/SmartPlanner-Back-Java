package fr.m2i.smartplanner.services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionService {

    private static EntityManagerFactory factory;
    
    public static EntityManagerFactory getFatcory(){
        if(factory==null){
            factory = Persistence.createEntityManagerFactory("smartplanner");
        }
        return factory;
    }
    
    
}

