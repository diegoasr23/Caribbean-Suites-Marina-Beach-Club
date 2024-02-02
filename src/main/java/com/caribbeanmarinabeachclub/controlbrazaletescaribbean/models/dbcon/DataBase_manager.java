package com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.dbcon;

import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.interfaces.Brazalete;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Brazalete_Invitado;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Brazalete_Propietario;
import com.caribbeanmarinabeachclub.controlbrazaletescaribbean.models.brazaletes.Brazalete_alquilado;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class DataBase_manager {

    private static final HikariDataSource dataSource;

    @Getter
    private static Connection connection;

    //Configuramos el pool de conexiones
    static {

        HikariConfig config = new HikariConfig("src/main/resources/config.properties");
        dataSource = new HikariDataSource(config);
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveBrazalete(Brazalete brazalete) {
        String sql = getString(brazalete);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            if (brazalete instanceof Brazalete_Propietario brazaletePropietario) {

                preparedStatement.setInt(1, brazaletePropietario.getSerial());
                preparedStatement.setString(2, brazaletePropietario.getProperty());
                preparedStatement.setString(3, brazaletePropietario.getCondicion().toString());
                preparedStatement.setString(4, brazaletePropietario.getDelivered_date());
                preparedStatement.setString(5, brazaletePropietario.getResponsable());
                preparedStatement.setString(6, brazaletePropietario.getObservacion());
                preparedStatement.setString(7, brazaletePropietario.getTurno().toString());

            } else if (brazalete instanceof Brazalete_Invitado brazaleteInvitado) {
                if(brazaleteInvitado.isRepresenta_ingreso()) {

                    preparedStatement.setInt(1, brazaleteInvitado.getSerial_brazalete());
                    preparedStatement.setString(2, brazaleteInvitado.getInmueble());
                    preparedStatement.setString(3, brazaleteInvitado.getCondicion().toString());
                    preparedStatement.setString(4, brazaleteInvitado.getDelivered_date_LocalDateTime());
                    preparedStatement.setString(5, brazaleteInvitado.getResponsable());
                    preparedStatement.setString(6, brazaleteInvitado.getSerial_autorizacion());
                    preparedStatement.setString(7, brazaleteInvitado.getTurno().toString());
                    preparedStatement.setString(8, brazaleteInvitado.getForma_de_pago().name());
                    preparedStatement.setDouble(9, brazaleteInvitado.getPrice());
                    preparedStatement.setDouble(10, brazaleteInvitado.getExchange_rate());
                    preparedStatement.setDouble(11, brazaleteInvitado.getMonto_pagado());
                    preparedStatement.setString(12, brazaleteInvitado.getReferenciaPago());
                    preparedStatement.setString(13, brazaleteInvitado.getSerial_billete_pago_usd());
                    preparedStatement.setString(14, brazaleteInvitado.getObservacion());
                    preparedStatement.setBoolean(15, brazaleteInvitado.isRepresenta_ingreso());
                }else{
                    preparedStatement.setInt(1, brazaleteInvitado.getSerial_brazalete());
                    preparedStatement.setString(2, brazaleteInvitado.getInmueble());
                    preparedStatement.setString(3, brazaleteInvitado.getCondicion().toString());
                    preparedStatement.setString(4, brazaleteInvitado.getDelivered_date_LocalDateTime());
                    preparedStatement.setString(5, brazaleteInvitado.getResponsable());
                    preparedStatement.setString(6, brazaleteInvitado.getSerial_autorizacion());
                    preparedStatement.setString(7, brazaleteInvitado.getTurno().toString());
                    preparedStatement.setString(8, brazaleteInvitado.getObservacion());
                    preparedStatement.setBoolean(9, brazaleteInvitado.isRepresenta_ingreso());
                }
            } else{
                assert brazalete instanceof Brazalete_alquilado;
                Brazalete_alquilado brazaleteAlquilado = (Brazalete_alquilado) brazalete;

                preparedStatement.setInt(1, brazaleteAlquilado.getSerial_brazalete());
                preparedStatement.setString(2, brazaleteAlquilado.getInmueble());
                preparedStatement.setString(3, brazaleteAlquilado.getCondicion().toString());
                preparedStatement.setString(4, brazaleteAlquilado.getDelivered_date_LocalDateTime());
                preparedStatement.setString(5, brazaleteAlquilado.getResponsable());
                preparedStatement.setString(6, brazaleteAlquilado.getSerial_autorizacion());
                preparedStatement.setString(7, brazaleteAlquilado.getTurno().toString());
                preparedStatement.setString(8, brazaleteAlquilado.getForma_de_pago().toString());
                preparedStatement.setDouble(9, brazaleteAlquilado.getPrice());
                preparedStatement.setDouble(10, brazaleteAlquilado.getExchange_rate());
                preparedStatement.setDouble(11, brazaleteAlquilado.getMonto_pagado());
                preparedStatement.setString(12, brazaleteAlquilado.getReferenciaPago());
                preparedStatement.setString(13, brazaleteAlquilado.getSerial_billete_pago_usd());
                preparedStatement.setString(14, brazaleteAlquilado.getObservacion());
                preparedStatement.setBoolean(15, brazaleteAlquilado.isRepresenta_ingreso());
            }

            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }

    }

    private static String getString(Brazalete brazalete) {
        String sql;

        String sql_propietario = "INSERT INTO CaribbeanCloud_Schema.relacion_brazaletes " +
                "(serial_number," +
                "property," +
                "`condition`," +
                "delivery_date," +
                "responsable_nombre," +
                "observacion," +
                "turno) " +
                "VALUES (?, ?, ?, ?, ?, ?,?)";

        String sql_alquilado = "INSERT INTO CaribbeanCloud_Schema.relacion_brazaletes " +
                "(serial_number, property, `condition`," +
                " delivery_date, responsable_nombre, serial_autorizacion," +
                " turno, forma_de_pago, price," +
                " exchange_rate, monto_pagado, referencia_pago_bs, " +
                " serial_billete_pago_usd, observacion, representa_ingreso) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?," +
                " ?, ?, ?, ?, ? ,? ,?, ?)";

        String sql_invitado_no_ingreso = "INSERT INTO CaribbeanCloud_Schema.relacion_brazaletes " +
                "(serial_number, property, `condition`," +
                " delivery_date, responsable_nombre, serial_autorizacion," +
                " turno, observacion, representa_ingreso) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";


        if(brazalete instanceof Brazalete_Invitado brazaleteInvitado){

            sql = (brazaleteInvitado.isRepresenta_ingreso()) ? sql_alquilado : sql_invitado_no_ingreso;
        }else if( brazalete instanceof Brazalete_alquilado){
            sql = sql_alquilado;
        }else{
            sql = sql_propietario;
        }
        return sql;
    }
}



