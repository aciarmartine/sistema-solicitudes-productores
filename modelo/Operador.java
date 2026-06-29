package modelo;

public class Operador extends Usuario {

    private String sector;

    public Operador() {

    }

    public Operador(int id, String nombre, String email, String sector) {
        super(id, nombre, email);
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Operador del sistema");
    }
}