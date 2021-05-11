import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class TestKramer {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testCorrectSolutions(){
        int[][] k = {
                {1, 1, 1},
                {2, -1, -6},
                {3, -2, 0},

        };
        int[] f = {2, -1, 8};
        assertArrayEquals(new double[]{2.0, -1.0, 1.0}, KramerSystem.solve(k, f));
    }

    @Test
    public void testNoSolutions(){
        int[][] k = {
                {11, 22, 3},
                {11, 22, 33},
                {22, 44, 66}
        };
        int[] f = {9, -4, 5};
        KramerSystem.solve(k, f);
        assertEquals("Решений нет", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void testInfSolutions() {
        int[][] k = {
                {11, 22, 33},
                {11, 22, 33},
                {22, 44, 66}
        };
        int[] f = {9, -4, 5};
        KramerSystem.solve(k, f);
        assertEquals("Система имеет бесконечное количество решений", outputStreamCaptor.toString()
                .trim());
    }
}