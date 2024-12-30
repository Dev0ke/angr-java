import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1400Tests {
    private final Solution1400 solution1400 = new Solution1400();

    @Test
    public void example1() {
        String s = "annabelle";
        int k = 2;
        Assertions.assertTrue(solution1400.canConstruct(s, k));
    }

    @Test
    public void example2() {
        String s = "leetcode";
        int k = 3;
        Assertions.assertFalse(solution1400.canConstruct(s, k));
    }

    @Test
    public void example3() {
        String s = "true";
        int k = 4;
        Assertions.assertTrue(solution1400.canConstruct(s, k));
    }

    @Test
    public void example4() {
        String s = "yzyzyzyzyzyzyzy";
        int k = 2;
        Assertions.assertTrue(solution1400.canConstruct(s, k));
    }

    @Test
    public void example5() {
        String s = "cr";
        int k = 7;
        Assertions.assertFalse(solution1400.canConstruct(s, k));
    }
}
