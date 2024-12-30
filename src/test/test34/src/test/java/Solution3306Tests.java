import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3306Tests {
    private final Solution3306 solution3306 = new Solution3306();

    @Test
    public void example1() {
        String word = "aeioqq";
        int k = 1;
        long expected = 0;
        Assertions.assertEquals(expected, solution3306.countOfSubstrings(word, k));
    }

    @Test
    public void example2() {
        String word = "aeiou";
        int k = 0;
        long expected = 1;
        Assertions.assertEquals(expected, solution3306.countOfSubstrings(word, k));
    }

    @Test
    public void example3() {
        String word = "ieaouqqieaouqq";
        int k = 1;
        long expected = 3;
        Assertions.assertEquals(expected, solution3306.countOfSubstrings(word, k));
    }
}