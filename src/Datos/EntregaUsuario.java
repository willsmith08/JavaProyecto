
package Datos;

import java.util.Date;

public class EntregaUsuario {
    private String metodoEntrega;
    private String email;
    private String FechaHora;
    
    public EntregaUsuario(){
        
    }

    public String getMetodoEntrega() {
        return metodoEntrega;
    }

    public void setMetodoEntrega(String metodoEntrega) {
        this.metodoEntrega = metodoEntrega;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(String FechaHora) {
        this.FechaHora = FechaHora;
    }
    
    
}
