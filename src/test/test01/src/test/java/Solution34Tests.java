import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution34Tests {
    private final Solution34 solution34 = new Solution34();

    @Test
    public void example1() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] expected = {3, 4};
        Assertions.assertArrayEquals(expected, solution34.searchRange(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution34.searchRange(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {};
        int target = 0;
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution34.searchRange(nums, target));
    }
}
