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
public class Reloj extends JLabel implements Runnable{

 private String hora, minutos, segundos = "";
    Thread hilo;
    private Calendar Calendario = new GregorianCalendar();
    
    public Reloj(int x, int y, int p1, int p2){
 
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
                setText(hora + ":" + minutos + ":" + segundos);
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                System.out.println(ex);
            }
        }
    }
  
    public void Actualiza(){
    
        Date fechahoraactual = new Date();
        Calendario.setTime(fechahoraactual);
        
        hora = String.valueOf(Calendario.get(Calendar.HOUR_OF_DAY));
        minutos = (Calendario.get(Calendar.MINUTE))> 9 ? "" + Calendario.get(Calendar.MINUTE) : "0" + Calendario.get(Calendar.MINUTE);
        segundos = (Calendario.get(Calendar.SECOND))> 9 ? "" + Calendario.get(Calendar.SECOND) : "0" + Calendario.get(Calendar.SECOND);
   
    } 
    
}
