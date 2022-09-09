/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

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
                HistorialOpciones opciones1 = new HistorialOpciones();
                errores = null;

                do {
                    if (errores != null) {
                        if (errores) {
                            System.out.println("\n-----Ocurrió un error en el proceso, vuelva a intentar-----\n");
                        }
                    }
                    System.out.println("Tabla: Historial\n" + opcionesCrud);
                    accionOpc = ent.nextInt();

                    switch (accionOpc) {
                        case 1:
                            opciones1.flush();
                            if (!opciones1.init()) {
                                opciones1.crearHistorial();
                            }
                            break;
                        case 2:
                            opciones1.todos();
                            break;
                        case 3:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones1.porId(id);
                            break;
                        case 4:
                            opciones1.flush();
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            System.out.println("----Llene los datos (Si quiere dejar el valor actual Escriba 'n' y en ids deje 0)----");
                            errores = opciones1.init();
                            opciones1.actualizar(id);
                            break;
                        case 5:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones1.eliminar(id);
                            break;
                    }
                } while (accionOpc != 0);
                break;
            case 3:
                ProductoOpciones opciones2 = new ProductoOpciones();
                errores = null;

                do {
                    if (errores != null) {
                        if (errores) {
                            System.out.println("\n-----Ocurrió un error en el proceso, vuelva a intentar-----\n");
                        }
                    }
                    System.out.println("Tabla: Producto\n" + opcionesCrud);
                    accionOpc = ent.nextInt();

                    switch (accionOpc) {
                        case 1:
                            opciones2.flush();
                            errores = opciones2.init();
                            opciones2.crearProducto();
                            break;
                        case 2:
                            opciones2.todos();
                            break;
                        case 3:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones2.porId(id);
                            break;
                        case 4:
                            opciones2.flush();
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            System.out.println("----Llene los datos (Si quiere dejar el valor actual Escriba 'n' y en ids deje 0)----");
                            errores = opciones2.init();
                            opciones2.actualizar(id);
                            break;
                        case 5:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones2.eliminar(id);
                            break;
                    }
                } while (accionOpc != 0);
                break;
            case 4:
                ReferenciaOpciones opciones3 = new ReferenciaOpciones();
                errores = null;

                do {
                    if (errores != null) {
                        if (errores) {
                            System.out.println("\n-----Ocurrió un error en el proceso, vuelva a intentar-----\n");
                        }
                    }
                    System.out.println("Tabla: Referencia\n" + opcionesCrud);
                    accionOpc = ent.nextInt();

                    switch (accionOpc) {
                        case 1:
                            opciones3.flush();
                            errores = opciones3.init();
                            opciones3.crearReferencia();
                            break;
                        case 2:
                            opciones3.todos();
                            break;
                        case 3:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones3.porId(id);
                            break;
                        case 4:
                            opciones3.flush();
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            System.out.println("----Llene los datos (Si quiere dejar el valor actual Escriba 'n' y en ids deje 0)----");
                            errores = opciones3.init();
                            opciones3.actualizar(id);
                            break;
                        case 5:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones3.eliminar(id);
                            break;
                    }
                } while (accionOpc != 0);
                break;
            case 5:
                SucursalOpciones opciones4 = new SucursalOpciones();
                errores = null;

                do {
                    if (errores != null) {
                        if (errores) {
                            System.out.println("\n-----Ocurrió un error en el proceso, vuelva a intentar-----\n");
                        }
                    }
                    System.out.println("Tabla: Sucursal\n" + opcionesCrud);
                    accionOpc = ent.nextInt();

                    switch (accionOpc) {
                        case 1:
                            opciones4.flush();
                            errores = opciones4.init();
                            opciones4.crearSucursal();
                            break;
                        case 2:
                            opciones4.todos();
                            break;
                        case 3:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones4.porId(id);
                            break;
                        case 4:
                            opciones4.flush();
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            System.out.println("----Llene los datos (Si quiere dejar el valor actual Escriba 'n' y en ids deje 0)----");
                            errores = opciones4.init();
                            opciones4.actualizar(id);
                            break;
                        case 5:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones4.eliminar(id);
                            break;
                    }
                } while (accionOpc != 0);
                break;
            case 6:
                TiendaOpciones opciones5 = new TiendaOpciones();
                errores = null;

                do {
                    if (errores != null) {
                        if (errores) {
                            System.out.println("\n-----Ocurrió un error en el proceso, vuelva a intentar-----\n");
                        }
                    }
                    System.out.println("Tabla: Tienda\n" + opcionesCrud);
                    accionOpc = ent.nextInt();

                    switch (accionOpc) {
                        case 1:
                            opciones5.flush();
                            errores = opciones5.init();
                            opciones5.crearTienda();
                            break;
                        case 2:
                            opciones5.todos();
                            break;
                        case 3:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones5.porId(id);
                            break;
                        case 4:
                            opciones5.flush();
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            System.out.println("----Llene los datos (Si quiere dejar el valor actual Escriba 'n' y en ids deje 0)----");
                            errores = opciones5.init();
                            opciones5.actualizar(id);
                            break;
                        case 5:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones5.eliminar(id);
                            break;
                    }
                } while (accionOpc != 0);
                break;
            case 7:
                UsuarioOpciones opciones6 = new UsuarioOpciones();
                errores = null;

                do {
                    if (errores != null) {
                        if (errores) {
                            System.out.println("\n-----Ocurrió un error en el proceso, vuelva a intentar-----\n");
                        }
                    }
                    System.out.println("Tabla: Usuario\n" + opcionesCrud);
                    accionOpc = ent.nextInt();

                    switch (accionOpc) {
                        case 1:
                            opciones6.flush();
                            errores = opciones6.init();
                            opciones6.crearUsuario();
                            break;
                        case 2:
                            opciones6.todos();
                            break;
                        case 3:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones6.porId(id);
                            break;
                        case 4:
                            opciones6.flush();
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            System.out.println("----Llene los datos (Si quiere dejar el valor actual Escriba 'n' y en ids deje 0)----");
                            errores = opciones6.init();
                            opciones6.actualizar(id);
                            break;
                        case 5:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones6.eliminar(id);
                            break;
                    }
                } while (accionOpc != 0);
                break;
            case 8: 
                VendedorOpciones opciones7 = new VendedorOpciones();
                errores = null;

                do {
                    if (errores != null) {
                        if (errores) {
                            System.out.println("\n-----Ocurrió un error en el proceso, vuelva a intentar-----\n");
                        }
                    }
                    System.out.println("Tabla: Vendedor\n" + opcionesCrud);
                    accionOpc = ent.nextInt();

                    switch (accionOpc) {
                        case 1:
                            opciones7.flush();
                            errores = opciones7.init();
                            opciones7.crearVendedor();
                            break;
                        case 2:
                            opciones7.todos();
                            break;
                        case 3:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones7.porId(id);
                            break;
                        case 4:
                            opciones7.flush();
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            System.out.println("----Llene los datos (Si quiere dejar el valor actual Escriba 'n' y en ids deje 0)----");
                            errores = opciones7.init();
                            opciones7.actualizar(id);
                            break;
                        case 5:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones7.eliminar(id);
                            break;
                    }
                } while (accionOpc != 0);
                break;
            case 9:
                VentaOpciones opciones8 = new VentaOpciones();
                errores = null;

                do {
                    if (errores != null) {
                        if (errores) {
                            System.out.println("\n-----Ocurrió un error en el proceso, vuelva a intentar-----\n");
                        }
                    }
                    System.out.println("Tabla: Venta\n" + opcionesCrud);
                    accionOpc = ent.nextInt();

                    switch (accionOpc) {
                        case 1:
                            opciones8.flush();
                            errores = opciones8.init();
                            opciones8.crearVenta();
                            break;
                        case 2:
                            opciones8.todos();
                            break;
                        case 3:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones8.porId(id);
                            break;
                        case 4:
                            opciones8.flush();
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            System.out.println("----Llene los datos (Si quiere dejar el valor actual Escriba 'n' y en ids deje 0)----");
                            errores = opciones8.init();
                            opciones8.actualizar(id);
                            break;
                        case 5:
                            System.out.println("Ingrese el id: ");
                            id = ent.nextInt();
                            opciones8.eliminar(id);
                            break;
                    }
                } while (accionOpc != 0);
                break;
        }
    }
}
