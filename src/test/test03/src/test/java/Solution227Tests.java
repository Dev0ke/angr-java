import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution227Tests {
    private final Solution227 solution227 = new Solution227();

    @Test
    public void example1() {
        String s = "3+2*2";
        int expected = 7;
        Assertions.assertEquals(expected, solution227.calculate(s));
    }

    @Test
    public void example2() {
        String s = " 3/2 ";
        int expected = 1;
        Assertions.assertEquals(expected, solution227.calculate(s));
    }

    @Test
    public void example3() {
        String s = " 3+5 / 2 ";
        int expected = 5;
        Assertions.assertEquals(expected, solution227.calculate(s));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/333522898/
        String s = "3+2*2";
        int expected = 7;
        Assertions.assertEquals(expected, solution227.calculate(s));
    }
}
