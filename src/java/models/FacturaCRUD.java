/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class FacturaCRUD {

    public FacturaCRUD() {
    }

    public boolean registrarFactura(int valoru, int valort, String documentoUsuario) {
        Factura factura = new Factura(valoru, valort, documentoUsuario);
        EnableConnection connection = new EnableConnection();
        connection.setConnection();
        try {
            if (factura.getValoru() != 0 && factura.getValort() != 0 && !factura.getDocumentoUsuario().equals("")) {
                CallableStatement execute = connection.executeCall("{call registrar_factura(?,?,?)}");

                // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
                //se cargan los parametros de entrada
                execute.setInt(1, factura.getValoru());//Tipo Integer
                execute.setInt(2, factura.getValort());//Tipo Integer
                execute.setString(3, factura.getDocumentoUsuario());//Tipo Integer
                // parametros de salida
                // Se ejecuta el procedimiento almacenado
                execute.execute();
                return true;
                // devuelve el valor del parametro de salida del procedimiento
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el procedimiento: " + e.getMessage());
            return false;
        }
    }

    public int mostrarSaldoCartera(int idUsuario) {
         try {
            EnableConnection connection = new EnableConnection();
            connection.setConnection();
            CallableStatement execute = connection.executeCall("{call mostrar_saldo_cartera(?)}");
            execute.setInt(1, idUsuario);//Tipo String
            ResultSet result = execute.executeQuery();
            int saldo=0;
            while (result.next()) {
                saldo = result.getInt(1);
            }
            connection.disconnect();
            return saldo;

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar el procedimiento: " + ex.getMessage());
            return 0;
        }
    }
}
