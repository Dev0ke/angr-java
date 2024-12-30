import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1337Tests {
    private final Solution1337 solution1337 = new Solution1337();

    @Test
    public void example1() {
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int k = 3;
        int[] expected = {2, 0, 3};
        Assertions.assertArrayEquals(expected, solution1337.kWeakestRows(mat, k));
    }

    @Test
    public void example2() {
        int[][] mat = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };
        int k = 2;
        int[] expected = {0, 2};
        Assertions.assertArrayEquals(expected, solution1337.kWeakestRows(mat, k));
    }
}
