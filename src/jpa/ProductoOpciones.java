/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import Controlador.ProductoController;
import Controlador.ReferenciaController;
import Modelo.Producto;
import Modelo.Referencia;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Harrison
 */
public class ProductoOpciones {

    private String nombre;
    private Long tamaño;
    private String color;
    private Long precio;
    private String descripcion;
    private Integer idReferencia;
    private ProductoController productControl = new ProductoController();
    private Referencia referenciaAsociada;
    private ReferenciaController refControl;

    public boolean init() {
        Scanner ent = new Scanner(System.in);
        this.refControl = new ReferenciaController();

        try {
            System.out.print("Ingrese el nombre del producto: ");
            this.nombre = ent.next();
            System.out.print("Ingrese el tamaño: ");
            this.tamaño = ent.nextLong();
            System.out.print("Ingrese el color: ");
            this.color = ent.next();
            System.out.print("Ingrese el precio: ");
            this.precio = ent.nextLong();
            System.out.print("Ingrese la descripción: ");
            this.descripcion = ent.next();
            System.out.print("Ingrese el id de la referencia: ");
            this.idReferencia = ent.nextInt();

            if (this.nombre.equals("n")) {
                this.nombre = null;
            }
            if (this.tamaño == 0) {
                this.tamaño = null;
            }
            if (this.color.equals("n")) {
                this.color = null;
            }
            if (this.precio == 0) {
                this.precio = null;
            }
            if (this.descripcion.equals("n")) {
                this.descripcion = null;
            }
            try {
                if (this.idReferencia == 0) {
                    this.idReferencia = null;
                    this.referenciaAsociada = null;
                } else {
                    this.referenciaAsociada = this.refControl.indexById(this.idReferencia);
                }
            } catch (Exception e) {
                System.out.println("No se encontró la referencia.");
                return true;
            }
        } catch (Exception e) {
            return true;
        }

        return false;
    }

    public void crearProducto() {
        Producto nuevo = new Producto(nombre, tamaño, color, precio, descripcion, referenciaAsociada);

        this.productControl.create(nuevo);
    }

    public void todos() {
        List<Producto> listaProductos = this.productControl.index();

        for (Producto ver : listaProductos) {
            System.out.println("ID: " + ver.getId()
                    + "\nNombre: " + ver.getNombre()
                    + "\nTamaño: " + ver.getTamaño()
                    + "\nColor: " + ver.getColor()
                    + "\nPrecio: " + ver.getPrecio()
                    + "\nDescripción: " + ver.getDescripcion()
                    + "\nReferencia: " + ver.getIdReferencia().getRef() + "\n");
        }
    }

    public void porId(Integer id) {
        Producto mostrar = this.productControl.indexById(id);

        if (mostrar == null) {
            System.out.println("No se encontró ningún producto.");
        } else {
            System.out.println("ID: " + mostrar.getId()
                    + "\nNombre: " + mostrar.getNombre()
                    + "\nTamaño: " + mostrar.getTamaño()
                    + "\nColor: " + mostrar.getColor()
                    + "\nPrecio: " + mostrar.getPrecio()
                    + "\nDescripción: " + mostrar.getDescripcion()
                    + "\nReferencia: " + mostrar.getIdReferencia().getRef() + "\n");
        }
    }
    
    public void actualizar(Integer id) {
        Producto actualizado = this.productControl.indexById(id);
        
        if (!(this.nombre == null)) {
            actualizado.setNombre(this.nombre);
        }
        if (!(this.tamaño == null)) {
            actualizado.setTamaño(this.tamaño);
        }
        if (!(this.color == null)) {
            actualizado.setColor(this.color);
        }
        if (!(this.precio == null)) {
            actualizado.setPrecio(this.precio);
        }
        if (!(this.descripcion == null)) {
            actualizado.setDescripcion(this.descripcion);
        }
        if (!(this.referenciaAsociada == null)) {
            actualizado.setIdReferencia(this.referenciaAsociada);
        }
        
        this.productControl.update(actualizado);
    }
    
    public void eliminar(Integer id) {
        this.productControl.delete(this.productControl.indexById(id));
    }

    public void flush() {
        this.nombre = null;
        this.tamaño = null;
        this.color = null;
        this.precio = null;
        this.descripcion = null;
        this.idReferencia = null;
        this.referenciaAsociada = null;
        this.refControl = null;
    }
    
    
}