/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interficies;

import Renders.RenderTreballador;
import Utils.DescargaServei;
import Utils.DescargaTreballador;
import Utils.GestionarUsuariBd;
import Utils.PostResponse;
import clases.Treballador;
import clases.Servei;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Maria
 *
 */
public class GestioUsuaris extends javax.swing.JFrame {

    public static DefaultListModel model;
    Treballador t;
    Treballador t2;
    private int selection;
    GestionarUsuariBd usuari_bd;
    ImageIcon icono;
    List<Servei> serveisTotal;
    DescargaServei descarrega;
    List<Servei> serveiTreballador;
    static List<Treballador> treballadors;
    DescargaTreballador descargaTreballador;
    int id_treballador;

    /**
     * @author Maria Remedios Ortega
     */
    public GestioUsuaris() {

        initComponents();
        descarrega = new DescargaServei();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jListTreballadors.setCellRenderer(new RenderTreballador());
        descargaTreballador = new DescargaTreballador();

        model = new DefaultListModel();
        _id.setVisible(false);
        jListTreballadors.setModel(model);

        InsereixTreballador();
        jListTreballadors.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                int selection = jListTreballadors.getSelectedIndex();
             
                if (jListTreballadors.getModel().getSize() != 0) {
                    t = new Treballador();
                    t = (Treballador) model.getElementAt(selection);
                    if (jListTreballadors.getSelectedValue() != null) {

                        id_treballador = t.getId();
                        _id.setText(String.valueOf(id_treballador));
                        nom.setText(t.getNom());
                        cognom1.setText(t.getCognom1());
                        cognom2.setText(t.getCognom2());
                        dni.setText(t.getDni());
                        login.setText(t.getLogin());
                        password.setText(t.getPassword());
                        int j = t.getEsAdmin();
                        if (j == 1) {
                            esAdmin.setState(true);
                            icono = new ImageIcon(getClass().getResource("/Images/admin.png"));
                            usuario.setIcon(icono);
                            usuario2.setText("Administrador");
                        } else {
                            esAdmin.setState(false);
                            icono = new ImageIcon(getClass().getResource("/Images/treb.png"));
                            usuario2.setText("    Usuari");
                            usuario.setIcon(icono);
                        }
                    }
                }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cognom1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cognom2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAfegir = new javax.swing.JButton();
        btnEsborra = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        esAdmin = new java.awt.Checkbox();
        label1 = new java.awt.Label();
        jLabel8 = new javax.swing.JLabel();
        dni = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTreballadors = new javax.swing.JList<>();
        _id = new javax.swing.JTextField();
        usuario = new javax.swing.JLabel();
        usuario2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        nom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel2.setText("Nom");

        jLabel3.setText("1er Cognom");

        cognom1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel4.setText("2on Cognom");

        cognom2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel5.setText("Login");

        login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        login.setForeground(new java.awt.Color(255, 0, 51));

        password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password.setForeground(new java.awt.Color(255, 51, 51));

        jLabel6.setText("Password");

        btnAfegir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAfegir.setText("Afegir");
        btnAfegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfegirActionPerformed(evt);
            }
        });

        btnEsborra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEsborra.setText("Esborrar");
        btnEsborra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsborraActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Gestionar Usuaris");

        label1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        label1.setText("Administrador");

        jLabel8.setText("DNI");

        dni.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListTreballadors);

        usuario2.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAfegir, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnEsborra, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(_id, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(236, 236, 236)
                        .addComponent(jLabel7))
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(esAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cognom2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cognom1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nom, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 155, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(cognom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cognom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(esAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(usuario2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAfegir)
                    .addComponent(btnModificar)
                    .addComponent(btnEsborra))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * @author Maria Remedios Ortega
     * @param evt
     */
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();

    }//GEN-LAST:event_jLabel1MouseClicked
    public boolean FormulariComplert() {
        boolean cognoms = cognom1.getText().equals("") && cognom2.getText().equals("");
        boolean login_pass = login.getText().equals("") && password.getText().equals("");
        boolean _dni = dni.getText().equals("");
        boolean _nom = nom.getText().equals("");

        if (_nom || cognoms || login_pass || _dni) {

            return true;
        } else {
            return false;
        }

    }

    /**
     * @author Maria Remedios Ortega
     * @param evt
     */
    private void btnAfegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfegirActionPerformed

        if (FormulariComplert()) {
            JOptionPane.showMessageDialog(null, "Falten dades");

        } else {
            inserirList();
            clearForm();
        }
    }//GEN-LAST:event_btnAfegirActionPerformed
    /**
     * @author Maria Remedios Ortega
     * 
     * @return 
     */
    
    public int Tria(){
         usuari_bd = new GestionarUsuariBd();
        selection = jListTreballadors.getSelectedIndex();
       return selection;
    }
    
    private void btnEsborraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsborraActionPerformed

        
        if (Tria()==-1) {
            JOptionPane.showMessageDialog(null, "Seleccionar usuari per esborrar");
        } else {
            Treballador t = (Treballador) model.getElementAt(selection);
            PostResponse response = usuari_bd.borrarTreballador(String.valueOf(t.getId()));
            if (response.getRequestCode() == 0) {
                JOptionPane.showMessageDialog(null, response.getMessage());

            } else {
                treballadors = descargaTreballador.obtenirTreballadorsDelServer();

                model.removeAllElements();
                actualitzaLlista(treballadors);

                clearForm();
            }

        }
    }//GEN-LAST:event_btnEsborraActionPerformed
    /**
     * @author Maria Remedios Ortega
     */

    public static void actualitzaLlista() {
        model.clear();

        for (int i = 0; i < Treballador.getSize(); i++) {
            model.addElement(Treballador.getTreballadors().get(i));
        }
    }

    /**
     * @author Maria Remedios Ortega
     * @param t
     */
    public static void actualitzaLlista(List<Treballador> t) {
        model.clear();

        for (int i = 0; i < t.size(); i++) {
            model.addElement(t.get(i));
        }
    }

    /**
     * @author Maria Remedios Ortega
     * @param evt
     */
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       if (Tria()==-1) {
            JOptionPane.showMessageDialog(null, "Seleccionar usuari per esborrar");
       
        } else {
            int id = Integer.parseInt(_id.getText());
            String sNom = nom.getText();
            String sCognom = cognom1.getText();
            String sCognom2 = cognom2.getText();
            String sLogin = login.getText();
            String sPassword = password.getText();
            String sDni = dni.getText();
            boolean x = esAdmin.getState();

            ArrayList<Treballador> treb = (ArrayList<Treballador>) descargaTreballador.obtenirTreballadorsDelServer();
            Iterator it = treb.iterator();
            int contador = 1;

            while (it.hasNext()) {
                Treballador t = (Treballador) it.next();
                System.out.println("Id del treballador a modificar" + t.getId());
                if (t.getId() == id) {
                    t.setId(id);
                    t.setNom(sNom);
                    t.setCognom1(sCognom);
                    t.setCognom2(sCognom2);
                    t.setLogin(sLogin);
                    t.setPassword(sPassword);
                    t.setDni(sDni);
                    if (x) {
                        t.setEsAdmin(1);
                    } else {
                        t.setEsAdmin(0);
                    }

                    PostResponse response = usuari_bd.actualitzarTreballador(t.getId(), sNom, sCognom, sCognom2, sDni, sLogin, sPassword, t.getEsAdmin());
                    if (response.getRequestCode() == 0) {
                        JOptionPane.showMessageDialog(null, response.getMessage());
                    } else {

                        InsereixTreballador();
                        actualitzaLlista();

                        break;
                    }
                }
                contador++;
            }
        }


    }//GEN-LAST:event_btnModificarActionPerformed

    private void dniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniActionPerformed
    /**
     * @author Maria Remedios Ortega
     */
    public void inserirList() {

        Treballador tr1 = new Treballador();
        tr1 = RecullirDadesFormulari();
        usuari_bd = new GestionarUsuariBd();
        PostResponse r = usuari_bd.inserirTreballador(tr1.getNom(), tr1.getCognom1(), tr1.getCognom2(), tr1.getDni(), tr1.getLogin(), tr1.getPassword(), tr1.getEsAdmin());
        if (r.getRequestCode() == 0) {
            JOptionPane.showMessageDialog(null, r.getMessage());
        } else {

            treballadors = descargaTreballador.obtenirTreballadorsDelServer();

            model.removeAllElements();
            actualitzaLlista(treballadors);
        }

    }

    /**
     * @author Maria Remedios Ortega
     * @return
     */
    public Treballador RecullirDadesFormulari() {
        String sNom = nom.getText();
        String sCognom = cognom1.getText();
        String sCognom2 = cognom2.getText();
        String sLogin = login.getText();
        String sPassword = password.getText();
        String sDni = dni.getText();
        Integer sEsAdmin = 0;

        if (esAdmin.getState()) {
            sEsAdmin = 1;
        } else {
            sEsAdmin = 0;
        }
        List<Servei> serv = new ArrayList();
        return new Treballador(0, sNom, sCognom, sCognom2, sDni, sLogin, sPassword, sEsAdmin, serv);

    }

    /**
     * @author Maria Remedios Ortega
     * @param t
     */
    public void OmplirFormulari(Treballador t) {

        _id.setText(String.valueOf(t.getId()));
        nom.setText(t.getNom());
        cognom1.setText(t.getCognom1());
        cognom2.setText(t.getCognom2());
        dni.setText(t.getDni());
        login.setText(t.getLogin());
        password.setText(t.getPassword());
        Integer value = t.getEsAdmin();
        if (value == 1) {
            esAdmin.setState(true);
        } else {
            esAdmin.setState(false);
        }

    }

    /**
     * @author Maria Remedios Ortega
     */
    public void clearForm() {
        nom.setText("");
        cognom1.setText("");
        cognom2.setText("");
        login.setText("");
        password.setText("");
        dni.setText("");
        esAdmin.setState(false);

    }

    /**
     * @author Maria Remedios Ortega
     */
    public void InsereixTreballador() {
        Treballador.getTreballadors().clear();

        DescargaTreballador todo = new DescargaTreballador();
        ArrayList<Treballador> treballadors = (ArrayList<Treballador>) todo.obtenirTreballadorsDelServer();

        Iterator it = treballadors.iterator();
        while (it.hasNext()) {
            Treballador t = (Treballador) it.next();
           
            Treballador.setTreballadors(t);
            model.addElement(t);

        }

    }

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
            java.util.logging.Logger.getLogger(GestioUsuaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestioUsuaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestioUsuaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestioUsuaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestioUsuaris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField _id;
    private javax.swing.JButton btnAfegir;
    private javax.swing.JButton btnEsborra;
    private javax.swing.JButton btnModificar;
    private javax.swing.JTextField cognom1;
    private javax.swing.JTextField cognom2;
    private javax.swing.JTextField dni;
    private java.awt.Checkbox esAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<Treballador> jListTreballadors;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JTextField login;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField password;
    private javax.swing.JLabel usuario;
    private javax.swing.JLabel usuario2;
    // End of variables declaration//GEN-END:variables

}
