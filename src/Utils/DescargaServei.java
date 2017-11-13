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
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DescargaServei {

//    private static final String BASE_URL = "localhost";
    private static final String BASE_URL = "easycheck.hopto.org";
    private static final int PORT = 8080;
    public static ArrayList<Servei> serveis;
    private static Gson gson = new Gson();

    /**
     * @author Carlos Alberto Castro Cañabate
     * @return
     */
    public static List<Servei> obtenirServeisDelServer() {
        String json = "";
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/servei", null);
        json = NetUtils.doGetRequest(url);

        java.lang.reflect.Type tipusLlistaDeServeis = new TypeToken<List<Servei>>() {
        }.getType();
        ArrayList<Servei> llistaDeServeis = gson.fromJson(json, tipusLlistaDeServeis);

        return llistaDeServeis;
    }

    /**
     * @author Carlos Alberto Castro Cañabate
     * @return
     */
    public static ArrayList<Servei> getServeisTreballador(int treballador) {
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/servei", "treballador=" + treballador);
        System.out.println(url);
        String json = NetUtils.doGetRequest(url);
        final Type tipusLlista = new TypeToken<List<Servei>>() {
        }.getType();
        ArrayList<Servei> llista = gson.fromJson(json, tipusLlista);
        return llista;
    }
}
