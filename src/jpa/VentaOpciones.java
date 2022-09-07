/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import Controlador.ProductoController;
import Controlador.VentaController;
import Modelo.Producto;
import Modelo.Venta;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Harrison
 */
public class VentaOpciones {
    private String fechaVentaCad;
    private Date fechaVenta;
    private String descripcion;
    private Integer idProducto;
    private VentaController ventaControl = new VentaController();

    private ProductoController productoControl;
    private Producto productoAsociado;

    public boolean init() {
        Scanner ent = new Scanner(System.in);
        this.productoControl = new ProductoController();
        this.productoAsociado = new Producto();

        try {
            System.out.print("Ingrese una fecha con el formato dd/MM/yyyy: ");
            this.fechaVentaCad = ent.next();
            System.out.print("Ingrese la descripción: ");
            this.descripcion = ent.next();
            System.out.print("Ingrese el Id del Producto asociado: ");
            this.idProducto = ent.nextInt();
            
            if (this.fechaVentaCad.equals("n")) {
                this.fechaVenta = null;
            } else {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    this.fechaVenta = formato.parse(this.fechaVentaCad);
                } catch (Exception e) {
                    System.out.println("Formato de fecha inválido.");
                    return true;
                }
            }
            if (this.descripcion.equals("n")) {
                this.descripcion = null;
            }
            if (this.idProducto == 0) {
                this.idProducto = null;
                this.productoAsociado = null;
            } else {
                try {
                    productoAsociado = productoControl.indexById(this.idProducto);
                } catch (Exception e) {
                    System.out.println("No se encontró un Producto con el Id ingresado.");
                    return true;
                }
            }
        } catch (Exception e) {
            return true;
        }

        return false;
    }

    public void crearVenta() {
        Venta nueva = new Venta(this.fechaVenta, this.descripcion, this.productoAsociado);

        this.ventaControl.create(nueva);
    }

    public void todos() {
        List<Venta> listaAdmins = this.ventaControl.index();

        for (Venta ver : listaAdmins) {
            System.out.println("ID: " + ver.getId()
                    + "\nfechaVenta: " + ver.getFechaVenta()
                    + "\nDescripcion: " + ver.getDescripcion()
                    + "\nProducto: " + ver.getIdProducto().getNombre() + "\n");
        }
    }

    public void porId(Integer id) {
        Venta mostrar = this.ventaControl.indexById(id);

        if (mostrar == null) {
            System.out.println("No se encontró ningún Venta.");
        } else {
            System.out.println("ID: " + mostrar.getId()
                    + "\nDescripcion: " + mostrar.getDescripcion()
                    + "\nfechaVenta: " + mostrar.getFechaVenta()
                    + "\nProducto: " + mostrar.getIdProducto().getNombre() + "\n");
        }
    }

    public void actualizar(Integer id) {
        Venta actualizada = this.ventaControl.indexById(id);
        
        if (!(this.fechaVenta == null)) {
            actualizada.setFechaVenta(this.fechaVenta);
        }
        if (!(this.descripcion == null)) {
            actualizada.setDescripcion(this.descripcion);
        }
        if (!(this.productoAsociado == null)) {
            actualizada.setIdProducto(this.productoAsociado);
        }

        this.ventaControl.update(actualizada);
    }

    public void eliminar(Integer id) {
        this.ventaControl.delete(this.ventaControl.indexById(id));
    }

    public void flush() {
        this.fechaVentaCad = null;
        this.fechaVenta = null;
        this.descripcion = null;
        this.idProducto = null;
        this.productoControl = null;
        this.productoAsociado = null;
    }

    
}
