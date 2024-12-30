import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution720Tests {
    private final Solution720 solution720 = new Solution720();

    @Test
    public void example1() {
        String[] words = {"w", "wo", "wor", "worl", "world"};
        String expected = "world";
        Assertions.assertEquals(expected, solution720.longestWord(words));
    }

    @Test
    public void example2() {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String expected = "apple";
        Assertions.assertEquals(expected, solution720.longestWord(words));
    }
}
