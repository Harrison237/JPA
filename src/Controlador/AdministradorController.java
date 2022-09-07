/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Administrador;
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
public class AdministradorController {

    private EntityManager entityManager() {
        return ConnectionDB.getInstance().getFactory().createEntityManager();
    }

    public void create(Administrador row) {
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

    public void update(Administrador row) {
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

    public void delete(Administrador row) {
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

    public List<Administrador> index() {
        EntityManager em = this.entityManager();

        try {
            em.getTransaction().begin();
            String consultac = "select a from Administrador a";
            Query consulta = em.createQuery(consultac, Administrador.class);
            List<Administrador> lstAdministrador = consulta.getResultList();

            em.getTransaction().commit();
            return lstAdministrador;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    public Administrador indexById(int id) {
        EntityManager em = this.entityManager();

        try {
            em.getTransaction().begin();
            Administrador admin = em.find(Administrador.class, id);
            em.getTransaction().commit();

            return admin;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
}
