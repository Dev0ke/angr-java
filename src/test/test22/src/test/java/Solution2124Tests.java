import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2124Tests {
    private final Solution2124 solution2124 = new Solution2124();

    @Test
    public void example1() {
        String s = "aaabbb";
        Assertions.assertTrue(solution2124.checkString(s));
    }

    @Test
    public void example2() {
        String s = "abab";
        Assertions.assertFalse(solution2124.checkString(s));
    }

    @Test
    public void example3() {
        String s = "bbb";
        Assertions.assertTrue(solution2124.checkString(s));
    }

    // 补充用例
    @Test
    public void example4() {
        String s = "a";
        Assertions.assertTrue(solution2124.checkString(s));
    }
}
