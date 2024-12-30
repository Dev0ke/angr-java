import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution686Tests {
    private final Solution686 solution686 = new Solution686();

    @Test
    public void example1() {
        String a = "abcd";
        String b = "cdabcdab";
        int expected = 3;
        Assertions.assertEquals(expected, solution686.repeatedStringMatch(a, b));
    }

    @Test
    public void example2() {
        String a = "a";
        String b = "aa";
        int expected = 2;
        Assertions.assertEquals(expected, solution686.repeatedStringMatch(a, b));
    }

    @Test
    public void example3() {
        String a = "a";
        String b = "a";
        int expected = 1;
        Assertions.assertEquals(expected, solution686.repeatedStringMatch(a, b));
    }

    @Test
    public void example4() {
        String a = "abc";
        String b = "wxyz";
        int expected = -1;
        Assertions.assertEquals(expected, solution686.repeatedStringMatch(a, b));
    }

    // 补充用例
    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/363423995/
        // 56 / 58 个通过测试用例
        String a = "aaaaaaaaaaaaaaaaaaaaaab";
        String b = "ba";
        int expected = 2;
        Assertions.assertEquals(expected, solution686.repeatedStringMatch(a, b));
    }

    @Test
    public void example6() {
        // https://leetcode.cn/submissions/detail/363424230/
        // 57 / 58 个通过测试用例
        String a = "bb";
        String b = "bbbbbbb";
        int expected = 4;
        Assertions.assertEquals(expected, solution686.repeatedStringMatch(a, b));
    }
}