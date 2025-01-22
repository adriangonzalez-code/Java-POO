import beans.Pieza;
import logica.GestionPieza;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestionPieza gestor = new GestionPieza();
        Scanner sc = new Scanner(System.in);
        int op, dia, mes, anio;
        String nombre;

        do {
            System.out.println("1.- Añadir Pieza");
            System.out.println("2.- Piezas Antiguas");
            System.out.println("3.- Salir");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    System.out.println("Nombre de la pieza: ");
                    nombre = sc.nextLine();

                    System.out.println("Año de fabricación: ");
                    anio = Integer.parseInt(sc.nextLine());

                    System.out.println("Mes de fabricación (1-12): ");
                    mes = Integer.parseInt(sc.nextLine());

                    System.out.println("Día de fabricación: ");
                    dia = Integer.parseInt(sc.nextLine());

                    Calendar cal = Calendar.getInstance();
                    cal.set(anio, mes - 1, dia);

                    gestor.agregarPieza(nombre, cal.getTime());
                    break;

                case 2:
                    System.out.println("Año de fabricación: ");
                    anio = Integer.parseInt(sc.nextLine());

                    System.out.println("Mes de fabricación (1-12): ");
                    mes = Integer.parseInt(sc.nextLine());

                    System.out.println("Día de fabricación: ");
                    dia = Integer.parseInt(sc.nextLine());

                    Calendar cal2 = Calendar.getInstance();
                    cal2.set(anio, mes - 1, dia);
                    HashSet<Pieza> piezas = gestor.obtenerAntiguas(cal2.getTime());

                    for (Pieza p : piezas) {
                        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, new Locale("ES", "es"));
                        System.out.println(p.getNombre() + " - " + df.format(p.getFechaFabricacion()));
                    }
            }
        } while (op != 3);
    }
}