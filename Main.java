import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sistema_solicitudes";
        String user = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO solicitudes (productor, descripcion, estado) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, "Juan Perez");
            stmt.setString(2, "Solicitud de certificado");
            stmt.setString(3, "Pendiente");

            stmt.executeUpdate();

            System.out.println("Solicitud insertada correctamente");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
