import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3333Tests {
    private final Solution3333 solution3333 = new Solution3333();

    @Test
    public void example1() {
        String word = "aabbccdd";
        int k = 7;
        int expected = 5;
        Assertions.assertEquals(expected, solution3333.possibleStringCount(word, k));
    }

    @Test
    public void example2() {
        String word = "aabbccdd";
        int k = 8;
        int expected = 1;
        Assertions.assertEquals(expected, solution3333.possibleStringCount(word, k));
    }

    @Test
    public void example3() {
        String word = "aaabbb";
        int k = 3;
        int expected = 8;
        Assertions.assertEquals(expected, solution3333.possibleStringCount(word, k));
    }
}