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
import clases.Client;
import clases.Reserva;
import clases.Servei;
import clases.Treballador;
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

public class DescargaClient {
    
    private static final String BASE_URL = "localhost";
    private static final int PORT = 8080;
    public static ArrayList<Client> clients;
    public static void main(String[] args) {
        DescargaClient test = new DescargaClient();
    }
    
    public DescargaClient(){
        clients = (ArrayList<Client>) obtenirClientsDelServer();
    }
    
    
    public String doGetRequest(URL url) {
        String responseBody = "";
        try {
            URLConnection connection = url.openConnection();
            InputStream response = connection.getInputStream();
            Scanner scanner = new Scanner(response);
            responseBody = scanner.useDelimiter("\\A").next();
        } catch (IOException ex) {
          //  Logger.getLogger(TestClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return responseBody;
    }
    
    public URL buildUrl(String host, int port, String path, String query) {
        try {
            return new URI("http", null, host, port, path, query, null).toURL();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DescargaClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(DescargaClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Client> obtenirClientsDelServer() {
        String json = "";
        URL url = buildUrl(BASE_URL, PORT, "/easycheckapi/client", null);
        json = doGetRequest(url);
        Gson gson = new Gson();
        java.lang.reflect.Type tipusLlistaDeClients = new TypeToken<List<Client>>() {
        }.getType();
        ArrayList<Client> llistaDeClients = gson.fromJson(json, tipusLlistaDeClients);

        return llistaDeClients;
    }
}

