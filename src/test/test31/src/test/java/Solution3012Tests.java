import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3012Tests {
    private final Solution3012 solution3012 = new Solution3012();

    @Test
    public void example1() {
        int[] nums = {1, 4, 3, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution3012.minimumArrayLength(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 5, 5, 10, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution3012.minimumArrayLength(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 3, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution3012.minimumArrayLength(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/minimize-length-of-array-using-operations/submissions/497053004/
        int[] nums = {5, 2, 2, 2, 9, 10};
        int expected = 1;
        Assertions.assertEquals(expected, solution3012.minimumArrayLength(nums));
    }
}