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
     */
    public static void carregaTreballador(Choice choice,ArrayList<Treballador> treb) {
        for (int i = 0; i < treb.size(); i++) {
            Treballador t = treb.get(i);
            choice.add(t.getNom() + " " + t.getCognom1() + " " + t.getCognom2());
        }

    }
    /**
     * @author Maria Remedios Ortega
     */
    public static  void carregaAny(Choice choice) {
        Calendar calendar = Calendar.getInstance();
        int year = (calendar.get(Calendar.YEAR));
        for (int i = year; i < 2101; i++) {
            choice.add(String.valueOf(i));
        }
    }

}
