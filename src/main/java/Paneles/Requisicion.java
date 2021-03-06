/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import com.alimundo.requisicionmateriales.CargarComponentes;
import com.alimundo.requisicionmateriales.Conexion;
import com.alimundo.requisicionmateriales.Parametros;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Requisicion extends javax.swing.JPanel {

    DefaultTableModel modelorequisicion = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int filas, int columnas){
            if (columnas <= 3){
                return false;
            }else return true;
        } 
    };
    
    Conexion con = new Conexion();
    String error;
    String fechaformat = "dd/MM/yyyy";
    Date fechahoy;
    JTextFieldDateEditor editor;
       
    public Requisicion() {
        initComponents();
        modelorequisicion.setColumnIdentifiers(new Object[]{"","","","",""});

        if (tablerequisicion.getColumnModel().getColumnCount() > 0) {

            tablerequisicion.getColumnModel().getColumn(0).setHeaderValue("<html><h3 style=font-family:Verdana;>Codigo</h3></html>");
            tablerequisicion.getColumnModel().getColumn(0).setPreferredWidth(150);
            tablerequisicion.getColumnModel().getColumn(0).setMaxWidth(150);
            tablerequisicion.getColumnModel().getColumn(0).setResizable(false);
            
            tablerequisicion.getColumnModel().getColumn(1).setHeaderValue("<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>");
            tablerequisicion.getColumnModel().getColumn(1).setPreferredWidth(400);
            tablerequisicion.getColumnModel().getColumn(1).setMaxWidth(400);
            tablerequisicion.getColumnModel().getColumn(1).setResizable(false);

            tablerequisicion.getColumnModel().getColumn(2).setHeaderValue("<html><h3 style=font-family:Verdana;>Medida</h3></html>");
            tablerequisicion.getColumnModel().getColumn(2).setPreferredWidth(200);
            tablerequisicion.getColumnModel().getColumn(2).setMaxWidth(150);
            tablerequisicion.getColumnModel().getColumn(2).setResizable(false);
            
            tablerequisicion.getColumnModel().getColumn(3).setHeaderValue("<html><h3 style=font-family:Verdana;>Precio</h3></html>");
            tablerequisicion.getColumnModel().getColumn(3).setPreferredWidth(150);
            tablerequisicion.getColumnModel().getColumn(3).setMaxWidth(150);
            tablerequisicion.getColumnModel().getColumn(3).setResizable(false);
            
            tablerequisicion.getColumnModel().getColumn(4).setHeaderValue("<html><h3 style=font-family:Verdana;>Cant.</h3></html>");
            tablerequisicion.getColumnModel().getColumn(4).setPreferredWidth(100);
            tablerequisicion.getColumnModel().getColumn(4).setMaxWidth(100);
            tablerequisicion.getColumnModel().getColumn(4).setResizable(false);
        }
        new CargarComponentes().llenarcombobox(jComboBoxdpto, "SELECT nom_departamento FROM Departamentos");
        new CargarComponentes().llenarcombobox(jComboBoxtipo,"SELECT Descripcion FROM TipoRequisicion");
        tablerequisicion.getTableHeader().setReorderingAllowed(false);
        tablerequisicion.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        fechahoy = new Date();
        this.date.setDateFormatString(fechaformat);
        this.date.setDate(fechahoy);
        editor = (JTextFieldDateEditor) date.getDateEditor();
        editor.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelnid = new javax.swing.JLabel();
        labelid = new javax.swing.JLabel();
        labeldepartamento = new javax.swing.JLabel();
        labeltipo = new javax.swing.JLabel();
        jComboBoxdpto = new javax.swing.JComboBox<>();
        jComboBoxtipo = new javax.swing.JComboBox<>();
        labelfecha = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jScrollPane = new javax.swing.JScrollPane();
        tablerequisicion = new javax.swing.JTable();
        labelfondo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(571, 360));
        setMinimumSize(new java.awt.Dimension(571, 360));
        setPreferredSize(new java.awt.Dimension(571, 360));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelnid.setBackground(new java.awt.Color(255, 255, 255));
        labelnid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelnid.setForeground(new java.awt.Color(255, 0, 0));
        labelnid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelnid.setEnabled(false);
        labelnid.setFocusable(false);
        labelnid.setOpaque(true);
        add(labelnid, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 50, 40));

        labelid.setBackground(new java.awt.Color(255, 255, 255));
        labelid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelid.setText("ID Requisici??n");
        labelid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(labelid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        labeldepartamento.setBackground(new java.awt.Color(255, 255, 255));
        labeldepartamento.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labeldepartamento.setText("Solicita");
        labeldepartamento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labeldepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(labeldepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        labeltipo.setBackground(new java.awt.Color(255, 255, 255));
        labeltipo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labeltipo.setText(" Tipo de Requisici??n");
        labeltipo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(labeltipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        jComboBoxdpto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        add(jComboBoxdpto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 260, 30));

        jComboBoxtipo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        add(jComboBoxtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 260, 30));

        labelfecha.setBackground(new java.awt.Color(255, 255, 255));
        labelfecha.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelfecha.setText("Fecha de Solicitud");
        labelfecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelfecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(labelfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        date.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        date.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        date.setOpaque(false);
        add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 210, 30));

        tablerequisicion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tablerequisicion.setModel(modelorequisicion);
        tablerequisicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablerequisicionKeyPressed(evt);
            }
        });
        jScrollPane.setViewportView(tablerequisicion);

        add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 570, 190));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 571, 360));
    }// </editor-fold>//GEN-END:initComponents

    private void tablerequisicionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablerequisicionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            if (tablerequisicion.getSelectedRowCount() > 0) {
                modelorequisicion.removeRow(tablerequisicion.getSelectedRow());
            }
            else{
                JOptionPane.showMessageDialog(null,"<html><h3 style=font-family:Verdana;>Debe Seleccionar un Registro</h3></html>",null,JOptionPane.PLAIN_MESSAGE,new Parametros().iconadvertencia);
            }
        }
    }//GEN-LAST:event_tablerequisicionKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.toedter.calendar.JDateChooser date;
    public javax.swing.JComboBox<String> jComboBoxdpto;
    public javax.swing.JComboBox<String> jComboBoxtipo;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel labeldepartamento;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelid;
    public javax.swing.JLabel labelnid;
    private javax.swing.JLabel labeltipo;
    public javax.swing.JTable tablerequisicion;
    // End of variables declaration//GEN-END:variables
}
