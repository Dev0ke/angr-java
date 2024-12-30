import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution1982Tests {
    private final Solution1982 solution1982 = new Solution1982();

    @Test
    public void example1() {
        int n = 3;
        int[] sums = {-3, -2, -1, 0, 0, 1, 2, 3};
//        int[] expected = {1, 2, -3};
        int[] expected = {-1, -2, 3};
        int[] actual = solution1982.recoverArray(n, sums);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        int n = 2;
        int[] sums = {0, 0, 0, 0};
        int[] expected = {0, 0};
        int[] actual = solution1982.recoverArray(n, sums);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example3() {
        int n = 4;
        int[] sums = {0, 0, 5, 5, 4, -1, 4, 9, 9, -1, 4, 3, 4, 8, 3, 8};
        int[] expected = {0, -1, 4, 5};
        int[] actual = solution1982.recoverArray(n, sums);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}