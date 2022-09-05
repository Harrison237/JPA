/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Referencia;
import config.ConnectionDB;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Harrison
 */
public class ReferenciaController {
    private EntityManager entityManager() {
        return ConnectionDB.getInstance().getFactory().createEntityManager();
    }
    
    public void create(Referencia row) {
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
    
    public void update(Referencia row) {
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
    
    public void delete(Referencia row) {
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
    
    public List<Referencia> index() {
        EntityManager em = this.entityManager();
        try {
            em.getTransaction().begin();
            Query consulta = em.createNativeQuery("select * from referencia");
            List<Object[]> total = consulta.getResultList();
            
            List<Referencia> listaReferencias = total.stream().map(res -> new Referencia(
                    (int) res[0], (String) res[1])
            ).collect(Collectors.toList());
            
            em.getTransaction().commit();
            return listaReferencias;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            
            return null;
        }
    }
    
    public Referencia indexById(int id) {
        EntityManager em = this.entityManager();
        
        try {
            em.getTransaction().begin();
            Referencia reference = em.find(Referencia.class, id);
            em.getTransaction().commit();

            return reference;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            
            return null;
        }
    }
}
