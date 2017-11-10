/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Carlos Alberto Castro Cañabate
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import clases.Servei;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DescargaServei {
    
    private static final String BASE_URL = "localhost";
    private static final int PORT = 8080;
    public static ArrayList<Servei> serveis;
    public static void main(String[] args) {
        DescargaServei test = new DescargaServei();
    }
    
    public DescargaServei(){
        serveis = (ArrayList<Servei>) obtenirServeisDelServer();
    }
    
    
    public URL buildUrl(String host, int port, String path, String query) {
        try {
            return new URI("http", null, host, port, path, query, null).toURL();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DescargaServei.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(DescargaServei.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Servei> obtenirServeisDelServer() {
        String json = "";
        URL url = buildUrl(BASE_URL, PORT, "/easycheckapi/servei", null);
        json = NetUtils.doGetRequest(url);
        Gson gson = new Gson();
        java.lang.reflect.Type tipusLlistaDeServeis = new TypeToken<List<Servei>>() {
        }.getType();
        ArrayList<Servei> llistaDeServeis = gson.fromJson(json, tipusLlistaDeServeis);

        return llistaDeServeis;
    }
}

