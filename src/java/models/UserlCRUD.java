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
public class UserlCRUD {

    public Userl userlLogIn(String userlDocument, String userlPassword) {
        try {
            EnableConnection connection = new EnableConnection();
            connection.setConnection();
            CallableStatement execute = connection.executeCall("{call userl_login(?,?)}");
            execute.setString(1, userlDocument);//Tipo String
            execute.setString(2, userlPassword);
            ResultSet result = execute.executeQuery();
            Userl userl=null;
            while (result.next()) {
                int userlId = result.getInt(1);
                String userlName=result.getString(3);
                userl= new Userl(userlId,userlName);
            }
            connection.disconnect();
            return userl;

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar el procedimiento: " + ex.getMessage());
            return null;
        }
    }
}