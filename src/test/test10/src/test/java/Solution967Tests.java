import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution967Tests {
    private final Solution967 solution967 = new Solution967();

    @Test
    public void example1() {
        int n = 3;
        int k = 7;
        int[] actual = solution967.numsSameConsecDiff(n, k);
        int[] expected = {181, 292, 707, 818, 929};
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        int n = 2;
        int k = 1;
        int[] actual = solution967.numsSameConsecDiff(n, k);
        int[] expected = {10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98};
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example3() {
        int n = 2;
        int k = 0;
        int[] actual = solution967.numsSameConsecDiff(n, k);
        int[] expected = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example4() {
        int n = 2;
        int k = 2;
        int[] actual = solution967.numsSameConsecDiff(n, k);
        int[] expected = {13, 20, 24, 31, 35, 42, 46, 53, 57, 64, 68, 75, 79, 86, 97};
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, actual);
    }
}
