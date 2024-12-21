public class Main {
    public static void main(String[] args) {
        System.out.println("La media es: " + media("4.2,7.1,2.8,9.0"));
    }

    private static double media(String cad) {
        String[] arrayNotas = cad.split(",");
        double[] notas = new double[arrayNotas.length];
        double promedio = 0.0;

        for (int i = 0; i < arrayNotas.length; i++) {
            notas[i] = Double.parseDouble(arrayNotas[i]);
        }

        for (double nota : notas) {
            promedio += nota;
        }

        return promedio / arrayNotas.length;
    }
}