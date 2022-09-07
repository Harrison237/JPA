/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import Controlador.HistorialController;
import Controlador.VendedorController;
import Modelo.Historial;
import Modelo.Vendedor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HistorialOpciones {
    private Date login;
    private String loginC;
    private Date logout;
    private String logoutC;
    private Integer idVendedor;
    private HistorialController historyControl = new HistorialController();
    
    private Vendedor vendedorAsociado;
    private VendedorController sellerControl;
    
    public boolean init() {
        Scanner ent = new Scanner(System.in);
        this.sellerControl = new VendedorController();
        
        System.out.print("Ingrese el login con el formato dd/MM/yyyy: ");
        this.loginC = ent.next();
        System.out.print("Ingrese el logout con el formato dd/MM/yyyy: ");
        this.logoutC = ent.next();
        System.out.print("Ingrese el Id del vendedor asociado: ");
        this.idVendedor = ent.nextInt();
        
        if(this.loginC.equals("n")) {
            this.login = null;
        } else {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    this.login = formato.parse(this.loginC);
                } catch (Exception e) {
                    System.out.println("Formato de fecha inválido.");
                    return true;
                }
        }
        if(this.logoutC.equals("n")) {
            this.logout = null;
        } else {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    this.logout = formato.parse(this.logoutC);
                } catch (Exception e) {
                    System.out.println("Formato de fecha inválido.");
                    return true;
                }
        }
        if(this.idVendedor == 0) {
            this.idVendedor = null;
            this.vendedorAsociado = null;
        } else {
            try {
                sellerControl = new VendedorController();
                this.vendedorAsociado = sellerControl.indexById(this.idVendedor);
                
                if(this.vendedorAsociado == null) {
                    System.out.println("No se encontró un vendedor con el Id ingresado.");
                    return true;
                }
            } catch (Exception e) {
                System.out.println("No se encontró un vendedor con el Id ingresado.");
                return true;
            }
        }
        return false;
    }
    
    public void crearHistorial() {
        Historial nuevo = new Historial(this.login,this.logout,this.vendedorAsociado);
        
        this.historyControl.create(nuevo);
    }
    
    public void todos() {
        List<Historial> listaHistoriales = this.historyControl.index();
    
        for(Historial ver : listaHistoriales) {
            System.out.println("ID: "+ver.getId()
                    + "\nLogin: "+ver.getLogin()
                    + "\nLogout: "+ver.getLogout()
                    + "\nVendedor: "+ver.getIdVendedor().getNombre()+"\n");
        }
    }
    
    public void porId(Integer id) {
        Historial mostrar = this.historyControl.indexById(id);
        
        if(mostrar == null) {
            System.out.println("No se encontró el historial");
        } else {
            System.out.println("ID: "+mostrar.getId()
                    + "\nLogin: "+mostrar.getLogin()
                    + "\nLogout: "+mostrar.getLogout()
                    + "\nVendedor: "+mostrar.getIdVendedor().getNombre()+"\n");
        }
    }
    
    public void actualizar(Integer id) {
        Historial actualizado = this.historyControl.indexById(id);
        
        if(!(this.login == null)) {
            actualizado.setLogin(this.login);
        }
        if(!(this.logout == null)) {
            actualizado.setLogout(logout);
        }
        if(!(this.vendedorAsociado == null)) {
            actualizado.setIdVendedor(this.vendedorAsociado);
        }
        
        this.historyControl.update(actualizado);
    }
    
    public void eliminar(Integer id) {
        this.historyControl.delete(this.historyControl.indexById(id));
    }
    
    public void flush() {
        this.idVendedor = null;
        this.login = null;
        this.loginC = "";
        this.logout = null;
        this.logoutC = null;
        this.sellerControl = null;
        this.vendedorAsociado = null;
    }
}
