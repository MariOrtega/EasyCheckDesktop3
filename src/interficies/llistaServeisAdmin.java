/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interficies;
import Renders.RenderServicios;
import java.awt.event.ItemEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import javax.swing.event.ListSelectionListener;
import clases.Treballador;
import clases.Reserva;
import clases.Servei;
import java.awt.Color;
import java.util.List;
import Utils.DescargaTreballador;


/**
 *
 * @author Carlos
 */
public class llistaServeisAdmin extends javax.swing.JFrame {
    HashMap<String, String> serviciosMap = new HashMap<String, String>();
    ArrayList <String> serviciosList = new ArrayList();
    DefaultListModel modeloLista;
    Integer[] idServei = new Integer [1000];
    Integer treballadors = 0;
    static Integer userID;
    
    /**
     * Creates new form NewJFrame
     */
    public llistaServeisAdmin(Integer userID) {
        this.userID = userID;
        initComponents();
        
        modeloLista = new DefaultListModel();
        jlista.setModel(modeloLista);
        jlista.setCellRenderer(new RenderServicios());
        jlista.setSelectionBackground(Color.ORANGE);
        jlista.addListSelectionListener(new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
                    JList list =(JList)arg0.getSource();
                    if (list.isSelectionEmpty() || list.getValueIsAdjusting()) {
                         return;
                    }
                    int seleccionat = list.getSelectedIndex();
                    System.out.println(seleccionat);
                    if (reservesServei(idServei[seleccionat])){
                        llistaReserves llistaReserves = new llistaReserves(idServei[seleccionat]);
                        llistaReserves.setVisible(true);
                        setLocationRelativeTo(null);
                    } else JOptionPane.showMessageDialog(null,"El servei seleccionat no te reserves!");
		}	
	});
        choiceTrabajador.addItemListener(new java.awt.event.ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie) {     
                String nomTreballador = (String) ie.getItem();
                System.out.println(nomTreballador); 
                // METODO POR SI NO COINCIDE EL ID_TRABAJADOR CON EL ORDEN QUE MUESTRA EN EL CHOICE TRABAJADOR
                Integer treballadorSeleccionat = obtenirTreballador(nomTreballador);
                System.out.println(treballadorSeleccionat);
                if (choiceTrabajador.getSelectedIndex()!=0){
                    llistaTreballador(treballadorSeleccionat);
                } else {
                    llistaTots(); 
                }
            }
        });
        if (esADmin()){
            emplenarChoice();
            llistaTots();
            labelPrincipal.setText("Consulta serveis usuari administrador:");
        }
        else {
            choiceTrabajador.setVisible(false);
            labelChoice.setVisible(false);
          //  labelChoice.setText("");
            llistaTreballador(userID);
            labelPrincipal.setText("Consulta serveis usuari treballador:");
        }
        
    }
    public boolean esADmin(){
        // SI el treballador es admin
        if (userID==-1){
            return true;
        } else return false;
    }
    public  Integer obtenirTreballador(String nom) {
        ArrayList<Treballador> treballadors = Treballador.getTreballadors();
        Integer idTreballador = 0;
        Iterator<Treballador> it = treballadors.iterator();
        while (it.hasNext()) {
            Treballador t = it.next();
            String nomTreballador = t.getNom()+" "+t.getCognom1()+" "+t.getCognom2();
            if (nomTreballador.equalsIgnoreCase(nom)) {
                idTreballador = t.getId();
            }
        }
        return idTreballador;
    }
    public Boolean reservesServei (int servei){
        List<Reserva> lista = new ArrayList();
        ArrayList<Servei> serveis = Servei.getLlistaServeis();
        Iterator itS = serveis.iterator();
        while(itS.hasNext()){
            Servei s = (Servei) itS.next();
            if (s.getId()== servei){
                System.out.println("Servei seleccionat:"+servei);
                lista = s.getLlistaReserves();  
                Iterator itL = lista.iterator();
                while (itL.hasNext()){
                    Reserva r = (Reserva) itL.next();
                    System.out.println("ID SERVEI: " +r.getId_servei());
                    if (r.getId_servei()== servei){
                        System.out.println(r.getEmail_titular());
                        return true;
                    }
                }
            }
        
        }
        
       
        return false;
    }
    public void llistaTots(){
        ArrayList<Servei>listaServeis = Servei.getLlistaServeis();
        int contador=0;
        Iterator it = listaServeis.iterator();
        modeloLista.clear();
        while(it.hasNext()){
            listaServeis.size();
            Servei servei = (Servei) it.next();
            idServei[contador] = servei.getId();
            modeloLista.addElement(servei.getLabel());
            jlista.ensureIndexIsVisible(modeloLista.getSize());
            contador++;
        }
    }
    public void llistaTreballador(int treballadorSeleccionat){
        int contador = 0;
        ArrayList<Servei>listaServeis = Servei.getServeisTreballador(treballadorSeleccionat);
        
        Iterator it = listaServeis.iterator();
        modeloLista.clear();
        while(it.hasNext()){
            listaServeis.size();
            Servei servei = (Servei) it.next();
            if (treballadorSeleccionat== servei.getId_treballador()){
                idServei[contador] = servei.getId();
                modeloLista.addElement(servei.getLabel());
                jlista.ensureIndexIsVisible(modeloLista.getSize());
                treballadors = servei.getId_treballador();
            } 
            contador++;
        } 
    }
    public void emplenarChoice (){
        DescargaTreballador todo = new DescargaTreballador();
        ArrayList<Treballador> treballadors = (ArrayList<Treballador>) todo.obtenirTreballadorsDelServer(); 
        choiceTrabajador.add("Tots");
        Iterator it = treballadors.iterator();
        while(it.hasNext()){
            Treballador t = (Treballador) it.next();
            choiceTrabajador.add(t.getNom()+" "+t.getCognom1()+" "+t.getCognom2());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jlista = new javax.swing.JList<>();
        labelChoice = new javax.swing.JLabel();
        choiceTrabajador = new java.awt.Choice();
        labelPrincipal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jlista);

        labelChoice.setText("Treballador");

        labelPrincipal.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jButton1.setText("Tancar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(choiceTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(labelPrincipal)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelChoice)
                    .addComponent(choiceTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(llistaServeisAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(llistaServeisAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(llistaServeisAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(llistaServeisAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new llistaServeisAdmin(userID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choiceTrabajador;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlista;
    private javax.swing.JLabel labelChoice;
    private javax.swing.JLabel labelPrincipal;
    // End of variables declaration//GEN-END:variables
}
