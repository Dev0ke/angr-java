import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2246Tests {
    private final Solution2246 solution2246 = new Solution2246();

    @Test
    public void example1() {
        int[] parent = {-1, 0, 0, 1, 1, 2};
        String s = "abacbe";
        int expected = 3;
        Assertions.assertEquals(expected, solution2246.longestPath(parent, s));
    }

    @Test
    public void example2() {
        int[] parent = {-1, 0, 0, 0};
        String s = "aabc";
        int expected = 3;
        Assertions.assertEquals(expected, solution2246.longestPath(parent, s));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/301270943/
        int[] parent = UtUtils.loadingInts("solution2246-example3-input.txt", 0);
        String s = UtUtils.loadingString("solution2246-example3-input.txt", 1);
        int expected = 33;
        Assertions.assertEquals(expected, solution2246.longestPath(parent, s));
    }
}
