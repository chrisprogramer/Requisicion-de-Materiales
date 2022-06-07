/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alimundo.requisicionmateriales;

import java.awt.Choice;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Alimundo-SRV
 */
public class CargarComponentes {
    
    Conexion con = new Conexion();
    String error = "";
    
    public void llenarcombobox(JComboBox cbox, String sql){
       
       Conexion con = new Conexion();
       String error;
         try{
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps=con.EstablecerConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                cbox.addItem(rs.getString(1));
            }
            ps.close();
        }catch (SQLException ex){
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
        }
    }

    public void llenarjlista(DefaultListModel modelo,String query){

     try{
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                modelo.addElement(rs.getString(1));
            }ps.close();
        }catch (SQLException ex){
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
        }
    } 
    public void llenarchoice(Choice cbox, String sql){
       
       Conexion con = new Conexion();
       String error;
         try{
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps=con.EstablecerConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                cbox.addItem(rs.getString(1));
            }
            ps.close();
        }catch (SQLException ex){
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
        }
    }
    
    public void addCheckBox(int column, JTable table)
    {
        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
    }
    
    public void addComboBox(int column, JTable table,String sql)
    {
        JComboBox combobox = new JComboBox();
        this.llenarcombobox(combobox, sql);
        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(new DefaultCellEditor(combobox));
        tc.setCellRenderer(table.getDefaultRenderer(JComboBox.class));
        combobox.setSelectedIndex(0);
    }
    public void addTextField(JLabel etiqueta, String sql){
       Conexion con = new Conexion();
       String error;
         try{
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps=con.EstablecerConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                etiqueta.setText(rs.getString(1));
            }
            ps.close();
        }catch (SQLException ex){
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
        } 
    }
}    