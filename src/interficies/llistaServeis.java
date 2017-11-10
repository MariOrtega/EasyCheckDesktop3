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
public class llistaServeis extends javax.swing.JFrame {
    DefaultListModel modeloLista;
    Integer[] idServei = new Integer [1000];
    Integer treballador = 0;
    ArrayList<Treballador> treballadors = null;
    
    /**
     * Creates new form NewJFrame
     */
    public llistaServeis() {
        DescargaTreballador todo = new DescargaTreballador();
        treballadors = (ArrayList<Treballador>) todo.obtenirTreballadorsDelServer(); 
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
        String nomTreballador = nomTreballador();
        if (VentanaLogin.TIPUS_USUARI == 1) {
            emplenarChoice();
            llistaTots();
            label_Principal.setText("Consulta serveis per a Administradors: ");
        }
        else {
            choiceTrabajador.setVisible(false);
            labelChoice.setVisible(false);
          //  labelChoice.setText("");
            llistaTreballador(VentanaLogin.USER_ID);
            label_Principal.setText("Consulta serveis usuari: "+nomTreballador);
        }
    }
    public String nomTreballador (){
        Iterator<Treballador> it = treballadors.iterator();
        while (it.hasNext()) {
            Treballador t = it.next();
            if (t.getId()==VentanaLogin.USER_ID) {
                return t.getNom()+" "+t.getCognom1()+" "+t.getCognom2();
            } 
        }
        return null;
    }

    public  Integer obtenirTreballador(String nom) {
       // ArrayList<Treballador> treballadors = Treballador.getTreballadors();
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
                        System.out.println(r.getClient().getEmail_titular());
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
                treballador = servei.getId_treballador();
            } 
            contador++;
        } 
    }
    public void emplenarChoice (){
       // DescargaTreballador todo = new DescargaTreballador();
      //  ArrayList<Treballador> treballadors = (ArrayList<Treballador>) todo.obtenirTreballadorsDelServer(); 
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

        labelPrincipal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlista = new javax.swing.JList<>();
        choiceTrabajador = new java.awt.Choice();
        labelChoice = new javax.swing.JLabel();
        label_Principal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 204, 51));

        labelPrincipal.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));

        jScrollPane1.setViewportView(jlista);

        labelChoice.setText("Treballador");

        label_Principal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_Principal.setText("CONSULTES ADMIN O TREBALLADOR");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Principal)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(labelChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choiceTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(label_Principal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelChoice)
                    .addComponent(choiceTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(labelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelPrincipal)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(llistaServeis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(llistaServeis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(llistaServeis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(llistaServeis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new llistaServeis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choiceTrabajador;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlista;
    private javax.swing.JLabel labelChoice;
    private javax.swing.JLabel labelPrincipal;
    private javax.swing.JLabel label_Principal;
    // End of variables declaration//GEN-END:variables
}
