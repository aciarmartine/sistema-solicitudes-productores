package controlador;

import dao.SolicitudDAO;
import modelo.Solicitud;

import java.util.ArrayList;

public class SolicitudControlador {

    private SolicitudDAO solicitudDAO;

    public SolicitudControlador() {
        solicitudDAO = new SolicitudDAO();
    }

    public void registrarSolicitud(Solicitud solicitud) {
        solicitudDAO.registrarSolicitud(solicitud);
    }

    public ArrayList<Solicitud> obtenerSolicitudes() {
        return solicitudDAO.obtenerSolicitudes();
    }

    public void actualizarEstado(int id, String estado) {
        solicitudDAO.actualizarEstado(id, estado);
    }

}