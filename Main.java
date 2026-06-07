import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Solicitud> solicitudes = new ArrayList<>();
        int opcion = 0;
        Productor productor = new Productor(
                1,
                "Juan Perez",
                "juan@mail.com",
                "MAT-001"
        );

        System.out.println("====================================");
        System.out.println("Sistema de Gestion de Solicitudes");
        System.out.println("====================================");

        while (opcion != 3) {
            System.out.println();
            System.out.println("1 - Registrar solicitud");
            System.out.println("2 - Mostrar solicitudes");
            System.out.println("3 - Salir");

            System.out.print("Seleccione una opcion: ");

            try {
                opcion = teclado.nextInt();
                teclado.nextLine();
                switch (opcion) {
                        
                    case 1:
                        System.out.print("Ingrese descripcion: ");
                        String descripcion = teclado.nextLine();
                        Solicitud solicitud = new Solicitud(
                                solicitudes.size() + 1,
                                descripcion,
                                "Pendiente"
                        );
                        solicitudes.add(solicitud);
                        System.out.println("Solicitud registrada correctamente.");
                        break;
                        
                    case 2:
                        if (solicitudes.isEmpty()) {
                            System.out.println("No existen solicitudes.");
                        } else {
                            for (Solicitud s : solicitudes) {
                                s.mostrarSolicitud();
                                System.out.println("-------------------");
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opcion invalida.");
                }

            } catch (Exception e) {
                System.out.println("Error: debe ingresar un numero.");
                teclado.nextLine();
            }
        }

        teclado.close();
    }
}
