public class Operador extends Usuario {

    public Operador(int idUsuario, String nombre, String email) {
        super(idUsuario, nombre, email);
    }

    @Override
    public void mostrarMenu() {
        System.out.println("Menu Operador");
        System.out.println("1 - Actualizar solicitud");
        System.out.println("2 - Registrar resolución");
    }
}
