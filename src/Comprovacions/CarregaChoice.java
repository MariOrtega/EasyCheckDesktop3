/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comprovacions;

import clases.Treballador;
import java.awt.Choice;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Maria
 */
public class CarregaChoice {
  
    /**
     * @author Maria Remedios Ortega
     * 
     * Mètode genèric per carregar un choice amb paràmetres. 
     * Es farà servir per dia, mes, hores i minuts.
     * 
     * @param choice
     * @param x : integer fins a la numeració a incorporar al choice
     * @param h : integer a començar a incorporar al choice
     * 
     * 
     */
    public static void carrega(Choice choice, int x,int h) {
        if (x != 25) {
            for (int i = h; i < x; i++) {
                if (i < 10) {
                    choice.add("0" + String.valueOf(i));
                } else {
                    choice.add(String.valueOf(i));
                }
            }
        } else {
            for (int i = 0; i < x; i++) {
                if (i < 10) {
                    choice.add("0" + String.valueOf(i));
                } else {
                    choice.add(String.valueOf(i));
                }
            }
        }
    }
    /**
     * @author Maria Remedios Ortega
     * 
     * Mètode per omplir un choice amb un arraylist passat per paràmetre
     * @param choice
     * @param treb. Arraylist amb tots el treballadors a incorporar al choice
     */
    public static void carregaTreballador(Choice choice,ArrayList<Treballador> treb) {
        for (int i = 0; i < treb.size(); i++) {
            Treballador t = treb.get(i);
            choice.add(t.getNom() + " " + t.getCognom1() + " " + t.getCognom2());
        }

    }
    /**
     * @author Maria Remedios Ortega
     * 
     * Mètode per carregar un choice amb un seguit d'anys.
     * Començarà a comptar des de l'any en curs. Els anteriors s'ignoren
     * 
     * @param choice
     */
    public static  void carregaAny(Choice choice) {
        Calendar calendar = Calendar.getInstance();
        int year = (calendar.get(Calendar.YEAR));
        for (int i = year; i < 2101; i++) {
            choice.add(String.valueOf(i));
        }
    }

}
