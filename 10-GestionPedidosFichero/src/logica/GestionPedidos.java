package logica;

import beans.Pedido;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class GestionPedidos {

    private String ruta = "c:\\temporal\\pedidos.txt";
    private String pedidoFormat = "%s|%s|%s|%s";
    private String dateFormat = "yyyy-MM-dd";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

    public boolean agregarPedido(Pedido pedido) {
        try (FileOutputStream fos = new FileOutputStream(this.ruta, true);
             PrintStream ps = new PrintStream(fos)) {
            ps.println(String.format(this.pedidoFormat, pedido.getProduto(), pedido.getPrecioUnitario(), pedido.getUnidades(), pedido.getFecha().format(this.formatter)));
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Pedido pedidoMayor() {
        try (FileReader fr = new FileReader(this.ruta);
        BufferedReader br = new BufferedReader(fr)) {
            String s;
            LinkedList<Pedido> pedidos = new LinkedList<>();

            while ((s = br.readLine()) != null) {
                String[] pedido = s.split("\\|");
                pedidos.add(new Pedido(pedido[0], Double.parseDouble(pedido[1]), Integer.parseInt(pedido[2]), LocalDate.parse(pedido[3], this.formatter)));
            }

            if (!pedidos.isEmpty()) {
                return pedidos.stream().max(Comparator.comparingInt(Pedido::getUnidades)).stream().findFirst().get();
            }

            return null;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Double totalFacturado() {
        try (FileReader fr = new FileReader(this.ruta);
             BufferedReader br = new BufferedReader(fr)) {
            String s;
            LinkedList<Pedido> pedidos = new LinkedList<>();

            while ((s = br.readLine()) != null) {
                String[] pedido = s.split("\\|");
                pedidos.add(new Pedido(pedido[0], Double.parseDouble(pedido[1]), Integer.parseInt(pedido[2]), LocalDate.parse(pedido[3], this.formatter)));
            }

            if (!pedidos.isEmpty()) {
                return pedidos.stream().reduce(0.0, (ac, p) -> ac + (p.getPrecioUnitario() * p.getUnidades()), Double::sum);
            }

            return 0.0;
        } catch (IOException ex) {
            ex.printStackTrace();
            return 0.0;
        }
    }

    public LinkedList<Pedido> pedidos(LocalDate fechaInicio, LocalDate fechaFin) {
        try (FileReader fr = new FileReader(this.ruta);
        BufferedReader br = new BufferedReader(fr)) {
            String s;
            LinkedList<Pedido> pedidos = new LinkedList<>();

            while ((s = br.readLine()) != null) {
                String[] pedido = s.split("\\|");
                pedidos.add(new Pedido(pedido[0], Double.parseDouble(pedido[1]), Integer.parseInt(pedido[2]), LocalDate.parse(pedido[3], this.formatter)));
            }

            if (!pedidos.isEmpty()) {
                return pedidos.stream().filter(p -> (!p.getFecha().isBefore(fechaInicio) || p.getFecha().equals(fechaInicio)) && (!p.getFecha().isAfter(fechaFin) || p.getFecha().equals(fechaFin))).collect(Collectors.toCollection(LinkedList::new));
            }

            return null;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}