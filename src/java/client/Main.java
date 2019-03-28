/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author entrar
 */
public class Main  {
    public static List<Book> main(String key,String name, int page) throws IOException {
        String URL = "http://openlibrary.org/search.json?"+key+"="+name+"&limit=15";
        if (page > 0) 
            URL+="&page="+page;
        
        URL url = new URL(URL);
        URLConnection conn = url.openConnection(); //conexión HTTP
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String res = "";
        String line;
        while ((line = rd.readLine()) != null) {
                res += line;
            }
        rd.close();
        JSONObject obj = new JSONObject(res);
        JSONArray rest = obj.getJSONArray("docs");
        List<Book> list = new ArrayList();
        
        int len = rest.length();
        if (len > 10)
            len = 10;
        
        for (int i = 0;i<len;i++) {
            JSONObject book = rest.getJSONObject(i);
            if (book == null || book.equals(""))
                continue;
            Book tmp = new Book();
            if (book.has("author_name"))
                tmp.setAuthor_name(book.getJSONArray("author_name").getString(0));
            if (book.has("title"))
                tmp.setTitle(book.getString("title"));
            if (book.has("publish_year")){
                tmp.setPublish_year(Integer.parseInt(book.getJSONArray("publish_year").optString(0)));
            }
                
                
            if (book.has("subject"))
                tmp.setSubject(book.getJSONArray("subject").getString(0));
            if (book.has("publisher"))
                tmp.setPublisher(book.getJSONArray("publisher").getString(0));
            if (book.has("oclc"))
                tmp.setOclc(book.getJSONArray("oclc").getString(0));
            if (book.has("isbn")) {
                tmp.setIsbn(book.getJSONArray("isbn").getString(0));
            } else {
                len++;
                continue;
            }
            list.add(tmp);
        }
        
        
        return list;
        
        
    }
}
