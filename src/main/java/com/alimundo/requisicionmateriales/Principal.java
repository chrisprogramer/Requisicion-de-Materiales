/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.alimundo.requisicionmateriales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author AdminSrv
 */
public class Principal extends javax.swing.JFrame {

    String letra = "Verdana";
    Image icono;
    Conexion con = new Conexion();
    String error;
    Menus BarMenu;
    JMenuBar mainmenu;
    public static int idreq;
    public static int botonpress;
  
    public Principal() {
        
        this.BarMenu = new Menus();
        UIManager.put("Button.font", new Font("Verdana",Font.BOLD,14));
        UIManager.put("Button.background", Color.WHITE);
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
        
        Reloj reloj = new Reloj(655,463,140,20);
        reloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reloj.setFont(new java.awt.Font(letra,1,16));
        add(reloj);
        
        Fecha fecha = new Fecha(10,463,180,20);
        fecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fecha.setFont(new java.awt.Font(letra,1,16));
        add(fecha); 
        
        initComponents();
        setTitle(" MODULO REQUISICIÓN");
        setSize(799, 505);
        setResizable(false);
        Point relative;
        setLocationRelativeTo(null);
        
        icono = new Parametros().getIconImagePrincipalForm();
        setIconImage(icono);
        //mainmenu = BarMenu.CreaMenuPrincipal();
        //mainmenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //mainmenu.setBackground(Color.red);
        //setJMenuBar(mainmenu);
        
         try{
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_verBD");
            rs = ps.executeQuery();
            while (rs.next()){
                this.labelnbd.setText(rs.getString(1));
            }ps.close();
            ps = con.EstablecerConexion().prepareStatement("EXEC spu_nomempresa");
            rs = ps.executeQuery();
            while (rs.next()){
                this.labelnomempresa.setText(rs.getString(1));
            }ps.close();
        }catch(SQLException ex){
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
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

        labelicono = new javax.swing.JLabel();
        labeltitulo = new javax.swing.JLabel();
        botonsalir = new javax.swing.JButton();
        botonnuevarequisicion = new javax.swing.JButton();
        botoneditarequisicion = new javax.swing.JButton();
        botoncancelarrequisicion = new javax.swing.JButton();
        botonayuda = new javax.swing.JButton();
        labelempresa = new javax.swing.JLabel();
        verbd = new javax.swing.JLabel();
        labelnbd = new javax.swing.JLabel();
        labelnomempresa = new javax.swing.JLabel();
        labellogo = new javax.swing.JLabel();
        labelsalir = new javax.swing.JLabel();
        labelcancelar = new javax.swing.JLabel();
        labelmodificar = new javax.swing.JLabel();
        labelnuevo = new javax.swing.JLabel();
        labelinfo = new javax.swing.JLabel();
        panelopciones = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelicono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/clipboard_paper_file_correct_done_list_document_icon_219488.png"))); // NOI18N
        getContentPane().add(labelicono, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 47));

        labeltitulo.setBackground(new java.awt.Color(255, 255, 255));
        labeltitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        labeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltitulo.setText("MODULO REQUISICIÓN DE MATERIALES");
        labeltitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labeltitulo.setOpaque(true);
        getContentPane().add(labeltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 45));

        botonsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/power_on_off_switch_exit_icon_141963.png"))); // NOI18N
        botonsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonsalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 47, 60, 60));

        botonnuevarequisicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/add_paper_plus_insert_append_incorporate_icon_141955.png"))); // NOI18N
        botonnuevarequisicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonnuevarequisicionActionPerformed(evt);
            }
        });
        getContentPane().add(botonnuevarequisicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 47, 60, 60));

        botoneditarequisicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/edit_pencil_paper_modify_write_icon_141958.png"))); // NOI18N
        botoneditarequisicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoneditarequisicionActionPerformed(evt);
            }
        });
        getContentPane().add(botoneditarequisicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 47, 60, 60));

        botoncancelarrequisicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/delete_cross_paper_remove_erase_undo_icon_141956.png"))); // NOI18N
        botoncancelarrequisicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncancelarrequisicionActionPerformed(evt);
            }
        });
        getContentPane().add(botoncancelarrequisicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 47, 60, 60));

        botonayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngs48X48/informationwebcircularbuttonsymbol_79860.png"))); // NOI18N
        botonayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonayudaActionPerformed(evt);
            }
        });
        getContentPane().add(botonayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 47, 60, 60));

        labelempresa.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        labelempresa.setText("Empresa:");
        getContentPane().add(labelempresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 463, -1, -1));

        verbd.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        verbd.setText("Ver. Base de Datos:");
        getContentPane().add(verbd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 463, -1, -1));

        labelnbd.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        labelnbd.setPreferredSize(new java.awt.Dimension(10, 10));
        getContentPane().add(labelnbd, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 463, 80, 20));

        labelnomempresa.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        labelnomempresa.setPreferredSize(new java.awt.Dimension(10, 10));
        getContentPane().add(labelnomempresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 463, 140, 20));

        labellogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO ALIMUNDO PEQUE.png"))); // NOI18N
        getContentPane().add(labellogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 420, 110));

        labelsalir.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        labelsalir.setText("Salir");
        getContentPane().add(labelsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 110, -1, -1));

        labelcancelar.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        labelcancelar.setText("Cancelar");
        getContentPane().add(labelcancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 110, -1, -1));

        labelmodificar.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        labelmodificar.setText("Modificar");
        getContentPane().add(labelmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 110, -1, -1));

        labelnuevo.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        labelnuevo.setText("Nueva");
        getContentPane().add(labelnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 110, -1, -1));

        labelinfo.setFont(new java.awt.Font("Verdana", 0, 9)); // NOI18N
        labelinfo.setText("Información");
        getContentPane().add(labelinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        panelopciones.setBackground(new java.awt.Color(0, 102, 153));
        panelopciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelopciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 30, 470));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 800, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 800, 10));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        fondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 799, 494));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonsalirActionPerformed
        this.setCursor(new Cursor (Cursor.WAIT_CURSOR));
        Object[] textoOpciones = {"Si","No"};
        int opc = JOptionPane.showOptionDialog(this,"<html><h3 style=font-family:Verdana;>¿Desea salir del Modulo Requisición?</h3></html>",
            "",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, new Parametros().iconpregunta, textoOpciones, textoOpciones[0]);
        if (opc == 0)
            System.exit(0);
        this.setCursor(new Cursor (Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonsalirActionPerformed

    private void botonnuevarequisicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonnuevarequisicionActionPerformed
        new Principal().setCursor(new Cursor(Cursor.WAIT_CURSOR));
        new NuevaRequisicion().setVisible(true);
        new Principal().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonnuevarequisicionActionPerformed

    private void botonayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonayudaActionPerformed
        new Principal().setCursor(new Cursor(Cursor.WAIT_CURSOR));
        new Ayuda().setVisible(true);
        new Principal().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botonayudaActionPerformed

    private void botoneditarequisicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneditarequisicionActionPerformed
        new Principal().setCursor(new Cursor(Cursor.WAIT_CURSOR));
        Principal.botonpress = 3;
        new EditarRequisicion().setVisible(true);
        new Principal().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botoneditarequisicionActionPerformed

    private void botoncancelarrequisicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncancelarrequisicionActionPerformed
        new Principal().setCursor(new Cursor(Cursor.WAIT_CURSOR));
        Principal.botonpress = 4;
        new EditarRequisicion().setVisible(true);
        new Principal().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_botoncancelarrequisicionActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonayuda;
    private javax.swing.JButton botoncancelarrequisicion;
    private javax.swing.JButton botoneditarequisicion;
    private javax.swing.JButton botonnuevarequisicion;
    private javax.swing.JButton botonsalir;
    private javax.swing.JLabel fondo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelcancelar;
    private javax.swing.JLabel labelempresa;
    private javax.swing.JLabel labelicono;
    private javax.swing.JLabel labelinfo;
    private javax.swing.JLabel labellogo;
    private javax.swing.JLabel labelmodificar;
    private javax.swing.JLabel labelnbd;
    private javax.swing.JLabel labelnomempresa;
    private javax.swing.JLabel labelnuevo;
    private javax.swing.JLabel labelsalir;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JPanel panelopciones;
    private javax.swing.JLabel verbd;
    // End of variables declaration//GEN-END:variables
}
