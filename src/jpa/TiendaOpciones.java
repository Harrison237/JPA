/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import Controlador.TiendaController;
import Modelo.Tienda;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Harrison
 */
public class TiendaOpciones {
    private String nombre;
    private TiendaController tiendaControl = new TiendaController();
    
    public boolean init() {
        Scanner ent = new Scanner(System.in);
        
        try {
            System.out.print("Inserte el nombre: ");
            this.nombre = ent.next();
            
            if(this.nombre.equals("n")) {
                this.nombre = null;
            }
        } catch (Exception e) {
            return true;
        }
        
        return false;
    }
    
    public void crearTienda() {
        Tienda nueva = new Tienda(this.nombre);
        
        this.tiendaControl.create(nueva);
    }
    
    public void todos() {
        List<Tienda> listaTiendas = this.tiendaControl.index();
        
        for(Tienda mostrar : listaTiendas) {
            System.out.println("ID: "+mostrar.getId()
                    +"\nNombre: "+mostrar.getNombre());
        }
    }
    
    public void porId(Integer id) {
        Tienda mostrar = this.tiendaControl.indexById(id);
        if (mostrar == null) {
            System.out.println("No se encontró ninguna tienda.");
        } else {
            System.out.println("ID: "+mostrar.getId()
                    +"\nNombre: "+mostrar.getNombre());
        }
    }
    
    public void actualizar(Integer id) {
        Tienda actualizada = this.tiendaControl.indexById(id);
        
        if(!(this.nombre == null)) {
            actualizada.setNombre(this.nombre);
        }
        
        this.tiendaControl.update(actualizada);
    }
    
    public void eliminar(Integer id) {
        this.tiendaControl.delete(this.tiendaControl.indexById(id));
    }

    public void flush() {
        this.nombre = null;
    }
}
