import java.util.Scanner;
import java.util.stream.IntStream;

public class Matrix {
    private static final Scanner scanner = new Scanner(System.in);

    static double find_det(){
        System.out.println("Введите размерность матрицы");
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        System.out.println("Введите матрицу");
        IntStream.range(0, size)
                .forEach(i -> IntStream.range(0, size)
                        .forEach(j -> matrix[i][j] = scanner.nextInt()));
        return Matrix.det(matrix);
    }

    static double det(int[][] matrix) {
        int n = matrix.length;
        if (n == 1)
            return matrix[0][0];
        if (n == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        double result = 0;
        int[][] minor = new int[n - 1][n - 1];
        int l = 1;
        for (int i = 0; i < n; ++i) {
            int x = 0;
            int y = 0;
            for (int j = 1; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (i == k) continue;
                    minor[x][y] = matrix[j][k];
                    y++;
                    if (y == n - 1) {
                        y = 0;
                        x++;
                    }
                }
            }
            result += l * matrix[0][i] * det(minor);
            l *= -1;
        }
        return result;
    }
}
