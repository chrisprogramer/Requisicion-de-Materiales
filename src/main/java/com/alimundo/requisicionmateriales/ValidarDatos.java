/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alimundo.requisicionmateriales;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;



public class ValidarDatos {

    public static boolean isNumeric(String cadena) {
        int numero; 
        try {
            numero = Integer.parseInt(cadena);
            return numero > 0;
        }catch (NumberFormatException nfe) {
            return false;
        }
    }
    
     public Boolean ValidaCantidad(int cant) {
        return cant > 0;
    }
     
    public boolean vacio(String campo) {
        try{
            return campo.length() > 0;
        }catch(java.lang.NullPointerException ex){
             return false;    
        }    
    }
    
    public boolean vacio(String campo1, String campo2) {
        return campo1.length() > 0 && campo2.length() > 0;
    }
    
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}
