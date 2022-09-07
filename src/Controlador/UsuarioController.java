/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import config.ConnectionDB;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Harrison
 */
public class UsuarioController {

    private EntityManager entityManager() {
        return ConnectionDB.getInstance().getFactory().createEntityManager();
    }

    public void create(Usuario row) {
        EntityManager em = this.entityManager();
        try {
            em.getTransaction().begin();
            em.persist(row);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void update(Usuario row) {
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

    public void delete(Usuario row) {
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

    public List<Usuario> index() {
        EntityManager em = this.entityManager();

        try {
            em.getTransaction().begin();
            String consultac = "select u from Usuario u";
            Query consulta = em.createQuery(consultac,Usuario.class);
            List<Usuario> listaUsuario = consulta.getResultList();
            em.getTransaction().commit();
            return listaUsuario;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
    
    public Usuario indexById(int id) {
        EntityManager em = this.entityManager();
        
        try {
            em.getTransaction().begin();
            Usuario user = em.find(Usuario.class, id);
            em.getTransaction().commit();
            
            return user;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            
            return null;
        }
    }
    
    public void findByUser(Usuario row) {
        EntityManager em = this.entityManager();

        try {
            em.getTransaction().begin();
            Query query = em.createNativeQuery("Select * from usuario where correo like '" + row.getCorreo() + "'"
                    + "and contrasena like '" + row.getContrasena() + "'");
            List<Object[]> ad = query.getResultList();

            List<Usuario> listasd = ad.stream().map(result -> new Usuario((String) result[1], (String) result[2])).collect(Collectors.toList());

            System.out.println(listasd.get(0).getCorreo());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
