package beans;

import java.time.LocalDate;

public class Pedido {
    private String producto;
    private LocalDate fechaPedido;
    private double precio;

    public Pedido(String producto, LocalDate fechaPedido, double precio) {
        super();
        this.producto = producto;
        this.fechaPedido = fechaPedido;
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}