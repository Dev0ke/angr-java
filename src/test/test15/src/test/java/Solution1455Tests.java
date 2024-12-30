import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1455Tests {
    private final Solution1455 solution1455 = new Solution1455();

    @Test
    public void example1() {
        String sentence = "i love eating burger";
        String searchWord = "burg";
        int expected = 4;
        Assertions.assertEquals(expected, solution1455.isPrefixOfWord(sentence, searchWord));
    }

    @Test
    public void example2() {
        String sentence = "this problem is an easy problem";
        String searchWord = "pro";
        int expected = 2;
        Assertions.assertEquals(expected, solution1455.isPrefixOfWord(sentence, searchWord));
    }

    @Test
    public void example3() {
        String sentence = "i am tired";
        String searchWord = "you";
        int expected = -1;
        Assertions.assertEquals(expected, solution1455.isPrefixOfWord(sentence, searchWord));
    }
}
