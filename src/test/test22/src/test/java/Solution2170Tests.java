import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2170Tests {
    private final Solution2170 solution2170 = new Solution2170();

    @Test
    public void example1() {
        int[] nums = {3, 1, 3, 2, 4, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution2170.minimumOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 2, 2, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution2170.minimumOperations(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = {1};
        int expected = 0;
        Assertions.assertEquals(expected, solution2170.minimumOperations(nums));
    }

    @Test
    public void example4() {
        int[] nums = {2, 2, 2, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution2170.minimumOperations(nums));
    }
}
