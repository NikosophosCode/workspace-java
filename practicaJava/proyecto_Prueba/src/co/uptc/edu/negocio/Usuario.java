package co.uptc.edu.negocio;

import java.util.Objects;

public class Usuario {

    private String usuario;
    private String correo;
    private String contrasena;
    private Persona persona;

    public Usuario() {
    }

    public Usuario(String usuario, String correo, String contrasena, Persona persona) {
        this.usuario = usuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.persona = persona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario1 = (Usuario) o;
        return Objects.equals(usuario, usuario1.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", correo='" + correo + '\'' +
                ", persona=" + persona +
                '}';
    }
}
