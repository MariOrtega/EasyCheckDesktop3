/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interficies;

import Renders.RenderServicios;
import Utils.DescargaTreballador;
import Utils.DescargaServei;
import Utils.GestioServeisBD;
import Utils.ValidaData;
import clases.Servei;
import clases.Treballador;
import static interficies.GestioUsuaris.model;
import static interficies.llistaServeis.userID;
import java.awt.Choice;
import java.awt.Color;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        serveis = Servei.getLlistaServeis();
        treballadors = des_treb.obtenirTreballadorsDelServer();

        carregaElements();

        this.setLocationRelativeTo(null);

        /**
         * @author Carlos Alberto Castro Cañabate
         */
        carregaLlista();

        Jservicios.addListSelectionListener(new ListSelectionListener() {
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

    public void carregaElements() {

        carregaTreballador(this.treballador);
        carregaAny(this.año);
        carrega(this.dia, 32);
        carrega(this.hora_inicio, 25);
        carrega(this.hora_final, 25);
        carrega(this.minutos_inicio, 60);

        carrega(this.minutos_final, 60);
        carrega(this.mes, 13);
    }

    public void carrega(Choice choice, int x) {
        if (x != 25) {
            for (int i = 0; i < x; i++) {
                if (i < 10) {
                    choice.add("0" + String.valueOf(i));
                } else {
                    choice.add(String.valueOf(i));
                }
            }
        } else {
            for (int i = 0; i < x; i++) {
                if (i < 10) {
                    choice.add("0" + String.valueOf(i));
                } else {
                    choice.add(String.valueOf(i));
                }
            }
        }
    }

    public void carregaTreballador(Choice choice) {
        for (int i = 0; i < treballadors.size(); i++) {
            Treballador t = treballadors.get(i);

            this.treballador.add(t.getNom() + " " + t.getCognom1() + " " + t.getCognom2());
        }
    }

    public void carregaAny(Choice choice) {
        Calendar calendar = Calendar.getInstance();
        int year = (calendar.get(Calendar.YEAR));
        System.out.println(year);
        for (int i = year; i < 2101; i++) {
            this.año.add(String.valueOf(i));
        }
    }
 public  static boolean  checkDay (int day, int month, int year){
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
    public boolean comprovaData(String dataSeleccionada) {
        ValidaData d= new ValidaData();
        boolean data=false;
        Calendar calendar = Calendar.getInstance();
        int year = (calendar.get(Calendar.YEAR));
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        System.out.println(day);
        String dataActual = (day + "/" + month + "/" + year);
       
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataActual_parseada = sdf.parse(dataActual, new ParsePosition(0));
            Date dataSeleccionada_parseada = sdf.parse(dataSeleccionada, new ParsePosition(0));

            if (dataActual_parseada.before(dataSeleccionada_parseada)) {
                data = true;
            } else {

                data = false;

            }
      
        
        return data;
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

        origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                origenActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Destinació");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Origen");

        sortida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        sortida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sortidaMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Gestió Servei");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Dia");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Mes");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Any");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("Treballador");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setText("Hora d'inici");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("Hora final");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                                .addComponent(origen, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(destino, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(treballador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(52, 52, 52)))
                                .addGap(77, 77, 77)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(104, 104, 104))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(89, 89, 89)
                                                .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel2)
                                                .addGap(59, 59, 59)
                                                .addComponent(jLabel1)
                                                .addGap(53, 53, 53)
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
                                            .addComponent(minutos_final, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btn_Inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1)
                                            .addComponent(btn_cancela, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
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
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(sortida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(treballador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel9)
                            .addGap(9, 9, 9))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(minutos_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(hora_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(minutos_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btn_Inserir)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)
                        .addGap(39, 39, 39)
                        .addComponent(btn_cancela))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        int d=Integer.parseInt(data);
        int m=Integer.parseInt(mes);
        int y= Integer.parseInt(any);
        if (comprovaData(data_servei)&&ValidaData.checkDay(d, m, y)) {
            Servei s = new Servei(0, descripcio, id_treb, data_servei, h_inici + ":" + min_ini, h_final + ":" + min_fi, null);
            gestio.inserirServei(descripcio, data_servei, h_inici + ":" + min_ini, h_final + ":" + min_fi, id_treb);
            serveis.add(s);
            model.addElement(s);
            //model.addElement(s.getLabel());
        } else {
            JOptionPane.showMessageDialog(null, "Data incorrecta!!!");
        }
    }//GEN-LAST:event_btn_InserirActionPerformed
    public Integer obtenirTreballador(String nom) {
        // ArrayList<Treballador> treballadors = Treballador.getTreballadors();
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
    private void sortidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sortidaMouseClicked
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_sortidaMouseClicked

    private void origenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_origenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_origenActionPerformed

    /**
     * @author Carlos Alberto Castro Cañabate
     * @param evt
     */
    public void carregaLlista() {
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
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
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
        if (comprovaData(data_servei)) {
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
                    Servei.getLlistaServeis().remove(s);

                    serveis.add(s);
                    model.addElement(s);
                    gestio.actualitzarServei(s.getId(), descripcio, data_servei, horaInici, horaFinal, id_treb);
                    model.remove(model.getSize() - 1);
                    break;
                }
                contador++;

            }
            JOptionPane.showMessageDialog(null, "Servei modificat!");
        } else {
            JOptionPane.showMessageDialog(null, "Data incorrecta!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @author Carlos Alberto Castro Cañabate
     * @param evt
     */
    private void btn_cancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelaActionPerformed
        // TODO add your handling code here:

        System.out.println("seleccionat: " + seleccionat);
        if (seleccionat == null) {
            JOptionPane.showMessageDialog(null, "Selecciona servei!");
        } else {
            Servei s = (Servei) model.getElementAt(seleccionat);
            Integer id_servei = s.getId();
            if (JOptionPane.showConfirmDialog(null, "Esta a punt d'esborrar aquesta entrada?") == 0) {
                gestio.borrarServei(id_servei);
                Servei.getLlistaServeis().remove(s);
                model.remove(seleccionat);
            }
        }
    }//GEN-LAST:event_btn_cancelaActionPerformed

    public void print(String x) {
        System.out.print(x + " ");
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
            java.util.logging.Logger.getLogger(GestioServeis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestioServeis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestioServeis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestioServeis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
