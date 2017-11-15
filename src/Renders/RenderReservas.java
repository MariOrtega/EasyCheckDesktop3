/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Renders;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
/**
 *
 * @author Carlos Alberto Castro Cañabate
 * Classe creada per formatar la sortida a la interficie de llistaReserves
 */
public class RenderReservas extends JLabel implements ListCellRenderer {
    static ImageIcon logoCheck = new ImageIcon("check.png");
    static ImageIcon logoNoCheck = new ImageIcon("noCheck.png");
    /**
     * @param jlist 
     * @param e 
     * @param i
     * @param isSelected
     * @param cellHasFocus
     * @return 
     */
    @Override
    public Component getListCellRendererComponent(JList jlist, Object e, int i,
            boolean isSelected, boolean cellHasFocus) {
        
        JLabel renderer = (JLabel) e;
        String valor = e.toString();
        if (valor.contains("No Realitzat")){
            renderer.setIcon(logoNoCheck);
        } else {
            renderer.setIcon(logoCheck);
        }
        if (isSelected){
            renderer.setBackground(jlist.getSelectionBackground());
            renderer.setForeground(Color.BLUE);
        } else {
            renderer.setBackground(jlist.getBackground());
            renderer.setForeground(jlist.getForeground());
        }
        renderer.setOpaque(true);
        return renderer;
    }
    
}
