/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class Pedido {
    private int id;
    private String codigo;
    private String nombre;
    private int cantidad;

    public Pedido(int id, String codigo, String nombre, int cantidad) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    public int getCantidad() {
        return cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

   

    public int getId() {
        return id;
    }
 

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    public void setId(int id) {
        this.id = id;
    }   
    
}
