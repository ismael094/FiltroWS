/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import client.Libros;
import client.Main;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author entrar
 */
@Path("filtro")
public class Filtro {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Filtro
     */
    public Filtro() {
    }

    /**
     * Retrieves representation of an instance of server.Filtro
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{key}, {nombre}, {page}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("key") String key, @PathParam("nombre") String nombre, @PathParam("page") int page) {
        try {
            List<Libros> tmp = Main.main(key,nombre.replace(' ', '+'),page);
            Gson g = new Gson();
            String res = "{\"num\" : " + Main.num+ ", \"books\" : [";
            if (tmp.size() > 0) {
                for (Libros book :  tmp) {
                    res+=g.toJson(book)+",";
                } 
            } else {
                return res+"]}";
            }
            
            res = res.substring(0, res.length()-1)+"]}";
            return res;
        } catch (Exception ex) {
            Logger.getLogger(Filtro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "{\"num\" : 0, \"books\" : []}";
    }
    
    @GET
    @Path("Novedades")
    @Produces(MediaType.APPLICATION_JSON)
    public String getNovedades() {
        
        return "{jj}";
    }

    /**
     * PUT method for updating or creating an instance of Filtro
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
