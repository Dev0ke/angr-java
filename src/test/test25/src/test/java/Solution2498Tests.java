import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2498Tests {
    private final Solution2498 solution2498 = new Solution2498();

    @Test
    public void example1() {
        int[] stones = {0, 2, 5, 6, 7};
        int expected = 5;
        Assertions.assertEquals(expected, solution2498.maxJump(stones));
    }

    @Test
    public void example2() {
        int[] stones = {0, 3, 9};
        int expected = 9;
        Assertions.assertEquals(expected, solution2498.maxJump(stones));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/388340191/
        int[] stones = {0, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution2498.maxJump(stones));
    }
}
