package com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes;

import java.sql.Timestamp;
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

@NoArgsConstructor
@Data
@ToString
public class Brazalete_Propietario implements Brazalete {

    private String responsable = "";
    private String property = "";
    private String observacion = "";
    private final Condicion condicion = Condicion.PROPIETARIO;
    private String delivered_date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    private int serial = 0;
    private Turno turno;
    private final boolean representa_ingreso = false;

    public Brazalete_Propietario(String responsable, String property, Turno turno, int serial, String observacion) {
        this.responsable = responsable;
        this.property = property;
        this.turno = turno;
        this.serial = serial;
        this.observacion = observacion;
        
    }

    @Override
    public void setBrazalete_serial(int serial) {
        this.serial = serial;
    }

    @Override
    public void setMontoPagado(double price) {
        
    }

    @Override
    public void setExchange_rate(double exchange_rate) {
        
    }

    @Override
    public void setFormadePago(FormaPago forma_de_pago) {

    }
    @Override
    public void setTurno(Turno turno){
        this.turno = turno;
    }

    public Timestamp getTimeStamp(){
        return Timestamp.valueOf(delivered_date);
    }
}
