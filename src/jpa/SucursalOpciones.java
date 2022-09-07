/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import Controlador.SucursalController;
import Controlador.TiendaController;
import Modelo.Sucursal;
import Modelo.Tienda;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Harrison
 */
public class SucursalOpciones {

    private String nombre;
    private String direccion;
    private Integer idTienda;
    private SucursalController sucursalControl = new SucursalController();
    private Tienda tiendaAsociada;
    private TiendaController tiendaControl;

    public boolean init() {
        Scanner ent = new Scanner(System.in);
        this.tiendaControl = new TiendaController();

        try {
            System.out.print("Ingrese el nombre de la sucursal: ");
            this.nombre = ent.next();
            System.out.print("Ingrese la dirección: ");
            this.direccion = ent.next();
            System.out.print("Ingrese el id de la tienda: ");
            this.idTienda = ent.nextInt();

            if (this.nombre.equals("n")) {
                this.nombre = null;
            }
            if (this.direccion.equals("n")) {
                this.direccion = null;
            }
            try {
                if (this.idTienda == 0) {
                    this.idTienda = null;
                    this.tiendaAsociada = null;
                } else {
                    this.tiendaAsociada = this.tiendaControl.indexById(this.idTienda);
                }
            } catch (Exception e) {
                System.out.println("No se encontró la tienda.");
                return true;
            }
        } catch (Exception e) {
            return true;
        }

        return false;
    }

    public void crearSucursal() {
        Sucursal nueva = new Sucursal(nombre, direccion, tiendaAsociada);

        this.sucursalControl.create(nueva);
    }

    public void todos() {
        List<Sucursal> listaSucursales = this.sucursalControl.index();

        for (Sucursal mostrar : listaSucursales) {
            System.out.println("ID: " + mostrar.getId()
                    + "\nNombre: " + mostrar.getNombre()
                    + "\nDirección: " + mostrar.getDireccion()
                    + "\nTienda: " + mostrar.getIdTienda().getNombre() + "\n");
        }
    }

    public void porId(Integer id) {
        Sucursal mostrar = this.sucursalControl.indexById(id);
        
        if (mostrar == null) {
            System.out.println("No se encontró ninguna sucursal.");
        } else {
            System.out.println("ID: " + mostrar.getId()
                    + "\nNombre: " + mostrar.getNombre()
                    + "\nDirección: " + mostrar.getDireccion()
                    + "\nTienda: " + mostrar.getIdTienda().getNombre() + "\n");
        }
    }
    
    public void actualizar(Integer id) {
        Sucursal actualizado = this.sucursalControl.indexById(id);
        
        if (!(this.nombre == null)) {
            actualizado.setNombre(this.nombre);
        }
        if (!(this.direccion == null)) {
            actualizado.setDireccion(this.direccion);
        }
        if (!(this.tiendaAsociada == null)) {
            actualizado.setIdTienda(this.tiendaAsociada);
        }
        
        this.sucursalControl.update(actualizado);
    }
    
    public void eliminar(Integer id) {
        this.sucursalControl.delete(this.sucursalControl.indexById(id));
    }

    public void flush() {
        this.nombre = null;
        this.direccion = null;
        this.idTienda = null;
        this.tiendaAsociada = null;
        this.tiendaControl = null;
    }
    
    
}
