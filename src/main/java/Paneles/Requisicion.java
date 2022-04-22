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

/**
 *
 * @author AdminSrv
 */
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
    Date fechahoy;
    String fechaformat = "dd/MM/yyyy";
    JTextFieldDateEditor editor;
    
    public Requisicion() {
        initComponents();
         modelorequisicion.setColumnIdentifiers(new Object[]{"","","","",""});

        if (tablerequisicion.getColumnModel().getColumnCount() > 0) {

            tablerequisicion.getColumnModel().getColumn(0).setHeaderValue("<html><h3 style=font-family:Verdana;>Codigo</h3></html>");
            tablerequisicion.getColumnModel().getColumn(0).setPreferredWidth(200);
            tablerequisicion.getColumnModel().getColumn(0).setMaxWidth(200);
            tablerequisicion.getColumnModel().getColumn(0).setResizable(false);
            
            tablerequisicion.getColumnModel().getColumn(1).setHeaderValue("<html><h3 style=font-family:Verdana;>Nombre Material</h3></html>");
            tablerequisicion.getColumnModel().getColumn(1).setPreferredWidth(700);
            tablerequisicion.getColumnModel().getColumn(1).setMaxWidth(700);
            tablerequisicion.getColumnModel().getColumn(1).setResizable(false);

            tablerequisicion.getColumnModel().getColumn(2).setHeaderValue("<html><h3 style=font-family:Verdana;>Medida</h3></html>");
            tablerequisicion.getColumnModel().getColumn(2).setPreferredWidth(180);
            tablerequisicion.getColumnModel().getColumn(2).setMaxWidth(180);
            tablerequisicion.getColumnModel().getColumn(2).setResizable(false);
            
            tablerequisicion.getColumnModel().getColumn(3).setHeaderValue("<html><h3 style=font-family:Verdana;>Precio</h3></html>");
            tablerequisicion.getColumnModel().getColumn(3).setPreferredWidth(130);
            tablerequisicion.getColumnModel().getColumn(3).setMaxWidth(130);
            tablerequisicion.getColumnModel().getColumn(3).setResizable(false);
            
            tablerequisicion.getColumnModel().getColumn(4).setHeaderValue("<html><h3 style=font-family:Verdana;>Cant.</h3></html>");
            tablerequisicion.getColumnModel().getColumn(4).setPreferredWidth(100);
            tablerequisicion.getColumnModel().getColumn(4).setMaxWidth(100);
            tablerequisicion.getColumnModel().getColumn(4).setResizable(false);
        }
        new CargarComponentes().llenarcombobox(jComboBoxdpto, "SELECT nom_departamento FROM Departamentos");
        tablerequisicion.getTableHeader().setReorderingAllowed(false);
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

        labeltitulo = new javax.swing.JLabel();
        labelnid = new javax.swing.JLabel();
        labelid = new javax.swing.JLabel();
        labeldepartamento = new javax.swing.JLabel();
        jComboBoxdpto = new javax.swing.JComboBox<>();
        labelfecha = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jScrollPane = new javax.swing.JScrollPane();
        tablerequisicion = new javax.swing.JTable();
        labelfondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        labeltitulo.setText("Nueva Requisición");
        add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 210, -1));

        labelnid.setBackground(new java.awt.Color(255, 255, 255));
        labelnid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelnid.setForeground(new java.awt.Color(255, 0, 0));
        labelnid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelnid.setEnabled(false);
        labelnid.setFocusable(false);
        labelnid.setOpaque(true);
        add(labelnid, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 50, 40));

        labelid.setBackground(new java.awt.Color(0, 153, 204));
        labelid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelid.setText("ID Requisición");
        labelid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelid.setOpaque(true);
        add(labelid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 46, -1, -1));

        labeldepartamento.setBackground(new java.awt.Color(0, 153, 204));
        labeldepartamento.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labeldepartamento.setText("Solicita");
        labeldepartamento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labeldepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labeldepartamento.setOpaque(true);
        add(labeldepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jComboBoxdpto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        add(jComboBoxdpto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 260, 30));

        labelfecha.setBackground(new java.awt.Color(0, 153, 204));
        labelfecha.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelfecha.setText("Fecha de Solicitud");
        labelfecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelfecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelfecha.setOpaque(true);
        add(labelfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        date.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        date.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        date.setOpaque(false);
        add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 210, 30));

        tablerequisicion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tablerequisicion.setModel(modelorequisicion);
        tablerequisicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablerequisicionKeyPressed(evt);
            }
        });
        jScrollPane.setViewportView(tablerequisicion);

        add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 720, 350));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 0, 780, 477));
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
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel labeldepartamento;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labelfondo;
    private javax.swing.JLabel labelid;
    public javax.swing.JLabel labelnid;
    private javax.swing.JLabel labeltitulo;
    public javax.swing.JTable tablerequisicion;
    // End of variables declaration//GEN-END:variables
}
