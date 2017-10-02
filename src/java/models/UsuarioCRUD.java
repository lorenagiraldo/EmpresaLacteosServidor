/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class UsuarioCRUD {

//    public Userl userlLogIn(String userlDocument, String userlPassword) {
//        try {
//            EnableConnection connection = new EnableConnection();
//            connection.setConnection();
//            CallableStatement execute = connection.executeCall("{call userl_login(?,?)}");
//            execute.setString(1, userlDocument);//Tipo String
//            execute.setString(2, userlPassword);
//            ResultSet result = execute.executeQuery();
//            Userl userl=null;
//            while (result.next()) {
//                int userlId = result.getInt(1);
//                String userlName=result.getString(3);
//                userl= new Userl(userlId,userlName);
//            }
//            connection.disconnect();
//            return userl;
//
//        } catch (SQLException ex) {
//            System.out.println("Error al ejecutar el procedimiento: " + ex.getMessage());
//            return null;
//        }
//    }
    
    public boolean registrarUsuario(String documento, String nombre, String direccion,String telefono)
    {
        Usuario usuario = new Usuario(-1, documento,nombre,direccion,telefono);
        EnableConnection connection = new EnableConnection();
        connection.setConnection();
        try {
            if (!"".equals(usuario.getDocumento()) && !"".equals(usuario.getNombre())) {
                CallableStatement execute = connection.executeCall("{call registrar_usuario(?,?,?,?)}");

                // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
                //se cargan los parametros de entrada
                execute.setString(1, usuario.getDocumento());//Tipo String
                execute.setString(2, usuario.getNombre());//Tipo String
                execute.setString(3, usuario.getDireccion());//Tipo String
                execute.setString(4, usuario.getTelefono());//Tipo String
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
