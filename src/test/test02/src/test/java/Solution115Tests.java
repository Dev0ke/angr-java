import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution115Tests {
    private final Solution115 solution115 = new Solution115();

    @Test
    public void example1() {
        String s = "rabbbit";
        String t = "rabbit";
        int expected = 3;
        Assertions.assertEquals(expected, solution115.numDistinct(s, t));
    }

    @Test
    public void example2() {
        String s = "babgbag";
        String t = "bag";
        int expected = 5;
        Assertions.assertEquals(expected, solution115.numDistinct(s, t));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/distinct-subsequences/submissions/461787470/
        // https://github.com/LeetCode-Feedback/LeetCode-Feedback/issues?q=is%3Aissue+115.+Distinct+Subsequences+is%3Aopen
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String t = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        int expected = 654905827;
        Assertions.assertEquals(expected, solution115.numDistinct(s, t));
    }
}