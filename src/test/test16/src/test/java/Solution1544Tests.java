import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1544Tests {
    private final Solution1544 solution1544 = new Solution1544();

    @Test
    public void example1() {
        String s = "leEeetcode";
        String expected = "leetcode";
        Assertions.assertEquals(expected, solution1544.makeGood(s));
    }

    @Test
    public void example2() {
        String s = "abBAcC";
        String expected = "";
        Assertions.assertEquals(expected, solution1544.makeGood(s));
    }

    @Test
    public void example3() {
        String s = "s";
        String expected = "s";
        Assertions.assertEquals(expected, solution1544.makeGood(s));
    }
}