import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2255Tests {
    private final Solution2255 solution2255 = new Solution2255();

    @Test
    public void example1() {
        String[] words = {"a", "b", "c", "ab", "bc", "abc"};
        String s = "abc";
        int expected = 3;
        Assertions.assertEquals(expected, solution2255.countPrefixes(words, s));
    }

    @Test
    public void example2() {
        String[] words = {"a", "a"};
        String s = "aa";
        int expected = 2;
        Assertions.assertEquals(expected, solution2255.countPrefixes(words, s));
    }
}
