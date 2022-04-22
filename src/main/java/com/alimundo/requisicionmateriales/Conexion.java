/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alimundo.requisicionmateriales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author AdminSrv
 */
public class Conexion {
    public Connection EstablecerConexion() throws SQLException {
        
        Connection con = null;
        String error;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://AlimundoSRV:1433;databaseName=RegistroAlmacen;encrypt=false","AlmacenAdmin","AlimundoStore");
        }catch (ClassNotFoundException | SQLException ex){
            error = ex.getMessage();
           JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.PLAIN_MESSAGE);
        }   
        return con;
    }
}
