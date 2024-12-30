import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1477Tests {
    private final Solution1477 solution1477 = new Solution1477();

    @Test
    public void example1() {
        int[] arr = {3, 2, 2, 4, 3};
        int target = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution1477.minSumOfLengths(arr, target));
    }

    @Test
    public void example2() {
        int[] arr = {7, 3, 4, 7};
        int target = 7;
        int expected = 2;
        Assertions.assertEquals(expected, solution1477.minSumOfLengths(arr, target));
    }

    @Test
    public void example3() {
        int[] arr = {4, 3, 2, 6, 2, 3, 4};
        int target = 6;
        int expected = -1;
        Assertions.assertEquals(expected, solution1477.minSumOfLengths(arr, target));
    }

    @Test
    public void example4() {
        int[] arr = {5, 5, 4, 4, 5};
        int target = 3;
        int expected = -1;
        Assertions.assertEquals(expected, solution1477.minSumOfLengths(arr, target));
    }

    @Test
    public void example5() {
        int[] arr = {3, 1, 1, 1, 5, 1, 2, 1};
        int target = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution1477.minSumOfLengths(arr, target));
    }
}