import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1078Tests {
    private final Solution1078 solution1078 = new Solution1078();

    @Test
    public void example1() {
        String text = "alice is a good girl she is a good student";
        String first = "a";
        String second = "good";
        String[] expected = {"girl", "student"};
        Assertions.assertArrayEquals(expected, solution1078.findOcurrences(text, first, second));
    }

    @Test
    public void example2() {
        String text = "we will we will rock you";
        String first = "we";
        String second = "will";
        String[] expected = {"we", "rock"};
        Assertions.assertArrayEquals(expected, solution1078.findOcurrences(text, first, second));
    }
}
