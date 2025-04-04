package Models;

import java.util.Scanner;

public class Sistemanotas {
    Materia[] materias = new Materia[5];
    Estudiante[] estudiantes = new Estudiante[10];
    int contMaterias = 0;
    int contEstudiantes = 0;

    public Sistemanotas() {
    }

    public void crearmateria() {
        if (contMaterias < 5) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese nombre de la materia:");
            String nombre = sc.next();

            System.out.println("Ingrese el código de la materia:");
            String codigo = sc.next();

            System.out.print("Ingrese créditos de la materia:");
            int creditos = sc.nextInt();

            Materia materia = new Materia(nombre, creditos, codigo);
            materias[contMaterias] = materia;
            contMaterias++;
        } else {
            System.out.println("No se pueden crear más materias.");
        }
    }

    public void crearEstudiante() {
        if (contEstudiantes < 10) {
            if (contMaterias == 0) {
                System.out.println("Primero debe crear materias antes de estudiantes.");
                return;
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese nombre del estudiante:");
            String nombre = sc.next();
            System.out.println("Ingrese edad del estudiante:");
            int edad = sc.nextInt();

            Estudiante est = new Estudiante(nombre, edad, contMaterias);

            for (int i = 0; i < contMaterias; i++) {
                double nota = pedirNota(sc, "Ingrese la nota para la materia " + materias[i].getNombre() + ": ");
                est.setNota(i, nota);
            }

            estudiantes[contEstudiantes] = est;
            contEstudiantes++;
        } else {
            System.out.println("No se pueden crear más estudiantes.");
        }
    }

    public void verEstadoEstudiantes() {
        if (contEstudiantes == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (int i = 0; i < contEstudiantes; i++) {
            System.out.println("\nEstudiante #" + (i + 1)); // Mostramos i+1 para que sea más entendible
            System.out.println("Nombre: " + estudiantes[i].getNombre());
            System.out.println("Edad: " + estudiantes[i].getEdad());
            double[] notas = estudiantes[i].getNotas();
            double sumaNotas = 0;
            for (int j = 0; j < contMaterias; j++) {
                System.out.println("Nota en " + materias[j].getNombre() + ": " + notas[j]);
                sumaNotas += notas[j];
            }
            double promedio = sumaNotas / contMaterias;
            System.out.println("Promedio general: " + promedio);

            if (promedio >= 7.0) {
                System.out.println("Estado: Aprobado");
            } else {
                System.out.println("Estado: Reprobado");
            }
        }
    }

    private double pedirNota(Scanner sc, String mensaje) {
        double nota;
        do {
            System.out.print(mensaje);
            nota = sc.nextDouble();
            if (nota < 0 || nota > 10) {
                System.out.println("La nota debe estar entre 0 y 10. Intente nuevamente.");
            }
        } while (nota < 0 || nota > 10);
        return nota;
    }
}
