/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Maria
 */
public class GestioServeisBD {
     //private static final String BASE_URL = "localhost";
         //private static final int PORT = 8080;
    private static final String BASE_URL = "easycheck.hopto.org";
         private static final int PORT = 8080;
         private Gson gson = new Gson();
    /**
     * @author Carlos Alberto Castro Cañabate 
     * @param id
     * @param nom
     * @param cognom1
     * @param cognom2
     * @param dni
     * @param login
     * @param password
     * @param esadmin
     * @return 
     */     
    public PostResponse actualitzarServei(int id, String descripcio, String dataservei, String horaInici, String horaFinal, int idTreballador) {
        PostResponse response;
        String query = buildQueryActualitzarServei(id, descripcio, dataservei, horaInici, horaFinal, idTreballador);
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/servei", null);
        String json = NetUtils.doPostRequest(url, query);
        response=gson.fromJson(json, PostResponse.class);
        return response;
    }   
    /**
     * @author Carlos Alberto Castro Cañabate
     * @param idServei
     * @return 
     */
    public PostResponse borrarServei(int idServei) {
        String query = buildQueryBorrarServei(idServei);
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/servei", null);
        String json = NetUtils.doPostRequest(url, query);
        PostResponse response=gson.fromJson(json, PostResponse.class);
        return response;
    }
         
     /**
      *  @author Maria Remedios Ortega
      * @param descripcio
      * @param dataservei
      * @param horaInici
      * @param horaFinal
      * @param idTreballador
      * @return 
      */    
     public PostResponse inserirServei(String descripcio, String dataservei, String horaInici, String horaFinal, int idTreballador) {
        String query = buildQueryInserirServei(descripcio, dataservei, horaInici, horaFinal, idTreballador);
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/servei", null);
        String json = NetUtils.doPostRequest(url, query);
        PostResponse response=gson.fromJson(json, PostResponse.class);
        return response;
    }
     
    /**
     * @author Carlos ALberto Castro Cañabate
     * @param id
     * @param descripcio
     * @param dataservei
     * @param horaInici
     * @param horaFinal
     * @param idTreballador
     * @return 
     */
    public String buildQueryActualitzarServei(int id, String descripcio, String dataservei, String horaInici, String horaFinal, int idTreballador) {
        return "id=" + id + "&descripcio=" + descripcio + "&dataservei=" + dataservei + "&horainici=" + horaInici + "&horafinal=" + horaFinal + "&idtreballador=" + idTreballador;
    }
    /**
     * @author Carlos Alberto Castro Cañabate
     * @param idServei
     * @return 
     */
    private String buildQueryBorrarServei(int idServei) {
        return "borrarid=" + idServei;
    }
    /**
     *  @author Maria Remedios Ortega
     * @param descripcio
     * @param dataservei
     * @param horaInici
     * @param horaFinal
     * @param idTreballador
     * @return 
     */
      public String buildQueryInserirServei(String descripcio, String dataservei, String horaInici, String horaFinal, int idTreballador) {
        return "descripcio=" + descripcio + "&dataservei=" + dataservei + "&horainici=" + horaInici + "&horafinal=" + horaFinal + "&idtreballador=" + idTreballador;
    }
}
