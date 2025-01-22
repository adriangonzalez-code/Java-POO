import beans.Pedido;
import logica.GestionPedidos;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionPedidos gp = new GestionPedidos();
        int op, unidades, anio, mes, dia;
        String producto;
        double precioUnitario;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Nuevo pedido");
            System.out.println("2. Pedido Mayor");
            System.out.println("3. Total facturado");
            System.out.println("4. Pedidos entre fechas");
            System.out.println("5. Salir");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    System.out.println("Producto:");
                    producto = sc.nextLine();

                    System.out.println("Precio unitario:");
                    precioUnitario = Double.parseDouble(sc.nextLine());

                    System.out.println("Unidades:");
                    unidades = Integer.parseInt(sc.nextLine());

                    System.out.println("Anio:");
                    anio = Integer.parseInt(sc.nextLine());

                    System.out.println("Mes:");
                    mes = Integer.parseInt(sc.nextLine());

                    System.out.println("Dia:");
                    dia = Integer.parseInt(sc.nextLine());

                    gp.agregarPedido(new Pedido(producto, precioUnitario, unidades, LocalDate.of(anio, mes, dia)));
                    break;

                case 2:
                    Pedido pedido = gp.pedidoMayor();
                    System.out.println("El pedido con mayor cantidad: " + pedido.getProduto() +", precio Unitario: " + pedido.getPrecioUnitario() + ", cantidad: " + pedido.getUnidades() + ", fecha: " + pedido.getFecha());
                    break;

                case 3:
                    System.out.println("Total facturado: " + gp.totalFacturado());
                    break;

                case 4:
                    System.out.println("Anio de Inicio:");
                    anio = Integer.parseInt(sc.nextLine());

                    System.out.println("Mes de Inicio:");
                    mes = Integer.parseInt(sc.nextLine());

                    System.out.println("Dia de Inicio:");
                    dia = Integer.parseInt(sc.nextLine());

                    LocalDate fechaInicio = LocalDate.of(anio, mes, dia);

                    System.out.println("Anio de Fin:");
                    anio = Integer.parseInt(sc.nextLine());

                    System.out.println("Mes de Fin:");
                    mes = Integer.parseInt(sc.nextLine());

                    System.out.println("Dia de Fin:");
                    dia = Integer.parseInt(sc.nextLine());

                    LocalDate fechaFin = LocalDate.of(anio, mes, dia);

                    System.out.println("Productos encontrados:");
                    LinkedList<Pedido> pedidos = gp.pedidos(fechaInicio, fechaFin);

                    for (Pedido p : pedidos) {
                        System.out.println(p.getProduto() + "|" + p.getPrecioUnitario() + "|" + p.getUnidades() + "|" + p.getFecha());
                    }
                    break;
            }
        } while (op != 5);
    }
}