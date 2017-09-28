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
import models.Product;
import models.ProductCRUD;
import models.Userl;
import models.UserlCRUD;

@Path("/services")
public class Services {
    
    @GET
    @Path("/userLogIn/{userlDocument}/{userlPassword}")
    @Produces(MediaType.APPLICATION_JSON)
    public String busLogIn(@PathParam("userlDocument") String userlDocument, @PathParam("userlPassword") String userlPassword) {
        UserlCRUD crud=new UserlCRUD();
        Userl userl=crud.userlLogIn(userlDocument,userlPassword);
        Gson json=new Gson();
        String result=json.toJson(userl);
        return result;
    }
    
    @GET
    @Path("/productRegister/{productCode}/{productName}/{productPrice}/{productQuantity}")
    @Produces(MediaType.APPLICATION_JSON)
    public String productRegister(@PathParam("productCode") String productCode,@PathParam("productName") String productName,@PathParam("productPrice") int productPrice,@PathParam("productQuantity") int productQuantity) {
        ProductCRUD crud=new ProductCRUD();
        boolean message=crud.productRegister(productCode, productName, productPrice, productQuantity);
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
    @Path("/productUpdate/{productCode}/{productName}/{productPrice}/{productQuantity}")
    @Produces(MediaType.APPLICATION_JSON)
    public String productUpdate(@PathParam("productCode") String productCode,@PathParam("productName") String productName,@PathParam("productPrice") int productPrice,@PathParam("productQuantity") int productQuantity) {
        ProductCRUD crud=new ProductCRUD();
        boolean message=crud.productUpdate(productCode, productName, productPrice, productQuantity);
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
    @Path("/productDelete/{productCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public String productDelete(@PathParam("productCode") String productCode) {
        ProductCRUD crud=new ProductCRUD();
        boolean message=crud.productDelete(productCode);
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
    @Path("/productShow/")
    @Produces(MediaType.APPLICATION_JSON)
    public String productShow() {
        ProductCRUD crud=new ProductCRUD();
        ArrayList<Product>products=crud.productShow();
        Gson json=new Gson();
        String result=json.toJson(products);
        return result;
    }
    
}
