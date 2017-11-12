/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comprovacions;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Maria
 *
 * Classe creada per comprova la validesa d'una data
 */
public class ValidaData {

    /**
     * @author Maria
     *
     * Mètode per comprovar la correcta validesa d'una data.
     * @param day
     * @param month
     * @param year
     * @return boolean. Si la data és correcta i existeix retornarà true, en cas
     * contrari false.
     */
    public static boolean checkDay(int day, int month, int year) {
        boolean valid = false;
        if (day >= 1) {

            /**
             * Mesos de 30 dies
             */
            if ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30) {
                valid = true;

            }
            /**
             * Mesos de 31 dies
             */
            if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day <= 31) {
                valid = true;
            }
            /**
             * Mes i any de traspàs
             */
            if (month == 2) {
                if (day <= 28) {
                    valid = true;
                } else if (day == 29) {
                    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                        valid = true;
                    }
                }
            }
        }
        return valid;
    }
/**
 * @author Maria
 * Mètode que comprova si la data introduida per paràmetre es posterior a la data actual
 * 
 * @param dataSeleccionada. 
 * @return 
 */
    public static boolean comprovaData(String dataSeleccionada) {

        // boolean data = false;
        Calendar calendar = Calendar.getInstance();
        int year = (calendar.get(Calendar.YEAR));
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        String dataActual = (day + "/" + month + "/" + year);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataActual_parseada = sdf.parse(dataActual, new ParsePosition(0));
        Date dataSeleccionada_parseada = sdf.parse(dataSeleccionada, new ParsePosition(0));

        return dataActual_parseada.before(dataSeleccionada_parseada);
    }
/**
 * @author Maria
 * Mètode que comprova al formulari serveis si l'origen i el desti estan completament omplert.
 * En cas de falta de dades retornarà false
 * També comprova si s'està assignat un servei a l'Administrador. Aquest no està autoritzat a
 * l'assignació de serveis
 * @param o origen al formulari
 * @param d desti al formulari
 * @param t treballador a qui se li assigna el servei
 * @return boolea amb el resultat de la comprovació
 */
    public static boolean comprovaFormulari(String o, String d, int t) {

        if (o.equals("") || d.equals("")) {
            JOptionPane.showMessageDialog(null, "falten dades!!!");
            return false;
        } else if (t == 1) {
            JOptionPane.showMessageDialog(null, "Administrador no pot tindre serveis!!!");
            return false;
        } else {
            return true;
        }

    }

}
