/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interficies;

import Comprovacions.CarregaChoice;
import Utils.DescargaTreballador;
import Utils.DescargaServei;
import Utils.GestioServeisBD;
import Utils.PostResponse;
import Comprovacions.ValidaData;
import clases.Servei;
import clases.Treballador;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Maria
 *
 *
 */
public class GestioServeis extends javax.swing.JFrame {

    DefaultListModel model;
    List<Servei> serveis = new ArrayList();
    GestioServeisBD gestio = new GestioServeisBD();
    DescargaTreballador des_treb = new DescargaTreballador();
    List<Treballador> treballadors = new ArrayList();
    static Integer id = null;
    static Integer seleccionat = null;

    /**
     * Creates new form GestioServeis
     */
    public GestioServeis() {
        initComponents();
        this.getContentPane().setBackground(Color.ORANGE);

        model = new DefaultListModel();
        Jservicios.setModel(model);
        treballadors = des_treb.obtenirTreballadorsDelServer();
        carregaElements();
        this.setLocationRelativeTo(null);

        /**
         * @author Carlos Alberto Castro Cañabate
         */
        carregaLlista();

        Jservicios.addListSelectionListener(new ListSelectionListener() {
            /**
             * @author Carlos Alberto Castro Cañabate
             * Mètode que omple els camps de la interficie grafica al clicar sobre un servei de la llista
             * @param e 
             */
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selection = Jservicios.getSelectedIndex();
                JList list = (JList) e.getSource();
                if (list.isSelectionEmpty() || list.getValueIsAdjusting()) {
                    return;
                }
                seleccionat = list.getSelectedIndex();
                Servei s = new Servei();
                if (selection != -1) {
                    s = (Servei) model.getElementAt(selection);
                    id = s.getId();
                    String data = s.getData_servei();
                    String descripcio = s.getDescripcio();
                    String horaFi = s.getHora_final();
                    String horaInici = s.getHora_inici();
                    Integer idTreballador = s.getId_treballador();
                    descripcio.trim();
                    String[] descripcioTotal = descripcio.split("-");

                    origen.setText(descripcioTotal[0]);
                    destino.setText(descripcioTotal[1]);
                    data.trim();
                    String[] dataTotal = data.split("/");
                    dia.select(dataTotal[0]);
                    mes.select(dataTotal[1]);
                    año.select(dataTotal[2]);
                    String[] horaIniciTotal = horaInici.split(":");
                    hora_inicio.select(horaIniciTotal[0]);
                    minutos_inicio.select(horaIniciTotal[1]);
                    String[] horaFiTotal = horaFi.split(":");
                    hora_final.select(horaFiTotal[0]);
                    minutos_final.select(horaFiTotal[1]);
                    String nomTreballador = nomTreballador(idTreballador);
                    treballador.select(nomTreballador);
                }
            }
        });
    }

    /**
     * @author Carlos Alberto Castro Cañabate
     * 
     * Mètode per retornar el nom d'un treballador a partir del seu id
     * @param userID de el treballador
     * @return nom del treballador
     */
    public String nomTreballador(Integer userID) {
        Iterator<Treballador> it = treballadors.iterator();
        while (it.hasNext()) {
            Treballador t = it.next();
            if (t.getId() == userID) {
                return t.getNom() + " " + t.getCognom1() + " " + t.getCognom2();
            }
        }
        return null;
    }

    /**
     * @author Maria Remedios Ortega
     * 
     * Mètode pel qual es carreguen tots els elements dels choice d'aquest JFrame
     */
    public void carregaElements() {

        CarregaChoice.carregaTreballador(this.treballador, (ArrayList<Treballador>) treballadors);
        CarregaChoice.carregaAny(this.año);
        CarregaChoice.carrega(this.dia, 32, 1);
        CarregaChoice.carrega(this.hora_inicio, 25, 0);
        CarregaChoice.carrega(this.hora_final, 25, 0);
        CarregaChoice.carrega(this.minutos_inicio, 60, 0);
        CarregaChoice.carrega(this.minutos_final, 60, 0);
        CarregaChoice.carrega(this.mes, 13, 1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hora_inicio = new java.awt.Choice();
        minutos_inicio = new java.awt.Choice();
        jScrollPane3 = new javax.swing.JScrollPane();
        Jservicios = new javax.swing.JList<>();
        btn_Inserir = new javax.swing.JButton();
        btn_cancela = new javax.swing.JButton();
        origen = new java.awt.TextField();
        destino = new java.awt.TextField();
        treballador = new java.awt.Choice();
        dia = new java.awt.Choice();
        mes = new java.awt.Choice();
        año = new java.awt.Choice();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sortida = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        hora_final = new java.awt.Choice();
        minutos_final = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 51));

        hora_inicio.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        minutos_inicio.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        jScrollPane3.setViewportView(Jservicios);

        btn_Inserir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Inserir.setText("Inserir");
        btn_Inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InserirActionPerformed(evt);
            }
        });

        btn_cancela.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cancela.setText("Eliminar");
        btn_cancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelaActionPerformed(evt);
            }
        });

        origen.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        origen.setForeground(new java.awt.Color(255, 0, 0));
        origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                origenActionPerformed(evt);
            }
        });

        destino.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        destino.setForeground(new java.awt.Color(255, 0, 0));

        treballador.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        dia.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        mes.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        año.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Destinació");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Origen");

        sortida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        sortida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sortidaMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Gestió Servei");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Dia");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Mes");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Any");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Treballador");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Hora d'inici");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Hora final");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        hora_final.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        minutos_final.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(41, 41, 41)
                                                .addComponent(jLabel6)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hora_final, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(minutos_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(minutos_final, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btn_Inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_cancela, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(origen, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(destino, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(treballador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sortida)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(sortida)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(treballador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(minutos_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(hora_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(minutos_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Inserir)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)
                        .addGap(39, 39, 39)
                        .addComponent(btn_cancela)
                        .addGap(46, 46, 46))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    /**
     * @author Maria Remedios Ortega
     * @param evt
     * 
     * Mètode per inserir un servei a la base de dades amb peticio al servidor Post.
     * Prèviament es controla si la data introduida es correcta.
     */
    private void btn_InserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InserirActionPerformed
        String treballador, descripcio, data, h_inici, h_final, any, mes, min_ini, min_fi;

        treballador = this.treballador.getSelectedItem();
        int id_treb = obtenirTreballador(treballador);
        descripcio = this.origen.getText() + " - " + this.destino.getText();
        data = this.dia.getSelectedItem();
        mes = this.mes.getSelectedItem();
        h_inici = this.hora_inicio.getSelectedItem();
        h_final = this.hora_final.getSelectedItem();
        any = this.año.getSelectedItem();
        min_ini = minutos_inicio.getSelectedItem();
        min_fi = this.minutos_final.getSelectedItem();
        String data_servei = data + "/" + mes + "/" + any;

        int d = Integer.parseInt(data);
        int m = Integer.parseInt(mes);
        int y = Integer.parseInt(any);
     
        if (ValidaData.comprovaFormulari(this.origen.getText(), this.destino.getText(), id_treb)) {
            if (ValidaData.comprovaData(data_servei) && ValidaData.checkDay(d, m, y)) {
                Servei s = new Servei(0, descripcio, id_treb, data_servei, h_inici + ":" + min_ini, h_final + ":" + min_fi, null);
                
                PostResponse response = gestio.inserirServei(descripcio, data_servei, h_inici + ":" + min_ini, h_final + ":" + min_fi, id_treb);
                if (response.getRequestCode() == 0) {
                    JOptionPane.showMessageDialog(null, response.getMessage());
                } else {
                    serveis.add(s);
                    model.addElement(s);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data incorrecta!!!");
            }
        }
        carregaLlista();
    }//GEN-LAST:event_btn_InserirActionPerformed
   
    /**
     * Mètode per obtenir mitjançant el nom del treballador el seu id.
     * @author Maria Remedios Ortega
     * @param nom
     * @return int amb el id del treballador
     */
    public Integer obtenirTreballador(String nom) {

        Integer idTreballador = 0;
        Iterator<Treballador> it = treballadors.iterator();
        while (it.hasNext()) {
            Treballador t = it.next();
            String nomTreballador = t.getNom() + " " + t.getCognom1() + " " + t.getCognom2();
            if (nomTreballador.equalsIgnoreCase(nom)) {
                idTreballador = t.getId();
            }
        }
        return idTreballador;
    }

    /**
     * @author Maria Remedios Ortega
     */
    private void sortidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sortidaMouseClicked
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_sortidaMouseClicked

    private void origenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_origenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_origenActionPerformed

    /**
     * @author Carlos Alberto Castro Cañabate
     * 
     * Mètode per carregar la llista de serveis
     */
    public void carregaLlista() {
        serveis = DescargaServei.obtenirServeisDelServer();
        model.removeAllElements();
        model = new DefaultListModel();
        Iterator it = serveis.iterator();
        Jservicios.setModel(model);
        while (it.hasNext()) {
            Servei se = (Servei) it.next();
            model.addElement(se);
        }
    }

    /**
     * @author Carlos Alberto Castro Cañabate
     * 
     * Mètode per modificarun servei a la base de dades amb peticio al servidor Post.
     * Prèviament es controla si la data introduida es correcta, y que el treballador seleccionat no tingui hores solapades.
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (seleccionat == null) {  // Si no hi ha servei seleccionat no deixa modificar
            JOptionPane.showMessageDialog(null, "Selecciona servei!");
        } else { // Si hi ha servei seleccionat, obtenim els camps amb les dades del servei:
            String treballador, descripcio, data, h_inici, m_inici, m_final, h_final, any, mes;
            treballador = this.treballador.getSelectedItem();
            int id_treb = obtenirTreballador(treballador);
            descripcio = this.origen.getText().trim() + " - " + this.destino.getText().trim();
            data = this.dia.getSelectedItem();
            mes = this.mes.getSelectedItem();
            h_inici = this.hora_inicio.getSelectedItem().trim();
            m_inici = this.minutos_inicio.getSelectedItem().trim();
            h_final = this.hora_final.getSelectedItem().trim();
            m_final = this.minutos_final.getSelectedItem().trim();
            String horaInici = h_inici + ":" + m_inici;
            String horaFinal = h_final + ":" + m_final;
            any = this.año.getSelectedItem();

            String data_servei = data + "/" + mes + "/" + any;
            int d = Integer.parseInt(data);
            int m = Integer.parseInt(mes);
            int y = Integer.parseInt(any);
            // Un cop obtingudes correctament totes les dades, validem que siguim correctes:
            if (ValidaData.comprovaData(data_servei) && ValidaData.checkDay(d, m, y)) {
                //  ArrayList<Servei> serv = Servei.getLlistaServeis();
                Iterator it2 = serveis.iterator();
                int contador = 1;

                while (it2.hasNext()) {
                    Servei s = (Servei) it2.next();
                    System.out.println(s.getId());
                    if (s.getId() == id) {
                        s.setId(id);
                        s.setDescripcio(descripcio);
                        s.setId_treballador(id_treb);
                        s.setHora_inici(horaInici);
                        s.setHora_final(horaFinal);
                        s.setData_servei(data_servei);
                        // Enviem petició de modificació al server
                        PostResponse response = gestio.actualitzarServei(s.getId(), descripcio, data_servei, horaInici, horaFinal, id_treb);
                        if (response.getRequestCode() == 0) { // Si no deixa modificar, mostrem missatge d'error
                            JOptionPane.showMessageDialog(null, response.getMessage());
                        } else { // Si deixa modificar, ho fem.
                            Servei.getLlistaServeis().remove(s);
                            serveis.add(s);
                            model.addElement(s);
                            model.remove(model.getSize() - 1);
                            JOptionPane.showMessageDialog(null, "Servei modificat!");
                        }
                        break;
                    }
                    contador++;
                }
               
            } else {
                JOptionPane.showMessageDialog(null, "Data incorrecta!");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @author Carlos Alberto Castro Cañabate
     * Mètode per eliminar un servei a la base de dades amb peticio al servidor Post.
     * controla si el servei te reserves adjudicades abans de eliminar.
     * @param evt
     */
    private void btn_cancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelaActionPerformed
        // Si no hem seleccionat cap servei no podrem eliminar:  
        if (seleccionat == null) {
            JOptionPane.showMessageDialog(null, "Selecciona servei!");
        } else {  // Si tenim un servei seleccionat
            Servei s = (Servei) model.getElementAt(seleccionat);
            Integer id_servei = s.getId();
            if (JOptionPane.showConfirmDialog(null, "Esta a punt d'esborrar aquesta entrada?") == 0) {
                // Enviem la petició de eliminar el servi al server
                PostResponse response = gestio.borrarServei(id_servei);
                if (response.getRequestCode() == 0) { // Si te alguna reserva ens mostrarà error
                    JOptionPane.showMessageDialog(null, response.getMessage());
                } else {  // Sino eliminarà el servei
                    Servei.getLlistaServeis().remove(s);
                    model.remove(seleccionat);
                }

            }
        }
    }//GEN-LAST:event_btn_cancelaActionPerformed

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
            java.util.logging.Logger.getLogger(GestioServeis.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestioServeis.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestioServeis.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestioServeis.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestioServeis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Jservicios;
    private java.awt.Choice año;
    private javax.swing.JButton btn_Inserir;
    private javax.swing.JButton btn_cancela;
    private java.awt.TextField destino;
    private java.awt.Choice dia;
    private java.awt.Choice hora_final;
    private java.awt.Choice hora_inicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.Choice mes;
    private java.awt.Choice minutos_final;
    private java.awt.Choice minutos_inicio;
    private java.awt.TextField origen;
    private javax.swing.JLabel sortida;
    private java.awt.Choice treballador;
    // End of variables declaration//GEN-END:variables
}
