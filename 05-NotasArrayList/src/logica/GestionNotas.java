package logica;

import java.util.ArrayList;

public class GestionNotas {

    ArrayList<Double> notas;

    public GestionNotas() {
        this.notas = new ArrayList<>();
    }

    public void guardarNota(double nota) {
        this.notas.add(nota);
    }

    public double media() {
        double media = 0;
        for (double nota : notas) {
            media += nota;
        }

        return media / notas.size();
    }

    public int aprobados() {
        int aprobados = 0;
        for (double nota : notas) {
            if (nota >= 5) {
                aprobados++;
            }
        }

        return aprobados;
    }
}