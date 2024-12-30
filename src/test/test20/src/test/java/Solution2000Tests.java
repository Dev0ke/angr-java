import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2000Tests {
    private final Solution2000 solution2000 = new Solution2000();

    @Test
    public void example1() {
        String word = "abcdefd";
        char ch = 'd';
        String expected = "dcbaefd";
        Assertions.assertEquals(expected, solution2000.reversePrefix(word, ch));
    }

    @Test
    public void example2() {
        String word = "xyxzxe";
        char ch = 'z';
        String expected = "zxyxxe";
        Assertions.assertEquals(expected, solution2000.reversePrefix(word, ch));
    }

    @Test
    public void example3() {
        String word = "abcd";
        char ch = 'z';
        String expected = "abcd";
        Assertions.assertEquals(expected, solution2000.reversePrefix(word, ch));
    }
}
