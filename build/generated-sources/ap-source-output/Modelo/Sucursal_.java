package Modelo;

import Modelo.Producto;
import Modelo.Tienda;
import Modelo.Vendedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-04T21:58:40")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile ListAttribute<Sucursal, Vendedor> vendedorList;
    public static volatile ListAttribute<Sucursal, Producto> productoList;
    public static volatile SingularAttribute<Sucursal, String> direccion;
    public static volatile SingularAttribute<Sucursal, Integer> id;
    public static volatile SingularAttribute<Sucursal, String> nombre;
    public static volatile SingularAttribute<Sucursal, Tienda> idTienda;

}