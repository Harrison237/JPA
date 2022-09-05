package Modelo;

import Modelo.Tienda;
import Modelo.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-04T21:58:40")
@StaticMetamodel(Administrador.class)
public class Administrador_ { 

    public static volatile SingularAttribute<Administrador, String> cedula;
    public static volatile SingularAttribute<Administrador, String> apellido;
    public static volatile SingularAttribute<Administrador, Usuario> idUsuario;
    public static volatile SingularAttribute<Administrador, Integer> id;
    public static volatile SingularAttribute<Administrador, String> telefono;
    public static volatile SingularAttribute<Administrador, String> nombre;
    public static volatile SingularAttribute<Administrador, Tienda> idTienda;
    public static volatile SingularAttribute<Administrador, Date> nacimiento;

}