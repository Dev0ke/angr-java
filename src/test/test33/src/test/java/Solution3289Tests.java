import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution3289Tests {
    private final Solution3289 solution3289 = new Solution3289();

    @Test
    public void example1() {
        int[] nums = {0, 1, 1, 0};
        int[] expected = {0, 1};
        int[] actual = solution3289.getSneakyNumbers(nums);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {0, 3, 2, 1, 3, 2};
        int[] expected = {2, 3};
        int[] actual = solution3289.getSneakyNumbers(nums);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example3() {
        int[] nums = {7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2};
        int[] expected = {4, 5};
        int[] actual = solution3289.getSneakyNumbers(nums);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}