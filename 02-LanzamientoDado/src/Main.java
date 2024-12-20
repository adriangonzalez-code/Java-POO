public class Main {
    public static void main(String[] args) {
        double[] generate = generate();

        for (int i = 0; i < generate.length; i++) {
            System.out.println("Cara: " + (i + 1) + ", Porcentaje: " + generate[i]);
        }
    }

    private static double[] generate() {
        int cara;
        int[] cantidades = new int[6];
        double[] porcentajesCaras = new double[cantidades.length];
        int intentos = 100000;
        double totalPorcentaje = 100.0;

        for (int i = 0; i < intentos; i++) {
            cara = (int) (Math.random() * cantidades.length);
            cantidades[cara] += 1;
        }

        for (int i = 0; i < cantidades.length; i++) {
            porcentajesCaras[i] = Math.round((cantidades[i] * totalPorcentaje / intentos) * 10.0) / 10.0;
        }

        return porcentajesCaras;
    }
}