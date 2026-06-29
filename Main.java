import controlador.SolicitudControlador;
import modelo.Solicitud;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        SolicitudControlador controlador = new SolicitudControlador();

        String[] estadosPermitidos = {"Pendiente", "En proceso", "Resuelta", "Rechazada"};

        int opcion = 0;

        while (opcion != 4) {

            System.out.println();
            System.out.println("====================================");
            System.out.println("Sistema de Gestion de Solicitudes");
            System.out.println("====================================");
            System.out.println("1 - Registrar solicitud");
            System.out.println("2 - Mostrar solicitudes");
            System.out.println("3 - Actualizar estado");
            System.out.println("4 - Salir");
            System.out.print("Seleccione una opcion: ");

            try {

                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {

                    case 1:
                        System.out.print("Ingrese descripcion de la solicitud: ");
                        String descripcion = teclado.nextLine();

                        Solicitud nuevaSolicitud = new Solicitud(
                                0,
                                descripcion,
                                estadosPermitidos[0]
                        );

                        controlador.registrarSolicitud(nuevaSolicitud);
                        break;

                    case 2:
                        ArrayList<Solicitud> solicitudes = controlador.obtenerSolicitudes();

                        if (solicitudes.isEmpty()) {
                            System.out.println("No existen solicitudes registradas.");
                        } else {
                            for (Solicitud solicitud : solicitudes) {
                                System.out.println("------------------------------");
                                System.out.println("ID: " + solicitud.getId());
                                System.out.println("Descripcion: " + solicitud.getDescripcion());
                                System.out.println("Estado: " + solicitud.getEstado());
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese ID de solicitud: ");
                        int idSolicitud = teclado.nextInt();
                        teclado.nextLine();

                        System.out.println("Seleccione el nuevo estado:");

                        for (int i = 0; i < estadosPermitidos.length; i++) {
                            System.out.println((i + 1) + " - " + estadosPermitidos[i]);
                        }

                        int opcionEstado = teclado.nextInt();
                        teclado.nextLine();

                        if (opcionEstado >= 1 && opcionEstado <= estadosPermitidos.length) {
                            String nuevoEstado = estadosPermitidos[opcionEstado - 1];
                            controlador.actualizarEstado(idSolicitud, nuevoEstado);
                        } else {
                            System.out.println("Estado seleccionado invalido.");
                        }

                        break;

                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opcion invalida.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error: debe ingresar un valor valido.");
                teclado.nextLine();
            }
        }

        teclado.close();
    }
}