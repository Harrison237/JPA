package Modelo;

import Modelo.Historial;
import Modelo.Sucursal;
import Modelo.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-04T21:58:40")
@StaticMetamodel(Vendedor.class)
public class Vendedor_ { 

    public static volatile SingularAttribute<Vendedor, Sucursal> idSucursal;
    public static volatile SingularAttribute<Vendedor, String> cedula;
    public static volatile SingularAttribute<Vendedor, String> apellido;
    public static volatile SingularAttribute<Vendedor, Usuario> idUsuario;
    public static volatile ListAttribute<Vendedor, Historial> historialList;
    public static volatile SingularAttribute<Vendedor, Integer> id;
    public static volatile SingularAttribute<Vendedor, String> telefono;
    public static volatile SingularAttribute<Vendedor, String> nombre;

}