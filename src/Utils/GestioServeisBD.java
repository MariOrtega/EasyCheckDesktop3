/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import static Utils.GestionarUsuariBd.doPostRequest;
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

/**
 *
 * @author Maria
 */
public class GestioServeisBD {
     private static final String BASE_URL = "localhost";
         private static final int PORT = 8080;
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
    public String actualitzarServei(Integer id,String descripcio, String dataservei, String horaInici, String horaFinal, int idTreballador) {
        String response = "";
        String query = buildQueryActualitzarServei (id,descripcio, dataservei, horaInici, horaFinal, idTreballador);
        URL url = buildUrl(BASE_URL, PORT, "/easycheckapi/treballador", null);
        response = doPostRequest(url, query);
        if (!response.equals("0")) {
            System.out.println("Actualitzat servei" + descripcio + " amb id " + id);
        }
        return response;
    }    
         
         
     public String inserirServei(String descripcio, String dataservei, String horaInici, String horaFinal, int idTreballador) {
        String response = "";
        String query = buildQueryInserirServei(descripcio, dataservei, horaInici, horaFinal, idTreballador);
        URL url = buildUrl(BASE_URL, PORT, "/easycheckapi/servei", null);
        response = doPostRequest(url, query);
        if (!response.equals("0")) {
            System.out.println("Inserit servei " + descripcio);
        }
        return response;
    }
     
     

    public static String doPostRequest(URL url, String parameters) {
        byte[] postData = parameters.getBytes(StandardCharsets.UTF_8);
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", "" + Integer.toString(parameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(parameters);
            wr.flush();
            wr.close();

            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            System.out.println(response);
            return response.toString();

        } catch (IOException ex) {
            ex.printStackTrace();
            return "";
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
     public URL buildUrl(String host, int port, String path, String query) {
        try {
            return new URI("http", null, host, port, path, query, null).toURL();
        } catch (URISyntaxException ex) {
           
        } catch (MalformedURLException ex) {
          
        }
        return null;
    }/**
     * @author Carlos ALberto Castro Cañabate
     * @param id
     * @param descripcio
     * @param dataservei
     * @param horaInici
     * @param horaFinal
     * @param idTreballador
     * @return 
     */
    public String buildQueryActualitzarServei(int id,String descripcio, String dataservei, String horaInici, String horaFinal, int idTreballador) {
        return "id=" + id + "descripcio=" + descripcio + "&dataservei=" + dataservei + "&horainici=" + horaInici + "&horafinal=" + horaFinal + "&idtreballador=" + idTreballador;
    }
      public String buildQueryInserirServei(String descripcio, String dataservei, String horaInici, String horaFinal, int idTreballador) {
        return "descripcio=" + descripcio + "&dataservei=" + dataservei + "&horainici=" + horaInici + "&horafinal=" + horaFinal + "&idtreballador=" + idTreballador;
    }
}
