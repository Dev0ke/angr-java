import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1422Tests {
    private final Solution1422 solution1422 = new Solution1422();

    @Test
    public void example1() {
        String s = "011101";
        int expected = 5;
        Assertions.assertEquals(expected, solution1422.maxScore(s));
    }

    @Test
    public void example2() {
        String s = "00111";
        int expected = 5;
        Assertions.assertEquals(expected, solution1422.maxScore(s));
    }

    @Test
    public void example3() {
        String s = "1111";
        int expected = 3;
        Assertions.assertEquals(expected, solution1422.maxScore(s));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/350062221/
        // 边界条件
        String s = "00";
        int expected = 1;
        Assertions.assertEquals(expected, solution1422.maxScore(s));
    }
}
