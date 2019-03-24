/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author entrar
 */
public class Book {
    String title = "";
    String author_name = "";
    String oclc = "";
    String author_key = "";
    String coverUrl = "";
    String subject = "";

    public String getTitle() {
        return title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getOclc() {
        return oclc;
    }

    public String getAuthor_key() {
        return author_key;
    }
    
    public String getCoverUrl() {
        return coverUrl;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public void setOclc(String oclc) {
        this.oclc = oclc;
        this.coverUrl = "http://covers.openlibrary.org/b/oclc/"+oclc+"-L.jpg";
    }

    public void setAuthor_key(String author_key) {
        this.author_key = author_key;
    }
}
