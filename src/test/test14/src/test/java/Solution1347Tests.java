import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1347Tests {
    private final Solution1347 solution1347 = new Solution1347();

    @Test
    public void example1() {
        String s = "bab";
        String t = "aba";
        int expected = 1;
        Assertions.assertEquals(expected, solution1347.minSteps(s, t));
    }

    @Test
    public void example2() {
        String s = "leetcode";
        String t = "practice";
        int expected = 5;
        Assertions.assertEquals(expected, solution1347.minSteps(s, t));
    }

    @Test
    public void example3() {
        String s = "anagram";
        String t = "mangaar";
        int expected = 0;
        Assertions.assertEquals(expected, solution1347.minSteps(s, t));
    }

    @Test
    public void example4() {
        String s = "xxyyzz";
        String t = "xxyyzz";
        int expected = 0;
        Assertions.assertEquals(expected, solution1347.minSteps(s, t));
    }

    @Test
    public void example5() {
        String s = "friend";
        String t = "family";
        int expected = 4;
        Assertions.assertEquals(expected, solution1347.minSteps(s, t));
    }
}