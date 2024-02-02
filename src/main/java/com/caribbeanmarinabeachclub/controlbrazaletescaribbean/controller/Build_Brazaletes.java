package com.caribbeanmarinabeachclub.controlbrazaletescaribbean.controller;

import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.interfaces.Brazalete;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Brazalete_Invitado;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Brazalete_Propietario;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Brazalete_alquilado;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.api_services.Currency_rate_API;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.FormaPago;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Turno;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Condicion;
import lombok.Getter;


public class Build_Brazaletes {

    @Getter
    private Brazalete_Propietario brazalete_propietario;
    @Getter
    private Brazalete_alquilado brazalete_alquilado;
    @Getter
    private Brazalete_Invitado brazalete_invitado;
    private Currency_rate_API currency_rate_api;

    private Brazalete brazalete;

    @Getter
    private double price_ves_usd = 0.0;

    public Build_Brazaletes() {
        currency_rate_api = new Currency_rate_API();
        price_ves_usd = currency_rate_api.getPriceVES_USD();
    }

    public void build_define_instances(Condicion condicion) {

        brazalete = switch (condicion) {
            case PROPIETARIO -> new Brazalete_Propietario();
            case INVITADO -> new Brazalete_Invitado();
            default -> new Brazalete_alquilado();
        };

        defineInstance(brazalete);
    }

    public void defineInstance(Brazalete brazalete) {
        
            
        if (brazalete instanceof Brazalete_Propietario) {
            brazalete_propietario = (Brazalete_Propietario) brazalete;

        } else if (brazalete instanceof Brazalete_alquilado) {
            brazalete_alquilado = (Brazalete_alquilado) brazalete;
        } else {
            brazalete_invitado = (Brazalete_Invitado) brazalete;
        }

    }

    public void build_brazalete(String inmueble, Turno turno, int serial, String observacion, String responsable,
                                String serial_autorizacion, FormaPago forma_de_pago, double monto_pago_bs,
                                String ref_pago, boolean representa_ingreso, String billete_serial_pago_usd) {
        if (brazalete_propietario != null) {
            brazalete_propietario.setProperty(inmueble);
            brazalete_propietario.setTurno(turno);
            brazalete_propietario.setBrazalete_serial(serial);
            brazalete_propietario.setObservacion(observacion);
            brazalete_propietario.setResponsable(responsable);

        } else if (brazalete_invitado != null) {
            brazalete_invitado.setBrazalete_serial(serial);
            brazalete_invitado.setInmueble(inmueble);
            brazalete_invitado.setResponsable(responsable);
            brazalete_invitado.setSerial_autorizacion(serial_autorizacion);
            brazalete_invitado.setTurno(turno);
            brazalete_invitado.setObservacion(observacion);
            brazalete_invitado.setRepresenta_ingreso(representa_ingreso);

            if (representa_ingreso) {
                brazalete_invitado.setFormadePago(forma_de_pago);
                brazalete_invitado.setExchange_rate(price_ves_usd);
                brazalete_invitado.setMontoPagado(monto_pago_bs);
                brazalete_invitado.setReferenciaPago(ref_pago);
                brazalete_invitado.setSerial_billete_pago_usd(billete_serial_pago_usd);


            }

        } else {
            brazalete_alquilado.setBrazalete_serial(serial);
            brazalete_alquilado.setInmueble(inmueble);
            brazalete_alquilado.setResponsable(responsable);
            brazalete_alquilado.setSerial_autorizacion(serial_autorizacion);
            brazalete_alquilado.setTurno(turno);
            brazalete_alquilado.setFormadePago(forma_de_pago);
            brazalete_alquilado.setExchange_rate(price_ves_usd);
            brazalete_alquilado.setMontoPagado(monto_pago_bs);
            brazalete_alquilado.setReferenciaPago(ref_pago);
            brazalete_alquilado.setSerial_billete_pago_usd(billete_serial_pago_usd);
            brazalete_alquilado.setObservacion(observacion);

        }
    }
    
    public void clearAll(){
        brazalete_alquilado = null;
        brazalete_invitado = null;
        brazalete_propietario = null;
    }
}
