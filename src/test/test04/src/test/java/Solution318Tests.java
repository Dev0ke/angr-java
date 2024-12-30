import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution318Tests {
    private final Solution318 solution318 = new Solution318();

    @Test
    public void example1() {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        int expected = 16;
        Assertions.assertEquals(expected, solution318.maxProduct(words));
    }

    @Test
    public void example2() {
        String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        int expected = 4;
        Assertions.assertEquals(expected, solution318.maxProduct(words));
    }

    @Test
    public void example3() {
        String[] words = {"a", "aa", "aaa", "aaaa"};
        int expected = 0;
        Assertions.assertEquals(expected, solution318.maxProduct(words));
    }
}
