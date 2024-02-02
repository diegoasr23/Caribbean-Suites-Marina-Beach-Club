package com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.dbcon;

import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.controller.Build_Brazaletes;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Condicion;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.FormaPago;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Turno;
import org.junit.Test;

public class DataBase_managerTest {
    @Test
    public void name() {
        DataBase_manager dataBaseManager = new DataBase_manager();
        System.out.println("Construir brazalete de propietario");
        String condicion = "PROPIETARIO";
        String inmueble = "3-42";
        int serial = 68230;
        String observacion = "null";

        Build_Brazaletes instance = new Build_Brazaletes();

        instance.build_define_instances(Condicion.INVITADO);

        instance.build_brazalete(inmueble, Turno.TURNO_DIURNO, serial, observacion,
                "Maria", "3232", FormaPago.PAGO_USD,
                0.0, "", true, "l3403");


    }
}