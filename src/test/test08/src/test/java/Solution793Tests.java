import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution793Tests {
    private final Solution793 solution793 = new Solution793();

    @Test
    public void example1() {
        int k = 0;
        int expected = 5;
        Assertions.assertEquals(expected, solution793.preimageSizeFZF(k));
    }

    @Test
    public void example2() {
        int k = 5;
        int expected = 0;
        Assertions.assertEquals(expected, solution793.preimageSizeFZF(k));
    }

    @Test
    public void example3() {
        int k = 3;
        int expected = 5;
        Assertions.assertEquals(expected, solution793.preimageSizeFZF(k));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/329770958/
        // 爆 int
        int k = 1000000000;
        int expected = 5;
        Assertions.assertEquals(expected, solution793.preimageSizeFZF(k));
    }
}
