/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariolagos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marix
 */
public class ProfesorDAO {
    
    
    
     public boolean ingresarProfesor (Profesor profe)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            String query ="insert into profesor (nombre,rut,grado,certificado) values (?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            
            ps.setString(1, profe.getNombre());
            ps.setString(2, profe.getRut());
            ps.setString(3, profe.getGrado());
            ps.setBoolean(4, profe.isCertificado());
            
            resultado=ps.executeUpdate()==1;
            
            ps.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
        
    }
    
     //-------
     public Profesor buscarProfesor(String rut)
    {
        Profesor profe=null;
        
        try {
            Connection con=Conexion.getConexion();
            String query="select * from profesor where rut = ?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, rut);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
                profe=new Profesor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return profe;
    }
     
     
     //-------
     public boolean eliminarProfesor(String rut)
    {
        boolean resultado=false;
        
        
        try {
            Connection con=Conexion.getConexion();
            String query = "delete from profesor where rut=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, rut);
            resultado=ps.executeUpdate()==1;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return resultado;
    }
     //-------
     public boolean modificarProfesor(Profesor profe)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            String query="update profesor set nombre=?, grado=?, certificado=?, where rut=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, profe.getNombre());
            ps.setString(2, profe.getGrado());
            ps.setBoolean(3, profe.isCertificado());
            ps.setString(4, profe.getRut());
            resultado=ps.executeUpdate()==1;
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return resultado;
    }
     
     //---------------
     ArrayList<Profesor> obtenerTodo()
    {
        ArrayList<Profesor> profesores=new ArrayList<Profesor>();
        try {
            Connection con=Conexion.getConexion();
            String query= "select * from profesor";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            Profesor alu;
            while(rs.next())
            {
                alu=new Profesor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
                profesores.add(alu);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return profesores;
    }
}
