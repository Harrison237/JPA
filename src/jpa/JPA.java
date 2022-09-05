/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import Controlador.UsuarioController;
import Modelo.Usuario;
import java.util.Scanner;

public class JPA {

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        Integer claseOpc = null;

        do {
            System.out.println("Seleccione la clase que quiere modificar: "
                    + "\n1. Administrador."
                    + "\n2. Historial."
                    + "\n3. Producto."
                    + "\n4. Referencia."
                    + "\n5. Sucursal."
                    + "\n6. Tienda."
                    + "\n7. Usuario"
                    + "\n8. Vendedor."
                    + "\n9. Venta."
                    + "\n0. Salir.");
            claseOpc = ent.nextInt();
            
            opciones(claseOpc);
        } while (claseOpc != 0);
    }

    public static void opciones(int opcion) {
        Scanner ent = new Scanner(System.in);
        Integer accionOpc = null;
        String opcionesCrud = ("1 -> Crear"
                + "\n2 -> Consultar todos"
                + "\n3 -> Consultar por Id"
                + "\n4 -> Actualizar"
                + "\n5 -> Eliminar"
                + "\n0 -> Regresar");
        Boolean errores = null;
        Integer id = null;
        
        switch (opcion) {
            case 1:
                AdministradorOpciones opciones = new AdministradorOpciones();
                errores = null;

                do {
                    if (errores != null) {
                        if (errores) {
                            System.out.println("\n-----Ocurrió un error en el proceso, vuelva a intentar-----\n");
                        }
                    }
                    System.out.println("Tabla: Administrador\n" + opcionesCrud);
                    accionOpc = ent.nextInt();

                    switch (accionOpc) {
                        case 1:
                            opciones.flush();
                            errores = opciones.init();
                            opciones.crearAdministrador();
                            break;
                        case 2:
                            opciones.todos();
                            break;
                        case 3:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones.porId(id);
                            break;
                        case 4:
                            opciones.flush();
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            System.out.println("----Llene los datos (Si quiere dejar el valor actual Escriba 'n' y en ids deje 0)----");
                            errores = opciones.init();
                            opciones.actualizar(id);
                            break;
                        case 5:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones.eliminar(id);
                            break;
                    }
                } while (accionOpc != 0);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
        }
    }
}
