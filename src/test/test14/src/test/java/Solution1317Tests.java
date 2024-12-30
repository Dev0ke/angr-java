import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1317Tests {
    private final Solution1317 solution1317 = new Solution1317();

    @Test
    public void example1() {
        int n = 2;
        int[] expected = {1, 1};
        Assertions.assertArrayEquals(expected, solution1317.getNoZeroIntegers(n));
    }

    @Test
    public void example2() {
        int n = 11;
        int[] expected = {2, 9};
        Assertions.assertArrayEquals(expected, solution1317.getNoZeroIntegers(n));
    }

    @Test
    public void example3() {
        int n = 10000;
        int[] expected = {1, 9999};
        Assertions.assertArrayEquals(expected, solution1317.getNoZeroIntegers(n));
    }

    @Test
    public void example4() {
        int n = 69;
        int[] expected = {1, 68};
        Assertions.assertArrayEquals(expected, solution1317.getNoZeroIntegers(n));
    }

    @Test
    public void example5() {
        int n = 1010;
        int[] expected = {11, 999};
        Assertions.assertArrayEquals(expected, solution1317.getNoZeroIntegers(n));
    }
}