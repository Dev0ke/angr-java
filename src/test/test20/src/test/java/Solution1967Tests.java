import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1967Tests {
    private final Solution1967 solution1967 = new Solution1967();

    @Test
    public void example1() {
        String[] patterns = {"a", "abc", "bc", "d"};
        String word = "abc";
        int expected = 3;
        Assertions.assertEquals(expected, solution1967.numOfStrings(patterns, word));
    }

    @Test
    public void example2() {
        String[] patterns = {"a", "b", "c"};
        String word = "aaaaabbbbb";
        int expected = 2;
        Assertions.assertEquals(expected, solution1967.numOfStrings(patterns, word));
    }

    @Test
    public void example3() {
        String[] patterns = {"a", "a", "a"};
        String word = "ab";
        int expected = 3;
        Assertions.assertEquals(expected, solution1967.numOfStrings(patterns, word));
    }
}
