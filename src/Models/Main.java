import Models.Sistemanotas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sistemanotas sistema = new Sistemanotas();

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Crear Materia");
            System.out.println("2. Crear Estudiante");
            System.out.println("3. Ver Estado de Estudiantes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    sistema.crearmateria();
                    break;
                case 2:
                    sistema.crearEstudiante();
                    break;
                case 3:
                    sistema.verEstadoEstudiantes();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
