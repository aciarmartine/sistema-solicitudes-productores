public class Productor extends Usuario {

    private String matricula;

    public Productor(int idUsuario, String nombre, String email, String matricula) {
        super(idUsuario, nombre, email);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("Menu Productor");
        System.out.println("1 - Registrar solicitud");
        System.out.println("2 - Consultar estado");
    }
}
