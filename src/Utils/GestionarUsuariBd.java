/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import Utils.PostResponse;
import static Utils.NetUtils.doPostRequest;
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
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maria
 */
public class GestionarUsuariBd {
      private static final String BASE_URL = "localhost";
         private static final int PORT = 8080;
         private Gson gson = new Gson();
    
    
   

    public String inserirTreballador(String nom, String cognom1, String cognom2, String dni, String login, String password, int esadmin) {
        String response = "";
        String query = buildQueryInserirTreballador(nom, cognom1, cognom2, dni, login, password, esadmin);
        URL url = buildUrl(BASE_URL, PORT, "/easycheckapi/treballador", null);
        response = doPostRequest(url, query);
        if (!response.equals("0")) {
            System.out.println("Inserit treballador " + nom);
        }
        return response;
    }

    public String actualitzarTreballador(int id, String nom, String cognom1, String cognom2, String dni, String login, String password, int esadmin) {
        String response = "";
        String query = buildQueryActualitzarTreballador(id, nom, cognom1, cognom2, dni, login, password, esadmin);
        URL url = buildUrl(BASE_URL, PORT, "/easycheckapi/treballador", null);
        response = doPostRequest(url, query);
        if (!response.equals("0")) {
            System.out.println("Actualitzat treballador " + nom + " amb id " + id);
        }
        return response;
    }
 public String borrarTreballador(String idTreballador) {
        String response = "";
        String query = buildQueryBorrarTreballador(idTreballador);
        URL url = buildUrl(BASE_URL, PORT, "/easycheckapi/treballador", null);
        response = doPostRequest(url, query);
        if (response.charAt(0)!=('0')) {
            System.out.println("Esborrat treballador " + idTreballador);
        } else {
            System.out.println("No s'ha pogut esborrar el treballador");
        }
        return response;
    
    }
 /**
  * @author Carlos Alberto Castro Cañabate
  * @param login
  * @param password
  * @return 
  */
    public String loginTreballador (String login, String password) {
        String resposta;
        String query = buildQueryLogin(login,password);
        URL url = buildUrl(BASE_URL, PORT, "/easycheckapi/login", null);
        String json = doPostRequest(url, query);        
        PostResponse response = gson.fromJson(json, PostResponse.class);
        resposta = Integer.toString(response.getRequestCode())+": "+response.getMessage();
        return resposta;

    }
    /**
     * @author Carlos Alberto Castro Cañabate
     * @param login
     * @param password
     * @return 
     */
    public String buildQueryLogin(String user, String password) {
        return "user=" + user + "&pass=" + password;
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
    }

  
    public String buildQueryInserirTreballador(String nom, String cognom1, String cognom2, String dni, String login, String password, int esadmin) {
        return "nom=" + nom + "&cognom1=" + cognom1 + "&cognom2=" + cognom2 + "&dni=" + dni + "&esadmin=" + esadmin + "&login=" + login + "&password=" + password;
    }

    public String buildQueryActualitzarTreballador(int id, String nom, String cognom1, String cognom2, String dni, String login, String password, int esadmin) {
        return "id=" + id + "&nom=" + nom + "&cognom1=" + cognom1 + "&cognom2=" + cognom2 + "&dni=" + dni + "&esadmin=" + esadmin + "&login=" + login + "&password=" + password;
    }
    private String buildQueryBorrarTreballador(String idTreballador) {
        return "borrarid=" + idTreballador;
    }
}