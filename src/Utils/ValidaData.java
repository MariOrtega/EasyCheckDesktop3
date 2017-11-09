/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Maria
 */
public class ValidaData{

 
   
       public static  boolean  checkDay (int day, int month, int year){
    boolean  valid = false;
    if(day >=1){
        // For months with 30 days.
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30){
            valid = true;
        }
        // For months with 31 days.
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day <= 31){
            valid = true;
        }
        // For February.
        if (month == 2)
        {
            if(day <= 28){
                valid = true;
            } else if(day == 29){
                if ((year%4 == 0 && year%100!=0) || year%400 == 0){
                    valid = true;
                } //else invalid
            }
        }
    } //else date is not valid
    return valid;
}
  
   
}