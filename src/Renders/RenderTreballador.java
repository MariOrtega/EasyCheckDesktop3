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
 * 
 * Classe creada per formatar la sortida a la interficie de gestor usuaris
 */
public class RenderTreballador extends JLabel implements ListCellRenderer {

   
/**
 *  @author Maria Remedios Ortega
 */
    public RenderTreballador() {
        setOpaque(true);
    }
/**
 *  @author Maria Remedios Ortega
 * @param list
 * @param value
 * @param index
 * @param isSelected
 * @param cellHasFocus
 * @return 
 * 
 * Mètode pel qual els objectes que conté el jList quedaran formatat i en seleccionar
 * un d'ell canviara de color a vermell
 */
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        String v = value.toString();

        if (isSelected) {
            setText(v);

            setForeground(Color.RED);

        } else {
            setText(v);
            setForeground(Color.BLACK);
        }

        return this;
    }

}
