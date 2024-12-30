import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1935Tests {
    private final Solution1935 solution1935 = new Solution1935();

    @Test
    public void example1() {
        String text = "hello world";
        String brokenLetters = "ad";
        int expected = 1;
        Assertions.assertEquals(expected, solution1935.canBeTypedWords(text, brokenLetters));
    }

    @Test
    public void example2() {
        String text = "leet code";
        String brokenLetters = "lt";
        int expected = 1;
        Assertions.assertEquals(expected, solution1935.canBeTypedWords(text, brokenLetters));
    }

    @Test
    public void example3() {
        String text = "leet code";
        String brokenLetters = "e";
        int expected = 0;
        Assertions.assertEquals(expected, solution1935.canBeTypedWords(text, brokenLetters));
    }
}
