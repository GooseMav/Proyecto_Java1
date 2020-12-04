/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariolagos;

import java.util.ArrayList;

/**
 *
 * @author marix
 */
public class Manejadora {
    
    private ArrayList<Profesor>profesores=new ArrayList<Profesor>();

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }
    
    public int buscarProfesor(String rut)
    {
        for (int i = 0; i < profesores.size(); i++) {
            if(profesores.get(i).getRut().compareToIgnoreCase(rut)==0)
                return i;
        }
        return -1;
    }
    //--------
    
    public String ingresarProfesor(Profesor profe)
    {
        if(buscarProfesor(profe.getRut())==-1)
        {
            profesores.add(profe);
            return "Profesor se ingresado exitosamente!";
        }
        return "Profesor ya existe!";
    }
    
    //-----------------
    
    public String eliminarProfesor(String rut)
    {
        if(buscarProfesor(rut)==-1)
            return "No se pudo eliminar, Profesor no encontrado";
        profesores.remove(buscarProfesor(rut));
        return "profesor eliminado!";
    }
    
    //-----------------
    
    public String modificarProfesor(Profesor profe)
    {
        int pos=buscarProfesor(profe.getRut());
        if(pos==-1)
            return "No se pudo Modificar, Profesor no encontrado!";
        profesores.set(pos, profe);
        return "Profesor modificado!";
    }
    
    
}
