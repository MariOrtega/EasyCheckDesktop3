/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Renders;

import clases.Treballador;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

/**
 *
 * @author Maria
 */
public class RenderTreballador extends JLabel implements ListCellRenderer{
    Treballador t;
public RenderTreballador(){
   setOpaque(true);
}
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
     String v=  value.toString();
    
     if(isSelected){
         setText(v);

          setForeground(Color.RED);
        
     }else{    
          setText(v);
          setForeground(Color.BLACK);
     }
        
        return this;
    }
    
}
