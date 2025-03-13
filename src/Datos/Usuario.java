package Datos;

public class Usuario {
    
    private int id;
    private String nombre;
    private String apellidos;
    private String passw;
    private String correoElectronico;
    private String suscripto;
    private String direccionPrincipal;
    private String direccionSecundaria;
    private int idCiudad;
    private int idPregunta;
    private String respuesta;

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getDireccionPrincipal() {
        return direccionPrincipal;
    }

    public void setDireccionPrincipal(String direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

    public String getDireccionSecundaria() {
        return direccionSecundaria;
    }

    public void setDireccionSecundaria(String direccionSecundaria) {
        this.direccionSecundaria = direccionSecundaria;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getSuscripto() {
        return suscripto;
    }

    public void setSuscripto(String suscripto) {
        this.suscripto = suscripto;
    }
    
    
}
