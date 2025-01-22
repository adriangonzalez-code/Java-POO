import beans.Pedido;
import logica.PedidosService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PedidosService gestor = new PedidosService();
        Scanner sc = new Scanner(System.in);
        int op, dia, mes, anio;
        String pedido;
        double precio;

        do {
            System.out.println("1.- Añadir pedido");
            System.out.println("2.- Ver pedido mas reciente");
            System.out.println("3.- Ver pedidos con precio máximo");
            System.out.println("4.- Salir");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    System.out.println("Nombre del pedido: ");
                    pedido = sc.nextLine();

                    System.out.println("Año del pedido: ");
                    anio = Integer.parseInt(sc.nextLine());

                    System.out.println("Mes del pedido (1-12): ");
                    mes = Integer.parseInt(sc.nextLine());

                    System.out.println("Día del pedido: ");
                    dia = Integer.parseInt(sc.nextLine());

                    System.out.println("Precio del pedido: ");
                    precio = Double.parseDouble(sc.nextLine());

                    LocalDate ld = LocalDate.of(anio, mes, dia);

                    gestor.guardarPedido(pedido, ld, precio);
                    break;

                case 2:
                    Pedido p = gestor.pedidoMasReciente();
                    System.out.println(p.getProducto() + " - $" + p.getPrecio() + " - " + p.getFechaPedido());
                    break;

                case 3:
                    System.out.println("Precio del pedido: ");
                    precio = Double.parseDouble(sc.nextLine());

                    ArrayList<Pedido> pedidos = gestor.pedidosPrecioMax(precio);

                    for (Pedido pl : pedidos) {
                        System.out.println(pl.getProducto() + " - $" + pl.getPrecio() + " - " + pl.getFechaPedido());
                    }
            }
        } while (op != 4);
    }
}