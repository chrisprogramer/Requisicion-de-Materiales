/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alimundo.requisicionmateriales;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.DateFormatter;

/**
 *
 * @author Alimundo-SRV
 */

public class FormatoTablas {

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
}
