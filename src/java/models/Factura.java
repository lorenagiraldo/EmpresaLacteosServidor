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
public class Factura {
    private int valoru;
    private int valort;
    private String DocumentoUsuario;

    public Factura(int valoru, int valort, String DocumentoUsuario) {
        this.valoru = valoru;
        this.valort = valort;
        this.DocumentoUsuario = DocumentoUsuario;
    }

    public String getDocumentoUsuario() {
        return DocumentoUsuario;
    }


    public int getValort() {
        return valort;
    }

    public int getValoru() {
        return valoru;
    }

    public void setDocumentoUsuario(String DocumentoUsuario) {
        this.DocumentoUsuario = DocumentoUsuario;
    }

    public void setValort(int valort) {
        this.valort = valort;
    }

    public void setValoru(int valoru) {
        this.valoru = valoru;
    }
}
