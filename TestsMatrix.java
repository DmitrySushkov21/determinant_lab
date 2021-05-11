import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestsMatrix {

    @Test
    public void SuccessCalc() {
        int[][] matrix = {
                {1, -2, 3},
                {4, 0, 6},
                {-7, 8, 9}
        };
        assertEquals(204, Matrix.det(matrix));
    }

    @Test
    public void ZeroDet() {
        int[][] matrix = {
                {11, 22, 33},
                {11, 22, 33},
                {22, 44, 66}
        };
        assertEquals(0, Matrix.det(matrix));
    }

    @Test
    public void SmallMatrix(){
        int[][] matrix = {
                {10},
        };
        assertEquals(10, Matrix.det(matrix));
    }

    @Test
    public void RedhefferMatrix() {
        int[][] RedhefferMatrix = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        };
        assertEquals(-2, Matrix.det(RedhefferMatrix));
    }
}