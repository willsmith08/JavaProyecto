
package Models;

import Controllers.IPregunta;
import Datos.Pregunta;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PreguntaConsulta implements IPregunta{

    @Override
    public List<Pregunta> listarPreguntas() {
        List<Pregunta> listaPreguntas = new ArrayList<>();
        
        Connection con = Conexion.Conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        
        var consulta = "SELECT * FROM pregustasdeseguridad";
        
        try {
            
            ps=con.prepareStatement(consulta);
            rs=ps.executeQuery();
            
            while (rs.next()) {                
                Pregunta p = new Pregunta();
                p.setIdPregunta(rs.getInt(1));
                p.setPregunta(rs.getString(2));
                
                listaPreguntas.add(p);
            }
            
        } catch (SQLException ex) {
            System.err.println("Error al hacer la consulta entrega: "+ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexion consulta entrega: "+ex);
            }
        }
        
        
        
        return listaPreguntas;
    }
    
}
