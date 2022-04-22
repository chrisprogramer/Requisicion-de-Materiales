/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alimundo.requisicionmateriales;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Parametros {
    
    String errorsql;
    
    public Image getIconImagePrincipalForm(){
        Image refValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/requerido.png"));
        return refValue;
    }

    URL info = getClass().getResource("/pngs96X96/dialog-information_36228.png");
    URL error = getClass().getResource("/pngs96X96/dialog-error_36230.png");
    URL advertencia = getClass().getResource("/pngs96X96/dialog-warning_36224.png");
    URL pregunta = getClass().getResource("/pngs96X96/dialog-question_36226.png");

    public final Icon iconinformacion = new ImageIcon(info);
    public final Icon iconerror = new ImageIcon(error);
    public final Icon iconadvertencia = new ImageIcon(advertencia);
    public final Icon iconpregunta = new ImageIcon(pregunta);
    String letra = "Verdana";
}
