import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2185Tests {
    private final Solution2185 solution2185 = new Solution2185();

    @Test
    public void example1() {
        String[] words = {"pay", "attention", "practice", "attend"};
        String pref = "at";
        int expected = 2;
        Assertions.assertEquals(expected, solution2185.prefixCount(words, pref));
    }

    @Test
    public void example2() {
        String[] words = {"leetcode", "win", "loops", "success"};
        String pref = "code";
        int expected = 0;
        Assertions.assertEquals(expected, solution2185.prefixCount(words, pref));
    }
}
