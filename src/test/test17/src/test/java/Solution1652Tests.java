import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1652Tests {
    private final Solution1652 solution1652 = new Solution1652();

    @Test
    public void example1() {
        int[] code = {5, 7, 1, 4};
        int k = 3;
        int[] expected = {12, 10, 16, 13};
        Assertions.assertArrayEquals(expected, solution1652.decrypt(code, k));
    }

    @Test
    public void example2() {
        int[] code = {1, 2, 3, 4};
        int k = 0;
        int[] expected = {0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, solution1652.decrypt(code, k));
    }

    @Test
    public void example3() {
        int[] code = {2, 4, 9, 3};
        int k = -2;
        int[] expected = {12, 5, 6, 13};
        Assertions.assertArrayEquals(expected, solution1652.decrypt(code, k));
    }
}