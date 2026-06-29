package modelo;

public class Productor extends Usuario {

    private String matricula;

    public Productor() {

    }

    public Productor(int id, String nombre, String email, String matricula) {
        super(id, nombre, email);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Productor de seguros");
    }
}