import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2800Tests {
    private final Solution2800 solution2800 = new Solution2800();

    @Test
    public void example1() {
        String a = "abc";
        String b = "bca";
        String c = "aaa";
        String expected = "aaabca";
        Assertions.assertEquals(expected, solution2800.minimumString(a, b, c));
    }

    @Test
    public void example2() {
        String a = "ab";
        String b = "ba";
        String c = "aba";
        String expected = "aba";
        Assertions.assertEquals(expected, solution2800.minimumString(a, b, c));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/451628990/
        // 包含情况
        String a = "cab";
        String b = "a";
        String c = "b";
        String expected = "cab";
        Assertions.assertEquals(expected, solution2800.minimumString(a, b, c));
    }
}