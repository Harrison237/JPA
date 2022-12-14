/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Vendedor;
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
public class VendedorController {
    private EntityManager entityManager() {
        return ConnectionDB.getInstance().getFactory().createEntityManager();
    }
    
    public void create(Vendedor row) {
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
    
    public void update(Vendedor row) {
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
    
    public void delete(Vendedor row) {
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
    
    public List<Vendedor> index() {
        EntityManager em = this.entityManager();
    
        try {
            em.getTransaction().begin();
            String consultac = "select v from Vendedor v";
            Query consulta = em.createQuery(consultac,Vendedor.class);
            List<Vendedor> listaVendedor = consulta.getResultList();
            em.getTransaction().commit();
            return listaVendedor;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
    
    public Vendedor indexById(int id) {
        EntityManager em = this.entityManager();
        
        try {
            em.getTransaction().begin();
            Vendedor seller = em.find(Vendedor.class, id);
            em.getTransaction().commit();
            
            return seller;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
}
