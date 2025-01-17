package logica;

import beans.Pieza;

import java.util.Date;
import java.util.HashSet;

public class GestionPieza {

    private HashSet<Pieza> piezas;

    public GestionPieza() {
        this.piezas = new HashSet<>();
    }

    public void agregarPieza(String nombre, Date fecha) {
        piezas.add(new Pieza(nombre, fecha));
    }

    public void agregarPieza(String nombre) {
        piezas.add(new Pieza(nombre, new Date()));
    }

    public HashSet<Pieza> obtenerAntiguas(Date fecha) {
        HashSet<Pieza> resultado = new HashSet<>();
        for (Pieza p : piezas) {
            if (p.getFechaFabricacion().getTime() < fecha.getTime()) {
                resultado.add(p);
            }
        }

        return resultado;
    }
}