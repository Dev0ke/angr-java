import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1653Tests {
    private final Solution1653 solution1653 = new Solution1653();

    @Test
    public void example1() {
        String s = "aababbab";
        int expected = 2;
        Assertions.assertEquals(expected, solution1653.minimumDeletions(s));
    }

    @Test
    public void example2() {
        String s = "bbaaaaabb";
        int expected = 2;
        Assertions.assertEquals(expected, solution1653.minimumDeletions(s));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/409899665/
        // 全 b 情况
        String s = "b";
        int expected = 0;
        Assertions.assertEquals(expected, solution1653.minimumDeletions(s));
    }
}