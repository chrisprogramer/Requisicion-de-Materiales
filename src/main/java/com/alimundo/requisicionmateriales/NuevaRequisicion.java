/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.alimundo.requisicionmateriales;

import Reportes.ReportesDB;
import java.awt.Color;
import java.awt.Cursor;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

public class NuevaRequisicion extends javax.swing.JDialog {

    DefaultTableModel modelo;
    String error;
    int coderrorsql;
    int tiporeq;
    String seleccion;
    int tabbedfocus;
    Conexion con = new Conexion();
    ReportesDB reportesalmacen = new ReportesDB();
    String fechaformat = "dd/MM/yyyy";
    SimpleDateFormat dateformat = new SimpleDateFormat(fechaformat);

    DefaultTableModel modelorequisicion = new DefaultTableModel();
    DefaultTableModel modelobusqueda = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            if (columnas == 4) {
                return true;
            } else {
                return false;
            }
        }
    };
    
    public int retornaidtiporequisicion(String selecciontipo) {
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornatiporequisicion ?");
            ps.setString(1, selecciontipo);
            rs = ps.executeQuery();
            while (rs.next()) {
                tiporeq = rs.getInt(1);
            }
        } catch (SQLException ex) {
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
        return tiporeq;
    }

    public NuevaRequisicion() {

        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);

        initComponents();
        setTitle("MOVIMIENTOS DE ALMACÉN");
        setSize(1229, 621);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        modelobusqueda.setColumnIdentifiers(new Object[]{"", ""});

        if (tablebuscarmaterial.getColumnModel().getColumnCount() > 0) {

            tablebuscarmaterial.getColumnModel().getColumn(0).setHeaderValue("<html><h3 style=font-family:Verdana;>Codigo</h3></html>");
            tablebuscarmaterial.getColumnModel().getColumn(0).setPreferredWidth(250);
            tablebuscarmaterial.getColumnModel().getColumn(0).setMaxWidth(250);
            tablebuscarmaterial.getColumnModel().getColumn(0).setResizable(false);

            tablebuscarmaterial.getColumnModel().getColumn(1).setHeaderValue("<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>");
            tablebuscarmaterial.getColumnModel().getColumn(1).setPreferredWidth(900);
            tablebuscarmaterial.getColumnModel().getColumn(1).setMaxWidth(900);
            tablebuscarmaterial.getColumnModel().getColumn(1).setResizable(false);
        }
        tablebuscarmaterial.getTableHeader().setReorderingAllowed(false);
        this.textfieldbuscar.requestFocus();
        this.setModal(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requisicion = new Paneles.Requisicion();
        panelopciones = new javax.swing.JPanel();
        textfieldbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablebuscarmaterial = new javax.swing.JTable();
        labelaceptar = new javax.swing.JLabel();
        botonaceptar = new javax.swing.JButton();
        labelcerrar = new javax.swing.JLabel();
        labelbuscar = new javax.swing.JLabel();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1229, 621));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1229, 621));
        getContentPane().setLayout(null);
        getContentPane().add(requisicion);
        requisicion.setBounds(500, 40, 722, 470);

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones);
        panelopciones.setBounds(0, 0, 30, 878);

        textfieldbuscar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        textfieldbuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textfieldbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textfieldbuscarKeyReleased(evt);
            }
        });
        getContentPane().add(textfieldbuscar);
        textfieldbuscar.setBounds(40, 120, 450, 30);

        tablebuscarmaterial.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablebuscarmaterial.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tablebuscarmaterial.setModel(modelobusqueda);
        tablebuscarmaterial.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablebuscarmaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablebuscarmaterialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablebuscarmaterial);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 160, 452, 350);

        labelaceptar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labelaceptar.setText("Aceptar");
        getContentPane().add(labelaceptar);
        labelaceptar.setBounds(1154, 595, 60, 16);

        botonaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs64X64/verificar.png"))); // NOI18N
        botonaceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botonaceptar.setOpaque(false);
        botonaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(botonaceptar);
        botonaceptar.setBounds(1140, 515, 80, 80);

        labelcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs32X32/cancel.png"))); // NOI18N
        labelcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcerrarMouseClicked(evt);
            }
        });
        getContentPane().add(labelcerrar);
        labelcerrar.setBounds(1180, 4, 32, 40);

        labelbuscar.setBackground(new java.awt.Color(0, 153, 204));
        labelbuscar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelbuscar.setText("Buscar Material");
        labelbuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelbuscar.setOpaque(true);
        getContentPane().add(labelbuscar);
        labelbuscar.setBounds(40, 90, 140, 20);

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        labelfondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(labelfondo);
        labelfondo.setBounds(30, 0, 1200, 620);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcerrarMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.dispose();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelcerrarMouseClicked

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
                modelobusqueda.addRow(new Object[]{rs.getString(1), rs.getString(2)});
            }
            ps.close();
        } catch (SQLException ex) {
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_textfieldbuscarKeyReleased

    private void tablebuscarmaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebuscarmaterialMouseClicked
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        int cantidad;
        int tiporeq;
        String selecciontiporeq;
        if (evt.getClickCount() == 2) {
            modelo = (DefaultTableModel) tablebuscarmaterial.getModel();
            modelorequisicion = (DefaultTableModel) requisicion.tablerequisicion.getModel();
            seleccion = String.valueOf(modelo.getValueAt(tablebuscarmaterial.getSelectedRow(), 0));
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
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_tablebuscarmaterialMouseClicked

    private void botonaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonaceptarActionPerformed
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        DetalleRequisicion arrayreq;
        ArrayList<DetalleRequisicion> arrayrequisicion;
        arrayrequisicion = new ArrayList<>();
        arrayrequisicion.clear();
        int numregreq;
        String fecharequisicion;
        int idrequisicion;
        String codmaterial = null;
        String nommaterial;
        String medida;
        String selecciontipo;
        double precio;
        int cant;
        int tiporeq;
        int restaexist = 0;
        int cantstock = 0;
        String valida;
        int contvalida = 0;
        int contvalidares = 0;

        fecharequisicion = dateformat.format(requisicion.date.getDate());
        selecciontipo = (String) requisicion.jComboBoxtipo.getSelectedItem();
        numregreq = requisicion.tablerequisicion.getRowCount();
        modelorequisicion = (DefaultTableModel) requisicion.tablerequisicion.getModel();
    
        Object[] textoOpciones = {"Si", "No"};
        int opc = JOptionPane.showOptionDialog(null, "<html><h3 style=font-family:Verdana New;>¿Esta Seguro que Desea Guardar el movimiento?</h3></html>",
                null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, new Parametros().iconpregunta, textoOpciones, textoOpciones[0]);
        if (opc == 0) {
            
            if (numregreq > 0) {
                for (int i = 0; i < numregreq; i++) {
                    int j = 1;
                    valida = (String) modelorequisicion.getValueAt(i, 4);
                    if (ValidarDatos.isNumeric(valida)) {
                        contvalida = contvalida + j;
                    }
                }
                tiporeq = retornaidtiporequisicion(selecciontipo);
                if (tiporeq == 2){
                    try {
                        for (int i = 0; i < numregreq; i++) {
                            int j = 1;
                            codmaterial = (String) modelorequisicion.getValueAt(i, 0);
                            cant = Integer.parseInt((String) modelorequisicion.getValueAt(i, 4));
                            PreparedStatement ps = null;
                            ResultSet rs = null;
                            ps = con.EstablecerConexion().prepareStatement("EXEC spu_verificarestastock ?,?");
                            ps.setString(1, codmaterial);
                            ps.setInt(2, cant);
                            rs = ps.executeQuery();
                            while (rs.next()) {
                                restaexist = rs.getInt(1);
                                if (restaexist < 0){
                                    try{
                                       ps = con.EstablecerConexion().prepareStatement("EXEC spu_retornacantexistencia ?");
                                       ps.setString(1, codmaterial);
                                       rs = ps.executeQuery();
                                       while(rs.next()){
                                           cantstock = rs.getInt(1);
                                       }
                                    }catch(SQLException ex){
                                       error = ex.getMessage();
                                       JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                    } 
                                    JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>El Código: " + codmaterial + " solo tiene " + cantstock + " en existencia </h3></html>",
                                            null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia); 
                                }else{
                                    contvalidares = contvalidares + j;
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                    }
                }else{
                    contvalidares = numregreq;
                }            
                if (contvalida == numregreq) {
                    if(contvalidares == numregreq){
                        try {
                            PreparedStatement ps = null;
                            ResultSet rs = null;
                            ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevarequisicion ?,?,?");
                            ps.setString(1, fecharequisicion);
                            ps.setString(2, selecciontipo);
                            ps.setString(3, (String) requisicion.jComboBoxdpto.getSelectedItem());
                            rs = ps.executeQuery();
                            if (rs.next()) {
                                try {
                                    requisicion.labelnid.setText(rs.getString(1));
                                    for (int i = 0; i < numregreq; i++) {
                                        idrequisicion = Integer.parseInt(requisicion.labelnid.getText());
                                        codmaterial = (String) modelorequisicion.getValueAt(i, 0);
                                        nommaterial = (String) modelorequisicion.getValueAt(i, 1);
                                        medida = (String) modelorequisicion.getValueAt(i, 2);
                                        try {
                                            precio = Double.parseDouble((String) modelorequisicion.getValueAt(i, 3));
                                        } catch (NullPointerException ex) {
                                            precio = 0.00;
                                        }
                                        cant = Integer.parseInt((String) modelorequisicion.getValueAt(i, 4));
                                        arrayreq = new DetalleRequisicion();
                                        arrayreq.setidrequisicion(idrequisicion);
                                        arrayreq.setcodmaterial(codmaterial);
                                        arrayreq.setnommaterial(nommaterial);
                                        arrayreq.setmedida(medida);
                                        arrayreq.setprecio(precio);
                                        arrayreq.setcant(cant);
                                        arrayrequisicion.add(arrayreq);
                                    }
                                    try {
                                        ps = con.EstablecerConexion().prepareStatement("EXEC spu_nuevanotarequisicion ?,?,?");
                                        ps.setString(1, fecharequisicion);
                                        ps.setString(2, (String) requisicion.jComboBoxdpto.getSelectedItem());
                                        ps.setInt(3, Integer.parseInt(requisicion.labelnid.getText()));
                                        rs = ps.executeQuery();
                                        while (rs.next()) {
                                            //
                                        }
                                    } catch (java.sql.SQLException ex) {
                                        error = ex.getMessage();
                                        JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                    }
                                    for (int i = 0; i < arrayrequisicion.size(); i++) {
                                        try {
                                            ps = con.EstablecerConexion().prepareStatement("EXEC spu_guardadetallerequisicion ?,?,?,?,?,?");
                                            ps.setInt(1, arrayrequisicion.get(i).getidrequisicion());
                                            ps.setString(2, arrayrequisicion.get(i).getcodmaterial());
                                            ps.setString(3, arrayrequisicion.get(i).getnommaterial());
                                            ps.setString(4, arrayrequisicion.get(i).getmedida());
                                            ps.setDouble(5, arrayrequisicion.get(i).getprecio());
                                            ps.setInt(6, arrayrequisicion.get(i).getcant());
                                            rs = ps.executeQuery();
                                            while (rs.next()) {
                                                //
                                            }
                                        } catch (SQLException ex) {
                                            error = ex.getMessage();
                                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                        }
                                    }
                                    for (int i = 0; i < arrayrequisicion.size(); i++) {
                                        try {
                                            ps = con.EstablecerConexion().prepareStatement("spu_guardadetallesnotarequisicion ?,?,?,?");
                                            ps.setString(1, arrayrequisicion.get(i).getcodmaterial());
                                            ps.setString(2, arrayrequisicion.get(i).getmedida());
                                            ps.setDouble(3, arrayrequisicion.get(i).getprecio());
                                            ps.setInt(4, arrayrequisicion.get(i).getcant());
                                            rs = ps.executeQuery();
                                            while (rs.next()) {
                                                //
                                            }
                                        } catch (java.sql.SQLException ex) {
                                            error = ex.getMessage();
                                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                        }
                                    }
                                    JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Requisición Generada con Exito </h3></html>",
                                            null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconinformacion);
                                    tiporeq = retornaidtiporequisicion(selecciontipo);
                                            switch(tiporeq){
                                                case 1: try {
                                                            reportesalmacen.ReporteNotaRequisicionCompra(Integer.parseInt(requisicion.labelnid.getText()), Integer.parseInt(requisicion.labelnid.getText()));
                                                        } catch (JRException | IOException ex) {
                                                            Logger.getLogger(NuevaRequisicion.class.getName()).log(Level.SEVERE, null, ex);
                                                        }
                                                        break;
                                                case 2: try{
                                                            reportesalmacen.ReporteNotaRequisicionSalida(Integer.parseInt(requisicion.labelnid.getText()), Integer.parseInt(requisicion.labelnid.getText()));
                                                        }catch (JRException | IOException ex) {
                                                            Logger.getLogger(NuevaRequisicion.class.getName()).log(Level.SEVERE, null, ex);
                                                        }
                                                        break;
                                            }
                                } catch (SQLException ex) {
                                    error = ex.getMessage();
                                    JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                                }
                                ps.close();
                            }
                        } catch (SQLException ex) {
                            error = ex.getMessage();
                            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
                        }
                        modelorequisicion.setRowCount(0);
                        requisicion.labelnid.setText("");
                }    
                } else {
                    JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Ingrese una Cantidad Valida y Mayor a 0</h3></html>", null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia);
                }
            } else {
                JOptionPane.showMessageDialog(null, "<html><h3 style=font-family:Verdana;>Debe Agregar al Menos un Registro</h3></html>", null, JOptionPane.PLAIN_MESSAGE, new Parametros().iconadvertencia);
            }
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_botonaceptarActionPerformed

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
            java.util.logging.Logger.getLogger(NuevaRequisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaRequisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaRequisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaRequisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaRequisicion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonaceptar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelaceptar;
    private javax.swing.JLabel labelbuscar;
    private javax.swing.JLabel labelcerrar;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JPanel panelopciones;
    private Paneles.Requisicion requisicion;
    private javax.swing.JTable tablebuscarmaterial;
    private javax.swing.JTextField textfieldbuscar;
    // End of variables declaration//GEN-END:variables
}
