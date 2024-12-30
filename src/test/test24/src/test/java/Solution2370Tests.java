import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2370Tests {
    private final Solution2370 solution2370 = new Solution2370();

    @Test
    public void example1() {
        String s = "acfgbd";
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution2370.longestIdealString(s, k));
    }

    @Test
    public void example2() {
        String s = "abcd";
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution2370.longestIdealString(s, k));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/346904473/
        String s = "eduktdb";
        int k = 15;
        int expected = 5;
        Assertions.assertEquals(expected, solution2370.longestIdealString(s, k));
    }
}