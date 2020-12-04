/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariolagos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion 
{
    private static Connection con=null;
    public static Connection getConexion() throws SQLException,ClassNotFoundException{
       if(con==null)
       {
          Class.forName("com.mysql.jdbc.Driver");
          con= DriverManager.getConnection("jdbc:mysql://localhost/bdinstituto","root","");
        }
        return con;
    }
}
