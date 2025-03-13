package Models;

import Datos.*;
import Conexion.Conexion;
import Controllers.IUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.StyledEditorKit;

public class UsuarioCRUD implements IUsuario{

    @Override
    public List<String> verificarUsuario(String email) {

        List<String> credencialesUsuario = new ArrayList();
        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        String Consulta = "select correoElectronico, contrasena from usuario where correoElectronico = ?";

        try {

            ps = con.prepareStatement(Consulta);
            ps.setString(1, email);

            rs = ps.executeQuery();

            if (rs.next()) {
                credencialesUsuario.add(rs.getString(1));
                credencialesUsuario.add(rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return credencialesUsuario;
    }
    

    @Override
    public boolean registrarUser(Usuario user) {
        Connection con = Conexion.getConexion();
        PreparedStatement ps;

        var sql = "call CUD_usuario('insert',"+null+",?,?,?,?,?,?,?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);

            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellidos());
            ps.setString(3, user.getPassw());
            ps.setString(4, user.getCorreoElectronico());
            ps.setString(5, user.getSuscripto());
            ps.setString(6, user.getDireccionPrincipal());
            ps.setString(7, user.getDireccionSecundaria());
            ps.setInt(8, user.getIdCiudad());
            ps.setInt(9, user.getIdPregunta());
            ps.setString(10, user.getRespuesta());

            ps.execute();

        } catch (SQLException ex) {

            System.err.println("No registró " + ex);

        } finally {
            try {
                con.close();
            } catch (SQLException sqlex) {
                System.err.println(sqlex);
            }
        }

        return true;
    }

    @Override
    public List<Usuario> listarUser() {
        List<Usuario> listaUser = new ArrayList();

        Connection con = Conexion.getConexion();
        PreparedStatement ps;

        ResultSet rs;

        var consulta = "select idusuario, nombre, apellidos, correoElectronico, direccionPrincipal, direccionSecundaria from usuario";

        try {

            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario user = new Usuario();
                user.setId(rs.getInt(1));
                user.setNombre(rs.getString(2));
                user.setApellidos(rs.getString(3));
                user.setCorreoElectronico(rs.getString(4));
                user.setDireccionPrincipal(rs.getString(5));
                user.setDireccionSecundaria(rs.getString(6));

                listaUser.add(user);
            }
        } catch (SQLException ex) {

            System.err.println(ex);

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }

        return listaUser;
    }

    @Override
    public void actualizarUsuario(String comprobanteCorreo, Usuario user) {
        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        String consulta = "call CUD_usuario('update',?,?,?,"+null+",?,"+null+",?,?,"+null+")";

        try {

            ps = con.prepareStatement(consulta);
            if (user.getNombre().trim().isEmpty()) {
                user.setNombre(null);
            }
            if (user.getApellidos().trim().isEmpty()) {
                user.setApellidos(null);
            }
            if (user.getCorreoElectronico().trim().isEmpty()) {
                user.setCorreoElectronico(null);
            }
            if (user.getDireccionPrincipal().trim().isEmpty()) {
                user.setDireccionPrincipal(null);
            }
            if (user.getDireccionSecundaria().trim().isEmpty()) {
                user.setDireccionSecundaria(null);
            }
            
            
            ps.setString(1, comprobanteCorreo);
            ps.setString(2, user.getNombre());
            ps.setString(3, user.getApellidos());
            ps.setString(4, user.getCorreoElectronico());
            ps.setString(5, user.getDireccionPrincipal());
            ps.setString(6, user.getDireccionSecundaria());

            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void elimanrUsuario(Usuario user) {
        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        String consulta = "call CUD_usuario('delete',?," + null + "," + null + "," + null + "," + null + "," + null + "," + null+ "," + null + "," + null+")";

        try {

            ps = con.prepareStatement(consulta);
            ps.setString(1, user.getCorreoElectronico().trim());

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Usuario> busquedaUsuario(String valor) {
        List<Usuario> listaUser = new ArrayList();

        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        String consulta = "select idusuario, nombre, apellidos, correoElectronico, direccionPrincipal, direccionSecundaria from usuario where correoElectronico like ?";

        try {
            ps = con.prepareStatement(consulta);

            ps.setString(1, valor + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellidos(rs.getString(3));
                usuario.setCorreoElectronico(rs.getString(4));
                usuario.setDireccionPrincipal(rs.getString(5));
                usuario.setDireccionSecundaria(rs.getString(6));

                listaUser.add(usuario);
            }

        } catch (SQLException ex) {
            System.err.println("Error al realizar la consulta: " + ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexion: " + ex);
            }
        }

        return listaUser;
    }

    @Override
    public Boolean vericarcarEmails(Usuario user) {
        
        Connection con = Conexion.getConexion();
        Boolean verificacion= false;
        PreparedStatement ps;
        ResultSet rs;
        var consulta = "select count(correoElectronico) from usuario where correoElectronico = ?";
        
        try {
            ps = con.prepareStatement(consulta);
            ps.setString(1, user.getCorreoElectronico().trim());
            
            rs = ps.executeQuery();
            rs.next();
            if (rs.getInt(1) == 1) {
                verificacion = true;
            }
            
        } catch (SQLException ex) {
            System.err.println("Error al verificar email: "+ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Error al verificar email:" +ex);
            }
        }
        
        return verificacion;
    }
}
