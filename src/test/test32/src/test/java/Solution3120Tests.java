import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3120Tests {
    private final Solution3120 solution3120 = new Solution3120();

    @Test
    public void example1() {
        String word = "aaAbcBC";
        int expected = 3;
        Assertions.assertEquals(expected, solution3120.numberOfSpecialChars(word));
    }

    @Test
    public void example2() {
        String word = "abc";
        int expected = 0;
        Assertions.assertEquals(expected, solution3120.numberOfSpecialChars(word));
    }

    @Test
    public void example3() {
        String word = "abBCab";
        int expected = 1;
        Assertions.assertEquals(expected, solution3120.numberOfSpecialChars(word));
    }
}