/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import Controlador.UsuarioController;
import Modelo.Usuario;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Harrison
 */
public class UsuarioOpciones {
    private String correo;
    private String contrasena;
    private UsuarioController usuarioControl = new UsuarioController();
    
    public boolean init() {
        Scanner ent = new Scanner(System.in);
        
        try {
            System.out.print("Inserte el correo: ");
            this.correo = ent.next();
            System.out.print("Inserte la contraseña: ");
            this.contrasena = ent.next();
            
            if(this.correo.equals("n")) {
                this.correo = null;
            }
            if(this.contrasena.equals("n")) {
                this.contrasena = null;
            }
        } catch (Exception e) {
            return true;
        }
        
        return false;
    }
    
    public void crearUsuario() {
        Usuario nuevo = new Usuario(this.correo,this.contrasena);
        
        this.usuarioControl.create(nuevo);
    }
    
    public void todos() {
        List<Usuario> listaUsuarios = this.usuarioControl.index();
        
        for(Usuario mostrar : listaUsuarios) {
            System.out.println("ID: "+mostrar.getId()
                    +"\nCorreo: "+mostrar.getCorreo()
                    +"\nContrasena: "+mostrar.getContrasena()+"\n");
        }
    }
    
    public void porId(Integer id) {
        Usuario mostrar = this.usuarioControl.indexById(id);
        if (mostrar == null) {
            System.out.println("No se encontró ningún usuario.");
        } else {
            System.out.println("ID: "+mostrar.getId()
                    +"\nCorreo: "+mostrar.getCorreo()
                    +"\nContrasena: "+mostrar.getContrasena()+"\n");
        }
    }
    
    public void actualizar(Integer id) {
        Usuario actualizado = this.usuarioControl.indexById(id);
        
        if(!(this.correo == null)) {
            actualizado.setCorreo(this.correo);
        }
        if(!(this.contrasena == null)) {
            actualizado.setContrasena(this.contrasena);
        }
        
        this.usuarioControl.update(actualizado);
    }
    
    public void eliminar(Integer id) {
        this.usuarioControl.delete(this.usuarioControl.indexById(id));
    }

    public void flush() {
        this.correo = null;
        this.contrasena = null;
    }
}
