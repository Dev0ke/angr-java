import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3330Tests {
    private final Solution3330 solution3330 = new Solution3330();

    @Test
    public void example1() {
        String word = "abbcccc";
        int expected = 5;
        Assertions.assertEquals(expected, solution3330.possibleStringCount(word));
    }

    @Test
    public void example2() {
        String word = "abcd";
        int expected = 1;
        Assertions.assertEquals(expected, solution3330.possibleStringCount(word));
    }

    @Test
    public void example3() {
        String word = "aaaa";
        int expected = 4;
        Assertions.assertEquals(expected, solution3330.possibleStringCount(word));
    }
}