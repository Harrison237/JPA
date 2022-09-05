/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Harrison
 */
public class ConnectionDB {
    private static ConnectionDB instance = new ConnectionDB();
    private EntityManagerFactory factory;

    private ConnectionDB() {
        factory = Persistence.createEntityManagerFactory("JPAPU");
                
    }

    public static ConnectionDB getInstance() {
        return instance;
    }

    public static void setInstance(ConnectionDB instance) {
        ConnectionDB.instance = instance;
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public void setFactory(EntityManagerFactory factory) {
        this.factory = factory;
    }
    
    
}