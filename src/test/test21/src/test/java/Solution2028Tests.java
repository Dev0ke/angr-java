import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution2028Tests {
    private final Solution2028 solution2028 = new Solution2028();

    @Test
    public void example1() {
        int[] rolls = {3, 2, 4, 3};
        int mean = 4;
        int n = 2;
        int[] expected = {6, 6};
        int[] actual = solution2028.missingRolls(rolls, mean, n);
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] rolls = {1, 5, 6};
        int mean = 3;
        int n = 4;
        int[] expected = {2, 3, 2, 2};
        int[] actual = solution2028.missingRolls(rolls, mean, n);
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example3() {
        int[] rolls = {1, 2, 3, 4};
        int mean = 6;
        int n = 4;
        int[] expected = {};
        int[] actual = solution2028.missingRolls(rolls, mean, n);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example4() {
        int[] rolls = {1};
        int mean = 3;
        int n = 1;
        int[] expected = {5};
        int[] actual = solution2028.missingRolls(rolls, mean, n);
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, actual);
    }

    // 补充用例
    @Test
    public void example5() {
        int[] rolls = {6, 3, 4, 3, 5, 3};
        int mean = 1;
        int n = 6;
        int[] expected = {};
        int[] actual = solution2028.missingRolls(rolls, mean, n);
        Assertions.assertArrayEquals(expected, actual);
    }
}
