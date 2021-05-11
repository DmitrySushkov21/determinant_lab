import java.util.Scanner;
import java.util.stream.IntStream;

public class KramerSystem {
    private static final Scanner scanner = new Scanner(System.in);

    public static double[] solve_system() {
        System.out.println("Введите размер системы");
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        int[] f = new int[size];
        System.out.println("Введите систему");
        IntStream.range(0, size).forEach(i -> IntStream.range(0, size + 1).forEach(j -> {
            if (j == size)
                f[i] = scanner.nextInt();
            else
                matrix[i][j] = scanner.nextInt();
        }));
        return KramerSystem.solve(matrix, f);
    }

    public static double[] solve(int[][] k, int[] f) {
        double det = Matrix.det(k);
        double[] solves = new double[f.length];
        double[] s = new double[f.length];
        for (int i = 0; i < k.length; i++) {
            int[][] tempArr = copy_array(k);
            for (int j = 0; j < f.length; j++)
                tempArr[j][i] = f[j];
            double det2 = Matrix.det(tempArr);
            s[i] = det2;
            if (det != 0)
                solves[i] = det2 / det;
        }
        if (det != 0) {
            return solves;
        } else if (check_array(s, 0)) {
            System.out.println("Система имеет бесконечное количество решений");
            return null;
        } else {
            System.out.println("Решений нет");
            return null;
        }
    }

    private static boolean check_array(double[] arr, double el) {
        for (double element : arr)
            if (element != el)
                return false;
        return true;
    }

    private static int[][] copy_array(int[][] arr) {
        int size = arr.length;
        int[][] copedArray = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                copedArray[i][j] = arr[i][j];
            }
        return copedArray;
    }
}
