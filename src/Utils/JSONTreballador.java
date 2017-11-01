/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import clases.Treballador;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Maria
 */
public class JSONTreballador {

    /*

    public static String conversioJson(Treballador t) {
        String nom = t.getNom();
        String cognom1 = t.getCognom1();
        String cognom2 = t.getCognom2();
        String dni = t.getDni();
        String esAdmin = t.getEsAdmin();
        String password = t.getPassword();
        String login = t.getLogin();
        
        JSONObject jsonTreballador = new JSONObject();
        
        jsonTreballador.put("password", password);
        jsonTreballador.put("cognom1", cognom1);
        jsonTreballador.put("cognom2", cognom2);
        jsonTreballador.put("dni", dni);
        jsonTreballador.put("nom", nom);
        jsonTreballador.put("esAdmin", esAdmin);
        jsonTreballador.put("login", login);
       
        System.out.println(jsonTreballador.toJSONString());
        
        return jsonTreballador.toJSONString();
    }

    public static Treballador DesconversioJson(String str) {
        Treballador t = new Treballador();
        JSONObject obj = (JSONObject) JSONValue.parse(str);

        String nom = (String) obj.get("nom");
        String cognom1 = (String) obj.get("cognom1");
        String cognom2 = (String) obj.get("cognom2");
        String dni = (String) obj.get("dni");
        String login = (String) obj.get("login");
        String password = (String) obj.get("password");
        String esAdmin = (String) obj.get("esAdmin");

        t.setNom(nom);
        t.setCognom1(cognom1);
        t.setCognom2(cognom2);
        t.setDni(dni);
        t.setEsAdmin(esAdmin);
        t.setPassword(password);
        t.setLogin(login);
        return t;

    }

    public static void imprimirTreballador(Treballador t) {
        System.out.println("NOM: " + t.getNom());
        System.out.println("COGMON1: " + t.getCognom1());
        System.out.println("COGMON2: " + t.getCognom2());
        System.out.println("ADMIN: " + t.getEsAdmin());
        System.out.println("LOGIN: " + t.getLogin());
        System.out.println("PASS: " + t.getPassword());
        System.out.println("DNI: " + t.getDni());
    }
    */

   
}
