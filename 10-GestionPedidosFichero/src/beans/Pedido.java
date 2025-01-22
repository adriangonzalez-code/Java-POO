package beans;

import java.time.LocalDate;

public class Pedido {

    private String produto;
    private double precioUnitario;
    private int unidades;
    private LocalDate fecha;

    public Pedido() {
    }

    public Pedido(String produto, double precioUnitario, int unidades, LocalDate fecha) {
        this.produto = produto;
        this.precioUnitario = precioUnitario;
        this.unidades = unidades;
        this.fecha = fecha;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}