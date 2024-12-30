import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution35Tests {
    private final Solution35 solution35 = new Solution35();

    @Test
    public void example1() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution35.searchInsert(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution35.searchInsert(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        int expected = 4;
        Assertions.assertEquals(expected, solution35.searchInsert(nums, target));
    }

    @Test
    public void example4() {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution35.searchInsert(nums, target));
    }

    @Test
    public void example5() {
        int[] nums = {1};
        int target = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution35.searchInsert(nums, target));
    }
}
