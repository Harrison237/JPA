package Modelo;

import Modelo.Vendedor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-04T21:58:40")
@StaticMetamodel(Historial.class)
public class Historial_ { 

    public static volatile SingularAttribute<Historial, Date> logout;
    public static volatile SingularAttribute<Historial, Vendedor> idVendedor;
    public static volatile SingularAttribute<Historial, Integer> id;
    public static volatile SingularAttribute<Historial, Date> login;

}