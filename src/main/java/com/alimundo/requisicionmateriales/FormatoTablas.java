/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alimundo.requisicionmateriales;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.DateFormatter;

public class FormatoTablas {

    String error;
    Conexion con = new Conexion();
    DefaultTableCellRenderer cellRendereraligcenter = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRendereraligright = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRendereraligleft = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRendererformatfloat = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRendererformatcolorfont = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRendererformatfont = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRendererformathour = new DefaultTableCellRenderer();
    public final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
    public final SimpleDateFormat fechaformat = new SimpleDateFormat("dd/MM/yyyy");
    public final DateFormatter timeformat = new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT));
    
    public FormatoTablas(){
        
        cellRendereraligcenter.setVerticalAlignment(SwingConstants.CENTER);
        cellRendereraligright.setHorizontalAlignment(SwingConstants.RIGHT);
        cellRendereraligleft.setHorizontalAlignment(SwingConstants.LEFT);
        cellRendererformatcolorfont.setForeground(Color.WHITE);
        cellRendererformatfont.setFont(new Font("Consolas", Font.BOLD,14));
    }

    public String FormatoHora(String hora){
        String hhparttexto = "";
        String horaformateada = "";
        int horaconvertida;
        int hhpartnum;
        
        if(hora != null){
            hhparttexto = hora.substring(0, 2);
            hhpartnum = Integer.parseInt(hhparttexto);

            if (hhpartnum <= 11)
                horaformateada = hora.substring(0, 5) + " AM";
            else if (hhpartnum == 12)
                horaformateada = hora.substring(0, 5) + " M";
            else if (hhpartnum > 12){
                horaconvertida = hhpartnum - 12;
                horaformateada = String.format("%02d",horaconvertida) + hora.substring(2, 5) + " PM";
            }    
            return horaformateada;
        }    
        else
            return null;
    }

    Object decimalFormat(String montodoublestring) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addTextField(int column, JTable table)
    {
        JTextField textfield = new JTextField();
        TextAutoCompleter ac;
        ac = new TextAutoCompleter(textfield);
        try{    
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.EstablecerConexion().prepareStatement("SELECT nom_material FROM Materiales");
            rs = ps.executeQuery();
            while (rs.next()){
                ac.addItem(rs.getString(1));
            }
            ps.close();
        }catch (SQLException ex){
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
        }
        //new CargarComponentes().llenarcombobox(combobox, "SELECT nom_material FROM Materiales");
        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(new DefaultCellEditor(textfield));
        tc.setCellRenderer(table.getDefaultRenderer(JTextField.class));
    }
}
