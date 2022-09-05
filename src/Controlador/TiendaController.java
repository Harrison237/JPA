/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Tienda;
import config.ConnectionDB;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Harrison
 */
public class TiendaController {
    private EntityManager entityManager() {
        return ConnectionDB.getInstance().getFactory().createEntityManager();
    }
    
    public void create(Tienda row) {
        EntityManager em = this.entityManager();
        try {
            em.getTransaction().begin();
            em.persist(row);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
    public void update(Tienda row) {
        EntityManager em = this.entityManager();

        try {
            em.getTransaction().begin();
            em.merge(row);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
    public void delete(Tienda row) {
        EntityManager em = this.entityManager();
        try {
            em.getTransaction().begin();
            if (!em.contains(row)) {
                row = em.merge(row);
            }
            em.remove(row);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
    public List<Tienda> index() {
        EntityManager em = this.entityManager();
        
        try {
            em.getTransaction().begin();
            Query consulta = em.createNativeQuery("select * from tienda");
            List<Object[]> total = consulta.getResultList();
            
            List<Tienda> listaTiendas = total.stream().map(res -> new Tienda(
                    (int) res[0], (String) res[1])
            ).collect(Collectors.toList());
            
            em.getTransaction().commit();
            return listaTiendas;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            
            return null;
        }
    }
    
    public Tienda indexById(int id) {
        EntityManager em = this.entityManager();
        
        try {
            em.getTransaction().begin();
            Tienda shop = em.find(Tienda.class, id);
            em.getTransaction().commit();

            return shop;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            
            return null;
        }
    }
}
