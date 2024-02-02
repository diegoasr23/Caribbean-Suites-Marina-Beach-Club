package com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.interfaces;

import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.FormaPago;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Turno;

/**
 * @author diego
 */
public interface Brazalete {

    public void setBrazalete_serial(int serial);

    public void setMontoPagado(double monto);

    public void setExchange_rate(double exchange_rate);

    public void setTurno(Turno turno);

    public void setFormadePago(FormaPago forma_de_pago);

}
