/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariolagos;

import javax.swing.JOptionPane;

/**
 *
 * @author marix
 */
public class Profesor {
    
    public String rut;
    public String nombre;
    public String grado;
    public boolean certificado;
    
    //------

    public Profesor(String rut, String nombre, String grado, boolean certificado) {
        this.rut = rut;
        this.nombre = nombre;
        setGrado(grado);
        this.certificado = certificado;
    }
    //------

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGrado() {
        return grado;
    }

    public boolean isCertificado() {
        return certificado;
    }
    
    //--------

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGrado(String grado) {
         if (grado.compareToIgnoreCase("T")==0 || grado.compareToIgnoreCase("L")==0 || grado.compareToIgnoreCase("M")==0 || grado.compareToIgnoreCase("D")==0)
         {
            this.grado = grado;
         }
    }

    public void setCertificado(boolean certificado) {
        this.certificado = certificado;
    }
    
    //---------
    
    public void certiAumento(){
        if(certificado)
        {
            
        }
    }
    
    public int ValorBono(){
        int valor = 0;
        if (grado.compareToIgnoreCase("T")==0)
        {
            valor= 250000;
        }
        if (grado.compareToIgnoreCase("L")==0)
        {
            valor= 225000;
        }
        if (grado.compareToIgnoreCase("M")==0)
        {
            valor= 200000;
        }
        if(grado.compareToIgnoreCase("D")==0)
        {
            valor= 175000;
        }
        if (tagCertificado().compareToIgnoreCase("Si") == 0)
        {
            
        }
        
        if (tagCertificado().compareToIgnoreCase("No") == 0)
        {
            
        }
      return valor;  
    }
    public String tagCertificado()
    {
        if (certificado)
        {
            return "Si";
        }
        return "No";
    }

    
}
