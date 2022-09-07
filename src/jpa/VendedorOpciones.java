/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import Controlador.SucursalController;
import Controlador.UsuarioController;
import Controlador.VendedorController;
import Modelo.Sucursal;
import Modelo.Usuario;
import Modelo.Vendedor;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Harrison
 */
public class VendedorOpciones {
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private Integer idUsuario;
    private Integer idSucursal;
    private VendedorController vendedorControl = new VendedorController();
    ;

    private UsuarioController productoControl;
    private SucursalController sucursalControl;
    private Usuario usuarioAsociado;
    private Sucursal sucursalAsociada;

    public boolean init() {
        Scanner ent = new Scanner(System.in);
        this.productoControl = new UsuarioController();
        this.sucursalControl = new SucursalController();
        this.usuarioAsociado = new Usuario();
        this.sucursalAsociada = new Sucursal();

        try {
            System.out.print("Ingrese el nombre: ");
            this.nombre = ent.next();
            System.out.print("Ingrese el apellido: ");
            this.apellido = ent.next();
            System.out.print("Ingrese la cédula: ");
            this.cedula = ent.next();
            System.out.print("Ingrese el teléfono: ");
            this.telefono = ent.next();
            System.out.print("Ingrese el Id del usuario asociado: ");
            this.idUsuario = ent.nextInt();
            System.out.print("Ingrese el Id de la Sucursal asociada: ");
            this.idSucursal = ent.nextInt();

            if (this.nombre.equals("n")) {
                this.nombre = null;
            }
            if (this.apellido.equals("n")) {
                this.apellido = null;
            }
            if (this.cedula.equals("n")) {
                this.cedula = null;
            }
            if (this.telefono.equals("n")) {
                this.telefono = null;
            }
            if (this.idUsuario == 0) {
                this.idUsuario = null;
                this.usuarioAsociado = null;
            } else {
                try {
                    usuarioAsociado = productoControl.indexById(this.idUsuario);
                } catch (Exception e) {
                    System.out.println("No se encontró un usuario con el Id ingresado.");
                    return true;
                }
            }
            if (this.idSucursal == 0) {
                this.idSucursal = null;
                this.sucursalAsociada = null;
            } else {
                try {
                    sucursalAsociada = sucursalControl.indexById(this.idSucursal);
                } catch (Exception e) {
                    System.out.println("No se encontró una Sucursal con el Id ingresado.");
                    return true;
                }
            }

        } catch (Exception e) {
            return true;
        }

        return false;
    }

    public void crearVendedor() {
        Vendedor nuevo = new Vendedor(this.nombre, this.apellido, this.cedula, this.telefono,
                this.sucursalAsociada, this.usuarioAsociado);

        this.vendedorControl.create(nuevo);
    }

    public void todos() {
        List<Vendedor> listaVendedores = this.vendedorControl.index();

        for (Vendedor ver : listaVendedores) {
            System.out.println("ID: " + ver.getId()
                    + "\nNombre: " + ver.getNombre()
                    + "\nApellido: " + ver.getApellido()
                    + "\nCedula: " + ver.getCedula()
                    + "\nTelefono: " + ver.getTelefono()
                    + "\nUsuario: " + ver.getIdUsuario().getCorreo()
                    + "\nSucursal: " + ver.getIdSucursal().getNombre() + "\n");
        }
    }

    public void porId(Integer id) {
        Vendedor mostrar = this.vendedorControl.indexById(id);

        if (mostrar == null) {
            System.out.println("No se encontró ningún Vendedor.");
        } else {
            System.out.println("ID: " + mostrar.getId()
                    + "\nNombre: " + mostrar.getNombre()
                    + "\nApellido: " + mostrar.getApellido()
                    + "\nCedula: " + mostrar.getCedula()
                    + "\nTelefono: " + mostrar.getTelefono()
                    + "\nUsuario: " + mostrar.getIdUsuario().getCorreo()
                    + "\nSucursal: " + mostrar.getIdSucursal().getNombre() + "\n");
        }
    }

    public void actualizar(Integer id) {
        Vendedor actualizado = this.vendedorControl.indexById(id);

        if (!(this.nombre == null)) {
            actualizado.setNombre(this.nombre);
        }
        if (!(this.apellido == null)) {
            actualizado.setApellido(this.apellido);
        }
        if (!(this.cedula == null)) {
            actualizado.setCedula(this.cedula);
        }
        if (!(this.telefono == null)) {
            actualizado.setTelefono(this.telefono);
        }
        if (!(this.usuarioAsociado == null)) {
            actualizado.setIdUsuario(this.usuarioAsociado);
        }
        if (!(this.sucursalAsociada == null)) {
            actualizado.setIdSucursal(this.sucursalAsociada);
        }

        this.vendedorControl.update(actualizado);
    }

    public void eliminar(Integer id) {
        this.vendedorControl.delete(this.vendedorControl.indexById(id));
    }

    public void flush() {
        this.nombre = null;
        this.apellido = null;
        this.cedula = null;
        this.telefono = null;
        this.idUsuario = null;
        this.idSucursal = null;
        this.productoControl = null;
        this.sucursalControl = null;
        this.usuarioAsociado = null;
        this.sucursalAsociada = null;
    }

    
}
