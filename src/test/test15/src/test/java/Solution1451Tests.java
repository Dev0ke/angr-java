import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1451Tests {
    private final Solution1451 solution1451 = new Solution1451();

    @Test
    public void example1() {
        String text = "Leetcode is cool";
        String expected = "Is cool leetcode";
        Assertions.assertEquals(expected, solution1451.arrangeWords(text));
    }

    @Test
    public void example2() {
        String text = "Keep calm and code on";
        String expected = "On and keep calm code";
        Assertions.assertEquals(expected, solution1451.arrangeWords(text));
    }

    @Test
    public void example3() {
        String text = "To be or not to be";
        String expected = "To be or to be not";
        Assertions.assertEquals(expected, solution1451.arrangeWords(text));
    }
}