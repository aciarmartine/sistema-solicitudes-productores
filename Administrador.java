public class Administrador extends Usuario {

    public Administrador(int idUsuario, String nombre, String email) {
        super(idUsuario, nombre, email);
    }

    @Override
    public void mostrarMenu() {
        System.out.println("Menu Administrador");
        System.out.println("1 - Asignar solicitudes");
        System.out.println("2 - Consultar reportes");
    }
}
