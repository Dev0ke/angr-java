import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution33Tests {
    private final Solution33 solution33 = new Solution33();

    @Test
    public void example1() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int expected = 4;
        Assertions.assertEquals(expected, solution33.search(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        int expected = -1;
        Assertions.assertEquals(expected, solution33.search(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {1};
        int target = 0;
        int expected = -1;
        Assertions.assertEquals(expected, solution33.search(nums, target));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] nums = {1, 3};
        int target = 0;
        int expected = -1;
        Assertions.assertEquals(expected, solution33.search(nums, target));
    }
}
