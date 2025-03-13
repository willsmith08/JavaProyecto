
package Controllers;

import Datos.Entrega;
import Datos.EntregaUsuario;
import Datos.Usuario;
import java.util.List;

public interface IEntrega {
    public void registrarEntrega(Entrega entrega);
    public List<EntregaUsuario> listarEntrega_Usuario(Usuario usuario);
}
