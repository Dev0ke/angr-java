import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2202Tests {
    private final Solution2202 solution2202 = new Solution2202();

    @Test
    public void example1() {
        int[] nums = {5, 2, 2, 4, 0, 6};
        int k = 4;
        int expected = 5;
        Assertions.assertEquals(expected, solution2202.maximumTop(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2};
        int k = 1;
        int expected = -1;
        Assertions.assertEquals(expected, solution2202.maximumTop(nums, k));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = {1, 2, 1000000000};
        int k = 2;
        int expected = 1000000000;
        Assertions.assertEquals(expected, solution2202.maximumTop(nums, k));
    }

    @Test
    public void example4() {
        int[] nums = {3,2,1};
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution2202.maximumTop(nums, k));
    }
}
