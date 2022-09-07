/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import Controlador.ReferenciaController;
import Modelo.Referencia;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Harrison
 */
public class ReferenciaOpciones {
    private String ref;
    private ReferenciaController refControl = new ReferenciaController();
    
    public boolean init() {
        Scanner ent = new Scanner(System.in);
        
        try {
            System.out.print("Inserte la referencia: ");
            this.ref = ent.next();
            
            if(this.ref.equals("n")) {
                this.ref = null;
            }
        } catch (Exception e) {
            return true;
        }
        
        return false;
    }
    
    public void crearReferencia() {
        Referencia nueva = new Referencia(this.ref);
        
        this.refControl.create(nueva);
    }
    
    public void todos() {
        List<Referencia> listaReferencias = this.refControl.index();
        
        for(Referencia mostrar : listaReferencias) {
            System.out.println("ID: "+mostrar.getId()
                    +"\nReferencia: "+mostrar.getRef());
        }
    }
    
    public void porId(Integer id) {
        Referencia mostrar = this.refControl.indexById(id);
        if (mostrar == null) {
            System.out.println("No se encontró ningún producto.");
        } else {
            System.out.println("ID: "+mostrar.getId()
                    +"\nReferencia: "+mostrar.getRef());
        }
    }
    
    public void actualizar(Integer id) {
        Referencia actualizada = this.refControl.indexById(id);
        
        if(!(this.ref == null)) {
            actualizada.setRef(this.ref);
        }
        
        this.refControl.update(actualizada);
    }
    
    public void eliminar(Integer id) {
        this.refControl.delete(this.refControl.indexById(id));
    }

    public void flush() {
        this.ref = null;
    }
    
    
}
