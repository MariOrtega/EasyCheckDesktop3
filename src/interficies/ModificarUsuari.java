/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interficies;

import Renders.RenderTreballador;
import clases.Reserva;
import clases.Treballador;
import static interficies.GestioUsuaris.model;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;

/**
 *
 * @author Maria
 */
public class ModificarUsuari extends javax.swing.JFrame {
 DefaultListModel model;
 GestioUsuaris gestio;
 List <Treballador>treballadors;
 Treballador tr;
 Integer id_treballador;
    /**
     * Creates new form ModificarUsuari
     */
    public ModificarUsuari() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         this.getContentPane().setBackground(Color.ORANGE);
        treballadors= Treballador.getTreballadors();
       this.jList1.setCellRenderer(new RenderTreballador());
        model = new DefaultListModel(); 
           Llista_Treballadors();
        } 
   
         public void Llista_Treballadors() {
        
       Iterator it= treballadors.iterator();
         jList1.setModel(model);
         while(it.hasNext()){
         Treballador tr = (Treballador) it.next();
                model.addElement(tr);  
       
    }
         jList1.addListSelectionListener(new ListSelectionListener(){
           @Override
           public void valueChanged(ListSelectionEvent e) {
             int selection=jList1.getSelectedIndex();
             Treballador t= new Treballador();
             t= (Treballador) model.getElementAt(selection);
               System.out.println(t.getId());
             id_treballador = t.getId();
              nom.setText(t.getNom());
        cognom1.setText(t.getCognom1());
        cognom2.setText(t.getCognom2());
        dni.setText(t.getDni());
        login.setText(t.getLogin());
        password.setText(t.getPassword());
           }
         });
         }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nom = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        cognom2 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        cognom1 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        login = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        password = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        dni = new javax.swing.JTextPane();
        EsAdmin = new javax.swing.JCheckBox();
        btnModifica = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 51));

        nom.setText("jTextField1");

        jScrollPane1.setViewportView(jList1);

        jScrollPane2.setViewportView(cognom2);

        jScrollPane3.setViewportView(cognom1);

        jScrollPane4.setViewportView(login);

        jScrollPane5.setViewportView(password);

        jScrollPane6.setViewportView(dni);

        EsAdmin.setText("Admin");

        btnModifica.setText("Modificar");
        btnModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nom");

        jLabel2.setText("1è Cognom");

        jLabel3.setText("2n Cognom");

        jLabel4.setText("Login");

        jLabel5.setText("Password");

        jLabel6.setText("DNI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nom)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(EsAdmin)
                                .addGap(62, 62, 62)
                                .addComponent(btnModifica)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel4)
                .addGap(94, 94, 94)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(73, 73, 73))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModifica)
                            .addComponent(EsAdmin))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaActionPerformed
      
        String sNom = nom.getText();
        String sCognom = cognom1.getText();
        String sCognom2 = cognom2.getText();
        String sLogin = login.getText();
        String sPassword = password.getText();
        String sDni = dni.getText();
        
        ArrayList <Treballador> treb = Treballador.getTreballadors();
        Iterator it= treb.iterator();
        int contador = 1;
        System.out.println(id_treballador);
        while(it.hasNext()){
            Treballador t =(Treballador) it.next();
            System.out.println(t.getId());
            if (t.getId()==id_treballador){
                t.setId(id_treballador);
                t.setNom(sNom);
                t.setCognom1(sCognom);
                t.setCognom2(sCognom2);
                t.setLogin(sLogin);
                t.setPassword(sPassword);
                t.setDni(sDni);
                Treballador.getTreballadors().remove(t);
                Treballador.setTreballadors(t);
               
                GestioUsuaris.actualitzaLlista();
                //tr=new Treballador(sNom,sCognom,sCognom2,sLogin,sPassword,"1",sDni);
                //Treballador.getTreballadors().add(tr);
                break;
            }
            contador++;
        } 
         model.addElement(tr);
        //tr=new Treballador(sNom,sCognom,sCognom2,sLogin,sPassword,"1",sDni);
       // model.addElement(tr);
       // treballadors.add(tr);
        //Treballador.setTreballadors(tr);
        dispose();
    }//GEN-LAST:event_btnModificaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarUsuari().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox EsAdmin;
    private javax.swing.JButton btnModifica;
    private javax.swing.JTextPane cognom1;
    private javax.swing.JTextPane cognom2;
    private javax.swing.JTextPane dni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane login;
    private javax.swing.JTextField nom;
    private javax.swing.JTextPane password;
    // End of variables declaration//GEN-END:variables




}


