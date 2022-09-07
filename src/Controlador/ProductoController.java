/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
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
public class ProductoController {
    private EntityManager entityManager() {
        return ConnectionDB.getInstance().getFactory().createEntityManager();
    }
    
    public void create(Producto row) {
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
    
    public void update(Producto row) {
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
    
    public void delete(Producto row) {
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
    
    public List<Producto> index() {
        EntityManager em = this.entityManager();
        
        try {
            em.getTransaction().begin();
            String consultac = "select p from Producto p";
            Query consulta = em.createQuery(consultac,Producto.class);
            List<Producto> listaProductos = consulta.getResultList();
            em.getTransaction().commit();
            return listaProductos;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
    
    public Producto indexById(int id) {
        EntityManager em = this.entityManager();
        
        try {
            em.getTransaction().begin();
            Producto product = em.find(Producto.class, id);
            em.getTransaction().commit();
            
            return product;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
}
