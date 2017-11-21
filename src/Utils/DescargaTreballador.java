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
import clases.Treballador;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DescargaTreballador {

    private static final String BASE_URL = "localhost";
//    private static final String BASE_URL = "easycheck.hopto.org";
    private static final int PORT = 8080;
    public static ArrayList<Treballador> treballadors;
    /**
     * Mètode principal
     * @param args 
     */
    public static void main(String[] args) {
        DescargaTreballador test = new DescargaTreballador();
    }
    /**
     * Constructor
     */
    public DescargaTreballador() {
        treballadors = (ArrayList<Treballador>) obtenirTreballadorsDelServer();
    }
    /**
     * Mètode per obtenir els treballadors del server.
     * @return  llista de traballadors.
     */
    public List<Treballador> obtenirTreballadorsDelServer() {
        String json = "";
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/treballador", null);
        json = NetUtils.doGetRequest(url);
        Gson gson = new Gson();
        java.lang.reflect.Type tipusLlistaDeTreballadors = new TypeToken<List<Treballador>>() {
        }.getType();
        ArrayList<Treballador> llistaDeTreballadors = gson.fromJson(json, tipusLlistaDeTreballadors);

        return llistaDeTreballadors;
    }
}
