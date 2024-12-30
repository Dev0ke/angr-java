import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP358Tests {
    private final SolutionP358 solutionP358 = new SolutionP358();

    @Test
    public void example1() {
        String s = "aabbcc";
        int k = 3;
        String expected = "abcabc";
        Assertions.assertEquals(expected, solutionP358.rearrangeString(s, k));
    }

    @Test
    public void example2() {
        String s = "aaabc";
        int k = 3;
        String expected = "";
        Assertions.assertEquals(expected, solutionP358.rearrangeString(s, k));
    }

    @Test
    public void example3() {
        String s = "aaadbbcc";
        int k = 2;
        String expected = "abacabcd";
        Assertions.assertEquals(expected, solutionP358.rearrangeString(s, k));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/331009121/
        // s.length 不能整除 k
        String s = "abb";
        int k = 2;
        String expected = "bab";
        Assertions.assertEquals(expected, solutionP358.rearrangeString(s, k));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/331008659/
        // 特判 k = 0
        String s = "a";
        int k = 0;
        String expected = "a";
        Assertions.assertEquals(expected, solutionP358.rearrangeString(s, k));
    }
}
