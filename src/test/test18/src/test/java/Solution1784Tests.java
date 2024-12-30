import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1784Tests {
    private final Solution1784 solution1784 = new Solution1784();

    @Test
    public void example1() {
        String s = "1001";
        Assertions.assertFalse(solution1784.checkOnesSegment(s));
    }

    @Test
    public void example2() {
        String s = "110";
        Assertions.assertTrue(solution1784.checkOnesSegment(s));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/370685776/
        String s = "1";
        Assertions.assertTrue(solution1784.checkOnesSegment(s));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/370686004/
        String s = "10";
        Assertions.assertTrue(solution1784.checkOnesSegment(s));
    }
}
