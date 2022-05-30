/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import com.alimundo.requisicionmateriales.Parametros;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 *
 * @author Alimundo-SRV
 */
public class ReportesDB {
 
    String ruta = null;
    String error;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Connection EstablecerConexion() throws SQLException {
       Connection con = null; 
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://AlimundoSRV:1433;databaseName=RegistroAlmacen","AlmacenAdmin","AlimundoStore");
        }catch (ClassNotFoundException | SQLException ex){
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
        }   
        return con;
    }
    
    public String RetornaRuta(){
        try{
           ps = this.EstablecerConexion().prepareStatement("EXEC spu_devuelverutaRpts"); 
           rs = ps.executeQuery();
            while (rs.next()){
                ruta = (rs.getString(1));
            }ps.close();
        }catch(SQLException ex){
            error = ex.getMessage();
            JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror); 
        }
        return ruta;
    }

    public void ExportarPDF(JasperPrint reporte, String nombrerpt, int numnota) throws JRException{
        String rutafinal = null;
        rutafinal = this.RetornaRuta();
        System.out.println(rutafinal);
        File directorio = new File(rutafinal);
        
        if (directorio.isDirectory()){
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(reporte));
            try{
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(rutafinal + nombrerpt + " " + numnota + ".pdf"));    
                SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
                exporter.setConfiguration(configuration);
                exporter.exportReport();
            }catch(JRRuntimeException ex){
                JOptionPane.showMessageDialog(null,"<html><h2 style=font-family:Courier New;>EL ARCHIVO ESTA SIENDO USADO POR OTRO PROGRAMA..!!</h2></html>",
                    "ERROR...",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"<html><h2 style=font-family:Courier New;>LA RUTA DEL DIRECTORIO NO EXISTE..!!</h2></html>",
                    "ERROR...",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
        }    
    }
    public void ExportarPDF(JasperPrint reporte, String nombrerpt) throws JRException{
        String rutafinal = null;
        rutafinal = this.RetornaRuta();
        File directorio = new File(rutafinal);
        
        if (directorio.isDirectory()){
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(reporte));
            try{
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(rutafinal + nombrerpt + ".pdf"));    
                SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
                exporter.setConfiguration(configuration);
                exporter.exportReport();
            }catch(JRRuntimeException ex){
                JOptionPane.showMessageDialog(null,"<html><h2 style=font-family:Courier New;>EL ARCHIVO ESTA SIENDO USADO POR OTRO PROGRAMA..!!</h2></html>",
                    "ERROR...",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"<html><h2 style=font-family:Courier New;>LA RUTA DEL DIRECTORIO NO EXISTE..!!</h2></html>",
                    "ERROR...",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
        }
    }    

    public void AbrirPDF(String ruta) throws IOException{
        try {
        File path = new File (ruta);
        Desktop.getDesktop().open(path);
        }catch (IOException ex) {
           error = ex.getMessage();
           JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);  
        } 
    }
    
    public void ReporteNotaRequisicionCompra(int idnotarequisicion, int numnota) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("idnotarequisicion", idnotarequisicion);
        String nombrearch = "Nota de Requisicion Compra Material";
        String rutacompleta;

        try {
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport("C:\\Users\\AdminSrv\\Documents\\NetBeansProjects\\RequisicionMateriales\\src\\main\\java\\Reportes\\"
                     + nombrearch + ".jasper", parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch, numnota);
            rutacompleta = ruta + nombrearch + " " + numnota + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void ReporteNotaRequisicionSalida(int idnotarequisicion, int numnota) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("idnotarequisicion", idnotarequisicion);
        String nombrearch = "Nota de Requisicion Salida Material";
        String rutacompleta;

        try {
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport("C:\\Users\\AdminSrv\\Documents\\NetBeansProjects\\RequisicionMateriales\\src\\main\\java\\Reportes\\"
                     + nombrearch + ".jasper", parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch, numnota);
            rutacompleta = ruta + nombrearch + " " + numnota + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
     public void ReporteNotaRequisicionSalida(int idnotarequisicion) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("idnotarequisicion", idnotarequisicion);
        String nombrearch = "Sub_ReporteRequisicionSalida";
        String rutacompleta;

        try {
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                     + nombrearch + ".jasper", parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch, idnotarequisicion);
            rutacompleta = ruta + nombrearch + " " + idnotarequisicion + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }
    public void ReporteNotaRequisicionCompra(int idnotarequisicion) throws SQLException, JRException, IOException {
        Connection con = this.EstablecerConexion();
        Map<String, Object> parametro = new HashMap();
        parametro.put("idnotarequisicion", idnotarequisicion);
        String nombrearch = "Sub_ReporteRequisicionCompra";
        String rutacompleta;

        try {
            JasperPrint jasperPrintWindow = JasperFillManager.fillReport("\\\\192.168.1.100\\Reportes\\"
                     + nombrearch + ".jasper", parametro, con);
            this.ExportarPDF(jasperPrintWindow, nombrearch, idnotarequisicion);
            rutacompleta = ruta + nombrearch + " " + idnotarequisicion + ".pdf";
            this.AbrirPDF(rutacompleta);
        } catch (JRException ex) {
             error = ex.getMessage();
            JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.PLAIN_MESSAGE, new Parametros().iconerror);
        }
    }  
}
