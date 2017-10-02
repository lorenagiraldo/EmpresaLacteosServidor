/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class PedidoCRUD {
    
    public boolean registrarPedido(String codigo, String nombre, int cantidad)
    {
        Pedido pedido = new Pedido(-1, codigo, nombre, cantidad);
        EnableConnection connection = new EnableConnection();
        connection.setConnection();
        try {
            if (!"".equals(pedido.getCodigo()) && pedido.getCantidad()!=0) {
                CallableStatement execute = connection.executeCall("{call registrar_pedido(?,?,?)}");

                // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
                //se cargan los parametros de entrada
                execute.setString(1, pedido.getCodigo());
                execute.setString(2, pedido.getNombre());//Tipo String
                execute.setInt(3, pedido.getCantidad());//Tipo Integer
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
}
