import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1283Tests {
    private final Solution1283 solution1283 = new Solution1283();

    @Test
    public void example1() {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        int expected = 5;
        Assertions.assertEquals(expected, solution1283.smallestDivisor(nums, threshold));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 5, 7, 11};
        int threshold = 11;
        int expected = 3;
        Assertions.assertEquals(expected, solution1283.smallestDivisor(nums, threshold));
    }

    @Test
    public void example3() {
        int[] nums = {19};
        int threshold = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solution1283.smallestDivisor(nums, threshold));
    }
}
