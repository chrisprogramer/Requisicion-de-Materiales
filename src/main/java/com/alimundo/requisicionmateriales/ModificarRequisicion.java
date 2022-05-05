/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.alimundo.requisicionmateriales;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ModificarRequisicion extends javax.swing.JDialog {
    DefaultTableModel modelorequisicion = new DefaultTableModel();
    DefaultTableModel modelobusqueda = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            if (columnas == 1) {
                return true;
            } else {
                return false;
            }
        }
    };
    TableColumnModel columnModel;
    
    public final void tamanocolumnasrequisicion(JTable table) {
        columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(700);
        columnModel.getColumn(2).setPreferredWidth(180);
        columnModel.getColumn(3).setPreferredWidth(130);
        columnModel.getColumn(4).setPreferredWidth(100);
    }
    
    public final void tamanocolumnasbusqueda(JTable table) {
        columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(700);
    }
    Conexion con = new Conexion();
    String error;
    String seleccion;
    Date fechahoy;
    String fechaformat = "dd/MM/yyyy";
    JTextFieldDateEditor editor;
    
    
    public ModificarRequisicion() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setModal(true);
        modelobusqueda.setColumnIdentifiers(new Object[]{"<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>"});
        
        modelorequisicion.setColumnIdentifiers(new Object[]{"<html><h3 style=font-family:Verdana;>Codigo</h3></html>","<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>",
                                                            "<html><h3 style=font-family:Verdana;>Medida</h3></html>","<html><h3 style=font-family:Verdana;>Precio</h3></html>",
                                                            "<html><h3 style=font-family:Verdana;>Cant.</h3></html>"});
        
        new CargarComponentes().llenarcombobox(jComboBoxdpto, "SELECT nom_departamento FROM Departamentos");
        new CargarComponentes().llenarcombobox(jComboBoxtipo,"SELECT Descripcion FROM TipoRequisicion");
        tablerequisicion.getTableHeader().setReorderingAllowed(false);
        tablebuscarmaterial.getTableHeader().setReorderingAllowed(false);
        fechahoy = new Date();
        this.date.setDateFormatString(fechaformat);
        this.date.setDate(fechahoy);
        editor = (JTextFieldDateEditor) date.getDateEditor();
        editor.setEnabled(false);
        
        try{
           PreparedStatement ps = null;
           ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornadatoscompletosrequisicion ?");
            ps.setInt(1,Principal.idreq);
            rs = ps.executeQuery();
            while(rs.next()){
                this.labelnid.setText(rs.getString(1));
                this.jComboBoxdpto.setSelectedIndex(rs.getInt(2)-1);
                this.date.setDate(rs.getDate(3));
                this.jComboBoxtipo.setSelectedIndex(rs.getInt(4)-1);
            }
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornadetallebasicorequisicion ?");
            ps.setInt(1,Principal.idreq);
            rs = ps.executeQuery();
            while(rs.next()){
                int cantidad;
                cantidad = rs.getInt(5);
                this.modelorequisicion.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),String.valueOf(cantidad)});
            }
        }catch(SQLException ex){
           error = ex.getMessage();
           JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelcerrar = new javax.swing.JLabel();
        labeltitulo = new javax.swing.JLabel();
        labelid = new javax.swing.JLabel();
        labelnid = new javax.swing.JLabel();
        labeldepartamento = new javax.swing.JLabel();
        botonmodificar = new javax.swing.JButton();
        botonaceptar = new javax.swing.JButton();
        jComboBoxdpto = new javax.swing.JComboBox<>();
        labelfecha = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        labeltipo = new javax.swing.JLabel();
        jComboBoxtipo = new javax.swing.JComboBox<>();
        jScrollPane = new javax.swing.JScrollPane();
        tablerequisicion = new javax.swing.JTable();
        labelbuscar = new javax.swing.JLabel();
        textfieldbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablebuscarmaterial = new javax.swing.JTable();
        panelopciones = new javax.swing.JPanel();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 465));
        setMinimumSize(new java.awt.Dimension(1024, 465));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1024, 465));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs32X32/cancel.png"))); // NOI18N
        labelcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcerrarMouseClicked(evt);
            }
        });
        getContentPane().add(labelcerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(986, 4, -1, -1));

        labeltitulo.setBackground(new java.awt.Color(255, 255, 255));
        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        labeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitulo.setText("MODIFICAR REQUISICIÓN");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labeltitulo.setOpaque(true);
        getContentPane().add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1025, 40));

        labelid.setBackground(new java.awt.Color(255, 255, 255));
        labelid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelid.setText("ID Requisición");
        labelid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(labelid, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        labelnid.setBackground(new java.awt.Color(255, 255, 255));
        labelnid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelnid.setForeground(new java.awt.Color(255, 0, 0));
        labelnid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelnid.setEnabled(false);
        labelnid.setFocusable(false);
        labelnid.setOpaque(true);
        getContentPane().add(labelnid, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 50, 40));

        labeldepartamento.setBackground(new java.awt.Color(255, 255, 255));
        labeldepartamento.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labeldepartamento.setText("Solicita");
        labeldepartamento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labeldepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(labeldepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        botonmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/edit_pencil_paper_modify_write_icon_141958.png"))); // NOI18N
        botonmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(botonmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 380, -1, -1));

        botonaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/refresh_paper_load_update_icon_141966.png"))); // NOI18N
        botonaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonaceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 380, -1, -1));

        jComboBoxdpto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        getContentPane().add(jComboBoxdpto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 260, 30));

        labelfecha.setBackground(new java.awt.Color(255, 255, 255));
        labelfecha.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelfecha.setText("Fecha de Solicitud");
        labelfecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelfecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(labelfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, -1, -1));

        date.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        date.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        date.setOpaque(false);
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 210, 30));

        labeltipo.setBackground(new java.awt.Color(255, 255, 255));
        labeltipo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labeltipo.setText(" Tipo de Requisición");
        labeltipo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(labeltipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        jComboBoxtipo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        getContentPane().add(jComboBoxtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 260, 30));

        tablerequisicion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tablerequisicion.setModel(modelorequisicion);
        tablerequisicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablerequisicionKeyPressed(evt);
            }
        });
        jScrollPane.setViewportView(tablerequisicion);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 720, 190));

        labelbuscar.setBackground(new java.awt.Color(255, 255, 255));
        labelbuscar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelbuscar.setText("Buscar Material");
        labelbuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(labelbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        textfieldbuscar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        textfieldbuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textfieldbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldbuscarActionPerformed(evt);
            }
        });
        textfieldbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textfieldbuscarKeyReleased(evt);
            }
        });
        getContentPane().add(textfieldbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 160, 258, 30));

        tablebuscarmaterial.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablebuscarmaterial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tablebuscarmaterial.setModel(modelobusqueda);
        tablebuscarmaterial.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablebuscarmaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablebuscarmaterialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablebuscarmaterial);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 192, 260, 210));

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 30, 420));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1023, 464));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcerrarMouseClicked
        this.setCursor(new Cursor (Cursor.WAIT_CURSOR));
        this.dispose();
        this.setCursor(new Cursor (Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelcerrarMouseClicked

    private void botonmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonmodificarActionPerformed
        /*if(validar.vacio(this.textfieldcodigo.getText(),this.texfieldnombre.getText())){
            try {
                PreparedStatement ps = null;
                ResultSet rs = null;
                ps = con.EstablecerConexion().prepareStatement("EXEC spu_modificarmaterial ?,?,?,?,?,?");
                ps.setString(1, this.textfieldcodigo.getText());
                ps.setString(2, this.texfieldnombre.getText());
                ps.setString(3, this.choicecategorias.getSelectedItem());
                ps.setString(4, this.choicemedidas.getSelectedItem());
                ps.setString(5, this.choicealmacenes.getSelectedItem());
                ps.setString(6, this.textfielddescripcion.getText());
                rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Material Modificado con Exito </h3></html>",
                        null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconinformacion);
                    this.textfieldcodigo.setText(" ");
                    this.texfieldnombre.setText(" ");
                    this.textfieldcantidad.setText("0");
                    this.textfielddescripcion.setText(" ");
                }
                ps.close();
            } catch (SQLException ex) {
                errorsql = ex.getErrorCode();
                if (errorsql == 0){
                    JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>El Codigo ingresado no existe en el Sistema</h3></html>",
                        "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                }else{
                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                }
            }
        }else {JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>El Codigo y Nombre no pueden estar vacios</h3></html>",
            "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);

        }*/
    }//GEN-LAST:event_botonmodificarActionPerformed

    private void botonaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarActionPerformed
       /* this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object[] textoOpciones = {"Si", "No"};
        int opc = JOptionPane.showOptionDialog(null, "<html><h3 style=font-family:Verdana New;>¿Esta Seguro que Desea Guardar la Entrada?</h3></html>",
            null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, new Parametros().iconpregunta, textoOpciones, textoOpciones[0]);
        if (opc == 0) {
            if (validar.vacio(this.textfieldcodigo.getText(), this.texfieldnombre.getText())) {
                if (validar.ValidaCantidad(Integer.parseInt(this.textfieldcantidad.getText()))) {
                    try {
                        ps = con.EstablecerConexion().prepareStatement("EXEC spu_guardanvomaterial ?,?,?,?,?,?,?");
                        ps.setString(1, this.textfieldcodigo.getText());
                        ps.setString(2, this.texfieldnombre.getText());
                        ps.setString(3, this.choicecategorias.getSelectedItem());
                        ps.setString(4, this.choicemedidas.getSelectedItem());
                        ps.setString(5, this.choicealmacenes.getSelectedItem());
                        ps.setInt(6, Integer.parseInt(this.textfieldcantidad.getText()));
                        ps.setString(7, this.textfielddescripcion.getText());
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Material Guardado con Exito </h3></html>",
                                null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconinformacion);
                            this.textfieldcodigo.setText(" ");
                            this.texfieldnombre.setText(" ");
                            this.textfieldcantidad.setText("0");
                            this.textfielddescripcion.setText(" ");
                        }
                        ps.close();
                    } catch (SQLException ex) {
                        errorsql = ex.getErrorCode();
                        if (errorsql == 2627) {
                            JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>El Material ya existe en el Sistema</h3></html>",
                                "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                        } else {
                            error = ex.getMessage();
                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>La cantidad debe ser mayor a 0</h3></html>",
                        "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                }
            } else {
                JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>El Codigo y Nombre no pueden estar vacios</h3></html>",
                    "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
            }
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));*/
    }//GEN-LAST:event_botonaceptarActionPerformed

    private void tablerequisicionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablerequisicionKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            if (this.tablerequisicion.getSelectedRowCount() > 0) {
                modelorequisicion.removeRow(tablerequisicion.getSelectedRow());
            }
            else{
                JOptionPane.showMessageDialog(null,"<html><h3 style=font-family:Verdana;>Debe Seleccionar un Registro</h3></html>",null,JOptionPane.PLAIN_MESSAGE,new Parametros().iconadvertencia);
            }
        }
    }//GEN-LAST:event_tablerequisicionKeyPressed

    private void textfieldbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfieldbuscarKeyReleased
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        String valor = this.textfieldbuscar.getText();
        try {
            modelobusqueda.setRowCount(0);
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_consultamaterial ?");
            ps.setString(1, valor);
            rs = ps.executeQuery();
            while (rs.next()) {
                modelobusqueda.addRow(new Object[]{rs.getString(2)});
            }
            ps.close();
        } catch (SQLException ex) {
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_textfieldbuscarKeyReleased

    private void tablebuscarmaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebuscarmaterialMouseClicked
        /*this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        int cantidad;
        int tiporeq;
        String selecciontiporeq;
        if (evt.getClickCount() == 2) {
            modelobusqueda = (DefaultTableModel) tablebuscarmaterial.getModel();
            modelorequisicion = (DefaultTableModel) this.tablerequisicion.getModel();
            seleccion = String.valueOf(modelobusqueda.getValueAt(tablebuscarmaterial.getSelectedRow(), 0));
            selecciontiporeq = (String) requisicion.jComboBoxtipo.getSelectedItem();
            try {
                PreparedStatement ps = null;
                ResultSet rs = null;
                ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornatiporequisicion ?");
                ps.setString(1,selecciontiporeq);
                rs = ps.executeQuery();
                while (rs.next()){
                    tiporeq = rs.getInt(1);
                    switch (tiporeq){
                        case 1: ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornadatosmaterial ?");
                        ps.setString(1, seleccion);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            modelorequisicion.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(6)});
                        }
                        break;
                        case 2: ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornacantexistencia ?");
                        ps.setString(1, seleccion);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            cantidad = rs.getInt(1);
                            if (cantidad > 0) {
                                ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornadatosmaterial ?");
                                ps.setString(1, seleccion);
                                rs = ps.executeQuery();
                                while (rs.next()) {
                                    modelorequisicion.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(6)});
                                }
                            }else {
                                JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>El Material no se Encuentra en Existencia</h3></html>", null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia);
                            }
                        }
                        break;
                    }
                }
                ps.close();
            }catch (SQLException ex) {
                error = ex.getMessage();
                JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
            }
            requisicion.tablerequisicion.getSelectionModel().setSelectionInterval(1, 1);
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));*/
    }//GEN-LAST:event_tablebuscarmaterialMouseClicked

    private void textfieldbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldbuscarActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarRequisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarRequisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarRequisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarRequisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarRequisicion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonaceptar;
    private javax.swing.JButton botonmodificar;
    public com.toedter.calendar.JDateChooser date;
    public javax.swing.JComboBox<String> jComboBoxdpto;
    public javax.swing.JComboBox<String> jComboBoxtipo;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelbuscar;
    private javax.swing.JLabel labelcerrar;
    private javax.swing.JLabel labeldepartamento;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelid;
    public javax.swing.JLabel labelnid;
    private javax.swing.JLabel labeltipo;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JPanel panelopciones;
    private javax.swing.JTable tablebuscarmaterial;
    public javax.swing.JTable tablerequisicion;
    private javax.swing.JTextField textfieldbuscar;
    // End of variables declaration//GEN-END:variables
}
