import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3291Tests {
    private final Solution3291 solution3291 = new Solution3291();

    @Test
    public void example1() {
        String[] words = {"abc", "aaaaa", "bcdef"};
        String target = "aabcdabc";
        int expected = 3;
        Assertions.assertEquals(expected, solution3291.minValidStrings(words, target));
    }

    @Test
    public void example2() {
        String[] words = {"abababab", "ab"};
        String target = "ababaababa";
        int expected = 2;
        Assertions.assertEquals(expected, solution3291.minValidStrings(words, target));
    }

    @Test
    public void example3() {
        String[] words = {"abcdef"};
        String target = "xyz";
        int expected = -1;
        Assertions.assertEquals(expected, solution3291.minValidStrings(words, target));
    }
}