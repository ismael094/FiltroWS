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
    String coverUrl = "";
    String subject = "";
    int publish_year = 0;
    String isbn = "";
    String publisher = "";

    public String getSubject() {
        return subject;
    }

    public int getPublish_year() {
        return publish_year;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }
    
    

    public String getTitle() {
        return title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getOclc() {
        return oclc;
    }
    
    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setPublish_year(int publish_year) {
        this.publish_year = publish_year;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
        this.coverUrl = "http://covers.openlibrary.org/b/isbn/"+isbn+"-L.jpg";
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public void setOclc(String oclc) {
        this.oclc = oclc;
    }
}
