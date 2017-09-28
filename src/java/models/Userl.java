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
public class Userl {
    private int userlId;
    private String userlDocument;
    private String userlName;
    private String userlAddress;
    private String userlPhone;
    private String userlCity;
    private String userlPassword;

    public Userl(int userl_id, String userl_document, String userl_name, String userl_address, String userl_phone, String userl_city, String userl_password) {
        this.userlId = userl_id;
        this.userlDocument = userl_document;
        this.userlName = userl_name;
        this.userlAddress = userl_address;
        this.userlPhone = userl_phone;
        this.userlCity = userl_city;
        this.userlPassword = userl_password;
    }
    
    public Userl(int userlId) {
        this.userlId = userlId;
        this.userlDocument = null;
        this.userlName = null;
        this.userlAddress = null;
        this.userlPhone = null;
        this.userlCity = null;
        this.userlPassword = null;
    }
    
    public Userl(int userlId, String userlName) {
        this.userlId = userlId;
        this.userlDocument = null;
        this.userlName = userlName;
        this.userlAddress = null;
        this.userlPhone = null;
        this.userlCity = null;
        this.userlPassword = null;
    }

    public String getUserlAddress() {
        return userlAddress;
    }

    public String getUserlCity() {
        return userlCity;
    }

    public String getUserlDocument() {
        return userlDocument;
    }

    public int getUserlId() {
        return userlId;
    }

    public String getUserlName() {
        return userlName;
    }

    public String getUserlPassword() {
        return userlPassword;
    }

    public String getUserlPhone() {
        return userlPhone;
    }

    public void setUserlAddress(String userlAddress) {
        this.userlAddress = userlAddress;
    }

    public void setUserlCity(String userlCity) {
        this.userlCity = userlCity;
    }

    public void setUserlDocument(String userlDocument) {
        this.userlDocument = userlDocument;
    }

    public void setUserlId(int userlId) {
        this.userlId = userlId;
    }

    public void setUserlName(String userlName) {
        this.userlName = userlName;
    }

    public void setUserlPassword(String userlPassword) {
        this.userlPassword = userlPassword;
    }

    public void setUserlPhone(String userlPhone) {
        this.userlPhone = userlPhone;
    }
    
    
}
