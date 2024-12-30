import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1816Tests {
    private final Solution1816 solution1816 = new Solution1816();

    @Test
    public void example1() {
        String s = "Hello how are you Contestant";
        int k = 4;
        String expected = "Hello how are you";
        Assertions.assertEquals(expected, solution1816.truncateSentence(s, k));
    }

    @Test
    public void example2() {
        String s = "What is the solution to this problem";
        int k = 4;
        String expected = "What is the solution";
        Assertions.assertEquals(expected, solution1816.truncateSentence(s, k));
    }

    @Test
    public void example3() {
        String s = "chopper is not a tanuki";
        int k = 5;
        String expected = "chopper is not a tanuki";
        Assertions.assertEquals(expected, solution1816.truncateSentence(s, k));
    }
}

