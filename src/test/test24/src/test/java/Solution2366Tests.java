import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2366Tests {
    private final Solution2366 solution2366 = new Solution2366();

    @Test
    public void example1() {
        int[] nums = {3, 9, 3};
        long expected = 2;
        Assertions.assertEquals(expected, solution2366.minimumReplacement(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        long expected = 0;
        Assertions.assertEquals(expected, solution2366.minimumReplacement(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/346783067/
        // max 值减少
        int[] nums = {12, 9, 7, 6, 17, 19, 21};
        long expected = 6;
        Assertions.assertEquals(expected, solution2366.minimumReplacement(nums));
    }
}
