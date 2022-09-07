/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Historial;
import config.ConnectionDB;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Harrison
 */
public class HistorialController {
    private EntityManager entityManager() {
        return ConnectionDB.getInstance().getFactory().createEntityManager();
    }
    
    public void create(Historial row) {
        EntityManager em = this.entityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(row);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public void update(Historial row) {
        EntityManager em = this.entityManager();
        
        try {
            em.getTransaction().begin();
            em.merge(row);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public void delete(Historial row) {
        EntityManager em = this.entityManager();
        
        try {
            em.getTransaction().begin();
            em.remove(row);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public Historial indexById(int id) {
        EntityManager em = this.entityManager();
        
        try {
            em.getTransaction().begin();
            Historial retorno = em.find(Historial.class, id);
            em.getTransaction().commit();
            
            return retorno;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }
    
    public List<Historial> index() {
        EntityManager em = this.entityManager();
    
        try {
            em.getTransaction().begin();
            String consultac = "select h from historial h";
            Query consulta = em.createQuery(consultac, Historial.class);
            List<Historial> listaHistoriales;
            listaHistoriales = consulta.getResultList();
            em.getTransaction().commit();
            return listaHistoriales;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
}
