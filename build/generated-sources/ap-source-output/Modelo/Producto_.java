package Modelo;

import Modelo.Referencia;
import Modelo.Sucursal;
import Modelo.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-04T21:58:40")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile ListAttribute<Producto, Sucursal> sucursalList;
    public static volatile SingularAttribute<Producto, Long> precio;
    public static volatile SingularAttribute<Producto, Long> tamaño;
    public static volatile SingularAttribute<Producto, String> color;
    public static volatile ListAttribute<Producto, Venta> ventaList;
    public static volatile SingularAttribute<Producto, Integer> id;
    public static volatile SingularAttribute<Producto, Referencia> idReferencia;
    public static volatile SingularAttribute<Producto, String> nombre;

}