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

//    private static final String BASE_URL = "easycheck.hopto.org";
    private static final int PORT = 8080;
    private Gson gson = new Gson();
    
    
    /**
     * @author Carlos Alberto Castro Cañabate
     * 
     * Mètode per inserir un servei a la base de dades fent una crida post al
     * server. S'enviaran les dades al server i aquest l'inserirà al server. Si
     * hi ha cap problema el server s'encarrega de retornar un PostResponse amb
     * un codi( 0 o 1) i missatge corresponent.
     * @param login  usuari
     * @param password usuari
     * @return PostResponse amb un codi( 0 o 1) i missatge corresponent.
     */
    public PostResponse loginTreballador(String login, String password) {
        String query = buildQueryLogin(login, password);
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/login", null);
        String json = NetUtils.doPostRequest(url, query);
        PostResponse response = gson.fromJson(json, PostResponse.class);
        return response;
    }

    /**
     * @author Carlos Alberto Castro Cañabate
     * @param user
     * @param password
     * @return
     */
    public String buildQueryLogin(String user, String password) {
        return "user=" + user + "&pass=" + password;
    }

    /**
     * @author Maria Remedios Ortega
     * 
     * Mètode pel qual s'envia una peticio post i el servidor conecta amb la base de dades 
     * enviant el query respectiu. El servidor retornarà PostResponse amb un codi(0 o 1) i missatge
     * amb el resultat de l'operació efectuada.
     * 
     * @param nom
     * @param cognom1
     * @param cognom2
     * @param dni
     * @param login
     * @param password
     * @param esadmin
     * @return response
     */
    public PostResponse inserirTreballador(String nom, String cognom1, String cognom2, String dni, String login, String password, int esadmin) {
        PostResponse response;
        String query = buildQueryInserirTreballador(nom, cognom1, cognom2, dni, login, password, esadmin);
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/treballador", null);
        String json = NetUtils.doPostRequest(url, query);
        response = gson.fromJson(json, PostResponse.class);

        return response;
    }

    /**
     * 
     * Mètode pel qual s'envia una peticio post i el servidor conecta amb la base de dades 
     * enviant el query respectiu. El servidor retornarà PostResponse amb un codi(0 o 1) i missatge
     * amb el resultat de l'operació efectuada.
     * 
     * @author Maria Remedios Ortega
     * @param id
     * @param nom
     * @param cognom1
     * @param cognom2
     * @param dni
     * @param login
     * @param password
     * @param esadmin
     * @return response
     */
    public PostResponse actualitzarTreballador(int id, String nom, String cognom1, String cognom2, String dni, String login, String password, int esadmin) {
        PostResponse response;
        String query = buildQueryActualitzarTreballador(id, nom, cognom1, cognom2, dni, login, password, esadmin);
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/treballador", null);
        String json = NetUtils.doPostRequest(url, query);
        response = gson.fromJson(json, PostResponse.class);

        return response;
    }

    /**
     * @author Maria Remedios Ortega
     * 
     * Mètode pel qual s'envia una peticio post i el servidor conecta amb la base de dades 
     * enviant el query respectiu. El servidor retornarà PostResponse amb un codi(0 o 1) i missatge
     * amb el resultat de l'operació efectuada.
     * 
     * @param idTreballador
     * @return response
     */
    public PostResponse borrarTreballador(String idTreballador) {
        PostResponse response;
        String query = buildQueryBorrarTreballador(idTreballador);
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/treballador", null);
        String json = NetUtils.doPostRequest(url, query);
        response = gson.fromJson(json, PostResponse.class);

        return response;

    }


    /**
     * @author Maria Remedios Ortega
     * @param nom
     * @param cognom1
     * @param cognom2
     * @param dni
     * @param login
     * @param password
     * @param esadmin
     * @return
     */
    public String buildQueryInserirTreballador(String nom, String cognom1, String cognom2, String dni, String login, String password, int esadmin) {
        return "nom=" + nom + "&cognom1=" + cognom1 + "&cognom2=" + cognom2 + "&dni=" + dni + "&esadmin=" + esadmin + "&login=" + login + "&password=" + password;
    }

    /**
     * @author Maria Remedios Ortega
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
    public String buildQueryActualitzarTreballador(int id, String nom, String cognom1, String cognom2, String dni, String login, String password, int esadmin) {
        return "id=" + id + "&nom=" + nom + "&cognom1=" + cognom1 + "&cognom2=" + cognom2 + "&dni=" + dni + "&esadmin=" + esadmin + "&login=" + login + "&password=" + password;
    }

    /**
     * @author Maria Remedios Ortega
     * @param idTreballador
     * @return
     */
    private String buildQueryBorrarTreballador(String idTreballador) {
        return "borrarid=" + idTreballador;
    }
}
