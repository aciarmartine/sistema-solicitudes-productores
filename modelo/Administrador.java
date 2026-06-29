package modelo;

public class Administrador extends Usuario {

    private String permiso;

    public Administrador() {

    }

    public Administrador(int id, String nombre, String email, String permiso) {
        super(id, nombre, email);
        this.permiso = permiso;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Administrador del sistema");
    }
}