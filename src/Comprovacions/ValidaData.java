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
 */
public class ValidaData{


   
       public  static boolean  checkDay (int day, int month, int year){
    boolean  valid = false;
    if(day >=1){
        
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30){
            valid = true;
            
        }
        
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day <= 31){
            valid = true;
        }
       
        if (month == 2)
        {
            if(day <= 28){
                valid = true;
            } else if(day == 29){
                if ((year%4 == 0 && year%100!=0) || year%400 == 0){
                    valid = true;
                } 
            }
        }
    } 
    return valid;
}
       
        public static boolean comprovaData(String dataSeleccionada) {
      
       // boolean data = false;
        Calendar calendar = Calendar.getInstance();
        int year = (calendar.get(Calendar.YEAR));
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        System.out.println(day);
        String dataActual = (day + "/" + month + "/" + year);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataActual_parseada = sdf.parse(dataActual, new ParsePosition(0));
        Date dataSeleccionada_parseada = sdf.parse(dataSeleccionada, new ParsePosition(0));

       

        return dataActual_parseada.before(dataSeleccionada_parseada);
    }
   public static  boolean comprovaFormulari(String o, String d,int t) {

        if (o.equals("") || d.equals("")) {
            JOptionPane.showMessageDialog(null, "falten dades!!!");
            return false;
        } else if (t==1) {
            JOptionPane.showMessageDialog(null, "Administrador no pot tindre serveis!!!");
            return false;
        } else {
            return true;
        }

    }
   
}