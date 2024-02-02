/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.caribbeanmarinabeachclub.controlbrazaletescaribbean.controller;

import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Brazalete_alquilado;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Condicion;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.FormaPago;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Turno;
import org.junit.Test;

/**
 *
 * @author diego
 */
public class Build_BrazaletesTest {
    
    public Build_BrazaletesTest() {
    }

    /**
     * Test of build_define_instances method, of class Build_Brazaletes.
     */
    @Test
    public void testBuild_define_instances() {
        System.out.println("Construir brazalete de propietario");
        String condicion = "ALQUILADO";
        String inmueble = "3-42";
        int serial = 320439;
        String observacion = "null";
        Build_Brazaletes instance = new Build_Brazaletes();
        instance.build_define_instances(Condicion.ALQUILADO);
        instance.build_brazalete(inmueble, Turno.TURNO_DIURNO, serial, observacion, "Maria", "332", FormaPago.PAGO_BS,
                20.2, "3232", false, "l23223");
        Brazalete_alquilado propietario = instance.getBrazalete_alquilado();
        System.out.println(propietario.toString());
        System.out.println(propietario.isRepresenta_ingreso());
    }

    
}
