package com.alimundo.requisicionmateriales;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class Menus {
    
    String letramenus = "Verdana";
    int tamnnoletramenus = 14;
    int tamnnoletraopciones = 14;
    int negritamenus = 1;
    public JMenuBar MenuPrincipal;
    Conexion con = new Conexion();
    String error;
 
    public JMenuBar CreaMenuPrincipal(){
        
        JMenu Archivo,Requisicion,Ayuda;
        JMenuItem Salir;
        JMenuItem NuevaRequisicion,ConsultarRequisicion;
        JMenuItem Acerca_de;
      
        MenuPrincipal = new javax.swing.JMenuBar();
 
       /** Barra Menus **/
            
        Archivo = new javax.swing.JMenu("Archivo");
        Archivo.setFont(new java.awt.Font(letramenus,negritamenus,tamnnoletramenus));
        //Archivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/64x64/folder_blue_9791.png")));
        Requisicion = new javax.swing.JMenu("Requisición");
        Requisicion.setFont(new java.awt.Font(letramenus,negritamenus,tamnnoletramenus));
        //Requisicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/64x64/contacts_icon-icons.com_75232.png")));
        Ayuda = new javax.swing.JMenu("Ayuda");
        Ayuda.setFont(new java.awt.Font(letramenus,negritamenus,tamnnoletramenus));
        //Ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/64x64/help_question_16768.png")));
        
        /** Items Barra de Menus **/
        
        /** Menu Archivo**/
        Salir = new javax.swing.JMenuItem("Salir del Modulo");
        Salir.setFont(new java.awt.Font(letramenus,negritamenus,tamnnoletraopciones));
        //Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/64x64/close_delete_delete_theaction_theoutput_10252.png")));
        
        /** Menu Requisición**/
        NuevaRequisicion = new javax.swing.JMenuItem("Generar Nueva Requisición");
        NuevaRequisicion.setFont(new java.awt.Font(letramenus,negritamenus,tamnnoletraopciones));
        //NuevaRequisicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/64x64/keepintouchwiththenew_1216.png")));
        ConsultarRequisicion = new javax.swing.JMenuItem("Consultar Requisición");
        ConsultarRequisicion.setFont(new java.awt.Font(letramenus,negritamenus,tamnnoletraopciones));
        //ConsultarRequisicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/64x64/filesystems_contact_kde_659.png")));
        
        /** Menu Ayuda **/
        Acerca_de = new javax.swing.JMenuItem("Acerca de");
        Acerca_de.setFont(new java.awt.Font(letramenus,negritamenus,tamnnoletraopciones));
        //Acerca_de.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/64x64/info.png")));
        
        MenuPrincipal.add(Archivo);
        Archivo.add(Salir);
        MenuPrincipal.add(Requisicion);
        Requisicion.add(NuevaRequisicion);
        Requisicion.add(new JSeparator());
        Requisicion.add(ConsultarRequisicion);
        MenuPrincipal.add(Ayuda);
        Ayuda.add(Acerca_de);

        Salir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evento) {
            System.exit(0);
         }
        });
        
        NuevaRequisicion.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evento) {
            new Principal().setCursor(new Cursor (Cursor.WAIT_CURSOR));
            new NuevaRequisicion().setVisible(true);
            new Principal().setCursor(new Cursor (Cursor.DEFAULT_CURSOR));
        }
        });
        return MenuPrincipal;
    }
}  
        
        
        
        
        
        
        
 
        
       
 
