
package Models;

import Datos.Ciudad;
import Controllers.ICiudad;
import java.util.List;
import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CiudadCrud implements ICiudad{

    @Override
    public List<Ciudad> listarCiudades() {
        
        Connection con = Conexion.getConexion();
        
        List<Ciudad> listaCiudades = new ArrayList();
        
        PreparedStatement ps;
        ResultSet rs;
        var consulta = "select * from ciudad";
        
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Ciudad ciudad = new Ciudad();
                
                ciudad.setIdCiudad(rs.getInt(1));
                ciudad.setNombreCiudad(rs.getString(2));
                
                listaCiudades.add(ciudad);
            }
            
        } catch (SQLException ex) {
            System.err.println("Error al consultar las ciudades: "+ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CiudadCrud.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaCiudades;
    }
    
}
