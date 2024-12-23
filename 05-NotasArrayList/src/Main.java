import logica.GestionNotas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestionNotas gnotas = new GestionNotas();

        int op; // opción elegida pro el usuario
        Scanner sc = new Scanner(System.in);
        double nota;

        do {
            // Presentamos menú
            System.out.println("1.- Añadir nota");
            System.out.println("2.- Ver media");
            System.out.println("3.- Ver aprobados");
            System.out.println("4.- Salir");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    System.out.println("Introduzca una nota:");
                    nota = Double.parseDouble(sc.nextLine());
                    gnotas.guardarNota(nota);
                    break;

                case 2:
                    System.out.println("Media actual: " + gnotas.media());
                    break;

                case 3:
                    System.out.println("Aprobados: " + gnotas.aprobados());
                    break;
            }
        } while (op != 4);
    }
}