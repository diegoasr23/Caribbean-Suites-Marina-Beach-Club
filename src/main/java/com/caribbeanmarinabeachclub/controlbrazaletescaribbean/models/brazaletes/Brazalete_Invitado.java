/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Condicion;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.FormaPago;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Turno;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.interfaces.Brazalete;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author diego
 */

@Data
@NoArgsConstructor
@ToString
public class Brazalete_Invitado implements Brazalete {

    private int serial_brazalete = 0;
    private Turno turno;
    private FormaPago forma_de_pago;
    private final Condicion condicion = Condicion.INVITADO;
    private String serial_billete_pago_usd="";
    private String observacion = "";
    private String serial_autorizacion = "";
    private String responsable = "";
    private String inmueble = "";
    private String referenciaPago = "";
    private String delivered_date_LocalDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    private double exchange_rate = 0.0;
    private final double price = 5.0;
    private double monto_pagado = 0.0;
    private boolean representa_ingreso = false;
    
    public Brazalete_Invitado(String responsable, String inmueble) {
        this.responsable = responsable;
        this.inmueble = inmueble;
    }

    @Override
    public void setBrazalete_serial(int serial) {
        serial_brazalete=serial;
    }

    @Override
    public void setMontoPagado(double monto) {
      monto_pagado = monto;
    }

    @Override
    public void setExchange_rate(double exchange_rate) {
       this.exchange_rate = exchange_rate;
    }

    @Override
    public void setTurno(Turno turno){this.turno = turno;}

    @Override
    public void setFormadePago(FormaPago forma_de_pago) {this.forma_de_pago = forma_de_pago;}

}
