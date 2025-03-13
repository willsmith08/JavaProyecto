
package Models;

import Datos.*;
import Conexion.Conexion;
import Controllers.IEntrega;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

public class EntregaCrud implements IEntrega{

    @Override
    public void registrarEntrega(Entrega entrega) {
        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        
        var consulta = "insert into entrega (metodoEntrega,usuario_idusuario) value (?,?)";
        
        try {
            ps=con.prepareStatement(consulta);
            ps.setString(1, entrega.getMetodoEntrega());
            ps.setInt(2, entrega.getIdUsuario());
            
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(EntregaCrud.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

    @Override
    public List<EntregaUsuario> listarEntrega_Usuario(Usuario usuario) {
        List<EntregaUsuario> lEntrega = new ArrayList();
        
        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        
        var consulta = "select e.metodoEntrega, u.correoElectronico, e.fecha_hora from entrega e inner join usuario u on u.idusuario = e.usuario_idusuario "
                +"where u.correoElectronico = ?";
        
        
        try {
            ps=con.prepareStatement(consulta);
            ps.setString(1, usuario.getCorreoElectronico());
            rs = ps.executeQuery();
            
            while(rs.next()){
                EntregaUsuario eu = new EntregaUsuario();
                
                eu.setMetodoEntrega(rs.getString(1));
                eu.setEmail(rs.getString(2));
                eu.setFechaHora(rs.getString(3));
                
                lEntrega.add(eu);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EntregaCrud.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        
        return lEntrega;
    }
    
}
