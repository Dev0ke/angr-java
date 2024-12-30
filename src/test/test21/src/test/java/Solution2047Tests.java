import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2047Tests {
    private final Solution2047 solution2047 = new Solution2047();

    @Test
    public void example1() {
        String sentence = "cat and  dog";
        int expected = 3;
        Assertions.assertEquals(expected, solution2047.countValidWords(sentence));
    }

    @Test
    public void example2() {
        String sentence = "!this  1-s b8d!";
        int expected = 0;
        Assertions.assertEquals(expected, solution2047.countValidWords(sentence));
    }

    @Test
    public void example3() {
        String sentence = "alice and  bob are playing stone-game10";
        int expected = 5;
        Assertions.assertEquals(expected, solution2047.countValidWords(sentence));
    }

    @Test
    public void example4() {
        String sentence = "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.";
        int expected = 6;
        Assertions.assertEquals(expected, solution2047.countValidWords(sentence));
    }
}
