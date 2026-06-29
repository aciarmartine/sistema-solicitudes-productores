package dao;

import conexion.ConexionBD;
import modelo.Solicitud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Esta clase aplica el patrón DAO.
 * Su responsabilidad es separar la lógica de acceso a datos
 * del resto del sistema.
 */
public class SolicitudDAO {

    public void registrarSolicitud(Solicitud solicitud) {

        String sql = "INSERT INTO solicitudes (fecha, descripcion, estado, id_productor, id_operador) " +
                "VALUES (NOW(), ?, ?, 1, 2)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, solicitud.getDescripcion());
            sentencia.setString(2, solicitud.getEstado());

            sentencia.executeUpdate();

            System.out.println("Solicitud guardada correctamente en la base de datos.");

        } catch (SQLException e) {
            System.out.println("Error al registrar la solicitud: " + e.getMessage());
        }
    }

    public ArrayList<Solicitud> obtenerSolicitudes() {

        ArrayList<Solicitud> solicitudes = new ArrayList<>();

        String sql = "SELECT id_solicitud, descripcion, estado FROM solicitudes";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {

                Solicitud solicitud = new Solicitud(
                        resultado.getInt("id_solicitud"),
                        resultado.getString("descripcion"),
                        resultado.getString("estado")
                );

                solicitudes.add(solicitud);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar solicitudes: " + e.getMessage());
        }

        return solicitudes;
    }

    public void actualizarEstado(int idSolicitud, String nuevoEstado) {

        String sql = "UPDATE solicitudes SET estado = ? WHERE id_solicitud = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, nuevoEstado);
            sentencia.setInt(2, idSolicitud);

            int filasAfectadas = sentencia.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Estado actualizado correctamente.");
            } else {
                System.out.println("No se encontró una solicitud con el ID indicado.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el estado: " + e.getMessage());
        }
    }
}