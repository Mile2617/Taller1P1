package Models;

public class Estudiante {
    private String nombre;
    private int edad;
    private double[] notas; // Arreglo de notas por cada materia

    public Estudiante(String nombre, int edad, int cantidadMaterias) {
        this.nombre = nombre;
        this.edad = edad;
        this.notas = new double[cantidadMaterias];
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNota(int index, double nota) {
        this.notas[index] = nota;
    }
}
