import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution290Tests {
    private final Solution290 solution290 = new Solution290();

    @Test
    public void example1() {
        String pattern = "abba";
        String s = "dog cat cat dog";
        Assertions.assertTrue(solution290.wordPattern(pattern, s));
    }

    @Test
    public void example2() {
        String pattern = "abba";
        String s = "dog cat cat fish";
        Assertions.assertFalse(solution290.wordPattern(pattern, s));
    }

    @Test
    public void example3() {
        String pattern = "aaaa";
        String s = "dog cat cat dog";
        Assertions.assertFalse(solution290.wordPattern(pattern, s));
    }

    @Test
    public void example4() {
        String pattern = "abba";
        String s = "dog dog dog dog";
        Assertions.assertFalse(solution290.wordPattern(pattern, s));
    }
}
