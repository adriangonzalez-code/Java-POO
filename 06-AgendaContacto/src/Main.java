import beans.Contacto;
import logica.GestionContacto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestionContacto gestor = new GestionContacto();
        Scanner entrada = new Scanner(System.in);
        int op, edad;
        String nombre, email;

        do {
            System.out.println("1.- Añadir contacto");
            System.out.println("2.- Buscar contacto");
            System.out.println("3.- Eliminar contacto");
            System.out.println("4.- Mostrar todos");
            System.out.println("5.- Salir");

            op = Integer.parseInt(entrada.nextLine());

            switch (op) {
                case 1:
                    System.out.println("Ingrese nombre: ");
                    nombre = entrada.nextLine();

                    System.out.println("Ingrese edad: ");
                    edad = Integer.parseInt(entrada.nextLine());

                    System.out.println("Ingrese email: ");
                    email = entrada.nextLine();

                    gestor.agregar(nombre, edad, email);
                    break;

                case 2:
                    System.out.println("Buscar contacto: ");
                    email = entrada.nextLine();

                    Contacto contacto = gestor.buscar(email);
                    if (contacto == null) {
                        System.out.println("Contacto no encontrado");
                    } else {
                        System.out.println("Nombre: " + contacto.getNombre() + "-" + contacto.getEmail() + "-" + contacto.getEdad());
                    }
                    break;

                case 3:
                    System.out.println("Email: ");
                    email = entrada.nextLine();

                    if (gestor.eliminar(email)) {
                        System.out.println("Contacto eliminado");
                    } else {
                        System.out.println("Contacto no encontrado");
                    }

                    break;

                case 4:
                    Contacto[] contactos = gestor.recuperarContactos();
                    for (Contacto con : contactos) {
                        System.out.println("Nombre: " + con.getNombre() + "-" + con.getEmail() + "-" + con.getEdad());
                    }

                    break;
            }
        } while (op != 5);
    }
}