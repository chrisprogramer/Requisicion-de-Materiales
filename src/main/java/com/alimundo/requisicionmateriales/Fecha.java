/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alimundo.requisicionmateriales;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
/**
 *
 * @author Alimundo-SRV
 */
public class Fecha extends JLabel implements Runnable {
    private String dia, mes, mesc, ano = "";
    Thread hilo;
    private final Calendar Calendario = new GregorianCalendar();
    String error;
    
    public Fecha(int x, int y, int p1, int p2){
        setBounds(x,y,p1,p2);
        hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        Thread hilo2 = new Thread().currentThread();
        
        while (hilo2 == hilo){
            try{
                Actualiza();
                int mesI;
                mesI = Integer.valueOf(mes)+1;
                mesc = "0"+String.valueOf(mesI);
                setText(dia + "/" + mesc + "/" + ano);
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                error = ex.getMessage();
                //JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.PLAIN_MESSAGE,new Parametros().iconerror);
            }
        }
    }
  
    public void Actualiza(){
        Date fechahoraactual = new Date();
        Calendario.setTime(fechahoraactual);

        dia = (Calendario.get(Calendar.DATE))> 9 ? "" + Calendario.get(Calendar.DATE) : "0" + Calendario.get(Calendar.DATE);
        mes = (Calendario.get(Calendar.MONTH))> 9 ? "" + Calendario.get(Calendar.MONTH) : "0" + Calendario.get(Calendar.MONTH);
        ano = (Calendario.get(Calendar.YEAR))> 9 ? "" + Calendario.get(Calendar.YEAR) : "0" + Calendario.get(Calendar.YEAR);
    } 
}
