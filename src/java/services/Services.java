/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author JORGE_ALEJANDRO
 */
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import models.FacturaCRUD;
import models.PedidoCRUD;
import models.UsuarioCRUD;

@Path("/services")
public class Services {
    
//    @GET
//    @Path("/registrarUsuario/{userlDocument}/{userlPassword}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String busLogIn(@PathParam("userlDocument") String userlDocument, @PathParam("userlPassword") String userlPassword) {
//        UsuarioCRUD crud=new UsuarioCRUD();
//        Userl userl=crud.userlLogIn(userlDocument,userlPassword);
//        Gson json=new Gson();
//        String result=json.toJson(userl);
//        return result;
//    }
    
    @GET
    @Path("/registrarUsuario/{documento}/{nombre}/{direccion}/{telefono}")
    @Produces(MediaType.APPLICATION_JSON)
    public String registrarUsuario(@PathParam("documento") String documento,@PathParam("nombre") String nombre,@PathParam("direccion") String direccion,@PathParam("telefono") String telefono) {
        UsuarioCRUD crud=new UsuarioCRUD();
        boolean message=crud.registrarUsuario(documento, nombre, direccion, telefono);
        if (message)
        {
            return "Success";
        }
        else
        {
            return "Failure";
        }
    }
    
    @GET
    @Path("/registrarPedido/{codigo}/{nombre}/{cantidad}")
    @Produces(MediaType.APPLICATION_JSON)
    public String registrarPedido(@PathParam("codigo") String codigo,@PathParam("nombre") String nombre, @PathParam("cantidad") int cantidad) {
        PedidoCRUD crud=new PedidoCRUD();
        boolean message=crud.registrarPedido(nombre, codigo, cantidad);
        if (message)
        {
            return "Success";
        }
        else
        {
            return "Failure";
        }
    }
    
    @GET
    @Path("/registrarFactura/{valoru}/{valort}/{documentoUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public String registrarFactura(@PathParam("valoru") int valoru,@PathParam("valort") int valort, @PathParam("documentoUsuario") String documentoUsuario) {
        FacturaCRUD crud=new FacturaCRUD();
        boolean message=crud.registrarFactura(valoru, valort, documentoUsuario);
        if (message)
        {
            return "Success";
        }
        else
        {
            return "Failure";
        }
    }
    
    
//    @GET
//    @Path("/productUpdate/{productCode}/{productName}/{productPrice}/{productQuantity}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String productUpdate(@PathParam("productCode") String productCode,@PathParam("productName") String productName,@PathParam("productPrice") int productPrice,@PathParam("productQuantity") int productQuantity) {
//        ProductCRUD crud=new ProductCRUD();
//        boolean message=crud.productUpdate(productCode, productName, productPrice, productQuantity);
//        if (message)
//        {
//            return "Success";
//        }
//        else
//        {
//            return "Failure";
//        }
//    }
//    
//    @GET
//    @Path("/productDelete/{productCode}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String productDelete(@PathParam("productCode") String productCode) {
//        ProductCRUD crud=new ProductCRUD();
//        boolean message=crud.productDelete(productCode);
//        if (message)
//        {
//            return "Success";
//        }
//        else
//        {
//            return "Failure";
//        }
//    }
//    
    @GET
    @Path("/mostrarSaldoCartera/{idUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public String mostrarSaldoCartera(@PathParam("idUsuario") int idUsuario) {
        FacturaCRUD crud=new FacturaCRUD();
        int saldo=crud.mostrarSaldoCartera(idUsuario);
        Gson json=new Gson();
        String result=json.toJson(saldo);
        return result;
    }
    
}
