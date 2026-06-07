public class Solicitud {

    private int idSolicitud;
    private String descripcion;
    private String estado;

    public Solicitud(int idSolicitud, String descripcion, String estado) {
        this.idSolicitud = idSolicitud;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public void mostrarSolicitud() {
        System.out.println("ID: " + idSolicitud);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Estado: " + estado);
    }
}
