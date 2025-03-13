/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    public static Connection getConexion(){
        
        Connection con = null;
        
        String url = "jdbc:mysql://localHost:3307/dblayonnais";
        String userName = "root";
        String password = "0000";
        
        try {
            con = DriverManager.getConnection(url,userName,password);
        } catch (SQLException ex) {
            System.err.println("Error al conectarse: "+ex);
        }
//        finally{
//            try {
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
  
        return con;
    }
}
