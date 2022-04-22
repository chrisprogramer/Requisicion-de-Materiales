/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alimundo.requisicionmateriales;

/**
 *
 * @author AdminSrv
 */
public class DetalleRequisicion {
        
    private int idrequisicion;
    private String codmaterial;
    private String nommaterial;
    private String medida;
    private double precio;
    private int cant;
    
    public void setidrequisicion (int idrequisicion){
       this.idrequisicion = idrequisicion;
    }
    
    public int getidrequisicion() {
        return idrequisicion;
    }
    
    public void setcodmaterial(String codmaterial) {
        this.codmaterial = codmaterial;
    }

    public String getcodmaterial() {
        return codmaterial;
    }
    
    public void setnommaterial(String nommaterial) {
        this.nommaterial = nommaterial;
    }

    public String getnommaterial() {
        return nommaterial;
    }
    
    public void setmedida(String medida) {
        this.medida = medida;
    }

    public String getmedida() {
        return medida;
    }
    
    public void setcant (int cant) {
        this.cant = cant;
    }

    public int getcant() {
        return cant;
    }
    
    public void setprecio(double precio) {
        this.precio = precio;
    }

    public double getprecio() {
        return precio;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();                                                                   
        sb.append("\nidrequisicion: ");
        sb.append(idrequisicion);
        sb.append("\ncodmaterial: ");
        sb.append(codmaterial);
        sb.append("\nnommateria: ");
        sb.append(nommaterial);
        sb.append("\nmedida: ");
        sb.append(medida);
        sb.append("\ncant: ");
        sb.append(cant);
        sb.append("\nprecio: ");
        sb.append(precio);
        return sb.toString();
    } 
}
