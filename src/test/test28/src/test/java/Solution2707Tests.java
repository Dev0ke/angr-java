import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2707Tests {
    private final Solution2707 solution2707 = new Solution2707();

    @Test
    public void example1() {
        String s = "leetscode";
        String[] dictionary = {"leet", "code", "leetcode"};
        int expected = 1;
        Assertions.assertEquals(expected, solution2707.minExtraChar(s, dictionary));
    }

    @Test
    public void example2() {
        String s = "sayhelloworld";
        String[] dictionary = {"hello", "world"};
        int expected = 3;
        Assertions.assertEquals(expected, solution2707.minExtraChar(s, dictionary));
    }
}