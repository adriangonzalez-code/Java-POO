public class Main {

    public static void main(String[] args) {

        int generados = 0;
        int[] nums = new int[6];
        int n;

        do {
            // Generamos un numero aleatorio entre 1 y 49
            n = (int) (Math.random() * 49 + 1);

            // Si no está repetido, lo guardamos en el arreglo
            if (!repetido(n, nums, generados)) {
                nums[generados] = n;
                generados++;
            }

        } while (generados < nums.length);

        ordernar(nums);
        mostrar(nums);
    }

    private static boolean repetido(int n, int[] nums, int generados) {
        boolean res = false;

        for (int i = 0; i < generados; i++) {
            if (n == nums[i]) {
                res = true;
                break;
            }
        }
        return res;
    }

    private static void ordernar(int[] nums) {
        int aux;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    aux = nums[i];
                    nums[i] = nums[j];
                    nums[j] = aux;
                }
            }
        }
    }

    private static void mostrar(int[] nums) {
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }
}