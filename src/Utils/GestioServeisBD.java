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
public class GestioServeisBD {
    private static final String BASE_URL = "localhost";

    //private static final String BASE_URL = "easycheck.hopto.org";
    private static final int PORT = 8080;
    private Gson gson = new Gson();

    /**
     * @author Carlos Alberto Castro Cañabate
     * 
     * Mètode pel qual s'envia una peticio post i el servidor conecta amb la base de dades 
     * enviant el query respectiu. El servidor retornarà PostResponse amb un codi(0 o 1) i missatge
     * amb el resultat de l'operació efectuada.
     * @param id del servei
     * @param descripcio del servei
     * @param dataservei del servei
     * @param horaInici del servei
     * @param horaFinal del servei
     * @param idTreballador del servei
     * @return PostResponse amb un codi(0 o 1) i missatge amb el resultat de l'operació efectuada.
     */
    public PostResponse actualitzarServei(int id, String descripcio, String dataservei, String horaInici, String horaFinal, int idTreballador) {
        PostResponse response;
        String query = buildQueryActualitzarServei(id, descripcio, dataservei, horaInici, horaFinal, idTreballador);
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/servei", null);
        String json = NetUtils.doPostRequest(url, query);
        response = gson.fromJson(json, PostResponse.class);
        return response;
    }

    /**
     * @author Carlos Alberto Castro Cañabate
     * Mètode pel qual s'envia una peticio post i el servidor conecta amb la base de dades 
     * enviant el query respectiu. El servidor retornarà PostResponse amb un codi(0 o 1) i missatge
     * amb el resultat de l'operació efectuada.
     * @param idServei servei a eliminar
     * @return PostResponse amb un codi(0 o 1) i missatge amb el resultat de l'operació efectuada.
     */
    public PostResponse borrarServei(int idServei) {
        String query = buildQueryBorrarServei(idServei);
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/servei", null);
        String json = NetUtils.doPostRequest(url, query);
        PostResponse response = gson.fromJson(json, PostResponse.class);
        return response;
    }

    /**
     * @author Maria Remedios Ortega
     *
     * Mètode per inserir un servei a la base de dades fent una crida post al
     * server. S'enviaran les dades al server i aquest l'inserirà al server. Si
     * hi ha cap problema el server s'encarrega de retornar un PostResponse amb
     * un codi( 0 o 1) i missatge corresponent.
     * @param descripcio
     * @param dataservei
     * @param horaInici
     * @param horaFinal
     * @param idTreballador
     * @return response 
     */
    public PostResponse inserirServei(String descripcio, String dataservei, String horaInici, String horaFinal, int idTreballador) {
        String query = buildQueryInserirServei(descripcio, dataservei, horaInici, horaFinal, idTreballador);
        URL url = NetUtils.buildUrl(BASE_URL, PORT, "/easycheckapi/servei", null);
        String json = NetUtils.doPostRequest(url, query);
        PostResponse response = gson.fromJson(json, PostResponse.class);
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
     * @author Maria Remedios Ortega
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
