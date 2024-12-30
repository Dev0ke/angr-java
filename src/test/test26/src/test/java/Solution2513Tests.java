import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2513Tests {
    private final Solution2513 solution2513 = new Solution2513();

    @Test
    public void example1() {
        int divisor1 = 2;
        int divisor2 = 7;
        int uniqueCnt1 = 1;
        int uniqueCnt2 = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution2513.minimizeSet(divisor1, divisor2, uniqueCnt1, uniqueCnt2));
    }

    @Test
    public void example2() {
        int divisor1 = 3;
        int divisor2 = 5;
        int uniqueCnt1 = 2;
        int uniqueCnt2 = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution2513.minimizeSet(divisor1, divisor2, uniqueCnt1, uniqueCnt2));
    }

    @Test
    public void example3() {
        int divisor1 = 2;
        int divisor2 = 4;
        int uniqueCnt1 = 8;
        int uniqueCnt2 = 2;
        int expected = 15;
        Assertions.assertEquals(expected, solution2513.minimizeSet(divisor1, divisor2, uniqueCnt1, uniqueCnt2));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/391185080/
        // 爆 int
        int divisor1 = 92761;
        int divisor2 = 48337;
        int uniqueCnt1 = 208563424;
        int uniqueCnt2 = 9115778;
        int expected = 217679202;
        Assertions.assertEquals(expected, solution2513.minimizeSet(divisor1, divisor2, uniqueCnt1, uniqueCnt2));
    }
}