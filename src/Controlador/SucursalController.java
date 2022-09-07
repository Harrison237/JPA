/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Sucursal;
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
public class SucursalController {
    private EntityManager entityManager() {
        return ConnectionDB.getInstance().getFactory().createEntityManager();
    }
    
    public void create(Sucursal row) {
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
    
    public void update(Sucursal row) {
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
    
    public void delete(Sucursal row) {
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
    
    public List<Sucursal> index() {
        EntityManager em = this.entityManager();
    
        try {
            em.getTransaction().begin();
            String consultac = "select s from Sucursal s";
            Query consulta = em.createQuery(consultac,Sucursal.class);
            List<Sucursal> listaSucursal = consulta.getResultList();
            em.getTransaction().commit();
            return listaSucursal;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
    
    public Sucursal indexById(int id) {
        EntityManager em = this.entityManager();
        
        try {
            em.getTransaction().begin();
            Sucursal branch = em.find(Sucursal.class, id);
            em.getTransaction().commit();
            
            return branch;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
}
