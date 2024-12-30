import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2042Tests {
    private final Solution2042 solution2042 = new Solution2042();

    @Test
    public void example1() {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        Assertions.assertTrue(solution2042.areNumbersAscending(s));
    }

    @Test
    public void example2() {
        String s = "hello world 5 x 5";
        Assertions.assertFalse(solution2042.areNumbersAscending(s));
    }

    @Test
    public void example3() {
        String s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
        Assertions.assertFalse(solution2042.areNumbersAscending(s));
    }

    @Test
    public void example4() {
        String s = "4 5 11 26";
        Assertions.assertTrue(solution2042.areNumbersAscending(s));
    }
}
