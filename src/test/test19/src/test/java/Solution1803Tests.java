import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1803Tests {
    private final Solution1803.V1 solution1803_v1 = new Solution1803.V1();
    private final Solution1803.V2 solution1803_v2 = new Solution1803.V2();

    @Test
    public void example1() {
        int[] nums = {1, 4, 2, 7};
        int low = 2;
        int high = 6;
        int expected = 6;
        Assertions.assertEquals(expected, solution1803_v1.countPairs(nums, low, high));
        Assertions.assertEquals(expected, solution1803_v2.countPairs(nums, low, high));
    }

    @Test
    public void example2() {
        int[] nums = {9, 8, 4, 2, 1};
        int low = 5;
        int high = 14;
        int expected = 8;
        Assertions.assertEquals(expected, solution1803_v1.countPairs(nums, low, high));
        Assertions.assertEquals(expected, solution1803_v2.countPairs(nums, low, high));
    }
}