import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution260Tests {
    private final Solution260 solution260 = new Solution260();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] expected = {3, 5};
        int[] actual = solution260.singleNumber(nums);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example1_2() {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] expected = {3, 5};
        int[] actual = solution260.singleNumber2(nums);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {-1, 0};
        int[] expected = {-1, 0};
        int[] actual = solution260.singleNumber(nums);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2_2() {
        int[] nums = {-1, 0};
        int[] expected = {-1, 0};
        int[] actual = solution260.singleNumber2(nums);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example3() {
        int[] nums = {0, 1};
        int[] expected = {1, 0};
        int[] actual = solution260.singleNumber(nums);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example3_2() {
        int[] nums = {0, 1};
        int[] expected = {1, 0};
        int[] actual = solution260.singleNumber2(nums);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}
