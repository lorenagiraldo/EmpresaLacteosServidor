/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author NIYIRETH_OSORIO
 */
public class EnableConnection {
    private final String url = "jdbc:postgresql://localhost:5432/enterprise";
    private final String user = "postgres";
    private final String password = "root";

    private Connection connection;
    private CallableStatement fop;

    public void setConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password); // getting Statement object to execute query
            fop=null;
        } catch (SQLException ex) {
            System.out.println("Connection error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en la clase");
        }
    }
    
    public ResultSet executeQuery(String sql)
    {
        try {
            fop=connection.prepareCall(sql);
            ResultSet resultado=fop.executeQuery();
            return resultado;
        } catch (SQLException ex) {
            return null;
        }
    }
   

    public CallableStatement executeCall(String sql)
    {
        try {
            fop=connection.prepareCall(sql);
            return fop;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void disconnect() {
        try {
            fop.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println("error al desconectar");
        }
    }
}
