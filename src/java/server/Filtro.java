/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import client.Book;
import client.Main;
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
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        try {
            List<Book> tmp = Main.main();
            String res = "{ \"books\" : [";
            for (Book book : tmp) {
                res+="{ \"title\" : \""+book.getTitle()+"\","
                    + "\"author_name\" : \""+book.getAuthor_name()+"\","
                    + "\"oclc\" : \""+book.getOclc()+"\","
                    + "\"cover\" : \""+book.getCoverUrl()+"\""
                    + "},";
            }
            res = res.substring(0, res.length()-1)+"]";
            return res;
        } catch (Exception ex) {
            Logger.getLogger(Filtro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "{}";
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
