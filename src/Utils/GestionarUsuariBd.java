/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import com.google.gson.Gson;
import java.net.URL;

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
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/treballador", null);
        response = NetUtils.doPostRequest(url, query);
        if (!response.equals("0")) {
            System.out.println("Inserit treballador " + nom);
        }
        return response;
    }

    public String actualitzarTreballador(int id, String nom, String cognom1, String cognom2, String dni, String login, String password, int esadmin) {
        String response = "";
        String query = buildQueryActualitzarTreballador(id, nom, cognom1, cognom2, dni, login, password, esadmin);
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/treballador", null);
        response = NetUtils.doPostRequest(url, query);
        if (!response.equals("0")) {
            System.out.println("Actualitzat treballador " + nom + " amb id " + id);
        }
        return response;
    }
 public String borrarTreballador(String idTreballador) {
        String response = "";
        String query = buildQueryBorrarTreballador(idTreballador);
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/treballador", null);
        response = NetUtils.doPostRequest(url, query);
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
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/login", null);
        String json = NetUtils.doPostRequest(url, query);        
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