/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import clases.Client;
import clases.Reserva;
import clases.Servei;
import clases.Treballador;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Carlos
 */
public class IntroduccioObjectes {
    public IntroduccioObjectes(){
        añadirObjetosAClases();
    }
    public void añadirObjetosAClases(){
        Client.getClients().clear();
        Treballador.getTreballadors().clear();
        Servei.getLlistaServeis().clear();
        Reserva.getReservas().clear();
        DescargaClient totsClients = new DescargaClient();
        
        DescargaReserva totsReserves = new DescargaReserva();
        ArrayList<Reserva> reserves = (ArrayList<Reserva>) totsReserves.obtenirReservesDelServer();
        Iterator itR = reserves.iterator();
        while (itR.hasNext()){
            Reserva r = (Reserva) itR.next();
            ArrayList<Client> clients = (ArrayList<Client>) totsClients.obtenirClientsDelServer();
            Iterator itC = clients.iterator();
            while (itC.hasNext()){
                Client c = (Client) itC.next();
                if (r.getClient().getDni_titular()==c.getDni_titular()){
                    Client.setClients(c);
                    r.setClient(c);
                }
                Client.setClients(c);
            }          
            Reserva.setReservas(r);
        } 
        
        DescargaServei totsServeis= new DescargaServei();
        DescargaTreballador todo = new DescargaTreballador();
        ArrayList<Treballador> treballadors = (ArrayList<Treballador>) todo.obtenirTreballadorsDelServer();
        Iterator it = treballadors.iterator();
        while(it.hasNext()){
            Treballador t = (Treballador) it.next();
            Treballador.setTreballadors(t);
            
            ArrayList<Servei> serveis = (ArrayList<Servei>) totsServeis.obtenirServeisDelServer();
            Iterator itS = serveis.iterator();
            while (itS.hasNext()){
                Servei s = (Servei) itS.next();
                if (t.getId()==s.getId_treballador()){
                    Servei.setLlistaServeis(s);
                }
            }
        }
    }
}
