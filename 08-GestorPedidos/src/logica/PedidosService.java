package logica;

import beans.Pedido;

import java.time.LocalDate;
import java.util.ArrayList;

public class PedidosService {

    private ArrayList<Pedido> pedidos;

    public PedidosService() {
        this.pedidos = new ArrayList<>();
    }

    public void guardarPedido(String producto, LocalDate fecha, double precio) {
        this.pedidos.add(new Pedido(producto, fecha, precio));
    }

    public Pedido pedidoMasReciente() {
        Pedido p1 = null;

        for (Pedido p : this.pedidos) {
            if (p1 == null) {
                p1 = p;
            } else {
                if (p1.getFechaPedido().isBefore(p.getFechaPedido())) {
                    p1 = p;
                }
            }
        }

        return p1;
    }

    public ArrayList<Pedido> pedidosPrecioMax(double precio) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        for (Pedido p : this.pedidos) {
            if (p.getPrecio() <= precio) {
                pedidos.add(p);
            }
        }

        return pedidos;
    }
}
