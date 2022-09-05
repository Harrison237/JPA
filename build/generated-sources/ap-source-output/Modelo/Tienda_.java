package Modelo;

import Modelo.Administrador;
import Modelo.Sucursal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-04T21:58:40")
@StaticMetamodel(Tienda.class)
public class Tienda_ { 

    public static volatile ListAttribute<Tienda, Sucursal> sucursalList;
    public static volatile ListAttribute<Tienda, Administrador> administradorList;
    public static volatile SingularAttribute<Tienda, Integer> id;
    public static volatile SingularAttribute<Tienda, String> nombre;

}