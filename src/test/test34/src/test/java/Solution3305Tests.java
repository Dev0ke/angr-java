import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3305Tests {
    private final Solution3305 solution3305 = new Solution3305();

    @Test
    public void example1() {
        String word = "aeioqq";
        int k = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution3305.countOfSubstrings(word, k));
    }

    @Test
    public void example2() {
        String word = "aeiou";
        int k = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solution3305.countOfSubstrings(word, k));
    }

    @Test
    public void example3() {
        String word = "ieaouqqieaouqq";
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution3305.countOfSubstrings(word, k));
    }
}