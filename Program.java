import java.util.Scanner;
import java.util.stream.IntStream;

public class Program {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1. Вычислить определитель");
        System.out.println("2. Решить систему линейных уравнений");
        String chose = scanner.next();
        switch (chose) {
            case "1" -> {
                double det = Matrix.find_det();
                System.out.println("Определитель равен " + det);
            }
            case "2" -> {
                double[] solve = KramerSystem.solve_system();
                if (solve != null) {
                    for (int i = 0; i < solve.length; i++) {
                        System.out.println("X" + i + " = " + solve[i]);
                    }
                }
            }
        }
    }
}

