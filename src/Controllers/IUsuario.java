
package Controllers;

import Datos.Usuario;
import java.util.List;

public interface IUsuario {
    
    public List<String> verificarUsuario(String email);
    public boolean registrarUser(Usuario user);
    public List<Usuario> listarUser();
    public void actualizarUsuario(String comprobanteCorreo, Usuario user);
    public void elimanrUsuario(Usuario user);
    public List<Usuario> busquedaUsuario(String valor);
    public Boolean vericarcarEmails(Usuario user);
    
}
