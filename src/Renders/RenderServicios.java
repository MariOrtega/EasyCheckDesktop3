/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Renders;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Carlos Alberto Castro Cañabate
 */
public class RenderServicios extends JLabel implements ListCellRenderer {
    ImageIcon admin = new ImageIcon(getClass().getResource("/Images/admin.png"));
    ImageIcon noAdmin= new ImageIcon(getClass().getResource("/Images/treb.png"));
    @Override
    public Component getListCellRendererComponent(JList jlist, Object e, int i,
            boolean isSelected, boolean cellHasFocus) {
        
        JLabel renderer = (JLabel) e;
        String valor = e.toString();
        if (valor.contains("Administrador")){
            renderer.setIcon(admin);
        } else {
            renderer.setIcon(noAdmin);
        }
        setText(valor);
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