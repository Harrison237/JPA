/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import Controlador.AdministradorController;
import Controlador.TiendaController;
import Controlador.UsuarioController;
import Modelo.Administrador;
import Modelo.Tienda;
import Modelo.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author Harrison
 */
public class AdministradorOpciones {

    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String nacimientoCad;
    private Date nacimiento;
    private Integer idUsuario;
    private Integer idTienda;
    private AdministradorController adminControl = new AdministradorController();
    ;

    private UsuarioController userControl;
    private TiendaController shopControl;
    private Usuario usuarioAsociado;
    private Tienda tiendaAsociada;

    public boolean init() {
        Scanner ent = new Scanner(System.in);
        this.adminControl = new AdministradorController();
        this.userControl = new UsuarioController();
        this.shopControl = new TiendaController();
        this.usuarioAsociado = new Usuario();
        this.tiendaAsociada = new Tienda();

        try {
            System.out.print("Ingrese el nombre: ");
            this.nombre = ent.next();
            System.out.print("Ingrese el apellido: ");
            this.apellido = ent.next();
            System.out.print("Ingrese la cédula: ");
            this.cedula = ent.next();
            System.out.print("Ingrese el teléfono: ");
            this.telefono = ent.next();
            System.out.print("Ingrese una fecha con el formato dd/MM/yyyy: ");
            this.nacimientoCad = ent.next();
            System.out.print("Ingrese el Id del usuario asociado: ");
            this.idUsuario = ent.nextInt();
            System.out.print("Ingrese el Id de la tienda asociada: ");
            this.idTienda = ent.nextInt();

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
            if (this.nacimientoCad.equals("n")) {
                this.nacimiento = null;
            } else {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    this.nacimiento = formato.parse(this.nacimientoCad);
                } catch (Exception e) {
                    System.out.println("Formato de fecha inválido.");
                    return true;
                }
            }
            if (this.idUsuario == 0) {
                this.usuarioAsociado = null;
            } else {
                try {
                    usuarioAsociado = userControl.indexById(this.idUsuario);
                } catch (Exception e) {
                    System.out.println("No se encontró un usuario con el Id ingresado.");
                    return true;
                }
            }
            if (this.idTienda == 0) {
                this.tiendaAsociada = null;
            } else {
                try {
                    tiendaAsociada = shopControl.indexById(this.idTienda);
                } catch (Exception e) {
                    System.out.println("No se encontró una tienda con el Id ingresado.");
                    return true;
                }
            }

        } catch (Exception e) {
            return true;
        }

        return false;
    }

    public void crearAdministrador() {
        Administrador nuevo = new Administrador(this.nombre, this.apellido, this.cedula, this.telefono, this.nacimiento,
                this.tiendaAsociada, this.usuarioAsociado);

        this.adminControl.create(nuevo);
    }

    public void todos() {
        List<Administrador> listaAdmins = this.adminControl.index();

        for (Administrador ver : listaAdmins) {
            System.out.println("ID: " + ver.getId()
                    + "\nNombre: " + ver.getNombre()
                    + "\nApellido: " + ver.getApellido()
                    + "\nCedula: " + ver.getCedula()
                    + "\nTelefono: " + ver.getTelefono()
                    + "\nNacimiento: " + ver.getNacimiento()
                    + "\nUsuario: " + ver.getIdUsuario().getCorreo()
                    + "\nTienda: " + ver.getIdTienda().getNombre() + "\n");
        }
    }

    public void porId(Integer id) {
        Administrador mostrar = this.adminControl.indexById(id);

        if (mostrar == null) {
            System.out.println("No se encontró ningún administrador.");
        } else {
            System.out.println("ID: " + mostrar.getId()
                    + "\nNombre: " + mostrar.getNombre()
                    + "\nApellido: " + mostrar.getApellido()
                    + "\nCedula: " + mostrar.getCedula()
                    + "\nTelefono: " + mostrar.getTelefono()
                    + "\nNacimiento: " + mostrar.getNacimiento()
                    + "\nUsuario: " + mostrar.getIdUsuario().getCorreo()
                    + "\nTienda: " + mostrar.getIdTienda().getNombre() + "\n");
        }
    }

    public void actualizar(Integer id) {
        Administrador actualizado = this.adminControl.indexById(id);

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
        if (!(this.nacimiento == null)) {
            actualizado.setNacimiento(this.nacimiento);
        }
        if (!(this.usuarioAsociado == null)) {
            actualizado.setIdUsuario(this.usuarioAsociado);
        }
        if (!(this.tiendaAsociada == null)) {
            actualizado.setIdTienda(this.tiendaAsociada);
        }

        this.adminControl.update(actualizado);
    }

    public void eliminar(Integer id) {
        this.adminControl.delete(this.adminControl.indexById(id));
    }

    public void flush() {
        this.nombre = null;
        this.apellido = null;
        this.cedula = null;
        this.telefono = null;
        this.nacimiento = null;
        this.nacimientoCad = null;
        this.idUsuario = null;
        this.idTienda = null;
        this.usuarioAsociado = null;
        this.tiendaAsociada = null;
    }
}
