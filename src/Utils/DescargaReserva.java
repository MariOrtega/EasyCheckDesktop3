/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 * @author Carlos Alberto Castro Cañabate
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import clases.Reserva;
import clases.Servei;
import clases.Treballador;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
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

public class DescargaReserva {
    
    private static final String BASE_URL = "localhost";
    private static final int PORT = 8080;
    private static Gson gson = new Gson();
    /**
     * @author Carlos Alberto Castro Cañabate
     * @return 
     */
    public static List<Reserva> obtenirReservesDelServer() {
        String json = "";
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/reserva", null);
        json = NetUtils.doGetRequest(url);
        java.lang.reflect.Type tipusLlistaDeReserves = new TypeToken<List<Reserva>>() {}.getType();
        ArrayList<Reserva> llistaDeReserves = gson.fromJson(json, tipusLlistaDeReserves);
        return llistaDeReserves;
    }
    /**
     * @author Carlos Alberto Castro Cañabate
     * @param servei
     * @return 
     */
    public static ArrayList<Reserva> getReservesServei(int servei){
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/reserva", "servei="+servei);
        String json = NetUtils.doGetRequest(url);
        final Type tipusLlista = new TypeToken<List<Reserva>>(){}.getType();
        ArrayList<Reserva> llista = gson.fromJson(json, tipusLlista);
        return llista;
    }
}

