/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class ProductCRUD {

    public boolean productRegister(String productCode, String productName, int productPrice, int productQuantity) {
        Product product = new Product(-1, productCode, productName, productPrice, productQuantity);
        EnableConnection connection = new EnableConnection();
        connection.setConnection();
        try {
            if (!"".equals(product.getProductCode()) && !"".equals(product.getProductName()) && product.getProductPrice()!= 0 && product.getProductQuantity() != 0) {
                CallableStatement execute = connection.executeCall("{call product_register(?,?,?,?)}");

                // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
                //se cargan los parametros de entrada
                execute.setString(1, product.getProductCode());//Tipo String
                execute.setString(2, product.getProductName());//Tipo String
                execute.setInt(3, product.getProductPrice());//Tipo String
                execute.setInt(4, product.getProductQuantity());//Tipo String
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
    
    public boolean productUpdate(String productCode, String productName, int productPrice, int productQuantity) {
        Product product = new Product(-1, productCode, productName, productPrice, productQuantity);
        EnableConnection connection = new EnableConnection();
        connection.setConnection();
        try {
            if (!"".equals(product.getProductCode()) && !"".equals(product.getProductName()) && product.getProductPrice()!= 0 && product.getProductQuantity() != 0) {
                CallableStatement execute = connection.executeCall("{call product_update(?,?,?,?)}");

                // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
                //se cargan los parametros de entrada
                execute.setString(1, product.getProductCode());//Tipo String
                execute.setString(2, product.getProductName());//Tipo String
                execute.setInt(3, product.getProductPrice());//Tipo String
                execute.setInt(4, product.getProductQuantity());//Tipo String
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
    
    public boolean productDelete(String productCode) {
        Product product = new Product(-1, productCode, null, -1, -1);
        EnableConnection connection = new EnableConnection();
        connection.setConnection();
        try {
            if (!"".equals(product.getProductCode())) {
                CallableStatement execute = connection.executeCall("{call product_delete(?)}");

                // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
                //se cargan los parametros de entrada
                execute.setString(1, product.getProductCode());//Tipo String
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


    public ArrayList<Product> productShow() {
        try {
            EnableConnection connection = new EnableConnection();
            ArrayList<Product> products = new ArrayList();
            connection.setConnection();
            ResultSet result = connection.executeQuery("{call product_show()}");

            while (result.next()) {
                int productId = result.getInt(1);
                String productCode = result.getString(2);
                String productName = result.getString(3);
                int productPrice = result.getInt(4);
                int productQuantity = result.getInt(5);
                Product product = new Product(productId, productCode, productName, productPrice, productQuantity);
                products.add(product);
            }
            connection.disconnect();
            return products;

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar el procedimiento: " + ex.getMessage());
            return null;
        }

    }
}
